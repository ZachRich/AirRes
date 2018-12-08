package main;

import java.util.HashMap;

import javax.swing.JButton;

public class FlightView {

	public void printFlightDetails(String ID, int capacity, double price, String origin, String destination) {

		System.out.println("Flight: " + ID + "\n Capacity:  " + capacity + "\n Price: $" + price + "\n Path: " + origin
				+ " to " + destination + "\n");

	}

	public static void addFlight(HashMap<Flight, Reservation[]> hashMap, String ID, int capacity, double price,
			String origin, String destination) {

		Flight newFlight = new Flight();
		newFlight.setID(ID);
		newFlight.setCapacity(capacity);
		newFlight.setPrice(price);
		newFlight.setOrigin(origin);
		newFlight.setDestination(destination);

		FlightView view = new FlightView();

		FlightController controller = new FlightController(newFlight, view);

		Reservation[] res = new Reservation[newFlight.getCapacity()];
		
		hashMap.put(newFlight, res);

		System.out.println("Flight added: \n");
		controller.updateView(); // print out view

	}

	JButton addFlight = new JButton("Add Flight");

}
