package com.capgemini.forestmanagementsystem.exceptions;

@SuppressWarnings("serial")
public class CustomExceptions extends Exception {

	private String exceptionMsg;
	
	public CustomExceptions(String exceptionMsg) {
		super();
		this.exceptionMsg = exceptionMsg;
	}

	
	public CustomExceptions() {
		super();
	}


	public void exceptionMessage() {
		System.err.println("\n"+exceptionMsg+"\n");
	}
	
	



	public void productIdAlreadyExist() {
		System.err.println("\nProduct Could`nt be added  !!");	
		System.err.println("The product id that you have entered, alreday exists.. please enter a different id\n");
		
	}
	
	public void clientIdAlreadyExist() {
		System.err.println("\nClient Could`nt be added  !!");	
		System.err.println("The product id that you have entered, alreday exists.. please enter a different id\n");
		
	}
	
	public void plotNumberAlreadyExist() {
		System.err.println("\nLand detail Could`nt be added  !!");	
		System.err.println("The plot number that you have entered, alreday exists.. please enter a different id\n");
		
	}
	
	public void customerIdAlreadyExist() {
		System.err.println("\nCustomer detail Could`nt be added  !!");	
		System.err.println("The customer id that you have entered, alreday exists.. please enter a different id\n");
		
	}
	
	
	public void schedulerIdAlreadyExist() {
		System.err.println("\nScheduler detail Could`nt be added  !!");	
		System.err.println("The scheduler id that you have entered, alreday exists.. please enter a different id\n");
		
	}
	
	
}
