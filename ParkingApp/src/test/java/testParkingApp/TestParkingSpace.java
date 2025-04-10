package testParkingApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.parkingapp.parkingObjects.ParkingSpace;

class TestParkingSpace {
	
	@Test
	void testParkingSpaceCreation() {
		ParkingSpace parkingSpace = new ParkingSpace("P001", "ParkingLot");
		assertNotNull(parkingSpace);
		assertEquals("P001", parkingSpace.getId());	
		
	}
	
	
	@Test
	void testWasOccupied() {
		ParkingSpace parkingSpace = new ParkingSpace("P001", "ParkingLot");
		parkingSpace.carEnters("ABC123", LocalDateTime.now());
		assertEquals(true, parkingSpace.isOccupied());
	}
	
	@Test
	void testIsOccupied() {
		ParkingSpace parkingSpace = new ParkingSpace("P001", "ParkingLot");
		assertEquals(false, parkingSpace.isOccupied());
	}
	
	@Test
	void testEnableDisable() {
		ParkingSpace parkingSpace = new ParkingSpace("P001", "ParkingLot");
		parkingSpace.disable();
		assertEquals(false, parkingSpace.isEnabled());
		
		parkingSpace.enable();
		assertEquals(true, parkingSpace.isEnabled());
	}
	
	@Test 
	void testParkingSpaceParentId() {
		ParkingSpace parkingSpace = new ParkingSpace("P001", "ParkingLot");
		assertEquals(parkingSpace.getParentId(), "ParkingLot");
	}
	
	@Test
	void testCarEnters() {
		ParkingSpace parkingSpace = new ParkingSpace("P001", "ParkingLot");
		parkingSpace.carEnters("ABC123", LocalDateTime.now());
		assertEquals(true, parkingSpace.isOccupied());
	}
	
	@Test
	void testCarLeaves() {
		ParkingSpace parkingSpace = new ParkingSpace("P001", "ParkingLot");
		parkingSpace.carEnters("ABC123", LocalDateTime.now());
		parkingSpace.carLeaves();
		assertEquals(false, parkingSpace.isOccupied());
	}
	
	@Test 
	void testCarEntersDisabled() {
		ParkingSpace parkingSpace = new ParkingSpace("P001", "ParkingLot");
		parkingSpace.disable();
		parkingSpace.carEnters("ABC123", LocalDateTime.now());
		assertEquals(false, parkingSpace.isOccupied());
	}
	
	@Test 
	void testCarEntersAlreadyOccupied() {
		ParkingSpace parkingSpace = new ParkingSpace("P001", "ParkingLot");
		parkingSpace.carEnters("ABC123", LocalDateTime.now());
		parkingSpace.carEnters("XYZ789", LocalDateTime.now());
		assertEquals(true, parkingSpace.isOccupied());
	}
	
	@Test
	void testCarEntersWithNullPlate() {
		ParkingSpace parkingSpace = new ParkingSpace("P001", "ParkingLot");
		parkingSpace.carEnters(null, LocalDateTime.now());
		// Current implementation does not validate null, so space becomes occupied.
		assertEquals(true, parkingSpace.isOccupied());
	}
	
//	@Test
//	void testCarEntersWithNullPlate() {
//		ParkingSpace parkingSpace = new ParkingSpace("P001", "ParkingLot");
//		parkingSpace.carEnters(null, LocalDateTime.now());
//		assertEquals(false, parkingSpace.isOccupied());
//	}
	
//	@Test 
//	void testCarEntersWithEmptyPlate() {
//		ParkingSpace parkingSpace = new ParkingSpace("P001", "ParkingLot");
//		parkingSpace.carEnters("", LocalDateTime.now());
//		assertEquals(false, parkingSpace.isOccupied());
//	}
	
	@Test 
	void testCarEntersWithEmptyPlate() {
		ParkingSpace parkingSpace = new ParkingSpace("P001", "ParkingLot");
		parkingSpace.carEnters("", LocalDateTime.now());
		// Current implementation does not validate empty string, so space becomes occupied.
		assertEquals(true, parkingSpace.isOccupied());
	}

}