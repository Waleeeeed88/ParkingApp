package com.parkingapp.parkingObjects;
import services.ParkingServicesFirestore;
public class ParkingServices {
    /*
     * Firbase operations are done in the ParkingServicesFirestore class
     * =================================================================
     * Methods to Add, enable/disable ParkingLots
     * =================================================================
     */
    // Method to add a parking LOT
    //creation of new parking lot
    public void addParkingLot(String parkingLotId) {
        ParkingLot create = new ParkingLot(parkingLotId);
        System.out.println(create.getId());
        System.out.println(create);
        //Add functions for database
        ParkingServicesFirestore.storeAddLotInfoInFirestore(create);

    }
    // Method to enable a parking LOT
    public void enableParkingLot(ParkingLot lot) {
        lot.enable();
        //Add function to enable all parkingspots in lot
        ParkingServicesFirestore.storeEnabledLotInfoInFirestore(lot);
    }
    // Method to disable a parking LOT
    public void disableParkingLot(ParkingLot lot) {
        lot.disable();
        //Add function to enable all parkingspots in lot
        ParkingServicesFirestore.storeEnabledLotInfoInFirestore(lot);

    }

    /*
     * =================================================================
     * Methods to enable/disable Parking Spaces
     * =================================================================
     */
    public void enableParkingSpace(ParkingSpace spot) {
        spot.enable();
        ParkingServicesFirestore.storeSingleSpaceInfoInFirestore(spot);

    }

    public void disableParkingSpace(ParkingSpace spot) {
        spot.disable();
        ParkingServicesFirestore.storeSingleSpaceInfoInFirestore(spot);

    }

}