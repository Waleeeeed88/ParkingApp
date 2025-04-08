package services;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.cloud.firestore.Firestore;

import java.io.InputStream;
import java.io.IOException;

/**
 * Singleton class for Firestore database.
 */
public class FirebaseInitialization {

    // Holds our one and only Firestore instance
    private static Firestore instance;

    // Private constructor prevents instantiation from outside
    private FirebaseInitialization() {
    }

    /**
     * Thread-safe retrieval of a single Firestore instance.
     */
    public static Firestore getInstance() {
        if (instance == null) {
            synchronized (FirebaseInitialization.class) {
                if (instance == null) {
                    // Initialize Firestore once
                    instance = initializeFirestore();
                }
            }
        }
        return instance;
    }

    private static Firestore initializeFirestore() {
        try {
            // Load the service account key from resources or your local file path
            InputStream serviceAccount = FirebaseInitialization.class.getClassLoader()
                                        .getResourceAsStream("google-services.json");
            if (serviceAccount == null) {
                throw new IOException("google-services.json not found in resources directory.");
            }

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            // Only initialize FirebaseApp once
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
            return FirestoreClient.getFirestore();
        } catch (IOException e) {
            System.err.println("Error initializing Firestore: " + e.getMessage());
            throw new RuntimeException("Could not initialize Firestore", e);
        }
    }
}
