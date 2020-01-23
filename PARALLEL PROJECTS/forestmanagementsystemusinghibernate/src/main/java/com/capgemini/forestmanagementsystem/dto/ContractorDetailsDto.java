package com.capgemini.forestmanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Table;

@Entity
@javax.persistence.Table(name="contrcatordetails")
public class ContractorDetailsDto {
	@Id
	@Column
	private int contractNo;
	@Column
	private int customerId;
	@Column
	private int productId;
	@Column
	private String deliveryDate;
	@Column
	private String quantity;
	@Column
	private String contractStatus="pending";
	
	
	public int getContractNo() {
		return contractNo;
	}
	public void setContractNo(int contractNo) {
		this.contractNo = contractNo;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getContractStatus() {
		return contractStatus;
	}
	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}
	@Override
	public String toString() {
		return "Contract No : " + contractNo + "\nCustomer Id : " + customerId + "\nProduct Id : "
				+ productId + "\nDelivery Date : " + deliveryDate + "\nQuantity : "  + quantity + "\nContract Status : "
				+ contractStatus;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
