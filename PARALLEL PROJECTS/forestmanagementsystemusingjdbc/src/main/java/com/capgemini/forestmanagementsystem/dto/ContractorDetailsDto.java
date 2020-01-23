package com.capgemini.forestmanagementsystem.dto;

public class ContractorDetailsDto {
	private int contractNo;
	private int customerId;
	private int productId;
	private String deliveryDate;
	private String quantity;

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

	@Override
	public String toString() {
		return "Contract No : " + contractNo + "\nCustomer Id : " + customerId + "\nProduct Id : "
				+ productId + "\nDelivery Date : " + deliveryDate + "\nQuantity : " + quantity;
	}

	
	
	
	
}
