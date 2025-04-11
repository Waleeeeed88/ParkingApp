package com.parkingapp.GUI;

// Firestore and Firebase Admin imports
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.parkingapp.PaymentRates;
import com.parkingapp.UserLogin;
import services.FirebaseInitialization; // Your custom initializer

// Java Standard Library imports
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.prefs.Preferences;

// Swing imports (Only needed for SwingWorker and potentially JOptionPane)
import javax.swing.*; // Keep for SwingWorker and JOptionPane

// GUI import (to interact back with the GUI)


// Represents the logic associated with the booking page.
public class BookingPage { // No longer extends JFrame

    // --- Constants ---
    private static final String USER_COLLECTION = "users";
    private static final String BOOKING_COLLECTION = "bookings";
    private static final String PARKING_SPACES_COLLECTION = "Parking_spaces";
    private static final String PARKING_SPACES_SUBCOLLECTION = "parkingSpaces";
    private static final String USER_UID_PREF_KEY = "user_uid";
    // Field Names (Firestore document fields)
    private static final String USER_TYPE_FIELD = "userType";
    private static final String EMAIL_FIELD = "email";
    private static final String BALANCE_FIELD = "balance";
    private static final String STATUS_FIELD = "status";
    private static final String LOT_FIELD = "lot";
    private static final String SPACE_FIELD = "space";
    private static final String START_TIME_FIELD = "startTime";
    private static final String END_TIME_FIELD = "endTime";
    private static final String VEHICLE_TYPE_FIELD = "vehicleType";
    private static final String CAR_BRAND_FIELD = "carBrand";
    private static final String DURATION_FIELD = "duration";
    private static final String LICENSE_PLATE_FIELD = "licensePlate";
    private static final String USER_EMAIL_FIELD = "userEmail";
    private static final String BOOKING_ID_FIELD = "bookingId"; // Assuming you store booking ID

    // Status Values
    private static final String BOOKED_STATUS = "booked";
    private static final String CANCELLED_STATUS = "cancelled";
    private static final String CHECKED_IN_STATUS = "Checked In";
    private static final String NO_SHOW_STATUS = "No Show";

