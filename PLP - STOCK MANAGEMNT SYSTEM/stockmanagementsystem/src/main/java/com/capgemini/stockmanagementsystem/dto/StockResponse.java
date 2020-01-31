package com.capgemini.stockmanagementsystem.dto;

import java.util.List;

public class StockResponse {

	private int statusCode;

	private String message;

	private List<StockDetails> bean;

	
	
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

	public List<StockDetails> getBean() {
		return bean;
	}

	public void setBean(List<StockDetails> bean) {
		this.bean = bean;
	}

	
	
	
}
