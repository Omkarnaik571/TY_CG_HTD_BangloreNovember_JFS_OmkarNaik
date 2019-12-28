package com.capgemini.springrest.dto;

import java.util.List;

public class EmployeeResponse {

	private int statuscode;
	private String message;
	private String description;
	
	private List<EmployeeBean> beans;
	
	
	public List<EmployeeBean> getBeans() {
		return beans;
	}
	public void setBeans(List<EmployeeBean> beans) {
		this.beans = beans;
	}
	
	
	
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
}
