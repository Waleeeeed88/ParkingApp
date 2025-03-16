package com.parkingapp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Payment extends JFrame {

    private double userBalance = 0.0;  // Balance stored
    private String userEmail;
    private JLabel balanceLabel;

    public Payment(String userEmail) {
        this.userEmail = userEmail;
        setTitle("Payment System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        balanceLabel = new JLabel("Current Balance: $" + userBalance, JLabel.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(balanceLabel);

        JButton depositButton = new JButton("Deposit Funds");
        depositButton.addActionListener(e -> openDepositPanel());
        mainPanel.add(depositButton);

        JButton payButton = new JButton("Make a Payment");
        payButton.addActionListener(e -> openPayPanel());
        mainPanel.add(payButton);

        add(mainPanel);
    }

    private void openDepositPanel() {
        new DepositPanel(this).setVisible(true);
    }

    private void openPayPanel() {
        new PayPanel(this).setVisible(true);
    }

    public void updateBalance(double amount) {
        userBalance += amount;
        balanceLabel.setText("Current Balance: $" + userBalance);
    }

    public boolean deductBalance(double amount) {
        if (amount > userBalance) {
            JOptionPane.showMessageDialog(this, "Insufficient funds!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        userBalance -= amount;
        balanceLabel.setText("Current Balance: $" + userBalance);
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Payment("testuser@example.com").setVisible(true));
    }
}

class DepositPanel extends JFrame {
    private JComboBox<String> paymentTypeComboBox;
    private JTextField depositAmountField;
    private Payment parent;

    public DepositPanel(Payment parent) {
        this.parent = parent;
        setTitle("Deposit Funds");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Payment Method:"));
        String[] paymentMethods = {"Credit Card", "Bank Transfer", "PayPal"};
        paymentTypeComboBox = new JComboBox<>(paymentMethods);
        add(paymentTypeComboBox);

        add(new JLabel("Amount:"));
        depositAmountField = new JTextField();
        add(depositAmountField);

        JButton proceedButton = new JButton("Proceed");
        proceedButton.addActionListener(e -> openPaymentWindow());
        add(proceedButton);
    }

    private void openPaymentWindow() {
        String selectedPaymentType = (String) paymentTypeComboBox.getSelectedItem();
        double amount;

        try {
            amount = Double.parseDouble(depositAmountField.getText());
            if (amount <= 0) {
                JOptionPane.showMessageDialog(this, "Amount must be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid amount.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (selectedPaymentType.equals("Credit Card")) {
            new CreditCardPaymentWindow(this, amount).setVisible(true);
        } else if (selectedPaymentType.equals("Bank Transfer")) {
            new BankTransferPaymentWindow(this, amount).setVisible(true);
        } else if (selectedPaymentType.equals("PayPal")) {
            new PayPalPaymentWindow(this, amount).setVisible(true);
        }
    }

    public void confirmDeposit(double amount) {
        parent.updateBalance(amount);
        JOptionPane.showMessageDialog(this, "Deposit successful! $" + amount + " added.");
        dispose();
    }
}

class PayPanel extends JFrame {
    private JTextField paymentAmountField;
    private Payment parent;

    public PayPanel(Payment parent) {
        this.parent = parent;
        setTitle("Make a Payment");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("Enter Payment Amount:"));
        paymentAmountField = new JTextField();
        add(paymentAmountField);

        JButton payButton = new JButton("Pay");
        payButton.addActionListener(e -> processPayment());
        add(payButton);
    }

    private void processPayment() {
        double amount;
        try {
            amount = Double.parseDouble(paymentAmountField.getText());
            if (amount <= 0) {
                JOptionPane.showMessageDialog(this, "Amount must be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid amount.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (parent.deductBalance(amount)) {
            JOptionPane.showMessageDialog(this, "Payment of $" + amount + " was successful!");
            dispose();
        }
    }
}

class CreditCardPaymentWindow extends JFrame {
    public CreditCardPaymentWindow(DepositPanel parent, double amount) {
        setTitle("Credit Card Payment");
        setSize(350, 250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Card Number (16 Digits):"));
        panel.add(new JTextField());

        panel.add(new JLabel("Expiry Date (MM/YY):"));
        panel.add(new JTextField());

        panel.add(new JLabel("CVV (3 Digits):"));
        panel.add(new JTextField());

        panel.add(new JLabel("Postal Code:"));
        panel.add(new JTextField());

        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(e -> {
            parent.confirmDeposit(amount);
            dispose();
        });
        panel.add(confirmButton);

        add(panel);
    }
}

class BankTransferPaymentWindow extends JFrame {
    public BankTransferPaymentWindow(DepositPanel parent, double amount) {
        setTitle("Bank Transfer");
        setSize(350, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Bank Name:"));
        panel.add(new JTextField());

        panel.add(new JLabel("Account Number:"));
        panel.add(new JTextField());

        panel.add(new JLabel("Institution Number:"));
        panel.add(new JTextField());

        panel.add(new JLabel("Transit Number:"));
        panel.add(new JTextField());

        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(e -> {
            parent.confirmDeposit(amount);
            dispose();
        });
        panel.add(confirmButton);

        add(panel);
    }
}

class PayPalPaymentWindow extends JFrame {
    public PayPalPaymentWindow(DepositPanel parent, double amount) {
        setTitle("PayPal Payment");
        setSize(350, 150);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("PayPal Email:"));
        panel.add(new JTextField());

        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(e -> {
            parent.confirmDeposit(amount);
            dispose();
        });
        panel.add(confirmButton);

        add(panel);
    }
}


