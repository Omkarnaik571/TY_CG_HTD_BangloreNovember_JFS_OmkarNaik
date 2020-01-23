package com.capgemini.forestmanagementsystemusingspringrest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.forestmanagementsystemusingspringrest.dto.AuthenticationResponse;
import com.capgemini.forestmanagementsystemusingspringrest.exception.CustomExceptions;

@RestControllerAdvice
public class ForestManagementAdvice {
    @ExceptionHandler(CustomExceptions.class)
	public AuthenticationResponse handleAuthenticationException(CustomExceptions e) {
		AuthenticationResponse response=new AuthenticationResponse();
		response.setStatuscode(501);
		response.setMessage(e.getMessage());	
		return response;
	}
	
	
	
}
