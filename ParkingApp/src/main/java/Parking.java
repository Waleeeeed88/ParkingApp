public class Parking {
    private String parkingID;
    private boolean isEnabled;
    private boolean isOccupied;
    private boolean isUnderMaintenance;

    public Parking(String parkingID) {
        this.parkingID = parkingID;
        this.isEnabled = true;
        this.isOccupied = false;
        this.isUnderMaintenance = false;
    }

    public String getParkingID() {
        return parkingID;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void enableParking() {
        this.isEnabled = true;
    }

    public void disableParking() {
        this.isEnabled = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void occupyParking() {
        this.isOccupied = true;
    }

    public void vacateParking() {
        this.isOccupied = false;
    }

    public boolean isUnderMaintenance() {
        return isUnderMaintenance;
    }

    public void setUnderMaintenance(boolean isUnderMaintenance) {
        this.isUnderMaintenance = isUnderMaintenance;
    }
}
