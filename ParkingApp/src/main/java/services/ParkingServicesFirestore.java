package services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.WriteBatch;
import com.google.cloud.firestore.WriteResult;
import com.parkingapp.parkingObjects.ParkingComponent;
import com.parkingapp.parkingObjects.ParkingLot;
import com.parkingapp.parkingObjects.ParkingSpace;

public class ParkingServicesFirestore {
	private static Firestore database = FirebaseInitialization.getInstance();	//instance held in database
	
	
	/**
	 * Method to add a parking lot and its parking spaces to Firestore.
	 * 
	 * @param parkingLot The ParkingLot object to be added.
	 */
	public static void storeAddLotInfoInFirestore(ParkingLot parkingLot) {
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
	
	public static void storeEnabledLotInfoInFirestore(ParkingLot parkingLot) { 
        try {
            // Reference to Firestore document for this parking lot
            DocumentReference lotDocRef = database.collection("Parking_spaces").document(parkingLot.getId());

            // Prepare data to update only the lot's status
            Map<String, Object> lotData = new HashMap<>();
            lotData.put("enabled", parkingLot.isEnabled()); // For example, false if disabling

            // Update the parking lot document in Firestore
            WriteResult lotResult = lotDocRef.set(lotData, SetOptions.merge()).get();
            System.out.println("Parking Lot " + parkingLot.getId() + " updated at " + lotResult.getUpdateTime());

            // Reference to the subcollection "parkingSpaces" inside the lot document
            CollectionReference spacesCollection = lotDocRef.collection("parkingSpaces");

            // Create a batch write instance to update all parking spaces at once
            WriteBatch batch = database.batch();

            // Loop over all parking spaces in the lot and add a set operation to the batch
            for (ParkingComponent space : parkingLot.getParkingSpaces()) {
                if (space instanceof ParkingSpace) {
                    ParkingSpace ps = (ParkingSpace) space;
                    Map<String, Object> spaceData = new HashMap<>();
                    spaceData.put("enabled", ps.isEnabled()); // Should match the current state (e.g., false)
                    DocumentReference spaceDocRef = spacesCollection.document(ps.getId());
                    batch.set(spaceDocRef, spaceData, SetOptions.merge());
                }
            }

            // Commit the batch write, so all parking space updates are sent in one operation
            List<WriteResult> results = batch.commit().get();
            System.out.println("Batch update complete: All parking spaces under lot " + parkingLot.getId() + " updated.");
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Firestore Error: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	public static void storeSingleSpaceInfoInFirestore(ParkingSpace space) {
    	try {
            // Reference to Firestore document for this specific parking space
            DocumentReference spaceDocRef = database.collection("Parking_spaces")
                    .document(space.getParentId()) // Get the parent parking lot
                    .collection("parkingSpaces")
                    .document(space.getId());

            // Prepare the update data
            Map<String, Object> spaceData = new HashMap<>();
            spaceData.put("enabled", space.isEnabled()); // Get the current status from the object

            // Commit update to Firestore
            WriteResult result = spaceDocRef.set(spaceData, SetOptions.merge()).get();
            System.out.println("Parking Space " + space.getId() + " enabled at " + result.getUpdateTime());

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Firestore Error: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    	
    }

}