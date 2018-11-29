package main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Main {

	static HashMap<Flight, Reservation[]> flightMap = new HashMap<Flight, Reservation[]>();
	static File flightFile = new File("/home/zach/Desktop/AirRes-Test-Files/FlightFiles/FlightFileNoErrors.txt");
	static File passengerFile = new File("");
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
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 100, 900, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{306, 388, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{43, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Airline Booking System");
		lblNewLabel.setFont(new Font("Ubuntu", Font.PLAIN, 37));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(2, 2, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Choose Flight File");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setFlightFile();
				
			}
		});
		
		JButton btnNewButton_2 = new JButton("Book Flights");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//SystemRunner.initalizeFlights(flightFile, passengerFile, flightMap);
				//SystemRunner.printHashMap(flightMap);
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(2, 2, 5, 5);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 4;
		frame.getContentPane().add(btnNewButton_2, gbc_btnNewButton_2);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 4;
		frame.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton = new JButton("Choose Passenger File");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setPassengerFile();
				
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(2, 2, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 4;
		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
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
