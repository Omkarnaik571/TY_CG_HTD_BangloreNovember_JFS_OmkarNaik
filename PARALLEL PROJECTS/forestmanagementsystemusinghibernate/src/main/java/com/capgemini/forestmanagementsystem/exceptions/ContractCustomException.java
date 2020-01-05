package com.capgemini.forestmanagementsystem.exceptions;

@SuppressWarnings("serial")
public class ContractCustomException extends Exception {

	public void primarykeyviolation() {
		System.err.println("\nContract Could`nt be added  !!");	
		System.err.println("the Contract No ");
		System.err.println("that you have entered alreday exists in the database, enter a different one  !!");
	}
	
	
}
