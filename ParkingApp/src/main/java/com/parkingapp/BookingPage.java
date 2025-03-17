package com.parkingapp;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.prefs.Preferences;
import javax.swing.Timer;

public class BookingPage extends JFrame {

    // Drop-down for parking lots
    private JComboBox<String> lotSelector;
    // Drop-down for parking spaces (within a selected lot)
    private JComboBox<String> spaceSelector;
    private JTextField startTimeField;
    private JTextField endTimeField;
    // Drop-down for vehicle type
    private JComboBox<String> vehicleTypeSelector;
    // Free-form text field for car brand
    private JTextField carBrandField;
    private JTextArea bookingDetailsArea;
    private JButton bookButton, cancelButton, editButton, extendButton, returnButton;
    private JLabel userTypeLabel;
    // License plate text field
    private JTextField licensePlateField;
    // Label to display the current time
    private JLabel realTimeLabel;

    // Listener for the book button
    private ActionListener bookButtonActionListener;

    // Store bookings in a local map (bookingId -> Booking)
    private Map<String, Booking> realTimeBookings = new HashMap<>();

    public BookingPage() {
        setTitle("Parking Space Booking");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);

        // Initialize Firebase (Admin SDK)
        initializeFirebase();

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Header panel with title and user type
        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Booking Page");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        userTypeLabel = new JLabel("Loading...", SwingConstants.RIGHT);
        userTypeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerPanel.add(userTypeLabel, BorderLayout.EAST);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Input panel
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

        // Update spaces when a lot is selected
        lotSelector.addActionListener(e -> updateSpaceSelectorForSelectedLot());

        // Row 1: Parking Space drop down
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

        // Row 2: Real-time clock display
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

        // Row 5: Vehicle Type drop down
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

        // Row 6: Car Brand
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

        // Row 7: License Plate
        JLabel licensePlateLabel = new JLabel("License Plate:");
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        inputPanel.add(licensePlateLabel, gbc);

        licensePlateField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(licensePlateField, gbc);

        // Row 8: Booking details area
        bookingDetailsArea = new JTextArea(10, 30);
        bookingDetailsArea.setEditable(false);
        bookingDetailsArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(bookingDetailsArea);
        gbc.gridx = 0;
        gbc.gridy = 8;
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

        bookButtonActionListener = e -> bookSpace();

        buttonPanel.add(bookButton);
        buttonPanel.add(cancelButton);
        buttonPanel.add(editButton);
        buttonPanel.add(extendButton);
        buttonPanel.add(returnButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Set up button listeners
        bookButton.addActionListener(bookButtonActionListener);
        cancelButton.addActionListener(e -> cancelBooking());
        editButton.addActionListener(e -> editBooking());
        extendButton.addActionListener(e -> extendBooking());
        spaceSelector.addActionListener(e -> showBookingDetails());
        returnButton.addActionListener(e -> returnToLoginPage());

        // Initial UI updates
        showBookingDetails();
        loadUserType();
        loadParkingLots();        // Synchronous load of lots
        loadAllBookings();        // Synchronous load of existing bookings
        startDateTimeUpdater();   // Start the timer for the clock

        setVisible(true);
    }

    /**
     * Returns to the login page. Adjust as needed for your own flow.
     */
    private void returnToLoginPage() {
        this.dispose();
        // If you have a UserLogin class, you can uncomment:
        // UserLogin loginPage = new UserLogin();
        // loginPage.setVisible(true);
    }

