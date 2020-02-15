package com.tyss.ehub.config.dto;

import lombok.Data;

@Data
public class AuthenticationResponse {
	
	private int statusCode;
	
	private String message;
	
	private AuthenticationDto userDetails; 

}
