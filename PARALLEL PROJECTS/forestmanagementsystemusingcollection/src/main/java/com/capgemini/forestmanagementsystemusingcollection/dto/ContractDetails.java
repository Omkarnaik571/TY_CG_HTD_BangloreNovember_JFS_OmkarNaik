package com.capgemini.forestmanagementsystemusingcollection.dto;

public class ContractDetails {
	private int contractNo;
	private int customerId;
	private int productId;
	private String deliveryDate;
	private int quantity;
	
	
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ContractNo=" + contractNo + "\nCustomerId=" + customerId + "\nProductId=" + productId
				+ "\nDeliveryDate=" + deliveryDate + "\nQuantity=" + quantity;
	}
	
	
	
	

	
	
	
	
}
