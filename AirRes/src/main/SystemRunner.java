package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class SystemRunner {

	
	public static void printHashMap(HashMap<Flight, Reservation[]> map) {
		
		StringBuilder sb = new StringBuilder();
		
		for (Entry<Flight, Reservation[]> entry : map.entrySet()) {
			  Flight key = entry.getKey();
			  Reservation[] value = entry.getValue();
			  
			  
			  
			  String output = "-------------------------------------------------------------------------------------------------------------" +"\n" + key +  "[";
			  sb.append(output);
			  int format = 0;
			  
			  for(Reservation r : value) {
				  
				  if(format % 3 == 0) {  //new line every 3 Seats
					  sb.append("\n");
				  }
				  
				  sb.append(r + ", ");
				  
				  format++;
			  }
			  sb.append("]" + "\n");
			 
			}
		
		System.out.println(sb);
		
	}
	
	
	
	public static void populateHashMap(HashMap<Flight, Reservation[]> hashMap) {
		
		ArrayList<Flight> flights = createFlightObjects();
		ArrayList<Reservation> reservations = createReservationObjects();
		
		for(int j = 0; j < flights.size(); j++) {
		
		Reservation[] tempArray = new Reservation[flights.get(j).getCapacity()];
		
		for(int i = 0; i < reservations.size(); i++) {  //
			if(reservations.get(i) != null && reservations.get(i).getOrigin().equals(flights.get(j).getOrigin()) && reservations.get(i).getDest().equals(flights.get(j).getDestination())) {
				tempArray[reservations.get(i).getSeatNumber() - 1] = reservations.get(i); 
				/*
				 * Compares Origin + Destination on reservation and flight objects,
				 * If its a match, It will add reservation to the Flight
				 */
			}
		}
		
		hashMap.put(flights.get(j), tempArray);
		
		}
	}
	
	public static ArrayList<Flight> createFlightObjects() {
	
		ArrayList<String> flightStrings = fileInput(Main.flightFile);
		ArrayList<Flight> flightObjects = new ArrayList<Flight>();
		String flight;
		
		
		for(int i = 0; i < flightStrings.size(); i++) {
			
			flight = (String) flightStrings.get(i); //Grab Flight String
			
			String[] splitter = flight.split(","); //Split String into Array [ID] [Capacity] [Price] [Origin] [Destination]
			
			Flight newFlight = new Flight();  //Initialize OBJ
			 
			newFlight.setID(splitter[0]);   //ID
			newFlight.setCapacity(Integer.parseInt(splitter[1])); //Capacity
			newFlight.setPrice(Double.parseDouble(splitter[2])); //Price
			newFlight.setOrigin(splitter[3]);  //Origin
			newFlight.setDestination(splitter[4]); //Destination
			
			flightObjects.add(newFlight); //Add new OBJ to flightObjects list
		}
		
		return flightObjects;
		
	}
	
	public static ArrayList<Reservation> createReservationObjects() {
		
		ArrayList<String> reservationStrings = fileInput(Main.passengerFile);
		ArrayList<Reservation> reservationObjects = new ArrayList<Reservation>();
		String reservation;
		
		
		for(int i = 0; i < reservationStrings.size(); i++) {
			
			reservation = (String) reservationStrings.get(i); //Grab Flight String
			
			String[] splitter = reservation.split(","); //Split String into Array [ID] [Capacity] [Price] [Origin] [Destination]
			
			Reservation newReservation = new Reservation();  //Initialize OBJ
			 
			newReservation.setOrigin(splitter[0]); //Origin
			newReservation.setDest(splitter[1]);  //Destination
			newReservation.setSeatNumber(Integer.parseInt(splitter[2])); //seatNumber
			newReservation.setName(splitter[3]); //name
			
			reservationObjects.add(newReservation);  
		}
		
		
		return reservationObjects;
		
	}
	
	public static ArrayList<String> fileInput(File file){
		
		BufferedReader input = null;
		
		try {
					input = new BufferedReader(new FileReader(file)); //Buffered reader that reads in File
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found!");
		}
		
		ArrayList<String> list = new ArrayList<String>(); 
		
		String line;
		
		try {
			while((line = input.readLine()) != null) { //adds each line of file to a list
				list.add(line);
			}
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		
		return list;
	}


}
