package com.capgemini.forestmanagementsystem.dto;

public class ProductDetails {
	private int productid;
	private String productname;
	private String productquantity;

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductquantity() {
		return productquantity;
	}
	public void setProductquantity(String productquantity) {
		this.productquantity = productquantity;
	}

	@Override
	public String toString() {
		return "PRODUCT ID : " + productid + "\nPRODUCT NAME : " + productname + "\nPRODUCT QUANTITY : "
				+ productquantity;
	}	
		
		
	
	
	
}
