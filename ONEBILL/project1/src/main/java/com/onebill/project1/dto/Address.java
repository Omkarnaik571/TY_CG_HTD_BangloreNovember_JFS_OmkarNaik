package com.onebill.project1.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Address {

	@Id
	@Column
	@GeneratedValue
	private int addressId;
	
	@Column
	private String street;
	
	@Column
	private String zip;
	
	@Column
	private String city;
	
	@ManyToOne
	@JoinColumn(name = "partnerId")
	@JsonIgnore
	private Partner partnerForAddress;
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	@JsonIgnore
	private Customer customerForAddress;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Partner getPartnerForAddress() {
		return partnerForAddress;
	}

	public void setPartnerForAddress(Partner partnerForAddress) {
		this.partnerForAddress = partnerForAddress;
	}

	public Customer getCustomerForAddress() {
		return customerForAddress;
	}

	public void setCustomerForAddress(Customer customerForAddress) {
		this.customerForAddress = customerForAddress;
	}
	
	
	
}
