package com.capgemini.forestmanagementsystem.dto;

import lombok.Data;


public class ClientDetailsDto {
	private int clientId;
	private String clientName;
	private String password;


	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}





}
