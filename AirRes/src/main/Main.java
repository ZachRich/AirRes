package main;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import main.EnvTableTest.EnvDataModel;


public class Main {

	static HashMap<Flight, Reservation[]> flightMap = new HashMap<Flight, Reservation[]>();
	static File flightFile = new File("/home/zach/Desktop/AirRes-Test-Files/FlightFiles/FlightFileNoErrors.txt");
	static File passengerFile = new File("/home/zach/Desktop/AirRes-Test-Files/PassengerFiles/PassengerFileNoErrors.txt");
	static File outputfilepath = new File("");
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		
		
		/*
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		 */
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

		
	}
	
	

	/**
	 * Create the application.
	 */
	public Main() {
	//change
		
		initialize();

		SystemRunner.printHashMap(flightMap);
		
		
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
		
		
		//Passenger Button
		JButton passengerChooserButton = new JButton();
		passengerChooserButton.setText("Passenger Data File");
		
		passengerChooserButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
					setPassengerFile();
			}
		});
		
		frame.add(passengerChooserButton);
		
		//Flight Button
		JButton flightChooserButton = new JButton();
		flightChooserButton.setText("Flight Data File");
		flightChooserButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
					setFlightFile();
			}
		});
		
		frame.add(flightChooserButton);
		
		//Book Flights Button
		JButton bookFlights = new JButton();
		bookFlights.setText("Run System");
		bookFlights.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				SystemRunner.populateHashMap(flightMap);
				
			}
		});
		
		frame.add(bookFlights);
		
		
		
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
		 * infoBox Displays a message consisting of a message, and a title for the popup box
		 */
		JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.WARNING_MESSAGE);
	}

	/*
	 * Overloaded entryBox methods:
	 * These are used for handling invalid inputs while Building the Passenger and Flight Objects
	 * A popup occurs when an invalid input is taken, and it asks the user to input a new value
	 * inplace of the invalid value.
	 */
	
	public static int entryBox(String infoMessage, String titleBar, int i) {
		 String entry= JOptionPane.showInputDialog(null, infoMessage, titleBar, JOptionPane.WARNING_MESSAGE);
		 int one = Integer.parseInt(entry);
		return one;
	}
	
	public static String entryBox(String infoMessage, String titleBar) {
		 String entry= JOptionPane.showInputDialog(null, infoMessage, titleBar, JOptionPane.WARNING_MESSAGE);
		return entry;
	}
	
	 public static double entryBox(String infoMessage, String titleBar, double i) {
		 String entry= JOptionPane.showInputDialog(null, infoMessage, titleBar, JOptionPane.WARNING_MESSAGE);
		double temp = Double.parseDouble(entry);
		return temp;
	}

	
}
