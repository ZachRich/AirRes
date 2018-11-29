package main;

public class ReservationController {

	private Reservation model;
	private ReservationView view;
	
	public ReservationController(Reservation model, ReservationView view) {
		this.model = model;
		this.view = view;
	}
	
	public void setName(String name) {
		model.setName(name);
	}

	public String getName() {
		return model.getName();
	}
	
	public void setSeatNumber(int seatNumber) {
		model.setSeatNumber(seatNumber);
	}

	public int getSeatNumber() {
		return model.getSeatNumber();
	}
	
	public void setOrigin(String origin) {
		model.setOrigin(origin);
	}

	public String getOrigin() {
		return model.getOrigin();
	}

	public void setDest(String dest) {
		model.setDest(dest);
	}

	public String getDest() {
		return model.getDest();
	}
	
	public void updateView() {
		view.printReservationDetails(model.getOrigin(), model.getDest(), model.getSeatNumber(), model.getName());
	}
	 
}
