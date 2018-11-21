package main;

/*
 * Enum represents how File One is setup
 * 
 */

public enum FlightTemplate {

	ID(0),
	NUMBERSEATS(1),
	PRICEPERSEAT(2),
	ORIGIN(3),
	DESTINATION(4);
	
	private final int index;
	//Used to keep track of column in CSV file
	
	private FlightTemplate(final int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return index;
	}
	
	
}
