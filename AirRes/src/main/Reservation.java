package main;

public class Reservation {

	// Input File #2

	private String name;

	private int seatNumber;

	private String origin;

	private String dest;

	public Reservation(String origin, String dest, int seatNumber, String name) {
		this.name = name;
		this.seatNumber = seatNumber;
		this.origin = origin;
		this.dest = dest;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public int getSeatNumber() {
		return seatNumber;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getOrigin() {
		return origin;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public String getDest() {
		return dest;
	}

	public String toString() {

		return " [Name: " + name.replaceAll("([^_])([A-Z])", "$1 $2") + ", SeatNumber: " + seatNumber + ", Path: "
				+ origin + " to " + dest + "] ";

	}

}
