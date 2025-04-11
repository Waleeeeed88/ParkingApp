package testParkingApp;

import static org.junit.jupiter.api.Assertions.*;

import com.parkingapp.parkingObjects.ParkingLot;
import com.parkingapp.parkingObjects.ParkingSpace;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.parkingapp.parkingObjects.ParkingServices;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ParkingServicesTest {

    // We'll capture System.out output for testing addParkingLot() behavior.
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @BeforeEach
    public void setUpStreams() {
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    // --------------------------------------------------------------------
    // Test addParkingLot() method (local behavior only)
    // --------------------------------------------------------------------

    @Test
    public void testAddParkingLotOutputsCorrectInformation() {
        ParkingServices service = new ParkingServices();
        String expectedLotId = "TestLot";

        service.addParkingLot(expectedLotId);

        String output = outContent.toString();
        // Expect that output contains the parking lot ID.
        assertTrue(output.contains(expectedLotId),
                "The output should contain the parking lot ID: " + expectedLotId);
    }

    // --------------------------------------------------------------------
    // Tests for enable/disable ParkingLot
    // --------------------------------------------------------------------

    @Test
    public void testEnableDisableLot() {
        // Create a ParkingLot with id "Lot1"
        ParkingLot lot = new ParkingLot("Lot1");

        // Do not assume its initial state; instead, force a state change.
        // Call enableParkingLot() and verify that lot.isEnabled() returns true.
        ParkingServices service = new ParkingServices();
        service.enableParkingLot(lot);
        assertTrue(lot.isEnabled(), "ParkingLot should be enabled after calling enableParkingLot");

        // Then, call disableParkingLot() and verify that lot.isEnabled() returns false.
        service.disableParkingLot(lot);
        assertFalse(lot.isEnabled(), "ParkingLot should be disabled after calling disableParkingLot");
    }

    // --------------------------------------------------------------------
    // Tests for enable/disable ParkingSpace
    // --------------------------------------------------------------------

    @Test
    public void testEnableDisableParkingSpace() {
        // Create a ParkingSpace with id "Space1" and an associated lot id "Lot1".
        ParkingSpace space = new ParkingSpace("Space1", "Lot1");

        ParkingServices service = new ParkingServices();
        // Enable the parking space.
        service.enableParkingSpace(space);
        assertTrue(space.isEnabled(), "ParkingSpace should be enabled after calling enableParkingSpace");

        // Disable the parking space.
        service.disableParkingSpace(space);
        assertFalse(space.isEnabled(), "ParkingSpace should be disabled after calling disableParkingSpace");
    }
}
