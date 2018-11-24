package main;

import java.awt.EventQueue;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.FlowLayout;
import javax.swing.JLabel;


public class Main {

	static HashMap<Flight, Reservation[]> flightMap = new HashMap<Flight, Reservation[]>();
	static File flightFile = new File("/home/zach/Desktop/inputFile1.txt");
	static File passengerFile = new File("/home/zach/Desktop/inputFile2.txt");
	static File outputfilepath = new File("");
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

		//SystemRunner.initalizeFlights(flightFile, passengerFile, flightMap);
		//SystemRunner.printHashMap(flightMap);
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
		frame.setBounds(200, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Airline Booking System");
		frame.getContentPane().add(lblNewLabel);
	}

	public static File setFlightFile() {

		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Flight File");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
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
			System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
		}
		return passengerFile = new File(chooser.getSelectedFile().getPath());
	}

	public static void initSplashScreen() throws MalformedURLException {
		JWindow window = new JWindow();
		window.getContentPane().add(new javax.swing.JLabel("", new ImageIcon(new URL("http://docs.oracle.com/javase/tutorial/uiswing/examples/misc/SplashDemoProject/src/misc/images/splash.gif")), SwingConstants.CENTER));
		window.setBounds(500, 150, 1200, 600);
		window.setVisible(true);
		try {
		    Thread.sleep(5000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		window.setVisible(false);
		JFrame frame = new JFrame();
		frame.getContentPane().add(new javax.swing.JLabel("Welcome"));
		frame.setVisible(true);
		frame.setSize(300,100);
		window.dispose();
	}
	
}
