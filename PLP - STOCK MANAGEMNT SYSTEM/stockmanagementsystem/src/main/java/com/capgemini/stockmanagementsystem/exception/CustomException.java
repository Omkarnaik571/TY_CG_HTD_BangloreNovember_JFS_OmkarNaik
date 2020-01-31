package com.capgemini.stockmanagementsystem.exception;

public class CustomException extends RuntimeException{

	private String exceptionMessage;

	public CustomException(String exceptionMessage) {
		super();
		this.exceptionMessage = exceptionMessage;
	}
	
	public String exceptionOccured() {
		return exceptionMessage;
	}
	
	
}
