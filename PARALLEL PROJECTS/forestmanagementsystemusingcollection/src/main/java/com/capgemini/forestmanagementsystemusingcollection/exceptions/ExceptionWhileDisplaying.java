package com.capgemini.forestmanagementsystemusingcollection.exceptions;

public class ExceptionWhileDisplaying extends RuntimeException {
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
