package com.tyss.ehub.config.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "authentication_details")
@Data
public class AuthenticationDto {

	@Id
	@Column
	@GeneratedValue
	private int authenticationID;
	@Column(unique = true)
	private String userName;
	@Column
	private String password;
	@Column
	private String accountType;
	public int getAuthenticationID() {
		return authenticationID;
	}
	public void setAuthenticationID(int authenticationID) {
		this.authenticationID = authenticationID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
	
	
}
