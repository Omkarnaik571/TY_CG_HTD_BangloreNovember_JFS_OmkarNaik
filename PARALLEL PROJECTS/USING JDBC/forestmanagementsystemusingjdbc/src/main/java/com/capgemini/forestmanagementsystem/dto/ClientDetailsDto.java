package com.capgemini.forestmanagementsystem.dto;

import lombok.Data;


public class ClientDetailsDto {
private int clientid;
private String clientname;
private String password;
public int getClientid() {
	return clientid;
}
public void setClientid(int clientid) {
	this.clientid = clientid;
}
public String getClientname() {
	return clientname;
}
public void setClientname(String clientname) {
	this.clientname = clientname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
	


	
}
