package com.parkingapp.GUI;

import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import com.parkingapp.AdminParkingServices;
import com.parkingapp.SuperAdminDashboard;
import com.parkingapp.parkingObjects.ParkingServices;
import services.FirebaseInitialization;

import javax.swing.*;
import java.awt.*;
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

        // Create main panel with GridBagLayout.
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        // User ID Label & Field
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("User ID:"), gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        userIdField = new JTextField(15);
        panel.add(userIdField, gbc);

        // Password Label & Field
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Password:"), gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        passwordField = new JPasswordField(15);
        panel.add(passwordField, gbc);

        // Login Button
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        loginButton = new JButton("Login");
        panel.add(loginButton, gbc);

        // Back Button
        gbc.gridy = 4;
        backButton = new JButton("Back");
        panel.add(backButton, gbc);

        backButton.addActionListener(e -> goBackToMain());
        add(panel);
    }

    protected abstract void authenticate();

    private void goBackToMain() {
        dispose();
        new ManagementLogin().setVisible(true);
    }

    // ------------------------------------------------------------------
    // Inner Class: ManagementLogin – login type selection screen.
    // ------------------------------------------------------------------
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

            JLabel selectLabel = new JLabel("Select Login Type");
            selectLabel.setFont(new Font("Arial", Font.BOLD, 20));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            panel.add(selectLabel, gbc);

            adminLoginButton = new JButton("Admin Login");
            superManagerLoginButton = new JButton("Super Manager Login");
            exitButton = new JButton("Exit");

            gbc.gridwidth = 2;
            gbc.gridx = 0;
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

        // Factory class to create the appropriate login screen.
        public static class LoginFactory {
            public static JFrame createLogin(String userType) {
                if ("Admin".equalsIgnoreCase(userType)) {
                    return new AdminLogin();
                } else if ("SuperManager".equalsIgnoreCase(userType)) {
                    return new SuperManagerLogin();
                }
                return null;
            }
        }
    }

    // ------------------------------------------------------------------
    // Inner Class: SuperManagerLogin – for super managers.
    // ------------------------------------------------------------------
    public static class SuperManagerLogin extends BaseLogin {
        private static final String SUPER_MANAGER_ID = "superadmin";
        private static final String SUPER_MANAGER_PASSWORD = "superpassword";

        public SuperManagerLogin() {
            super("Super Manager Login");
            loginButton.addActionListener(e -> authenticate());
        }

        @Override
        protected void authenticate() {
            String userId = userIdField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            if (SUPER_MANAGER_ID.equals(userId) && SUPER_MANAGER_PASSWORD.equals(password)) {
                JOptionPane.showMessageDialog(this, "Super Manager Login Successful!");
                dispose();
                // Launch the GUI version of the Super Admin Dashboard.
                new com.parkingapp.GUI.SuperAdminDashboardGUI(
                        new ParkingServices(),
                        new SuperAdminDashboard.AdminAccount("defaultAdmin", "defaultPassword"),
                        true
                ).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // ------------------------------------------------------------------
    // Inner Class: AdminLogin – for regular admins.
    // ------------------------------------------------------------------
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
            Firestore db = FirebaseInitialization.getInstance();
            try {
                QuerySnapshot snapshot = db.collection("admin_accounts").get().get();
                for (QueryDocumentSnapshot document : snapshot.getDocuments()) {
                    String storedUser = document.getString("admin_user");
                    String storedPassword = document.getString("admin_password");
                    if (storedUser != null && storedPassword != null &&
                            storedUser.equals(userId) && storedPassword.equals(password)) {
                        return true;
                    }
                }
            } catch (InterruptedException | ExecutionException e) {
                JOptionPane.showMessageDialog(this, "Error connecting to database.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            return false;
        }
    }

    // ------------------------------------------------------------------
    // Inner Class: AdminManagementPanel – for admin post-login management.
    // ------------------------------------------------------------------
    public static class AdminManagementPanel extends JFrame {
        private JButton openParkingServicesButton, logoutButton;

        public AdminManagementPanel() {
            setTitle("Admin Management Panel");
            setSize(400, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.fill = GridBagConstraints.HORIZONTAL;

            JLabel titleLabel = new JLabel("Admin Management Panel - Manage Parking Lots");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            panel.add(titleLabel, gbc);

            openParkingServicesButton = new JButton("Open Parking Lot and Space Management Services");
            gbc.gridy = 1;
            panel.add(openParkingServicesButton, gbc);

            logoutButton = new JButton("Logout");
            gbc.gridy = 2;
            panel.add(logoutButton, gbc);

            openParkingServicesButton.addActionListener(e -> openParkingServices());
            logoutButton.addActionListener(e -> logout());

            add(panel);
            setVisible(true);
        }

        private void openParkingServices() {
            dispose();
            new AdminParkingServices(false);
        }

        private void logout() {
            dispose();
            SwingUtilities.invokeLater(() -> new ManagementLogin().setVisible(true));
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> new AdminManagementPanel().setVisible(true));
        }
    }
}

