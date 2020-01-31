package com.capgemini.stockmanagementsystem.dto;

import java.util.List;

public class AuthenticationResponse {

	private int statusCode;
	
	private String message;
	
	private List<AuthenticationDto> bean;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<AuthenticationDto> getBean() {
		return bean;
	}

	public void setBean(List<AuthenticationDto> bean) {
		this.bean = bean;
	}
	
	
	
}
