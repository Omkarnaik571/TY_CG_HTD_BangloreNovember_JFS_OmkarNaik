package com.capgemini.forestmanagementsystemusingspringboot.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.forestmanagementsystemusingspringboot.dto.AuthenticationResponse;
import com.capgemini.forestmanagementsystemusingspringboot.exception.CustomExceptions;

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