    // Other Constants
    private static final String USER_TYPE_UNKNOWN = "unknown";
    private static final String TIME_FORMAT = "HH:mm";
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT);
    private static final int MIN_BOOKING_ADVANCE_MINUTES = 0;
    // Relaxed regex, adjust if needed. Original: "^[A-Za-z0-9]{5}[A-Za-z][0-9]$"
    private static final String LICENSE_PLATE_REGEX = "^[A-Za-z0-9 -]+$";

    // --- State Variables ---
    private Firestore db;
    private BookingPageGUI bookingPageGUI; // Reference back to the GUI
    private String currentUserUid;
    private String currentUserType;
    private String currentUserEmail;
    // Use the external com.parkingapp.Booking class
    private final Map<String, com.parkingapp.Booking> realTimeBookings = new HashMap<>();

    // --- Constructor ---
    public BookingPage() {
        initializeFirebase();
        loadCurrentUserDetails();
    }

    // Method to link the GUI instance
    public void setGUIReference(BookingPageGUI gui) {
        this.bookingPageGUI = gui;
        loadInitialUIData(); // Load data needed for UI now that GUI exists
    }

    // --- Initialization ---
    private void initializeFirebase() {
        try {
            db = FirebaseInitialization.getInstance();
            if (db == null) {
                throw new RuntimeException("Firestore initialization returned null.");
            }
        } catch (RuntimeException ex) {
            // Use internal error handler which can show JOptionPane via GUI ref later
            handleError("Firebase initialization failed", ex);
        }
    }

    private void loadCurrentUserDetails() {
        Preferences prefs = Preferences.userNodeForPackage(UserLogin.class);
        this.currentUserUid = prefs.get(USER_UID_PREF_KEY, null);

        if (this.currentUserUid == null) {
            handleError("User not logged in (UID not found).", null);
            this.currentUserType = USER_TYPE_UNKNOWN;
            this.currentUserEmail = USER_TYPE_UNKNOWN;
            return;
        }
        // Fetch details in background
        fetchUserDetailsFromFirestore();
    }

    private void fetchUserDetailsFromFirestore() {
        if (db == null || currentUserUid == null) return;
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            String email = USER_TYPE_UNKNOWN;
            String type = USER_TYPE_UNKNOWN;
            boolean found = false;

            @Override
            protected Void doInBackground() throws Exception {
                DocumentReference docRef = db.collection(USER_COLLECTION).document(currentUserUid);
                DocumentSnapshot userSnap = docRef.get().get();
                if (userSnap.exists()) {
                    email = userSnap.getString(EMAIL_FIELD);
                    type = userSnap.getString(USER_TYPE_FIELD);
                    found = true;
                }
                return null;
            }

            @Override
            protected void done() {
                try {
                    get(); // Check for exceptions from doInBackground
                    currentUserEmail = email;
                    currentUserType = type;
                    if (!found) {
                        handleError("User document not found for UID: " + currentUserUid, null);
                    }
                    // Now that details are loaded, update relevant parts of GUI if ready
                    if(bookingPageGUI != null) {
                        loadUserTypeForDisplay();
                        loadUserBalance();
                    }
                } catch (Exception e) {
                    currentUserEmail = USER_TYPE_UNKNOWN;
                    currentUserType = USER_TYPE_UNKNOWN;
                    handleError("Error fetching user details from Firestore", e);
                    if(bookingPageGUI != null) { // Show error state in GUI
                        bookingPageGUI.updateUserTypeDisplay("Error");
                        bookingPageGUI.updateUserBalanceDisplay(0.0);
                    }
                }
            }
        };
        worker.execute();
    }

    public void loadInitialUIData() {
        // Check if critical details are loaded, otherwise wait or show error
        if (currentUserUid == null) {
            if (bookingPageGUI != null) {
                bookingPageGUI.updateUserTypeDisplay("Error");
                bookingPageGUI.updateUserBalanceDisplay(0.0);
                bookingPageGUI.updateLotSelector(new ArrayList<>());
            }
            return;
        }
        // Trigger GUI updates now that GUI ref is likely set
        loadUserTypeForDisplay();
        loadUserBalance();
        loadParkingLots();
        loadAllBookings();
    }

    // --- Data Loading Methods ---

    public void loadUserTypeForDisplay() {
        // Update GUI only if reference exists
        if (bookingPageGUI != null) {
            bookingPageGUI.updateUserTypeDisplay(currentUserType != null ? currentUserType : "Loading...");
        }
    }

    public void loadUserBalance() {
        if (currentUserUid == null || db == null) {
            if(bookingPageGUI != null) bookingPageGUI.updateUserBalanceDisplay(0.0);
            return;
        }
        SwingWorker<Double, Void> worker = createBalanceWorker();
        worker.execute();
    }

    private SwingWorker<Double, Void> createBalanceWorker() {
        return new SwingWorker<>() {
            @Override
            protected Double doInBackground() throws Exception {
                DocumentReference docRef = db.collection(USER_COLLECTION).document(currentUserUid);
                DocumentSnapshot docSnap = docRef.get().get();
                if (docSnap.exists() && docSnap.contains(BALANCE_FIELD)) {
                    return docSnap.getDouble(BALANCE_FIELD);
                }
                return 0.0;
            }
            @Override
            protected void done() {
                try {
                    double balance = get();
                    if (bookingPageGUI != null) bookingPageGUI.updateUserBalanceDisplay(balance);
                } catch (Exception e) {
                    handleError("Error loading user balance", e);
                    if (bookingPageGUI != null) bookingPageGUI.updateUserBalanceDisplay(0.0);
                }
            }
        };
    }

    public void loadParkingLots() {
        if (db == null) return;
        SwingWorker<List<String>, Void> worker = createLotLoadingWorker();
        worker.execute();
    }

    private SwingWorker<List<String>, Void> createLotLoadingWorker() {
        return new SwingWorker<>() {
            @Override
            protected List<String> doInBackground() throws Exception {
                ApiFuture<QuerySnapshot> future = db.collection(PARKING_SPACES_COLLECTION)
                        .whereEqualTo("enabled", true)
                        .orderBy(FieldPath.documentId())
                        .get();
                List<String> lots = new ArrayList<>();
                for (QueryDocumentSnapshot doc : future.get().getDocuments()) {
                    lots.add(doc.getId());
                }
                return lots;
            }
            @Override
            protected void done() {
                try {
                    List<String> lots = get();
                    if (bookingPageGUI != null) bookingPageGUI.updateLotSelector(lots);
                } catch (Exception e) {
                    handleError("Error loading parking lots", e);
                    if (bookingPageGUI != null) bookingPageGUI.updateLotSelector(new ArrayList<>());
                }
            }
        };
    }

    public void loadSpacesForLot(String selectedLot) {
        if (db == null || selectedLot == null) {
            if(bookingPageGUI != null) bookingPageGUI.updateSpaceSelector(new ArrayList<>());
            return;
        }
        SwingWorker<List<String>, Void> worker = createSpaceLoadingWorker(selectedLot);
        worker.execute();
    }

    private SwingWorker<List<String>, Void> createSpaceLoadingWorker(String selectedLot) {
        return new SwingWorker<>() {
            @Override
            protected List<String> doInBackground() throws Exception {
                ApiFuture<QuerySnapshot> future = db.collection(PARKING_SPACES_COLLECTION)
                        .document(selectedLot)
                        .collection(PARKING_SPACES_SUBCOLLECTION)
                        .whereEqualTo("enabled", true)
                        .orderBy("id")
                        .get();
                List<String> spaces = new ArrayList<>();
                for (QueryDocumentSnapshot doc : future.get().getDocuments()) {
                    spaces.add(doc.getId());
                }
                return spaces;
            }
            @Override
            protected void done() {
                try {
                    List<String> spaces = get();
                    if (bookingPageGUI != null) bookingPageGUI.updateSpaceSelector(spaces);
                } catch (Exception e) {
                    handleError("Error loading spaces for lot " + selectedLot, e);
                    if (bookingPageGUI != null) bookingPageGUI.updateSpaceSelector(new ArrayList<>());
                }
            }
        };
    }

    private void loadAllBookings() {
        if (db == null) return;
        SwingWorker<Void, Void> worker = createLoadAllBookingsWorker();
        worker.execute();
    }

    private SwingWorker<Void, Void> createLoadAllBookingsWorker() {
        return new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                ApiFuture<QuerySnapshot> future = db.collection(BOOKING_COLLECTION)
                        .whereEqualTo(STATUS_FIELD, BOOKED_STATUS)
                        .get();
                Map<String, com.parkingapp.Booking> tempBookings = new HashMap<>();
                for (DocumentSnapshot doc : future.get().getDocuments()) {
                    // Use the external Booking class
                    com.parkingapp.Booking booking = createBookingFromSnapshot(doc);
                    if (booking != null) {
                        // The key is the Firestore document ID
                        tempBookings.put(doc.getId(), booking);
                    }
                }
                // Safely update the shared map
                synchronized (realTimeBookings) {
                    realTimeBookings.clear();
                    realTimeBookings.putAll(tempBookings);
                }
                return null;
            }
            @Override
            protected void done() {
                try {
                    get(); // Check for exceptions
                    System.out.println("Loaded " + realTimeBookings.size() + " active bookings into memory.");
                } catch (Exception e) {
                    handleError("Error loading all active bookings", e);
                }
            }
        };
    }

    public void fetchAndDisplayBookingDetails(String lot, String space) {
        String details = "No active booking found for " + lot + " - " + space;
        String targetSpaceId = lot + " - " + space; // Format used in Booking object
        synchronized (realTimeBookings) {
            for (com.parkingapp.Booking booking : realTimeBookings.values()) {
                if (targetSpaceId.equals(booking.getSpace())) {
                    details = booking.toString(); // Assumes Booking.toString() is suitable
                    break;
                }
            }
        }
        if (bookingPageGUI != null) {
            bookingPageGUI.updateBookingDetailsArea(details);
        }
    }

    public void loadUserBookings() {
        if (db == null || currentUserEmail == null) {
            if(bookingPageGUI != null) bookingPageGUI.updateBookingsTable(new ArrayList<>());
            return;
        }
        SwingWorker<List<Object[]>, Void> worker = createUserBookingsWorker();
        worker.execute();
    }

    private SwingWorker<List<Object[]>, Void> createUserBookingsWorker() {
        return new SwingWorker<>() {
            @Override
            protected List<Object[]> doInBackground() throws Exception {
                ApiFuture<QuerySnapshot> future = db.collection(BOOKING_COLLECTION)
                        .whereEqualTo(USER_EMAIL_FIELD, currentUserEmail)
                        // .orderBy(START_TIME_FIELD, Query.Direction.DESCENDING) // Optional sort
                        .get();
                List<Object[]> bookingData = new ArrayList<>();
                for (DocumentSnapshot doc : future.get().getDocuments()) {
                    // Data order must match table columns in BookingPageGUI exactly
                    bookingData.add(new Object[]{
                            doc.getString(LOT_FIELD),
                            doc.getString(SPACE_FIELD),
                            doc.getString(START_TIME_FIELD),
                            doc.getString(END_TIME_FIELD),
                            doc.getString(STATUS_FIELD),
                            doc.getString(LICENSE_PLATE_FIELD),
                            doc.getId() // Booking ID for actions
                    });
                }
                return bookingData;
            }
            @Override
            protected void done() {
                try {
                    List<Object[]> data = get();
                    if (bookingPageGUI != null) bookingPageGUI.updateBookingsTable(data);
                } catch (Exception e) {
                    handleError("Error loading user bookings", e);
                    if (bookingPageGUI != null) bookingPageGUI.updateBookingsTable(new ArrayList<>());
                }
            }
        };
    }

    // --- Booking Action Methods (Called by GUI) ---

    public void attemptBooking(String lot, String space, String startTime, String endTime,
                               String vehicleType, String carBrand, String licensePlate) {

        // ... (Existing validation code remains the same) ...
        if (!validateBookingTimes(startTime, endTime) || !validateLicensePlate(licensePlate)) {
            return;
        }
        if (isSpaceBookedInMemory(lot, space, startTime, endTime, null)) {
            showGuiErrorMessage("This space is already booked for the selected time.");
            return;
        }
        long duration = calculateDuration(startTime, endTime);
        if (duration <= 0) {
            showGuiErrorMessage("End time must be after start time.");
            return;
        }
        UserLogin.UserType typeEnum = parseUserType(currentUserType);
        if (typeEnum == null) { showGuiErrorMessage("Cannot determine user type for pricing."); return; }
        double amountDue = PaymentRates.calculateCost(typeEnum, duration);

        // Show Payment Page - MODIFY THE CALLBACK LAMBDA HERE:
        PaymentPage paymentDialog = new PaymentPage(
                bookingPageGUI, // Parent frame
                currentUserEmail,
                typeEnum,
                duration, // Pass duration for cost calculation *within* PaymentPage if needed, or amountDue directly
                // This is the callback function: (paymentSuccessful) -> { ... }
                (paymentSuccessful) -> {
                    if (paymentSuccessful) {
                        // Payment successful!
                        // 1. Finalize booking in Firestore
                        finalizeBooking(lot, space, startTime, endTime, vehicleType, carBrand, licensePlate, duration);

                        // 2. *** ADD THIS LINE TO REFRESH BALANCE DISPLAY ***
                        this.loadUserBalance(); // Trigger balance reload which updates GUI

                    } else {
                        // Payment failed or cancelled
                        showGuiInfoMessage("Payment failed or cancelled. Booking not created.");
                    }
                });
        paymentDialog.setVisible(true); // Show the modal payment dialog
    }

    private void finalizeBooking(String lot, String space, String startTime, String endTime,
                                 String vehicleType, String carBrand, String licensePlate, long duration) {
        String bookingId = generateBookingId(lot, space);
        Map<String, Object> bookingData = createBookingDataMap(lot, space, startTime, endTime, vehicleType, carBrand, licensePlate, duration, bookingId);

        SwingWorker<Boolean, Void> worker = createFirestoreWriteWorker(bookingId, bookingData);
        worker.execute(); // Execute the Firestore write
    }

    // Creates the data map for Firestore booking document
    private Map<String, Object> createBookingDataMap(String lot, String space, String startTime, String endTime, String vehicleType, String carBrand, String licensePlate, long duration, String bookingId) {
        Map<String, Object> data = new HashMap<>();
        data.put(LOT_FIELD, lot);
        data.put(SPACE_FIELD, space);
        data.put(START_TIME_FIELD, startTime);
        data.put(END_TIME_FIELD, endTime);
        data.put(VEHICLE_TYPE_FIELD, vehicleType);
        data.put(CAR_BRAND_FIELD, carBrand);
        data.put(DURATION_FIELD, duration);
        data.put(LICENSE_PLATE_FIELD, licensePlate);
        data.put(STATUS_FIELD, BOOKED_STATUS);
        data.put(USER_EMAIL_FIELD, currentUserEmail);
        data.put(USER_TYPE_FIELD, currentUserType);
        data.put(BOOKING_ID_FIELD, bookingId); // Include the ID itself if needed
        return data;
    }

    // Creates a SwingWorker for writing booking data to Firestore
    private SwingWorker<Boolean, Void> createFirestoreWriteWorker(String bookingId, Map<String, Object> bookingData) {
        return new SwingWorker<>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                if (db == null) throw new IllegalStateException("Firestore not initialized.");
                DocumentReference bookingRef = db.collection(BOOKING_COLLECTION).document(bookingId);
                bookingRef.set(bookingData).get(); // Use set() to create or overwrite
                return true;
            }

            @Override
            protected void done() {
                try {
                    if (get()) { // Check if doInBackground succeeded
                        // Add to local map *using external Booking class*
                        com.parkingapp.Booking newBooking = new com.parkingapp.Booking(
                                (String)bookingData.get(LOT_FIELD) + " - " + (String)bookingData.get(SPACE_FIELD),
                                (String)bookingData.get(START_TIME_FIELD),
                                (String)bookingData.get(END_TIME_FIELD),
                                (String)bookingData.get(VEHICLE_TYPE_FIELD),
                                (String)bookingData.get(CAR_BRAND_FIELD),
                                (long)bookingData.get(DURATION_FIELD)
                                // Add license plate if Booking class supports it
                        );
                        synchronized(realTimeBookings) {
                            realTimeBookings.put(bookingId, newBooking);
                        }
                        showGuiInfoMessage("Booking successful!\nDuration: " + bookingData.get(DURATION_FIELD) + " minutes");
                        if (bookingPageGUI != null) {
                            bookingPageGUI.resetToBookingMode(); // Use the reset method
                            bookingPageGUI.updateBookingDetailsArea(newBooking.toString());
                        }
                    }
                } catch (Exception e) {
                    handleError("Error saving booking to Firestore", e);
                    showGuiErrorMessage("Failed to save booking. Please try again.");
                }
            }
        };
    }

    public void cancelBookingForSelectedSpace(String lot, String space) {
        String bookingIdToCancel = findBookingIdInMemory(lot, space);
        if (bookingIdToCancel == null) {
            showGuiErrorMessage("No active booking found for " + lot + " - " + space + " to cancel.");
            return;
        }
        SwingWorker<Boolean, Void> worker = createBookingStatusUpdateWorker(bookingIdToCancel, CANCELLED_STATUS);
        worker.execute();
    }

    private SwingWorker<Boolean, Void> createBookingStatusUpdateWorker(String bookingId, String newStatus) {
        return new SwingWorker<>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                if (db == null) throw new IllegalStateException("Firestore not initialized.");
                DocumentReference bookingRef = db.collection(BOOKING_COLLECTION).document(bookingId);
                bookingRef.update(STATUS_FIELD, newStatus).get();
                return true;
            }
            @Override
            protected void done() {
                try {
                    if (get()) {
                        boolean removed = false;
                        // Update local map only if status is cancelled or maybe completed
                        if (CANCELLED_STATUS.equals(newStatus) || NO_SHOW_STATUS.equals(newStatus)) {
                            synchronized(realTimeBookings) {
                                removed = (realTimeBookings.remove(bookingId) != null);
                            }
                        }
                        showGuiInfoMessage("Booking status updated to: " + newStatus);
                        if (bookingPageGUI != null && removed) {
                            // Reset fields only if it was the currently displayed one being cancelled
                            bookingPageGUI.resetToBookingMode();
                            // No need to update details area if it was removed
                            bookingPageGUI.updateBookingDetailsArea("Booking status updated for selected space.");

                        } else if (bookingPageGUI != null) {
                            // If status changed but not removed (e.g., checked-in), refresh details
                            fetchAndDisplayBookingDetails(findLotFromBookingId(bookingId), findSpaceFromBookingId(bookingId));
                        }
                        // Always refresh the 'My Bookings' table if open
                        loadUserBookings();
                    }
                } catch (Exception e) {
                    handleError("Error updating booking status in Firestore", e);
                    showGuiErrorMessage("Failed to update booking status.");
                }
            }
        };
    }


    /** Initiates the edit process by fetching data and telling GUI to populate fields */
    public String prepareEditing(String lot, String space) {
        String bookingIdToEdit = findBookingIdInMemory(lot, space);
        if (bookingIdToEdit == null) {
            showGuiErrorMessage("No active booking found to edit for " + lot + " - " + space);
            return null;
        }

        // Fetch potentially more up-to-date details from Firestore? Or rely on map?
        // For simplicity, using map data + direct fetch for license plate for now.
        com.parkingapp.Booking currentBooking;
        synchronized(realTimeBookings) {
            currentBooking = realTimeBookings.get(bookingIdToEdit);
        }
        if (currentBooking == null) {
            showGuiErrorMessage("Booking data inconsistency. Please reload.");
            loadAllBookings(); // Attempt to refresh map
            return null;
        }

        // Fetch license plate directly as it's not in Booking object currently
        fetchLicensePlateForEditing(bookingIdToEdit, currentBooking);

        return bookingIdToEdit; // Return ID for GUI to store
    }

    // Fetches license plate specifically for editing and triggers GUI update
    private void fetchLicensePlateForEditing(String bookingId, com.parkingapp.Booking bookingToEdit) {
        if (db == null) return;
        SwingWorker<String,Void> worker = new SwingWorker<>(){
            @Override
            protected String doInBackground() throws Exception {
                DocumentSnapshot snap = db.collection(BOOKING_COLLECTION).document(bookingId).get().get();
                return snap.exists() ? snap.getString(LICENSE_PLATE_FIELD) : null;
            }
            @Override
            protected void done() {
                try {
                    String licensePlate = get();
                    if (licensePlate == null) licensePlate = ""; // Default if not found

                    if (bookingPageGUI != null) {
                        bookingPageGUI.populateFieldsForEditing(
                                bookingToEdit.getStartTime(), bookingToEdit.getEndTime(),
                                bookingToEdit.getVehicleType(), bookingToEdit.getCarBrand(),
                                licensePlate
                        );
                        // GUI's setEditMode method should be called by the action listener
                        // that called prepareEditing, passing the bookingId.
                    }
                } catch (Exception e) {
                    handleError("Error fetching license plate for edit", e);
                    showGuiErrorMessage("Could not load full details for editing.");
                }
            }
        };
        worker.execute();
    }

    /** Attempts to update an existing booking after user edits fields */
    public void attemptUpdateBooking(String bookingIdToUpdate, String lot, String space, String startTime, String endTime,
                                     String vehicleType, String carBrand, String licensePlate) {

        // Validation
        if (!validateBookingTimes(startTime, endTime) || !validateLicensePlate(licensePlate)) {
            return;
        }
        // Check for Overlap (excluding the booking being updated)
        if (isSpaceBookedInMemory(lot, space, startTime, endTime, bookingIdToUpdate)) {
            showGuiErrorMessage("This space is already booked for the selected time.");
            return;
        }

        // Get original booking to calculate cost difference
        com.parkingapp.Booking originalBooking;
        synchronized(realTimeBookings) {
            originalBooking = realTimeBookings.get(bookingIdToUpdate);
        }
        if (originalBooking == null) {
            showGuiErrorMessage("Cannot update: Original booking data not found.");
            if(bookingPageGUI != null) bookingPageGUI.resetToBookingMode();
            return;
        }

        long newDuration = calculateDuration(startTime, endTime);
        long originalDuration = originalBooking.getDuration();
        long durationChange = newDuration - originalDuration;

        UserLogin.UserType typeEnum = parseUserType(currentUserType);
        if (typeEnum == null) { showGuiErrorMessage("Cannot determine user type for pricing."); return; }

        double costChange = PaymentRates.calculateCost(typeEnum, durationChange); // Can be negative for refund

        // Prepare update data map
        Map<String, Object> updateData = new HashMap<>();
        updateData.put(START_TIME_FIELD, startTime);
        updateData.put(END_TIME_FIELD, endTime);
        updateData.put(VEHICLE_TYPE_FIELD, vehicleType);
        updateData.put(CAR_BRAND_FIELD, carBrand);
        updateData.put(DURATION_FIELD, newDuration);
        updateData.put(LICENSE_PLATE_FIELD, licensePlate);
        // Don't update status, lot, space, userEmail, userType, bookingId

        if (costChange > 0) {
            // Additional payment required
            PaymentPage paymentDialog = new PaymentPage(bookingPageGUI, currentUserEmail, typeEnum, durationChange, // Pass duration CHANGE
                    (paymentSuccessful) -> {
                        if (paymentSuccessful) {
                            updateBookingInFirestore(bookingIdToUpdate, updateData);
                        } else {
                            showGuiInfoMessage("Payment failed or cancelled. Update cancelled.");
                            if(bookingPageGUI != null) bookingPageGUI.resetToBookingMode();
                        }
                    });
            paymentDialog.setVisible(true);
        } else if (costChange < 0) {
            // Refund might be needed - for now, just update and inform
            showGuiInfoMessage(String.format("Booking time reduced. Potential refund: $%.2f (Manual processing needed).", -costChange));
            updateBookingInFirestore(bookingIdToUpdate, updateData);
        }
        else {
            // No cost change, just update
            updateBookingInFirestore(bookingIdToUpdate, updateData);
        }
    }

    /** Performs the actual Firestore update for booking changes */
    private void updateBookingInFirestore(String bookingId, Map<String, Object> updateData) {
        SwingWorker<Boolean, Void> worker = new SwingWorker<>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                if (db == null) throw new IllegalStateException("Firestore not initialized.");
                DocumentReference bookingRef = db.collection(BOOKING_COLLECTION).document(bookingId);
                bookingRef.update(updateData).get(); // Use update() not set()
                return true;
            }
            @Override
            protected void done() {
                try {
                    if (get()) {
                        // Update local map
                        synchronized(realTimeBookings) {
                            com.parkingapp.Booking booking = realTimeBookings.get(bookingId);
                            if (booking != null) {
                                // Update fields based on updateData map
                                booking.setStartTime((String)updateData.get(START_TIME_FIELD));
                                booking.setEndTime((String)updateData.get(END_TIME_FIELD));
                                booking.setVehicleType((String)updateData.get(VEHICLE_TYPE_FIELD));
                                booking.setCarBrand((String)updateData.get(CAR_BRAND_FIELD));
                                booking.setDuration((long)updateData.get(DURATION_FIELD));
                                // Update license plate if Booking class supports it
                            }
                        }
                        showGuiInfoMessage("Booking updated successfully!");
                        if (bookingPageGUI != null) {
                            bookingPageGUI.resetToBookingMode(); // Reset UI state
                            // Refresh details display
                            fetchAndDisplayBookingDetails(findLotFromBookingId(bookingId), findSpaceFromBookingId(bookingId));
                        }
                    }
                } catch (Exception e) {
                    handleError("Error saving booking updates to Firestore", e);
                    showGuiErrorMessage("Failed to save booking updates.");
                    if(bookingPageGUI != null) bookingPageGUI.resetToBookingMode(); // Reset UI on failure too
                }
            }
        };
        worker.execute();
    }


    public void attemptExtendBooking(String lot, String space, String newEndTime) {
        String bookingIdToExtend = findBookingIdInMemory(lot, space);
        if (bookingIdToExtend == null) { showGuiErrorMessage("No active booking found to extend."); return; }

        com.parkingapp.Booking currentBooking;
        synchronized(realTimeBookings) { currentBooking = realTimeBookings.get(bookingIdToExtend); }
        if(currentBooking == null) { showGuiErrorMessage("Booking data missing locally."); return; }

        String startTime = currentBooking.getStartTime();

        if (!validateBookingTimes(startTime, newEndTime)) return;
        if (isSpaceBookedInMemory(lot, space, startTime, newEndTime, bookingIdToExtend)) {
            showGuiErrorMessage("Extending would overlap with another booking."); return;
        }

        long originalDuration = currentBooking.getDuration();
        long newDuration = calculateDuration(startTime, newEndTime);
        long additionalDuration = newDuration - originalDuration;

        if (additionalDuration <= 0) { showGuiErrorMessage("New end time must be later."); return; }

        UserLogin.UserType typeEnum = parseUserType(currentUserType);
        if (typeEnum == null) { showGuiErrorMessage("Cannot determine user type for pricing."); return; }

        double additionalCost = PaymentRates.calculateCost(typeEnum, additionalDuration);

        int confirm = JOptionPane.showConfirmDialog(bookingPageGUI,
                String.format("Extending will cost $%.2f extra. Proceed?", additionalCost),
                "Confirm Extension Cost", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) { showGuiInfoMessage("Extension cancelled."); return; }

        PaymentPage paymentDialog = new PaymentPage(bookingPageGUI, currentUserEmail, typeEnum, additionalDuration,
                (paymentSuccessful) -> {
                    if (paymentSuccessful) {
                        updateBookingEndTimeInFirestore(bookingIdToExtend, newEndTime, newDuration);
                    } else {
                        showGuiInfoMessage("Payment failed or cancelled. Extension not applied.");
                    }
                });
        paymentDialog.setVisible(true);
    }

    private void updateBookingEndTimeInFirestore(String bookingId, String newEndTime, long newDuration) {
        SwingWorker<Boolean, Void> worker = new SwingWorker<>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                if (db == null) throw new IllegalStateException("Firestore not initialized.");
                DocumentReference ref = db.collection(BOOKING_COLLECTION).document(bookingId);
                Map<String, Object> updates = Map.of(END_TIME_FIELD, newEndTime, DURATION_FIELD, newDuration);
                ref.update(updates).get();
                return true;
            }
            @Override
            protected void done() {
                try {
                    if (get()) {
                        synchronized(realTimeBookings) {
                            com.parkingapp.Booking booking = realTimeBookings.get(bookingId);
                            if (booking != null) {
                                booking.setEndTime(newEndTime);
                                booking.setDuration(newDuration);
                            }
                        }
                        showGuiInfoMessage("Booking extended successfully!");
                        if (bookingPageGUI != null) {
                            fetchAndDisplayBookingDetails(findLotFromBookingId(bookingId), findSpaceFromBookingId(bookingId));
                            loadUserBookings(); // Refresh 'My Bookings' table too
                        }
                    }
                } catch (Exception e) {
                    handleError("Error extending booking in Firestore", e);
                    showGuiErrorMessage("Failed to save booking extension.");
                }
            }
        };
        worker.execute();
    }

    public void processLoadFunds(double amountToAdd) {
        if (currentUserUid == null || db == null || amountToAdd <= 0) return;
        SwingWorker<Double, Void> worker = createLoadFundsWorker(amountToAdd);
        worker.execute();
    }

    private SwingWorker<Double, Void> createLoadFundsWorker(double amountToAdd) {
        return new SwingWorker<>() {
            @Override
            protected Double doInBackground() throws Exception {
                DocumentReference userRef = db.collection(USER_COLLECTION).document(currentUserUid);
                return db.runTransaction(tx -> {
                    DocumentSnapshot snap = tx.get(userRef).get();
                    double current = snap.exists() && snap.contains(BALANCE_FIELD) ? snap.getDouble(BALANCE_FIELD) : 0.0;
                    double newBalance = current + amountToAdd;
                    tx.update(userRef, BALANCE_FIELD, newBalance);
                    return newBalance;
                }).get();
            }
            @Override
            protected void done() {
                try {
                    double newBalance = get();
                    showGuiInfoMessage(String.format("Funds loaded. New balance: $%.2f", newBalance));
                    if (bookingPageGUI != null) bookingPageGUI.updateUserBalanceDisplay(newBalance);
                } catch (Exception e) {
                    handleError("Error processing fund loading", e);
                    showGuiErrorMessage("Failed to load funds.");
                }
            }
        };
    }

    public void performCheckIn(String bookingId, String lot, String space, String checkInTime, String enteredLicensePlate) {
        if (db == null || bookingId == null) return;
        SwingWorker<Boolean, String> worker = createCheckInWorker(bookingId, enteredLicensePlate);
        worker.execute();
    }

    private SwingWorker<Boolean, String> createCheckInWorker(String bookingId, String enteredLicensePlate) {
        return new SwingWorker<>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                DocumentReference bookingRef = db.collection(BOOKING_COLLECTION).document(bookingId);
                DocumentSnapshot snap = bookingRef.get().get();
                if (!snap.exists()) { publish("Booking not found."); return false; }

                String actualLicense = snap.getString(LICENSE_PLATE_FIELD);
                if (actualLicense == null || !actualLicense.equalsIgnoreCase(enteredLicensePlate)) {
                    publish("License plate mismatch! Check-in denied."); return false;
                }
                // Simulate sensor check
                Thread.sleep(1000); // Reduced delay
                // Update status
                bookingRef.update(STATUS_FIELD, CHECKED_IN_STATUS).get();
                return true;
            }
            @Override
            protected void process(List<String> chunks) { chunks.forEach(BookingPage.this::showGuiErrorMessage); } // Show errors via GUI
            @Override
            protected void done() {
                try {
                    if (get()) {
                        showGuiInfoMessage("Sensor verified. Check-in successful!");
                        loadUserBookings(); // Refresh 'My Bookings'
                    }
                } catch (Exception e) {
                    handleError("Error during check-in", e);
                    showGuiErrorMessage("Check-in failed unexpectedly.");
                }
            }
        };
    }

    public void handleLogoutOrReturn() {
        Preferences prefs = Preferences.userNodeForPackage(UserLogin.class);
        prefs.remove(USER_UID_PREF_KEY);
        System.out.println("User UID cleared. Logic state reset.");
        // Clear local state
        this.currentUserUid = null; this.currentUserEmail = null; this.currentUserType = null;
        synchronized(realTimeBookings) { this.realTimeBookings.clear(); }
        // GUI window is closed by its own action listener
        // If login needs to be reshown, that logic belongs in the main application flow
    }

    // --- Utility & Helper Methods ---

    private String findBookingIdInMemory(String lot, String space) {
        String targetSpaceId = lot + " - " + space;
        synchronized (realTimeBookings) {
            for (Map.Entry<String, com.parkingapp.Booking> entry : realTimeBookings.entrySet()) {
                if (targetSpaceId.equals(entry.getValue().getSpace())) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    private String findLotFromBookingId(String bookingId) {
        synchronized(realTimeBookings) {
            com.parkingapp.Booking booking = realTimeBookings.get(bookingId);
            if (booking != null && booking.getSpace() != null) {
                String[] parts = booking.getSpace().split(" - ", 2); // Limit split
                if (parts.length > 0) return parts[0];
            }
        }
        return null;
    }

    private String findSpaceFromBookingId(String bookingId) {
        synchronized(realTimeBookings) {
            com.parkingapp.Booking booking = realTimeBookings.get(bookingId);
            if (booking != null && booking.getSpace() != null) {
                String[] parts = booking.getSpace().split(" - ", 2); // Limit split
                if (parts.length > 1) return parts[1];
            }
        }
        return null;
    }

    // Creates a Booking object (using external class) from Firestore data
    private com.parkingapp.Booking createBookingFromSnapshot(DocumentSnapshot doc) {
        try {
            String lot = doc.getString(LOT_FIELD); String space = doc.getString(SPACE_FIELD);
            if (lot == null || space == null) return null;
            // Assume external Booking class constructor takes these args + duration
            // License plate is NOT part of the external Booking class currently
            return new com.parkingapp.Booking(
                    lot + " - " + space,
                    doc.getString(START_TIME_FIELD), doc.getString(END_TIME_FIELD),
                    doc.getString(VEHICLE_TYPE_FIELD), doc.getString(CAR_BRAND_FIELD),
                    doc.getLong(DURATION_FIELD) != null ? doc.getLong(DURATION_FIELD) : 0L
            );
        } catch (Exception e) {
            handleError("Error creating Booking from snapshot: " + doc.getId(), e);
            return null;
        }
    }

    private boolean isSpaceBookedInMemory(String lot, String space, String newStartTimeStr, String newEndTimeStr, String excludeBookingId) {
        try {
            LocalTime newStart = LocalTime.parse(newStartTimeStr, TIME_FORMATTER);
            LocalTime newEnd = LocalTime.parse(newEndTimeStr, TIME_FORMATTER);
            String targetSpaceId = lot + " - " + space;

            synchronized (realTimeBookings) {
                for (Map.Entry<String, com.parkingapp.Booking> entry : realTimeBookings.entrySet()) {
                    if (excludeBookingId != null && excludeBookingId.equals(entry.getKey())) continue;
                    com.parkingapp.Booking existing = entry.getValue();
                    if (targetSpaceId.equals(existing.getSpace())) {
                        LocalTime existingStart = LocalTime.parse(existing.getStartTime(), TIME_FORMATTER);
                        LocalTime existingEnd = LocalTime.parse(existing.getEndTime(), TIME_FORMATTER);
                        // Overlap check: new period starts before existing ends AND new period ends after existing starts
                        if (newStart.isBefore(existingEnd) && newEnd.isAfter(existingStart)) return true;
                    }
                }
            }
        } catch (DateTimeParseException e) {
            handleError("Invalid time format during overlap check", e); return true; // Fail safe
        }
        return false;
    }

    private boolean validateBookingTimes(String startTimeStr, String endTimeStr) {
        try {
            LocalTime start = LocalTime.parse(startTimeStr, TIME_FORMATTER);
            LocalTime end = LocalTime.parse(endTimeStr, TIME_FORMATTER);
            if (!end.isAfter(start)) { showGuiErrorMessage("End time must be after start time."); return false; }
            if (!isBookingTimeInFuture(startTimeStr)) return false; // Shows own error
            return true;
        } catch (DateTimeParseException e) { showGuiErrorMessage("Invalid time format. Use HH:MM."); return false; }
    }

    private boolean validateLicensePlate(String licensePlate) {
        if (licensePlate == null || !licensePlate.matches(LICENSE_PLATE_REGEX)) {
            showGuiErrorMessage("Invalid license plate format."); return false;
        }
        return true;
    }

    private boolean isBookingTimeInFuture(String startTimeStr) {
        try {
            LocalTime enteredStartTime = LocalTime.parse(startTimeStr, TIME_FORMATTER);
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime bookingStartDateTime = now.toLocalDate().atTime(enteredStartTime);
            // Simplification: Disallow booking for a time already passed today
            if (bookingStartDateTime.isBefore(now) && enteredStartTime.isBefore(now.toLocalTime())) {
                showGuiErrorMessage("Cannot book for a time already passed today.");
                return false;
            }
            LocalDateTime earliestBookingDateTime = now.plusMinutes(MIN_BOOKING_ADVANCE_MINUTES);
            if (bookingStartDateTime.isBefore(earliestBookingDateTime)) {
                showGuiErrorMessage("Booking start time too soon (must be at least " + MIN_BOOKING_ADVANCE_MINUTES + " min away).");
                return false;
            }
            return true;
        } catch (DateTimeParseException e) { return false; } // Should be caught earlier
    }

    private long calculateDuration(String startTimeStr, String endTimeStr) {
        try {
            LocalTime start = LocalTime.parse(startTimeStr, TIME_FORMATTER);
            LocalTime end = LocalTime.parse(endTimeStr, TIME_FORMATTER);
            return java.time.Duration.between(start, end).toMinutes();
        } catch (DateTimeParseException e) { return -1; }
    }

    private UserLogin.UserType parseUserType(String typeStr) {
        if (typeStr == null) return null;
        try { return UserLogin.UserType.valueOf(typeStr.toUpperCase()); }
        catch (IllegalArgumentException e) { return null; }
    }

    private String generateBookingId(String lot, String space) {
        return lot + "-" + space + "-" + UUID.randomUUID().toString().substring(0, 8);
    }

    public String getCurrentEndTimeForBooking(String lot, String space) {
        String bookingId = findBookingIdInMemory(lot, space);
        if (bookingId != null) {
            synchronized(realTimeBookings) {
                com.parkingapp.Booking booking = realTimeBookings.get(bookingId);
                return (booking != null) ? booking.getEndTime() : null;
            }
        }
        return null;
    }

    // --- Error Handling & GUI Interaction ---
    private void handleError(String message, Throwable throwable) {
        System.err.println("LOGIC ERROR: " + message + (throwable != null ? " - Cause: " + throwable.getMessage() : ""));
        if (throwable != null) throwable.printStackTrace();
        showGuiErrorMessage(message); // Show simplified message to user
    }

    private void showGuiErrorMessage(String message) {
        if (bookingPageGUI != null) SwingUtilities.invokeLater(() -> bookingPageGUI.showErrorMessage(message));
        else System.err.println("GUI Error Message (GUI not set): " + message);
    }
    private void showGuiInfoMessage(String message) {
        if (bookingPageGUI != null) SwingUtilities.invokeLater(() -> bookingPageGUI.showInfoMessage(message));
        else System.out.println("GUI Info Message (GUI not set): " + message);
    }

    // Inner classes (Booking, BookingDurationCalculator) removed - assuming they exist externally or calculator is static utility
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