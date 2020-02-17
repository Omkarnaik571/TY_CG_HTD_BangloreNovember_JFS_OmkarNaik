package com.onebill.project1.dto;

public class CustomerResponse {

	private int statusCode;
	
	private String message;
	
	private String partnername;
	
	private Customer customer;

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

	public String getPartnername() {
		return partnername;
	}

	public void setPartnername(String partnername) {
		this.partnername = partnername;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
	
}
