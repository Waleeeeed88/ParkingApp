import java.util.HashMap;
import java.util.Map;

public class ParkingServices {

    private Map<String, Parking> parkingSpaces;

    public ParkingServices() {
        parkingSpaces = new HashMap<>();
    }

    public void addParking(String id) {
        if (!parkingSpaces.containsKey(id)) {
            parkingSpaces.put(id, new Parking(id));
            System.out.println("Parking lot added: " + id);
        }
    }

    public void enableParking(String id) {
        Parking parking = parkingSpaces.get(id);
        if (parking != null) {
            parking.enableParking();
            System.out.println("Parking lot enabled: " + id);
        }
    }

    public void disableParking(String id) {
        Parking parking = parkingSpaces.get(id);
        if (parking != null) {
            parking.disableParking();
            System.out.println("Parking lot disabled: " + id);
        }
    }

    public Parking getParking(String id) {
        return parkingSpaces.get(id);
    }
}
