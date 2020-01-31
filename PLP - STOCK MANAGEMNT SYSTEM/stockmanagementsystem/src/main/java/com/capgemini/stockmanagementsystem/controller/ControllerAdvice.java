package com.capgemini.stockmanagementsystem.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.stockmanagementsystem.dto.AuthenticationResponse;
import com.capgemini.stockmanagementsystem.exception.CustomException;


@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(CustomException.class)
	public AuthenticationResponse handleAuthenticationException(CustomException e) {
		AuthenticationResponse response=new AuthenticationResponse();
		response.setStatusCode(501);
		response.setMessage(e.exceptionOccured());	
		return response;
	}
	
	
}
