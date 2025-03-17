package com.parkingapp;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
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
import java.util.concurrent.ExecutionException;
import java.util.prefs.Preferences;

public class BookingPage extends JFrame {

    // Drop down for parking lots
    private JComboBox<String> lotSelector;
    // Drop down for parking spaces (within a selected lot)
    private JComboBox<String> spaceSelector;
    private JTextField startTimeField;
    private JTextField endTimeField;
    // Drop down for vehicle type (e.g., SUV, Sedan, etc.)
    private JComboBox<String> vehicleTypeSelector;
    // Free-form text field for car brand
    private JTextField carBrandField;

    private JTextArea bookingDetailsArea;
    private JButton bookButton, cancelButton, editButton, extendButton, returnButton;
    private JLabel userTypeLabel;
    private final Map<String, Booking> bookings = new HashMap<>();
    // Map storing the parking spaces for each lot.
    private Map<String, List<String>> parkingLotSpaces = new HashMap<>();

    // Listener for the book button.
    private ActionListener bookButtonActionListener;
    private JLabel realTimeLabel; // Label to display the current time
    private static final String TAG = "BookingUpdate";

    public BookingPage() {
        setTitle("Parking Space Booking");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 550);
        setLocationRelativeTo(null);

        initializeFirebase();

        // Create main panel with border layout.
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Header panel with title and user type.
        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Booking Page");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        userTypeLabel = new JLabel("Loading...", SwingConstants.RIGHT);
        userTypeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerPanel.add(userTypeLabel, BorderLayout.EAST);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Input panel with GridBagLayout.
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Row 0: Parking Lot drop down.
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

        // Update spaces when a lot is selected.
        lotSelector.addActionListener(e -> updateSpaceSelectorForSelectedLot());

        // Row 1: Parking Space drop down.
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

        // Row 2: Real-time display.
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

        // Row 3: Start time field.
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

        // Row 4: End time field.
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

        // Row 5: Vehicle Type drop down.
        JLabel vehicleTypeLabel = new JLabel("Vehicle Type:");
        vehicleTypeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0;
        inputPanel.add(vehicleTypeLabel, gbc);

        vehicleTypeSelector = new JComboBox<>();
        vehicleTypeSelector.setFont(new Font("Arial", Font.PLAIN, 14));
        vehicleTypeSelector.addItem("SUV");
        vehicleTypeSelector.addItem("Sedan");
        vehicleTypeSelector.addItem("Convertible");
        vehicleTypeSelector.addItem("Mini SUV");
        vehicleTypeSelector.addItem("Van");
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        inputPanel.add(vehicleTypeSelector, gbc);

        // Row 6: Car Brand text field.
        JLabel carBrandLabel = new JLabel("Car Brand:");
        carBrandLabel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0;
        inputPanel.add(carBrandLabel, gbc);

        carBrandField = new JTextField(10);
        carBrandField.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        inputPanel.add(carBrandField, gbc);

        // Row 7: Booking details text area with scroll pane.
        bookingDetailsArea = new JTextArea(10, 30);
        bookingDetailsArea.setEditable(false);
        bookingDetailsArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(bookingDetailsArea);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;
        inputPanel.add(scrollPane, gbc);

        mainPanel.add(inputPanel, BorderLayout.CENTER);

        // Button panel.
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

        bookButtonActionListener = e -> bookSpace();

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
        loadParkingLotsAndSpacesInRealTime(); // Start real-time listeners.
        startDateTimeUpdater(); // Start the timer for the real-time clock.

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
                throw new IOException("google-services.json not found in resources");
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

    // Booking methods

