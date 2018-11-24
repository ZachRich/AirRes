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
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Main {

	static HashMap<Flight, Reservation[]> flightMap = new HashMap<Flight, Reservation[]>();
	static File flightFile = new File("");
	static File passengerFile = new File("");
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
				
				SystemRunner.initalizeFlights(flightFile, passengerFile, flightMap);
				SystemRunner.printHashMap(flightMap);
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
