package com.parkingapp;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import services.FirebaseInitialization;

import javax.swing.*;
import java.awt.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class AdminDashboard extends JFrame {
    private boolean isSuperManager;
    private JButton openParkingServicesButton, logoutButton, createAdminButton, viewAdminAccountsButton;
    private ParkingServices parkingServices;
    private AdminAccountPrototype adminPrototype;
    private static final String COLLECTION_NAME = "admin_accounts";

    public AdminDashboard(ParkingServices parkingServices, AdminAccountPrototype adminPrototype, boolean isSuperManager) {
        this.parkingServices = parkingServices;
        this.adminPrototype = adminPrototype;
        this.isSuperManager = isSuperManager;

        setTitle("Super Manager Dashboard - Oversee Admin Accounts and Parking Lot Management");
        setSize(650, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel dashboardLabel = new JLabel("Super Manager Dashboard");
        dashboardLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(dashboardLabel, gbc);

        openParkingServicesButton = new JButton("Open Parking Lot and Space Management Services");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(openParkingServicesButton, gbc);

        createAdminButton = new JButton("Auto-Generate Admin Accounts");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(createAdminButton, gbc);

        viewAdminAccountsButton = new JButton("View Admin Accounts");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panel.add(viewAdminAccountsButton, gbc);

        logoutButton = new JButton("Logout");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(logoutButton, gbc);

        add(panel);

        openParkingServicesButton.addActionListener(e -> openParkingServices());
        createAdminButton.addActionListener(e -> generateAdminAccount());
        viewAdminAccountsButton.addActionListener(e -> viewGeneratedAccounts());
        logoutButton.addActionListener(e -> logout());

        setVisible(true);
    }

    private void openParkingServices() {
        dispose();
        new AdminParkingServices(isSuperManager);
    }

    private void generateAdminAccount() {
        JTextField prefixField = new JTextField(10);

        JPanel inputPanel = new JPanel(new GridLayout(0, 1));
        inputPanel.add(new JLabel("Enter username prefix (e.g., 'admin'):"));
        inputPanel.add(prefixField);

        int result = JOptionPane.showConfirmDialog(this, inputPanel,
                "Generate Admin Account", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String prefix = prefixField.getText().trim().toLowerCase();

            if (prefix.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Prefix cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String uniqueUserId = prefix + "yups";
            String generatedPassword = generateSecurePassword(10);

            AdminAccount newAdmin = adminPrototype.clone();
            newAdmin.setUserId(uniqueUserId);
            newAdmin.setPassword(generatedPassword);

            saveAdminAccountToFirebase(newAdmin);
        }
    }

    private String generateSecurePassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*()-_?.";
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(chars.charAt(random.nextInt(chars.length())));
        }
        return password.toString();
    }

    private void saveAdminAccountToFirebase(AdminAccount adminAccount) {
        Firestore db = FirebaseInitialization.getInstance();	//instance held in database

        DocumentReference docRef = db.collection(COLLECTION_NAME).document(adminAccount.getUserId());

        // Create data map for Firestore
        AdminAccountData adminData = new AdminAccountData(adminAccount.getUserId(), adminAccount.getPassword());

        ApiFuture<WriteResult> result = docRef.set(adminData);

        try {
            result.get();  // Wait until Firestore operation completes
            JOptionPane.showMessageDialog(this,
                    "Admin account created!\nUsername: " + adminAccount.getUserId() +
                            "\nPassword: " + adminAccount.getPassword());
        } catch (InterruptedException | ExecutionException e) {
            JOptionPane.showMessageDialog(this, "Error saving admin account.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewGeneratedAccounts() {
        Firestore db = FirebaseInitialization.getInstance();	//instance held in database

        List<String> accounts = new ArrayList<>();
        try {
            ApiFuture<QuerySnapshot> future = db.collection(COLLECTION_NAME).get();
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            for (QueryDocumentSnapshot document : documents) {
                String username = document.getString("admin_user");
                String password = document.getString("admin_password");
                accounts.add("Username: " + username + ", Password: " + password);
            }
        } catch (InterruptedException | ExecutionException e) {
            JOptionPane.showMessageDialog(this, "Error fetching admin accounts.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (accounts.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No admin accounts available.");
        } else {
            JOptionPane.showMessageDialog(this, String.join("\n", accounts), "Admin Accounts", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void logout() {
        dispose();
        SwingUtilities.invokeLater(() -> new BaseLogin.ManagementLogin().setVisible(true));
    }

    // ---------------------------------
    // Admin Account Prototype Interface
    // ---------------------------------
    interface AdminAccountPrototype extends Cloneable {
        AdminAccount clone();
        void setUserId(String userId);
        void setPassword(String password);
    }

    // ---------------------------------
    // Admin Account Class (Prototype Pattern)
    // ---------------------------------
    static class AdminAccount implements AdminAccountPrototype {
        private String userId;
        private String password;

        public AdminAccount(String userId, String password) {
            this.userId = userId;
            this.password = password;
        }

        public AdminAccount(AdminAccount source) {
            this.userId = source.userId;
            this.password = source.password;
        }

        @Override
        public AdminAccount clone() {
            return new AdminAccount(this);
        }

        @Override
        public void setUserId(String userId) {
            this.userId = userId;
        }

        @Override
        public void setPassword(String password) {
            this.password = password;
        }

        public String getUserId() {
            return userId;
        }

        public String getPassword() {
            return password;
        }
    }

    // ---------------------------------
    // Data Transfer Object for Firestore
    // ---------------------------------
    static class AdminAccountData {
        private String admin_user;
        private String admin_password;

        public AdminAccountData(String admin_user, String admin_password) {
            this.admin_user = admin_user;
            this.admin_password = admin_password;
        }

        public String getAdmin_user() {
            return admin_user;
        }

        public String getAdmin_password() {
            return admin_password;
        }
    }
}
