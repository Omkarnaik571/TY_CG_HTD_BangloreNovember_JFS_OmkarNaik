package com.capgemini.stockmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.stockmanagementsystem.dao.AuthenticationDao;
import com.capgemini.stockmanagementsystem.dto.AuthenticationDto;
@Service
public class AuthenticationServiceImpl  implements AuthenticationService{

	@Autowired
	AuthenticationDao authenticationDao;
	
	
	@Override
	public boolean addUser(AuthenticationDto authenticationDto) {
		
		return authenticationDao.addUser(authenticationDto);
	}

	@Override
	public boolean removeUser(AuthenticationDto authenticationDto) {
		
		return authenticationDao.removeUser(authenticationDto);
	}

	@Override
	public boolean updateUser(AuthenticationDto authenticationDto) {
		
		return authenticationDao.updateUser(authenticationDto);
	}

	@Override
	public AuthenticationDto verifyUser(AuthenticationDto authenticationDto) {
		
		return authenticationDao.verifyUser(authenticationDto);
	}

	@Override
	public List<AuthenticationDto> viewAllUsers() {
		
		return authenticationDao.viewAllUsers();
	}

}
