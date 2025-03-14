//package com.parkingapp;
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//import com.google.firebase.cloud.FirestoreClient;
//import com.google.cloud.firestore.Firestore;
//import com.google.cloud.firestore.DocumentReference;
//import com.google.cloud.firestore.SetOptions;
//import com.google.cloud.firestore.WriteResult;
//
//import javax.swing.*;
//import java.awt.*;
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.prefs.Preferences;
//import java.util.regex.Pattern;
//
//import org.json.JSONObject;
//
//public class UserLogin extends JFrame { // *** IMPORTANT: Extend JFrame
//
//    // Replace this with your own API key
//    private static final String API_KEY =
//            "AIzaSyAeBBsBEyflDmEmfjwiX7rm0FuILDflss4"; //  REPLACE WITH YOUR KEY!
//
//    private static final String SIGN_IN_URL =
//            "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=" + API_KEY;
//    private static final String SIGN_UP_URL =
//            "https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=" + API_KEY;
//
//    // Enum for user types
//    public enum UserType {
//        STUDENT, FACULTY, NON_FACULTY, VISITOR
//    }
//
//    private Firestore db; // Firestore instance
//
//    private JFrame frame; // Use a class-level JFrame
//    private CardLayout cardLayout;
//    private JPanel mainPanel;
//
//    private JTextField emailField, regEmailField;
//    private JPasswordField passwordField, regPasswordField;
//    private JComboBox<UserType> userTypeComboBox; // ComboBox for user type selection
//
//    public static void main(String[] args) {
//        // Use invokeLater to ensure GUI creation happens on the Event Dispatch Thread
//        SwingUtilities.invokeLater(() -> new UserLogin().createAndShowGUI()); // Call the method
//    }
//
//    // Constructor
//    public UserLogin() {
//        initializeFirebase();
//    }
//
//    private void initializeFirebase() {
//        try {
//            // Load the service account key from the resources folder.
//            InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("google-services.json");
//
//            if (serviceAccount == null) {
//                throw new IOException("google-services.json not found in resources directory.");
//            }
//
//            FirebaseOptions options = new FirebaseOptions.Builder()
//                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                    .build();
//
//            if (FirebaseApp.getApps().isEmpty()) {
//                FirebaseApp.initializeApp(options);
//            }
//            db = FirestoreClient.getFirestore(); // Initialize Firestore
//
//        } catch (IOException e) {
//            System.err.println("Firebase Initialization Error: " + e.getMessage());
//            JOptionPane.showMessageDialog(
//                    frame, // Use the frame as the parent
//                    "Firebase initialization failed:\n" + e.getMessage(),
//                    "Firebase Error",
//                    JOptionPane.ERROR_MESSAGE
//            );
//        }
//    }
//
//
//    private void createAndShowGUI() {
//        frame = new JFrame("Firebase Login App"); // Initialize the frame
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(600, 450);
//
//        cardLayout = new CardLayout();
//        mainPanel = new JPanel(cardLayout);
//
//        mainPanel.add(createLoginPanel(), "login");
//        mainPanel.add(createRegisterPanel(), "register");
//
//        frame.add(mainPanel);
//        frame.setLocationRelativeTo(null); // Center the frame
//        frame.setVisible(true); // Make the frame visible
//    }
//
//    private JPanel createLoginPanel() {
//        JPanel panel = new JPanel(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets = new Insets(10, 10, 10, 10);
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//
//        JLabel loginLabel = new JLabel("Login");
//        loginLabel.setFont(new Font("Arial", Font.BOLD, 28));
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.gridwidth = 2;
//        panel.add(loginLabel, gbc);
//
//        JLabel emailLabel = new JLabel("Email:");
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        gbc.gridwidth = 1;
//        panel.add(emailLabel, gbc);
//
//        emailField = new JTextField();
//        emailField.setPreferredSize(new Dimension(300, 35));
//        gbc.gridx = 1;
//        gbc.gridy = 1;
//        panel.add(emailField, gbc);
//
//        JLabel passwordLabel = new JLabel("Password:");
//        gbc.gridx = 0;
//        gbc.gridy = 2;
//        panel.add(passwordLabel, gbc);
//
//        passwordField = new JPasswordField();
//        passwordField.setPreferredSize(new Dimension(300, 35));
//        gbc.gridx = 1;
//        gbc.gridy = 2;
//        panel.add(passwordField, gbc);
//
//        JButton loginButton = new JButton("Login");
//        gbc.gridx = 0;
//        gbc.gridy = 3;
//        gbc.gridwidth = 2;
//        panel.add(loginButton, gbc);
//
//        JButton goToRegisterButton = new JButton("Create Account");
//        gbc.gridx = 0;
//        gbc.gridy = 4;
//        gbc.gridwidth = 2;
//        panel.add(goToRegisterButton, gbc);
//
//        JButton goToAdminLoginButton = new JButton("Admin Login");
//        gbc.gridx = 0;
//        gbc.gridy = 5;
//        gbc.gridwidth = 2;
//        panel.add(goToAdminLoginButton, gbc);
//
//        loginButton.addActionListener(e -> performLogin());
//        goToRegisterButton.addActionListener(e -> cardLayout.show(mainPanel, "register"));
//        goToAdminLoginButton.addActionListener(e -> new BaseLogin.ManagementLogin().setVisible(true)); //create admin page
//
//        return panel;
//    }
//
//    private JPanel createRegisterPanel() {
//        JPanel panel = new JPanel(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets = new Insets(10, 10, 10, 10);
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//
//        JLabel registerLabel = new JLabel("Register");
//        registerLabel.setFont(new Font("Arial", Font.BOLD, 28));
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.gridwidth = 2;
//        panel.add(registerLabel, gbc);
//
//        JLabel regEmailLabel = new JLabel("Email:");
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        gbc.gridwidth = 1;
//        panel.add(regEmailLabel, gbc);
//
//        regEmailField = new JTextField();
//        regEmailField.setPreferredSize(new Dimension(300, 35));
//        gbc.gridx = 1;
//        gbc.gridy = 1;
//        panel.add(regEmailField, gbc);
//
//        JLabel regPasswordLabel = new JLabel("Password:");
//        gbc.gridx = 0;
//        gbc.gridy = 2;
//        panel.add(regPasswordLabel, gbc);
//
//        regPasswordField = new JPasswordField();
//        regPasswordField.setPreferredSize(new Dimension(300, 35));
//        gbc.gridx = 1;
//        gbc.gridy = 2;
//        panel.add(regPasswordField, gbc);
//
//        // --- User Type Dropdown ---
//        JLabel userTypeLabel = new JLabel("User Type:");
//        gbc.gridx = 0;
//        gbc.gridy = 3;
//        panel.add(userTypeLabel, gbc);
//
//        userTypeComboBox = new JComboBox<>(UserType.values());
//        userTypeComboBox.setPreferredSize(new Dimension(300, 35));
//        gbc.gridx = 1;
//        gbc.gridy = 3;
//        panel.add(userTypeComboBox, gbc);
//        // ------------------------------
//
//        JButton registerButton = new JButton("Register");
//        gbc.gridx = 0;
//        gbc.gridy = 4;
//        gbc.gridwidth = 2;
//        panel.add(registerButton, gbc);
//
//        JButton backToLoginButton = new JButton("Back to Login");
//        gbc.gridx = 0;
//        gbc.gridy = 5;
//        gbc.gridwidth = 2;
//        panel.add(backToLoginButton, gbc);
//
//        registerButton.addActionListener(e -> performRegistration());
//        backToLoginButton.addActionListener(e -> cardLayout.show(mainPanel, "login"));
//
//        return panel;
//    }
//
//
//    private boolean isValidEmail(String email) {
//        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
//        Pattern pattern = Pattern.compile(emailRegex);
//        return pattern.matcher(email).matches();
//    }
//
//
//    private void performLogin() {
//        String email = emailField.getText();
//        String password = new String(passwordField.getPassword());
//        passwordField.setText(""); // Clear the password field
//
//        if (!isValidEmail(email) || password.isEmpty()) {
//            JOptionPane.showMessageDialog(frame, "Please enter a valid email and password",
//                    "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        new SwingWorker<String, Void>() {
//            @Override
//            protected String doInBackground() throws Exception {
//                try {
//                    String response = signIn(email, password); // Call your signIn method
//                    JSONObject jsonResponse = new JSONObject(response);
//                    if (jsonResponse.has("idToken")) {
//                        return response; // Return the *entire* response
//                    } else if (jsonResponse.has("error")) {
//                        handleFirebaseError(jsonResponse);
//                    }
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                    SwingUtilities.invokeLater(()->{
//                        JOptionPane.showMessageDialog(frame, "Login Failed: " + ex.getMessage(),
//                                "Error", JOptionPane.ERROR_MESSAGE);
//                    });
//                }
//                return null; // Return null if there was an error
//            }
//
//            @Override
//            protected void done() {
//                try {
//                    String response = get(); // Get the *response*
//                    if (response != null) {
//                        // Parse the JSON response to get the UID
//                        JSONObject jsonResponse = new JSONObject(response);
//                        String uid = jsonResponse.getString("localId");
//
//                        // Save the UID to Preferences (CRUCIAL!)
//                        Preferences prefs = Preferences.userNodeForPackage(UserLogin.class);
//                        prefs.put("user_uid", uid);
//                        System.out.println("UID saved to preferences: " + uid);
//
//                        frame.dispose(); // Close login window
//                        new BookingPage().setVisible(true); // Open booking page
//
//                    }
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                    JOptionPane.showMessageDialog(frame, "Login Failed: " + ex.getMessage(),
//                            "Error", JOptionPane.ERROR_MESSAGE); //improved error handling
//                }
//            }
//        }.execute(); // IMPORTANT: Call .execute() to run the SwingWorker
//    }
//
//
//    private void performRegistration() {
//        String email = regEmailField.getText();
//        String password = new String(regPasswordField.getPassword());
//        regPasswordField.setText(""); //clear password
//
//        // Get selected user type from combo box
//        UserType selectedUserType = (UserType) userTypeComboBox.getSelectedItem();
//
//        // --- Input Validation ---
//        if (!isValidEmail(email)) {
//            JOptionPane.showMessageDialog(frame, "Please enter a valid email address.",
//                    "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//        if (password.length() < 6) {
//            JOptionPane.showMessageDialog(frame, "Password must be at least 6 characters long.",
//                    "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//        if (selectedUserType == null) {
//            JOptionPane.showMessageDialog(frame, "Please select a user type.",
//                    "Error", JOptionPane.ERROR_MESSAGE);
//            return; // Ensure a user type is selected
//        }
//        // --- End Input Validation ---
//
//        new SwingWorker<Void, Void>() { // Use Void if not returning a result
//            @Override
//            protected Void doInBackground() throws Exception {
//                try {
//                    String response = signUp(email, password); // Call your signUp method
//                    JSONObject jsonResponse = new JSONObject(response);
//
//                    if (jsonResponse.has("idToken")) {
//                        // Registration successful -> get UID
//                        String uid = jsonResponse.getString("localId");
//
//                        // Store user type in Firestore
//                        storeUserInfoInFirestore(uid, email, selectedUserType);
//
//                        SwingUtilities.invokeLater(() -> {
//                            JOptionPane.showMessageDialog(frame,
//                                    "Registration Successful! You can now log in.");
//                            cardLayout.show(mainPanel, "login"); // Go back to login
//                        });
//
//                    } else if (jsonResponse.has("error")) {
//                        handleFirebaseError(jsonResponse); //proper error handling
//                    }
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                    SwingUtilities.invokeLater(() -> { //ensure swing operations on EDT
//                        JOptionPane.showMessageDialog(frame,
//                                "Registration Failed: " + ex.getMessage(),
//                                "Error", JOptionPane.ERROR_MESSAGE);
//                    });
//                }
//                return null; // Nothing to return
//            }
//
//        }.execute(); // IMPORTANT: Call .execute()!
//    }
//
//
//    private void storeUserInfoInFirestore(String uid, String email, UserType userType) {
//        try {
//            DocumentReference docRef = db.collection("users").document(uid);
//
//            Map<String, Object> data = new HashMap<>();
//            data.put("email", email);
//            data.put("userType", userType.name()); // Store as String
//
//            WriteResult result = docRef.set(data, SetOptions.merge()).get(); // Use .get() for Future
//            System.out.println("User info stored for UID " + uid + " at " + result.getUpdateTime());
//
//        } catch (Exception e) {
//            //handle the exceptions using joptionpane
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(frame, "Firestore Error: " + e.getMessage(),
//                    "Error", JOptionPane.ERROR_MESSAGE);
//
//        }
//    }
//
//
//    private void handleFirebaseError(JSONObject jsonResponse) {
//        // Log the full response for debugging
//        System.err.println("Firebase error response: " + jsonResponse.toString());
//
//        // Extract and display a user-friendly error message
//        try {
//            JSONObject error = jsonResponse.getJSONObject("error");
//            String message = error.getString("message"); // Get detailed message
//            // Display error message in the UI
//            JOptionPane.showMessageDialog(frame, "Firebase Error: " + message, "Error", JOptionPane.ERROR_MESSAGE);
//
//        } catch (Exception e) {
//            // Fallback if the error structure is unexpected
//            JOptionPane.showMessageDialog(frame, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//
//    }
//
//    private String signIn(String email, String password) throws IOException {
//        URL url = new URL(SIGN_IN_URL);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("POST");
//        conn.setRequestProperty("Content-Type", "application/json");
//        conn.setDoOutput(true);
//
//        String jsonInputString = "{\"email\":\"" + email + "\",\"password\":\"" + password + "\",\"returnSecureToken\":true}";
//        try (OutputStream os = conn.getOutputStream()) {
//            byte[] input = jsonInputString.getBytes("utf-8");
//            os.write(input, 0, input.length);
//        }
//
//        return getResponse(conn); //get the response
//    }
//
//
//    private String signUp(String email, String password) throws IOException {
//        URL url = new URL(SIGN_UP_URL);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("POST");
//        conn.setRequestProperty("Content-Type", "application/json");
//        conn.setDoOutput(true);
//
//        String jsonInputString = "{\"email\":\"" + email + "\",\"password\":\"" + password + "\",\"returnSecureToken\":true}";
//        try (OutputStream os = conn.getOutputStream()) {
//            byte[] input = jsonInputString.getBytes("utf-8");
//            os.write(input, 0, input.length);
//        }
//
//        return getResponse(conn); //get the response
//    }
//
//    private String getResponse(HttpURLConnection conn) throws IOException {
//        int responseCode = conn.getResponseCode();
//        BufferedReader br;
//
//        // Handle both successful and error responses
//        if (responseCode == HttpURLConnection.HTTP_OK) {
//            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
//        } else {
//            br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "utf-8"));
//        }
//        StringBuilder response = new StringBuilder();
//        String responseLine;
//        while ((responseLine = br.readLine()) != null) {
//            response.append(responseLine.trim());
//        }
//        return response.toString();
//    }
//}

package com.parkingapp;

import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.WriteResult;
import com.google.cloud.firestore.Firestore;
import org.json.JSONObject;
import services.FirebaseInitialization;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;
import java.util.regex.Pattern;

public class UserLogin extends JFrame { // Extending JFrame

    // Replace this with your own API key
    private static final String API_KEY =
            "AIzaSyAeBBsBEyflDmEmfjwiX7rm0FuILDflss4"; //  API key usage

    private static final String SIGN_IN_URL =
            "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=" + API_KEY;
    private static final String SIGN_UP_URL =
            "https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=" + API_KEY;

    // Enum for user types
    public enum UserType {
        STUDENT, FACULTY, NON_FACULTY, VISITOR
    }

    private Firestore db; // Firestore instance from FirebaseInitialization

    private JFrame frame; // Use a class-level JFrame
    private CardLayout cardLayout;
    private JPanel mainPanel;

    private JTextField emailField, regEmailField;
    private JPasswordField passwordField, regPasswordField;
    private JComboBox<UserType> userTypeComboBox; // ComboBox for user type selection (User client type)

    public static void main(String[] args) {
        // Using invokeLater to ensure GUI creation happens on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new UserLogin().createAndShowGUI()); // Calling the method
    }

    // Constructor
    public UserLogin() {
        initializeFirebase();
    }

    /**
     * Getting the Firestore singleton instance from FirebaseInitialization.
     */
    private void initializeFirebase() {
        try {
            db = FirebaseInitialization.getInstance(); // Acquire Firestore from our singleton firebaseInitializer
        } catch (RuntimeException e) {
            System.err.println("Firebase Initialization Error: " + e.getMessage());
            JOptionPane.showMessageDialog(
                    frame, // Use the frame as the parent
                    "Firebase initialization failed:\n" + e.getMessage(),
                    "Firebase Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void createAndShowGUI() {
        frame = new JFrame("Firebase Login App"); // Initializing the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 450);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(createLoginPanel(), "login");
        mainPanel.add(createRegisterPanel(), "register");

        frame.add(mainPanel);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true); // Making the frame visible
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel loginLabel = new JLabel("Login");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 28));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(loginLabel, gbc);

        JLabel emailLabel = new JLabel("Email:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(emailLabel, gbc);

        emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(300, 35));
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(emailField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(passwordLabel, gbc);

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(300, 35));
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(passwordField, gbc);

        JButton loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(loginButton, gbc);

        JButton goToRegisterButton = new JButton("Create Account");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(goToRegisterButton, gbc);

        JButton goToAdminLoginButton = new JButton("Admin Login");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panel.add(goToAdminLoginButton, gbc);

        loginButton.addActionListener(e -> performLogin());
        goToRegisterButton.addActionListener(e -> cardLayout.show(mainPanel, "register"));
        goToAdminLoginButton.addActionListener(e -> new BaseLogin.ManagementLogin().setVisible(true)); // creating Admin Registration page

        return panel;
    }

    private JPanel createRegisterPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel registerLabel = new JLabel("Register");
        registerLabel.setFont(new Font("Arial", Font.BOLD, 28));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(registerLabel, gbc);

        JLabel regEmailLabel = new JLabel("Email:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(regEmailLabel, gbc);

        regEmailField = new JTextField();
        regEmailField.setPreferredSize(new Dimension(300, 35));
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(regEmailField, gbc);

        JLabel regPasswordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(regPasswordLabel, gbc);

        regPasswordField = new JPasswordField();
        regPasswordField.setPreferredSize(new Dimension(300, 35));
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(regPasswordField, gbc);

        // --- User Type Dropdown ---
        JLabel userTypeLabel = new JLabel("User Type:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(userTypeLabel, gbc);

        userTypeComboBox = new JComboBox<>(UserType.values());
        userTypeComboBox.setPreferredSize(new Dimension(300, 35));
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(userTypeComboBox, gbc);
        // ------------------------------

        JButton registerButton = new JButton("Register");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(registerButton, gbc);

        JButton backToLoginButton = new JButton("Back to Login");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panel.add(backToLoginButton, gbc);

        registerButton.addActionListener(e -> performRegistration());
        backToLoginButton.addActionListener(e -> cardLayout.show(mainPanel, "login"));

        return panel;
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    private void performLogin() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        passwordField.setText(""); // Clear the password field

        if (!isValidEmail(email) || password.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid email and password",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        new SwingWorker<String, Void>() {
            @Override
            protected String doInBackground() throws Exception {
                try {
                    // Using Factory to obtain the sign-in operation
                    AuthOperation authOp = AuthOperationFactory.getAuthOperation(UserLogin.this, "login");
                    String response = authOp.execute(email, password);
                    JSONObject jsonResponse = new JSONObject(response);
                    if (jsonResponse.has("idToken")) {
                        return response; // Return the entire response
                    } else if (jsonResponse.has("error")) {
                        handleFirebaseError(jsonResponse);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(frame, "Login Failed: " + ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                    });
                }
                return null; // Returning null if there was an error
            }

            @Override
            protected void done() {
                try {
                    String response = get(); // Getting the response
                    if (response != null) {
                        // Parsing the JSON response to get the UID
                        JSONObject jsonResponse = new JSONObject(response);
                        String uid = jsonResponse.getString("localId");

                        // Saving the UID to Preferences (CRUCIAL!)
                        Preferences prefs = Preferences.userNodeForPackage(UserLogin.class);
                        prefs.put("user_uid", uid);
                        System.out.println("UID saved to preferences: " + uid);

                        frame.dispose(); // Closing login window
                        new BookingPage().setVisible(true); // Opening booking page
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Login Failed: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE); // Error handling
                }
            }
        }.execute(); // Calling .execute() to run the SwingWorker
    }

    // Performing user registration
    private void performRegistration() {
        String email = regEmailField.getText();
        String password = new String(regPasswordField.getPassword());
        regPasswordField.setText(""); // Clearing password

        // Getting selected user type from combo box
        UserType selectedUserType = (UserType) userTypeComboBox.getSelectedItem();

        // Input Validation 
        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid email address.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (password.length() < 6) {
            JOptionPane.showMessageDialog(frame, "Password must be at least 6 characters long.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (selectedUserType == null) {
            JOptionPane.showMessageDialog(frame, "Please select a user type.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return; // Ensure a user type is selected
        }
        // --- End Input Validation ---

        new SwingWorker<Void, Void>() { // Using VOID if not returning a result
            @Override
            protected Void doInBackground() throws Exception {
                try {
                    // Using Factory to obtain the sign-up operation
                    AuthOperation authOp = AuthOperationFactory.getAuthOperation(UserLogin.this, "register");
                    String response = authOp.execute(email, password);
                    JSONObject jsonResponse = new JSONObject(response);

                    if (jsonResponse.has("idToken")) {
                        // Registration successful -> get UID
                        String uid = jsonResponse.getString("localId");

                        // Storing user type in Firestore
                        storeUserInfoInFirestore(uid, email, selectedUserType);

                        SwingUtilities.invokeLater(() -> {
                            JOptionPane.showMessageDialog(frame,
                                    "Registration Successful! You can now log in.");
                            cardLayout.show(mainPanel, "login"); // Back button: Go back to login
                        });
                    } else if (jsonResponse.has("error")) {
                        handleFirebaseError(jsonResponse); // Error handling
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(frame,
                                "Registration Failed: " + ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                    });
                }
                return null; // Nothing to return
            }

        }.execute(); // Calling for execution .execute()!
    }

    private void storeUserInfoInFirestore(String uid, String email, UserType userType) {
        try {
            DocumentReference docRef = db.collection("users").document(uid);

            Map<String, Object> data = new HashMap<>();
            data.put("email", email);
            data.put("userType", userType.name()); // Storing as String

            WriteResult result = docRef.set(data, SetOptions.merge()).get(); // Using .get() for Future
            System.out.println("User info stored for UID " + uid + " at " + result.getUpdateTime());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Firestore Error: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleFirebaseError(JSONObject jsonResponse) {
        // Logging the full response for debugging
        System.err.println("Firebase error response: " + jsonResponse.toString());

        // Extracting and displaying user-friendly error message
        try {
            JSONObject error = jsonResponse.getJSONObject("error");
            String message = error.getString("message");
            JOptionPane.showMessageDialog(frame, "Firebase Error: " + message,
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "An unexpected error occurred.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String getResponse(HttpURLConnection conn) throws IOException {
        int responseCode = conn.getResponseCode();
        BufferedReader br;

        // Handling both successful and error responses
        if (responseCode == HttpURLConnection.HTTP_OK) {
            br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
        } else {
            br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "utf-8"));
        }
        StringBuilder response = new StringBuilder();
        String responseLine;
        while ((responseLine = br.readLine()) != null) {
            response.append(responseLine.trim());
        }
        return response.toString();
    }

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
        return getResponse(conn);
    }

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
        return getResponse(conn);
    }

    // Factory Design Pattern Implementation
    private interface AuthOperation {
        String execute(String email, String password) throws IOException;
    }

    private static class SignInOperation implements AuthOperation {
        private final UserLogin userLogin;

        public SignInOperation(UserLogin userLogin) {
            this.userLogin = userLogin;
        }

        @Override
        public String execute(String email, String password) throws IOException {
            return userLogin.signIn(email, password);
        }
    }

    private static class SignUpOperation implements AuthOperation {
        private final UserLogin userLogin;

        public SignUpOperation(UserLogin userLogin) {
            this.userLogin = userLogin;
        }

        @Override
        public String execute(String email, String password) throws IOException {
            return userLogin.signUp(email, password);
        }
    }

    //Factory class created used for user registration type i.e: login or register options
    private static class AuthOperationFactory {
        public static AuthOperation getAuthOperation(UserLogin instance, String operationType) {
            if (operationType.equalsIgnoreCase("login")) {
                return new SignInOperation(instance);
            } else if (operationType.equalsIgnoreCase("register")) {
                return new SignUpOperation(instance);
            }
            throw new IllegalArgumentException("Invalid operation type: " + operationType);
        }
    }

}


