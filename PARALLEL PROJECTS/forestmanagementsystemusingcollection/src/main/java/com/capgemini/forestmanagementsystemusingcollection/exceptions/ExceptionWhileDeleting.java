package com.capgemini.forestmanagementsystemusingcollection.exceptions;

public class ExceptionWhileDeleting extends Exception {
	String exceptionMsg;
	
	
	
	
	
	public ExceptionWhileDeleting(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}



	@Override
	public String toString() {
		return "Exception "+exceptionMsg;
	}
	
	public void exceptionMessage() {
		System.err.println(exceptionMsg);
	}
	
	
	
	
	
}
