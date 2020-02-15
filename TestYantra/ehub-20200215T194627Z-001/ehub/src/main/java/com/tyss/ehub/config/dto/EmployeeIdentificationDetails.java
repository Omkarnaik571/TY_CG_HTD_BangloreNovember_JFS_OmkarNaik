package com.tyss.ehub.config.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Table
@Entity
@Data
public class EmployeeIdentificationDetails {
	
	@Id
	@Column
	@GeneratedValue
	private int identificationId;
	@Column
	private String aadharNo;
	@Column
	private String panNo;
	@Column
	private String voterId;
	
	@OneToOne
	@JoinColumn(name = "empId")
	@JsonIgnore
    private EmpDetails employeeDetails;
	

}
