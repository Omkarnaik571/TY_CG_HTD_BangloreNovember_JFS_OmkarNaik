package com.capgemini.forestmanagementsystem.exceptions;

public class InvalidUserIdAndPassword  extends RuntimeException{

	public void invalidUserIdandPassword() {
		System.err.println("\nTHERE ARE NO CLIENTS PRESENT IN DATABASE....\n");
	}
	
	public void invalidUserIdandPasswordForSchesuler() {
		System.err.println("\nTHERE ARE NO SCHEDULERS PRESENT IN DATABASE....\n");
	}
		
	
}
