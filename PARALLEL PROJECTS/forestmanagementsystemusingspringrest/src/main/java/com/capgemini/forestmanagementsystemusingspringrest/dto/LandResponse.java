package com.capgemini.forestmanagementsystemusingspringrest.dto;

import java.util.List;

public class LandResponse {

	private int statuscode;
	private String message;
	private String description;
	
	private List<LandDetailsDto> bean;

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

	public List<LandDetailsDto> getBean() {
		return bean;
	}

	public void setBean(List<LandDetailsDto> bean) {
		this.bean = bean;
	}
	
	
	
	
	
	
	
	
}
