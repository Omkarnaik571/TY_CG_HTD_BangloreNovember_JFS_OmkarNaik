package com.capgemini.forestmanagementsystem.dto;


public class CustomerDetailsDto {
	private int	customerid; 
	private String	customername; 
	private String	streetaddress1;  
	private String	streetaddress2; 
	private String	town;  
	private int	postalcode; 
	private String	email; 
	private long	telephoneno;
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getStreetaddress1() {
		return streetaddress1;
	}
	public void setStreetaddress1(String streetaddress1) {
		this.streetaddress1 = streetaddress1;
	}
	public String getStreetaddress2() {
		return streetaddress2;
	}
	public void setStreetaddress2(String streetaddress2) {
		this.streetaddress2 = streetaddress2;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public int getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(int postalcode) {
		this.postalcode = postalcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getTelephoneno() {
		return telephoneno;
	}
	public void setTelephoneno(long telephoneno) {
		this.telephoneno = telephoneno;
	}
	
	
	

}
