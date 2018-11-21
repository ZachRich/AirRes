package main;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {

	static HashMap<String, Flight> flightMap = new HashMap<String, Flight>();

	static final String flightFile = "/AirRes/inputFiles/inputFile1.csv";
	static final String passengerFile = "/AirRes/inputFiles/inputFile2.csv";
	static final String outputfilepath = "";

	public static void main(String[] args) {

		try {
			initalizeFlights();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void initalizeFlights() throws IOException {

		// flightMap.put("A100",new Flight(null, 0, null, null, null));

		/*
		 * if ( FlightNumber is new ){
		 * 		Create array with that F.N.
		 * } else {
		 *      add Flight OBJ to array with matching F.N.
		 * }
		 * 
		 * Once end of file is reached, Put all arrays into hashMap
		 * 
		 */
		
		List list = new List();
		
		BufferedReader br = new BufferedReader(new FileReader(flightFile));
		
		String line = "";
		
		while(br.readLine() != null) {
			
		}
		

	}
	
	public static void addFlight() {
		
		
		
		
	}
	

}
