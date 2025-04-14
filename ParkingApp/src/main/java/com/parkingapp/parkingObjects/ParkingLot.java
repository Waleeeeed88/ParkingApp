package com.parkingapp.parkingObjects;

import java.util.ArrayList;
import java.util.List;

//Composite Class 
public class ParkingLot implements ParkingComponent {
 private String id;
 private List<ParkingComponent> parkingSpaces;
 private boolean enabled;

    public ParkingLot(String id, boolean enabled) {
        this.id = id;
        this.enabled = enabled; // Use the provided enabled state
        this.parkingSpaces = new ArrayList<>();
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
    public ParkingLot(String id) {
        this(id, true);
    }


}
