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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Partner {

	@Id
	@Column
	@GeneratedValue
	private int partnerId;
	
	@Column(nullable = false, unique = true)
	private int partnerIdentificationId;
	
	@Column
	private String partnerName;
	
	@Column
	private String dateOfCommencement;
	
	@Column
	private long phoneNumber;
	
	@ManyToOne
	@JoinColumn(name = "companyId")
	@JsonIgnore
	private Company company;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "partner")
	private List<Customer> customers;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "partnerForAddress")
	private List<Address> partnerAddresses;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "partnerEmail")
	private List<Email> partnerEmails;

	
	
	public int getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
	}

	public int getPartnerIdentificationId() {
		return partnerIdentificationId;
	}

	public void setPartnerIdentificationId(int partnerIdentificationId) {
		this.partnerIdentificationId = partnerIdentificationId;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Address> getPartnerAddresses() {
		return partnerAddresses;
	}

	public void setPartnerAddresses(List<Address> partnerAddresses) {
		this.partnerAddresses = partnerAddresses;
	}

	public List<Email> getPartnerEmails() {
		return partnerEmails;
	}

	public void setPartnerEmails(List<Email> partnerEmails) {
		this.partnerEmails = partnerEmails;
	}
	
	
	
	
	
	
	
}
