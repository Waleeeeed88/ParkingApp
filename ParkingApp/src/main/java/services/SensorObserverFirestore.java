package services;

import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.parkingapp.PaymentRates;
import com.parkingapp.UserLogin;
import com.parkingapp.parkingObjects.ParkingSpace;
import com.google.cloud.firestore.Firestore;



public class SensorObserverFirestore {
	
	private static Firestore db = FirebaseInitialization.getInstance();
	
	private static final String BOOKING_COLLECTION = "bookings";
    private static final String STATUS_FIELD = "status";
    private static final String NO_SHOW_STATUS = "No Show";
    private static final String USER_EMAIL_FIELD = "userEmail";
    private static final String DURATION_FIELD = "duration";
    private static final String USER_TYPE_FIELD = "userType";
	public static void markBookingAsNoShow(String carPlate, ParkingSpace parkingSpace) {
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
