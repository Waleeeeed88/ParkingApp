package com.parkingapp;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import javax.swing.Timer;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.*;
import java.util.prefs.Preferences;

public class BookingPage extends JFrame {

    // New drop down for parking lots
    private JComboBox<String> lotSelector;
    // Drop down for parking spaces (within a selected lot)
    private JComboBox<String> spaceSelector;
    private JTextField startTimeField;
    private JTextField endTimeField;
    private JTextArea bookingDetailsArea;
    private JButton bookButton, cancelButton, editButton, extendButton, returnButton;
    private JLabel userTypeLabel;

    private final Map<String, Booking> bookings = new HashMap<>();
    // This map will store the parking spaces for each lot.
    private Map<String, List<String>> parkingLotSpaces = new HashMap<>();

    // Listener for the book button.
    private ActionListener bookButtonActionListener;
    private JLabel realTimeLabel; // Label to display the real-time

    public BookingPage() {
        setTitle("Parking Space Booking");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 450);
        setLocationRelativeTo(null);

        initializeFirebase();

        // Create panels
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

        // Create the input panel with GridBagLayout for two drop downs and time fields.
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Row 0: Parking Lot drop down
        JLabel lotLabel = new JLabel("Select Lot:");
        lotLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        inputPanel.add(lotLabel, gbc);

        lotSelector = new JComboBox<>();
        lotSelector.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        inputPanel.add(lotSelector, gbc);

        // Add action listener to update spaces when a lot is selected
        lotSelector.addActionListener(e -> updateSpaceSelectorForSelectedLot());

        // Row 1: Parking Space drop down (shows spaces for selected lot)
        JLabel spaceLabel = new JLabel("Select Space:");
        spaceLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        inputPanel.add(spaceLabel, gbc);

        spaceSelector = new JComboBox<>();
        spaceSelector.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        inputPanel.add(spaceSelector, gbc);

        // Row 2: Real-time display
        JLabel realTimeTitleLabel = new JLabel("Current Time:");
        realTimeTitleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        inputPanel.add(realTimeTitleLabel, gbc);

        realTimeLabel = new JLabel();
        realTimeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        inputPanel.add(realTimeLabel, gbc);

        // Row 3: Start time field
        JLabel startTimeLabel = new JLabel("Start Time (HH:MM):");
        startTimeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        inputPanel.add(startTimeLabel, gbc);

        startTimeField = new JTextField(5);
        startTimeField.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        inputPanel.add(startTimeField, gbc);

        // Row 4: End time field
        JLabel endTimeLabel = new JLabel("End Time (HH:MM):");
        endTimeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0;
        inputPanel.add(endTimeLabel, gbc);

        endTimeField = new JTextField(5);
        endTimeField.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        inputPanel.add(endTimeField, gbc);

        // Row 5: Booking details text area with scroll pane
        bookingDetailsArea = new JTextArea(10, 30);
        bookingDetailsArea.setEditable(false);
        bookingDetailsArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(bookingDetailsArea);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;
        inputPanel.add(scrollPane, gbc);

        mainPanel.add(inputPanel, BorderLayout.CENTER);

        // Button panel
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

        // Set up button listeners.
        bookButton.addActionListener(bookButtonActionListener);
        cancelButton.addActionListener(e -> cancelBooking());
        editButton.addActionListener(e -> editBooking());
        extendButton.addActionListener(e -> extendBooking());
        spaceSelector.addActionListener(e -> showBookingDetails());
        returnButton.addActionListener(e -> returnToLoginPage());

        showBookingDetails();
        loadUserType();
        loadParkingLotsAndSpacesInRealTime(); // Start the real-time listeners
        startDateTimeUpdater(); // Start the real-time timer

