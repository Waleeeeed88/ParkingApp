package com.parkingapp;

import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import com.parkingapp.parkingObjects.ParkingServices;

import services.FirebaseInitialization;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public abstract class BaseLogin extends JFrame {
    protected JTextField userIdField;
    protected JPasswordField passwordField;
    protected JButton loginButton, backButton;

    public BaseLogin(String title) {
        setTitle(title);
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel loginLabel = new JLabel(title);
        loginLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(loginLabel, gbc);

        userIdField = new JTextField();
        passwordField = new JPasswordField();
        userIdField.setPreferredSize(new Dimension(150, 30));
        passwordField.setPreferredSize(new Dimension(150, 30));

        // User ID Label
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("User ID:"), gbc);

        // User ID Field
        userIdField = new JTextField();
        userIdField.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(userIdField, gbc);

        // Password Label
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Password:"), gbc);

        // Password Field
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(150, 30));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(passwordField, gbc);

        loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(loginButton, gbc);

        backButton = new JButton("Back");
        gbc.gridy = 4;
        panel.add(backButton, gbc);

        backButton.addActionListener(e -> goBackToMain());

        add(panel);
    }

    protected abstract void authenticate();

    private void goBackToMain() {
        dispose();
        new ManagementLogin().setVisible(true);
    }

    public static class ManagementLogin extends JFrame {
        private JButton adminLoginButton, superManagerLoginButton, exitButton;

        public ManagementLogin() {
            setTitle("Parking Management Login");
            setSize(400, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.fill = GridBagConstraints.HORIZONTAL;

            JLabel loginLabel = new JLabel("Select Login Type");
            loginLabel.setFont(new Font("Arial", Font.BOLD, 20));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            panel.add(loginLabel, gbc);

            adminLoginButton = new JButton("Admin Login");
            superManagerLoginButton = new JButton("Super Manager Login");
            exitButton = new JButton("Exit");

            gbc.gridy = 1;
            panel.add(adminLoginButton, gbc);

            gbc.gridy = 2;
            panel.add(superManagerLoginButton, gbc);

            gbc.gridy = 3;
            panel.add(exitButton, gbc);

            adminLoginButton.addActionListener(e -> openLogin("Admin"));
            superManagerLoginButton.addActionListener(e -> openLogin("SuperManager"));
            exitButton.addActionListener(e -> System.exit(0));

            add(panel);
            setVisible(true);
        }

        private void openLogin(String userType) {
            dispose();
            JFrame loginFrame = LoginFactory.createLogin(userType);
            if (loginFrame != null) {
                loginFrame.setVisible(true);
            }
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(ManagementLogin::new);
        }

        public static class SuperManagerLogin extends BaseLogin {
            private static final String SUPER_MANAGER_ID = "superadmin";
            private static final String SUPER_MANAGER_PASSWORD = "superpassword";

            public SuperManagerLogin() {
                super("Super Manager Login");
                loginButton.addActionListener(e -> authenticate());
            }

            @Override
            protected void authenticate() {
                String userId = userIdField.getText();
                String password = new String(passwordField.getPassword());

                if (SUPER_MANAGER_ID.equals(userId) && SUPER_MANAGER_PASSWORD.equals(password)) {
                    JOptionPane.showMessageDialog(this, "Super Manager Login Successful!");
                    dispose();
                    new SuperAdminDashboard(new ParkingServices(), new SuperAdminDashboard.AdminAccount("defaultAdmin", "defaultPassword"), true).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Credentials", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        public static class AdminLogin extends BaseLogin {
            public AdminLogin() {
                super("Admin Login");
                loginButton.addActionListener(e -> authenticate());
            }

            @Override
            protected void authenticate() {
                String userId = userIdField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();

                if (userId.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Fields cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (verifyAdminCredentials(userId, password)) {
                    JOptionPane.showMessageDialog(this, "Admin Login Successful!");
                    dispose();
                    new AdminManagementPanel().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Credentials", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            private boolean verifyAdminCredentials(String userId, String password) {
                Firestore db = FirebaseInitialization.getInstance();	//instance held in database


                try {
                    QuerySnapshot snapshot = db.collection("admin_accounts").get().get();
                    for (QueryDocumentSnapshot document : snapshot) {
                        String storedUser = document.getString("admin_user");
                        String storedPassword = document.getString("admin_password");

                        if (storedUser != null && storedPassword != null) {
                            if (storedUser.equals(userId) && storedPassword.equals(password)) {
                                return true;
                            }
                        }
                    }
                } catch (InterruptedException | ExecutionException e) {
                    JOptionPane.showMessageDialog(this, "Error connecting to database.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                return false;
            }
        }


        public static class LoginFactory {
            public static JFrame createLogin(String userType) {
                if (userType.equalsIgnoreCase("Admin")) {
                    return new BaseLogin.ManagementLogin.AdminLogin();
                } else if (userType.equalsIgnoreCase("SuperManager")) {
                    return new SuperManagerLogin();
                }
                return null;
            }
        }
    }

    // Code for the regular admin account generated by super manager
    public static class AdminManagementPanel extends JFrame {
        private JButton openParkingServicesButton, logoutButton;  // Only responsible for parking services

        public AdminManagementPanel() {

            // Code for Swing UI
            setTitle("Admin Management Panel");
            setSize(400, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.fill = GridBagConstraints.HORIZONTAL;

            // Title
            panel.add(new JLabel("Admin Management Panel - Manage Parking Lots"));

            add(panel);
            setVisible(true);

            openParkingServicesButton = new JButton("Open Parking Lot and Space Management Services");
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 2;
            panel.add(openParkingServicesButton, gbc);

            logoutButton = new JButton("Logout");
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 2;
            panel.add(logoutButton, gbc);

            add(panel);

            // Action listeners that program the buttom to call method
            openParkingServicesButton.addActionListener(e -> openParkingServices());
            logoutButton.addActionListener(e -> logout());

            setVisible(true);
        }

        // Opens Admin Parking Services class (set to false for is super manager as this is just a regular admin)
        private void openParkingServices() {
            dispose();
            new AdminParkingServices(false);
        }

        // Standard logout method, returns back to admin login
        private void logout() {
            dispose(); // Close current dashboard window
            SwingUtilities.invokeLater(() -> new BaseLogin.ManagementLogin().setVisible(true)); // Open login panel again
        }

        // Main Method
        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> new AdminManagementPanel().setVisible(true));
        }
    }
}

