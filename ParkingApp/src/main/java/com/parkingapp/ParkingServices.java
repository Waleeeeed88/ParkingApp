package com.parkingapp;
import services.FirebaseInitialization;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import javax.swing.JOptionPane;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.parkingapp.UserLogin.UserType;
import com.google.cloud.firestore.WriteBatch;
public class ParkingServices {
	
	public static void main(String[] args) {
	    // Create a parking lot
	    ParkingLot lot1 = new ParkingLot("Downtown Lot");

	    // Get the first parking space from lot1
	    ParkingSpace lot1space1 = (ParkingSpace) lot1.getParkingSpaces().get(0);
	    
	    ParkingLot lot2 = new ParkingLot("York");
	    ParkingSpace lot2space1 = (ParkingSpace) lot2.getParkingSpaces().get(0);
	    
	    
	    // Print details of the first parking space
	    System.out.println("First Parking Space ID: " + lot1space1.getId());
	    System.out.println("Parent Lot ID: " + lot1space1.getParentId());
	    System.out.println("Is Enabled: " + lot1space1.isEnabled());
	    System.out.println("Is Occupied: " + lot1space1.isOccupied());
	    System.out.println("Is Enabled: " + lot1space1.isEnabled());
	    lot1.disable();
	    System.out.println("Is Enabled: " + lot1space1.isEnabled());
	    System.out.println("Is Enabled: " + lot2space1.isEnabled());
	}
	Firestore database = FirebaseInitialization.getInstance();	//instance held in database
    /*
     * =================================================================
     * Methods to Add, enable/disable ParkingLots
     * =================================================================
     */
    // Method to add a parking LOT
    //creation of new parking lot
    public void addParkingLot(String parkingLotId) {
    	ParkingLot create = new ParkingLot(parkingLotId);
    	
    	//storeAddLotInfoInFirestore();
    	System.out.println(create.getId());
    	System.out.println(create);
    	//Add REST functions for database
    	storeAddLotInfoInFirestore(create);
    	
    }
    // Method to enable a parking LOT
    public void enableParkingLot(ParkingLot lot) {
        lot.enable();
        //Add REST function to enable all parkingspots in lot	
        storeEnabledLotInfoInFirestore(lot);
    }
    // Method to disable a parking LOT
    public void disableParkingLot(ParkingLot lot) {
        lot.disable();
      //Add REST function to enable all parkingspots in lot
        storeEnabledLotInfoInFirestore(lot);

    }
    
    /*
     * =================================================================
     * Methods to enable/disable Parking Spaces
     * =================================================================
     */
    public void enableParkingSpace(ParkingSpace spot) {
    	spot.enable();
    	
    }

    public static void disableParkingSpace(ParkingSpace spot) {
    	spot.disable();
    	
    }
    /*
     * =================================================================
     * Firebase Operations
     * 
     * =================================================================
     */
//    public ParkingLot showAllParkingLots() {
//    	datab.collection("cities")
//        .whereEqualTo("capital", true)
//        .get()
//        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                if (task.isSuccessful()) {
//                    for (QueryDocumentSnapshot document : task.getResult()) {
//                        Log.d(TAG, document.getId() + " => " + document.getData());
//                    }
//                } else {
//                    Log.d(TAG, "Error getting documents: ", task.getException());
//                }
//            }
//        });
//    	
//    }
    /*
     * ADD LOT TO FIRESTORE DB
     */
private void storeAddLotInfoInFirestore(ParkingLot parkingLot) {
        try {
            // Reference to Firestore collection for parking lots
            DocumentReference lotDocRef = database.collection("Parking_spaces").document(parkingLot.getId());

            // Prepare data for the parking lot
            Map<String, Object> lotData = new HashMap<>();
            lotData.put("id", parkingLot.getId());
            lotData.put("enabled", parkingLot.isEnabled()); // Defaults to true

            // Store the parking lot document
            WriteResult lotResult = lotDocRef.set(lotData, SetOptions.merge()).get();
            System.out.println("Parking Lot added: " + parkingLot.getId() + " at " + lotResult.getUpdateTime());

            // Reference to the subcollection "parkingSpaces" inside the lot
            CollectionReference spacesCollection = lotDocRef.collection("parkingSpaces");

            // Create a batch write instance
            WriteBatch batch = database.batch();

            // Add each parking space to the batch write
            for (ParkingComponent space : parkingLot.getParkingSpaces()) {
                if (space instanceof ParkingSpace) {
                    ParkingSpace ps = (ParkingSpace) space;

                    // Prepare data for the parking space
                    Map<String, Object> spaceData = new HashMap<>();
                    spaceData.put("id", ps.getId());
                    spaceData.put("parentId", ps.getParentId()); // Reference to the parent lot
                    spaceData.put("enabled", ps.isEnabled());
                    spaceData.put("occupied", ps.isOccupied());

                    // Add set operation to the batch instead of executing immediately
                    DocumentReference spaceDocRef = spacesCollection.document(ps.getId());
                    batch.set(spaceDocRef, spaceData, SetOptions.merge());
                }
            }

            // Commit the batch write, which writes all documents at once
            batch.commit().get();
            System.out.println("All parking spaces added in batch under lot " + parkingLot.getId());

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Firestore Error: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    
    /*
     * DISABLE LOT IN FIRESTORE DB
     */
    private void storeEnabledLotInfoInFirestore(ParkingLot parkingLot) { 
        try {
            // Reference to Firestore document for this parking lot
            DocumentReference lotDocRef = database.collection("Parking_spaces").document(parkingLot.getId());

            // Prepare data to update only the lot's status
            Map<String, Object> lotData = new HashMap<>();
            lotData.put("enabled", parkingLot.isEnabled()); // This should be false now

            // Store updated lot status in Firestore
            WriteResult lotResult = lotDocRef.set(lotData, SetOptions.merge()).get();
            System.out.println("Parking Lot " + parkingLot.getId() + " disabled at " + lotResult.getUpdateTime());

            // Reference to the "parkingSpaces" subcollection
            CollectionReference spacesCollection = lotDocRef.collection("parkingSpaces");

            // Disable all parking spaces in Firestore
            List<ApiFuture<WriteResult>> futures = new ArrayList<>();

            for (ParkingComponent space : parkingLot.getParkingSpaces()) {
                if (space instanceof ParkingSpace) {
                    ParkingSpace ps = (ParkingSpace) space;

                    // Prepare updated data for the parking space
                    Map<String, Object> spaceData = new HashMap<>();
                    spaceData.put("enabled", ps.isEnabled()); // Should be false now

                    // Update Firestore document for this parking space
                    ApiFuture<WriteResult> future = spacesCollection.document(ps.getId()).set(spaceData, SetOptions.merge());
                    futures.add(future);
                }
            }

            // Ensure all Firestore writes are completed
            for (ApiFuture<WriteResult> future : futures) {
                future.get();
            }

            System.out.println("All parking spaces under lot " + parkingLot.getId() + " disabled in Firestore.");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Firestore Error: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
