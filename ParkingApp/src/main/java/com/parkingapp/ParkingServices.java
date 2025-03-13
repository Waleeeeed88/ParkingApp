//package com.parkingapp;
//
//import javax.swing.*;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.Color;
//
//public class ParkingServices implements ActionListener {
//
//        private static ArrayList<ParkingComponent> parkingSpaces = new ArrayList<>();
//        private static DefaultListModel<ParkingComponent> listModel;
//        private static JList<ParkingComponent> parkingList;
//        private static JFrame frame;
//        private static JPanel panel;
//        private static JTextField parkingSpotInput;
//        private static JButton addParkingButton;
//        private static JButton enableParkingButton;
//        private static JButton disableParkingButton;
//        private static JButton underMaintenanceButton;
//        private static JTextArea successLabel;
//
//        public static void main(String[] args) {
//            parkingSpaces.add(new ParkingComponent("A1"));
//            parkingSpaces.add(new ParkingComponent("A2"));
//            parkingSpaces.add(new ParkingComponent("B1"));
//            parkingSpaces.add(new ParkingComponent("B2"));
//
//            parkingServicesGUI();
//        }
//
//        public static void parkingServicesGUI() {
//            frame = new JFrame("Admin Parking Services");
//            panel = new JPanel();
//            frame.setSize(400, 350);
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.add(panel);
//            panel.setLayout(null);
//
//            JLabel parkingSpacesLabel = new JLabel("Parking Spaces");
//            parkingSpacesLabel.setBounds(10, 20, 150, 25);
//            panel.add(parkingSpacesLabel);
//
//            // Parking JList to show available parking spaces
//            listModel = new DefaultListModel<>();
//            parkingList = new JList<>(listModel);
//            JScrollPane scrollPane = new JScrollPane(parkingList);
//            scrollPane.setBounds(10, 50, 300, 150);
//            panel.add(scrollPane);
//
//            // Update the list with current parking spaces
//            refreshParkingList();
//
//            // Input for parking spot
//            JLabel parkingSpotLabel = new JLabel("Parking Spot ID:");
//            parkingSpotLabel.setBounds(10, 210, 150, 25);
//            panel.add(parkingSpotLabel);
//
//            parkingSpotInput = new JTextField();
//            parkingSpotInput.setBounds(150, 210, 150, 25);
//            panel.add(parkingSpotInput);
//
//            // Buttons
//            addParkingButton = new JButton("Add Parking");
//            addParkingButton.setBounds(10, 240, 120, 30);
//            addParkingButton.addActionListener(new ParkingServices());
//            panel.add(addParkingButton);
//
//            enableParkingButton = new JButton("Enable Parking");
//            enableParkingButton.setBounds(140, 240, 120, 30);
//            enableParkingButton.addActionListener(new ParkingServices());
//            panel.add(enableParkingButton);
//
//            disableParkingButton = new JButton("Disable Parking");
//            disableParkingButton.setBounds(270, 240, 120, 30);
//            disableParkingButton.addActionListener(new ParkingServices());
//            panel.add(disableParkingButton);
//
////            underMaintenanceButton = new JButton("Under Maintenance");
////            underMaintenanceButton.setBounds(10, 280, 150, 30);
////            underMaintenanceButton.addActionListener(new ParkingServices());
////            panel.add(underMaintenanceButton);
//
//            successLabel = new JTextArea();
//            successLabel.setBounds(10, 320, 350, 30);
//            successLabel.setBackground(Color.GRAY);
//            successLabel.setForeground(Color.WHITE);
//            successLabel.setEditable(false);
//            panel.add(successLabel);
//
//            frame.setVisible(true);
//        }
//
//        // This method updates the JList with the current parking spaces' status
//        private static void refreshParkingList() {
//            listModel.clear(); // Clear the previous list
//            for (ParkingComponent p : parkingSpaces) {
//                listModel.addElement(p);
//            }
//        }
//
//        // Action handler for buttons
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            String parkingSpotId = parkingSpotInput.getText();
//
//            if (e.getSource() == addParkingButton) {
//                addParking(parkingSpotId);
//            } else if (e.getSource() == enableParkingButton) {
//                enableParking(parkingSpotId);
//            } else if (e.getSource() == disableParkingButton) {
//                disableParking(parkingSpotId);
//            } else if (e.getSource() == underMaintenanceButton) {
//                setUnderMaintenance(parkingSpotId);
//            }
//        }
//
//        // Method to add a parking space
//        private static void addParking(String parkingSpotId) {
//            if (parkingSpotId != null && !parkingSpotId.isEmpty()) {
//                ParkingComponent newParking = new ParkingComponent(parkingSpotId);
//                parkingSpaces.add(newParking);
//                successLabel.setText("Parking Spot " + parkingSpotId + " Added");
//                refreshParkingList();
//            } else {
//                successLabel.setText("Please enter a valid Parking Spot ID");
//            }
//        }
//
//        // Method to enable a parking space
//        private static void enableParking(String parkingSpotId) {
//            for (ParkingComponent parking : parkingSpaces) {
//                if (parking.getId().equals(parkingSpotId)) {
//                    parking.setEnabled(true);
//                    successLabel.setText("Parking Spot " + parkingSpotId + " Enabled");
//                    refreshParkingList();
//                    return;
//                }
//            }
//            successLabel.setText("Parking Spot ID does not exist");
//        }
//
//        // Method to disable a parking space
//        private static void disableParking(String parkingSpotId) {
//            for (ParkingComponent parking : parkingSpaces) {
//                if (parking.getId().equals(parkingSpotId)) {
//                    parking.setEnabled(false);
//                    successLabel.setText("Parking Spot " + parkingSpotId + " Disabled");
//                    refreshParkingList();
//                    return;
//                }
//            }
//            successLabel.setText("Parking Spot ID does not exist");
//        }
//
//        // Method to set a parking space under maintenance
//        private static void setUnderMaintenance(String parkingSpotId) {
//            for (ParkingComponent parking : parkingSpaces) {
//                if (parking.getId().equals(parkingSpotId)) {
//                    parking.setUnderMaintenance(true);
//                    successLabel.setText("Parking Spot " + parkingSpotId + " is now Under Maintenance");
//                    refreshParkingList();
//                    return;
//                }
//            }
//            successLabel.setText("Parking Spot ID does not exist");
//        }
//
//		
//    }

