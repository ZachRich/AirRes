package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import main.Flight;


public class FlightObjectServiceTest {


	@Test
	public void flightToStringTest() {
		Flight flight = new Flight("A110", 20, 500.0, "BOS", "DEN");
		String expected = "Flight: " + "A110" + "\n Capacity:  " + 20 + "\n Price: $"
				+ 500.0 + "\n Path: " + "BOS" + " to " + "DEN" + "\n";
		assertEquals(expected, flight.toString());
		
		
	}
	
	

}
