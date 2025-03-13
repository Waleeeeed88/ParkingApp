package com.parkingapp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;

public class ParkingServices {

    private static ArrayList<ParkingComponent> parkingSpaces = new ArrayList<>();
    private static DefaultListModel<ParkingComponent> listModel;
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