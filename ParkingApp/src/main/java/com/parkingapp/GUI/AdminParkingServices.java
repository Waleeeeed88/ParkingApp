package com.parkingapp.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.parkingapp.parkingObjects.ParkingLot;
import com.parkingapp.SuperAdminDashboard;
import com.parkingapp.parkingObjects.ParkingComponent;
import com.parkingapp.parkingObjects.ParkingSpace;
import com.parkingapp.parkingObjects.ParkingServices;

import services.FirebaseInitialization;

public class AdminParkingServices {
    private ParkingServices parkingServices; // Instance of ParkingServices
    private JFrame frame;
    private JComboBox<String> lotSelector;
    private JComboBox<String> spaceSelector;
    private JTextField lotNameField;
    private JButton addLotButton, enableLotButton, disableLotButton;
    private JButton enableSpaceButton, disableSpaceButton;
    private DefaultComboBoxModel<String> lotModel;
    private DefaultComboBoxModel<String> spaceModel;
    private ArrayList<ParkingLot> parkingLots;
    private boolean isSuperManager; // Flag to determine user role
    private JButton returnButton; // Added Return Button to admin dashboard (either super or reg admin)

    private JLabel lotStatusLabel;
    private JLabel spaceStatusLabel;

    public AdminParkingServices(boolean isSuperManager) {
        this.isSuperManager = isSuperManager;
        parkingServices = new ParkingServices(); // Initialize ParkingServices instance
        parkingLots = new ArrayList<>();

        // Setup Nimbus Look & Feel if available for a modern UI appearance
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.err.println("Nimbus L&F not available, using default look & feel");
        }

        // Create the main frame with BorderLayout for overall structure
        frame = new JFrame("Parking Services Dashboard");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        // Create a title panel with custom header
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Admin Parking Services");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 26));
        titlePanel.add(titleLabel);
        frame.add(titlePanel, BorderLayout.NORTH);

        // Create the tabbed pane for different management sections
        JTabbedPane tabbedPane = new JTabbedPane();

        // Create the Parking Lot Management Panel using GridBagLayout
        JPanel lotPanel = createLotManagementPanel();
        tabbedPane.addTab("Parking Lots", lotPanel);

        // Create the Parking Space Management Panel
        JPanel spacePanel = createSpaceManagementPanel();
        tabbedPane.addTab("Parking Spaces", spacePanel);

        frame.add(tabbedPane, BorderLayout.CENTER);

        // Return Button Panel at the bottom
        JPanel returnPanel = new JPanel();
        returnButton = new JButton("Return to Dashboard");
        returnButton.setToolTipText("Return to the main dashboard");
        returnButton.setPreferredSize(new Dimension(180, 35));
        returnPanel.add(returnButton);
        frame.add(returnPanel, BorderLayout.SOUTH);

        // Attach event handlers
        addEventHandlers();

        // Initialize real-time updates for lots
        loadParkingLotsRealtime();

        // Make the frame visible
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Creates and returns the panel for Parking Lot Management with enhanced layout.
     */
    private JPanel createLotManagementPanel() {
        JPanel lotPanel = new JPanel(new GridBagLayout());
        lotPanel.setBorder(BorderFactory.createTitledBorder("Manage Parking Lots"));
        lotPanel.setBackground(new Color(245, 245, 245)); // Light background for clarity

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Row 0: Lot Selector
        gbc.gridx = 0;
        gbc.gridy = 0;
        lotPanel.add(new JLabel("Select Parking Lot:"), gbc);

        gbc.gridx = 1;
        lotModel = new DefaultComboBoxModel<>();
        lotSelector = new JComboBox<>(lotModel);
        lotSelector.setPreferredSize(new Dimension(200, 25));
        lotSelector.setToolTipText("Select a parking lot to manage");
        lotPanel.add(lotSelector, gbc);

        // Row 1: Enable and Disable Buttons
        gbc.gridx = 0;
        gbc.gridy = 1;
        enableLotButton = new JButton("Enable Lot");
        enableLotButton.setToolTipText("Enable the selected parking lot");
        lotPanel.add(enableLotButton, gbc);

        gbc.gridx = 1;
        disableLotButton = new JButton("Disable Lot");
        disableLotButton.setToolTipText("Disable the selected parking lot");
        lotPanel.add(disableLotButton, gbc);

        // Row 2: Lot Name field and Add Button
        gbc.gridx = 0;
        gbc.gridy = 2;
        lotNameField = new JTextField(15);
        lotNameField.setToolTipText("Enter a new parking lot name");
        lotPanel.add(lotNameField, gbc);

        gbc.gridx = 1;
        addLotButton = new JButton("Add New Lot");
        addLotButton.setToolTipText("Add a new parking lot");
        lotPanel.add(addLotButton, gbc);

        // Row 3: Lot Status
        gbc.gridx = 0;
        gbc.gridy = 3;
        lotPanel.add(new JLabel("Lot Status:"), gbc);

        gbc.gridx = 1;
        lotStatusLabel = new JLabel("Unknown");
        lotPanel.add(lotStatusLabel, gbc);

        return lotPanel;
    }

