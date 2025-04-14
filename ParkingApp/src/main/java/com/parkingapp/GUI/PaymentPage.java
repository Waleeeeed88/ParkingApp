package com.parkingapp.GUI;

import services.FirebaseInitialization;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.SetOptions;
import com.parkingapp.PaymentRates;
import com.parkingapp.UserLogin;

import javax.swing.*;
import javax.swing.SwingWorker;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;
import java.util.concurrent.ExecutionException;

/**
 * PaymentPage - A modern, engaging payment dialog that displays the amount due and allows
 * the user to pay instantly. It visually indicates processing with a progress bar and shows
 * friendly messages upon success or error.
 */
public class PaymentPage extends JDialog {

    public interface PaymentCallback {
        void onPaymentComplete(boolean wasPaid);
    }

    private final String userEmail;
    private final UserLogin.UserType userType;
    private final long durationInMinutes;
    private final double amountDue;   // Calculated cost using PaymentRates
    private final PaymentCallback callback;

    // Firestore instance from FirebaseInitialization
    private final Firestore db = FirebaseInitialization.getInstance();

    // UI Components
    private JProgressBar progressBar;

    /**
     * Constructs a modal PaymentPage dialog.
     *
     * @param parent            Parent frame
     * @param userEmail         The user’s email
     * @param userType          The user’s type (e.g., STUDENT, FACULTY)
     * @param durationInMinutes Duration of the booking (in minutes)
     * @param callback          Called when the payment either completes or fails
     */
    public PaymentPage(Frame parent,
                       String userEmail,
                       UserLogin.UserType userType,
                       long durationInMinutes,
                       PaymentCallback callback) {
        super(parent, "Payment Required", true);
        this.userEmail = userEmail;
        this.userType = userType;
        this.durationInMinutes = durationInMinutes;
        this.callback = callback;

        // Compute the amount due using PaymentRates
        this.amountDue = PaymentRates.calculateCost(userType, durationInMinutes);

        // Apply Nimbus Look & Feel for a modern style, if available
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
                if ("Nimbus".equals(info.getName())){
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch(Exception e){
            System.err.println("Nimbus Look & Feel not available, defaulting to system L&F.");
        }

        initializeUI();
    }

    /**
     * Initializes the UI components with modern styling.
     */
    private void initializeUI() {
        setLayout(new BorderLayout());
        setSize(350, 220);
        setLocationRelativeTo(getParent());

        // Create and add a custom gradient header panel
        GradientHeaderPanel header = new GradientHeaderPanel("Make Payment");
        add(header, BorderLayout.NORTH);

        // Center panel to display the amount due and progress indicator
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel amountLabel = new JLabel("Amount Due: $" + String.format("%.2f", amountDue), JLabel.CENTER);
        amountLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        centerPanel.add(amountLabel, BorderLayout.CENTER);

        // Progress bar to indicate processing during payment
        progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        progressBar.setVisible(false);
        centerPanel.add(progressBar, BorderLayout.SOUTH);

        add(centerPanel, BorderLayout.CENTER);

        // Button panel for actions
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        JButton payButton = new JButton("Pay Now");
        payButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        payButton.setToolTipText("Click to make payment instantly");
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        buttonPanel.add(payButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Action to process payment when "Pay Now" is clicked
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processPayment();
            }
        });

        // Cancel button closes the dialog and notifies the callback if needed
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (callback != null) {
                    callback.onPaymentComplete(false);
                }
                dispose();
            }
        });
    }

    /**
     * Custom panel for a gradient header.
     */
    class GradientHeaderPanel extends JPanel {
        private final String title;

        public GradientHeaderPanel(String title) {
            this.title = title;
            setPreferredSize(new Dimension(getWidth(), 50));
            setLayout(new BorderLayout());
            JLabel titleLabel = new JLabel(title);
            titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
            titleLabel.setForeground(Color.WHITE);
            titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
            add(titleLabel, BorderLayout.CENTER);
        }

        @Override
        protected void paintComponent(Graphics g) {
            // Create a smooth gradient background
            Graphics2D g2 = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();
            Color color1 = new Color(72, 61, 139);   // Dark Slate Blue
            Color color2 = new Color(123, 104, 238); // Medium Slate Blue
            GradientPaint gp = new GradientPaint(0, 0, color1, width, height, color2);
            g2.setPaint(gp);
            g2.fillRect(0, 0, width, height);
            super.paintComponent(g);
        }
    }

    /**
     * Processes the payment by checking the user balance, deducting the amount, and updating Firestore.
     * Shows a progress indicator during processing.
     */
    private void processPayment() {
        // Show the progress bar and change the cursor to a waiting cursor
        progressBar.setVisible(true);
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        SwingWorker<Double, Void> worker = new SwingWorker<>() {
            @Override
            protected Double doInBackground() throws Exception {
                // Retrieve the user's UID from preferences
                Preferences prefs = Preferences.userNodeForPackage(UserLogin.class);
                String uid = prefs.get("user_uid", null);
                if (uid == null) {
                    throw new Exception("User not logged in.");
                }

                // Fetch current balance from Firestore
                DocumentReference userRef = db.collection("users").document(uid);
                DocumentSnapshot docSnap = userRef.get().get();
                double currentBalance = 0.0;
                if (docSnap.exists() && docSnap.contains("balance")) {
                    Double balance = docSnap.getDouble("balance");
                    currentBalance = (balance != null) ? balance : 0.0;
                }

                // Deduct the amount due and check for sufficient funds
                double newBalance = currentBalance - amountDue;
                if (newBalance < 0) {
                    throw new Exception("Insufficient funds. Please load funds. Current balance: $" +
                            String.format("%.2f", currentBalance));
                }

                // Update Firestore with the new balance
                Map<String, Object> data = new HashMap<>();
                data.put("balance", newBalance);
                userRef.set(data, SetOptions.merge()).get();
                return newBalance;
            }

            @Override
            protected void done() {
                try {
                    double newBalance = get();
                    // Notify the callback on successful payment
                    if (callback != null) {
                        callback.onPaymentComplete(true);
                    }
                    // Show a friendly success message with HTML formatting for clarity
                    JOptionPane.showMessageDialog(
                            PaymentPage.this,
                            "<html><div style='text-align: center;'>Payment of $" + String.format("%.2f", amountDue) +
                                    " succeeded.<br>New Balance: $" + String.format("%.2f", newBalance) + "</div></html>",
                            "Payment Successful",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    dispose();
                } catch (InterruptedException | ExecutionException ex) {
                    Throwable cause = ex.getCause() != null ? ex.getCause() : ex;
                    JOptionPane.showMessageDialog(
                            PaymentPage.this,
                            "Payment failed: " + cause.getMessage(),
                            "Payment Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                } finally {
                    // Hide progress indicator and reset cursor
                    progressBar.setVisible(false);
                    setCursor(Cursor.getDefaultCursor());
                }
            }
        };
        worker.execute();
    }
}
