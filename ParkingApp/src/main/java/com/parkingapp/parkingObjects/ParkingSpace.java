package com.parkingapp.parkingObjects;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;

import com.parkingapp.parkingObjects.ParkingComponent;
//Leaf Class 
public class ParkingSpace implements ParkingComponent {
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