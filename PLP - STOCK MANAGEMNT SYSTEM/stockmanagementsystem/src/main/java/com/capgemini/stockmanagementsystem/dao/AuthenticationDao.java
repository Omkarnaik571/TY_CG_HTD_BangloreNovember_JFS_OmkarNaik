package com.capgemini.stockmanagementsystem.dao;

import java.util.List;

import com.capgemini.stockmanagementsystem.dto.AuthenticationDto;

public interface AuthenticationDao {

	public boolean addUser(AuthenticationDto authenticationDto);
	
	public boolean removeUser(AuthenticationDto authenticationDto);
	
	
	public boolean updateUser(AuthenticationDto authenticationDto);
	
	
	public AuthenticationDto verifyUser(AuthenticationDto authenticationDto);
	
	public List<AuthenticationDto> viewAllUsers();
	
	
}