package control.util;

import java.sql.Date;

/**
 * This class converts a string to a java.sql.date.
 * @author Tamburello Martina
 * 
 */
public class StringConverter {

	/**
	 * This method converts a string in the format "dd MM,yyyy" to the java.sql.date format.
	 * @param d input string in the format "dd MM,yyyy"
	 * @return the java.sql.Date in format yyyy-MM-dd if the string d respects the format, otherwise null.
	 * 
	 */
	@SuppressWarnings("deprecation")
	public static Date stringToDate(String d) {

		if(d == null) {
			return null; 
		}

		int dd;

		try {

			dd = Integer.parseInt(d.substring(d.length()-8, d.length()-6));
		}
		catch(NumberFormatException e) {
			try {
				dd = Integer.parseInt(d.substring(d.length()-7, d.length()-6));
			}
			catch(NumberFormatException er){
				return null;
			}
		}
		int yy;
		try {
			yy = Integer.parseInt(d.substring(d.length()-4, d.length()));
			if(yy<1900 || yy>2999) {
				return null;
			}
		}
		catch(NumberFormatException er) {
			return null;
		}
		int MM;

		if(d.substring(0, 3).equalsIgnoreCase("gen")) 
			MM = 0;

		else if(d.substring(0, 3).equalsIgnoreCase("feb")) 
			MM = 1;

		else if(d.substring(0, 3).equalsIgnoreCase("mar")) 
			MM = 2;

		else if(d.substring(0, 3).equalsIgnoreCase("apr")) 
			MM = 3;

		else if(d.substring(0, 3).equalsIgnoreCase("mag")) 
			MM = 4;

		else if(d.substring(0, 3).equalsIgnoreCase("giu")) 
			MM = 5;

		else if(d.substring(0, 3).equalsIgnoreCase("lug")) 
			MM = 6;

		else if(d.substring(0, 3).equalsIgnoreCase("ago")) 
			MM = 7;

		else if(d.substring(0, 3).equalsIgnoreCase("set")) 
			MM = 8;

		else if(d.substring(0, 3).equalsIgnoreCase("ott")) 
			MM = 9;

		else if(d.substring(0, 3).equalsIgnoreCase("nov")) 
			MM = 10;

		else if(d.substring(0, 3).equalsIgnoreCase("dic")) 
			MM = 11;

		else return null;

		Date date = new java.sql.Date(yy-1900, MM, dd);
		return date;
	}


	/**
	 * This method converts a string in the format "yyyy-MM-dd" to the java.sql.date format.
	 * @param s input string in the format "yyyy-MM-dd"
	 * @return the java.sql.Date in format yyyy-MM-dd if the string d respects the format, otherwise null.
	 */
	@SuppressWarnings("deprecation")
	public static Date dateStringToDate(String s) {
		if(s == null || s.length()>11) {
			return null;
		}
		Date date;
		try {
			int yy = Integer.parseInt(s.substring(0,4));
			if(yy<1900 || yy>2999) {
				return null;
			}
			else
				date = new java.sql.Date(Integer.parseInt(s.substring(0,4))-1900, Integer.parseInt(s.substring(5, 7))-1, Integer.parseInt(s.substring(8, s.length())));
		}
		catch(NumberFormatException e) {
			return null;
		}
		return date;
	}
}
