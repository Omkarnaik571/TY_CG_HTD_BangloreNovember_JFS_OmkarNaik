package com.tyss.ehub.config.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@Table
@Entity
@Data
public class EmpDetails {

	@Id
	@Column
	@GeneratedValue
	private int empId;
	@Column
	private String name;
	
	@Exclude
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "empDetails")
	private List<TemporaryAddress> tempAddress;
	
	@Exclude
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "employeeDetails")
	private EmployeeIdentificationDetails identification;

	
}
