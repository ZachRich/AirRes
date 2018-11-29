package main;

public class ReservationView {

	public void printReservationDetails(String origin, String dest, int seatNumber, String name) {
		
		System.out.println(" [Name: " + name.replaceAll("([^_])([A-Z])", "$1 $2") + ", SeatNumber: " + seatNumber + ", Path: "
				+ origin + " to " + dest + "] ");
		
	}
	
}
