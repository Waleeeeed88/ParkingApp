package com.parkingapp.GUI;

import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
// Assuming FirebaseInitialization provides Firestore instance correctly
// import com.google.firebase.cloud.FirestoreClient; // Original import - check if needed
import services.FirebaseInitialization; // Assuming this path is correct
import com.parkingapp.SuperAdminDashboard; // Needed for AdminAccountPrototype instantiation
import com.parkingapp.parkingObjects.ParkingServices; // Needed for instantiation

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ExecutionException;

public abstract class BaseLogin extends JFrame {

    // --- Styling Constants (Consistent with SuperAdminDashboardGUI) ---
    protected static final Color BACKGROUND_COLOR = new Color(248, 249, 250);
    protected static final Color PRIMARY_COLOR = new Color(0, 123, 255);
    protected static final Color PRIMARY_DARKER = new Color(0, 105, 217);
    protected static final Color SECONDARY_COLOR = new Color(108, 117, 125); // Gray for back/secondary
    protected static final Color SECONDARY_DARKER = new Color(84, 92, 99);
    protected static final Color DANGER_COLOR = new Color(220, 53, 69); // Red for exit
    protected static final Color DANGER_DARKER = new Color(187, 38, 53);
    protected static final Color TEXT_COLOR = new Color(33, 37, 41);
    protected static final Color BORDER_COLOR = new Color(222, 226, 230);
    protected static final Font TITLE_FONT = new Font("Arial", Font.BOLD, 24); // Adjusted size for login screens
    protected static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 14);
    protected static final Font LABEL_FONT = new Font("Arial", Font.PLAIN, 14);
    protected static final Dimension FIELD_SIZE = new Dimension(200, 36); // Input field size
    protected static final Dimension BUTTON_SIZE = new Dimension(180, 42); // Button size for login screens

    // --- UI Components ---
    protected JTextField userIdField;
    protected JPasswordField passwordField;
    protected JButton loginButton, backButton;
    protected JPanel mainPanel; // Make mainPanel accessible to subclasses if needed

    public BaseLogin(String title) {
        setTitle(title);
        setSize(550, 350); // Adjusted size
        setMinimumSize(new Dimension(450, 300));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // --- Main Panel Setup ---
        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(new EmptyBorder(25, 30, 25, 30)); // Padding
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Spacing
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0; // Allow horizontal expansion

        // --- Title ---
        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(TITLE_FONT);
        titleLabel.setForeground(TEXT_COLOR);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 20, 10); // Bottom spacing for title
        mainPanel.add(titleLabel, gbc);

        // Reset constraints
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END; // Align labels to the right
        gbc.insets = new Insets(8, 10, 8, 10);

        // --- User ID Label & Field ---
        JLabel userIdLabel = new JLabel("User ID:");
        userIdLabel.setFont(LABEL_FONT);
        userIdLabel.setForeground(TEXT_COLOR);
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(userIdLabel, gbc);

        userIdField = new JTextField(15);
        userIdField.setFont(LABEL_FONT);
        userIdField.setPreferredSize(FIELD_SIZE);
        userIdField.setBorder(createStyledBorder()); // Apply styled border
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START; // Align field to the left
        mainPanel.add(userIdField, gbc);

        // --- Password Label & Field ---
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(LABEL_FONT);
        passwordLabel.setForeground(TEXT_COLOR);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        mainPanel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(15);
        passwordField.setFont(LABEL_FONT);
        passwordField.setPreferredSize(FIELD_SIZE);
        passwordField.setBorder(createStyledBorder()); // Apply styled border
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        mainPanel.add(passwordField, gbc);

        // --- Buttons ---
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // Span both columns
        gbc.anchor = GridBagConstraints.CENTER; // Center buttons
        gbc.insets = new Insets(15, 10, 8, 10); // Adjust spacing around buttons

        loginButton = createStyledButton("🔑 Login", PRIMARY_COLOR, PRIMARY_DARKER);
        mainPanel.add(loginButton, gbc);

        gbc.gridy = 4;
        gbc.insets = new Insets(8, 10, 10, 10);
        backButton = createStyledButton("⬅️ Back", SECONDARY_COLOR, SECONDARY_DARKER);
        mainPanel.add(backButton, gbc);

        backButton.addActionListener(e -> goBackToMain());
        add(mainPanel);
    }

    /** Abstract method for authentication logic in subclasses. */
    protected abstract void authenticate();

    /** Navigates back to the ManagementLogin screen. */
    private void goBackToMain() {
        dispose();
        // Ensure the new ManagementLogin instance is also styled
        SwingUtilities.invokeLater(() -> new ManagementLogin().setVisible(true));
    }

    /** Helper method to create a styled border for input fields. */
    protected static javax.swing.border.Border createStyledBorder() {
        return BorderFactory.createCompoundBorder(
                new LineBorder(BORDER_COLOR, 1),
                new EmptyBorder(5, 8, 5, 8) // Padding inside the field
        );
    }

    /** Helper method to create consistently styled buttons. */
    protected static JButton createStyledButton(String text, Color bgColor, Color hoverBgColor) {
        JButton button = new JButton(text);
        button.setFont(BUTTON_FONT);
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setPreferredSize(BUTTON_SIZE);
        button.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(bgColor.darker(), 1),
                new EmptyBorder(8, 15, 8, 15) // Padding inside button
        ));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(hoverBgColor);
                button.setBorder(BorderFactory.createCompoundBorder(
                        new LineBorder(hoverBgColor.darker(), 1),
                        new EmptyBorder(8, 15, 8, 15)
                ));
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                button.setBackground(bgColor);
                button.setBorder(BorderFactory.createCompoundBorder(
                        new LineBorder(bgColor.darker(), 1),
                        new EmptyBorder(8, 15, 8, 15)
                ));
            }
        });
        return button;
    }

    // --- Helper Methods for Dialogs (Can be used by subclasses) ---
    protected void showErrorDialog(String message) {
        // Customize JOptionPane appearance slightly
        UIManager.put("OptionPane.background", BACKGROUND_COLOR);
        UIManager.put("Panel.background", BACKGROUND_COLOR);
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    protected void showInfoDialog(String message, String title) {
        UIManager.put("OptionPane.background", BACKGROUND_COLOR);
        UIManager.put("Panel.background", BACKGROUND_COLOR);
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
    }


    // ==================================================================
    // Inner Class: ManagementLogin – login type selection screen.
    // ==================================================================
    public static class ManagementLogin extends JFrame {
        private JButton adminLoginButton, superManagerLoginButton, exitButton;

        public ManagementLogin() {
            setTitle("Parking Management Login");
            setSize(450, 300); // Adjusted size
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel(new GridBagLayout());
            panel.setBackground(BACKGROUND_COLOR); // Apply background
            panel.setBorder(new EmptyBorder(20, 25, 20, 25)); // Apply padding
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.weightx = 1.0; // Allow horizontal expansion

            JLabel selectLabel = new JLabel("Select Login Type", SwingConstants.CENTER);
            selectLabel.setFont(TITLE_FONT); // Apply title font
            selectLabel.setForeground(TEXT_COLOR); // Apply text color
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.insets = new Insets(10, 10, 20, 10); // Bottom spacing
            panel.add(selectLabel, gbc);

            // Use the static helper from BaseLogin to style buttons
            adminLoginButton = BaseLogin.createStyledButton("👤 Admin Login", PRIMARY_COLOR, PRIMARY_DARKER);
            superManagerLoginButton = BaseLogin.createStyledButton("👑 Super Manager Login", PRIMARY_COLOR, PRIMARY_DARKER);
            exitButton = BaseLogin.createStyledButton("❌ Exit", DANGER_COLOR, DANGER_DARKER); // Use danger color for exit

            gbc.gridwidth = 2; // Buttons span full width
            gbc.gridx = 0;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.insets = new Insets(8, 10, 8, 10); // Reset insets

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
            // setVisible(true); // Visibility set by caller
        }

        private void openLogin(String userType) {
            dispose();
            JFrame loginFrame = LoginFactory.createLogin(userType);
            if (loginFrame != null) {
                loginFrame.setVisible(true);
            } else {
                // Handle case where factory returns null (optional)
                JOptionPane.showMessageDialog(null, "Could not create login screen for type: " + userType,
                        "Error", JOptionPane.ERROR_MESSAGE);
                // Re-open management login potentially
                SwingUtilities.invokeLater(() -> new ManagementLogin().setVisible(true));
            }
        }

        // --- Factory class to create the appropriate login screen ---
        // No visual styling needed here, it just creates instances.
        public static class LoginFactory {
            public static JFrame createLogin(String userType) {
                if ("Admin".equalsIgnoreCase(userType)) {
                    return new AdminLogin();
                } else if ("SuperManager".equalsIgnoreCase(userType)) {
                    return new SuperManagerLogin();
                }
                return null; // Indicates failure or unknown type
            }
        }
    }

    // ==================================================================
    // Inner Class: SuperManagerLogin – for super managers.
    // ==================================================================
    public static class SuperManagerLogin extends BaseLogin {
        // Hardcoded credentials - Consider a more secure approach for production
        private static final String SUPER_MANAGER_ID = "superadmin";
        private static final String SUPER_MANAGER_PASSWORD = "superpassword";

        public SuperManagerLogin() {
            super("Super Manager Login"); // Title passed to BaseLogin constructor
            // Action listener for the login button inherited from BaseLogin
            loginButton.addActionListener(e -> authenticate());
        }

        @Override
        protected void authenticate() {
            String userId = userIdField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            if (SUPER_MANAGER_ID.equals(userId) && SUPER_MANAGER_PASSWORD.equals(password)) {
                showInfoDialog("Super Manager Login Successful!", "Success"); // Use styled dialog
                dispose();
                // Launch the styled Super Admin Dashboard GUI.
                // Ensure constructor arguments are valid. Using defaults/placeholders here.
                SwingUtilities.invokeLater(() -> new com.parkingapp.GUI.SuperAdminDashboardGUI(
                        new ParkingServices(), // Provide actual instance if needed
                        new SuperAdminDashboard.AdminAccount("placeholder", "placeholder"), // Provide actual prototype
                        true // isSuperManager flag
                ).setVisible(true));
            } else {
                showErrorDialog("Invalid User ID or Password."); // Use styled dialog
                passwordField.setText(""); // Clear password field on failure
                userIdField.requestFocus(); // Focus user ID field
            }
        }
    }

    // ==================================================================
    // Inner Class: AdminLogin – for regular admins.
    // ==================================================================
    public static class AdminLogin extends BaseLogin {
        public AdminLogin() {
            super("Admin Login"); // Title passed to BaseLogin constructor
            loginButton.addActionListener(e -> authenticate());
        }

        @Override
        protected void authenticate() {
            String userId = userIdField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            if (userId.isEmpty() || password.isEmpty()) {
                showErrorDialog("User ID and Password cannot be empty.");
                return;
            }

            // Perform Firebase authentication
            if (verifyAdminCredentials(userId, password)) {
                showInfoDialog("Admin Login Successful!", "Success");
                dispose();
                // Launch the styled Admin Management Panel
                SwingUtilities.invokeLater(() -> new AdminManagementPanel().setVisible(true));
            } else {
                showErrorDialog("Invalid User ID or Password.");
                passwordField.setText("");
                userIdField.requestFocus();
            }
        }

        /** Verifies admin credentials against Firestore database. */
        private boolean verifyAdminCredentials(String userId, String password) {
            try {
                Firestore db = FirebaseInitialization.getInstance(); // Get Firestore instance
                // Query the 'admin_accounts' collection
                QuerySnapshot snapshot = db.collection("admin_accounts")
                        .whereEqualTo("admin_user", userId) // Query by user ID first
                        .limit(1) // We only expect one match
                        .get()
                        .get(); // Synchronous get

                if (snapshot.isEmpty()) {
                    System.out.println("No admin found with ID: " + userId);
                    return false; // No user found
                }

                // Should only be one document due to limit(1)
                for (QueryDocumentSnapshot document : snapshot.getDocuments()) {
                    String storedPassword = document.getString("admin_password");
                    // Compare the provided password with the stored password
                    if (storedPassword != null && storedPassword.equals(password)) {
                        System.out.println("Password match for user: " + userId);
                        return true; // Credentials match
                    } else {
                        System.out.println("Password mismatch for user: " + userId);
                        return false; // Password doesn't match
                    }
                }
            } catch (InterruptedException | ExecutionException e) {
                showErrorDialog("Database Error: Could not verify credentials.\n" + e.getMessage());
                e.printStackTrace(); // Log the full error
            } catch (Exception e) {
                // Catch any other unexpected errors during Firebase interaction
                showErrorDialog("An unexpected error occurred during authentication.\n" + e.getMessage());
                e.printStackTrace();
            }
            return false; // Default to false if any error occurs or no match
        }
    }

    // ==================================================================
    // Inner Class: AdminManagementPanel – for admin post-login management.
    // ==================================================================
    public static class AdminManagementPanel extends JFrame {
        private JButton openParkingServicesButton, logoutButton;

        public AdminManagementPanel() {
            setTitle("Admin Management Panel");
            setSize(500, 250); // Adjusted size
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel(new GridBagLayout());
            panel.setBackground(BACKGROUND_COLOR); // Apply background
            panel.setBorder(new EmptyBorder(20, 25, 20, 25)); // Apply padding
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.weightx = 1.0;

            JLabel titleLabel = new JLabel("Admin Panel - Manage Parking", SwingConstants.CENTER);
            titleLabel.setFont(TITLE_FONT); // Apply title font
            titleLabel.setForeground(TEXT_COLOR); // Apply text color
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.insets = new Insets(10, 10, 20, 10); // Bottom spacing
            panel.add(titleLabel, gbc);

            // Style buttons using the helper method
            openParkingServicesButton = BaseLogin.createStyledButton("🅿️ Manage Parking Lots", PRIMARY_COLOR, PRIMARY_DARKER);
            logoutButton = BaseLogin.createStyledButton("🚪 Logout", DANGER_COLOR, DANGER_DARKER); // Use danger color

            gbc.gridwidth = 2; // Buttons span full width
            gbc.gridx = 0;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.insets = new Insets(8, 10, 8, 10); // Reset insets

            gbc.gridy = 1;
            panel.add(openParkingServicesButton, gbc);

            gbc.gridy = 2;
            panel.add(logoutButton, gbc);

            openParkingServicesButton.addActionListener(e -> openParkingServices());
            logoutButton.addActionListener(e -> logout());

            add(panel);
            // setVisible(true); // Visibility usually handled by caller
        }

        private void openParkingServices() {
            dispose();
            // Assuming AdminParkingServices GUI exists and is styled separately or needs styling
            SwingUtilities.invokeLater(() -> new AdminParkingServices(false).setVisible(true)); // Pass false for regular admin
        }

        private void logout() {
            dispose();
            // Go back to the styled ManagementLogin screen
            SwingUtilities.invokeLater(() -> new ManagementLogin().setVisible(true));
        }

        // Main method likely for testing this panel directly
        public static void main(String[] args) {
            // Ensure Look and Feel is set early if needed, e.g., for anti-aliasing
            // try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception e) { e.printStackTrace(); }
            SwingUtilities.invokeLater(() -> new AdminManagementPanel().setVisible(true));
        }
    }

    // Main method to launch the initial Management Login screen (optional)
    public static void main(String[] args) {
        // Set Look and Feel for better rendering (optional, but recommended)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> new ManagementLogin().setVisible(true));
    }
}


