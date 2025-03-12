import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class AdminLogin extends JFrame {

    private JTextField adminIdField;
    private JPasswordField adminPasswordField;
    private JButton adminLoginButton;
    private static Map<String, String> adminAccounts = new HashMap<>(); // Store admin accounts

    // *** TEMPORARY HARDCODED ADMIN ACCOUNT (FOR DEMO ONLY) ***
    private static final String HARDCODED_ADMIN_ID = "admin";
    private static final String HARDCODED_ADMIN_PASSWORD = "adminpassword";


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

        JLabel adminIdLabel = new JLabel("Admin User ID:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(adminIdLabel, gbc);

        adminIdField = new JTextField();
        adminIdField.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(adminIdField, gbc);

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

        // Add the hardcoded account to the map *initially*.
        addHardcodedAdmin();
    }

    // Method to add admin accounts (used by AdminDashboard)
    public static void addAdminAccount(String userId, String password) {
        adminAccounts.put(userId, password); // In real-world, hash the password!
    }

    private void addHardcodedAdmin() {
        adminAccounts.put(HARDCODED_ADMIN_ID, HARDCODED_ADMIN_PASSWORD);
    }

    private void performAdminLogin() {
        String userId = adminIdField.getText();
        String password = new String(adminPasswordField.getPassword());
        adminPasswordField.setText(null);
        adminIdField.setText(null);

        if (adminAccounts.containsKey(userId) && adminAccounts.get(userId).equals(password)) {
            JOptionPane.showMessageDialog(this, "Admin Login Successful!");
            ParkingServices parkingServices = new ParkingServices();
            AdminAccount prototypeAdmin = new AdminAccount("defaultAdmin", "defaultPassword");
            new AdminDashboard(parkingServices, prototypeAdmin).setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Admin Credentials", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setVisible(boolean visible) {
        super.setVisible(visible);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdminLogin().setVisible(true));
    }
}
