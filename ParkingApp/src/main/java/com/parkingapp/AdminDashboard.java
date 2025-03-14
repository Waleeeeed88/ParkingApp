package com.parkingapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDashboard extends JFrame {
    private JButton openParkingServicesButton, logoutButton, createAdminButton, viewAdminAccountsButton;
    private ParkingServices parkingServices;
    private AdminAccountPrototype adminPrototype;
    private static final String CSV_FILE = "admin_accounts.csv";

    public AdminDashboard(ParkingServices parkingServices, AdminAccountPrototype adminPrototype) {
        this.parkingServices = parkingServices;
        this.adminPrototype = adminPrototype;

        setTitle("Admin Dashboard");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel dashboardLabel = new JLabel("Admin Dashboard");
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

        viewAdminAccountsButton = new JButton("View Generated Accounts");
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
        createAdminButton.addActionListener(e -> createAdminAccount());
        viewAdminAccountsButton.addActionListener(e -> viewGeneratedAccounts());
        logoutButton.addActionListener(e -> logout());

        setVisible(true);
    }

    private void openParkingServices() {
        new AdminParkingServices();
    }

    private void createAdminAccount() {
        JTextField userIdField = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(10);

        JPanel inputPanel = new JPanel(new GridLayout(0, 1));
        inputPanel.add(new JLabel("User ID:"));
        inputPanel.add(userIdField);
        inputPanel.add(new JLabel("Password:"));
        inputPanel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(this, inputPanel,
                "Create Admin Account", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String userId = userIdField.getText();
            String password = new String(passwordField.getPassword());

            if (userId.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "User ID and password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            AdminAccount newAdmin = adminPrototype.clone();
            newAdmin.setUserId(userId);
            newAdmin.setPassword(password);

            AdminLogin.addAdminAccount(userId, password);
            saveAdminAccountToCSV(userId, password);

            JOptionPane.showMessageDialog(this, "Admin account created for User ID: " + userId);
        }
    }

    private void saveAdminAccountToCSV(String userId, String password) {
        try (FileWriter writer = new FileWriter(CSV_FILE, true)) {
            writer.append(userId).append(",").append(password).append("\n");
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
            JOptionPane.showMessageDialog(this, "No generated accounts found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (accounts.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No admin accounts available.");
        } else {
            JOptionPane.showMessageDialog(this, String.join("\n", accounts), "Generated Admin Accounts", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void logout() {
        dispose(); // Close current dashboard window
        SwingUtilities.invokeLater(() -> new AdminLogin().setVisible(true)); // Open login panel again
    }

    public static void main(String[] args) {
        ParkingServices parkingServices = new ParkingServices();
        AdminAccount prototypeAdmin = new AdminAccount("defaultAdmin", "defaultPassword");

        SwingUtilities.invokeLater(() -> new AdminDashboard(parkingServices, prototypeAdmin).setVisible(true));
    }
}
interface AdminAccountPrototype extends Cloneable {
    AdminAccount clone();
    void setUserId(String userId);
    void setPassword(String password);
}

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