// Last Update: 2021-10-14T21:00:00+00:00
package com.parkingapp;

import services.FirebaseInitialization;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.SetOptions;

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
 * PaymentPage - Displays the amount due and allows the user
 * to pay instantly by comparing the amountDue vs. their Firestore balance.
 * If insufficient, it shows an error.
 */
public class PaymentPage extends JDialog {

    public interface PaymentCallback {
        void onPaymentComplete(boolean wasPaid);
    }

    private final String userEmail;
    private final UserLogin.UserType userType;
    private final long durationInMinutes;
    private final double amountDue;   // Calculated using PaymentRates
    private final PaymentCallback callback;

    // Firestore instance from FirebaseInitialization
    private final Firestore db;

    /**
     * Constructs a modal dialog for payment.
     * 
     * @param parent            The parent frame (BookingPage)
     * @param userEmail         The user’s email
     * @param userType          The user’s type (STUDENT, FACULTY, etc.)
     * @param durationInMinutes Duration of the booking (minutes)
     * @param callback          Notified when payment completes or fails
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

        // Compute cost using PaymentRates
        this.amountDue = PaymentRates.calculateCost(userType, durationInMinutes);

        // Acquire Firestore from your singleton
        db = FirebaseInitialization.getInstance();

        initializeUI();
    }

    /**
     * Builds a simple UI with:
     * - A label "Amount Due"
     * - A "Pay Now" button
     * - A "Cancel" button
     */
    private void initializeUI() {
        setLayout(new BorderLayout(10, 10));
        setSize(300, 150);
        setLocationRelativeTo(getParent());

        // Center label for amount
        JLabel amountLabel = new JLabel("Amount Due: $" + String.format("%.2f", amountDue), JLabel.CENTER);
        amountLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(amountLabel, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        JButton payButton = new JButton("Pay Now");
        JButton cancelButton = new JButton("Cancel");

        buttonPanel.add(payButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Pay button: attempt payment instantly
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processPayment();
            }
        });

        // Cancel button: closes dialog
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
     * Immediately checks the user's Firestore balance:
     * - If sufficient, deduct the amountDue, update Firestore, show success.
     * - If not, show "Insufficient funds" error.
     * - If parent is BookingPage, call loadUserBalance() to refresh UI.
     */
    private void processPayment() {
        SwingWorker<Double, Void> worker = new SwingWorker<>() {
            @Override
            protected Double doInBackground() throws Exception {
                // 1) Get the user's UID from Preferences
                Preferences prefs = Preferences.userNodeForPackage(UserLogin.class);
                String uid = prefs.get("user_uid", null);
                if (uid == null) {
                    throw new Exception("User not logged in.");
                }

                // 2) Fetch current balance from Firestore
                DocumentReference userRef = db.collection("users").document(uid);
                DocumentSnapshot docSnap = userRef.get().get();
                double currentBalance = 0.0;
                if (docSnap.exists() && docSnap.contains("balance")) {
                    currentBalance = docSnap.getDouble("balance");
                }

                // 3) Check if user has enough funds
                double newBalance = currentBalance - amountDue;
                if (newBalance < 0) {
                    throw new Exception("Insufficient funds. Please load funds, Current balance: $"
                            + String.format("%.2f", currentBalance));
                }

                // 4) Update Firestore with the new balance
                Map<String, Object> data = new HashMap<>();
                data.put("balance", newBalance);
                userRef.set(data, SetOptions.merge()).get();

                return newBalance;
            }

            @Override
            protected void done() {
                try {
                    double newBalance = get();  // If no exception, payment succeeded

                    // Refresh BookingPage's balance if the parent is BookingPage
                    getParent();

                    // Notify callback that payment was successful
                    if (callback != null) {
                        callback.onPaymentComplete(true);
                    }

                    // Show success message
                    JOptionPane.showMessageDialog(
                            PaymentPage.this,
                            "Payment of $" + String.format("%.2f", amountDue)
                                    + " succeeded.\nNew Balance: $"
                                    + String.format("%.2f", newBalance),
                            "Payment Successful",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    dispose();

                } catch (InterruptedException | ExecutionException ex) {
                    // Firestore future exceptions
                    Throwable cause = ex.getCause() != null ? ex.getCause() : ex;
                    JOptionPane.showMessageDialog(
                            PaymentPage.this,
                            "Payment failed: " + cause.getMessage(),
                            "Payment Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                } catch (Exception ex) {
                    // Any other exceptions
                    JOptionPane.showMessageDialog(
                            PaymentPage.this,
                            "Payment failed: " + ex.getMessage(),
                            "Payment Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        };
        worker.execute();
    }
}
