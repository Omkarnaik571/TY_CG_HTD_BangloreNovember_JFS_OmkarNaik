package com.capgemini.moduletesttwo.dto;

public class ProductResponse {
	
	 private	int statusCode;
	  private	String message;
	  private ProductInfo bean;
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
	public ProductInfo getBean() {
		return bean;
	}
	public void setBean(ProductInfo bean) {
		this.bean = bean;
	}
	  
	  
	  

}
