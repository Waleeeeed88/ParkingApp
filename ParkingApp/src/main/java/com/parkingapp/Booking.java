package com.parkingapp;

import java.util.Objects;

//The Booking class with both vehicleType, carBrand, and duration fields.
public class Booking {
    private String space; // Combined "Lot - Space" identifier.
    private String startTime;
    private String endTime;
    private String vehicleType;
    private String carBrand;
    private long duration; // Duration in minutes

    public Booking(String space, String startTime, String endTime, String vehicleType, String carBrand, long duration) {
        this.space = space;
        this.startTime = startTime;
        this.endTime = endTime;
        this.vehicleType = vehicleType;
        this.carBrand = carBrand;
        this.duration = duration;
    }

    public String getSpace() {
        return space;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public long getDuration() {
        return duration;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public void setDuration(long duration) {
        this.duration = duration;
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
                Objects.equals(carBrand, booking.carBrand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(space, startTime, endTime, vehicleType, carBrand, duration);
    }
}