    private void bookSpace() {
        String selectedLot = (String) lotSelector.getSelectedItem();
        String selectedSpace = (String) spaceSelector.getSelectedItem();
        String startTime = startTimeField.getText().trim();
        String endTime = endTimeField.getText().trim();
        String vehicleType = (String) vehicleTypeSelector.getSelectedItem();
        String carBrand = carBrandField.getText().trim();
        String licensePlate = licensePlateField.getText().trim();

        // --- Basic Input Validation ---
        if (selectedLot == null || selectedSpace == null || startTime.isEmpty() ||
                endTime.isEmpty() || licensePlate.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please select a lot, space, enter start/end times, and provide a license plate.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!licensePlate.matches("^[A-Za-z0-9]{5}[A-Za-z][0-9]$")) {
            JOptionPane.showMessageDialog(this,
                    "Invalid license plate format. It must be 7 characters, with the 6th being a letter and the 7th a digit.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        try {
            LocalTime.parse(startTime, formatter);
            LocalTime.parse(endTime, formatter);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid time format. Please use HH:MM. (Minutes must be between 0 and 59)",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // --- Booking Time Constraint (15 minutes in advance) ---
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowRounded = now.minusSeconds(now.getSecond()).minusNanos(now.getNano());
        LocalDateTime earliestBookingTime = nowRounded.plusMinutes(15);
        LocalDateTime bookingStartTime;
        try {
            LocalTime enteredStartTime = LocalTime.parse(startTime, formatter);
            bookingStartTime = LocalDateTime.now().withHour(enteredStartTime.getHour())
                    .withMinute(enteredStartTime.getMinute()).withSecond(0).withNano(0);
            if (bookingStartTime.isBefore(earliestBookingTime)) {
                String earliestStr = earliestBookingTime.format(DateTimeFormatter.ofPattern("HH:mm"));
                JOptionPane.showMessageDialog(this,
                        "Booking can only be made 15 minutes from now (" + earliestStr + " or later).",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid start time format. Please use HH:MM.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // --- Check for Overlapping Bookings ---
        if (isSpaceBooked(selectedLot, selectedSpace, startTime, endTime, null)) {
            JOptionPane.showMessageDialog(this,
                    "This space is already booked for the selected time.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // --- Proceed with Booking ---
        long duration = BookingDurationCalculator.calculateDuration(startTime, endTime);
        String bookingId = selectedLot + "_" + selectedSpace + "_" + UUID.randomUUID().toString();

        // Create the Booking object for local use (if needed)
        Booking newBooking = new Booking(selectedLot + " - " + selectedSpace,
                startTime, endTime, vehicleType, carBrand, duration, licensePlate);

        // --- Prepare Data for Firestore ---
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference bookingRef = db.collection("bookings").document(bookingId);
        Map<String, Object> bookingData = new HashMap<>();
        bookingData.put("lot", selectedLot);
        bookingData.put("space", selectedSpace);
        bookingData.put("startTime", startTime);
        bookingData.put("endTime", endTime);
        bookingData.put("vehicleType", vehicleType);
        bookingData.put("carBrand", carBrand);
        bookingData.put("duration", duration);
        bookingData.put("licensePlate", licensePlate);
        bookingData.put("status", "booked");

        // --- NEW: Retrieve User Email and User Type ---
        Preferences prefs = Preferences.userNodeForPackage(UserLogin.class);
        String uid = prefs.get("user_uid", null);
        String userEmail = "unknown";
        String userType = "unknown";
        if (uid != null) {
            try {
                DocumentReference userRef = db.collection("users").document(uid);
                DocumentSnapshot userSnap = userRef.get().get();
                if (userSnap.exists()) {
                    userEmail = userSnap.getString("email");
                    userType = userSnap.getString("userType");
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        bookingData.put("userEmail", userEmail);
        bookingData.put("userType", userType);
        // --- END NEW CODE ---

        ApiFuture<WriteResult> future = bookingRef.set(bookingData);
        try {
            WriteResult result = future.get(); // Wait for the write to complete
            System.out.println("Booking written at: " + result.getUpdateTime());
            // Update local booking map and UI
            realTimeBookings.put(bookingId, newBooking);
            showBookingDetails();
            JOptionPane.showMessageDialog(this,
                    "Booking successful!\nDuration: " + duration + " minutes",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
            clearInputFields();
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error writing booking to Firestore: " + e.getMessage());
            JOptionPane.showMessageDialog(this,
                    "Error booking space: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
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
        vehicleTypeSelector.setSelectedItem(currentBooking.getVehicleType());
        carBrandField.setText(currentBooking.getCarBrand());

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
        String vehicleType = (String) vehicleTypeSelector.getSelectedItem();
        String carBrand = carBrandField.getText();

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
        existingBooking.setVehicleType(vehicleType);
        existingBooking.setCarBrand(carBrand);
        // Recalculate duration.
        long duration = BookingDurationCalculator.calculateDuration(startTime, endTime);
        existingBooking.setDuration(duration);

        if (!originalBookingId.equals(bookingId)) {
            bookings.remove(originalBookingId);
            bookings.put(bookingId, existingBooking);
        }

        showBookingDetails();
        JOptionPane.showMessageDialog(this, "Booking updated!", "Success", JOptionPane.INFORMATION_MESSAGE);

        bookButton.setText("Book Space");
        // Reset to the original book button action.
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
        // Update the duration after extension.
        long duration = BookingDurationCalculator.calculateDuration(currentBooking.getStartTime(), newEndTime);
        currentBooking.setDuration(duration);
        showBookingDetails();
        JOptionPane.showMessageDialog(this, "Booking extended!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // New method to update the Firestore database with the booked space.
    private void updateBookingWithSpace(String bookingId, String bookedSpace) {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference bookingRef = db.collection("bookings").document(bookingId);

        // Prepare the update data.
        Map<String, Object> updates = new HashMap<>();
        updates.put("bookedSpace", bookedSpace);
        updates.put("status", "booked");

        ApiFuture<WriteResult> future = bookingRef.update(updates);
        try {
            WriteResult result = future.get();
            System.out.println("Booking updated successfully with space: " + bookedSpace + " at " + result.getUpdateTime());
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error updating booking: " + e.getMessage());
        }
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
        carBrandField.setText("");
    }

    /**
     * Updates the spaces drop down for the currently selected lot.
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
            updateSpaceSelectorForSelectedLot();
        });
    }

    /**
     * Sets up real-time listeners on the Parking_spaces collection and its parkingSpaces subcollections.
     */
    private void loadParkingLotsAndSpacesInRealTime() {
        Firestore db = FirestoreClient.getFirestore();

        db.collection("Parking_spaces")
                .addSnapshotListener((lotSnapshots, e) -> {
                    if (e != null) {
                        System.err.println("Listen for parking lots failed: " + e);
                        return;
                    }
                    if (lotSnapshots != null) {
                        for (DocumentSnapshot lotDoc : lotSnapshots) {
                            if (lotDoc.exists()) {
                                String lotId = lotDoc.getId();
                                System.out.println("Found parking lot: " + lotId);
                                parkingLotSpaces.putIfAbsent(lotId, new ArrayList<>());
                                lotDoc.getReference().collection("parkingSpaces")
                                        .addSnapshotListener((spaceSnapshots, ex) -> {
                                            if (ex != null) {
                                                System.err.println("Listen for parking spaces in " + lotId + " failed: " + ex);
                                                return;
                                            }
                                            List<String> spaceList = new ArrayList<>();
                                            if (spaceSnapshots != null) {
                                                for (DocumentSnapshot spaceDoc : spaceSnapshots) {
                                                    if (spaceDoc.exists()) {
                                                        String spaceId = spaceDoc.getId();
                                                        spaceList.add(spaceId);
                                                        System.out.println("  Found space: " + spaceId + " in lot: " + lotId);
                                                    }
                                                }
                                            }
                                            parkingLotSpaces.put(lotId, spaceList);
                                            System.out.println("Updated spaces for " + lotId + ": " + spaceList);
                                            updateLotSelector();
                                        });
                            } else {
                                System.out.println("Parking lot document does not exist.");
                            }
                        }
                        if (lotSnapshots.isEmpty()) {
                            System.out.println("No parking lot documents found.");
                        }
                    }
                });
    }

    private void startDateTimeUpdater() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        Timer timer = new Timer(1000, e -> {
            String now = LocalDateTime.now().format(formatter);
            realTimeLabel.setText(now);
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BookingPage());
    }
}

// New class to calculate booking duration by subtracting start time from end time.
class BookingDurationCalculator {
    public static long calculateDuration(String startTime, String endTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime start = LocalTime.parse(startTime, formatter);
        LocalTime end = LocalTime.parse(endTime, formatter);
        return java.time.Duration.between(start, end).toMinutes();
    }
}

