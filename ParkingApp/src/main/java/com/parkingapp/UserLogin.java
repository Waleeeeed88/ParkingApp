package com.parkingapp;

import com.parkingapp.GUI.UserLoginGUI; // Import the GUI class
import org.json.JSONObject; // Still needed to parse results from Service
import services.UserLoginService;

import javax.swing.*; // Needed for SwingWorker and JOptionPane
import java.util.prefs.Preferences;
// Removed Firebase/Firestore/Network imports, keep others needed for logic/UI interaction

public class UserLogin { // No longer extends JFrame

    // UserType Enum remains here as it relates to application logic/data model
    public enum UserType {
        STUDENT, FACULTY, NON_FACULTY, VISITOR
    }

    private UserLoginGUI userLoginGUI; // Reference to the GUI
    private UserLoginService userLoginService; // Reference to the Service layer

    /**
     * Constructor: Initializes the UserLogin logic component.
     * Creates an instance of the UserLoginService.
     */
    public UserLogin() {
        try {
            this.userLoginService = new UserLoginService();
        } catch (RuntimeException e) {
            // Handle service initialization failure (e.g., Firestore unavailable)
            System.err.println("Failed to initialize UserLoginService: " + e.getMessage());
            JOptionPane.showMessageDialog(null, // No parent frame available yet
                    "Critical Error: Could not connect to backend services.\n" + e.getMessage() + "\nPlease check configuration and try again.",
                    "Initialization Error",
                    JOptionPane.ERROR_MESSAGE);
            // Consider exiting the application if the service is essential
            System.exit(1);
        }
    }

    /**
     * Sets the reference to the GUI instance.
     * @param gui The UserLoginGUI instance.
     */
    public void setGUIReference(UserLoginGUI gui) {
        this.userLoginGUI = gui;
    }

    /**
     * Handles the login logic triggered by the GUI.
     * Uses SwingWorker to call the service in the background.
     * @param email User's email.
     * @param password User's password.
     */
    public void performLogin(String email, String password) {
        // Optional: Add validation here if not fully handled by GUI
        // if (!isValidEmail(email) || password.isEmpty()) { ... }

        // Use SwingWorker to perform network operations via the service off the EDT
        new SwingWorker<String, Void>() {
            @Override
            protected String doInBackground() throws Exception {
                // Delegate the actual sign-in network call to the service
                return userLoginService.signInUser(email, password);
            }

            @Override
            protected void done() {
                try {
                    String response = get(); // Get the JSON result string from doInBackground
                    JSONObject jsonResponse = new JSONObject(response);

                    if (jsonResponse.has("idToken")) {
                        // Login Successful
                        String uid = jsonResponse.getString("localId");
                        saveUserSession(uid); // Save session locally

                        // Navigate to the next page
                        navigateToBookingPage();

                    } else if (jsonResponse.has("error")) {
                        // Login Failed - Handle error JSON returned by service
                        handleFirebaseErrorResponse(jsonResponse);
                    } else {
                        // Unexpected response format from service
                        showErrorMessage("Login Failed: Unexpected response from server.", "Error");
                    }
                } catch (Exception ex) {
                    // Handle exceptions during background task (e.g., network IOExceptions passed up)
                    System.err.println("Exception in login worker done(): " + ex.getMessage());
                    ex.printStackTrace();
                    showErrorMessage("Login Failed: " + ex.getMessage(), "Error");
                }
                System.out.println("Login worker done() finished.");
            }
        }.execute();
    }

    /**
     * Handles the registration logic triggered by the GUI.
     * Uses SwingWorker to call the service in the background.
     * @param email User's email.
     * @param password User's password.
     * @param selectedUserType User's selected type.
     */
    public void performRegistration(String email, String password, UserType selectedUserType) {
        // Optional: Add validation here if not fully handled by GUI
        // if (password.length() < 6) { ... }
        // if (selectedUserType == null) { ... }

        new SwingWorker<String, Void>() {
            @Override
            protected String doInBackground() throws Exception {
                // 1. Call the sign-up service method
                String signUpResponse = userLoginService.signUpUser(email, password);

                // 2. Check response and potentially store user info if successful
                JSONObject jsonResponse = new JSONObject(signUpResponse);
                if (jsonResponse.has("localId")) {
                    String uid = jsonResponse.getString("localId");
                    // Call service to store additional info (fire-and-forget or handle errors if needed)
                    userLoginService.storeNewUserInfo(uid, email, selectedUserType);
                }
                // Return the original sign-up response for the 'done' method to process
                return signUpResponse;
            }

            @Override
            protected void done() {
                try {
                    String response = get(); // Get the result from doInBackground (sign-up response)
                    JSONObject jsonResponse = new JSONObject(response);

                    if (jsonResponse.has("idToken")) { // Check for idToken or localId for success
                        // Registration Successful
                        String uid = jsonResponse.getString("localId");
                        saveUserSession(uid); // Save session locally

                        SwingUtilities.invokeLater(() ->
                        JOptionPane.showMessageDialog(userLoginGUI,
                            "Registration successful!  You can now login with your new credentials.",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE)
                        );
                        
                        // Navigate back to the userLogin page
                        if (userLoginGUI != null) {
                            userLoginGUI.showPanel("login");   //navigate back to Login page
                        }

                    } else if (jsonResponse.has("error")) {
                        // Registration Failed - Handle error JSON
                        handleFirebaseErrorResponse(jsonResponse);
                    } else {
                        // Unexpected response format
                        showErrorMessage("Registration Failed: Unexpected response from server.", "Error");
                    }
                } catch (Exception ex) {
                    // Handle exceptions during background task
                    System.err.println("Exception in registration worker done(): " + ex.getMessage());
                    ex.printStackTrace();
                    showErrorMessage("Registration Failed: " + ex.getMessage(), "Error");
                }
                System.out.println("Registration worker done() finished.");
            }
        }.execute();
    }

