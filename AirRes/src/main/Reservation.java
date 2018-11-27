package main;

public class Reservation {

	//Input File #2
	
	private final String name;
	
	private final int seatNumber;
	
	private final String origin;
	
	private final String dest;
	
	public Reservation(final String origin, final String dest, final int seatNumber, final String name) {
		this.name = name;
		this.seatNumber = seatNumber;
		this.origin = origin;
		this.dest = dest;
	}
	
	public String getName() {
		return name;
	}
	
	public int getSeatNumber() {
		return seatNumber;
	}
	
	public String getOrigin() {
		return origin;
	}
	
	public String getDest() {
		return dest;
	}
	
	public String toString() {
		
		return " [Name: " + name.replaceAll("([^_])([A-Z])", "$1 $2") + ", SeatNumber: " + seatNumber + ", Path: " + origin + " to " + dest + "] ";
		
	}
	
	
	
}
