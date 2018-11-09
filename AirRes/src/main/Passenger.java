package main;

public class Passenger {

	private final String name;
	
	public Passenger(final String name) {
		
		this.name = name;
		
	}
	
	public String getName() {
		return name;
	}
	
	 @Override
	    public boolean equals(Object o){
	           
	           if(o==null)
	                  return false;
	           if(this.getClass()!=o.getClass())
	                  return false;
	    
	           Passenger p=(Passenger)o;
	           return p.name.equals(this.name);          
	    }
	           
	    @Override
	    public int hashCode(){
	           return  name.hashCode();      
	    }

}
