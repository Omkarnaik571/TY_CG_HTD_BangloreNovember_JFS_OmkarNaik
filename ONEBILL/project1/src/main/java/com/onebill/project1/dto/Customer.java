package com.onebill.project1.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Customer {

	@Id
	@Column
	@GeneratedValue
	private int customerId;
	
	@Column(unique = true)
	private int customerIdentificationId;
	
	@Column
	private String customerName;
	
	@Column
	private String dateOfCommencement;
	
	@Column
	private long phoneNumber;
	
	@ManyToOne
	@JoinColumn(name = "partnerId")
	private Partner partner;
	

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customerForAddress")
	private List<Address> customerAddresses;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customerEmail")
	private List<Email> customerEmails;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getCustomerIdentificationId() {
		return customerIdentificationId;
	}

	public void setCustomerIdentificationId(int customerIdentificationId) {
		this.customerIdentificationId = customerIdentificationId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDateOfCommencement() {
		return dateOfCommencement;
	}

	public void setDateOfCommencement(String dateOfCommencement) {
		this.dateOfCommencement = dateOfCommencement;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public List<Address> getCustomerAddresses() {
		return customerAddresses;
	}

	public void setCustomerAddresses(List<Address> customerAddresses) {
		this.customerAddresses = customerAddresses;
	}

	public List<Email> getCustomerEmails() {
		return customerEmails;
	}

	public void setCustomerEmails(List<Email> customerEmails) {
		this.customerEmails = customerEmails;
	}
	
	
	
	
	
	
	
}
