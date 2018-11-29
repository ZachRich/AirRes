package main;

public class FlightController {

	private Flight model;
	private FlightView view;
	
	public FlightController(Flight model, FlightView view) {
		this.model = model;
		this.view = view;
	}
	
	public void setID(String ID) {
		model.setID(ID);
	}
	
	public String getID() {
		return model.getID();
	}
	
	public void setCapacity(int capacity) {
		model.setCapacity(capacity);
	}
	
	public int getCapacity() {
		return model.getCapacity();
	}
	
	public void setPrice(double price) {
		model.setPrice(price);
	}
	
	public double getPrice() {
		return model.getPrice();
	}
	
	public void setOrigin(String origin) {
		model.setOrigin(origin);
	}
	
	public String getOrigin() {
		return model.getOrigin();
	}
	
	public void setDestination(String destination) {
		model.setDestination(destination);
	}
	
	public String getDestination() {
		return model.getDestination();
	}
	
	public void updateView() {
		view.printFlightDetails(model.getID(), model.getCapacity(), model.getPrice(), model.getOrigin(), model.getDestination());
	}
	
	
	
}
