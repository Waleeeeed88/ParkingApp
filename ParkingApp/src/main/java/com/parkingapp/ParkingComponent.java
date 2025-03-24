package com.parkingapp;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

import services.FirebaseInitialization;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

// Component Interface
interface ParkingComponent {
    String getId();
    void enable();
    void disable();
    boolean isEnabled();
}

// Composite Class (ParkingLot)
class ParkingLot implements ParkingComponent {
    private String id;
    private List<ParkingComponent> parkingSpaces;
    private boolean enabled;

    public ParkingLot(String id) {
        this.id = id;
        this.parkingSpaces = new ArrayList<>();
        this.enabled = true;
        initializeParkingSpaces();
    }

    private void initializeParkingSpaces() {
        for (int i = 1; i <= 100; i++) {
            String paddedNum = String.format("%03d", i);
            parkingSpaces.add(new ParkingSpace(this.id + paddedNum, this.id));
        }
    }

    public List<ParkingComponent> getParkingSpaces() {
        return parkingSpaces;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void enable() {
        this.enabled = true;
        for (ParkingComponent space : parkingSpaces) {
            space.enable();
        }
    }

    @Override
    public void disable() {
        this.enabled = false;
        for (ParkingComponent space : parkingSpaces) {
            space.disable();
        }
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}

// Leaf Class (ParkingSpace)
class ParkingSpace implements ParkingComponent {
    private String id;
    private String parentId;
    private boolean enabled;
    private boolean occupied;
    private Sensor sensor;

    public ParkingSpace(String id, String parentId) {
        this.parentId = parentId;
        this.id = id;
        this.enabled = true;
        this.occupied = false;
        this.sensor = new Sensor(this);
        this.sensor.addObserver(new DepositHandler());
    }

    @Override
    public String getId() {
        return id;
    }

    public String getParentId() {
        return parentId;
    }

    @Override
    public void enable() {
        this.enabled = true;
    }

    @Override
    public void disable() {
        this.enabled = false;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void carEnters(String carPlate, LocalDateTime bookingStartTime) {
        if (!enabled) {
            JOptionPane.showMessageDialog(null, "Parking Space " + id + " is not available.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!occupied) {
            occupied = true;
            sensor.detectCar(carPlate, bookingStartTime);
        } else {
            JOptionPane.showMessageDialog(null, "Parking Space " + id + " is already occupied.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void carLeaves() {
        if (occupied) {
            occupied = false;
            JOptionPane.showMessageDialog(null, "Parking Space " + id + " is now available.", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Parking Space " + id + " was already vacant.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

// Observer Pattern
interface SensorObserver {
    void onCarDetected(String carPlate, ParkingSpace parkingSpace, boolean hasValidBooking, LocalDateTime bookingStartTime);
}

class Sensor {
    private ParkingSpace parkingSpace;
    private static final Random random = new Random();
    private List<SensorObserver> observers = new ArrayList<>();

    public Sensor(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public void addObserver(SensorObserver observer) {
        observers.add(observer);
    }

    public void detectCar(String carPlate, LocalDateTime bookingStartTime) {
        boolean hasValidBooking = random.nextBoolean();
        notifyObservers(carPlate, hasValidBooking, bookingStartTime);
    }

    private void notifyObservers(String carPlate, boolean hasValidBooking, LocalDateTime bookingStartTime) {
        for (SensorObserver observer : observers) {
            observer.onCarDetected(carPlate, parkingSpace, hasValidBooking, bookingStartTime);
        }
    }
}

class DepositHandler implements SensorObserver {
    private static final String BOOKING_COLLECTION = "bookings";
    private static final String STATUS_FIELD = "status";
    private static final String NO_SHOW_STATUS = "No Show";
    private static final String USER_EMAIL_FIELD = "userEmail";
    private static final String DURATION_FIELD = "duration";
    private static final String USER_TYPE_FIELD = "userType";

    private Firestore db;

    public DepositHandler() {
    	this.db = FirebaseInitialization.getInstance();	//instance held in database
    }

    @Override
    public void onCarDetected(String carPlate, ParkingSpace parkingSpace, boolean hasValidBooking, LocalDateTime bookingStartTime) {
        LocalDateTime deadline = bookingStartTime.plusHours(1);
        if (hasValidBooking && LocalDateTime.now().isBefore(deadline)) {
            processDepositReturn(carPlate);
        } else {
            markBookingAsNoShow(carPlate, parkingSpace);
        }
    }

    private void processDepositReturn(String carPlate) {
        JOptionPane.showMessageDialog(null, "Deposit for car " + carPlate + " has been refunded.", "Deposit Refunded", JOptionPane.INFORMATION_MESSAGE);
    }

    private void markBookingAsNoShow(String carPlate, ParkingSpace parkingSpace) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            private String userEmail;
            private String userType;
            private double depositAmount;

            @Override
            protected Void doInBackground() throws Exception {
                QuerySnapshot snapshot = db.collection(BOOKING_COLLECTION)
                        .whereEqualTo("licensePlate", carPlate)
                        .whereEqualTo(STATUS_FIELD, "booked")
                        .get()
                        .get();

                if (snapshot.isEmpty()) {
                    return null; // No active booking found
                }

                DocumentSnapshot bookingDoc = snapshot.getDocuments().get(0);
                String bookingId = bookingDoc.getId();
                userEmail = bookingDoc.getString(USER_EMAIL_FIELD);
                userType = bookingDoc.getString(USER_TYPE_FIELD);

                // Calculate deposit fee based on user type (equivalent to 1 hour of pay rate)
                depositAmount = PaymentRates.calculateCost(UserLogin.UserType.valueOf(userType.toUpperCase()), 60);

                // Update booking status to "No Show"
                db.collection(BOOKING_COLLECTION).document(bookingId)
                        .update(STATUS_FIELD, NO_SHOW_STATUS)
                        .get();

                return null;
            }

            @Override
            protected void done() {
                try {
                    get(); // Ensure no exceptions occurred
                    JOptionPane.showMessageDialog(null,
                            "Booking marked as 'No Show'. Deposit of $" + String.format("%.2f", depositAmount) +
                                    " has been charged for " + userEmail,
                            "Deposit Charged", JOptionPane.WARNING_MESSAGE);
                } catch (InterruptedException | ExecutionException e) {
                    JOptionPane.showMessageDialog(null, "Error updating No Show status: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        worker.execute();
    }
}