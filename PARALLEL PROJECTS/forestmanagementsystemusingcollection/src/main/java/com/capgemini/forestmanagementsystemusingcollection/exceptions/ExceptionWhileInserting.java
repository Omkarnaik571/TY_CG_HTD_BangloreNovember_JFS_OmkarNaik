package com.capgemini.forestmanagementsystemusingcollection.exceptions;

public class ExceptionWhileInserting extends Exception {

	String exceptionMsg;

	public ExceptionWhileInserting(String exceptionMsg) {
		super();
		this.exceptionMsg = exceptionMsg;
	}

	@Override
	public String toString() {
		return " Warning !! " +exceptionMsg;
	}
	
	
	public void exceptionMessage() {
		System.err.println(exceptionMsg);
	}
	
	
	
}
