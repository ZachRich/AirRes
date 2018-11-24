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
	
	public String getName(String name) {
		return name;
	}
	
	public int getSeatNumber(int seatNumber) {
		return seatNumber;
	}
	
	public String getOrigin(String origin) {
		return origin;
	}
	
	public String getDest(String dest) {
		return dest;
	}
	
}