package com.parkingapp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;

public class ParkingServices {

    private static ArrayList<ParkingComponent> parkingSpaces = new ArrayList<>();
    private static DefaultListModel<ParkingComponent> listModel;
<<<<<<< HEAD
    private static JList<ParkingComponent> parkingList;
    private static JFrame frame;
    private static JPanel panel;
    private static JTextField parkingSpotInput;
    private static JButton addParkingButton;
    private static JButton enableParkingButton;
    private static JButton disableParkingButton;
    private static JTextArea successLabel;

    public static void main(String[] args) {
        // Create some initial parking spaces
        parkingSpaces.add(new ParkingSpace("A1", "Regular"));
        parkingSpaces.add(new ParkingSpace("A2", "Regular"));
        parkingSpaces.add(new ParkingSpace("B1", "Regular"));
        parkingSpaces.add(new ParkingSpace("B2", "Regular"));

        parkingServicesGUI();
    }

    public static void parkingServicesGUI() {
        frame = new JFrame("Admin Parking Services");
        panel = new JPanel();
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        JLabel parkingSpacesLabel = new JLabel("Parking Spaces");
        parkingSpacesLabel.setBounds(10, 20, 150, 25);
        panel.add(parkingSpacesLabel);

        // Parking JList to show available parking spaces
        listModel = new DefaultListModel<>();
        parkingList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(parkingList);
        scrollPane.setBounds(10, 50, 300, 150);
        panel.add(scrollPane);

        // Update the list with current parking spaces
        refreshParkingList();

        // Input for parking spot
        JLabel parkingSpotLabel = new JLabel("Parking Spot ID:");
        parkingSpotLabel.setBounds(10, 210, 150, 25);
        panel.add(parkingSpotLabel);

        parkingSpotInput = new JTextField();
        parkingSpotInput.setBounds(150, 210, 150, 25);
        panel.add(parkingSpotInput);

        // Buttons
        addParkingButton = new JButton("Add Parking");
        addParkingButton.setBounds(10, 240, 120, 30);
        addParkingButton.addActionListener(new ParkingServices());
        panel.add(addParkingButton);

        enableParkingButton = new JButton("Enable Parking");
        enableParkingButton.setBounds(140, 240, 120, 30);
        enableParkingButton.addActionListener(new ParkingServices());
        panel.add(enableParkingButton);

        disableParkingButton = new JButton("Disable Parking");
        disableParkingButton.setBounds(270, 240, 120, 30);
        disableParkingButton.addActionListener(new ParkingServices());
        panel.add(disableParkingButton);

        // Removed the "Under Maintenance" button and method

        successLabel = new JTextArea();
        successLabel.setBounds(10, 320, 350, 30);
        successLabel.setBackground(Color.GRAY);
        successLabel.setForeground(Color.WHITE);
        successLabel.setEditable(false);
        panel.add(successLabel);

        frame.setVisible(true);
    }