    /**
     * Creates and returns the panel for Parking Space Management with enhanced layout.
     */
    private JPanel createSpaceManagementPanel() {
        JPanel spacePanel = new JPanel(new GridBagLayout());
        spacePanel.setBorder(BorderFactory.createTitledBorder("Manage Parking Spaces"));
        spacePanel.setBackground(new Color(245, 245, 245));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Row 0: Space Selector
        gbc.gridx = 0;
        gbc.gridy = 0;
        spacePanel.add(new JLabel("Select Parking Space:"), gbc);

        gbc.gridx = 1;
        spaceModel = new DefaultComboBoxModel<>();
        spaceSelector = new JComboBox<>(spaceModel);
        spaceSelector.setPreferredSize(new Dimension(200, 25));
        spaceSelector.setToolTipText("Select a parking space to manage");
        spacePanel.add(spaceSelector, gbc);

        // Row 1: Enable and Disable Space Buttons
        gbc.gridx = 0;
        gbc.gridy = 1;
        enableSpaceButton = new JButton("Enable Space");
        enableSpaceButton.setToolTipText("Enable the selected parking space");
        spacePanel.add(enableSpaceButton, gbc);

        gbc.gridx = 1;
        disableSpaceButton = new JButton("Disable Space");
        disableSpaceButton.setToolTipText("Disable the selected parking space");
        spacePanel.add(disableSpaceButton, gbc);

        // Row 2: Space Status
        gbc.gridx = 0;
        gbc.gridy = 2;
        spacePanel.add(new JLabel("Space Status:"), gbc);

        gbc.gridx = 1;
        spaceStatusLabel = new JLabel("Unknown");
        spacePanel.add(spaceStatusLabel, gbc);

        return spacePanel;
    }

