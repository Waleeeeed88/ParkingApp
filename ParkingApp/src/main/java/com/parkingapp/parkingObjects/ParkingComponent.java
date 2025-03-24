package com.parkingapp.parkingObjects;
// Component Interface
public interface ParkingComponent {
    String getId();
    void enable();
    void disable();
    boolean isEnabled();
}
// Composite Class (ParkingLot)
// Leaf class (ParkingSpace)
