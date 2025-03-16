package com.parkingapp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class Payment extends JFrame {

    private double userBalance = 0;  // Balance stored
    private String userEmail;
    private UserLogin.UserType userType;
    private JLabel userTypeLabel; // Display user type
    private long durationInMinutes;  // Store booking duration
    private double amountToPay; // Store calculated payment amount
    private JLabel balanceLabel;
    private JLabel amountLabel;

    public Payment(String userEmail, UserLogin.UserType userType, long durationInMinutes) {
        this.userEmail = userEmail;
        this.userType = userType; // Retrieve user type
        this.durationInMinutes = durationInMinutes;

        // Calculate amount to pay using PaymentRates
        this.amountToPay = PaymentRates.calculateCost(userType, durationInMinutes);

        setTitle("Payment System -" + userType);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        balanceLabel = new JLabel("Current Balance: $" + userBalance, JLabel.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(balanceLabel);

        // Display the auto-calculated payment amount
        amountLabel = new JLabel("Amount Due: $" + amountToPay, JLabel.CENTER);
        amountLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(amountLabel);

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
        new PayPanel(this, amountToPay).setVisible(true);
    }

    public void updateBalance(double amount) {
        userBalance += amount;
        balanceLabel.setText("Account Funds: $" + userBalance);
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
        SwingUtilities.invokeLater(() -> new Payment("testuser@example.com", UserLogin.UserType.STUDENT, 0).setVisible(true));
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
    private double amountToPay; // Store calculated amount

    public PayPanel(Payment parent, double amountToPay) {
        this.parent = parent;
        this.amountToPay = amountToPay;

        setTitle("Make a Payment");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("Amount to Pay:"));
        paymentAmountField = new JTextField(String.format("%.2f", amountToPay)); // Pre-fill the amount
        paymentAmountField.setEnabled(false); // Disable manual input
        add(paymentAmountField);

        JButton payButton = new JButton("Pay");
        payButton.addActionListener(e -> processPayment());
        add(payButton);
    }

    private void processPayment() {
        double amountToPay;
        try {
            amountToPay = Double.parseDouble(paymentAmountField.getText());
            if (amountToPay <= 0) {
                JOptionPane.showMessageDialog(this, "Amount must be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid amount.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (parent.deductBalance(amountToPay)) {
            JOptionPane.showMessageDialog(this, "Payment of $" + amountToPay + " was successful!");
            dispose();
        }
    }
}

class CreditCardPaymentWindow extends JFrame {
    private JTextField cardNumberField, expiryDateField, cvvField, postalCodeField;
    private DepositPanel parent;
    private double amount;

    public CreditCardPaymentWindow(DepositPanel parent, double amount) {
        this.parent = parent;
        this.amount = amount;

        setTitle("Credit Card Payment");
        setSize(350, 250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Card Number (16 Digits):"));
        cardNumberField = new JTextField();
        panel.add(cardNumberField);

        panel.add(new JLabel("Expiry Date (MM/YY):"));
        expiryDateField = new JTextField();
        panel.add(expiryDateField);

        panel.add(new JLabel("CVV (3 Digits):"));
        cvvField = new JTextField();
        panel.add(cvvField);

        panel.add(new JLabel("Postal Code:"));
        postalCodeField = new JTextField();
        panel.add(postalCodeField);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(e -> processPayment());
        panel.add(confirmButton);

        add(panel);
    }

    private void processPayment() {
        String cardNumber = cardNumberField.getText().trim();
        String expiryDate = expiryDateField.getText().trim();
        String cvv = cvvField.getText().trim();
        String postalCode = postalCodeField.getText().trim();

        // Validate 16-digit card number (only numbers)
        if (!cardNumber.matches("\\d{16}")) {
            JOptionPane.showMessageDialog(this, "Card number must be exactly 16 digits.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate expiry date format MM/YY
        if (!expiryDate.matches("^(0[1-9]|1[0-2])/\\d{2}$")) {
            JOptionPane.showMessageDialog(this, "Expiry date must be in MM/YY format.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate CVV (only 3 digits)
        if (!cvv.matches("\\d{3}")) {
            JOptionPane.showMessageDialog(this, "CVV must be exactly 3 digits.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        saveCreditPaymentDetails("Credit Card", cardNumber, expiryDate, cvv, postalCode, amount);
        parent.confirmDeposit(amount);
        dispose();
    }

    private void saveCreditPaymentDetails(String method, String cardNumber, String expiryDate, String cvv, String postalCode, double amount) {
        try (FileWriter writer = new FileWriter("payment_details.csv", true)) {
            writer.append(method).append(",");
            writer.append(cardNumber).append(",");
            writer.append(expiryDate).append(",");
            writer.append(cvv).append(",");
            writer.append(postalCode).append(",");
            writer.append(String.valueOf(amount)).append("\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving payment details.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

class BankTransferPaymentWindow extends JFrame {
    private JTextField bankNameField, accountNumberField, instNumberField, transitNumberField, holderNameField;
    private JComboBox<String> accountTypeComboBox;
    private DepositPanel parent;
    private double amount;

    public BankTransferPaymentWindow(DepositPanel parent, double amount) {
        this.parent = parent;
        this.amount = amount;

        setTitle("Bank Transfer");
        setSize(350, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Account Holder Full Name:"));
        holderNameField = new JTextField();
        panel.add(holderNameField);

        panel.add(new JLabel("Bank Name:"));
        bankNameField = new JTextField();
        panel.add(bankNameField);

        panel.add(new JLabel("Account Type:"));
        String[] accountTypes = {"Deposit (Checking)", "Savings"};
        accountTypeComboBox = new JComboBox<>(accountTypes);
        panel.add(accountTypeComboBox);

        panel.add(new JLabel("Account Number:"));
        accountNumberField = new JTextField();
        panel.add(accountNumberField);

        panel.add(new JLabel("Institution Number:"));
        instNumberField = new JTextField();
        panel.add(instNumberField);

        panel.add(new JLabel("Transit Number:"));
        transitNumberField = new JTextField();
        panel.add(transitNumberField);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(e -> processBankPayment());
        panel.add(confirmButton);

        add(panel);
    }

    private void processBankPayment() {
        String holderName = holderNameField.getText().trim();
        String bankName = bankNameField.getText().trim();
        String accountType = (String) accountTypeComboBox.getSelectedItem();
        String accountNumber = accountNumberField.getText().trim();
        String instNumber = instNumberField.getText().trim();
        String transitNumber = transitNumberField.getText().trim();

        // The following code will validate user bank details using standard Canadian Banking Direct Deposit Standards
        // (i.e. Bank Transfer)

        // Validate Account Holder Name
        if (holderName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Account holder name is required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate Bank Name
        if (bankName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bank Name is required!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate Account Number (Must be numeric and at least 6 digits)
        if (!accountNumber.matches("\\d{6,}")) {
            JOptionPane.showMessageDialog(this, "Account number must be at least 6 digits.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate Institution Number (Exactly 3 digits)
        if (!instNumber.matches("\\d{3}")) {
            JOptionPane.showMessageDialog(this, "Institution number must be exactly 3 digits.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate Transit Number (Exactly 5 digits)
        if (!transitNumber.matches("\\d{5}")) {
            JOptionPane.showMessageDialog(this, "Transit number must be exactly 5 digits.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Save details and confirm deposit
        saveBankPaymentDetails("Bank Transfer", holderName, bankName, accountType, accountNumber, instNumber, transitNumber, amount);
        parent.confirmDeposit(amount);
        dispose();
    }

    private void saveBankPaymentDetails(String method, String holderFullName, String bankName, String accountType, String accountNumber, String instNumber, String transitNumber, double amount) {
        try (FileWriter writer = new FileWriter("payment_details.csv", true)) {
            writer.append(method).append(",");
            writer.append(holderFullName).append(",");
            writer.append(bankName).append(",");
            writer.append(accountType).append(",");
            writer.append(accountNumber).append(",");
            writer.append(instNumber).append(",");
            writer.append(transitNumber).append(",");
            writer.append(String.valueOf(amount)).append("\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving bank payment details.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

class PayPalPaymentWindow extends JFrame {
    private JTextField emailField;
    private DepositPanel parent;
    private double amount;

    public PayPalPaymentWindow(DepositPanel parent, double amount) {
        this.parent = parent;
        this.amount = amount;

        setTitle("PayPal Payment");
        setSize(500, 200);
        setLocationRelativeTo(null);

        // Panel for Form Fields
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Adding PayPal Logo
        ImageIcon paypalIcon = new ImageIcon(getClass().getResource("/paypal_logo.png")); // uploaded this file in our project directory

        // Resize the image to 150x50 pixels
        Image scaledImage = paypalIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);

        // Create the JLabel with the resized icon
        JLabel paypalLabel = new JLabel(resizedIcon);

        formPanel.add(paypalLabel);

        // Email Label
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("PayPal Email:"), gbc);

        // Email Text Field (Increased width)
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(200, 30));  // Set fixed size
        formPanel.add(emailField, gbc);

        // Confirm Button (Increased width)
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setPreferredSize(new Dimension(200, 40));  // Set fixed size
        confirmButton.addActionListener(e -> processPaypalPayment());

        // Panel for Button (Centers the button)
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(confirmButton);

        // Adding Components to Frame
        add(paypalLabel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

    }

    private void processPaypalPayment() {
        String email = emailField.getText().trim();

        // Validate email format
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            JOptionPane.showMessageDialog(this, "Invalid PayPal email format.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        savePayPalPaymentDetails("PayPal", email, amount);
        parent.confirmDeposit(amount);
        dispose();
    }

    private void savePayPalPaymentDetails(String method, String email, double amount) {
        try (FileWriter writer = new FileWriter("payment_details.csv", true)) {
            writer.append(method).append(",");
            writer.append(email).append(",");
            writer.append(String.valueOf(amount)).append("\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving PayPal payment details.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}


