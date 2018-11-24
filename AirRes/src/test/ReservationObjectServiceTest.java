package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Reservation;

public class ReservationObjectServiceTest {
	
	@Test
	public void ReservationToStringFormattingTest() {
		Reservation res = new Reservation("BOS", "NYC", 1, "JohnSmith");
		String expected =  " [Name: " + "John Smith" + ", SeatNumber: " + 1 + ", Path: " + "BOS" + " to " + "NYC" + "] ";
		assertEquals(expected, res.toString());
		
	}
}
