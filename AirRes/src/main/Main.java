package main;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	static HashMap<Flight, ArrayList<Passenger>> flightMap = new HashMap<Flight, ArrayList<Passenger>>();

	static final String flightFile = "/home/zach/Desktop/inputFile1.txt";
	static final String passengerFile = "/home/zach/Desktop/inputFile2.txt";
	static final String outputfilepath = "";

	public static void main(String[] args) throws IOException {

		initalizeFlights();

	}

	public static void initalizeFlights() throws IOException {
		
		ArrayList<Flight> temp = new ArrayList<Flight>();		
		
		BufferedReader br = new BufferedReader(new FileReader(flightFile));
		String line;
		
		while ((line = br.readLine()) != null) {
		      String[] values = line.split(",");
	
		      Flight newFlight = new Flight(values[0], Integer.parseInt(values[1]), Double.parseDouble(values[2]), values[3], values[4]);
		      temp.add(newFlight);
		}
		
		for(Flight f : temp) {
			System.out.println(f);
		}
		
	}
}
