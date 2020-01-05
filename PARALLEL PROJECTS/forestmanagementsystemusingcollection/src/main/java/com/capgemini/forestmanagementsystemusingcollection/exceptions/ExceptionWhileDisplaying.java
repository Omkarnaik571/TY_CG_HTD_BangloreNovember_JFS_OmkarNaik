package com.capgemini.forestmanagementsystemusingcollection.exceptions;

public class ExceptionWhileDisplaying extends Exception {
	String exceptionMsg;

	public ExceptionWhileDisplaying(String exceptionMsg) {
		super();
		this.exceptionMsg = exceptionMsg;
	}
	
	@Override
	public String toString() {
		return exceptionMsg;
	}
	
	
	public void exceptionMessage() {
		System.err.println(exceptionMsg);
	}
	
}
