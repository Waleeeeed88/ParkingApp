package services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.parkingapp.SuperAdminDashboard.AdminAccount;
import com.parkingapp.SuperAdminDashboard.AdminAccountData;

public class SuperAdminDashboardFirestore {
    private static final String COLLECTION_NAME = "admin_accounts";
    private Firestore db = FirebaseInitialization.getInstance();
	
	// Saves the admin account to Firebase Firestore.
    public void saveAdminAccountToFirebase(AdminAccount adminAccount)
            throws InterruptedException, ExecutionException {
        
        DocumentReference docRef = db.collection(COLLECTION_NAME).document(adminAccount.getUserId());
        AdminAccountData adminData = new AdminAccountData(adminAccount.getUserId(), adminAccount.getPassword());
        ApiFuture<WriteResult> result = docRef.set(adminData);
        result.get(); // Wait for operation completion.
    }

    // Retrieves existing admin accounts from Firebase Firestore.
    public List<String> fetchAdminAccountsFromFirestore() throws InterruptedException, ExecutionException {
        List<String> accounts = new ArrayList<>();
        ApiFuture<QuerySnapshot> future = db.collection(COLLECTION_NAME).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        for (QueryDocumentSnapshot document : documents) {
            String username = document.getString("admin_user");
            String password = document.getString("admin_password");
            accounts.add("Username: " + username + ", Password: " + password);
        }
        return accounts;
    }

}
