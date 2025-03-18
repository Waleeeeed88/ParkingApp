package com.parkingapp;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class AdminDashboard extends JFrame {
    private boolean isSuperManager;
    private JButton openParkingServicesButton, logoutButton, createAdminButton, viewAdminAccountsButton;
    private ParkingServices parkingServices;
    private AdminAccountPrototype adminPrototype;
    private static final String CSV_FILE = "admin_accounts.csv";

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
            String prefix = prefixField.getText().trim().toLowerCase(); // Convert to lowercase

            if (prefix.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Prefix cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Generate username using prefix + "yups" (all lowercase)
            String uniqueUserId = prefix + "yups";
            String generatedPassword = generateSecurePassword(10); // Generate 16-character strong password

            AdminAccount newAdmin = adminPrototype.clone();
            newAdmin.setUserId(uniqueUserId);
            newAdmin.setPassword(generatedPassword);

            saveAdminAccountToCSV(uniqueUserId, generatedPassword);
            JOptionPane.showMessageDialog(this, "Admin account created!\nUsername: " + uniqueUserId + "\nPassword: " + generatedPassword);
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

    private void saveAdminAccountToCSV(String userId, String password) {
        try (FileWriter writer = new FileWriter(CSV_FILE, true)) {
            writer.append(userId).append("; ").append(password).append("\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving admin account.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewGeneratedAccounts() {
        List<String> accounts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                accounts.add(line);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "No admin accounts found.", "Error", JOptionPane.ERROR_MESSAGE);
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

    public static void main(String[] args) {
        ParkingServices parkingServices = new ParkingServices();
        AdminAccount prototypeAdmin = new AdminAccount("defaultadmin", "defaultpassword");

        SwingUtilities.invokeLater(() -> new AdminDashboard(parkingServices, prototypeAdmin, true).setVisible(true));
    }
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
class AdminAccount implements AdminAccountPrototype {
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
}
