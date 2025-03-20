package com.parkingapp;

import javax.swing.*;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;

import services.FirebaseInitialization;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
        frame = new JFrame("Parking Services");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 1));

        // Panel for Parking Lots
        JPanel lotPanel = new JPanel();
        lotPanel.setLayout(new GridLayout(5, 2));
        lotPanel.setBorder(BorderFactory.createTitledBorder("Parking Lot Management"));

        lotModel = new DefaultComboBoxModel<>();
        lotSelector = new JComboBox<>(lotModel);
        lotPanel.add(new JLabel("Select Parking Lot"));
        lotPanel.add(lotSelector);

        enableLotButton = new JButton("Enable Lot");
        disableLotButton = new JButton("Disable Lot");
        lotPanel.add(enableLotButton);
        lotPanel.add(disableLotButton);

        lotNameField = new JTextField();
        addLotButton = new JButton("Add New Lot");
        lotPanel.add(lotNameField);
        lotPanel.add(addLotButton);
        
        //lot status label
        lotPanel.add(new JLabel("Lot Status:"));
        lotStatusLabel = new JLabel("Unknown");
        lotPanel.add(lotStatusLabel);

//        //optional rows
//        lotPanel.add(new JLabel(""));
//        lotPanel.add(new JLabel(""));

        
        frame.add(lotPanel);

        // Panel for Parking Spaces
        JPanel spacePanel = new JPanel();
        spacePanel.setLayout(new GridLayout(4, 2));
        spacePanel.setBorder(BorderFactory.createTitledBorder("Parking Space Management"));

        spaceModel = new DefaultComboBoxModel<>();
        spaceSelector = new JComboBox<>(spaceModel);
        spacePanel.add(new JLabel("Select Parking Space"));
        spacePanel.add(spaceSelector);

        enableSpaceButton = new JButton("Enable Space");
        disableSpaceButton = new JButton("Disable Space");
        spacePanel.add(enableSpaceButton);
        spacePanel.add(disableSpaceButton);

        // space status label
        spacePanel.add(new JLabel("Space Status:"));
        spaceStatusLabel = new JLabel("Unknown");
        spacePanel.add(spaceStatusLabel);
        
        frame.add(spacePanel);

        // New Panel for Return Button
        JPanel returnPanel = new JPanel();
        returnButton = new JButton("Return to Dashboard");
        returnPanel.add(returnButton);
        frame.add(returnPanel);

        addEventHandlers();

        // Initialize real-time updates for lots
        loadParkingLotsRealtime();

        // When a lot is selected, load its parking spaces
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

        frame.setVisible(true);
    }

    private void addEventHandlers() {
        // Add new Parking Lot
        addLotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lotName = lotNameField.getText().trim();
                if (!lotName.isEmpty()) {
                    ParkingLot newLot = new ParkingLot(lotName);
                    parkingLots.add(newLot);
                    lotModel.addElement(lotName);
                    lotNameField.setText("");

                    // Call the method in ParkingServices
                    parkingServices.addParkingLot(lotName);

                    updateSpaceSelector();
                }
            }
        });

     // Enable selected Parking Lot with confirmation
        enableLotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = lotSelector.getSelectedIndex();
                if (index >= 0) {
                    // Show confirmation dialog
                    int confirm = JOptionPane.showConfirmDialog(
                        frame,
                        "Are you sure you want to enable this parking lot?",
                        "Confirm Enable",
                        JOptionPane.YES_NO_OPTION
                    );
                    // Only proceed if the user confirms
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
                    // Show confirmation dialog
                    int confirm = JOptionPane.showConfirmDialog(
                        frame,
                        "Are you sure you want to disable this parking lot?",
                        "Confirm Disable",
                        JOptionPane.YES_NO_OPTION
                    );
                    // Only proceed if the user confirms
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

        // Disable selected Parking Space (Fixed missing `}` issue)
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
            } // <-- Corrected missing closing bracket
        });

        // FIXED RETURN BUTTON FUNCTIONALITY
        returnButton.addActionListener(e -> {
            frame.dispose(); // Close current window

            if (isSuperManager) {
                new AdminDashboard(new ParkingServices(), new AdminDashboard.AdminAccount("defaultAdmin", "defaultPassword"), isSuperManager).setVisible(true);

            } else {

                new BaseLogin.AdminManagementPanel().setVisible(true);
            }
        });

        // Update space selector when a parking lot is selected
        lotSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedLotId = (String) lotSelector.getSelectedItem();
                if (selectedLotId != null) {
                	loadParkingSpacesRealtime(selectedLotId);
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
 // Real-time listener for parking spaces for a given lotId
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
                  // Restore selection if possible and update space status.
                  if (currentSelection != null && spaceModel.getIndexOf(currentSelection) != -1) {
                      spaceSelector.setSelectedItem(currentSelection);
                      updateSpaceStatus(lotId, currentSelection);
                  } else {
                      // If no selection exists, clear the status.
                      spaceStatusLabel.setText("Unknown");
                  }
              });
              System.out.println("Realtime update: Parking spaces updated for lot " + lotId);
          });
    }


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
                        lotModel.addElement(lotId);
                        ParkingLot lot = new ParkingLot(lotId);
                        parkingLots.add(lot);
                    }
                }
                // Restore previous selection if possible, then update the lot status.
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
        Firestore db = FirebaseInitialization.getInstance();
        ApiFuture<DocumentSnapshot> future = db.collection("Parking_spaces").document(lotId).get();
        new Thread(() -> {
            try {
                DocumentSnapshot doc = future.get();
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
                String status = enabled ? "Enabled" : "Disabled";
                SwingUtilities.invokeLater(() -> lotStatusLabel.setText(status));
            } catch (Exception ex) {
                ex.printStackTrace();
                SwingUtilities.invokeLater(() -> lotStatusLabel.setText("Error"));
            }
        }).start();
    }

    // --- Method to update the ParkingSpace status by reading its Firestore document ---
    private void updateSpaceStatus(String lotId, String spaceId) {
        Firestore db = FirebaseInitialization.getInstance();
        ApiFuture<DocumentSnapshot> future = db.collection("Parking_spaces")
                .document(lotId)
                .collection("parkingSpaces")
                .document(spaceId)
                .get();
        new Thread(() -> {
            try {
                DocumentSnapshot doc = future.get();
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
                String status = enabled ? "Enabled" : "Disabled";
                SwingUtilities.invokeLater(() -> spaceStatusLabel.setText(status));
            } catch (Exception ex) {
                ex.printStackTrace();
                SwingUtilities.invokeLater(() -> spaceStatusLabel.setText("Error"));
            }
        }).start();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdminParkingServices(true));
    }
}
