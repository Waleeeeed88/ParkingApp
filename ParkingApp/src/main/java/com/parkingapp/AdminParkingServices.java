package com.parkingapp;

import javax.swing.*;
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
    private JButton returnButton; // Added Return Button to admin dashboard (either super or reg admin)
    private DefaultComboBoxModel<String> lotModel;
    private DefaultComboBoxModel<String> spaceModel;
    private ArrayList<ParkingLot> parkingLots;
    private boolean isSuperManager; // Flag to determine user role

    public AdminParkingServices(boolean isSuperManager) {
        this.isSuperManager = isSuperManager;
        parkingServices = new ParkingServices(); // Initialize ParkingServices instance
        parkingLots = new ArrayList<>();
        frame = new JFrame("Parking Services");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 1));

        // Panel for Parking Lots
        JPanel lotPanel = new JPanel();
        lotPanel.setLayout(new GridLayout(3, 2));
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

        frame.add(lotPanel);

        // Panel for Parking Spaces
        JPanel spacePanel = new JPanel();
        spacePanel.setLayout(new GridLayout(2, 2));
        spacePanel.setBorder(BorderFactory.createTitledBorder("Parking Space Management"));

        spaceModel = new DefaultComboBoxModel<>();
        spaceSelector = new JComboBox<>(spaceModel);
        spacePanel.add(new JLabel("Select Parking Space"));
        spacePanel.add(spaceSelector);

        enableSpaceButton = new JButton("Enable Space");
        disableSpaceButton = new JButton("Disable Space");
        spacePanel.add(enableSpaceButton);
        spacePanel.add(disableSpaceButton);

        frame.add(spacePanel);

        // New Panel for Return Button
        JPanel returnPanel = new JPanel();
        returnButton = new JButton("Return to Dashboard");
        returnPanel.add(returnButton);
        frame.add(returnPanel);

        addEventHandlers();
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

        // Enable selected Parking Lot
        enableLotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = lotSelector.getSelectedIndex();
                if (index >= 0) {
                    ParkingLot lot = parkingLots.get(index);
                    parkingServices.enableParkingLot(lot);
                }
            }
        });

        // Disable selected Parking Lot
        disableLotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = lotSelector.getSelectedIndex();
                if (index >= 0) {
                    ParkingLot lot = parkingLots.get(index);
                    parkingServices.disableParkingLot(lot);
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
                new AdminDashboard(new ParkingServices(), new AdminAccount("defaultAdmin", "defaultPassword"), isSuperManager).setVisible(true);

            } else {

                new BaseLogin.AdminManagementPanel().setVisible(true);
            }
        });

        // Update space selector when a parking lot is selected
        lotSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSpaceSelector();
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
    
    
    
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new AdminParkingServices(true));

    }
}
