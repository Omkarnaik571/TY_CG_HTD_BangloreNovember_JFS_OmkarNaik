package com.capgemini.moduletesttwo.controller;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.moduletesttwo.dto.UserInfoResponse;
import com.capgemini.moduletesttwo.exception.CustomExceptions;

@RestControllerAdvice
public class ExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler(CustomExceptions.class)
	public UserInfoResponse handleAuthenticationException(CustomExceptions e) {
		UserInfoResponse response=new UserInfoResponse();
		response.setStatusCode(444);
		response.setMessage(e.getMessage());	
		return response;
	}
	
	
	

}
