package com.capgemini.springrest.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name="employee_info")
public class EmployeeBean {
	@Id
	@Column
	@GeneratedValue
   private int id;
	@Column
   private String name;
	@Column(unique = true,nullable = false)
   private String email;
	@Column
   private String password;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "employeeBean")
	private List<EmployeeAddressBean> addressBeans;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<EmployeeAddressBean> getAddressBeans() {
		return addressBeans;
	}


	public void setAddressBeans(List<EmployeeAddressBean> addressBeans) {
		this.addressBeans = addressBeans;
	}

	
	
	
	
	
	
	
}
