package com.capgemini.forestmanagementsystemusingcollection.exceptions;

public class ExceptionWhileModifying extends RuntimeException{
	String exceptionMsg;

	public ExceptionWhileModifying(String exceptionMsg) {
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
