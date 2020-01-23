package com.capgemini.forestmanagementsystemusingspringboot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productdetails")
public class ProductDetailsDto {
	@Id
	@Column
	private int productId;
	@Column
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
