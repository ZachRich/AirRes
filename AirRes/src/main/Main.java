package main;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.sun.codemodel.internal.JLabel;

public class Main {

	static HashMap<Flight, Reservation[]> flightMap = new HashMap<Flight, Reservation[]>();
	static File flightFile = new File("/home/zach/Desktop/AirRes-Test-Files/FlightFiles/FlightFileNoErrors.txt");
	static File passengerFile = new File(
			"/home/zach/Desktop/AirRes-Test-Files/PassengerFiles/PassengerFileNoErrors.txt");
	static File outputfilepath = new File("");
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		SystemRunner.addFlight(flightMap);
		SystemRunner.printHashMap(flightMap);
		

		/*
		 * EventQueue.invokeLater(new Runnable() { public void run() { try { Main window
		 * = new Main(); window.frame.setVisible(true); } catch (Exception e) {
		 * e.printStackTrace(); } } });
		 */

	}

	/**
	 * Create the application.
	 */
	public Main() {
		// change

		// initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame("AirRes Flight System");
		frame.getContentPane().setLayout(new FlowLayout());
		frame.setSize(1800, 1200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		// Passenger Button
		JButton passengerChooserButton = new JButton();
		passengerChooserButton.setText("Passenger Data File");

		passengerChooserButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setPassengerFile();
			}
		});

		frame.add(passengerChooserButton);

		// Flight Button
		JButton flightChooserButton = new JButton();
		flightChooserButton.setText("Flight Data File");
		flightChooserButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setFlightFile();
			}
		});

		frame.add(flightChooserButton);

		// Book Flights Button
		JButton bookFlights = new JButton();
		bookFlights.setText("Run System");
		bookFlights.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				SystemRunner.populateHashMap(flightMap);
				SystemRunner.printHashMap(flightMap);
			}
		});

		frame.add(bookFlights);

		JButton addFlight = new JButton();
		addFlight.setText("Add Flight");
		addFlight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				// SystemRunner.addFlight(flightMap, ID, capacity, price, origin, destination);

			}

		});

	}

	public static File setFlightFile() {

		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Flight File");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose [" + chooser.getSelectedFile().getName() + "] for your Flight Data");
		}
		return flightFile = new File(chooser.getSelectedFile().getPath());
	}

	public static File setPassengerFile() {

		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Passenger File");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose [" + chooser.getSelectedFile().getName() + "] for your Passenger Data");
		}
		return passengerFile = new File(chooser.getSelectedFile().getPath());
	}

	public static void infoBox(String infoMessage, String titleBar) {
		/*
		 * infoBox Displays a message consisting of a message, and a title for the popup
		 * box
		 */
		JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.WARNING_MESSAGE);
	}

	/*
	 * Overloaded entryBox methods: These are used for handling invalid inputs while
	 * Building the Passenger and Flight Objects A popup occurs when an invalid
	 * input is taken, and it asks the user to input a new value inplace of the
	 * invalid value.
	 */

	public static int entryBox(String infoMessage, String titleBar, int i) {
		String entry = JOptionPane.showInputDialog(null, infoMessage, titleBar, JOptionPane.WARNING_MESSAGE);
		int one = Integer.parseInt(entry);
		return one;
	}

	public static String entryBox(String infoMessage, String titleBar) {
		String entry = JOptionPane.showInputDialog(null, infoMessage, titleBar, JOptionPane.WARNING_MESSAGE);
		return entry;
	}

	public static double entryBox(String infoMessage, String titleBar, double i) {
		String entry = JOptionPane.showInputDialog(null, infoMessage, titleBar, JOptionPane.WARNING_MESSAGE);
		double temp = Double.parseDouble(entry);
		return temp;
	}

	public static Flight flightEntryBox() {
		
		 Flight newFlight = new Flight();
		 
		 String flightNum = JOptionPane.showInputDialog(null, "Please enter Flight Number: ", "Flight Number", JOptionPane.OK_CANCEL_OPTION);
		 String capacity = JOptionPane.showInputDialog(null, "Please enter Capacity: ", "Capacity Number", JOptionPane.OK_CANCEL_OPTION);
		 String price = JOptionPane.showInputDialog(null, "Please enter Price: ", "Price", JOptionPane.OK_CANCEL_OPTION);
		 String origin = JOptionPane.showInputDialog(null, "Please enter 3 Digit Origin Code: ", "Origin Code", JOptionPane.OK_CANCEL_OPTION);
		 String destination = JOptionPane.showInputDialog(null, "Please enter 3 Digit Destination Code: ", "Destination Code", JOptionPane.OK_CANCEL_OPTION);
		 
		 newFlight.setID(flightNum);
		 newFlight.setCapacity(Integer.parseInt(capacity));
		 newFlight.setPrice(Double.parseDouble(price));
		 newFlight.setOrigin(origin);
		 newFlight.setDestination(destination);
		 
		 return newFlight;
		 
	 }

}
