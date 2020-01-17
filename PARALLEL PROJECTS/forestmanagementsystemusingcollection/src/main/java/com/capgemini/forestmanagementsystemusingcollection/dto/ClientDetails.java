package com.capgemini.forestmanagementsystemusingcollection.dto;

public class ClientDetails {

private String clientUserName;
private String clientPassword;


public String getClientUserName() {
	return clientUserName;
}
public void setClientUserName(String clientUserName) {
	this.clientUserName = clientUserName;
}
public String getClientPassword() {
	return clientPassword;
}
public void setClientPassword(String clientPassword) {
	this.clientPassword = clientPassword;
}
@Override
public String toString() {
	return "Client User Name = " + clientUserName + "\nClient Password=" + clientPassword;
}	
	




	
}
