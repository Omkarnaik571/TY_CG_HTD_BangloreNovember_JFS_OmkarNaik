package com.capgemini.forestmanagementsystem.dto;


public class ProductDetailsDto {
	private int productId;
	private String productName;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Override
	public String toString() {
		return "Product Id : " + productId + "\nProduct Name : " + productName;
	}
	
	
	
	
	
	
	
}
