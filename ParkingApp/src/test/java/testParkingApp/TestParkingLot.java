package testParkingApp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.parkingapp.parkingObjects.ParkingLot;

class TestParkingLot {

	@Test
	void testParkingLotCreation() {
		ParkingLot parkingLot = new ParkingLot("ParkingLot");
		assertNotNull(parkingLot);
		assertEquals("ParkingLot", parkingLot.getId());
		assertTrue(parkingLot.isEnabled());
		assertEquals(100, parkingLot.getParkingSpaces().size());
	}
	
	@Test
	void testParkingLotEnableDisable() {
		ParkingLot parkingLot = new ParkingLot("ParkingLot");
		parkingLot.disable();
		assertFalse(parkingLot.isEnabled());
		
		parkingLot.enable();
		assertTrue(parkingLot.isEnabled());
	}
}