package com.parkingapp;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.WriteResult;
import com.google.cloud.firestore.Firestore;
import org.json.JSONObject; // Ensure org.json library is available
import services.FirebaseInitialization;
import com.parkingapp.GUI.UserLoginGUI; // Import the GUI class

import javax.swing.*; // Still needed for JOptionPane
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;
import java.util.regex.Pattern; // Keep for validation if not done in GUI

public class UserLogin { // No longer extends JFrame

    // API Key and URLs for Firebase Authentication
    // IMPORTANT: Keep your API_KEY secure. Consider loading it from a config file or environment variable.
    private static final String API_KEY =
            "AIzaSyAeBBsBEyflDmEmfjwiX7rm0FuILDflss4"; // PASTE YOUR API KEY HERE
    private static final String SIGN_IN_URL =
            "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=" + API_KEY;
    private static final String SIGN_UP_URL =
            "https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=" + API_KEY;

    // UserType Enum
    public enum UserType {
        STUDENT, FACULTY, NON_FACULTY, VISITOR
    }

    private Firestore db; // Firestore instance
    private UserLoginGUI userLoginGUI; // Reference to the GUI

    public UserLogin() {
        initializeFirebase();
    }

    /**
     * Initializes the Firestore database connection.
     */
    private void initializeFirebase() {
        try {
            db = FirebaseInitialization.getInstance();
        } catch (RuntimeException e) {
            System.err.println("Firebase Initialization Error: " + e.getMessage());
            // Show error directly here, or pass status back to GUI to display
            JOptionPane.showMessageDialog(null, // No parent frame available directly
                    "Firebase initialization failed:\n" + e.getMessage(),
                    "Firebase Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Sets the reference to the GUI instance.
     * This allows the logic class to interact back with the GUI if needed
     * (e.g., to close the window or show specific messages).
     * @param gui The UserLoginGUI instance.
     */
    public void setGUIReference(UserLoginGUI gui) {
        this.userLoginGUI = gui;
    }

    /**
     * Handles the login logic. Called by the GUI.
     * @param email User's email.
     * @param password User's password.
     */
    public void performLogin(String email, String password) {
        // Optional: Add validation here if not fully handled by GUI
        // if (!isValidEmail(email) || password.isEmpty()) { ... }

        // Use SwingWorker to perform network operations off the EDT
        new SwingWorker<String, Void>() {
            @Override
            protected String doInBackground() throws Exception {
                return signIn(email, password); // Call the actual sign-in method
            }

            @Override
            protected void done() {
                try {
                    String response = get(); // Get the result from doInBackground
                    JSONObject jsonResponse = new JSONObject(response);

                    if (jsonResponse.has("idToken")) {
                        // Login Successful
                        String uid = jsonResponse.getString("localId");

                        // Save UID to preferences for session management
                        Preferences prefs = Preferences.userNodeForPackage(UserLogin.class);
                        prefs.put("user_uid", uid);
                        System.out.println("UID saved to preferences: " + uid);

                        // Close login window and open booking page
                        if (userLoginGUI != null) {
                            userLoginGUI.closeWindow();
                        }
                        // Ensure BookingPage constructor doesn't require params for now
                        // or pass necessary info
                        // --- CORRECTED NAVIGATION ---
                        System.out.println("Creating BookingPage logic..."); // Log
                        // Instantiate the BookingPage logic class
                        com.parkingapp.BookingPage bookingLogic = new com.parkingapp.BookingPage(); // Logic class (no setVisible)

                        System.out.println("Creating BookingPageGUI..."); // Log
                        // Instantiate the BookingPageGUI, passing the logic instance
                        com.parkingapp.GUI.BookingPageGUI bookingGUI = new com.parkingapp.GUI.BookingPageGUI(bookingLogic); // GUI class (JFrame, has setVisible via constructor)

                        System.out.println("Setting GUI reference in logic..."); // Log
                        // Link the logic back to the GUI
                        bookingLogic.setGUIReference(bookingGUI);

                        System.out.println("Navigation logic complete."); // Log
                        // NOTE: bookingGUI.setVisible(true) should be handled within the BookingPageGUI constructor itself.
                        // --- END CORRECTION ---

                    } else if (jsonResponse.has("error")) {
                        // Login Failed - Handle error
                        handleFirebaseError(jsonResponse);
                    } else {
                        // Unexpected response format
                        JOptionPane.showMessageDialog(null, "Login Failed: Unexpected response from server.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    // Handle exceptions during background task or getting result
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Login Failed: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }.execute();
    }

    /**
     * Handles the registration logic. Called by the GUI.
     * @param email User's email.
     * @param password User's password.
     * @param selectedUserType User's selected type.
     */
    public void performRegistration(String email, String password, UserType selectedUserType) {
        // Optional: Add validation here if not fully handled by GUI
        // if (!isValidEmail(email)) { ... }
        // if (password.length() < 6) { ... }
        // if (selectedUserType == null) { ... }

        new SwingWorker<String, Void>() {
            @Override
            protected String doInBackground() throws Exception {
                // Calls the actual sign-up network request
                return signUp(email, password);
            }

            @Override
            protected void done() {
                try {
                    String response = get(); // Get the result from doInBackground
                    JSONObject jsonResponse = new JSONObject(response);

                    if (jsonResponse.has("idToken")) {
                        // Login Successful
                        String uid = jsonResponse.getString("localId");

                        // Save UID to preferences for session management
                        Preferences prefs = Preferences.userNodeForPackage(UserLogin.class);
                        prefs.put("user_uid", uid);
                        System.out.println("UID saved to preferences: " + uid); // Log

                        // --- CORRECTED NAVIGATION ---
                        // 1. Close the login window
                        if (userLoginGUI != null) {
                            userLoginGUI.closeWindow(); // Calls dispose() on the UserLoginGUI JFrame
                            System.out.println("Login GUI close requested."); // Log
                        } else {
                            System.out.println("Login GUI reference was null when trying to close."); // Log
                        }

                        // 2. Create instances for the NEXT screen (Booking Page)
                        System.out.println("Creating BookingPage logic..."); // Log
                        // Instantiate the BookingPage logic class
                        com.parkingapp.BookingPage bookingLogic = new com.parkingapp.BookingPage(); // Logic class (no setVisible)

                        System.out.println("Creating BookingPageGUI..."); // Log
                        // Instantiate the BookingPageGUI, passing the logic instance
                        com.parkingapp.GUI.BookingPageGUI bookingGUI = new com.parkingapp.GUI.BookingPageGUI(bookingLogic); // GUI class (JFrame, has setVisible via constructor)

                        System.out.println("Setting GUI reference in logic..."); // Log
                        // Link the logic back to the GUI
                        bookingLogic.setGUIReference(bookingGUI);

                        System.out.println("Navigation logic complete."); // Log
                        // NOTE: bookingGUI.setVisible(true) should be handled within the BookingPageGUI constructor itself.

                        // --- END CORRECTION ---

                    } else if (jsonResponse.has("error")) {
                        // Login Failed - Handle error
                        handleFirebaseError(jsonResponse);
                    } else {
                        // Unexpected response format
                        JOptionPane.showMessageDialog(null, "Login Failed: Unexpected response from server.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    // Handle exceptions during background task or getting result
                    System.err.println("Exception in login worker done():"); // Log error
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Login Failed: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                System.out.println("Login worker done() finished."); // Log end
            }
        }.execute();
    }

    /**
     * Stores user information in Firestore after successful registration.
     * @param uid User's unique ID.
     * @param email User's email.
     * @param userType User's selected type.
     */
    private void storeUserInfoInFirestore(String uid, String email, UserType userType) {
        if (db == null) {
            System.err.println("Firestore database is not initialized. Cannot store user info.");
            JOptionPane.showMessageDialog(null, "Database connection error. Cannot save user details.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            DocumentReference docRef = db.collection("users").document(uid);
            Map<String, Object> data = new HashMap<>();
            data.put("email", email);
            data.put("userType", userType.name()); // Storing enum name as String
            data.put("balance", 0.0); // Initial balance

            // Asynchronous write - consider handling completion/failure if needed
            docRef.set(data, SetOptions.merge());
            // .get() was removed to make it async, add back if blocking is needed

            System.out.println("User info stored request sent for UID " + uid);

        } catch (Exception e) {
            // Catch potential exceptions during Firestore operation
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Firestore Error during user info storage: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Parses and displays Firebase error messages using JOptionPane.
     * @param jsonResponse The JSONObject containing the error details.
     */
    private void handleFirebaseError(JSONObject jsonResponse) {
        System.err.println("Firebase error response: " + jsonResponse.toString());
        try {
            JSONObject error = jsonResponse.getJSONObject("error");
            String message = error.getString("message");
            // Display error in a dialog
            JOptionPane.showMessageDialog(null, // Parent frame is tricky here, null works
                    "Operation Failed: " + message,
                    "Firebase Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An unexpected error occurred processing the server response.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // --- Network Communication Methods ---

    /**
     * Performs the actual HTTP POST request for signing in.
     * @param email User's email.
     * @param password User's password.
     * @return The raw JSON response string from Firebase.
     * @throws IOException If a network error occurs.
     */
    private String signIn(String email, String password) throws IOException {
        URL url = new URL(SIGN_IN_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        String jsonInputString = "{\"email\":\"" + email + "\",\"password\":\"" + password + "\",\"returnSecureToken\":true}";
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        return getResponse(conn); // Get response (success or error body)
    }

    /**
     * Performs the actual HTTP POST request for signing up.
     * @param email User's email.
     * @param password User's password.
     * @return The raw JSON response string from Firebase.
     * @throws IOException If a network error occurs.
     */
    private String signUp(String email, String password) throws IOException {
        URL url = new URL(SIGN_UP_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        String jsonInputString = "{\"email\":\"" + email + "\",\"password\":\"" + password + "\",\"returnSecureToken\":true}";
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        return getResponse(conn); // Get response (success or error body)
    }

    /**
     * Reads the response body from an HttpURLConnection.
     * Handles both success (200 OK) and error streams.
     * @param conn The active HttpURLConnection.
     * @return The response body as a String.
     * @throws IOException If reading the stream fails.
     */
    private String getResponse(HttpURLConnection conn) throws IOException {
        int responseCode = conn.getResponseCode();
        BufferedReader br = null;
        StringBuilder response = new StringBuilder();
        String line;

        try {
            if (responseCode >= HttpURLConnection.HTTP_OK && responseCode < HttpURLConnection.HTTP_BAD_REQUEST) {
                // Read success stream
                br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            } else {
                // Read error stream for non-successful responses
                InputStream errorStream = conn.getErrorStream();
                if (errorStream != null) {
                    br = new BufferedReader(new InputStreamReader(errorStream, "utf-8"));
                } else {
                    // No error stream, maybe just return status code info?
                    return "{\"error\":{\"message\":\"HTTP Error " + responseCode + "\",\"code\":" + responseCode + "}}";
                }
            }
            while ((line = br.readLine()) != null) {
                response.append(line.trim());
            }
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response.toString();
    }


    // Main method removed - application should be started differently now.
    // Example of how to start the application:

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UserLogin logic = new UserLogin();
            UserLoginGUI gui = new UserLoginGUI(logic);
            logic.setGUIReference(gui); // Link logic back to GUI if needed
        });
    }

}