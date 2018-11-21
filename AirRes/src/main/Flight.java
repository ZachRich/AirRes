package main;

public class Flight {

	//Input File #1
	
	private final int seats;
	private final String ID;
	private final Double price;
	private final String origin;
	private final String destination;
	
	public Flight(final String ID, final int seats, final Double price, final String origin, final String destination) {
		this.seats = seats;
		this.ID = ID;
		this.price = price;
		this.origin = origin;
		this.destination = destination;	
	}
	
	
	public boolean hasSeats() {
		
		/*
		 * returns true if flight has seats
		 * 
		 * returns false if flight is full
		 * 
		 */
		
		return false;
		
	}
	
}
