package com.tyss.ehub.config.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tyss.ehub.config.dto.AuthenticationResponse;
import com.tyss.ehub.config.exception.CustomException;

@RestControllerAdvice
public class AdminControllerAdvice {

	
	
	@ExceptionHandler(CustomException.class)
	public AuthenticationResponse handlerException(CustomException e) {
		AuthenticationResponse adminResponse=new AuthenticationResponse();
		adminResponse.setStatusCode(501);
		adminResponse.setMessage(e.getMessage());
		return adminResponse;
	}
}
