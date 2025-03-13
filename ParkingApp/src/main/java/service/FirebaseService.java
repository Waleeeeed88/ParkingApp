package service;

//import com.parkingapp.AdminDashboard;


import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

import com.google.firebase.cloud.FirestoreClient;

import java.util.HashMap;
import java.util.Map;

@Service
public class FirebaseService {
//	public String addParkingDetails( ParkingSpace parking) {
//		Firestore dbFirestore = FirestoreClient
//	}
	
//	/**
//     * Fetch parking spaces data from Firestore.
//     * Ensure correct Firestore field names are used.
//     */
//    public List<QueryDocumentSnapshot> fetchParkingSpacesFromFirestore() {
//        Firestore db = FirestoreClient.getFirestore();
//        ApiFuture<QuerySnapshot> future = db.collection("Parking_spaces").get();
//
//        try {
//            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
//
//            if (documents.isEmpty()) {
//                System.out.println("No parking spaces found in Firestore.");
//            }
//
//            return documents;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException("Error fetching parking spaces from Firestore", e);
//        }
//    }
	 
}