package com.parkingapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A simple popup dialog that shows a dynamically calculated amount
 * (based on PaymentRates) and two buttons:
 *  - "Pay Now" confirms payment (wasPaid = true)
 *  - "Cancel" closes without payment (wasPaid = false)
 *
 * The caller should pass in a PaymentCallback so it can know if the user
 * completed the payment successfully (wasPaid = true) or canceled (wasPaid = false).
 */
public class PaymentPage extends JDialog {

    /**
     * A functional interface to receive a boolean indicating
     * if the user actually paid (true) or canceled (false).
     */
    public interface PaymentCallback {
        /**
         * Called when the user finishes the payment process.
         *
         * @param wasPaid true if the user paid successfully, false otherwise
         */
        void onPaymentComplete(boolean wasPaid);
    }

    private final String userEmail;
    private final UserLogin.UserType userType;
    private final long durationInMinutes;
    private final double amountDue;        // Calculated using PaymentRates
    private final PaymentCallback callback;

    /**
     * Constructs a modal dialog for payment.
     *
     * @param parent            a parent frame (so the dialog is centered relative to it)
     * @param userEmail         the user’s email (if you need it for logging or display)
     * @param userType          the user’s type (STUDENT, FACULTY, etc.)
     * @param durationInMinutes how long the user is booking (in minutes)
     * @param callback          a callback to notify the caller if payment was successful or canceled
     */
    public PaymentPage(Frame parent,
                       String userEmail,
                       UserLogin.UserType userType,
                       long durationInMinutes,
                       PaymentCallback callback) {
        // 'true' makes this a modal dialog (blocks until closed).
        super(parent, "Payment Required", true);
        this.userEmail = userEmail;
        this.userType = userType;
        this.durationInMinutes = durationInMinutes;
        this.callback = callback;

        // Compute the cost using your PaymentRates class:
        this.amountDue = PaymentRates.calculateCost(userType, durationInMinutes);

        initializeUI();
    }

    private void initializeUI() {
        // Basic layout
        setLayout(new BorderLayout(10, 10));
        setSize(300, 150);
        setLocationRelativeTo(getParent());

        // Center label to show calculated amount
        JLabel amountLabel = new JLabel("Amount Due: $" + String.format("%.2f", amountDue), JLabel.CENTER);
        amountLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(amountLabel, BorderLayout.CENTER);

        // Button panel with "Pay Now" & "Cancel"
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        JButton payButton = new JButton("Pay Now");
        JButton cancelButton = new JButton("Cancel");

        buttonPanel.add(payButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // "Pay Now" action
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // In a real app, you'd integrate a payment processor here.
                // For now, assume payment succeeded:
                if (callback != null) {
                    callback.onPaymentComplete(true);
                }
                dispose();
            }
        });

        // "Cancel" action
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // User canceled payment
                if (callback != null) {
                    callback.onPaymentComplete(false);
                }
                dispose();
            }
        });
    }
}


