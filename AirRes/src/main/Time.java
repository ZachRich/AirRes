package main;

public class Time {

	private int hour;
	private int minute;

	public Time() {

		hour = 0;
		minute = 0;
	}

	public Time(int h, int m) {
		if (h >= 1 && h <= 23)
			hour = h;
		else
			hour = 0;
		if (m >= 0 && m <= 59)
			minute = m;
		else
			minute = 0;
	}
	
	 public String toString()
	    {
	        String s = "";
	        if ( hour < 10 && minute < 10)
	            s = "0" + hour + "0" + minute;
	        else if ( hour < 10 && minute > 10)
	            s = "0" + hour + minute;
	        else if ( hour > 10 && minute < 10)
	            s = hour + "0" + minute;
	        else if ( hour > 10 && minute > 10)
	            s = hour +""+ minute;
	        else if ( hour == 0)
	            s = "0" + hour + minute;
	        else if ( minute == 0)
	            s = hour + "0" + minute;

	        return s;

	    }
}
