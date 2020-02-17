package com.tyss.ehub.config.dto;

public class EmployeeResponse {

	private int ststusCode;
	
	private String message;
	
	private String employeeName;
	
	
	private EmpDetails empDetails;

	
	
	
	
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getStstusCode() {
		return ststusCode;
	}

	public void setStstusCode(int ststusCode) {
		this.ststusCode = ststusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public EmpDetails getEmpDetails() {
		return empDetails;
	}

	public void setEmpDetails(EmpDetails empDetails) {
		this.empDetails = empDetails;
	}
	
	
}
