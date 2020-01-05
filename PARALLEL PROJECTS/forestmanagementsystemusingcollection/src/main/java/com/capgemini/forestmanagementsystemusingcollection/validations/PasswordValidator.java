package com.capgemini.forestmanagementsystemusingcollection.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
	
	private  Pattern pattern;
	  private  Matcher matcher;

	  private static final String PASSWORD_PATTERN = 
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})";
	        
	  public PasswordValidator(){
		  pattern = Pattern.compile(PASSWORD_PATTERN);
	  }
	  
	 
	  
	  public   boolean  validate(final String password){
		  
		  matcher = pattern.matcher(password);
		  return matcher.matches();
	    	    
		 
		  
	  }
	/*
	 # must contains one digit from 0-9
	 #   must contains one lowercase characters
	 	#   must contains one uppercase characters
	  	#   must contains one special symbols in the list "@#$%"
	  #     match anything with previous condition checking
	    {6,20}	#  length at least 6 characters and maximum of 20	
	  
	  
	   System.err.println("Password must contains one digit from 0-9 ");
	   System.err.println("one lowercase characters, one uppercase characters ");
	    System.err.println("one special symbols in the list "@#$%",  length at least 8 characters and maximum of 20  ");
	   
	  */
	  
	  
	  
	  
	  
	  
}
