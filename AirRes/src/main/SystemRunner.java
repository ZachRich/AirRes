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
				  
				  if(format % 3 == 0) {
					  sb.append("\n");
				  }
				  
				  sb.append(r + ", ");
				  
				  format++;
			  }
			  sb.append("]" + "\n");
			 
			}
		
		System.out.println(sb);
		
	}

	/*
	
	public static void initalizeFlights(File flights, File passengers, HashMap<Flight, Reservation[]> map) throws NumberFormatException, IOException {

		ArrayList<Flight> temp = new ArrayList<Flight>();
		ArrayList<Reservation> passengerList = initalizePassengers(passengers);

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(flights));
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found");
		}

		String line;

		try {
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");

				Flight newFlight = new Flight();
				
				newFlight.setID(values[0]);                                                  //Object Creation
				newFlight.setCapacity(Integer.parseInt(values[1]));
				newFlight.setPrice(Double.parseDouble(values[2]));
				newFlight.setOrigin(values[3]);
				newFlight.setDestination(values[4]);
				
				Reservation[] tempArray = new Reservation[newFlight.getCapacity()];
				
				
				for(int i = 0; i < passengerList.size(); i++) {
					if(passengerList.get(i) != null && passengerList.get(i).getOrigin().equals(newFlight.getOrigin()) && passengerList.get(i).getDest().equals(newFlight.getDestination())) {
						tempArray[passengerList.get(i).getSeatNumber() - 1] = passengerList.get(i); 
						
					}
				}
				
				map.put(newFlight, tempArray);
				
			}

			br.close();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			System.err.println("IOException or NumberFormatException");
			e.printStackTrace();
		}

	}

	private static ArrayList<Reservation> initalizePassengers(File file) throws NumberFormatException, IOException {
		
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		
		BufferedReader br = null;
	
			try {
				br = new BufferedReader(new FileReader(file));               //Setting up file I/O
			} catch (FileNotFoundException e1) {
				System.out.println("File Not Found; Please choose another.");
				Main.setPassengerFile();
			}

			
			
		String line;

			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				
				Reservation newReservation = new Reservation(values[0], values[1], Integer.parseInt(values[2]), values[3]);
				list.add(newReservation);
			}
	
		return list;
		
	}
	*/
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
	
	public static ArrayList<Reservation> createPassengerObjects() {
		
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
