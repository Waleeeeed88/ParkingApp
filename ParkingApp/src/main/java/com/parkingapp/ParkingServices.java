import java.util.HashMap;
import java.util.Map;

public class ParkingServices {

    private Map<String, Parking> parkingSpaces;

    public ParkingServices() {
        parkingSpaces = new HashMap<>();
    }

    // Corrected addParking method to accept ParkingSpace
    public void addParking(ParkingSpace parking) {  // Changed parameter type
        if (!parkingSpaces.containsKey(parking.getId())) { // Use getId()
            parkingSpaces.put(parking.getId(), parking); // Store the ParkingSpace object
            System.out.println("Parking lot added: " + parking.getId());
        }
    }

    public void enableParking(String id) {
        Parking parking = parkingSpaces.get(id);
        if (parking != null) {
            parking.setEnabled(true); // Use the interface method
            System.out.println("Parking lot enabled: " + id);
        }
    }

    public void disableParking(String id) {
        Parking parking = parkingSpaces.get(id);
        if (parking != null) {
            parking.setEnabled(false); // Use the interface method
            System.out.println("Parking lot disabled: " + id);
        }
    }
    public void setUnderMaintenance(String id, boolean isUnderMaintenance) {
        Parking parking = parkingSpaces.get(id);
        if (parking != null) {
            parking.setUnderMaintenance(isUnderMaintenance);
        }
    }

    public Parking getParking(String id) {
        return parkingSpaces.get(id);
    }

    public Map<String, Parking> getParkingSpaces() {
        return parkingSpaces; // Return the map of all parking spaces
    }
}
