package com.parkingapp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Payment extends JFrame {

    private JTextField cardNumberField, expiryDateField, cvvField, cardholderNameField, provinceField, postalCodeField, billingAddressField;
    private JTextField recipientNameField, bankNameField, transitNumberField, institutionNumberField, accountNumberField;
    private JTextField paypalUsernameField, paypalEmailField;
    private JTextField transactionAmountField;
    private JComboBox<String> paymentTypeComboBox;
    private JLabel balanceLabel;
    private JButton payButton;
    private JPanel cardPanel, bankPanel, paypalPanel;
    private double userBalance = 0.0;
    private String userEmail;

    public Payment(String userEmail) {
        this.userEmail = userEmail;
        setTitle("Payment Options");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 550);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel paymentTypeLabel = new JLabel("Payment Type:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(paymentTypeLabel, gbc);

        String[] paymentTypes = {"Debit/Credit Card", "Bank Transfer", "PayPal"};
        paymentTypeComboBox = new JComboBox<>(paymentTypes);
        gbc.gridx = 1;
        gbc.gridy = 0;
        inputPanel.add(paymentTypeComboBox, gbc);

        JLabel amountLabel = new JLabel("Transaction Amount:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(amountLabel, gbc);

        transactionAmountField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        inputPanel.add(transactionAmountField, gbc);

        balanceLabel = new JLabel("Balance: $" + userBalance);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        inputPanel.add(balanceLabel, gbc);

        mainPanel.add(inputPanel, BorderLayout.NORTH);

        cardPanel = createCardPanel();
        mainPanel.add(cardPanel, BorderLayout.CENTER);

        bankPanel = createBankPanel();
        mainPanel.add(bankPanel, BorderLayout.CENTER);
        bankPanel.setVisible(false);

        paypalPanel = createPayPalPanel();
        mainPanel.add(paypalPanel, BorderLayout.CENTER);
        paypalPanel.setVisible(false);

        payButton = new JButton("Pay");
        mainPanel.add(payButton, BorderLayout.SOUTH);

        add(mainPanel);

        paymentTypeComboBox.addActionListener(e -> updatePaymentPanel());
        payButton.addActionListener(e -> processPayment());
    }

    private JPanel createCardPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        cardNumberField = createTextField("Card Number:", panel, gbc, 0);
        expiryDateField = createTextField("Expiry Date (MM/YY):", panel, gbc, 1);
        cvvField = createTextField("CVV:", panel, gbc, 2);
        cardholderNameField = createTextField("Cardholder Name:", panel, gbc, 3);
        provinceField = createTextField("Province:", panel, gbc, 4);
        postalCodeField = createTextField("Postal Code:", panel, gbc, 5);
        billingAddressField = createTextField("Billing Address:", panel, gbc, 6);

        return panel;
    }

    private JPanel createBankPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        recipientNameField = createTextField("Recipient Name:", panel, gbc, 0);
        bankNameField = createTextField("Bank Name:", panel, gbc, 1);
        transitNumberField = createTextField("Transit Number:", panel, gbc, 2);
        institutionNumberField = createTextField("Institution Number:", panel, gbc, 3);
        accountNumberField = createTextField("Account Number:", panel, gbc, 4);

        return panel;
    }

    private JPanel createPayPalPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        paypalUsernameField = createTextField("PayPal Username:", panel, gbc, 0);
        paypalEmailField = createTextField("PayPal Email:", panel, gbc, 1);

        return panel;
    }

    private JTextField createTextField(String labelText, JPanel panel, GridBagConstraints gbc, int gridy) {
        JLabel label = new JLabel(labelText);
        gbc.gridx = 0;
        gbc.gridy = gridy;
        panel.add(label, gbc);

        JTextField textField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = gridy;
        panel.add(textField, gbc);
        return textField;
    }

    private void updatePaymentPanel() {
        String selectedPaymentType = (String) paymentTypeComboBox.getSelectedItem();
        cardPanel.setVisible(selectedPaymentType.equals("Debit/Credit Card"));
        bankPanel.setVisible(selectedPaymentType.equals("Bank Transfer"));
        paypalPanel.setVisible(selectedPaymentType.equals("PayPal"));
    }

    private void processPayment() {
        String paymentType = (String) paymentTypeComboBox.getSelectedItem();
        double amount;
        try {
            amount = Double.parseDouble(transactionAmountField.getText());
            if (amount <= 0) {
                JOptionPane.showMessageDialog(this, "Amount must be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid amount.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Map<String, String> paymentDetails = new HashMap<>();
        paymentDetails.put("Payment Type", paymentType);
        paymentDetails.put("Amount", String.valueOf(amount));
        paymentDetails.put("User Email", userEmail);

        PaymentStrategy strategy = null;
        if (paymentType.equals("Debit/Credit Card")) {
            strategy = new CreditCardPayment();
        } else if (paymentType.equals("Bank Transfer")) {
            strategy = new BankTransferPayment();
        } else if (paymentType.equals("PayPal")) {
            strategy = new PayPalPayment();
        }

        if (strategy != null) {
            strategy.processPayment(paymentDetails, amount, this);
        }
    }

    private void writePaymentToCSV(Map<String, String> paymentDetails) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("payment_details.csv", true))) {
            StringBuilder line = new StringBuilder();
            for (String value : paymentDetails.values()) {
                line.append(value).append(",");
            }
            line.deleteCharAt(line.length() - 1);
            writer.write(line.toString());
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to CSV file.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    // Strategy Pattern: Payment Strategy Interface
    interface PaymentStrategy {
        void processPayment(Map<String, String> paymentDetails, double amount, Payment payment);
    }

    // Concrete Strategy: Credit Card Payment
    class CreditCardPayment implements PaymentStrategy {
        @Override
        public void processPayment(Map<String, String> paymentDetails, double amount, Payment payment) {
            JOptionPane.showMessageDialog(payment, "Credit Card Payment of $" + amount + " Successful.");
            payment.writePaymentToCSV(paymentDetails);
        }
    }

    // Concrete Strategy: Bank Transfer Payment
    class BankTransferPayment implements PaymentStrategy {
        @Override
        public void processPayment(Map<String, String> paymentDetails, double amount, Payment payment) {
            JOptionPane.showMessageDialog(payment, "Bank Transfer Payment of $" + amount + " Successful.");
            payment.writePaymentToCSV(paymentDetails);
        }
    }

    // Concrete Strategy: PayPal Payment
    class PayPalPayment implements PaymentStrategy {
        @Override
        public void processPayment(Map<String, String> paymentDetails, double amount, Payment payment) {
            JOptionPane.showMessageDialog(payment, "PayPal Payment of $" + amount + " Successful.");
            payment.writePaymentToCSV(paymentDetails);
        }
    }
}