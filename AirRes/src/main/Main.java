package main;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	static HashMap<Flight, Reservation[]> flightMap = new HashMap<Flight, Reservation[]>();

	static final String flightFile = "/home/zach/Desktop/inputFile1.txt";
	static final String passengerFile = "/home/zach/Desktop/inputFile2.txt";
	static final String outputfilepath = "";

	public static void main(String[] args) throws IOException {

		initalizeFlights();
		initalizePassengers();

	}

	public static void initalizeFlights() {

		ArrayList<Flight> temp = new ArrayList<Flight>();

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(flightFile));
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found");
		}

		String line;

		try {
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");

				Flight newFlight = new Flight(values[0], Integer.parseInt(values[1]), Double.parseDouble(values[2]),
						values[3], values[4]);
				temp.add(newFlight);
			}

			br.close();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			System.err.println("IOException or NumberFormatException");
			e.printStackTrace();
		}

	}

	public static void initalizePassengers() {

		ArrayList<Reservation> temp1 = new ArrayList<Reservation>();

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(passengerFile));
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found");
		}

		String line;

		try {
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				
				Reservation newReservation = new Reservation(values[0], values[1], Integer.parseInt(values[2]), values[3]);
				temp1.add(newReservation);
			}

			br.close();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			System.err.println("IOException or NumberFormatException");
			e.printStackTrace();
		}

		for (Reservation r : temp1) {
			System.out.println(r);
		}

	}

}
