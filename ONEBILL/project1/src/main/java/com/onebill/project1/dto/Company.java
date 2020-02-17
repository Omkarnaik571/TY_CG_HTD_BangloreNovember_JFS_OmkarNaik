package com.onebill.project1.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Company {
   
	@Id
	@GeneratedValue
	@Column
	private int companyId;
	
	@Column(unique = true, nullable = false)
	private String companyName;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "company")
	private List<Partner> partners;

	
	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<Partner> getPartners() {
		return partners;
	}

	public void setPartners(List<Partner> partners) {
		this.partners = partners;
	}
	
	
	
	
	
	
}