    // This method updates the JList with the current parking spaces' status
    private static void refreshParkingList() {
        listModel.clear(); // Clear the previous list
        for (ParkingComponent p : parkingSpaces) {
            listModel.addElement(p);
        }
    }

    // Action handler for buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        String parkingSpotId = parkingSpotInput.getText();

        if (e.getSource() == addParkingButton) {
            addParking(parkingSpotId);
        } else if (e.getSource() == enableParkingButton) {
            enableParking(parkingSpotId);
        } else if (e.getSource() == disableParkingButton) {
            disableParking(parkingSpotId);
        }
    }

    // Method to add a parking space
    private static void addParking(String parkingSpotId) {
        if (parkingSpotId != null && !parkingSpotId.isEmpty()) {
            // Create a new ParkingSpace with "Regular" type (for example)
            ParkingComponent newParking = new ParkingSpace(parkingSpotId, "Regular");
            parkingSpaces.add(newParking);
            successLabel.setText("Parking Spot " + parkingSpotId + " Added");
            refreshParkingList();
        } else {
            successLabel.setText("Please enter a valid Parking Spot ID");
        }
    }

    // Method to enable a parking space
    private static void enableParking(String parkingSpotId) {
        for (ParkingComponent parking : parkingSpaces) {
            if (parking.getId().equals(parkingSpotId)) {
                parking.enable();  // Call interface method
                successLabel.setText("Parking Spot " + parkingSpotId + " Enabled");
                refreshParkingList();
                return;
            }
        }
        successLabel.setText("Parking Spot ID does not exist");
    }

    // Method to disable a parking space
    private static void disableParking(String parkingSpotId) {
        for (ParkingComponent parking : parkingSpaces) {
            if (parking.getId().equals(parkingSpotId)) {
                parking.disable(); // Call interface method
                successLabel.setText("Parking Spot " + parkingSpotId + " Disabled");
                refreshParkingList();
                return;
            }
        }
        successLabel.setText("Parking Spot ID does not exist");
    }

    // Removed setUnderMaintenance(String parkingSpotId)
    // Instead, "maintenance" is logically covered by disable() or enable()
}

=======
//    private static JList<ParkingComponent> parkingList;
//    private static JFrame frame;
//    private static JPanel panel;
//    private static JTextField parkingSpotInput;
//    private static JButton addParkingButton;
//    private static JButton enableParkingButton;
//    private static JButton disableParkingButton;
//    private static JTextArea successLabel;

    public static void main(String[] args) {
        // Create some initial parking spaces
//        parkingSpaces.add(new ParkingSpace("A1", "Regular"));
//        parkingSpaces.add(new ParkingSpace("A2", "Regular"));
//        parkingSpaces.add(new ParkingSpace("B1", "Regular"));
//        parkingSpaces.add(new ParkingSpace("B2", "Regular"));
    }

//    // This method updates the JList with the current parking spaces' status
//    private static void refreshParkingList() {
//        listModel.clear(); // Clear the previous list
//        for (ParkingComponent p : parkingSpaces) {
//            listModel.addElement(p);
//        }
//    }

    // Action handler for buttons
 
    // Method to add a parking LOT
    private static void addParkingLot(String parkingLotId) {
    	ParkingLot create = new ParkingLot(parkingLotId);
    	System.out.println(create.getId());
    	System.out.println(create);
    	//Add REST functions for database
    }

    // Method to enable a parking LOT
    private static void enableParkingLot(ParkingLot lot) {
        lot.enable();
        //Add REST function to enable all parkingspots in lot
    	
    }

    // Method to disable a parking LOT
    private static void disableParkingLot(ParkingLot lot) {
        lot.disable();
      //Add REST function to enable all parkingspots in lot
    }
    
    private static void enableParkingSpace(ParkingSpace spot) {
    	spot.enable();
    	
    }

    private static void disableParkingSpace(ParkingSpace spot) {
    	spot.disable();
    	
    }
    // Removed setUnderMaintenance(String parkingSpotId)
    // Instead, "maintenance" is logically covered by disable() or enable()
}
>>>>>>> 860184b65e15b1036277d933bf81b2193ed9eccf
