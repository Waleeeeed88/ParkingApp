import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class AdminDashboard extends JFrame {
    private JButton addParkingButton, enableParkingButton, disableParkingButton, underMaintenanceButton, logoutButton;
    private ParkingServices parkingServices;
    private JList<String> parkingList;
    private DefaultListModel<String> parkingListModel;

    public AdminDashboard(ParkingServices parkingServices) {
        this.parkingServices = parkingServices; // Initialize ParkingServices

        setTitle("Admin Dashboard");
        setSize(600, 400);
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

        // Label for "Current Parking Spaces"
        JLabel currentSpacesLabel = new JLabel("Current Parking Spaces");
        currentSpacesLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(currentSpacesLabel, gbc);

        // List to display parking spaces and their statuses
        parkingListModel = new DefaultListModel<>();
        parkingList = new JList<>(parkingListModel);
        parkingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(parkingList);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(scrollPane, gbc);

        // Add Parking Lot Button
        addParkingButton = new JButton("Add Parking Lot");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(addParkingButton, gbc);

        // Enable Parking Button
        enableParkingButton = new JButton("Enable Parking");
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(enableParkingButton, gbc);

        // Disable Parking Button
        disableParkingButton = new JButton("Disable Parking");
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(disableParkingButton, gbc);

        // Under Maintenance Button
        underMaintenanceButton = new JButton("Put Parking Lot Under Maintenance");
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(underMaintenanceButton, gbc);

        // Logout Button
        logoutButton = new JButton("Logout");
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        panel.add(logoutButton, gbc);

        add(panel);

        // Add action listeners to the buttons
        addParkingButton.addActionListener(e -> addParkingLot());
        enableParkingButton.addActionListener(e -> enableParking());
        disableParkingButton.addActionListener(e -> disableParking());
        underMaintenanceButton.addActionListener(e -> putUnderMaintenance());
        logoutButton.addActionListener(e -> logout());

        // Refresh the parking list to display the latest data
        refreshParkingList();
    }

    private void addParkingLot() {
        String id = JOptionPane.showInputDialog(this, "Enter Parking Lot ID:");
        if (id != null && !id.isEmpty()) {
            parkingServices.addParking(id);
            JOptionPane.showMessageDialog(this, "Parking lot added: " + id);
            refreshParkingList();
        }
    }

    private void enableParking() {
        String id = JOptionPane.showInputDialog(this, "Enter Parking Lot ID to enable:");
        if (id != null && !id.isEmpty()) {
            if (parkingServices.getParking(id) == null) {
                JOptionPane.showMessageDialog(this, "Parking lot ID does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                parkingServices.enableParking(id);
                JOptionPane.showMessageDialog(this, "Parking lot enabled: " + id);
                refreshParkingList();
            }
        }
    }

    private void disableParking() {
        String id = JOptionPane.showInputDialog(this, "Enter Parking Lot ID to disable:");
        if (id != null && !id.isEmpty()) {
            if (parkingServices.getParking(id) == null) {
                JOptionPane.showMessageDialog(this, "Parking lot ID does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                parkingServices.disableParking(id);
                JOptionPane.showMessageDialog(this, "Parking lot disabled: " + id);
                refreshParkingList();
            }
        }
    }

    private void putUnderMaintenance() {
        String id = JOptionPane.showInputDialog(this, "Enter Parking Lot ID to put under maintenance:");
        if (id != null && !id.isEmpty()) {
            if (parkingServices.getParking(id) == null) {
                JOptionPane.showMessageDialog(this, "Parking lot ID does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                parkingServices.getParking(id).setUnderMaintenance(true);
                JOptionPane.showMessageDialog(this, "Parking lot under maintenance: " + id);
                refreshParkingList();
            }
        }
    }

    private void logout() {
        dispose(); // Close the admin dashboard
        new AdminLogin().setVisible(true); // Show the login page again
    }

    private void refreshParkingList() {
        parkingListModel.clear(); // Clear the list before adding updated data
        Map<String, Parking> parkingSpaces = parkingServices.getParkingSpaces();
        for (String id : parkingSpaces.keySet()) {
            Parking parking = parkingSpaces.get(id);
            String status = parking.isEnabled() ? "Enabled" : "Disabled";
            if (parking.isUnderMaintenance()) {
                status = "Under Maintenance";
            }
            parkingListModel.addElement(id + " - " + status);
        }
    }

    public static void main(String[] args) {
        // Create ParkingServices object
        ParkingServices parkingServices = new ParkingServices();
        SwingUtilities.invokeLater(() -> new AdminDashboard(parkingServices).setVisible(true));
    }
}
