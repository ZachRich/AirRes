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
		
		 Scanner input = new Scanner(new File(flightFile));
		input.useDelimiter("\n");

		while(input.hasNext()) {
			
			String ID = input.next();
			int capacity = input.nextInt();
			Double price = input.nextDouble();
			String origin = input.next();
			String destination = input.next();
			
			Flight newFlight = new Flight(ID, capacity, price, origin, destination);
			
			temp.add(newFlight);
		}
		
		temp.listIterator();
		
		
	}
}
