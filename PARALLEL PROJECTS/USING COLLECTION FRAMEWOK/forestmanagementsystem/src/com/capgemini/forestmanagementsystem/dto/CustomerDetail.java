package com.capgemini.forestmanagementsystem.dto;

public class CustomerDetail {
	private int customerid;
	private String customername;
	private String streetAddress1;
	private String streetAddress2;
	private String town;
	private int postalcode;
	private String email;
	private long telephoneno;
	
	
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


	@Override
	public String toString() {
		return "Customerid :  " + customerid + "\n customername : " + customername + "\n streetAddress1 :  "
				+ streetAddress1 + "\n streetAddress2 :  " + streetAddress2 + "\n town :  " + town + "\n postalcode :  " + postalcode
				+ "\n email : " + email + "\n telephoneno :  " + telephoneno;
	}





}
