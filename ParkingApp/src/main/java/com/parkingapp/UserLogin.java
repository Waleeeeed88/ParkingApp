package com.parkingapp;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class UserLogin {
    private static final String API_KEY = 
            "AIzaSyAeBBsBEyflDmEmfjwiX7rm0FuILDflss4"; // Replace
    private static final String SIGN_IN_URL = "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=" + API_KEY;
    private static final String SIGN_UP_URL = "https://identitytoolkit.googleapis.com/v1/accounts:signUp?key=" + API_KEY;

    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JTextField emailField, regEmailField;
    private JPasswordField passwordField, regPasswordField;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserLogin().createAndShowGUI());
    }

    private void createAndShowGUI() {
        frame = new JFrame("Firebase Login App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 455);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(createLoginPanel(), "login");
        mainPanel.add(createRegisterPanel(), "register");

        frame.add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ... (rest of the login panel setup - labels, fields, etc. - same as before) ...
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
        goToAdminLoginButton.addActionListener(e -> new AdminLogin().setVisible(true));

        return panel;
    }

    private JPanel createRegisterPanel() {
        // ... (register panel setup - same as before) ...
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(); // Create a new GBC instance
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

        JButton registerButton = new JButton("Register");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(registerButton, gbc);

        JButton backToLoginButton = new JButton("Back to Login");
        gbc.gridx = 0;
        gbc.gridy = 4;
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
        passwordField.setText(null);

        if (!isValidEmail(email) || password.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid email and password", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        new SwingWorker<String, Void>() { // Changed to return the idToken
            @Override
            protected String doInBackground() throws Exception {
                try {
                    String response = signIn(email, password);
                    JSONObject jsonResponse = new JSONObject(response);
                    if (jsonResponse.has("idToken")) {
                        return jsonResponse.getString("idToken"); // Return the idToken
                    } else if (jsonResponse.has("error")) {
                        handleFirebaseError(jsonResponse);
                        return null; // Return null on error
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Login Failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                return null; // Return null on exception
            }

            @Override
            protected void done() {
                try {
                    String idToken = get(); // Get the result of doInBackground
                    if (idToken != null) {
                        // *** Successful user login - Open BookingPage ***
                        frame.dispose(); // Close the login window
                        new BookingPage().setVisible(true); // Open the booking page

                    }
                } catch (Exception ex) {
                    ex.printStackTrace(); // Handle exceptions from get()
                }
            }
        }.execute();
    }
    private void performRegistration() {
        String email = regEmailField.getText();
        String password = new String(regPasswordField.getPassword());
        regPasswordField.setText(null);

        if (!isValidEmail(email) || password.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid email and password", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (password.length() < 6) {
            JOptionPane.showMessageDialog(frame, "Password must be at least 6 characters long.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {
                    String response = signUp(email, password);
                    JSONObject jsonResponse = new JSONObject(response);
                    if (jsonResponse.has("idToken")) {
                        SwingUtilities.invokeLater(() -> {
                            JOptionPane.showMessageDialog(frame, "Registration Successful! You can now log in.");
                            cardLayout.show(mainPanel, "login");
                        });
                    } else if (jsonResponse.has("error")) {
                        handleFirebaseError(jsonResponse);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(frame, "Registration Failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    });
                }
                return null;
            }
        }.execute();
    }
    private void handleFirebaseError(JSONObject jsonResponse) {
        JSONObject error = jsonResponse.getJSONObject("error");
        String message = error.getString("message");
        JOptionPane.showMessageDialog(frame, "Firebase Error: " + message, "Error", JOptionPane.ERROR_MESSAGE);
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

    private String getResponse(HttpURLConnection conn) throws IOException {
        int responseCode = conn.getResponseCode();
        BufferedReader br;
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
}
