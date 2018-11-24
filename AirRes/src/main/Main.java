package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

	static HashMap<Flight, Reservation[]> flightMap = new HashMap<Flight, Reservation[]>();
	static ArrayList<Reservation> passengerList = new ArrayList<Reservation>();

	static final String flightFile = "/home/zach/Desktop/inputFile1.txt";
	static final String passengerFile = "/home/zach/Desktop/inputFile2.txt";
	static final String outputfilepath = "";

	private JFrame frame;
	
	public static void main(String[] args) throws IOException {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		initalizePassengers();
		initalizeFlights();
		
		for (Entry<Flight, Reservation[]> entry : flightMap.entrySet()) {
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
	

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				
				Reservation[] tempArray = new Reservation[newFlight.getCapacity()];
				
				
				for(int i = 0; i < passengerList.size(); i++) {
					if(passengerList.get(i) != null && passengerList.get(i).getOrigin().equals(newFlight.getOrigin()) && passengerList.get(i).getDest().equals(newFlight.getDestination())) {
						//System.out.println(passengerList.get(i).getName() + " boarded " + "Flight:" + newFlight.getID());
						
						//System.out.println("SeatNum: "+passengerList.get(i).getSeatNumber() + " SeatsOnPlane: "+newFlight.getCapacity());
						tempArray[passengerList.get(i).getSeatNumber() - 1] = passengerList.get(i); 
						
					}
				}
				
				flightMap.put(newFlight, tempArray);
				
			}

			br.close();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			System.err.println("IOException or NumberFormatException");
			e.printStackTrace();
		}

	}

	public static void initalizePassengers() {

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
				passengerList.add(newReservation);
			}

			br.close();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			System.err.println("IOException or NumberFormatException");
			e.printStackTrace();
		}

	}

}
