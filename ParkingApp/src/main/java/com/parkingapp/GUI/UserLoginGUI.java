package com.parkingapp.GUI; // New package for GUI classes

import com.parkingapp.BaseLogin; // Needed for Admin Login button action
import com.parkingapp.UserLogin; // Needed for UserType enum and logic methods access

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern; // Keep for basic email validation in GUI layer if desired

public class UserLoginGUI extends JFrame {

    // --- UI Components ---
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JTextField emailField, regEmailField;
    private JPasswordField passwordField, regPasswordField;
    private JComboBox<UserLogin.UserType> userTypeComboBox; // Use UserType from UserLogin

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

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(createLoginPanel(), "login");
        mainPanel.add(createRegisterPanel(), "register");

        add(mainPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel loginLabel = new JLabel("User Login");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 28));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(loginLabel, gbc);

        // ... (rest of the login panel components: emailLabel, emailField, passwordLabel, passwordField) ...
        JLabel emailLabel = new JLabel("Email:");
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        panel.add(emailLabel, gbc);

        emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(300, 35));
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(emailField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(passwordLabel, gbc);

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(300, 35));
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(passwordField, gbc);
        // ---

        JButton loginButton = new JButton("Login");
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        panel.add(loginButton, gbc);

        JButton goToRegisterButton = new JButton("Create Account");
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        panel.add(goToRegisterButton, gbc);

        JButton goToAdminLoginButton = new JButton("Admin Login");
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        panel.add(goToAdminLoginButton, gbc);

        // --- Event Listeners for Login Panel ---
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                if (!isValidEmail(email) || password.isEmpty()) {
                    JOptionPane.showMessageDialog(UserLoginGUI.this, "Please enter a valid email and password",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // Call the logic method in UserLogin
                userLoginLogic.performLogin(email, password);
                // Clear password field after attempt
                passwordField.setText("");
            }
        });

        goToRegisterButton.addActionListener(e -> cardLayout.show(mainPanel, "register"));

        goToAdminLoginButton.addActionListener(e -> {
            new BaseLogin.ManagementLogin().setVisible(true);
            // Consider closing this window: dispose();
        });
        // --- End Event Listeners ---

        return panel;
    }

    private JPanel createRegisterPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel registerLabel = new JLabel("Register New User");
        registerLabel.setFont(new Font("Arial", Font.BOLD, 28));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(registerLabel, gbc);

        // ... (rest of the register panel components: regEmailLabel, regEmailField, etc...) ...
        JLabel regEmailLabel = new JLabel("Email:");
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        panel.add(regEmailLabel, gbc);

        regEmailField = new JTextField();
        regEmailField.setPreferredSize(new Dimension(300, 35));
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(regEmailField, gbc);

        JLabel regPasswordLabel = new JLabel("Password (min 6 chars):");
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(regPasswordLabel, gbc);

        regPasswordField = new JPasswordField();
        regPasswordField.setPreferredSize(new Dimension(300, 35));
        gbc.gridx = 1; gbc.gridy = 2;
        panel.add(regPasswordField, gbc);

        JLabel userTypeLabel = new JLabel("User Type:");
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(userTypeLabel, gbc);

        userTypeComboBox = new JComboBox<>(UserLogin.UserType.values());
        userTypeComboBox.setPreferredSize(new Dimension(300, 35));
        gbc.gridx = 1; gbc.gridy = 3;
        panel.add(userTypeComboBox, gbc);
        // ---

        JButton registerButton = new JButton("Register");
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        panel.add(registerButton, gbc);

        JButton backToLoginButton = new JButton("Back to Login");
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
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
                    JOptionPane.showMessageDialog(UserLoginGUI.this, "Please enter a valid email address.",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (password.length() < 6) {
                    JOptionPane.showMessageDialog(UserLoginGUI.this, "Password must be at least 6 characters long.",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (selectedType == null) {
                    JOptionPane.showMessageDialog(UserLoginGUI.this, "Please select a user type.",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Call the logic method in UserLogin
                userLoginLogic.performRegistration(email, password, selectedType);
                // Clear password field after attempt
                regPasswordField.setText("");
            }
        });

        backToLoginButton.addActionListener(e -> cardLayout.show(mainPanel, "login"));
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