        setVisible(true);
    }

    private void returnToLoginPage() {
        this.dispose();
        UserLogin loginPage = new UserLogin();
        loginPage.setVisible(true);
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

    // Booking methods (bookSpace, cancelBooking, editBooking, updateBooking, extendBooking, etc.)
    private void bookSpace() {
        String selectedLot = (String) lotSelector.getSelectedItem();
        String selectedSpace = (String) spaceSelector.getSelectedItem();
        String startTime = startTimeField.getText();
        String endTime = endTimeField.getText();

        if (selectedLot == null || selectedSpace == null || startTime.isEmpty() || endTime.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a lot, space and enter start and end times.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Combine lot and space for booking identifier (or use a different structure as needed)
        String bookingId = selectedLot + " - " + selectedSpace;

        if (bookings.containsKey(bookingId)) {
            JOptionPane.showMessageDialog(this, "Space already booked.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        LocalDateTime nowToronto = LocalDateTime.now();
        // Round current time to the nearest minute WITHOUT ChronoUnit
        LocalDateTime nowRounded = nowToronto.minusSeconds(nowToronto.getSecond()).minusNanos(nowToronto.getNano());
        LocalDateTime earliestBookingTime = nowRounded.plusMinutes(15);

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime enteredStartTime = LocalTime.parse(startTime, formatter);
            LocalDateTime bookingStartTime = LocalDateTime.now().with(enteredStartTime); // Use current date for comparison

            // Adjust bookingStartTime's date to today
            bookingStartTime = bookingStartTime.withDayOfYear(nowToronto.getDayOfYear()).withYear(nowToronto.getYear());

            if (bookingStartTime.isBefore(earliestBookingTime)) {
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                JOptionPane.showMessageDialog(this, "Booking can only be made 15 minutes from the current time (" + earliestBookingTime.format(timeFormatter) + " or later).", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Booking newBooking = new Booking(bookingId, startTime, endTime);
            bookings.put(bookingId, newBooking);
            showBookingDetails();
            JOptionPane.showMessageDialog(this, "Booking successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearInputFields();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid start time format. Please use HH:MM.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelBooking() {
        String selectedLot = (String) lotSelector.getSelectedItem();
        String selectedSpace = (String) spaceSelector.getSelectedItem();
        String bookingId = selectedLot + " - " + selectedSpace;
        if (bookings.containsKey(bookingId)) {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to cancel the booking for " + bookingId + "?",
                    "Confirm Cancellation",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                bookings.remove(bookingId);
                showBookingDetails();
                JOptionPane.showMessageDialog(this, "Booking cancelled!", "Success", JOptionPane.INFORMATION_MESSAGE);
                clearInputFields();
            }
        } else {
            JOptionPane.showMessageDialog(this, "No booking found for the selected space.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editBooking() {
        String selectedLot = (String) lotSelector.getSelectedItem();
        String selectedSpace = (String) spaceSelector.getSelectedItem();
        String bookingId = selectedLot + " - " + selectedSpace;
        if (!bookings.containsKey(bookingId)) {
            JOptionPane.showMessageDialog(this, "No booking to edit for " + bookingId, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Booking currentBooking = bookings.get(bookingId);
        startTimeField.setText(currentBooking.getStartTime());
        endTimeField.setText(currentBooking.getEndTime());

        bookButton.setText("Update Booking");
        bookButton.removeActionListener(bookButtonActionListener);
        bookButton.addActionListener(e -> updateBooking(bookingId));

        cancelButton.setEnabled(false);
        editButton.setEnabled(false);
        extendButton.setEnabled(false);
        lotSelector.setEnabled(false);
        spaceSelector.setEnabled(false);
    }

    private void updateBooking(String originalBookingId) {
        String selectedLot = (String) lotSelector.getSelectedItem();
        String selectedSpace = (String) spaceSelector.getSelectedItem();
        String bookingId = selectedLot + " - " + selectedSpace;
        String startTime = startTimeField.getText();
        String endTime = endTimeField.getText();

        if (selectedLot == null || selectedSpace == null || startTime.isEmpty() || endTime.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a lot, space and enter start and end times.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!startTime.matches("\\d{2}:\\d{2}") || !endTime.matches("\\d{2}:\\d{2}")) {
            JOptionPane.showMessageDialog(this, "Invalid time format. Use HH:MM.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Booking existingBooking = bookings.get(originalBookingId);
        existingBooking.setSpace(bookingId);
        existingBooking.setStartTime(startTime);
        existingBooking.setEndTime(endTime);

        if (!originalBookingId.equals(bookingId)) {
            bookings.remove(originalBookingId);
            bookings.put(bookingId, existingBooking);
        }

        showBookingDetails();
        JOptionPane.showMessageDialog(this, "Booking updated!", "Success", JOptionPane.INFORMATION_MESSAGE);

        bookButton.setText("Book Space");
        bookButton.removeActionListener(bookButton.getActionListeners()[0]);
        bookButton.addActionListener(bookButtonActionListener);
        cancelButton.setEnabled(true);
        editButton.setEnabled(true);
        extendButton.setEnabled(true);
        lotSelector.setEnabled(true);
        spaceSelector.setEnabled(true);
        clearInputFields();
    }

    private void extendBooking() {
        String selectedLot = (String) lotSelector.getSelectedItem();
        String selectedSpace = (String) spaceSelector.getSelectedItem();
        String bookingId = selectedLot + " - " + selectedSpace;
        if (!bookings.containsKey(bookingId)) {
            JOptionPane.showMessageDialog(this, "No booking to extend for " + bookingId, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Booking currentBooking = bookings.get(bookingId);
        String newEndTime = JOptionPane.showInputDialog(this, "Enter new end time (HH:MM):", currentBooking.getEndTime());
        if (newEndTime == null || newEndTime.isEmpty()) {
            return;
        }
        if (!newEndTime.matches("\\d{2}:\\d{2}")) {
            JOptionPane.showMessageDialog(this, "Invalid time format. Use HH:MM.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        currentBooking.setEndTime(newEndTime);
        showBookingDetails();
        JOptionPane.showMessageDialog(this, "Booking extended!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showBookingDetails() {
        String selectedLot = (String) lotSelector.getSelectedItem();
        String selectedSpace = (String) spaceSelector.getSelectedItem();
        if (selectedLot != null && selectedSpace != null) {
            String bookingId = selectedLot + " - " + selectedSpace;
            if (bookings.containsKey(bookingId)) {
                Booking booking = bookings.get(bookingId);
                bookingDetailsArea.setText(booking.toString());
            } else {
                bookingDetailsArea.setText("No booking found for " + bookingId);
            }
        } else {
            bookingDetailsArea.setText("");
        }
    }

    private void clearInputFields() {
        startTimeField.setText("");
        endTimeField.setText("");
    }

    // The Booking class remains similar.
    private class Booking {
        private String space; // This now holds the combined "Lot - Space" identifier.
        private String startTime;
        private String endTime;

        public Booking(String space, String startTime, String endTime) {
            this.space = space;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public String getSpace() {
            return space;
        }

        public String getStartTime() {
            return startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setSpace(String space) {
            this.space = space;
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
                    "Start Time: " + startTime + "\n" +
                    "End Time: " + endTime + "\n";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Booking booking = (Booking) o;
            return Objects.equals(space, booking.space) &&
                    Objects.equals(startTime, booking.startTime) &&
                    Objects.equals(endTime, booking.endTime);
        }

        @Override
        public int hashCode() {
            return Objects.hash(space, startTime, endTime);
        }
    }

    /**
     * This method updates the spaces drop down for the currently selected lot.
     */
    private void updateSpaceSelectorForSelectedLot() {
        String selectedLot = (String) lotSelector.getSelectedItem();
        List<String> spaces = parkingLotSpaces.getOrDefault(selectedLot, new ArrayList<>());
        SwingUtilities.invokeLater(() -> {
            spaceSelector.removeAllItems();
            for (String space : spaces) {
                spaceSelector.addItem(space);
            }
        });
    }

    /**
     * Updates the lot drop down based on the keys in parkingLotSpaces.
     */
    private void updateLotSelector() {
        List<String> lotList = new ArrayList<>(parkingLotSpaces.keySet());
        Collections.sort(lotList);
        SwingUtilities.invokeLater(() -> {
            lotSelector.removeAllItems();
            for (String lot : lotList) {
                lotSelector.addItem(lot);
            }
            // Also update the space drop down for the newly selected lot
            updateSpaceSelectorForSelectedLot();
        });
    }

    /**
     * Sets up real-time listeners on the Parking_spaces collection and for each
     * parking lot document, on its parkingSpaces subcollection.
     */
    private void loadParkingLotsAndSpacesInRealTime() {
        Firestore db = FirestoreClient.getFirestore();

        // Listen for changes in the "Parking_spaces" collection (parking lots)
        db.collection("Parking_spaces")
                .addSnapshotListener((lotSnapshots, e) -> {
                    if (e != null) {
                        System.err.println("Listen for parking lots failed: " + e);
                        return;
                    }

                    // Iterate through each parking lot document
                    for (DocumentSnapshot lotDoc : lotSnapshots) {
                        if (lotDoc.exists()) {
                            String lotId = lotDoc.getId();
                            System.out.println("Found parking lot: " + lotId);
                            // Ensure the lot exists in the map (even if its space list is empty)
                            parkingLotSpaces.putIfAbsent(lotId, new ArrayList<>());

                            // Listen for changes in the "parkingSpaces" subcollection for this lot
                            lotDoc.getReference().collection("parkingSpaces")
                                    .addSnapshotListener((spaceSnapshots, ex) -> {
                                        if (ex != null) {
                                            System.err.println("Listen for parking spaces in " + lotId + " failed: " + ex);
                                            return;
                                        }
                                        List<String> spaceList = new ArrayList<>();
                                        for (DocumentSnapshot spaceDoc : spaceSnapshots) {
                                            if (spaceDoc.exists()) {
                                                String spaceId = spaceDoc.getId();
                                                spaceList.add(spaceId);
                                                System.out.println("  Found space: " + spaceId + " in lot: " + lotId);
                                            }
                                        }
                                        // Update the map for this lot
                                        parkingLotSpaces.put(lotId, spaceList);
                                        System.out.println("Updated spaces for " + lotId + ": " + spaceList);
                                        // Update the lot drop down (and the spaces drop down for the selected lot)
                                        updateLotSelector();
                                    });
                        } else {
                            System.out.println("Parking lot document does not exist.");
                        }
                    }
                    if (lotSnapshots.isEmpty()) {
                        System.out.println("No parking lot documents found.");
                    }
                });
    }

    private void startDateTimeUpdater() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss"); // Display only time
        Timer timer = new Timer(1000, e -> {
            String now = LocalDateTime.now().format(formatter);
            realTimeLabel.setText(now); // Update the realTimeLabel
        });
        timer.start();
    }

    public static void main(String[]args) {
        SwingUtilities.invokeLater(() -> new BookingPage());
    }
}
