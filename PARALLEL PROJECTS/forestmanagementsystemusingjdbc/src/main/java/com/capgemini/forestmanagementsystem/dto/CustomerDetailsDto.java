package com.capgemini.forestmanagementsystem.dto;


public class CustomerDetailsDto {
	private int	customerId; 
	private String	customerName; 
	private String	streetAddress1;  
	private String	streetAddress2; 
	private String	town;  
	private int	 postalCode; 
	private String	email; 
	private long	telephoneNo;
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getStreetAddress1() {
		return streetAddress1;
	}
	public void setStreetAddress1(String streetAddress1) {
		this.streetAddress1 = streetAddress1;
	}
	public String getStreetAddress2() {
		return streetAddress2;
	}
	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	
	
	
	
	
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getTelephoneno() {
		return telephoneNo;
	}
	public void setTelephoneno(long telephoneNo) {
		this.telephoneNo = telephoneNo;
	}
	@Override
	public String toString() {
		return "Customer Id : " + customerId + "\nCustomer Name : " + customerName + "\nStreet Address1 : "
				+ streetAddress1 + "\nStreet Address2 : " + streetAddress2 + "\nTown : " + town + "\nPostal Code : "
				+ postalCode + "\nE-mail : " + email + "\nTelephone No : " + telephoneNo;
	}
	
	
	
	
	
	

}
