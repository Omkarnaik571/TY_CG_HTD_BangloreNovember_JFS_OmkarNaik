package com.tyss.ehub.config.dto;

import lombok.Data;

@Data
public class AuthenticationResponse {
	
	private int statusCode;
	
	private String message;
	
	private AuthenticationDto userDetails;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AuthenticationDto getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(AuthenticationDto userDetails) {
		this.userDetails = userDetails;
	} 

	
	
	
}
