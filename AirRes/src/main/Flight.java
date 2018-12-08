package main;

import java.util.HashMap;
import java.util.regex.Pattern;

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
	
	public Flight() { //noargs Constructor
		
	}
	

	/*
	 * setCapacity checks if capacity is greater then zero
	 * if capacity is 0 or less, it prompts user to set a new capacity
	 */
	public void setCapacity(int capacity) {
		
		if(capacity > 0) {
			this.capacity = capacity;
		} else {
			setCapacity(Main.entryBox("Please enter a valid Capacity; [Greater then 10]", "Invalid Capacity", 1)); //Last Arg "0" uses overloaded Int method
		}
		
	}

	public int getCapacity() {return capacity;}

	/*
	 * setID checks if ID is valid, if not valid, prompts user for a new value
	 * Ex. [A100, B345, C643] All valid ID's
	 * Ex. [1SC3, HH55, 2222] Invalid ID's
	 * 
	 */
	
	public void setID(String ID) {
		
		if(Pattern.matches("[A-Z]+[0-9]+[0-9]+[0-9]", ID) && ID != null) {
		this.ID = ID;
		} else {
			setID(Main.entryBox("Please Enter Valid ID", "Invalid ID"));
		}
	}
	
	public String getID() {return ID;}

	/*
	 * setPrice checks if price is greater then zero,
	 * if price is zero or less, it prompts user for a new value
	 */
	
	public void setPrice(double price) {
		
		if(price > 0) {
			this.price = price;
		} else {
			setPrice(Main.entryBox("Please set Valid Price", "Invalid Price", 0.0));
		}
		
	}

	public Double getPrice() {return price;}

	/*
	 * setOrigin makes sure the Origin code is valid, if not it prompts user for new input
	 * Ex. [BOS NYC, DEN] are Valid Codes
	 * Ex. [bos,N7Y,12G] are NOT Valid Codes
	 */
	
	public void setOrigin(String origin) {
		
		if(Pattern.matches("([A-Z]+[A-Z]+[A-Z])", origin)) {
			this.origin = origin;
		} else {
			setOrigin(Main.entryBox("Invalid Origin Code; Please Enter Valid code, EX. [BOS]", "Invalid Origin"));	
		}
		
	}

	public String getOrigin() {return origin;} 

	/*
	 * setDestination makes sure the Destination code is valid, if not it prompts user for new input
	 * Ex. [BOS NYC, DEN] are Valid Codes
	 * Ex. [bos,N7Y,12G] are NOT Valid Codes
	 */
	
	public void setDestination(String destination) {
		if(Pattern.matches("([A-Z]+[A-Z]+[A-Z])", destination)) {
			this.destination = destination;
		} else {
			setDestination(Main.entryBox("Invalid Destination Code; Please Enter Valid code, EX. [NYC]", "Invalid Destination"));
		}
	}
	
	public String getDestination() {return destination;}


	public String toString() {
		
		return "Flight: " + ID + "\n Capacity:  " + capacity + "\n Price: $"
		+ price + "\n Path: " + origin + " to " + destination + "\n";
		
	}
	
}
