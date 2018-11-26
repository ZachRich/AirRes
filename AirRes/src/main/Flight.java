package main;

public class Flight {

	//Input File #1
	
	private int capacity;
	private String ID;
	private  double price;
	private String origin;
	private  String destination;
	
	public Flight( String ID,  int capacity,  double price,  String origin,  String destination) {
		this.capacity = capacity;
		this.ID = ID;
		this.price = price;
		this.origin = origin;
		this.destination = destination;	
	}
	
	public Flight() {
		
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public void setDestination(String destination) {
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
