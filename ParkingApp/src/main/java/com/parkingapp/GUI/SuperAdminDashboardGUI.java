package com.parkingapp.GUI;

import com.parkingapp.SuperAdminDashboard;
import com.parkingapp.SuperAdminDashboard.AdminAccount;
import com.parkingapp.SuperAdminDashboard.AdminAccountPrototype;
import com.parkingapp.parkingObjects.ParkingServices;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class SuperAdminDashboardGUI extends JFrame {
    private boolean isSuperManager;
    private JButton openParkingServicesButton, logoutButton, createAdminButton, viewAdminAccountsButton;
    private ParkingServices parkingServices;
    private AdminAccountPrototype adminPrototype;

    // Instance of the logic provider from the original SuperAdminDashboard file
    private SuperAdminDashboard logic;

    public SuperAdminDashboardGUI(ParkingServices parkingServices, AdminAccountPrototype adminPrototype, boolean isSuperManager) {
        this.parkingServices = parkingServices;
        this.adminPrototype = adminPrototype;
        this.isSuperManager = isSuperManager;
        // Instantiate the logic object.
        logic = new SuperAdminDashboard();

        setTitle("Super Manager Dashboard - Oversee Admin Accounts and Parking Lot Management");
        setSize(650, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        addEventHandlers();
        setVisible(true);
    }

    private void initComponents() {
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
    }

    private void addEventHandlers() {
        openParkingServicesButton.addActionListener(e -> openParkingServices());
        createAdminButton.addActionListener(e -> generateAdminAccount());
        viewAdminAccountsButton.addActionListener(e -> viewGeneratedAccounts());
        logoutButton.addActionListener(e -> logout());
    }

    // Opens the parking services dashboard.
    private void openParkingServices() {
        dispose();
        // Assuming AdminParkingServices is the GUI for parking management.
        new com.parkingapp.GUI.AdminParkingServices(true);
    }

    // Gathers input from the user, uses the logic class to generate and save an admin account.
    private void generateAdminAccount() {
        JTextField prefixField = new JTextField(10);
        JPanel inputPanel = new JPanel(new GridLayout(0, 1));
        inputPanel.add(new JLabel("Enter username prefix (e.g., 'admin'):"));
        inputPanel.add(prefixField);

        int result = JOptionPane.showConfirmDialog(
                this,
                inputPanel,
                "Generate Admin Account",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            String prefix = prefixField.getText().trim().toLowerCase();
            if (prefix.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Prefix cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                AdminAccount newAdmin = (AdminAccount) logic.generateAdminAccount(prefix, adminPrototype);
                logic.saveAdminAccountToFirebase(newAdmin);
                JOptionPane.showMessageDialog(this,
                        "Admin account created!\nUsername: " + newAdmin.getUserId() +
                                "\nPassword: " + newAdmin.getPassword());
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (InterruptedException | ExecutionException ex) {
                JOptionPane.showMessageDialog(this, "Error saving admin account.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Retrieves and displays admin account information.
    private void viewGeneratedAccounts() {
        try {
            List<String> accounts = logic.fetchAdminAccounts();
            if (accounts.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No admin accounts available.");
            } else {
                JOptionPane.showMessageDialog(this, String.join("\n", accounts), "Admin Accounts", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (InterruptedException | ExecutionException ex) {
            JOptionPane.showMessageDialog(this, "Error fetching admin accounts.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Logs out by returning to the management login screen.
    private void logout() {
        dispose();
        SwingUtilities.invokeLater(() -> new com.parkingapp.GUI.BaseLogin.ManagementLogin().setVisible(true));
    }
}
