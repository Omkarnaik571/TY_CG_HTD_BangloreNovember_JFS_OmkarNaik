package com.capgemini.stockmanagementsystem.dto;

import java.util.List;

public class InvestorResponse {

	private int statusCode;

	private String message;

	private List<InvestorDetails> bean;

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

	public List<InvestorDetails> getBean() {
		return bean;
	}

	public void setBean(List<InvestorDetails> bean) {
		this.bean = bean;
	}

	
	
}
