package com.parkingapp;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener; // Import the CORRECT ActionListener
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.*;
import java.util.prefs.Preferences;

public class BookingPage extends JFrame {

    private JComboBox<String> spaceSelector;
    private JTextField bookingDateField;
    private JTextField startTimeField;
    private JTextField endTimeField;
    private JTextArea bookingDetailsArea;
    private JButton bookButton, cancelButton, editButton, extendButton, returnButton;

    private JLabel userTypeLabel;

    private final Map<String, Booking> bookings = new HashMap<>();
    private final List<String> availableSpaces = new ArrayList<>();
    private ActionListener bookButtonActionListener; // Use the correct ActionListener


    public BookingPage() {
        setTitle("Parking Space Booking");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 450);
        setLocationRelativeTo(null);

        initializeFirebase();

        availableSpaces.add("Space A1");
        availableSpaces.add("Space A2");
        availableSpaces.add("Space B1");
        availableSpaces.add("Space B2");
        availableSpaces.add("Space C1");

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Booking Page");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        userTypeLabel = new JLabel("Loading...", SwingConstants.RIGHT);
        userTypeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerPanel.add(userTypeLabel, BorderLayout.EAST);

        mainPanel.add(headerPanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel spaceLabel = new JLabel("Select Space:");
        spaceLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        inputPanel.add(spaceLabel, gbc);

        spaceSelector = new JComboBox<>(availableSpaces.toArray(new String[0]));
        spaceSelector.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        inputPanel.add(spaceSelector, gbc);

        JLabel dateLabel = new JLabel("Date (YYYY-MM-DD):");
        dateLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        inputPanel.add(dateLabel, gbc);

        bookingDateField = new JTextField(10);
        bookingDateField.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        inputPanel.add(bookingDateField, gbc);

        JLabel startTimeLabel = new JLabel("Start Time (HH:MM):");
        startTimeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        inputPanel.add(startTimeLabel, gbc);

        startTimeField = new JTextField(5);
        startTimeField.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        inputPanel.add(startTimeField, gbc);

        JLabel endTimeLabel = new JLabel("End Time (HH:MM):");
        endTimeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        inputPanel.add(endTimeLabel, gbc);

        endTimeField = new JTextField(5);
        endTimeField.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        inputPanel.add(endTimeField, gbc);

        bookingDetailsArea = new JTextArea(10, 30);
        bookingDetailsArea.setEditable(false);
        bookingDetailsArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(bookingDetailsArea);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;
        inputPanel.add(scrollPane, gbc);

        mainPanel.add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        bookButton = new JButton("Book Space");
        bookButton.setFont(new Font("Arial", Font.BOLD, 14));
        cancelButton = new JButton("Cancel Booking");
        cancelButton.setFont(new Font("Arial", Font.BOLD, 14));
        editButton = new JButton("Edit Booking");
        editButton.setFont(new Font("Arial", Font.BOLD, 14));
        extendButton = new JButton("Extend Booking");
        extendButton.setFont(new Font("Arial", Font.BOLD, 14));
        returnButton = new JButton("Return");
        returnButton.setFont(new Font("Arial", Font.BOLD, 14));

        bookButtonActionListener = e -> bookSpace(); // Initialize the listener

        buttonPanel.add(bookButton);
        buttonPanel.add(cancelButton);
        buttonPanel.add(editButton);
        buttonPanel.add(extendButton);
        buttonPanel.add(returnButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        bookButton.addActionListener(bookButtonActionListener); // Use the named listener
        cancelButton.addActionListener(e -> cancelBooking());
        editButton.addActionListener(e -> editBooking());
        extendButton.addActionListener(e -> extendBooking());
        spaceSelector.addActionListener(e -> showBookingDetails());
        returnButton.addActionListener(e -> returnToLoginPage());

        showBookingDetails();
        loadUserType();

        setVisible(true);
    }
    private void returnToLoginPage() {
        this.dispose();
        UserLogin loginPage = new UserLogin(); // Create new login page
        loginPage.setVisible(true); // Make login page visible
    }

    private void initializeFirebase() {
        try {
            InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("google-services.json");
            if (serviceAccount == null) {
                throw new IOException("serviceAccountKey.json not found in resources");
            }
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
        } catch (IOException e) {
            System.out.println("ERROR: invalid service account credentials. See the README.");
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "Firebase initialization failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void loadUserType() {
        new SwingWorker<String, Void>() {
            @Override
            protected String doInBackground() throws Exception {
                Preferences prefs = Preferences.userNodeForPackage(UserLogin.class);
                String uid = prefs.get("user_uid", null);
                if (uid == null) {
                    return "Guest";
                }
                Firestore db = FirestoreClient.getFirestore();
                DocumentReference docRef = db.collection("users").document(uid);
                DocumentSnapshot docSnap = docRef.get().get();
                if (docSnap.exists() && docSnap.contains("userType")) {
                    return docSnap.getString("userType");
                }
                return "Undefined";
            }

            @Override
            protected void done() {
                try {
                    String userType = get();
                    userTypeLabel.setText(userType.toUpperCase());
                } catch (Exception e) {
                    e.printStackTrace();
                    userTypeLabel.setText("Error");
                    JOptionPane.showMessageDialog(BookingPage.this, "Error loading user type: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }.execute();
    }


    private void bookSpace() {
        String space = (String) spaceSelector.getSelectedItem();
        String date = bookingDateField.getText();
        String startTime = startTimeField.getText();
        String endTime = endTimeField.getText();

        if (space == null || date.isEmpty() || startTime.isEmpty() || endTime.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            JOptionPane.showMessageDialog(this, "Invalid date format. Use YYYY-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!startTime.matches("\\d{2}:\\d{2}") || !endTime.matches("\\d{2}:\\d{2}")) {
            JOptionPane.showMessageDialog(this, "Invalid time format. Use HH:MM.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (bookings.containsKey(space)) {
            Booking existingBooking = bookings.get(space);
            if (existingBooking.getDate().equals(date)) {
                if (timeConflict(existingBooking.getStartTime(), existingBooking.getEndTime(), startTime, endTime)) {
                    JOptionPane.showMessageDialog(this, "Booking conflict. Space already booked for this time.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }

        Booking newBooking = new Booking(space, date, startTime, endTime);
        bookings.put(space, newBooking);
        showBookingDetails();
        JOptionPane.showMessageDialog(this, "Booking successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        clearInputFields();
    }


    private boolean timeConflict(String start1, String end1, String start2, String end2) {
        int start1Minutes = Integer.parseInt(start1.substring(0, 2)) * 60 + Integer.parseInt(start1.substring(3));
        int end1Minutes = Integer.parseInt(end1.substring(0, 2)) * 60 + Integer.parseInt(end1.substring(3));
        int start2Minutes = Integer.parseInt(start2.substring(0, 2)) * 60 + Integer.parseInt(start2.substring(3));
        int end2Minutes = Integer.parseInt(end2.substring(0, 2)) * 60 + Integer.parseInt(end2.substring(3));

        return start1Minutes < end2Minutes && start2Minutes < end1Minutes;
    }


    private void cancelBooking() {
        String selectedSpace = (String) spaceSelector.getSelectedItem();
        if (bookings.containsKey(selectedSpace)) {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to cancel the booking for " + selectedSpace + "?",
                    "Confirm Cancellation",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                bookings.remove(selectedSpace);
                showBookingDetails();
                JOptionPane.showMessageDialog(this, "Booking cancelled!", "Success", JOptionPane.INFORMATION_MESSAGE);
                clearInputFields();
            }
        } else {
            JOptionPane.showMessageDialog(this, "No booking found for the selected space.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editBooking() {
        String space = (String) spaceSelector.getSelectedItem();
        if (!bookings.containsKey(space)) {
            JOptionPane.showMessageDialog(this, "No booking to edit for " + space, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Booking currentBooking = bookings.get(space);
        bookingDateField.setText(currentBooking.getDate());
        startTimeField.setText(currentBooking.getStartTime());
        endTimeField.setText(currentBooking.getEndTime());

        bookButton.setText("Update Booking");
        bookButton.removeActionListener(bookButtonActionListener);
        bookButton.addActionListener(e -> updateBooking(space));

        cancelButton.setEnabled(false);
        editButton.setEnabled(false);
        extendButton.setEnabled(false);
        spaceSelector.setEnabled(false);
    }

    private void updateBooking(String originalSpace) {
        String space = (String) spaceSelector.getSelectedItem();
        String date = bookingDateField.getText();
        String startTime = startTimeField.getText();
        String endTime = endTimeField.getText();

        if (space == null || date.isEmpty() || startTime.isEmpty() || endTime.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            JOptionPane.showMessageDialog(this, "Invalid date format. Use YYYY-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!startTime.matches("\\d{2}:\\d{2}") || !endTime.matches("\\d{2}:\\d{2}")) {
            JOptionPane.showMessageDialog(this, "Invalid time format. Use HH:MM.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Booking existingBooking = bookings.get(originalSpace);

        if (bookings.containsKey(space)) {
            Booking otherBooking = bookings.get(space);
            if (!otherBooking.equals(existingBooking) && otherBooking.getDate().equals(date)) {
                if (timeConflict(otherBooking.getStartTime(), otherBooking.getEndTime(), startTime, endTime)) {
                    JOptionPane.showMessageDialog(this, "Booking conflict. Space already booked for this time.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }

        existingBooking.setDate(date);
        existingBooking.setStartTime(startTime);
        existingBooking.setEndTime(endTime);

        if (!originalSpace.equals(space)) {
            bookings.remove(originalSpace);
            bookings.put(space, existingBooking);
        }

        showBookingDetails();
        JOptionPane.showMessageDialog(this, "Booking updated!", "Success", JOptionPane.INFORMATION_MESSAGE);

        bookButton.setText("Book Space");
        bookButton.removeActionListener(bookButton.getActionListeners()[0]);
        bookButton.addActionListener(bookButtonActionListener);
        cancelButton.setEnabled(true);
        editButton.setEnabled(true);
        extendButton.setEnabled(true);
        spaceSelector.setEnabled(true);
        clearInputFields();
    }


    private void extendBooking() {
        String space = (String) spaceSelector.getSelectedItem();
        if (!bookings.containsKey(space)) {
            JOptionPane.showMessageDialog(this, "No booking to extend for " + space, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Booking currentBooking = bookings.get(space);
        String newEndTime = JOptionPane.showInputDialog(this, "Enter new end time (HH:MM):", currentBooking.getEndTime());
        if (newEndTime == null || newEndTime.isEmpty()) {
            return;
        }

        if (!newEndTime.matches("\\d{2}:\\d{2}")) {
            JOptionPane.showMessageDialog(this, "Invalid time format. Use HH:MM.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (bookings.containsKey(space)) {
            Booking otherBooking = bookings.get(space);
            if (otherBooking.getDate().equals(currentBooking.getDate())) {
                if (!otherBooking.equals(currentBooking) && timeConflict(otherBooking.getStartTime(), otherBooking.getEndTime(), currentBooking.getStartTime(), newEndTime)) {
                    JOptionPane.showMessageDialog(this, "Booking conflict. Space already booked for this time.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }
        if(timeConflict(currentBooking.getStartTime(),currentBooking.getStartTime(),currentBooking.getEndTime(), newEndTime)){
            JOptionPane.showMessageDialog(this, "New end time cannot be before start time.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        currentBooking.setEndTime(newEndTime);
        showBookingDetails();
        JOptionPane.showMessageDialog(this, "Booking extended!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showBookingDetails() {
        String selectedSpace = (String) spaceSelector.getSelectedItem();
        if (selectedSpace != null) {
            if (bookings.containsKey(selectedSpace)) {
                Booking booking = bookings.get(selectedSpace);
                bookingDetailsArea.setText(booking.toString());
            } else {
                bookingDetailsArea.setText("No booking found for " + selectedSpace);
            }
        } else {
            bookingDetailsArea.setText("");
        }
    }

    private void clearInputFields() {
        bookingDateField.setText("");
        startTimeField.setText("");
        endTimeField.setText("");
    }

    private class Booking {
        private String space;
        private String date;
        private String startTime;
        private String endTime;

        public Booking(String space, String date, String startTime, String endTime) {
            this.space = space;
            this.date = date;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public String getSpace() {
            return space;
        }

        public String getDate() {
            return date;
        }

        public String getStartTime() {
            return startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return "Booking Details:\n" +
                    "-------------------\n" +
                    "Space: " + space + "\n" +
                    "Date: " + date + "\n" +
                    "Start Time: " + startTime + "\n" +
                    "End Time: " + endTime + "\n";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Booking booking = (Booking) o;
            return Objects.equals(space, booking.space) &&
                    Objects.equals(date, booking.date) &&
                    Objects.equals(startTime, booking.startTime) &&
                    Objects.equals(endTime, booking.endTime);
        }

        @Override
        public int hashCode() {
            return Objects.hash(space, date, startTime, endTime);
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BookingPage());
    }
}
