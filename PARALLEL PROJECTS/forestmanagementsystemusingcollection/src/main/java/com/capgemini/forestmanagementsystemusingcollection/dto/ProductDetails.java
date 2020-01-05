package com.capgemini.forestmanagementsystemusingcollection.dto;

public class ProductDetails {
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
		return "PRODUCT ID : " + productId + "\nPRODUCT NAME : " + productName ;
	}	
		
		
	
	
	
}
