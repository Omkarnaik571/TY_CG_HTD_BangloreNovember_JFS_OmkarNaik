package com.capgemini.moduletesttwo.exception;

public class CustomExceptions extends RuntimeException{
	
private String exceptionMsg;
	
	public CustomExceptions(String exceptionMsg) {
		super();
		this.exceptionMsg = exceptionMsg;
	}

	
	public CustomExceptions() {
		super();
	}

	@Override
	public String getMessage() {
		return exceptionMsg;
	}
	
	
	

}
