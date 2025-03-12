import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Test Line
public class AdminLogin extends JFrame {

    // *** HARDCODED ADMIN CREDENTIALS (FOR DEMO ONLY - DO NOT USE IN PRODUCTION) ***
    private static final String ADMIN_EMAIL = "admin@example.com";
    private static final String ADMIN_PASSWORD = "adminpassword";

    private JTextField adminEmailField;
    private JPasswordField adminPasswordField;
    private JButton adminLoginButton;

    public AdminLogin() {
        setTitle("Admin Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        setLocationRelativeTo(null); // Center on screen

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel adminLoginLabel = new JLabel("Admin Login");
        adminLoginLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(adminLoginLabel, gbc);

        JLabel adminEmailLabel = new JLabel("Admin Email:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(adminEmailLabel, gbc);

        adminEmailField = new JTextField();
        adminEmailField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(adminEmailField, gbc);

        JLabel adminPasswordLabel = new JLabel("Admin Password:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(adminPasswordLabel, gbc);

        adminPasswordField = new JPasswordField();
        adminPasswordField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(adminPasswordField, gbc);

        adminLoginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(adminLoginButton, gbc);

        adminLoginButton.addActionListener(e -> performAdminLogin());

        add(panel);
    }

    private void performAdminLogin() {
        String email = adminEmailField.getText();
        String password = new String(adminPasswordField.getPassword());
        adminPasswordField.setText(null); // Clear the password

        // *** VERY BASIC ADMIN CHECK (FOR DEMO ONLY) ***
        if (email.equals(ADMIN_EMAIL) && password.equals(ADMIN_PASSWORD)) {
            JOptionPane.showMessageDialog(this, "Admin Login Successful!");
            // Open an admin-specific panel/window here (replace this with your admin functionality)
            dispose(); // Close the admin login window after successful login
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Admin Credentials", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void setVisible(boolean visible) {
        super.setVisible(visible); // Call the superclass method
    }
}