package main;

public class OutputTemplate {

	private final String airline;
	 
	private final int numberOfSeats;
	
	private final double pricePerSeat;
	
	private final String Origin;
	
	private final String Destination;
	
	public OutputTemplate(final String airline, final int numberOfSeats, final double pricePerSeat, final String Origin, final String Destination) {
		
		this.airline = airline;
		this.numberOfSeats = numberOfSeats;
		this.pricePerSeat = pricePerSeat;
		this.Origin = Origin;
		this.Destination = Destination;

	}
	
} 