    /**
     * Saves the user's UID to preferences for session management.
     * @param uid The user's unique ID.
     */
    public void saveUserSession(String uid) {
        Preferences prefs = Preferences.userNodeForPackage(UserLogin.class);
        prefs.put("user_uid", uid);
        System.out.println("UID saved to preferences: " + uid);
    }

    /**
     * Handles closing the current login window and opening the booking page.
     */
    private void navigateToBookingPage() {
        // 1. Close the login window
        if (userLoginGUI != null) {
            userLoginGUI.closeWindow(); // Calls dispose() on the UserLoginGUI JFrame
            System.out.println("Login GUI close requested.");
        } else {
            System.out.println("WARN: Login GUI reference was null when trying to close.");
        }

        // 2. Create instances for the NEXT screen (Booking Page)
        // Ensure this runs on the Event Dispatch Thread if it modifies Swing components directly
        // SwingUtilities.invokeLater(() -> { // Often needed if BookingPageGUI constructor does heavy UI setup
        System.out.println("Creating BookingPage logic...");
        com.parkingapp.GUI.BookingPage bookingLogic = new com.parkingapp.GUI.BookingPage(); // Logic class

        System.out.println("Creating BookingPageGUI...");
        // Instantiate the GUI, passing the logic instance. Assume GUI shows itself.
        com.parkingapp.GUI.BookingPageGUI bookingGUI = new com.parkingapp.GUI.BookingPageGUI(bookingLogic);

        System.out.println("Setting GUI reference in BookingPage logic...");
        bookingLogic.setGUIReference(bookingGUI); // Link logic back to its GUI

        System.out.println("Navigation to Booking Page complete.");
        // });
    }


    /**
     * Parses and displays Firebase error messages from the JSON response using JOptionPane.
     * @param jsonResponse The JSONObject containing the error details (as returned by the service).
     */
    private void handleFirebaseErrorResponse(JSONObject jsonResponse) {
        System.err.println("Firebase error response received by logic layer: " + jsonResponse.toString());
        try {
            // Standard Firebase Auth REST API error structure
            JSONObject error = jsonResponse.getJSONObject("error");
            String message = error.getString("message");
            // Display error in a dialog
            showErrorMessage("Operation Failed: " + message, "Firebase Error");
        } catch (Exception e) {
            // Error parsing the error response itself
            System.err.println("Error parsing the error JSON: " + e.getMessage());
            showErrorMessage("An unexpected error occurred processing the server response.", "Error");
        }
    }

    /**
     * Helper method to show error messages consistently using JOptionPane.
     * Ensures it runs on the EDT.
     * @param message The error message text.
     * @param title The dialog window title.
     */
    private void showErrorMessage(String message, String title) {
        // Ensure dialogs are shown on the Event Dispatch Thread
        SwingUtilities.invokeLater(() ->
                JOptionPane.showMessageDialog(null, // Use null if GUI ref might be unavailable early
                        message,
                        title,
                        JOptionPane.ERROR_MESSAGE)
        );
    }

    // Main method to start the application
    public static void main(String[] args) {
        // Ensure GUI creation happens on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            try {
                UserLogin logic = new UserLogin(); // Creates logic & initializes service
                UserLoginGUI gui = new UserLoginGUI(logic); // Create GUI, passing logic instance
                logic.setGUIReference(gui); // Link logic back to GUI
                // The UserLoginGUI constructor should handle making the window visible.
            } catch (Exception e) {
                System.err.println("Application startup failed: " + e.getMessage());
                e.printStackTrace();
                // Show a final error message if startup fails badly
                JOptionPane.showMessageDialog(null,
                        "Application failed to start: " + e.getMessage(),
                        "Fatal Error",
                        JOptionPane.ERROR_MESSAGE);
                System.exit(1); // Exit if essential components fail
            }
        });
    }
}