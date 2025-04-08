package testParkingApp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.parkingapp.Booking;

class BookingTest {

    @Test
    @DisplayName("1) Constructor sets fields correctly")
    void testConstructorSetsFields() {
        Booking booking = new Booking("LotA - Space1", "09:00", "10:00", 
                                      "SUV", "Toyota", 60);
        assertEquals("LotA - Space1", booking.getSpace());
        assertEquals("09:00", booking.getStartTime());
        assertEquals("10:00", booking.getEndTime());
        assertEquals("SUV", booking.getVehicleType());
        assertEquals("Toyota", booking.getCarBrand());
        assertEquals(60, booking.getDuration());
    }

    @Test
    @DisplayName("2) setSpace() and getSpace()")
    void testSetGetSpace() {
        Booking booking = new Booking("", "", "", "", "", 0);
        booking.setSpace("LotB - Space9");
        assertEquals("LotB - Space9", booking.getSpace());
    }

    @Test
    @DisplayName("3) setStartTime() and getStartTime()")
    void testSetGetStartTime() {
        Booking booking = new Booking("", "", "", "", "", 0);
        booking.setStartTime("11:15");
        assertEquals("11:15", booking.getStartTime());
    }

    @Test
    @DisplayName("4) setEndTime() and getEndTime()")
    void testSetGetEndTime() {
        Booking booking = new Booking("", "", "", "", "", 0);
        booking.setEndTime("12:45");
        assertEquals("12:45", booking.getEndTime());
    }

    @Test
    @DisplayName("5) setVehicleType() and getVehicleType()")
    void testSetGetVehicleType() {
        Booking booking = new Booking("", "", "", "", "", 0);
        booking.setVehicleType("Sedan");
        assertEquals("Sedan", booking.getVehicleType());
    }

    @Test
    @DisplayName("6) setCarBrand() and getCarBrand()")
    void testSetGetCarBrand() {
        Booking booking = new Booking("", "", "", "", "", 0);
        booking.setCarBrand("Honda");
        assertEquals("Honda", booking.getCarBrand());
    }

    @Test
    @DisplayName("7) setDuration() and getDuration()")
    void testSetGetDuration() {
        Booking booking = new Booking("", "", "", "", "", 0);
        booking.setDuration(90);
        assertEquals(90, booking.getDuration());
    }

    @Test
    @DisplayName("8) toString() contains essential info")
    void testToString() {
        Booking booking = new Booking("LotC - 22", "10:00", "12:00", "Van", "Ford", 120);
        String text = booking.toString();
        assertTrue(text.contains("LotC - 22"));
        assertTrue(text.contains("10:00"));
        assertTrue(text.contains("12:00"));
        assertTrue(text.contains("Van"));
        assertTrue(text.contains("Ford"));
        assertTrue(text.contains("120"));
    }

    @Test
    @DisplayName("9) equals() returns true for same fields")
    void testEquals_Same() {
        Booking b1 = new Booking("LotX - 7", "08:00", "09:00", "SUV", "BMW", 60);
        Booking b2 = new Booking("LotX - 7", "08:00", "09:00", "SUV", "BMW", 60);
        assertTrue(b1.equals(b2));
        assertEquals(b1.hashCode(), b2.hashCode());
    }

    @Test
    @DisplayName("10) equals() returns false for different durations")
    void testEquals_DifferentDuration() {
        Booking b1 = new Booking("LotX - 7", "08:00", "09:00", "SUV", "BMW", 60);
        Booking b2 = new Booking("LotX - 7", "08:00", "09:00", "SUV", "BMW", 120);
        assertFalse(b1.equals(b2));
    }

}
