package services;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.SetOptions;
import com.parkingapp.UserLogin;
import org.json.JSONObject; // Keep for potential internal use or structured error return
import services.FirebaseInitialization; // Assuming this handles Firestore setup

import javax.swing.*; // Keep for potential error display *if* service needs standalone feedback
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class UserLoginService {

    // API Key and URLs for Firebase Authentication
    // IMPORTANT: Keep your API_KEY secure. Consider loading it from a config file or environment variable.
    private static final String API_KEY =
            "Systemenv.get(API_KEY)"; // PASTE YOUR API KEY HERE
    private static final String SIGN_IN_URL =
            "" + API_KEY;
    private static final String SIGN_UP_URL =
            "" + API_KEY;

    private Firestore db; // Firestore instance

    /**
     * Constructor: Initializes the Firestore database connection.
     * Throws RuntimeException if initialization fails.
     */
    public UserLoginService() {
        initializeFirebase();
    }

    /**
     * Initializes the Firestore database connection using FirebaseInitialization service.
     */
    private void initializeFirebase() {
        try {
            db = FirebaseInitialization.getInstance();
            System.out.println("Firestore instance obtained successfully in UserLoginService.");
        } catch (RuntimeException e) {
            System.err.println("Firebase Initialization Error in UserLoginService: " + e.getMessage());
            // Re-throw or handle as appropriate for the service layer
            // For now, re-throwing allows the calling logic layer to handle it.
            throw new RuntimeException("Firebase initialization failed in Service: " + e.getMessage(), e);
        }
    }

    /**
     * Performs the HTTP POST request for signing in via Firebase Authentication REST API.
     * @param email User's email.
     * @param password User's password.
     * @return The raw JSON response string from Firebase (success or error).
     * @throws IOException If a network error occurs during the request.
     */
    public String signInUser(String email, String password) throws IOException {
        URL url = new URL(SIGN_IN_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        // Construct JSON payload
        String jsonInputString = "{\"email\":\"" + email + "\",\"password\":\"" + password + "\",\"returnSecureToken\":true}";

        // Send request body
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Read and return response (handles both success and error streams)
        return getResponse(conn);
    }

    /**
     * Performs the HTTP POST request for signing up via Firebase Authentication REST API.
     * @param email User's email.
     * @param password User's password.
     * @return The raw JSON response string from Firebase (success or error).
     * @throws IOException If a network error occurs during the request.
     */
    public String signUpUser(String email, String password) throws IOException {
        URL url = new URL(SIGN_UP_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        // Construct JSON payload
        String jsonInputString = "{\"email\":\"" + email + "\",\"password\":\"" + password + "\",\"returnSecureToken\":true}";

        // Send request body
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        // Read and return response (handles both success and error streams)
        return getResponse(conn);
    }

    /**
     * Stores additional user information (like userType) in Firestore after successful registration.
     * @param uid User's unique ID from Firebase Authentication.
     * @param email User's email.
     * @param userType User's selected type (using the enum from UserLogin).
     */
    public void storeNewUserInfo(String uid, String email, UserLogin.UserType userType) {
        if (db == null) {
            System.err.println("Firestore database is not initialized in Service. Cannot store user info.");
            // Consider throwing a specific exception or returning a boolean status
            // For now, just logging the error. The logic layer might show a generic error.
            return;
        }
        try {
            DocumentReference docRef = db.collection("users").document(uid);
            Map<String, Object> data = new HashMap<>();
            data.put("email", email);
            data.put("userType", userType.name()); // Store enum name as String
            data.put("balance", 0.0); // Initial balance

            // Asynchronous write - no blocking '.get()'
            docRef.set(data, SetOptions.merge());
            System.out.println("Firestore user info store request sent for UID: " + uid);

        } catch (Exception e) {
            // Catch potential exceptions during Firestore operation
            System.err.println("Firestore Error during user info storage for UID " + uid + ": " + e.getMessage());
            e.printStackTrace();
            // Optionally re-throw a custom exception if the caller needs to know about storage failure
            // throw new RuntimeException("Failed to store user info in Firestore", e);
        }
    }


    /**
     * Reads the response body from an HttpURLConnection.
     * Handles both success (200-299) and error streams (>=400).
     * @param conn The active HttpURLConnection.
     * @return The response body as a String.
     * @throws IOException If reading the stream fails.
     */
    private String getResponse(HttpURLConnection conn) throws IOException {
        int responseCode = conn.getResponseCode();
        BufferedReader br = null;
        StringBuilder response = new StringBuilder();
        String line;
        InputStream streamToRead = null;

        try {
            if (responseCode >= HttpURLConnection.HTTP_OK && responseCode < HttpURLConnection.HTTP_BAD_REQUEST) {
                // Read success stream
                streamToRead = conn.getInputStream();
            } else {
                // Read error stream for non-successful responses
                streamToRead = conn.getErrorStream();
            }

            // If there's a stream (success or error), read it
            if (streamToRead != null) {
                br = new BufferedReader(new InputStreamReader(streamToRead, "utf-8"));
                while ((line = br.readLine()) != null) {
                    response.append(line.trim());
                }
            } else if (responseCode >= HttpURLConnection.HTTP_BAD_REQUEST) {
                // No error stream, but it's an error code. Construct basic error JSON.
                return "{\"error\":{\"message\":\"HTTP Error " + responseCode + "\",\"code\":" + responseCode + "}}";
            }
            // If successful but no stream, return empty string (shouldn't happen often with JSON APIs)
            // If not an error and no stream, return empty.

        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace(); // Log closing error, but proceed
                }
            }
            // Ensure connection stream is closed if manually handled, but try-with-resources is better for input streams.
            // Disconnect is handled automatically by HttpURLConnection usually after streams are closed/consumed.
        }
        return response.toString();
    }
}
