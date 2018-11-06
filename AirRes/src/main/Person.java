package main;

public class Person extends Passenger{

	private String name;
	private String telephoneNum;
	private String email;
	
	
	public Person(String name, String telephoneNum, String email){
		this.name = name;
		this.telephoneNum = telephoneNum;
		this.email = email;
	}
	
	public Person(){
		
		name = null;
		telephoneNum = null;
		email = null;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setTelephoneNum(String telephoneNum) {
		this.telephoneNum = telephoneNum;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public String getTelephoneNum() {
		return telephoneNum;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String toString() {
		return "[" + name + ", "  + telephoneNum + ", " + email + "]";
	}
	
	
}
