package com.tyss.ehub.config.dao;

import com.tyss.ehub.config.dto.AuthenticationDto;

public interface AuthenticationDao {
	
	public boolean addUser(AuthenticationDto authenticationDto);
	
	public boolean deleteUser(AuthenticationDto authenticationDto);
	
	public AuthenticationDto getUser(AuthenticationDto authenticationDto);
	
	public boolean updateUser(AuthenticationDto authenticationDto);
	

}
