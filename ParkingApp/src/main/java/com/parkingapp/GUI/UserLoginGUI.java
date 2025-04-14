package com.parkingapp.GUI; // New package for GUI classes

import com.parkingapp.UserLogin; // Needed for UserType enum and logic methods access

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern; // Keep for basic email validation in GUI layer if desired
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.geom.RoundRectangle2D;

public class UserLoginGUI extends JFrame {

    // --- UI Components ---
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JTextField emailField, regEmailField;
    private JPasswordField passwordField, regPasswordField;
    private JComboBox<UserLogin.UserType> userTypeComboBox; // Use UserType from UserLogin
    private JLabel messageLabel; // Added for displaying messages
    private JPanel loginPanel, registerPanel; // Declare as class members

    // Reference to the logic handler class
    private UserLogin userLoginLogic;

    /**
     * Constructor takes an instance of UserLogin (which holds the logic)
     * @param userLoginLogic The instance handling authentication and user data logic.
     */
    public UserLoginGUI(UserLogin userLoginLogic) {
        this.userLoginLogic = userLoginLogic;
        createAndShowGUI();
    }

    // --- GUI Creation Methods ---
    private void createAndShowGUI() {
        setTitle("Parking App Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 450);
        setMinimumSize(new Dimension(400, 300)); // Set a minimum size for better responsiveness

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        loginPanel = createLoginPanel(); // Initialize here
        registerPanel = createRegisterPanel(); // Initialize here

        mainPanel.add(loginPanel, "login");
        mainPanel.add(registerPanel, "register");

        add(mainPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(240, 248, 255)); // Light background (Alice Blue)
        panel.setBorder(new EmptyBorder(20, 20, 20, 20)); // Add padding

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0; // Make components expand horizontally

        JLabel loginLabel = new JLabel("User Login");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 30));
        loginLabel.setForeground(new Color(0, 70, 140)); // Dark blue title
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER; // Center the title
        panel.add(loginLabel, gbc);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        emailLabel.setForeground(new Color(100, 100, 100));
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(emailLabel, gbc);

        emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(300, 40));
        emailField.setFont(new Font("Arial", Font.PLAIN, 16));
        emailField.setBorder(createRoundedBorder()); // Use rounded border
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(emailField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordLabel.setForeground(new Color(100, 100, 100));
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(passwordLabel, gbc);

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(300, 40));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordField.setBorder(createRoundedBorder());
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(passwordField, gbc);

        messageLabel = new JLabel(); // Initialize messageLabel
        messageLabel.setForeground(Color.RED);
        messageLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(messageLabel, gbc);

        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(150, 45));
        loginButton.setFont(new Font("Arial", Font.BOLD, 18));
        loginButton.setBackground(new Color(0, 123, 255)); // Blue button
        loginButton.setForeground(Color.WHITE);
        loginButton.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        loginButton.setFocusPainted(false);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(loginButton, gbc);

        JButton goToRegisterButton = new JButton("Create Account");
        goToRegisterButton.setPreferredSize(new Dimension(150, 40));
        goToRegisterButton.setFont(new Font("Arial", Font.PLAIN, 14));
        goToRegisterButton.setForeground(new Color(0, 123, 255)); // Blue text
        goToRegisterButton.setBackground(new Color(240, 248, 255)); // Transparent background
        goToRegisterButton.setBorder(BorderFactory.createEmptyBorder());
        goToRegisterButton.setFocusPainted(false);
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(goToRegisterButton, gbc);

        JButton goToAdminLoginButton = new JButton("Admin Login");
        goToAdminLoginButton.setPreferredSize(new Dimension(150, 40));
        goToAdminLoginButton.setFont(new Font("Arial", Font.PLAIN, 14));
        goToAdminLoginButton.setForeground(new Color(0, 123, 255)); // Blue text
        goToAdminLoginButton.setBackground(new Color(240, 248, 255)); // Transparent background
        goToAdminLoginButton.setBorder(BorderFactory.createEmptyBorder());
        goToAdminLoginButton.setFocusPainted(false);
        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(goToAdminLoginButton, gbc);

        // --- Event Listeners for Login Panel ---
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                if (!isValidEmail(email) || password.isEmpty()) {
                    messageLabel.setText("Invalid email or password."); // Use messageLabel
                    return;
                }
                // Call the logic method in UserLogin
                userLoginLogic.performLogin(email, password);
                // Clear password field after attempt
                passwordField.setText("");
            }
        });

        goToRegisterButton.addActionListener(e -> {
            cardLayout.show(mainPanel, "register");
            messageLabel.setText(""); // Clear message
        });

        goToAdminLoginButton.addActionListener(e -> {
            new BaseLogin.ManagementLogin().setVisible(true);
            // Consider closing this window: dispose();
        });
        // --- End Event Listeners ---

        return panel;
    }

    private JPanel createRegisterPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(240, 248, 255)); // Light background (Alice Blue)
        panel.setBorder(new EmptyBorder(20, 20, 20, 20)); // Add padding

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JLabel registerLabel = new JLabel("Register New User");
        registerLabel.setFont(new Font("Arial", Font.BOLD, 30));
        registerLabel.setForeground(new Color(0, 70, 140)); // Dark blue title
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(registerLabel, gbc);

        JLabel regEmailLabel = new JLabel("Email:");
        regEmailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        regEmailLabel.setForeground(new Color(100, 100, 100));
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(regEmailLabel, gbc);

        regEmailField = new JTextField();
        regEmailField.setPreferredSize(new Dimension(300, 40));
        regEmailField.setFont(new Font("Arial", Font.PLAIN, 16));
        regEmailField.setBorder(createRoundedBorder());
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(regEmailField, gbc);

        JLabel regPasswordLabel = new JLabel("Password (min 6 chars):");
        regPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        regPasswordLabel.setForeground(new Color(100, 100, 100));
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(regPasswordLabel, gbc);

        regPasswordField = new JPasswordField();
        regPasswordField.setPreferredSize(new Dimension(300, 40));
        regPasswordField.setFont(new Font("Arial", Font.PLAIN, 16));
        regPasswordField.setBorder(createRoundedBorder());
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(regPasswordField, gbc);

        JLabel userTypeLabel = new JLabel("User Type:");
        userTypeLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        userTypeLabel.setForeground(new Color(100, 100, 100));
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(userTypeLabel, gbc);

        userTypeComboBox = new JComboBox<>(UserLogin.UserType.values());
        userTypeComboBox.setPreferredSize(new Dimension(300, 40));
        userTypeComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        userTypeComboBox.setBorder(createRoundedBorder());
        gbc.gridx = 1; gbc.gridy = 3;
        panel.add(userTypeComboBox, gbc);

        messageLabel = new JLabel(); // Initialize
        messageLabel.setForeground(Color.RED);
        messageLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(messageLabel, gbc);

        JButton registerButton = new JButton("Register");
        registerButton.setPreferredSize(new Dimension(150, 45));
        registerButton.setFont(new Font("Arial", Font.BOLD, 18));
        registerButton.setBackground(new Color(0, 123, 255)); // Blue button
        registerButton.setForeground(Color.WHITE);
        registerButton.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        registerButton.setFocusPainted(false);
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(registerButton, gbc);

        JButton backToLoginButton = new JButton("Back to Login");
        backToLoginButton.setPreferredSize(new Dimension(150, 40));
        backToLoginButton.setFont(new Font("Arial", Font.PLAIN, 14));
        backToLoginButton.setForeground(new Color(0, 123, 255)); // Blue text
        backToLoginButton.setBackground(new Color(240, 248, 255)); // Transparent
        backToLoginButton.setBorder(BorderFactory.createEmptyBorder());
        backToLoginButton.setFocusPainted(false);
        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(backToLoginButton, gbc);

        // --- Event Listeners for Register Panel ---
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = regEmailField.getText();
                String password = new String(regPasswordField.getPassword());
                UserLogin.UserType selectedType = (UserLogin.UserType) userTypeComboBox.getSelectedItem();

                // Basic validation
                if (!isValidEmail(email)) {
                    messageLabel.setText("Invalid email address.");
                    return;
                }
                if (password.length() < 6) {
                    messageLabel.setText("Password must be at least 6 characters.");
                    return;
                }
                if (selectedType == null) {
                    messageLabel.setText("Please select a user type.");
                    return;
                }

                // Call the logic method in UserLogin
                userLoginLogic.performRegistration(email, password, selectedType);
                // Clear password
                regPasswordField.setText("");
            }
        });

        backToLoginButton.addActionListener(e -> {
            cardLayout.show(mainPanel, "login");
            messageLabel.setText("");
        });
        // --- End Event Listeners ---

        return panel;
    }

    // Helper method for basic email validation
    private boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) return false;
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    // Helper method to create rounded borders for text fields and combo boxes
    private Border createRoundedBorder() {
        return new LineBorder(new Color(200, 200, 200), 3, true); // Light gray border
    }

    /**
     * Shows a specific panel (card) in the main layout.
     * @param panelName The name of the panel ("login" or "register").
     */
    public void showPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    /**
     * Closes the Login window.
     */
    public void closeWindow() {
        dispose();
    }

    // Main method removed from here - Application entry point will likely create
    // UserLogin and UserLoginGUI instances.
}

