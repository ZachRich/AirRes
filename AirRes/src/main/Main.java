package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Main {

	static HashMap<Flight, Reservation[]> flightMap = new HashMap<Flight, Reservation[]>();
	static File flightFile = new File("/home/zach/Desktop/AirRes-Test-Files/FlightFiles/FlightFileNoErrors.txt");
	static File passengerFile = new File(
			"/home/zach/Desktop/AirRes-Test-Files/PassengerFiles/PassengerFileNoErrors.txt");
	static File outputfilepath = new File("");
	private JFrame frame;
	private JComponent ui = null;
   
    Main(){
    	initUI();
    }
    
    public void initUI() {
        if (ui!=null) return;

        // I always use this 'ui' panel as a content pane that contains
        // everything else..
        ui = new JPanel(new BorderLayout(4,4));
        ui.setBorder(new EmptyBorder(4,4,4,4));

        // now to create the 3 panels of the '3 panel layout'. 
        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setBackground(Color.BLUE);
        panel1.setBorder(new TitledBorder("Choose Option"));


        JPanel panel3 = new JPanel(new BorderLayout());
        panel3.setBackground(Color.BLACK);
        panel3.setBorder(new TitledBorder("Instructions"));

        // add the buttons to 1st panel
        //panel1.add(addButtonsToPanel(buttonNames), BorderLayout.LINE_START);
        // add the combos to the top of 2nd panel 
       
        // give the 3rd panel some size
        panel3.add(new JLabel(new ImageIcon(new BufferedImage(400,200,BufferedImage.TYPE_INT_ARGB))));
        
        JPanel p = new JPanel(new GridLayout(0, 2));
        panel1.add(p, BorderLayout.LINE_START);
        
     // Passenger Button
     		JButton passengerChooserButton = new JButton();
     		passengerChooserButton.setText("Passenger Data File");

     		passengerChooserButton.addActionListener(new ActionListener() {

     			@Override
     			public void actionPerformed(ActionEvent arg0) {
     				setPassengerFile();
     			}
     		});

     		p.add(passengerChooserButton);

     		// Flight Button
     		JButton flightChooserButton = new JButton();
     		flightChooserButton.setText("Flight Data File");
     		flightChooserButton.addActionListener(new ActionListener() {

     			@Override
     			public void actionPerformed(ActionEvent arg0) {
     				setFlightFile();
     			}
     		});

     		p.add(flightChooserButton);

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

     		p.add(bookFlights);

     		JButton addFlightButton = new JButton();
     		addFlightButton.setText("Add Flight");
     		addFlightButton.addActionListener(new ActionListener() {

     			@Override
     			public void actionPerformed(ActionEvent arg0) {

     				SystemRunner.addFlight(flightMap);

     			}

     		});

     		p.add(addFlightButton);

     		JButton removeFlightButton = new JButton();
     		removeFlightButton.setText("Remove Flight");
     		removeFlightButton.addActionListener(new ActionListener() {

     			@Override
     			public void actionPerformed(ActionEvent arg0) {

     				SystemRunner.removeFlight(flightMap);

     			}

     		});
     		
     		p.add(removeFlightButton);
     		
     		JButton exportFile = new JButton();
     		exportFile.setText("Export Flight Summary");
     		exportFile.addActionListener(new ActionListener() {

     			@Override
     			public void actionPerformed(ActionEvent arg0) {
     				
     				try {
						exportFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

     			}
     		});
     		
     		p.add(exportFile);
     		
     		JButton addPassenger = new JButton();
     		addPassenger.setText("Add Passenger");
     		addPassenger.addActionListener(new ActionListener() {

     			@Override
     			public void actionPerformed(ActionEvent arg0) {
     				
     				SystemRunner.addPassenger(flightMap);

     			}
     		});
     		
     		p.add(addPassenger);
     		
     		JButton removePassenger = new JButton();
     		removePassenger.setText("Remove Passenger");
     		removePassenger.addActionListener(new ActionListener() {

     			@Override
     			public void actionPerformed(ActionEvent arg0) {
     				
     				SystemRunner.removePassenger(flightMap);

     			}
     		});
     		
     		//p.add(removePassenger);
     		
     		JLabel instructions = new JLabel("Please Select a Passenger file and a Flight File." + "\n" + " Then run the system, add or remove any flights and export the results");
     		
     		panel3.add(instructions);
     		
     	   // now assemble them all together
            panel1.add(panel3, BorderLayout.CENTER);
            ui.add(panel1, BorderLayout.CENTER);
    }

    private JPanel addCombosToPanel(String[][] ids) {
        JPanel p = new JPanel(new FlowLayout());
        for (String[] id : ids) {
            p.add(new JComboBox<String>(id));
        }
        return p;
    }
    
    public JComponent getUI() {
        return ui;
    }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                Main o = new Main();

                JFrame f = new JFrame(o.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.pack();
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
            }
		});
	}


	/**
	 * Create the application.
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame("AirRes Flight System");
		frame.getContentPane().setLayout(new FlowLayout());
		frame.setSize(1800, 1200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
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
	
	
	public static void exportFile() throws IOException {
	
		String userHomeFolder = System.getProperty("user.home");
		File textFile = new File(userHomeFolder, "Output.txt");
		BufferedWriter out = new BufferedWriter(new FileWriter(textFile));
		try {
		    out.append(SystemRunner.printHashMap(flightMap));
		} finally {
		   out.close();
		}
		
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

		String flightNum = JOptionPane.showInputDialog(null, "Please enter Flight Number: ", "Flight Number",
				JOptionPane.OK_CANCEL_OPTION);
		String capacity = JOptionPane.showInputDialog(null, "Please enter Capacity: ", "Capacity Number",
				JOptionPane.OK_CANCEL_OPTION);
		String price = JOptionPane.showInputDialog(null, "Please enter Price: ", "Price", JOptionPane.OK_CANCEL_OPTION);
		String origin = JOptionPane.showInputDialog(null, "Please enter 3 Digit Origin Code: ", "Origin Code",
				JOptionPane.OK_CANCEL_OPTION);
		String destination = JOptionPane.showInputDialog(null, "Please enter 3 Digit Destination Code: ",
				"Destination Code", JOptionPane.OK_CANCEL_OPTION);

		newFlight.setID(flightNum);
		newFlight.setCapacity(Integer.parseInt(capacity));
		newFlight.setPrice(Double.parseDouble(price));
		newFlight.setOrigin(origin);
		newFlight.setDestination(destination);

		return newFlight;

	}
	
	public static Reservation passengerEntryBox() {

		Reservation newRes = new Reservation();

		String name = JOptionPane.showInputDialog(null, "Please enter name, with no spaces. Ex. \"BobJones\" ", "Name",
				JOptionPane.OK_CANCEL_OPTION);
		String seatNum = JOptionPane.showInputDialog(null, "Please enter Seat Num: ", "Seat Number",
				JOptionPane.OK_CANCEL_OPTION);
		String origin = JOptionPane.showInputDialog(null, "Please enter 3 Digit Origin Code: ", "Origin Code",
				JOptionPane.OK_CANCEL_OPTION);
		String destination = JOptionPane.showInputDialog(null, "Please enter 3 Digit Destination Code: ",
				"Destination Code", JOptionPane.OK_CANCEL_OPTION);

		newRes.setName(name);
		newRes.setSeatNumber(Integer.parseInt(seatNum));
		newRes.setOrigin(origin);
		newRes.setDest(destination);

		return newRes;

	}

}
