package com.tyss.ehub.config.service;

import com.tyss.ehub.config.dto.AuthenticationDto;

public interface AuthenticationService {

	
public boolean addUser(AuthenticationDto authenticationDto);
	
	public boolean deleteUser(AuthenticationDto authenticationDto);
	
	public AuthenticationDto getUser(AuthenticationDto authenticationDto);
	
	public boolean updateUser(AuthenticationDto authenticationDto);
	

}