    private void addEventHandlers() {
        // Add new Parking Lot event handler
        addLotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lotName = lotNameField.getText().trim();
                if (!lotName.isEmpty()) {
                    ParkingLot newLot = new ParkingLot(lotName);
                    parkingLots.add(newLot);
                    lotModel.addElement(lotName);
                    lotNameField.setText("");

                    // Call the method in ParkingServices to add the new lot in Firestore
                    parkingServices.addParkingLot(lotName);

                    updateSpaceSelector();
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid lot name.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Enable selected Parking Lot with confirmation
        enableLotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = lotSelector.getSelectedIndex();
                if (index >= 0) {
                    int confirm = JOptionPane.showConfirmDialog(
                            frame,
                            "Are you sure you want to enable this parking lot?",
                            "Confirm Enable",
                            JOptionPane.YES_NO_OPTION
                    );
                    if (confirm == JOptionPane.YES_OPTION) {
                        ParkingLot lot = parkingLots.get(index);
                        parkingServices.enableParkingLot(lot);
                    }
                }
            }
        });

        // Disable selected Parking Lot with confirmation
        disableLotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = lotSelector.getSelectedIndex();
                if (index >= 0) {
                    int confirm = JOptionPane.showConfirmDialog(
                            frame,
                            "Are you sure you want to disable this parking lot?",
                            "Confirm Disable",
                            JOptionPane.YES_NO_OPTION
                    );
                    if (confirm == JOptionPane.YES_OPTION) {
                        ParkingLot lot = parkingLots.get(index);
                        parkingServices.disableParkingLot(lot);
                    }
                }
            }
        });

        // Enable selected Parking Space
        enableSpaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = spaceSelector.getSelectedIndex();
                if (index >= 0) {
                    String spaceId = (String) spaceModel.getElementAt(index);
                    for (ParkingLot lot : parkingLots) {
                        for (ParkingComponent space : lot.getParkingSpaces()) {
                            if (space instanceof ParkingSpace && space.getId().equals(spaceId)) {
                                parkingServices.enableParkingSpace((ParkingSpace) space);
                                return;
                            }
                        }
                    }
                }
            }
        });

        // Disable selected Parking Space
        disableSpaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = spaceSelector.getSelectedIndex();
                if (index >= 0) {
                    String spaceId = (String) spaceModel.getElementAt(index);
                    for (ParkingLot lot : parkingLots) {
                        for (ParkingComponent space : lot.getParkingSpaces()) {
                            if (space instanceof ParkingSpace && space.getId().equals(spaceId)) {
                                parkingServices.disableParkingSpace((ParkingSpace) space);
                                return;
                            }
                        }
                    }
                }
            }
        });

        // Return Button functionality to go back to the appropriate dashboard
        returnButton.addActionListener(e -> {
            frame.dispose(); // Close current window
            if (isSuperManager) {
                new com.parkingapp.GUI.SuperAdminDashboardGUI(
                        new ParkingServices(),
                        new SuperAdminDashboard.AdminAccount("defaultAdmin", "defaultPassword"),
                        isSuperManager
                ).setVisible(true);
            } else {
                new BaseLogin.AdminManagementPanel().setVisible(true);
            }
        });

        // When a lot is selected, load its parking spaces and update the lot status.
        lotSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedLotId = (String) lotSelector.getSelectedItem();
                if (selectedLotId != null) {
                    loadParkingSpacesRealtime(selectedLotId);
                    updateLotStatus(selectedLotId);
                }
            }
        });

        // When a space is selected, update the space status.
        spaceSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedLotId = (String) lotSelector.getSelectedItem();
                String selectedSpaceId = (String) spaceSelector.getSelectedItem();
                if (selectedLotId != null && selectedSpaceId != null) {
                    updateSpaceStatus(selectedLotId, selectedSpaceId);
                }
            }
        });
    }

    private void updateSpaceSelector() {
        spaceModel.removeAllElements();
        int index = lotSelector.getSelectedIndex();
        if (index >= 0) {
            ParkingLot selectedLot = parkingLots.get(index);
            List<ParkingComponent> spaces = selectedLot.getParkingSpaces();
            for (ParkingComponent space : spaces) {
                if (space instanceof ParkingSpace) {
                    spaceModel.addElement(space.getId());
                }
            }
        }
    }

    // Real-time listener for parking spaces for a given lotId.
    private void loadParkingSpacesRealtime(String lotId) {
        Firestore db = FirebaseInitialization.getInstance();
        db.collection("Parking_spaces")
                .document(lotId)
                .collection("parkingSpaces")
                .addSnapshotListener((spaceSnapshots, spaceError) -> {
                    if (spaceError != null) {
                        System.err.println("Space listen failed: " + spaceError);
                        return;
                    }
                    if (spaceSnapshots == null) {
                        return;
                    }
                    SwingUtilities.invokeLater(() -> {
                        String currentSelection = (String) spaceSelector.getSelectedItem();
                        spaceModel.removeAllElements();
                        for (DocumentSnapshot spaceDoc : spaceSnapshots.getDocuments()) {
                            if (spaceDoc.exists()) {
                                String spaceId = spaceDoc.getString("id");  // Adjust field name if needed
                                if (spaceId != null) {
                                    spaceModel.addElement(spaceId);
                                }
                            }
                        }
                        // Restore previous selection if possible and update space status.
                        if (currentSelection != null && spaceModel.getIndexOf(currentSelection) != -1) {
                            spaceSelector.setSelectedItem(currentSelection);
                            updateSpaceStatus(lotId, currentSelection);
                        } else {
                            spaceStatusLabel.setText("Unknown");
                        }
                    });
                    System.out.println("Realtime update: Parking spaces updated for lot " + lotId);
                });
    }

    // Real-time listener for parking lots.
    private void loadParkingLotsRealtime() {
        Firestore db = FirebaseInitialization.getInstance();
        db.collection("Parking_spaces").addSnapshotListener((lotSnapshots, lotError) -> {
            if (lotError != null) {
                System.err.println("Lot listen failed: " + lotError);
                return;
            }
            if (lotSnapshots == null) {
                return;
            }
            SwingUtilities.invokeLater(() -> {
                String currentSelection = (String) lotSelector.getSelectedItem();
                lotModel.removeAllElements();
                parkingLots.clear();
                for (DocumentSnapshot lotDoc : lotSnapshots.getDocuments()) {
                    if (lotDoc.exists()) {
                        String lotId = lotDoc.getId();
                        // Read the 'enabled' field from Firestore, defaulting to true if not present.
                        boolean enabledFromDoc = lotDoc.getBoolean("enabled") != null ? lotDoc.getBoolean("enabled") : true;
                        lotModel.addElement(lotId);
                        // Use the new constructor to pass the enabled state.
                        ParkingLot lot = new ParkingLot(lotId, enabledFromDoc);
                        parkingLots.add(lot);
                    }
                }


                if (currentSelection != null && lotModel.getIndexOf(currentSelection) != -1) {
                    lotSelector.setSelectedItem(currentSelection);
                    updateLotStatus(currentSelection);
                } else if (lotModel.getSize() > 0) {
                    String firstLot = (String) lotModel.getElementAt(0);
                    lotSelector.setSelectedItem(firstLot);
                    updateLotStatus(firstLot);
                } else {
                    lotStatusLabel.setText("Unknown");
                }
            });
            System.out.println("Realtime update: Parking lots updated.");
        });
    }

    private void updateLotStatus(String lotId) {
        SwingWorker<String, Void> worker = new SwingWorker<>() {
            @Override
            protected String doInBackground() throws Exception {
                Firestore db = FirebaseInitialization.getInstance();
                DocumentSnapshot doc = db.collection("Parking_spaces").document(lotId).get().get();
                boolean enabled = false;
                if (doc.exists()) {
                    Object enabledObj = doc.get("enabled");
                    if (enabledObj != null) {
                        if (enabledObj instanceof Boolean) {
                            enabled = (Boolean) enabledObj;
                        } else {
                            enabled = Boolean.parseBoolean(enabledObj.toString());
                        }
                    }
                }
                return enabled ? "Enabled" : "Disabled";
            }

            @Override
            protected void done() {
                try {
                    String status = get();
                    lotStatusLabel.setText(status);
                } catch (Exception e) {
                    e.printStackTrace();
                    lotStatusLabel.setText("Error");
                }
            }
        };
        worker.execute();
    }

    private void updateSpaceStatus(String lotId, String spaceId) {
        SwingWorker<String, Void> worker = new SwingWorker<>() {
            @Override
            protected String doInBackground() throws Exception {
                Firestore db = FirebaseInitialization.getInstance();
                DocumentSnapshot doc = db.collection("Parking_spaces")
                        .document(lotId)
                        .collection("parkingSpaces")
                        .document(spaceId)
                        .get().get();
                boolean enabled = false;
                if (doc.exists()) {
                    Object enabledObj = doc.get("enabled");
                    if (enabledObj != null) {
                        if (enabledObj instanceof Boolean) {
                            enabled = (Boolean) enabledObj;
                        } else {
                            enabled = Boolean.parseBoolean(enabledObj.toString());
                        }
                    }
                }
                return enabled ? "Enabled" : "Disabled";
            }

            @Override
            protected void done() {
                try {
                    String status = get();
                    spaceStatusLabel.setText(status);
                } catch (Exception e) {
                    e.printStackTrace();
                    spaceStatusLabel.setText("Error");
                }
            }
        };
        worker.execute();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdminParkingServices(true));
    }

    public void setVisible(boolean b) {
    }
}
