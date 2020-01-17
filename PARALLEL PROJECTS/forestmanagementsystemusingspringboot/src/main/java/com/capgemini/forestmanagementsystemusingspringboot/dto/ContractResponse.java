package com.capgemini.forestmanagementsystemusingspringboot.dto;

import java.util.List;

public class ContractResponse {
	
	private int statuscode;
	private String message;
	private String description;
	
	private List<ContractorDetailsDto> bean;

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

	public List<ContractorDetailsDto> getBean() {
		return bean;
	}

	public void setBean(List<ContractorDetailsDto> bean) {
		this.bean = bean;
	}
	
	

}
