package com.capgemini.forestmanagementsystemusingspringrest.dto;

import java.util.List;

public class AuthenticationResponse {

	private int statuscode;
	private String message;
	private String description;
	
	private List<AuthenticationDetailsDto> bean;

	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<AuthenticationDetailsDto> getBean() {
		return bean;
	}

	public void setBean(List<AuthenticationDetailsDto> bean) {
		this.bean = bean;
	}
	
	
	

}
