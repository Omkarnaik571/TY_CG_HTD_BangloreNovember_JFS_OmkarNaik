package com.capgemini.forestmanagementsystemusingcollection.validations;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {
	
	public static boolean isStringOnlyAlphabet(String str) 
    { 
		
        return ((str != null) 
                && (!str.equals("")) 
                && (str.matches("^[a-zA-Z]*$"))); 
    }
	
	public static boolean isValid(String email) 
    {  
		String emailRegex = "^[a-z0-9_+&*-]+(?:\\."+ 
                "[a-z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 
	

	public static boolean isValidDate(String d) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		try {
			Date date = sdf.parse(d); //if date invalid throw exception
			Date today = new Date();
			return date.before(today); //return false if future date
			} catch (Exception e) {
				return true;
			}
	}
	
	public static boolean isValidDateFormat(String d) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		try {
			Date date = sdf.parse(d); 
			return true;
			} catch (Exception e) {
				return false;
			}
	}
	
	
	
	

	public static boolean isNumber1(String s) {
		try {
			long t = Long.parseLong(s);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	} 
	
	
	public static boolean isValidDay(String s) {
		String temp=s.toLowerCase();
		if(temp.equals("sunday") || temp.equals("monday") || temp.equals("tuesday") || temp.equals("wednesday") 
			||temp.equals("thursday") || temp.equals("friday") || temp.equals("saturday")	
				) {
			return true;
		}
		return false;
	}
	
	public static boolean isVaidPhoneNumber(String number) {
		if(number.length() != 10 ) {
	       return false;
		}
		return true;

	}
	
	public static boolean isVaidPostalCode(String number) {
		if(number.length() != 6 ) {
	       return false;
		}
		return true;

	}
	
	
	
}









		