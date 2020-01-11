package com.capgemini.moduletesttwo.dto;

public class UserInfoResponse {

  private	int statusCode;
  private	String message;
  private   UserInfo bean;
  
  
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
public UserInfo getBean() {
	return bean;
}
public void setBean(UserInfo bean) {
	this.bean = bean;
}
	
	
	
}
