package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class SystemRunner {
	
	public static void printHashMap(HashMap<Flight, Reservation[]> map) {
		for (Entry<Flight, Reservation[]> entry : map.entrySet()) {
			  Flight key = entry.getKey();
			  Reservation[] value = entry.getValue();
			  
			  System.out.println("-------------------------------------------------------------------------------------------------------------");
			  System.out.print("\n" + key);
			  
			  System.out.print("\n" + "[");
			  for(Reservation r : value) {
				  System.out.print(r + ", ");
			  }
			  System.out.print("]" + "\n");
			 
			}
	}

	public static void initalizeFlights(File flights, File passengers, HashMap<Flight, Reservation[]> map) {

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

				Flight newFlight = new Flight(values[0], Integer.parseInt(values[1]), Double.parseDouble(values[2]),
						values[3], values[4]);
				
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

	public static ArrayList<Reservation> initalizePassengers(File file) {
		
		ArrayList<Reservation> list = new ArrayList<Reservation>();
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found");
		}

		String line;

		try {
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				
				Reservation newReservation = new Reservation(values[0], values[1], Integer.parseInt(values[2]), values[3]);
				list.add(newReservation);
			}

			br.close();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			System.err.println("IOException or NumberFormatException");
			e.printStackTrace();
		}

		return list;
		
	}

}
