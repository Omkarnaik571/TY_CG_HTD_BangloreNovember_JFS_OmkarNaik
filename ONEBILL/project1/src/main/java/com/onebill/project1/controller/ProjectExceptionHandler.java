package com.onebill.project1.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.onebill.project1.dto.ExceptionResponse;
import com.onebill.project1.exception.CustomException;


@RestControllerAdvice
public class ProjectExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public ExceptionResponse handlerException(CustomException e) {
		ExceptionResponse response=new ExceptionResponse();
		response.setStatusCode(777);
		response.setMessage(e.getMessage());
		return response;
	}
	
	
	
	
}
