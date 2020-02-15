package com.tyss.ehub.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.ehub.config.dao.AuthenticationDao;
import com.tyss.ehub.config.dto.AuthenticationDto;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

	@Autowired
	AuthenticationDao authenticationDao;

	@Override
	public boolean addUser(AuthenticationDto authenticationDto) {
		return authenticationDao.addUser(authenticationDto);
	}

	@Override
	public boolean deleteUser(AuthenticationDto authenticationDto) {
		return authenticationDao.deleteUser(authenticationDto);
	}

	@Override
	public AuthenticationDto getUser(AuthenticationDto authenticationDto) {
		return authenticationDao.getUser(authenticationDto);
	}

	@Override
	public boolean updateUser(AuthenticationDto authenticationDto) {
		return authenticationDao.updateUser(authenticationDto);
	}
	
	
	
	
}
