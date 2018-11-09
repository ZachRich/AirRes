package main;

public class Reservation {

	private final Passenger passenger;
	
	private final int seatNumber;
	
	private final String origin;
	
	private final String dest;
	
	public Reservation(final Passenger passenger, final int seatNumber, final String origin, final String dest) {
		this.passenger = passenger;
		this.seatNumber = seatNumber;
		this.origin = origin;
		this.dest = dest;
	}
	
	public Passenger getPassenger(Passenger passenger) {
		return passenger;
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
