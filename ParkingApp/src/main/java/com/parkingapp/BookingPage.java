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

    // --- Constants ---
    private static final String GOOGLE_SERVICES_JSON = "google-services.json";
    private static final String USER_COLLECTION = "users";
    private static final String BOOKING_COLLECTION = "bookings";
    private static final String PARKING_SPACES_COLLECTION = "Parking_spaces";
    private static final String PARKING_SPACES_SUBCOLLECTION = "parkingSpaces";
    private static final String USER_UID_PREF_KEY = "user_uid";
    private static final String USER_TYPE_FIELD = "userType";
    private static final String EMAIL_FIELD = "email";
    private static final String STATUS_FIELD = "status";
    private static final String BOOKED_STATUS = "booked";
    private static final String CANCELLED_STATUS = "cancelled";
    private static final String LOT_FIELD = "lot";
    private static final String SPACE_FIELD = "space";
    private static final String START_TIME_FIELD = "startTime";
    private static final String END_TIME_FIELD = "endTime";
    private static final String VEHICLE_TYPE_FIELD = "vehicleType";
    private static final String CAR_BRAND_FIELD = "carBrand";
    private static final String DURATION_FIELD = "duration";
    private static final String LICENSE_PLATE_FIELD = "licensePlate";
    private static final String USER_EMAIL_FIELD = "userEmail";
    private static final String USER_TYPE_UNKNOWN = "unknown";
    private static final String TIME_FORMAT = "HH:mm";
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT);
    private static final int MIN_BOOKING_ADVANCE_MINUTES = 15;
    private static final String LICENSE_PLATE_REGEX = "^[A-Za-z0-9]{5}[A-Za-z][0-9]$";
    private String currentUserType;
    private String currentUserEmail;  // NEW


    // UI Components
    private JComboBox<String> lotSelector;
    private JComboBox<String> spaceSelector;
    private JTextField startTimeField;
    private JTextField endTimeField;
    private JComboBox<String> vehicleTypeSelector;
    private JTextField carBrandField;
    private JTextArea bookingDetailsArea;
    private JButton bookButton, cancelButton, editButton, extendButton, returnButton;
    private JLabel userTypeLabel;
    private JTextField licensePlateField;
    private JLabel realTimeLabel;
    private ActionListener bookButtonActionListener;  // Keep the original listener

    // Data Storage
    private final Map<String, Booking> realTimeBookings = new HashMap<>();
    private Firestore db; // Firestore instance


    public BookingPage() {
        initializeFrame();
        initializeFirebase();
        initializeUI();
        loadInitialData();
        startDateTimeUpdater();
        setVisible(true);
    }

    private void initializeFrame() {
        setTitle("Parking Space Booking");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
    }

    private void initializeFirebase() {
        try {
            InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream(GOOGLE_SERVICES_JSON);
            if (serviceAccount == null) {
                throw new IOException(GOOGLE_SERVICES_JSON + " not found in resources");
            }
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
            db = FirestoreClient.getFirestore(); // Initialize Firestore here
        } catch (IOException ex) {
            handleFirebaseError("Firebase initialization failed", ex);
        }
    }


    private void initializeUI() {
        JPanel mainPanel = createMainPanel();
        JPanel headerPanel = createHeaderPanel();
        JPanel inputPanel = createInputPanel();
        JPanel buttonPanel = createButtonPanel();

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel);
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        return mainPanel;
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Booking Page");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        userTypeLabel = new JLabel("Loading...", SwingConstants.RIGHT);
        userTypeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        headerPanel.add(userTypeLabel, BorderLayout.EAST);
        return headerPanel;
    }

    //region Create UI
    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = createGridBagConstraints();

        addLabelAndComponent(inputPanel, "Select Lot:", lotSelector = new JComboBox<>(), gbc, 0);
        lotSelector.addActionListener(e -> updateSpaceSelectorForSelectedLot());

        addLabelAndComponent(inputPanel, "Select Space:", spaceSelector = new JComboBox<>(), gbc, 1);
        spaceSelector.addActionListener(e -> showBookingDetails());

        addLabelAndComponent(inputPanel, "Current Time:", realTimeLabel = new JLabel(), gbc, 2);

        addLabelAndComponent(inputPanel, "Start Time (HH:MM):", startTimeField = new JTextField(5), gbc, 3);
        addLabelAndComponent(inputPanel, "End Time (HH:MM):", endTimeField = new JTextField(5), gbc, 4);

        addLabelAndComponent(inputPanel, "Vehicle Type:", vehicleTypeSelector = createVehicleTypeSelector(), gbc, 5);
        addLabelAndComponent(inputPanel, "Car Brand:", carBrandField = new JTextField(10), gbc, 6);

        addLabelAndComponent(inputPanel, "License Plate:", licensePlateField = new JTextField(10), gbc, 7);

        bookingDetailsArea = new JTextArea(10, 30);
        bookingDetailsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(bookingDetailsArea);
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;
        inputPanel.add(scrollPane, gbc);

        return inputPanel;
    }

    private GridBagConstraints createGridBagConstraints() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        return gbc;
    }

    private void addLabelAndComponent(JPanel panel, String labelText, JComponent component, GridBagConstraints gbc, int row) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(label, gbc);

        component.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.weightx = 1.0;
        panel.add(component, gbc);
    }

    private JComboBox<String> createVehicleTypeSelector() {
        JComboBox<String> selector = new JComboBox<>();
        selector.addItem("SUV");
        selector.addItem("Sedan");
        selector.addItem("Convertible");
        selector.addItem("Mini SUV");
        selector.addItem("Van");
        return selector;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout());
        bookButton = new JButton("Book Space");
        cancelButton = new JButton("Cancel Booking");
        editButton = new JButton("Edit Booking");
        extendButton = new JButton("Extend Booking");
        returnButton = new JButton("Return");

        setButtonFonts(bookButton, cancelButton, editButton, extendButton, returnButton);
        addButtonListeners();

        buttonPanel.add(bookButton);
        buttonPanel.add(cancelButton);
        buttonPanel.add(editButton);
        buttonPanel.add(extendButton);
        buttonPanel.add(returnButton);

        return buttonPanel;
    }

    private void setButtonFonts(JButton... buttons) {
        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        for (JButton button : buttons) {
            button.setFont(buttonFont);
        }
    }

    private void addButtonListeners() {
        bookButtonActionListener = e -> bookSpace(); // Store the original listener
        bookButton.addActionListener(bookButtonActionListener);
        cancelButton.addActionListener(e -> cancelBooking());
        editButton.addActionListener(e -> editBooking());
        extendButton.addActionListener(e -> extendBooking());
        returnButton.addActionListener(e -> returnToLoginPage());
    }
    //endregion

    //region Loading Initial Data
    private void loadInitialData() {
        loadUserType();
        loadParkingLots();
        loadAllBookings();
    }
    //endregion

    //region return to login
    private void returnToLoginPage() {
        this.dispose();
        // Instantiate and display your login page.  Example:
        // UserLogin loginPage = new UserLogin();
        // loginPage.setVisible(true);
    }
    //endregion

    //region load user type
    private void loadUserType() {
        SwingWorker<String, Void> worker = new SwingWorker<>() {
            @Override
            protected String doInBackground() {
                try {
                    Preferences prefs = Preferences.userNodeForPackage(BookingPage.class);
                    String uid = prefs.get(USER_UID_PREF_KEY, null);
                    if (uid == null) return "Guest";

                    DocumentReference docRef = db.collection(USER_COLLECTION).document(uid);
                    DocumentSnapshot docSnap = docRef.get().get();

                    if (docSnap.exists() && docSnap.contains(USER_TYPE_FIELD)) {
                        currentUserType = docSnap.getString(USER_TYPE_FIELD);
                        currentUserEmail = docSnap.getString(EMAIL_FIELD);  // Capture email
                        return currentUserType;
                    }
                    return "Undefined";
                } catch (InterruptedException | ExecutionException e) {
                    Thread.currentThread().interrupt();
                    return "Error: " + e.getMessage();
                }
            }

            @Override
            protected void done() {
                try {
                    String userType = get();
                    userTypeLabel.setText(userType.toUpperCase());
                } catch (Exception ex) {
                    ex.printStackTrace();
                    userTypeLabel.setText("Error");
                }
            }
        };
        worker.execute();
    }
    //endregion

    //region load parking lots
    private void loadParkingLots() {
        // Use SwingWorker for background Firestore operation
        SwingWorker<List<QueryDocumentSnapshot>, Void> worker = new SwingWorker<>() {
            @Override
            protected List<QueryDocumentSnapshot> doInBackground() throws Exception {
                ApiFuture<QuerySnapshot> future = db.collection(PARKING_SPACES_COLLECTION).get();
                QuerySnapshot snapshot = future.get(); // Get the future and get the result (blocking)
                return snapshot.getDocuments();
            }

            @Override
            protected void done() {
                try {
                    List<QueryDocumentSnapshot> documents = get();
                    updateLotSelector(documents);
                } catch (InterruptedException | ExecutionException e) {
                    handleLoadParkingLotsError("Error loading parking lots", e);
                }
            }
        };
        worker.execute();
    }
    private void updateLotSelector(List<QueryDocumentSnapshot> documents) {
        SwingUtilities.invokeLater(() -> {
            lotSelector.removeAllItems();
            for (QueryDocumentSnapshot document : documents) {
                lotSelector.addItem(document.getId());
            }
            updateSpaceSelectorForSelectedLot(); // Update spaces for initial selection
        });
    }

    //endregion

    //region load all bookings
    private void loadAllBookings() {
        // Use SwingWorker for asynchronous operation
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                ApiFuture<QuerySnapshot> future = db.collection(BOOKING_COLLECTION).get();
                QuerySnapshot snapshot = future.get(); // Get the future and get the result (blocking)
                for (DocumentSnapshot doc : snapshot.getDocuments()) {
                    if (BOOKED_STATUS.equals(doc.getString(STATUS_FIELD))) {
                        Booking booking = createBookingFromSnapshot(doc);
                        realTimeBookings.put(doc.getId(), booking);
                    }
                }
                return null;
            }

            @Override
            protected void done() {
                try {
                    get(); // Check for exceptions
                    showBookingDetails();
                } catch (InterruptedException | ExecutionException e) {
                    handleLoadBookingsError("Error loading bookings", e);
                }
            }
        };
        worker.execute();
    }
    //endregion

    //region Update Space Selector
    private void updateSpaceSelectorForSelectedLot() {
        String selectedLot = (String) lotSelector.getSelectedItem();
        if (selectedLot == null) {
            return;
        }

        // Use SwingWorker
        SwingWorker<List<String>, Void> worker = new SwingWorker<>() {
            @Override
            protected List<String> doInBackground() throws Exception {
                ApiFuture<QuerySnapshot> future = db.collection(PARKING_SPACES_COLLECTION)
                        .document(selectedLot)
                        .collection(PARKING_SPACES_SUBCOLLECTION)
                        .get();

                QuerySnapshot snapshot = future.get();  // Block here
                List<String> spaces = new ArrayList<>();
                for (QueryDocumentSnapshot document : snapshot) {
                    spaces.add(document.getId());
                }
                return spaces;
            }

            @Override
            protected void done() {
                try {
                    List<String> spaces = get(); // Retrieves result or throws exception
                    SwingUtilities.invokeLater(() -> {
                        spaceSelector.removeAllItems();
                        spaces.forEach(spaceSelector::addItem);
                        showBookingDetails(); // Refresh details after updating
                    });
                } catch (InterruptedException | ExecutionException e) {
                    handleSpaceSelectorError("Error loading spaces for lot", e);
                }
            }
        };
        worker.execute();
    }
    //endregion

    //region book, cancel, edit and extend booking
    private void bookSpace() {
        if (!validateBookingInput()) return;

        String selectedLot = (String) lotSelector.getSelectedItem();
        String selectedSpace = (String) spaceSelector.getSelectedItem();
        String startTime = startTimeField.getText().trim();
        String endTime = endTimeField.getText().trim();
        String vehicleType = (String) vehicleTypeSelector.getSelectedItem();
        String carBrand = carBrandField.getText().trim();
        String licensePlate = licensePlateField.getText().trim();

        // Check for Overlapping Bookings
        if (isSpaceBooked(selectedLot, selectedSpace, startTime, endTime, null)) {
            JOptionPane.showMessageDialog(this,
                    "This space is already booked for the selected time.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Calculate duration
        long duration = BookingDurationCalculator.calculateDuration(startTime, endTime);

        // Build your new Booking object
        String bookingId = selectedLot + "_" + selectedSpace + "_" + UUID.randomUUID();
        Booking newBooking = new Booking(
                selectedLot + " - " + selectedSpace,
                startTime,
                endTime,
                vehicleType,
                carBrand,
                duration,
                licensePlate
        );

        // Prepare data for Firestore (status = "booked" set later)
        Map<String, Object> bookingData = new HashMap<>();
        bookingData.put(LOT_FIELD, selectedLot);
        bookingData.put(SPACE_FIELD, selectedSpace);
        bookingData.put(START_TIME_FIELD, startTime);
        bookingData.put(END_TIME_FIELD, endTime);
        bookingData.put(VEHICLE_TYPE_FIELD, vehicleType);
        bookingData.put(CAR_BRAND_FIELD, carBrand);
        bookingData.put(DURATION_FIELD, duration);
        bookingData.put(LICENSE_PLATE_FIELD, licensePlate);
        bookingData.put(STATUS_FIELD, BOOKED_STATUS);  // We'll finalize after payment

        // Insert user info
        bookingData.put(USER_EMAIL_FIELD, currentUserEmail != null ? currentUserEmail : USER_TYPE_UNKNOWN);
        bookingData.put(USER_TYPE_FIELD, currentUserType != null ? currentUserType : USER_TYPE_UNKNOWN);

        // Now, instead of calling Firestore here, open the Payment page:
        // For example:
        double amountDue = PaymentRates.calculateCost(
                UserLogin.UserType.valueOf(currentUserType.toUpperCase()),
                duration
        );
        // Example: inside bookSpace(), after verifying no overlap:

        PaymentPage paymentDialog = new PaymentPage(
                /* parent frame */ this,
                currentUserEmail,                       // or however you store the user's email
                UserLogin.UserType.valueOf(currentUserType.toUpperCase()),
                duration,
                (wasPaid) -> {
                    if (wasPaid) {
                        // Payment was successful -> finalize the booking in Firestore
                        finalizeBooking(bookingData, newBooking, bookingId);
                    } else {
                        // Payment canceled or failed
                        JOptionPane.showMessageDialog(
                                BookingPage.this,
                                "Payment cancelled or failed. Booking NOT finalized.",
                                "Payment Cancelled",
                                JOptionPane.WARNING_MESSAGE
                        );
                    }
                }
        );

        paymentDialog.setVisible(true);
    }


    private Map<String, Object> prepareBookingData(String lot, String space, String startTime,
                                                   String endTime, String vehicleType, String carBrand,long duration, String licensePlate) {

        Map<String, Object> bookingData = new HashMap<>();
        bookingData.put(LOT_FIELD, lot);
        bookingData.put(SPACE_FIELD, space);
        bookingData.put(START_TIME_FIELD, startTime);
        bookingData.put(END_TIME_FIELD, endTime);
        bookingData.put(VEHICLE_TYPE_FIELD, vehicleType);
        bookingData.put(CAR_BRAND_FIELD, carBrand);
        bookingData.put(DURATION_FIELD, duration);
        bookingData.put(LICENSE_PLATE_FIELD, licensePlate);
        bookingData.put(STATUS_FIELD, BOOKED_STATUS);

        // Retrieve and add user email/type
        retrieveUserEmailAndType(bookingData);
        return bookingData;
    }

    private void retrieveUserEmailAndType(Map<String, Object> bookingData) {
        Preferences prefs = Preferences.userNodeForPackage(BookingPage.class);
        String uid = prefs.get(USER_UID_PREF_KEY, null);

        if (uid != null) {
            // Use SwingWorker for the Firestore call
            SwingWorker<DocumentSnapshot, Void> worker = new SwingWorker<>() {
                @Override
                protected DocumentSnapshot doInBackground() throws Exception {
                    DocumentReference userRef = db.collection(USER_COLLECTION).document(uid);
                    return userRef.get().get(); // Get the future and get the result
                }

                @Override
                protected void done() {
                    try {
                        DocumentSnapshot userSnap = get(); // Get result/exception
                        if (userSnap.exists()) {
                            bookingData.put(USER_EMAIL_FIELD, userSnap.getString(EMAIL_FIELD));
                            bookingData.put(USER_TYPE_FIELD, userSnap.getString(USER_TYPE_FIELD));
                        } else {
                            bookingData.put(USER_EMAIL_FIELD, USER_TYPE_UNKNOWN);
                            bookingData.put(USER_TYPE_FIELD, USER_TYPE_UNKNOWN);
                        }
                        // Now that we have user data, proceed with writing the booking
                        // (This part was moved inside the done() method)
                    } catch (InterruptedException | ExecutionException e) {
                        handleRetrieveUserError("Error retrieving user data", e);
                        // Fallback: still attempt to book with unknown user data
                        bookingData.put(USER_EMAIL_FIELD, USER_TYPE_UNKNOWN);
                        bookingData.put(USER_TYPE_FIELD, USER_TYPE_UNKNOWN);
                    }
                }
            };
            worker.execute();
        } else {
            bookingData.put(USER_EMAIL_FIELD, USER_TYPE_UNKNOWN);
            bookingData.put(USER_TYPE_FIELD, USER_TYPE_UNKNOWN);
        }
    }



    private void writeBookingToFirestore(String bookingId, Map<String, Object> bookingData, Booking newBooking) {
        // Use SwingWorker for the Firestore write operation
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                DocumentReference bookingRef = db.collection(BOOKING_COLLECTION).document(bookingId);
                ApiFuture<WriteResult> future = bookingRef.set(bookingData);
                future.get(); // Wait for write to complete
                return null;
            }

            @Override
            protected void done() {
                try {
                    get(); // Check for exceptions from doInBackground
                    realTimeBookings.put(bookingId, newBooking);
                    showBookingDetails();
                    JOptionPane.showMessageDialog(BookingPage.this,
                            "Booking successful!\nDuration: " + newBooking.getDuration() + " minutes",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                    clearInputFields();
                } catch (InterruptedException | ExecutionException e) {
                    handleBookingWriteError("Error booking space", e);
                }
            }
        };
        worker.execute();
    }



    private void cancelBooking() {
        String selectedLot = (String) lotSelector.getSelectedItem();
        String selectedSpace = (String) spaceSelector.getSelectedItem();
        String bookingIdToCancel = findBookingId(selectedLot, selectedSpace);

        if (bookingIdToCancel == null) {
            JOptionPane.showMessageDialog(this, "No booking found for the selected space.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to cancel the booking for " + selectedLot + " - " + selectedSpace + "?",
                "Confirm Cancellation", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            cancelBookingInFirestore(bookingIdToCancel);
        }
    }


    private void cancelBookingInFirestore(String bookingId) {
        // Use SwingWorker for asynchronous Firestore operation
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                DocumentReference bookingRef = db.collection(BOOKING_COLLECTION).document(bookingId);
                ApiFuture<WriteResult> future = bookingRef.update(STATUS_FIELD, CANCELLED_STATUS);
                future.get(); // Wait for completion
                return null;
            }

            @Override
            protected void done() {
                try {
                    get();  // Check for exceptions
                    realTimeBookings.remove(bookingId);
                    showBookingDetails();
                    JOptionPane.showMessageDialog(BookingPage.this, "Booking cancelled!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    clearInputFields();
                } catch (InterruptedException | ExecutionException e) {
                    handleCancelBookingError("Error cancelling booking", e);
                }
            }
        };
        worker.execute();
    }

    private void editBooking() {
        String selectedLot = (String) lotSelector.getSelectedItem();
        String selectedSpace = (String) spaceSelector.getSelectedItem();
        String bookingIdToEdit = findBookingId(selectedLot, selectedSpace);

        if (bookingIdToEdit == null) {
            JOptionPane.showMessageDialog(this, "No booking to edit for " + selectedLot + " - " + selectedSpace, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Booking currentBooking = realTimeBookings.get(bookingIdToEdit);
        // Populate fields with existing booking data
        startTimeField.setText(currentBooking.getStartTime());
        endTimeField.setText(currentBooking.getEndTime());
        vehicleTypeSelector.setSelectedItem(currentBooking.getVehicleType());
        carBrandField.setText(currentBooking.getCarBrand());
        licensePlateField.setText(currentBooking.getLicensePlate());

        // Change button and listener for update
        bookButton.setText("Update Booking");
        bookButton.removeActionListener(bookButtonActionListener);
        bookButton.addActionListener(e -> updateBooking(bookingIdToEdit));

        // Disable other actions during edit
        setComponentsEnabled(false, cancelButton, editButton, extendButton, lotSelector, spaceSelector);
    }

    private void updateBooking(String originalBookingId) {
        if (!validateBookingInput()) return;

        String selectedLot = (String) lotSelector.getSelectedItem();
        String selectedSpace = (String) spaceSelector.getSelectedItem();
        String startTime = startTimeField.getText().trim();
        String endTime = endTimeField.getText().trim();
        String vehicleType = (String) vehicleTypeSelector.getSelectedItem();
        String carBrand = carBrandField.getText().trim();
        String licensePlate = licensePlateField.getText().trim();

        // Check overlap, excluding the current booking
        if (isSpaceBooked(selectedLot, selectedSpace, startTime, endTime, originalBookingId)) {
            JOptionPane.showMessageDialog(this, "This space is already booked for the selected time.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        long duration = BookingDurationCalculator.calculateDuration(startTime, endTime);
        Map<String, Object> updateData = prepareBookingData(selectedLot, selectedSpace, startTime, endTime, vehicleType, carBrand, duration, licensePlate);
        // Don't set the status here, it should remain "booked"
        updateData.put(STATUS_FIELD, BOOKED_STATUS);

        updateBookingInFirestore(originalBookingId, updateData);
    }

    private void updateBookingInFirestore(String bookingId, Map<String, Object> updateData) {
        // Use SwingWorker for asynchronous Firestore operation
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                DocumentReference bookingRef = db.collection(BOOKING_COLLECTION).document(bookingId);
                ApiFuture<WriteResult> future = bookingRef.update(updateData);
                future.get(); // Block
                return null;
            }

            @Override
            protected void done() {
                try {
                    get(); // Check for exceptions
                    // Update local map with new values
                    Booking updatedBooking = realTimeBookings.get(bookingId);
                    updatedBooking.setStartTime(updateData.get(START_TIME_FIELD).toString());
                    updatedBooking.setEndTime(updateData.get(END_TIME_FIELD).toString());
                    updatedBooking.setVehicleType(updateData.get(VEHICLE_TYPE_FIELD).toString());
                    updatedBooking.setCarBrand(updateData.get(CAR_BRAND_FIELD).toString());
                    updatedBooking.setLicensePlate(updateData.get(LICENSE_PLATE_FIELD).toString());
                    updatedBooking.setDuration((Long) updateData.get(DURATION_FIELD));

                    showBookingDetails();
                    JOptionPane.showMessageDialog(BookingPage.this, "Booking updated!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (InterruptedException | ExecutionException e) {
                    handleUpdateBookingError("Error updating booking", e);
                } finally {
                    // Restore UI state
                    resetEditState();
                }
            }
        };
        worker.execute();
    }


    private void extendBooking() {
        String selectedLot = (String) lotSelector.getSelectedItem();
        String selectedSpace = (String) spaceSelector.getSelectedItem();
        String bookingIdToExtend = findBookingId(selectedLot, selectedSpace);

        if (bookingIdToExtend == null) {
            JOptionPane.showMessageDialog(this, "No booking to extend for " + selectedLot + " - " + selectedSpace, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Booking currentBooking = realTimeBookings.get(bookingIdToExtend);
        String newEndTime = JOptionPane.showInputDialog(this, "Enter new end time (HH:MM):", currentBooking.getEndTime());

        if (newEndTime == null || newEndTime.trim().isEmpty()) {
            return; // User canceled
        }

        if (!isValidTimeFormat(newEndTime)) {
            JOptionPane.showMessageDialog(this, "Invalid time format. Use HH:MM.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check for overlap (using the original start time)
        if (isSpaceBooked(selectedLot, selectedSpace, currentBooking.getStartTime(), newEndTime, bookingIdToExtend)) {
            JOptionPane.showMessageDialog(this, "Extending the booking would overlap with another booking.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        long newDuration = BookingDurationCalculator.calculateDuration(currentBooking.getStartTime(), newEndTime);
        Map<String, Object> updateMap = Map.of(END_TIME_FIELD, newEndTime, DURATION_FIELD, newDuration);
        extendBookingInFirestore(bookingIdToExtend, updateMap);
    }


    private void extendBookingInFirestore(String bookingId, Map<String, Object> updateMap) {
        // Use SwingWorker for asynchronous Firestore operation
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                DocumentReference bookingRef = db.collection(BOOKING_COLLECTION).document(bookingId);
                ApiFuture<WriteResult> future = bookingRef.update(updateMap);
                future.get(); // Wait for completion
                return null;
            }

            @Override
            protected void done() {
                try {
                    get(); // Check for exceptions
                    Booking currentBooking = realTimeBookings.get(bookingId);
                    currentBooking.setEndTime((String) updateMap.get(END_TIME_FIELD));
                    currentBooking.setDuration((Long) updateMap.get(DURATION_FIELD));
                    showBookingDetails();
                    JOptionPane.showMessageDialog(BookingPage.this, "Booking extended!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (InterruptedException | ExecutionException e) {
                    handleExtendBookingError("Error extending booking", e);
                }
            }
        };
        worker.execute();
    }


    //region Helper Methods
    private void resetEditState() {
        bookButton.setText("Book Space");
        bookButton.removeActionListener(bookButton.getActionListeners()[0]);
        bookButton.addActionListener(bookButtonActionListener);
        setComponentsEnabled(true, cancelButton, editButton, extendButton, lotSelector, spaceSelector);
        clearInputFields();
    }

    private void setComponentsEnabled(boolean enabled, JComponent... components) {
        for (JComponent component : components) {
            component.setEnabled(enabled);
        }
    }

    private String findBookingId(String lot, String space) {
        for (Map.Entry<String, Booking> entry : realTimeBookings.entrySet()) {
            if (entry.getValue().getSpace().equals(lot + " - " + space)) {
                return entry.getKey();
            }
        }
        return null;
    }


    private boolean validateBookingInput() {
        String selectedLot = (String) lotSelector.getSelectedItem();
        String selectedSpace = (String) spaceSelector.getSelectedItem();
        String startTime = startTimeField.getText().trim();
        String endTime = endTimeField.getText().trim();
        String licensePlate = licensePlateField.getText().trim();

        if (selectedLot == null || selectedSpace == null || startTime.isEmpty() || endTime.isEmpty() || licensePlate.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!isValidTimeFormat(startTime) || !isValidTimeFormat(endTime)) {
            JOptionPane.showMessageDialog(this, "Invalid time format. Please use HH:MM.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!isBookingTimeInFuture(startTime)) {
            String earliestStr = LocalDateTime.now().plusMinutes(MIN_BOOKING_ADVANCE_MINUTES).format(TIME_FORMATTER);
            JOptionPane.showMessageDialog(this,
                    "Booking can only be made " + MIN_BOOKING_ADVANCE_MINUTES + " minutes from now (" + earliestStr + " or later).",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!licensePlate.matches(LICENSE_PLATE_REGEX)) {
            JOptionPane.showMessageDialog(this, "Invalid license plate format. It must be 7 characters, with the 6th being a letter and the 7th a digit.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private boolean isValidTimeFormat(String time) {
        try {
            LocalTime.parse(time, TIME_FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private boolean isBookingTimeInFuture(String startTime) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowRounded = now.minusSeconds(now.getSecond()).minusNanos(now.getNano());
        LocalDateTime earliestBookingTime = nowRounded.plusMinutes(MIN_BOOKING_ADVANCE_MINUTES);
        LocalDateTime bookingStartTime;
        try {
            LocalTime enteredStartTime = LocalTime.parse(startTime, TIME_FORMATTER);
            bookingStartTime = LocalDateTime.now().withHour(enteredStartTime.getHour())
                    .withMinute(enteredStartTime.getMinute()).withSecond(0).withNano(0);
            return !bookingStartTime.isBefore(earliestBookingTime);

        } catch (DateTimeParseException e) {
            return false; // Should have been caught by isValidTimeFormat
        }
    }
    /**
     * Called only AFTER successful payment
     */
    public void finalizeBooking(Map<String, Object> bookingData, Booking newBooking, String bookingId) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                DocumentReference bookingRef = db.collection(BOOKING_COLLECTION).document(bookingId);
                ApiFuture<WriteResult> future = bookingRef.set(bookingData);
                future.get(); // Wait for write to complete
                return null;
            }

            @Override
            protected void done() {
                try {
                    get(); // Check for exceptions
                    // Store it in our local map
                    realTimeBookings.put(bookingId, newBooking);
                    showBookingDetails();
                    JOptionPane.showMessageDialog(BookingPage.this,
                            "Booking successful!\nDuration: " + newBooking.getDuration() + " minutes",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                    clearInputFields();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(BookingPage.this,
                            "Error finalizing booking: " + e.getMessage(),
                            "Booking Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        worker.execute();
    }


    private boolean isSpaceBooked(String lot, String space, String newStartTime, String newEndTime, String excludeBookingId) {
        LocalTime newStart = LocalTime.parse(newStartTime, TIME_FORMATTER);
        LocalTime newEnd = LocalTime.parse(newEndTime, TIME_FORMATTER);

        for (Map.Entry<String, Booking> entry : realTimeBookings.entrySet()) {
            if (excludeBookingId != null && excludeBookingId.equals(entry.getKey())) {
                continue; // Skip the booking being edited
            }

            Booking existingBooking = entry.getValue();
            String[] parts = existingBooking.getSpace().split(" - ");
            if (parts.length != 2) continue; // defensive check
            String existingLot = parts[0];
            String existingSpace = parts[1];

            if (lot.equals(existingLot) && space.equals(existingSpace)) {
                LocalTime existingStart = LocalTime.parse(existingBooking.getStartTime(), TIME_FORMATTER);
                LocalTime existingEnd = LocalTime.parse(existingBooking.getEndTime(), TIME_FORMATTER);
                // Check for overlap: newStart < existingEnd AND newEnd > existingStart
                if (newStart.isBefore(existingEnd) && newEnd.isAfter(existingStart)) {
                    return true;
                } }
        }
        return false;
    }

    private void showBookingDetails() {
        String selectedLot = (String) lotSelector.getSelectedItem();
        String selectedSpace = (String) spaceSelector.getSelectedItem();

        if (selectedLot != null && selectedSpace != null) {
            String bookingId = findBookingId(selectedLot, selectedSpace);
            if (bookingId != null) {
                bookingDetailsArea.setText(realTimeBookings.get(bookingId).toString());
            } else {
                bookingDetailsArea.setText("No booking found for " + selectedLot + " - " + selectedSpace);
            }
        } else {
            bookingDetailsArea.setText("");
        }
    }

    private void clearInputFields() {
        startTimeField.setText("");
        endTimeField.setText("");
        carBrandField.setText("");
        licensePlateField.setText("");
    }

    private void startDateTimeUpdater() {
        Timer timer = new Timer(1000, e -> {
            String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            realTimeLabel.setText(now);
        });
        timer.start();
    }

    private Booking createBookingFromSnapshot(DocumentSnapshot doc) {
        String lot = doc.getString(LOT_FIELD);
        String space = doc.getString(SPACE_FIELD);
        String startTime = doc.getString(START_TIME_FIELD);
        String endTime = doc.getString(END_TIME_FIELD);
        String vehicleType = doc.getString(VEHICLE_TYPE_FIELD);
        String carBrand = doc.getString(CAR_BRAND_FIELD);
        Long durationLong = doc.getLong(DURATION_FIELD);
        String licensePlate = doc.getString(LICENSE_PLATE_FIELD);

        long duration = (durationLong != null) ? durationLong : 0;
        // Combine for the local Booking object
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

    // --- Error Handling Methods ---

    private void handleFirebaseError(String message, Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, message + ": " + ex.getMessage(), "Firebase Error", JOptionPane.ERROR_MESSAGE);
    }
    private void handleUserTypeError(String message, Exception ex){
        ex.printStackTrace();
        userTypeLabel.setText("Error");
        JOptionPane.showMessageDialog(this, message + ": " + ex.getMessage(), "User Type Error", JOptionPane.ERROR_MESSAGE);
    }
    private void handleLoadParkingLotsError(String message, Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, message + ": " + ex.getMessage(), "Load Parking Lots Error", JOptionPane.ERROR_MESSAGE);
    }
    private void handleLoadBookingsError(String message, Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, message + ": " + ex.getMessage(), "Load Bookings Error", JOptionPane.ERROR_MESSAGE);
    }
    private void handleSpaceSelectorError(String message, Exception ex){
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, message + ": " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void handleRetrieveUserError(String message, Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, message + ": " + ex.getMessage(), "Retrieve User Error", JOptionPane.ERROR_MESSAGE);
    }

    private void handleBookingWriteError(String message, Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, message + ": " + ex.getMessage(), "Booking Write Error", JOptionPane.ERROR_MESSAGE);
    }

    private void handleCancelBookingError(String message, Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, message + ": " + ex.getMessage(), "Cancel Booking Error", JOptionPane.ERROR_MESSAGE);
    }
    private void handleUpdateBookingError(String message, Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, message + ": " + ex.getMessage(), "Update Booking Error", JOptionPane.ERROR_MESSAGE);
    }

    private void handleExtendBookingError(String message, Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, message + ": " + ex.getMessage(), "Extend Booking Error", JOptionPane.ERROR_MESSAGE);
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

        public Booking(String space, String startTime, String endTime, String vehicleType, String carBrand, long duration, String licensePlate) {
            this.space = space;
            this.startTime = startTime;
            this.endTime = endTime;
            this.vehicleType = vehicleType;
            this.carBrand = carBrand;
            this.duration = duration;
            this.licensePlate = licensePlate;
        }

        // Getters
        public String getSpace() { return space; }
        public String getStartTime() { return startTime; }
        public String getEndTime() { return endTime; }
        public String getVehicleType() { return vehicleType; }
        public String getCarBrand() { return carBrand; }
        public long getDuration() { return duration; }
        public String getLicensePlate() { return licensePlate; }

        // Setters (used for updating)
        public void setEndTime(String endTime) { this.endTime = endTime; }
        public void setDuration(long duration) { this.duration = duration; }
        public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }
        public void setCarBrand(String carBrand) { this.carBrand = carBrand; }
        public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
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
