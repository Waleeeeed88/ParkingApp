package com.parkingapp;

import java.util.*;
public class ParkingServices {
    /*
     * =================================================================
     * Methods to Add, enable/disable ParkingLots
     * =================================================================
     */
    // Method to add a parking LOT
    //creation of new parking lot
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
    
    /*
     * =================================================================
     * Methods to enable/disable Parking Spaces
     * =================================================================
     */
    private static void enableParkingSpace(ParkingSpace spot) {
    	spot.enable();
    	
    }

    private static void disableParkingSpace(ParkingSpace spot) {
    	spot.disable();
    	
    }
}