    /**
     * Initializes the Firebase Admin SDK (synchronous usage).
     */
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
        } catch (IOException ex) {
            System.out.println("ERROR: invalid service account credentials.");
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Firebase initialization failed: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Loads user type from Firestore and updates the label.
     * Uses synchronous calls (future.get()).
     */
    private void loadUserType() {
        SwingWorker<String, Void> worker = new SwingWorker<>() {
            @Override
            protected String doInBackground() throws Exception {
                // Attempt to retrieve user UID from Preferences
                Preferences prefs = Preferences.userNodeForPackage(BookingPage.class);
                String uid = prefs.get("user_uid", null);
                if (uid == null) {
                    return "Guest";
                }
                Firestore db = FirestoreClient.getFirestore();
                DocumentReference docRef = db.collection("users").document(uid);

                ApiFuture<DocumentSnapshot> future = docRef.get();
                DocumentSnapshot docSnap = future.get();
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
                } catch (Exception ex) {
                    ex.printStackTrace();
                    userTypeLabel.setText("Error");
                    JOptionPane.showMessageDialog(BookingPage.this,
                            "Error loading user type: " + ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        worker.execute();
    }

    /**
     * Synchronously loads all parking lots from Firestore.
     * Then updates the lotSelector dropdown.
     */
    private void loadParkingLots() {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = db.collection("Parking_spaces").get();
        try {
            QuerySnapshot snapshot = future.get();
            List<QueryDocumentSnapshot> documents = snapshot.getDocuments();

            // Update the lot selector
            updateLotSelector(documents);

        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Error loading parking lots: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Helper method to populate the lotSelector combo box.
     */
    private void updateLotSelector(List<QueryDocumentSnapshot> documents) {
        SwingUtilities.invokeLater(() -> {
            lotSelector.removeAllItems();
            for (QueryDocumentSnapshot document : documents) {
                lotSelector.addItem(document.getId());
            }
            // Update spaces for the first lot (if any)
            updateSpaceSelectorForSelectedLot();
        });
    }

    /**
     * Called when a new lot is selected, loads its parking spaces from Firestore (synchronously).
     */
    private void updateSpaceSelectorForSelectedLot() {
        String selectedLot = (String) lotSelector.getSelectedItem();
        if (selectedLot == null) {
            return;
        }
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = db.collection("Parking_spaces")
                .document(selectedLot)
                .collection("parkingSpaces")
                .get();
        try {
            QuerySnapshot snapshot = future.get();
            List<String> spaces = new ArrayList<>();
            for (QueryDocumentSnapshot document : snapshot) {
                spaces.add(document.getId());
            }
            SwingUtilities.invokeLater(() -> {
                spaceSelector.removeAllItems();
                for (String space : spaces) {
                    spaceSelector.addItem(space);
                }
                showBookingDetails();
            });
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Error loading spaces for lot: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Synchronously loads all existing bookings from Firestore into the local map.
     */
    private void loadAllBookings() {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> future = db.collection("bookings").get();
        try {
            QuerySnapshot snapshot = future.get();
            for (DocumentSnapshot doc : snapshot.getDocuments()) {
                // Only add if status == "booked" (optional)
                String status = doc.getString("status");
                if ("booked".equals(status)) {
                    Booking b = createBookingFromSnapshot(doc);
                    realTimeBookings.put(doc.getId(), b);
                }
            }
            showBookingDetails();
        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Error loading bookings: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Attempts to book a space (synchronous).
     */
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


    /**
     * Checks if a given lot/space is already booked in the local map for the given time range.
     * If editing an existing booking, pass its bookingId to exclude it from overlap checks.
     */
    private boolean isSpaceBooked(String lot, String space, String newStartTime, String newEndTime, String excludeBookingId) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime newStart = LocalTime.parse(newStartTime, formatter);
        LocalTime newEnd = LocalTime.parse(newEndTime, formatter);

        for (Map.Entry<String, Booking> entry : realTimeBookings.entrySet()) {
            String existingId = entry.getKey();
            if (excludeBookingId != null && excludeBookingId.equals(existingId)) {
                continue; // skip the booking being edited
            }

            Booking existingBooking = entry.getValue();
            String[] parts = existingBooking.getSpace().split(" - ");
            if (parts.length != 2) continue;
            String existingLot = parts[0];
            String existingSpace = parts[1];

            if (lot.equals(existingLot) && space.equals(existingSpace)) {
                LocalTime existingStart = LocalTime.parse(existingBooking.getStartTime(), formatter);
                LocalTime existingEnd = LocalTime.parse(existingBooking.getEndTime(), formatter);

                // Overlap if newStart < existingEnd AND newEnd > existingStart
                if (newStart.isBefore(existingEnd) && newEnd.isAfter(existingStart)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Cancels the booking for the currently selected lot/space (if any).
     */
    private void cancelBooking() {
        String selectedLot = (String) lotSelector.getSelectedItem();
        String selectedSpace = (String) spaceSelector.getSelectedItem();
        String bookingIdToCancel = null;

        // Find matching booking in local map
        for (Map.Entry<String, Booking> entry : realTimeBookings.entrySet()) {
            if (entry.getValue().getSpace().equals(selectedLot + " - " + selectedSpace)) {
                bookingIdToCancel = entry.getKey();
                break;
            }
        }

        if (bookingIdToCancel == null) {
            JOptionPane.showMessageDialog(this,
                    "No booking found for the selected space.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to cancel the booking for " + selectedLot + " - " + selectedSpace + "?",
                "Confirm Cancellation",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            Firestore db = FirestoreClient.getFirestore();
            DocumentReference bookingRef = db.collection("bookings").document(bookingIdToCancel);

            // We simply set the status to 'cancelled' instead of deleting
            ApiFuture<WriteResult> future = bookingRef.update("status", "cancelled");
            try {
                future.get(); // wait for completion
                realTimeBookings.remove(bookingIdToCancel);
                showBookingDetails();
                JOptionPane.showMessageDialog(this,
                        "Booking cancelled!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                clearInputFields();
            } catch (InterruptedException | ExecutionException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "Error cancelling booking: " + ex.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Allows editing the currently selected booking (loads the data into fields).
     */
    private void editBooking() {
        String selectedLot = (String) lotSelector.getSelectedItem();
        String selectedSpace = (String) spaceSelector.getSelectedItem();
        String bookingIdToEdit = null;

        for (Map.Entry<String, Booking> entry : realTimeBookings.entrySet()) {
            if (entry.getValue().getSpace().equals(selectedLot + " - " + selectedSpace)) {
                bookingIdToEdit = entry.getKey();
                break;
            }
        }

        if (bookingIdToEdit == null) {
            JOptionPane.showMessageDialog(this,
                    "No booking to edit for " + selectedLot + " - " + selectedSpace,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Booking currentBooking = realTimeBookings.get(bookingIdToEdit);
        startTimeField.setText(currentBooking.getStartTime());
        endTimeField.setText(currentBooking.getEndTime());
        vehicleTypeSelector.setSelectedItem(currentBooking.getVehicleType());
        carBrandField.setText(currentBooking.getCarBrand());
        licensePlateField.setText(currentBooking.getLicensePlate());


        bookButton.setText("Update Booking");
        // Temporarily remove the normal book listener
        bookButton.removeActionListener(bookButtonActionListener);

        // Add a new one for update
        final String finalBookingIdToEdit = bookingIdToEdit;
        bookButton.addActionListener(e -> updateBooking(finalBookingIdToEdit));

        // Disable other actions while editing
        cancelButton.setEnabled(false);
        editButton.setEnabled(false);
        extendButton.setEnabled(false);
        lotSelector.setEnabled(false);
        spaceSelector.setEnabled(false);
    }

    /**
     * Updates an existing booking in Firestore (synchronous).
     */
    private void updateBooking(String originalBookingId) {
        String selectedLot = (String) lotSelector.getSelectedItem();
        String selectedSpace = (String) spaceSelector.getSelectedItem();
        String startTime = startTimeField.getText().trim();
        String endTime = endTimeField.getText().trim();
        String vehicleType = (String) vehicleTypeSelector.getSelectedItem();
        String carBrand = carBrandField.getText().trim();
        String licensePlate = licensePlateField.getText().trim();

        // Basic validation
        if (selectedLot == null || selectedSpace == null ||
                startTime.isEmpty() || endTime.isEmpty() || licensePlate.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please select a lot, space, enter start/end times, and provide a license plate.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!licensePlate.matches("^[A-Za-z0-9]{5}[A-Za-z][0-9]$")) {
            JOptionPane.showMessageDialog(this,
                    "Invalid license plate format.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        try {
            LocalTime.parse(startTime, formatter);
            LocalTime.parse(endTime, formatter);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this,
                    "Invalid time format. Use HH:MM.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check overlap, excluding the current booking
        if (isSpaceBooked(selectedLot, selectedSpace, startTime, endTime, originalBookingId)) {
            JOptionPane.showMessageDialog(this,
                    "This space is already booked for the selected time.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Update Firestore
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference bookingRef = db.collection("bookings").document(originalBookingId);

        long duration = BookingDurationCalculator.calculateDuration(startTime, endTime);

        Map<String, Object> updateData = new HashMap<>();
        updateData.put("lot", selectedLot);
        updateData.put("space", selectedSpace);
        updateData.put("startTime", startTime);
        updateData.put("endTime", endTime);
        updateData.put("vehicleType", vehicleType);
        updateData.put("carBrand", carBrand);
        updateData.put("licensePlate", licensePlate);
        updateData.put("duration", duration);
        updateData.put("status", "booked");

        ApiFuture<WriteResult> future = bookingRef.update(updateData);
        try {
            future.get(); // block
            // Update local map
            Booking updatedBooking = new Booking(
                    selectedLot + " - " + selectedSpace,
                    startTime,
                    endTime,
                    vehicleType,
                    carBrand,
                    duration,
                    licensePlate
            );
            realTimeBookings.put(originalBookingId, updatedBooking);
            showBookingDetails();
            JOptionPane.showMessageDialog(this,
                    "Booking updated!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Error updating booking: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        // Restore the UI
        bookButton.setText("Book Space");
        // Remove the temporary "update" action listener
        bookButton.removeActionListener(bookButton.getActionListeners()[0]);
        // Reattach the original booking listener
        bookButton.addActionListener(bookButtonActionListener);

        cancelButton.setEnabled(true);
        editButton.setEnabled(true);
        extendButton.setEnabled(true);
        lotSelector.setEnabled(true);
        spaceSelector.setEnabled(true);
        clearInputFields();
    }

    /**
     * Extends the currently selected booking (new end time).
     */
    private void extendBooking() {
        String selectedLot = (String) lotSelector.getSelectedItem();
        String selectedSpace = (String) spaceSelector.getSelectedItem();
        String bookingIdToExtend = null;

        for (Map.Entry<String, Booking> entry : realTimeBookings.entrySet()) {
            if (entry.getValue().getSpace().equals(selectedLot + " - " + selectedSpace)) {
                bookingIdToExtend = entry.getKey();
                break;
            }
        }

        if (bookingIdToExtend == null) {
            JOptionPane.showMessageDialog(this,
                    "No booking to extend for " + selectedLot + " - " + selectedSpace,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Booking currentBooking = realTimeBookings.get(bookingIdToExtend);
        String newEndTime = JOptionPane.showInputDialog(this,
                "Enter new end time (HH:MM):",
                currentBooking.getEndTime());
        if (newEndTime == null || newEndTime.isEmpty()) {
            return; // user canceled
        }

        // Validate time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        try {
            LocalTime.parse(newEndTime, formatter);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this,
                    "Invalid time format. Use HH:MM.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check for overlap
        if (isSpaceBooked(
                selectedLot, selectedSpace,
                currentBooking.getStartTime(), newEndTime,
                bookingIdToExtend)) {
            JOptionPane.showMessageDialog(this,
                    "Extending the booking would overlap with another booking.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Update Firestore
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference bookingRef = db.collection("bookings").document(bookingIdToExtend);

        long newDuration = BookingDurationCalculator.calculateDuration(currentBooking.getStartTime(), newEndTime);
        Map<String, Object> updateMap = new HashMap<>();
        updateMap.put("endTime", newEndTime);
        updateMap.put("duration", newDuration);

        ApiFuture<WriteResult> future = bookingRef.update(updateMap);
        try {
            future.get();
            // Update local
            currentBooking.setEndTime(newEndTime);
            currentBooking.setDuration(newDuration);

            showBookingDetails();
            JOptionPane.showMessageDialog(this,
                    "Booking extended!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Error extending booking: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Shows booking details in the text area for the currently selected lot/space.
     */
    private void showBookingDetails() {
        String selectedLot = (String) lotSelector.getSelectedItem();
        String selectedSpace = (String) spaceSelector.getSelectedItem();

        if (selectedLot != null && selectedSpace != null) {
            boolean bookingFound = false;
            for (Booking booking : realTimeBookings.values()) {
                if (booking.getSpace().equals(selectedLot + " - " + selectedSpace)) {
                    bookingDetailsArea.setText(booking.toString());
                    bookingFound = true;
                    break;
                }
            }
            if (!bookingFound) {
                bookingDetailsArea.setText("No booking found for " + selectedLot + " - " + selectedSpace);
            }
        } else {
            bookingDetailsArea.setText("");
        }
    }

    /**
     * Clears the input fields after booking/cancelling.
     */
    private void clearInputFields() {
        startTimeField.setText("");
        endTimeField.setText("");
        carBrandField.setText("");
        licensePlateField.setText("");
    }

    /**
     * Updates the current time label every second.
     */
    private void startDateTimeUpdater() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        Timer timer = new Timer(1000, e -> {
            String now = LocalDateTime.now().format(formatter);
            realTimeLabel.setText(now);
        });
        timer.start();
    }

    /**
     * Creates a Booking object from a Firestore DocumentSnapshot.
     */
    private Booking createBookingFromSnapshot(DocumentSnapshot doc) {
        String lot = doc.getString("lot");
        String space = doc.getString("space");
        String startTime = doc.getString("startTime");
        String endTime = doc.getString("endTime");
        String vehicleType = doc.getString("vehicleType");
        String carBrand = doc.getString("carBrand");
        Long durationLong = doc.getLong("duration");
        String licensePlate = doc.getString("licensePlate");

        long duration = (durationLong != null) ? durationLong : 0;
        // Combine "Lot - Space" for the local Booking object
        return new Booking(
                (lot != null ? lot : "") + " - " + (space != null ? space : ""),
                startTime != null ? startTime : "",
                endTime != null ? endTime : "",
                vehicleType != null ? vehicleType : "",
                carBrand != null ? carBrand : "",
                duration,
                licensePlate != null ? licensePlate : ""
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BookingPage::new);
    }

    // Inner class to store booking details
    private class Booking {
        private String space;       // "Lot - Space"
        private String startTime;
        private String endTime;
        private String vehicleType;
        private String carBrand;
        private long duration;
        private String licensePlate;

        public Booking(String space,
                       String startTime,
                       String endTime,
                       String vehicleType,
                       String carBrand,
                       long duration,
                       String licensePlate) {
            this.space = space;
            this.startTime = startTime;
            this.endTime = endTime;
            this.vehicleType = vehicleType;
            this.carBrand = carBrand;
            this.duration = duration;
            this.licensePlate = licensePlate;
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

        public String getVehicleType() {
            return vehicleType;
        }

        public String getCarBrand() {
            return carBrand;
        }

        public long getDuration() {
            return duration;
        }

        public String getLicensePlate() {
            return licensePlate;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public void setDuration(long duration) {
            this.duration = duration;
        }

        @Override
        public String toString() {
            return "Booking Details:\n" +
                    "-------------------\n" +
                    "Space: " + space + "\n" +
                    "Start Time: " + startTime + "\n" +
                    "End Time: " + endTime + "\n" +
                    "Vehicle Type: " + vehicleType + "\n" +
                    "Car Brand: " + carBrand + "\n" +
                    "License Plate: " + licensePlate + "\n" +
                    "Duration: " + duration + " minutes\n";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Booking booking = (Booking) o;
            return duration == booking.duration &&
                    Objects.equals(space, booking.space) &&
                    Objects.equals(startTime, booking.startTime) &&
                    Objects.equals(endTime, booking.endTime) &&
                    Objects.equals(vehicleType, booking.vehicleType) &&
                    Objects.equals(carBrand, booking.carBrand) &&
                    Objects.equals(licensePlate, booking.licensePlate);
        }

        @Override
        public int hashCode() {
            return Objects.hash(space, startTime, endTime, vehicleType, carBrand, duration, licensePlate);
        }
    }
}

/**
 * Separate helper class to calculate booking duration (in minutes).
 */
class BookingDurationCalculator {
    public static long calculateDuration(String startTime, String endTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime start = LocalTime.parse(startTime, formatter);
        LocalTime end = LocalTime.parse(endTime, formatter);
        return java.time.Duration.between(start, end).toMinutes();
    }
}


