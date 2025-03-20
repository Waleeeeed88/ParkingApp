////package com.parkingapp;
////
////import javax.swing.*;
////import java.awt.*;
////import java.awt.event.ActionEvent;
////import java.awt.event.ActionListener;
////
/////**
//// * A simple popup dialog that shows a dynamically calculated amount
//// * (based on PaymentRates) and two buttons:
//// *  - "Pay Now" confirms payment (wasPaid = true)
//// *  - "Cancel" closes without payment (wasPaid = false)
//// *
//// * The caller should pass in a PaymentCallback so it can know if the user
//// * completed the payment successfully (wasPaid = true) or canceled (wasPaid = false).
//// */
////public class PaymentPage extends JDialog {
////
////    /**
////     * A functional interface to receive a boolean indicating
////     * if the user actually paid (true) or canceled (false).
////     */
////    public interface PaymentCallback {
////        /**
////         * Called when the user finishes the payment process.
////         *
////         * @param wasPaid true if the user paid successfully, false otherwise
////         */
////        void onPaymentComplete(boolean wasPaid);
////    }
////
////    private final String userEmail;
////    private final UserLogin.UserType userType;
////    private final long durationInMinutes;
////    private final double amountDue;        // Calculated using PaymentRates
////    private final PaymentCallback callback;
////
////    /**
////     * Constructs a modal dialog for payment.
////     *
////     * @param parent            a parent frame (so the dialog is centered relative to it)
////     * @param userEmail         the user’s email (if you need it for logging or display)
////     * @param userType          the user’s type (STUDENT, FACULTY, etc.)
////     * @param durationInMinutes how long the user is booking (in minutes)
////     * @param callback          a callback to notify the caller if payment was successful or canceled
////     */
////    public PaymentPage(Frame parent,
////                       String userEmail,
////                       UserLogin.UserType userType,
////                       long durationInMinutes,
////                       PaymentCallback callback) {
////        // 'true' makes this a modal dialog (blocks until closed).
////        super(parent, "Payment Required", true);
////        this.userEmail = userEmail;
////        this.userType = userType;
////        this.durationInMinutes = durationInMinutes;
////        this.callback = callback;
////
////        // Compute the cost using your PaymentRates class:
////        this.amountDue = PaymentRates.calculateCost(userType, durationInMinutes);
////
////        initializeUI();
////    }
////
////    private void initializeUI() {
////        // Basic layout
////        setLayout(new BorderLayout(10, 10));
////        setSize(300, 150);
////        setLocationRelativeTo(getParent());
////
////        // Center label to show calculated amount
////        JLabel amountLabel = new JLabel("Amount Due: $" + String.format("%.2f", amountDue), JLabel.CENTER);
////        amountLabel.setFont(new Font("Arial", Font.BOLD, 16));
////        add(amountLabel, BorderLayout.CENTER);
////
////        // Button panel with "Pay Now" & "Cancel"
////        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
////        JButton payButton = new JButton("Pay Now");
////        JButton cancelButton = new JButton("Cancel");
////
////        buttonPanel.add(payButton);
////        buttonPanel.add(cancelButton);
////        add(buttonPanel, BorderLayout.SOUTH);
////
////        // "Pay Now" action
////        payButton.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                // In a real app, you'd integrate a payment processor here.
////                // For now, assume payment succeeded:
////                if (callback != null) {
////                    callback.onPaymentComplete(true);
////                }
////                dispose();
////            }
////        });
////
////        // "Cancel" action
////        cancelButton.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                // User canceled payment
////                if (callback != null) {
////                    callback.onPaymentComplete(false);
////                }
////                dispose();
////            }
////        });
////    }
////}
//
//
//package com.parkingapp;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import services.FirebaseInitialization;   // For db = FirebaseInitialization.getInstance();
//import com.google.cloud.firestore.DocumentReference;
//import com.google.cloud.firestore.DocumentSnapshot;
//import com.google.cloud.firestore.Firestore;
//import com.google.cloud.firestore.SetOptions;
//
//import javax.swing.*;
//import javax.swing.SwingWorker;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.prefs.Preferences;
//import java.util.concurrent.ExecutionException;
//
///**
// * PaymentPage - Displays the amount due and allows the user to select a payment option.
// */
//public class PaymentPage extends JDialog {
//
//    public interface PaymentCallback {
//        void onPaymentComplete(boolean wasPaid);
//    }
//
//    private final String userEmail;
//    private final UserLogin.UserType userType;
//    private final long durationInMinutes;
//    private final double amountDue;        // Calculated using PaymentRates
//    private final PaymentCallback callback;
//    
//    // ADDED: Firestore instance from your FirebaseInitialization singleton
//    private Firestore db;
//
//    public PaymentPage(Frame parent, 
//                       String userEmail, 
//                       UserLogin.UserType userType, 
//                       long durationInMinutes, 
//                       PaymentCallback callback) {
//        super(parent, "Payment Required", true);
//        this.userEmail = userEmail;
//        this.userType = userType;
//        this.durationInMinutes = durationInMinutes;
//        this.callback = callback;
//
//        // Compute the cost using your PaymentRates class:
//        this.amountDue = PaymentRates.calculateCost(userType, durationInMinutes);
//        
//        // ADDED: Get Firestore instance from your FirebaseInitialization singleton
//        db = FirebaseInitialization.getInstance();
//
//        initializeUI();
//    }
//
//    private void initializeUI() {
//        setLayout(new BorderLayout(10, 10));
//        setSize(300, 150);
//        setLocationRelativeTo(getParent());
//
//        // Center label to show calculated amount
//        JLabel amountLabel = new JLabel("Amount Due: $" + String.format("%.2f", amountDue), JLabel.CENTER);
//        amountLabel.setFont(new Font("Arial", Font.BOLD, 16));
//        add(amountLabel, BorderLayout.CENTER);
//
//        // Button panel with "Pay Now" & "Cancel"
//        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
//        JButton payButton = new JButton("Pay Now");
//        JButton cancelButton = new JButton("Cancel");
//
//        buttonPanel.add(payButton);
//        buttonPanel.add(cancelButton);
//        add(buttonPanel, BorderLayout.SOUTH);
//
//        // "Pay Now" action
//        payButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Open a new dialog for payment options
//                showPaymentOptions();
//            }
//        });
//
//        // "Cancel" action
//        cancelButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // If canceled, notify that no payment was made
//                if (callback != null) {
//                    callback.onPaymentComplete(false);
//                }
//                dispose();
//            }
//        });
//    }
//
//    private void showPaymentOptions() {
//        // New dialog to show payment options
//        JDialog paymentOptionsDialog = new JDialog(this, "Choose Payment Method", true);
//        paymentOptionsDialog.setSize(300, 250);
//        paymentOptionsDialog.setLocationRelativeTo(this);
//
//        // Main panel for the payment options
//        JPanel optionsPanel = new JPanel();
//        optionsPanel.setLayout(new BorderLayout(10, 10));
//
//        // Center panel for the buttons
//        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
//        JLabel instructionLabel = new JLabel("Choose Your Payment Method", JLabel.CENTER);
//        instructionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
//
//        // Add the instruction label and payment buttons
//        buttonsPanel.add(instructionLabel);
//
//        // Payment method buttons
//        JButton debitButton = new JButton("Debit");
//        JButton creditButton = new JButton("Credit");
//        JButton mobileButton = new JButton("Mobile");
//
//        buttonsPanel.add(debitButton);
//        buttonsPanel.add(creditButton);
//        buttonsPanel.add(mobileButton);
//
//        // Add action listeners for each payment option
//        debitButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                showCardDetailsDialog("Debit");
//                paymentOptionsDialog.dispose();  // Close the payment options dialog
//            }
//        });
//
//        creditButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                showCardDetailsDialog("Credit");
//                paymentOptionsDialog.dispose();  // Close the payment options dialog
//            }
//        });
//
//        mobileButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                showCardDetailsDialog("Mobile");
//                paymentOptionsDialog.dispose();  // Close the payment options dialog
//            }
//        });
//
//        // Add buttons panel to the center of the dialog
//        optionsPanel.add(buttonsPanel, BorderLayout.CENTER);
//
//        // Cancel button at the bottom
//        JButton cancelButton = new JButton("Cancel");
//        cancelButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                paymentOptionsDialog.dispose();  // Close the dialog without processing payment
//            }
//        });
//
//        optionsPanel.add(cancelButton, BorderLayout.SOUTH);  // Place Cancel button at the bottom
//
//        paymentOptionsDialog.add(optionsPanel);
//        paymentOptionsDialog.setVisible(true);  // Display the payment options dialog
//    }
//
//    private void showCardDetailsDialog(String paymentMethod) {
//        // Create a dialog for card details entry
//        JDialog cardDetailsDialog = new JDialog(this, "Enter Card Details", true);
//        cardDetailsDialog.setSize(400, 350); // Increased size to provide more space
//        cardDetailsDialog.setLocationRelativeTo(this);
//
//        // Panel for the card details form
//        JPanel cardDetailsPanel = new JPanel();
//        cardDetailsPanel.setLayout(new GridLayout(7, 1, 10, 10)); // Added more space for better alignment
//
//        // Labels and text fields for card details
//        JLabel cardNumberLabel = new JLabel("Card Number (Must Enter 16 digits):");
//        JTextField cardNumberField = new JTextField();
//
//        JLabel cvvLabel = new JLabel("CVV (Must Enter 3 digits):");
//        JTextField cvvField = new JTextField();
//
//        JLabel clientIdLabel = new JLabel("Client ID (Must Enter 5 digits):");
//        JTextField clientIdField = new JTextField();
//
//        // "Confirm Booking" button
//        JButton confirmButton = new JButton("Confirm Booking");
//        confirmButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Validation before processing payment
//                if (validateCardDetails(cardNumberField, cvvField, clientIdField)) {
//                    processPayment(paymentMethod);  // Process payment based on the selected method
//                    cardDetailsDialog.dispose();  // Close the card details dialog
//                }
//            }
//        });
//
//        // Add components to the card details panel
//        cardDetailsPanel.add(cardNumberLabel);
//        cardDetailsPanel.add(cardNumberField);
//        cardDetailsPanel.add(cvvLabel);
//        cardDetailsPanel.add(cvvField);
//        cardDetailsPanel.add(clientIdLabel);
//        cardDetailsPanel.add(clientIdField);
//        cardDetailsPanel.add(confirmButton);
//
//        cardDetailsDialog.add(cardDetailsPanel);
//        cardDetailsDialog.setVisible(true);  // Show the card details dialog
//    }
//
//
//    private boolean validateCardDetails(JTextField cardNumberField, JTextField cvvField, JTextField clientIdField) {
//        // Validate Card Number (must be exactly 16 digits in the format #### #### #### ####)
//        String cardNumber = cardNumberField.getText().replaceAll("\\s", "");
//        if (cardNumber.length() != 16 || !cardNumber.matches("\\d{16}")) {
//            JOptionPane.showMessageDialog(this, "Card number must be exactly 16 digits.", "Error", JOptionPane.ERROR_MESSAGE);
//            return false;
//        }
//
//        // Validate CVV (must be exactly 3 digits)
//        String cvv = cvvField.getText();
//        if (cvv.length() != 3 || !cvv.matches("\\d{3}")) {
//            JOptionPane.showMessageDialog(this, "CVV must be exactly 3 digits.", "Error", JOptionPane.ERROR_MESSAGE);
//            return false;
//        }
//
//        // Validate Client ID (must be exactly 9 digits)
//        String clientId = clientIdField.getText();
//        if (clientId.length() != 5 || !clientId.matches("\\d{5}")) {
//            JOptionPane.showMessageDialog(this, "Client ID must be exactly 5 digits.", "Error", JOptionPane.ERROR_MESSAGE);
//            return false;
//        }
//
//        return true;  // All validations passed
//    }
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
////    private void processPayment(String method) {
////        if (callback != null) {
////            callback.onPaymentComplete(true);  // Notify the caller that payment was successful
////        }
////
////        // Show payment confirmation
////        JOptionPane.showMessageDialog(this,
////                "Payment of $" + String.format("%.2f", amountDue) + " made via " + method,
////                "Payment Successful",
////                JOptionPane.INFORMATION_MESSAGE);
////
////        dispose(); // Close the original PaymentPage dialog after successful payment
////    }
////}
//    
//    //NEW PROCESSPAYMENT METHOD TO REFLECT CHANGES IN BALANCE:
//    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    
//    
//    
//    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// // ----------------- PROCESS PAYMENT -----------------
//    /**
//     * 1) Retrieves the user’s UID from Preferences.
//     * 2) Fetches current balance from Firestore.
//     * 3) Deducts amountDue and updates Firestore.
//     * 4) Invokes callback on success/failure.
//     * 5) Refreshes BookingPage balance if PaymentPage was opened from BookingPage.
//     */
//    
//    private void processPayment(String method) {
//        SwingWorker<Double, Void> worker = new SwingWorker<>() {
//            @Override
//            protected Double doInBackground() throws Exception {
//                // Retrieve user UID from Preferences
//                Preferences prefs = Preferences.userNodeForPackage(BookingPage.class);
//                String uid = prefs.get("user_uid", null);
//                if (uid == null) {
//                    throw new Exception("User not logged in.");
//                }
//
//                // Get the user document
//                DocumentReference userRef = db.collection("users").document(uid);
//                DocumentSnapshot docSnap = userRef.get().get();
//
//                double currentBalance = 0.0;
//                if (docSnap.exists() && docSnap.contains("balance")) {
//                    currentBalance = docSnap.getDouble("balance");
//                }
//
//                // Check if there's enough balance
//                double newBalance = currentBalance - amountDue;
//                if (newBalance < 0) {
//                    throw new Exception("Insufficient funds. Current balance: $" 
//                            + String.format("%.2f", currentBalance));
//                }
//
//                // Update the balance in Firestore
//                Map<String, Object> data = new HashMap<>();
//                data.put("balance", newBalance);
//                userRef.set(data, SetOptions.merge()).get();  // Wait for completion
//
//                return newBalance;
//            }
//
//            @Override
//            protected void done() {
//                try {
//                    double newBalance = get();  // Retrieve result or throw exception
//
//                    // If PaymentPage has a BookingPage parent, refresh that page’s balance
//                    if (getParent() instanceof BookingPage) {
//                        ((BookingPage) getParent()).loadUserBalance();
//                    }
//
//                    // Notify the original caller (BookingPage) that payment succeeded
//                    if (callback != null) {
//                        callback.onPaymentComplete(true);
//                    }
//
//                    // Show success message
//                    JOptionPane.showMessageDialog(PaymentPage.this,
//                            "Payment of $" + String.format("%.2f", amountDue) 
//                            + " made via " + method
//                            + ".\nNew Balance: $" + String.format("%.2f", newBalance),
//                            "Payment Successful",
//                            JOptionPane.INFORMATION_MESSAGE);
//                    dispose();
//
//                } catch (InterruptedException | ExecutionException ex) {
//                    // Exceptions from Firestore futures
//                    JOptionPane.showMessageDialog(PaymentPage.this,
//                            "Payment failed: " + ex.getCause().getMessage(),
//                            "Payment Error",
//                            JOptionPane.ERROR_MESSAGE);
//                } catch (Exception ex) {
//                    // Exceptions thrown in doInBackground() or here
//                    JOptionPane.showMessageDialog(PaymentPage.this,
//                            "Payment failed: " + ex.getMessage(),
//                            "Payment Error",
//                            JOptionPane.ERROR_MESSAGE);
//                }
//            }
//        };
//        worker.execute();
//    }
//}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
                Preferences prefs = Preferences.userNodeForPackage(BookingPage.class);
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
                    if (getParent() instanceof BookingPage) {
                        ((BookingPage) getParent()).loadUserBalance();
                    }

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


