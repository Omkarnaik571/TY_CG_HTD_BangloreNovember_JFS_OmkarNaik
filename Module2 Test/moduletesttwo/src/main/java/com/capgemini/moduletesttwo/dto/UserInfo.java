package com.capgemini.moduletesttwo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="UserInfo")
@Entity
public class UserInfo {
  
	@GeneratedValue
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column(unique = true)
	private String email;
	@Column
	private String password;
	
	
	
	@Override
	public String toString() {
		return "Id : " + id + "\nName : " + name + "\nEmail : " + email + "\nPassword : " + password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
