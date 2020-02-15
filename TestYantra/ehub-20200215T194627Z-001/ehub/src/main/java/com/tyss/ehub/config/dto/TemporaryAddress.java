package com.tyss.ehub.config.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Table
@Entity
@Data
public class TemporaryAddress {

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
	@JoinColumn(name = "empId")
	@JsonIgnore
	private EmpDetails empDetails;
	
}
