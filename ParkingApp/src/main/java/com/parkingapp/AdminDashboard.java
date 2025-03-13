package com.parkingapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class AdminDashboard extends JFrame {
    private JButton addParkingButton, enableParkingButton, disableParkingButton, underMaintenanceButton, logoutButton, createAdminButton;
    private ParkingServices parkingServices;
    private JList<String> parkingList;
    private DefaultListModel<String> parkingListModel;
    private AdminAccountPrototype adminPrototype; // Prototype for admin accounts

    public AdminDashboard(ParkingServices parkingServices, AdminAccountPrototype adminPrototype) {
        this.parkingServices = parkingServices;
        this.adminPrototype = adminPrototype;

        setTitle("Admin Dashboard");
        setSize(600, 450);
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

        JLabel currentSpacesLabel = new JLabel("Current Parking Spaces");
        currentSpacesLabel.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(currentSpacesLabel, gbc);

        parkingListModel = new DefaultListModel<>();
        parkingList = new JList<>(parkingListModel);
        parkingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(parkingList);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0; // Allow list to expand horizontally
        gbc.weighty = 1.0; // Allow list to expand vertically
        gbc.fill = GridBagConstraints.BOTH; // Fill both horizontally and vertically
        panel.add(scrollPane, gbc);


        addParkingButton = new JButton("Add Parking Lot");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1; // Set gridwidth back to 1
        gbc.weightx = 0; // Reset weightx
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Reset fill
        panel.add(addParkingButton, gbc);


        enableParkingButton = new JButton("Enable Parking");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(enableParkingButton, gbc);

        disableParkingButton = new JButton("Disable Parking");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;

        panel.add(disableParkingButton, gbc);

        underMaintenanceButton = new JButton("Put Under Maintenance");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(underMaintenanceButton, gbc);

        createAdminButton = new JButton("Create Admin Account");
        gbc.gridx = 0;
        gbc.gridy = 5;  // Corrected y position
        gbc.gridwidth = 2; // Span two columns
        panel.add(createAdminButton, gbc);


        logoutButton = new JButton("Logout");
        gbc.gridx = 0;
        gbc.gridy = 6; // Adjusted for the new button
        gbc.gridwidth = 2;
        panel.add(logoutButton, gbc);

        add(panel);

        addParkingButton.addActionListener(e -> addParkingLot());
        enableParkingButton.addActionListener(e -> enableParking());
        disableParkingButton.addActionListener(e -> disableParking());
        underMaintenanceButton.addActionListener(e -> putUnderMaintenance());
        logoutButton.addActionListener(e -> logout());
        createAdminButton.addActionListener(e -> createAdminAccount()); // Add action listener


        refreshParkingList();
        setVisible(true);
    }
    private void createAdminAccount() {
        JTextField userIdField = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(10);

        JPanel inputPanel = new JPanel(new GridLayout(0, 1)); // Use GridLayout for vertical layout
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
                return; // Exit if input is invalid
            }

            // Use the prototype to create a new admin account
            AdminAccount newAdmin = adminPrototype.clone();
            newAdmin.setUserId(userId);
            newAdmin.setPassword(password);  // Ideally, hash the password here

            // Store the new admin account (in a real application, you'd use a database)
            AdminLogin.addAdminAccount(userId, password); //static method to add the admin

            JOptionPane.showMessageDialog(this, "Admin account created for User ID: " + userId);
        }
    }


    private void addParkingLot() {
        String id = JOptionPane.showInputDialog(this, "Enter Parking Lot ID:");
        if (id != null && !id.trim().isEmpty()) {
            String type = (String) JOptionPane.showInputDialog(
                    this,
                    "Select Parking Lot Type:",
                    "Parking Lot Type",
                    JOptionPane.QUESTION_MESSAGE,
                    null, // No icon
                    new String[]{"Standard", "Handicapped", "Compact", "Electric"}, // Options
                    "Standard" // Default selection
            );

            if (type != null) {
                ParkingSpace newSpace = ParkingSpaceFactory.createParkingSpace(id, type); //use factory
                if (newSpace != null){
                    parkingServices.addParking(newSpace);  // Corrected: Pass the ParkingSpace object directly
                    JOptionPane.showMessageDialog(this, type + " parking lot added: " + id);
                    refreshParkingList();
                }
            }
        } else if (id != null) { // Handle empty input
            JOptionPane.showMessageDialog(this, "Parking Lot ID cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void enableParking() {
        String id = JOptionPane.showInputDialog(this, "Enter Parking Lot ID to enable:");
        if (id != null && !id.isEmpty()) {
            Parking parking = parkingServices.getParking(id);
            if (parking == null) {
                JOptionPane.showMessageDialog(this, "Parking lot ID does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {

                parking.setEnabled(true);
                parking.setUnderMaintenance(false);
                JOptionPane.showMessageDialog(this, "Parking lot enabled: " + id);
                refreshParkingList();

            }
        }
    }

    private void disableParking() {
        String id = JOptionPane.showInputDialog(this, "Enter Parking Lot ID to disable:");
        if (id != null && !id.isEmpty()) {
            Parking parking = parkingServices.getParking(id);
            if (parking == null) {
                JOptionPane.showMessageDialog(this, "Parking lot ID does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                parking.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Parking lot disabled: " + id);
                refreshParkingList();
            }
        }
    }

    private void putUnderMaintenance() {
        String id = JOptionPane.showInputDialog(this, "Enter Parking Lot ID to put under maintenance:");
        if (id != null && !id.isEmpty()) {
            Parking parking = parkingServices.getParking(id);
            if (parking == null) {
                JOptionPane.showMessageDialog(this, "Parking lot ID does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                parking.setUnderMaintenance(true);
                parking.setEnabled(false); //good practice
                JOptionPane.showMessageDialog(this, "Parking lot under maintenance: " + id);
                refreshParkingList();
            }
        }
    }
    private void logout() {
        dispose();
        new AdminLogin().setVisible(true);
    }
    private void refreshParkingList() {
        parkingListModel.clear();
        Map<String, Parking> parkingSpaces = parkingServices.getParkingSpaces();
        for (Parking parking : parkingSpaces.values()) { // Iterate through values directly
            String id = parking.getId(); // Get ID from Parking object
            String status = parking.isEnabled() ? "Enabled" : "Disabled";
            if (parking.isUnderMaintenance()) {
                status = "Under Maintenance";
            }
            parkingListModel.addElement(id + " - " + status);
        }
    }

    public static void main(String[] args) {
        ParkingServices parkingServices = new ParkingServices();
        // Create a prototype admin account.  In a real system, you might
        // load this from a configuration file or database.
        AdminAccount prototypeAdmin = new AdminAccount("defaultAdmin", "defaultPassword"); // Consider better defaults

        SwingUtilities.invokeLater(() -> new AdminDashboard(parkingServices, prototypeAdmin).setVisible(true));
    }
}
//Parking services class



// Prototype interface
interface AdminAccountPrototype extends Cloneable {
    AdminAccount clone();

    void setUserId(String userId);

    void setPassword(String password); // Consider hashing the password
}

// Concrete Prototype
class AdminAccount implements AdminAccountPrototype {
    private String userId;
    private String password; // Store a hashed password, NOT plaintext!

    public AdminAccount(String userId, String password) {
        this.userId = userId;
        this.password = password; // In a real system, hash the password!
    }

    // Copy constructor for the Prototype pattern
    public AdminAccount(AdminAccount source) {
        this.userId = source.userId;
        this.password = source.password; // Copy the (hashed) password
    }

    @Override
    public AdminAccount clone() {
        return new AdminAccount(this); // Use the copy constructor
    }

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public void setPassword(String password) {
        this.password = password; // Hash the password in a real application!
    }


    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }
}

// Interface
interface Parking {
    String getId();
    boolean isEnabled();
    void setEnabled(boolean enabled);
    boolean isUnderMaintenance();
    void setUnderMaintenance(boolean underMaintenance);
}

// Parking space interface
interface ParkingSpace extends Parking {
    String getType();
    // Other methods common to all parking spaces
}

// Concrete classes
class StandardSpace implements ParkingSpace {
    private String id;
    private boolean enabled;
    private boolean underMaintenance;

    public StandardSpace(String id) {
        this.id = id;
        this.enabled = true; // Initially enabled
        this.underMaintenance = false; // Initially not under maintenance
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isUnderMaintenance() {
        return underMaintenance;
    }

    @Override
    public void setUnderMaintenance(boolean underMaintenance) {
        this.underMaintenance = underMaintenance;
    }

    @Override
    public String getType() {
        return "Standard";
    }
}

class HandicappedSpace implements ParkingSpace {
    private String id;
    private boolean enabled;
    private boolean underMaintenance;

    public HandicappedSpace(String id) {
        this.id = id;
        this.enabled = true; // Initially enabled
        this.underMaintenance = false; // Initially not under maintenance
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isUnderMaintenance() {
        return underMaintenance;
    }

    @Override
    public void setUnderMaintenance(boolean underMaintenance) {
        this.underMaintenance = underMaintenance;
    }

    @Override
    public String getType() {
        return "Handicapped";
    }
}

class CompactSpace implements ParkingSpace {
    private String id;
    private boolean enabled;
    private boolean underMaintenance;

    public CompactSpace(String id) {
        this.id = id;
        this.enabled = true;
        this.underMaintenance = false;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isUnderMaintenance() {
        return underMaintenance;
    }

    @Override
    public void setUnderMaintenance(boolean underMaintenance) {
        this.underMaintenance = underMaintenance;
    }

    @Override
    public String getType() {
        return "Compact";
    }
}

class ElectricSpace implements ParkingSpace {
    private String id;
    private boolean enabled;
    private boolean underMaintenance;

    public ElectricSpace(String id) {
        this.id = id;
        this.enabled = true;
        this.underMaintenance = false;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean isUnderMaintenance() {
        return underMaintenance;
    }

    @Override
    public void setUnderMaintenance(boolean underMaintenance) {
        this.underMaintenance = underMaintenance;
    }

    @Override
    public String getType() {
        return "Electric";
    }
}

// Factory Method
class ParkingSpaceFactory {
    public static ParkingSpace createParkingSpace(String id, String type) {
        switch (type) {
            case "Standard":
                return new StandardSpace(id); // Pass id
            case "Handicapped":
                return new HandicappedSpace(id); // Pass id
            case "Compact":
                return new CompactSpace(id); // Pass id
            case "Electric":
                return new ElectricSpace(id); // Pass id
            default:
                return null; // Or throw an exception
        }
    }
}


