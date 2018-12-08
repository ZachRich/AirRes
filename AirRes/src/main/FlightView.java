package main;

import java.util.HashMap;

import javax.swing.JButton;

public class FlightView {

	public void printFlightDetails(String ID, int capacity, double price, String origin, String destination) {

		System.out.println("Flight: " + ID + "\n Capacity:  " + capacity + "\n Price: $" + price + "\n Path: " + origin
				+ " to " + destination + "\n");

	}
}
