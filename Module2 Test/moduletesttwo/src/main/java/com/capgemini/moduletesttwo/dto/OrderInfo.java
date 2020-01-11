package com.capgemini.moduletesttwo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OrderInfo")
public class OrderInfo {
    @Id
    @GeneratedValue
	@Column
	private int id;
	@Column
	private int productId;
	@Column
	private int userId;
	
	
	
	
	
	@Override
	public String toString() {
		return "Id : " + id + "\nProduct Id : " + productId + "\nUser Id : " + userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	
	
	
}
