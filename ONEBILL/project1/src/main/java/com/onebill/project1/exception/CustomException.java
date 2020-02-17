package com.onebill.project1.exception;

public class CustomException extends RuntimeException{

	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private String exceptionMsg;
	
	public CustomException(String exceptionMsg) {
		super();
		this.exceptionMsg = exceptionMsg;
	}

	
	public CustomException() {
		super();
	}

	@Override
	public String getMessage() {
		return exceptionMsg;
	}


	
}
