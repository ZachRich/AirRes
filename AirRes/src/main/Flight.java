package main;

public class Flight {

	//Input File #1
	
	private final int capacity;
	private final String ID;
	private final Double price;
	private final String origin;
	private final String destination;
	
	public Flight(final String ID, final int capacity, final Double price, final String origin, final String destination) {
		this.capacity = capacity;
		this.ID = ID;
		this.price = price;
		this.origin = origin;
		this.destination = destination;	
	}
	
	public int getCapacity() {
		return capacity;
	}

	public String getID() {
		return ID;
	}	

	public Double getPrice() {
		return price;
	}

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

	public String toString() {
		
		return "Flight: " + ID + "\n Capacity:  " + capacity + "\n Price: $"
		+ price + "\n Path: " + origin + " to " + destination + "\n";
		
	}
	
}
