package com.parkingapp.GUI;

import com.parkingapp.SuperAdminDashboard;
import com.parkingapp.SuperAdminDashboard.AdminAccount;
import com.parkingapp.SuperAdminDashboard.AdminAccountPrototype;
import com.parkingapp.parkingObjects.ParkingServices; // Assuming this import is correct

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class SuperAdminDashboardGUI extends JFrame {

    // --- Constants for Styling ---
    private static final Color BACKGROUND_COLOR = new Color(248, 249, 250); // Slightly lighter gray
    private static final Color PRIMARY_COLOR = new Color(0, 123, 255); // Vibrant Blue
    private static final Color PRIMARY_DARKER = new Color(0, 105, 217); // Darker blue for borders/hover
    private static final Color SECONDARY_COLOR = new Color(108, 117, 125); // Gray
    private static final Color SECONDARY_DARKER = new Color(84, 92, 99);   // Darker gray
    private static final Color DANGER_COLOR = new Color(220, 53, 69);    // Red
    private static final Color DANGER_DARKER = new Color(187, 38, 53);   // Darker red
    private static final Color TEXT_COLOR = new Color(33, 37, 41);       // Dark text
    private static final Color BORDER_COLOR = new Color(222, 226, 230); // Lighter border for inputs
    private static final Font TITLE_FONT = new Font("Arial", Font.BOLD, 30); // Slightly larger title
    private static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 14);
    private static final Font LABEL_FONT = new Font("Arial", Font.PLAIN, 14);
    private static final Dimension BUTTON_SIZE = new Dimension(250, 48); // Slightly larger buttons

    // --- UI Components ---
    private JButton openParkingServicesButton, logoutButton, createAdminButton, viewAdminAccountsButton;
    private JPanel mainPanel;

    // --- Logic Dependencies ---
    private ParkingServices parkingServices;
    private AdminAccountPrototype adminPrototype;
    private SuperAdminDashboard logic;

    public SuperAdminDashboardGUI(ParkingServices parkingServices, AdminAccountPrototype adminPrototype, boolean isSuperManager) {
        this.parkingServices = parkingServices;
        this.adminPrototype = adminPrototype;
        this.logic = new SuperAdminDashboard();

        setTitle("Super Manager Dashboard");
        setSize(750, 400); // Adjusted size for better spacing with larger elements
        setMinimumSize(new Dimension(650, 350));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        addEventHandlers();

        setVisible(true);
    }

    private void initComponents() {
        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);
        // Increased padding for a more spacious feel
        mainPanel.setBorder(new EmptyBorder(30, 40, 30, 40));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Increased spacing between components
        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.weightx = 1.0; // Allow horizontal expansion

        // --- Title Label ---
        JLabel dashboardLabel = new JLabel("Super Manager Dashboard");
        dashboardLabel.setFont(TITLE_FONT);
        dashboardLabel.setForeground(TEXT_COLOR);
        dashboardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        // Increased bottom spacing for title
        gbc.insets = new Insets(10, 10, 25, 10);
        mainPanel.add(dashboardLabel, gbc);

        // Reset insets and gridwidth
        gbc.insets = new Insets(12, 12, 12, 12);
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        // --- Buttons with Icons (using Unicode) ---
        // Icons added before the text for visual cue
        openParkingServicesButton = createStyledButton("⚙️ Manage Parking Lots & Spaces", PRIMARY_COLOR, PRIMARY_DARKER);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2; // Span full width
        mainPanel.add(openParkingServicesButton, gbc);

        createAdminButton = createStyledButton("➕ Generate Admin Account", PRIMARY_COLOR, PRIMARY_DARKER);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1; // Reset gridwidth
        mainPanel.add(createAdminButton, gbc);

        viewAdminAccountsButton = createStyledButton("👁️ View Admin Accounts", SECONDARY_COLOR, SECONDARY_DARKER);
        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(viewAdminAccountsButton, gbc);

        logoutButton = createStyledButton("🚪 Logout", DANGER_COLOR, DANGER_DARKER);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // Span full width
        // Increased top spacing before logout
        gbc.insets = new Insets(25, 10, 10, 10);
        mainPanel.add(logoutButton, gbc);

        add(mainPanel);
    }

    /**
     * Helper method to create consistently styled buttons with icons and hover effects.
     * @param text The text for the button (including Unicode icon).
     * @param bgColor The base background color.
     * @param hoverBgColor The background color on hover.
     * @return A styled JButton.
     */
    private JButton createStyledButton(String text, Color bgColor, Color hoverBgColor) {
        JButton button = new JButton(text);
        button.setFont(BUTTON_FONT);
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setPreferredSize(BUTTON_SIZE);
        // Use a compound border for padding and a subtle line border
        button.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(bgColor.darker(), 1), // Subtle border matching darker shade
                new EmptyBorder(10, 20, 10, 20) // Increased padding inside button
        ));
        // More distinct hover effect
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(hoverBgColor);
                // Slightly darken border on hover too
                button.setBorder(BorderFactory.createCompoundBorder(
                        new LineBorder(hoverBgColor.darker(), 1),
                        new EmptyBorder(10, 20, 10, 20)
                ));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                button.setBackground(bgColor); // Reset to original background
                button.setBorder(BorderFactory.createCompoundBorder( // Reset border
                        new LineBorder(bgColor.darker(), 1),
                        new EmptyBorder(10, 20, 10, 20)
                ));
            }
        });
        return button;
    }


    private void addEventHandlers() {
        // Event handlers remain the same
        openParkingServicesButton.addActionListener(e -> openParkingServices());
        createAdminButton.addActionListener(e -> generateAdminAccount());
        viewAdminAccountsButton.addActionListener(e -> viewGeneratedAccounts());
        logoutButton.addActionListener(e -> logout());
    }

    // --- Action Methods (Logic remains the same, UI improvements in dialogs) ---

    private void openParkingServices() {
        dispose();
        SwingUtilities.invokeLater(() -> new com.parkingapp.GUI.AdminParkingServices(true).setVisible(true));
    }

    private void generateAdminAccount() {
        // Input Panel styling
        JPanel inputPanel = new JPanel(new BorderLayout(10, 10)); // Increased gaps
        inputPanel.setBorder(new EmptyBorder(15, 15, 15, 15)); // More padding
        inputPanel.setBackground(BACKGROUND_COLOR); // Match panel background

        JLabel instructionLabel = new JLabel("Enter username prefix (e.g., 'admin'):");
        instructionLabel.setFont(LABEL_FONT);
        instructionLabel.setForeground(TEXT_COLOR); // Use standard text color
        inputPanel.add(instructionLabel, BorderLayout.NORTH);

        JTextField prefixField = new JTextField(15);
        prefixField.setFont(LABEL_FONT);
        // Improved input field border and padding
        prefixField.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(BORDER_COLOR, 1),
                new EmptyBorder(5, 8, 5, 8) // Padding inside the text field
        ));
        inputPanel.add(prefixField, BorderLayout.CENTER);

        // Show Dialog
        int result = JOptionPane.showConfirmDialog(
                this,
                inputPanel,
                "Generate Admin Account",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            String prefix = prefixField.getText().trim().toLowerCase();
            if (prefix.isEmpty() || !prefix.matches("^[a-zA-Z0-9]+$")) {
                showErrorDialog("Prefix cannot be empty and should contain only letters/numbers.");
                return;
            }
            // --- Logic execution (remains the same) ---
            try {
                AdminAccount newAdmin = (AdminAccount) logic.generateAdminAccount(prefix, adminPrototype);
                logic.saveAdminAccountToFirebase(newAdmin);
                showInfoDialog("Admin Account Created Successfully!\n\n" +
                                "Username: " + newAdmin.getUserId() + "\n" +
                                "Password: " + newAdmin.getPassword(), // Still showing password - ensure this is acceptable
                        "Success");
            } catch (IllegalArgumentException ex) {
                showErrorDialog("Error creating account: " + ex.getMessage());
            } catch (InterruptedException | ExecutionException ex) {
                showErrorDialog("Database Error: Could not save admin account. Details: " + ex.getMessage());
                ex.printStackTrace();
            } catch (Exception ex) {
                showErrorDialog("An unexpected error occurred: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    private void viewGeneratedAccounts() {
        // --- Logic execution (remains the same) ---
        try {
            List<String> accounts = logic.fetchAdminAccounts();
            if (accounts.isEmpty()) {
                showInfoDialog("No admin accounts found in the database.", "Admin Accounts");
            } else {
                // --- Display Panel Styling ---
                JTextArea textArea = new JTextArea(15, 45); // Adjusted size
                textArea.setFont(new Font("Monospaced", Font.PLAIN, 13)); // Slightly larger monospaced font
                textArea.setEditable(false);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setBackground(new Color(255, 255, 255)); // White background for text area
                textArea.setForeground(TEXT_COLOR);
                // Add padding inside the text area
                textArea.setBorder(new EmptyBorder(10, 10, 10, 10));
                textArea.setText(String.join("\n", accounts));
                textArea.setCaretPosition(0);

                JScrollPane scrollPane = new JScrollPane(textArea);
                // Style the scroll pane border
                scrollPane.setBorder(BorderFactory.createTitledBorder(
                        new LineBorder(BORDER_COLOR, 1), // Use consistent border color
                        " Registered Admin Accounts ",
                        javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                        javax.swing.border.TitledBorder.DEFAULT_POSITION,
                        LABEL_FONT, // Use standard label font for title
                        TEXT_COLOR // Use standard text color for title
                ));
                scrollPane.getViewport().setBackground(Color.WHITE); // Ensure viewport background is white

                // Use a custom panel for the dialog message for better control if needed in future
                // For now, just showing the scrollPane is fine.
                JOptionPane.showMessageDialog(
                        this,
                        scrollPane,
                        "Admin Accounts",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        } catch (InterruptedException | ExecutionException ex) {
            showErrorDialog("Database Error: Could not fetch admin accounts. Details: " + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            showErrorDialog("An unexpected error occurred while fetching accounts: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void logout() {
        dispose();
        SwingUtilities.invokeLater(() -> new com.parkingapp.GUI.BaseLogin.ManagementLogin().setVisible(true));
    }

    // --- Helper Methods for Dialogs (Unchanged) ---
    private void showErrorDialog(String message) {
        // You could potentially customize JOptionPane further here if needed
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void showInfoDialog(String message, String title) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}

