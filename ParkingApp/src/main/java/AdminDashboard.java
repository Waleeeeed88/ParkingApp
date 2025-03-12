import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDashboard extends JFrame {
    private JButton addParkingButton, enableParkingButton, disableParkingButton, logoutButton;
    private ParkingServices parkingServices;

    public AdminDashboard(ParkingServices parkingServices) {
        this.parkingServices = parkingServices; // Initialize ParkingServices

        setTitle("Admin Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application when the window is closed
        setLocationRelativeTo(null); // Center on screen

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

        // Add Parking Lot Button
        addParkingButton = new JButton("Add Parking Lot");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(addParkingButton, gbc);

        // Enable Parking Button
        enableParkingButton = new JButton("Enable Parking");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(enableParkingButton, gbc);

        // Disable Parking Button
        disableParkingButton = new JButton("Disable Parking");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(disableParkingButton, gbc);

        // Logout Button
        logoutButton = new JButton("Logout");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(logoutButton, gbc);

        add(panel);

        // Add action listeners to the buttons
        addParkingButton.addActionListener(e -> addParkingLot());
        enableParkingButton.addActionListener(e -> enableParking());
        disableParkingButton.addActionListener(e -> disableParking());
        logoutButton.addActionListener(e -> logout());
    }

    private void addParkingLot() {
        String id = JOptionPane.showInputDialog(this, "Enter Parking Lot ID:");
        if (id != null && !id.isEmpty()) {
            parkingServices.addParking(id);
            JOptionPane.showMessageDialog(this, "Parking lot added: " + id);
        }
    }

    private void enableParking() {
        String id = JOptionPane.showInputDialog(this, "Enter Parking Lot ID to enable:");
        if (id != null && !id.isEmpty()) {
            parkingServices.enableParking(id);
            JOptionPane.showMessageDialog(this, "Parking lot enabled: " + id);
        }
    }

    private void disableParking() {
        String id = JOptionPane.showInputDialog(this, "Enter Parking Lot ID to disable:");
        if (id != null && !id.isEmpty()) {
            parkingServices.disableParking(id);
            JOptionPane.showMessageDialog(this, "Parking lot disabled: " + id);
        }
    }

    private void logout() {
        dispose(); // Close the admin dashboard
        new AdminLogin().setVisible(true); // Show the login page again
    }

    public static void main(String[] args) {
        // Create ParkingServices object
        ParkingServices parkingServices = new ParkingServices();
        SwingUtilities.invokeLater(() -> new AdminDashboard(parkingServices).setVisible(true));
    }
}
