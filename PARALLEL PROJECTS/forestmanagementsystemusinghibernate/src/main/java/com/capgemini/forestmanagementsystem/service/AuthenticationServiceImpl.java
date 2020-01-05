package com.capgemini.forestmanagementsystem.service;

import java.util.List;

import com.capgemini.forestmanagementsystem.dao.AuthenticationDetailsDao;
import com.capgemini.forestmanagementsystem.dao.AuthenticationDetailsDaoImpl;
import com.capgemini.forestmanagementsystem.dto.AuthenticationDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public class AuthenticationServiceImpl implements AuthenticationService {

	AuthenticationDetailsDao authenticationDetailsDao=new AuthenticationDetailsDaoImpl();
	
	
	
	@Override
	public boolean addUser(AuthenticationDetailsDto aDetails) throws CustomExceptions {
		// TODO Auto-generated method stub
		return authenticationDetailsDao.addUser(aDetails);
	}

	@Override
	public boolean delateUser(AuthenticationDetailsDto aDetails) throws CustomExceptions {
		// TODO Auto-generated method stub
		return authenticationDetailsDao.delateUser(aDetails);
	}

	@Override
	public boolean modifyUser(AuthenticationDetailsDto aDetails, String newPassword) throws CustomExceptions {
		// TODO Auto-generated method stub
		return authenticationDetailsDao.modifyUser(aDetails, newPassword);
	}

	@Override
	public AuthenticationDetailsDto viewSingleUserClient(AuthenticationDetailsDto aDetails) throws CustomExceptions {
		// TODO Auto-generated method stub
		return authenticationDetailsDao.viewSingleUserClient(aDetails);
	}

	@Override
	public List<AuthenticationDetailsDto> viewAllClients() throws CustomExceptions {
		// TODO Auto-generated method stub
		return authenticationDetailsDao.viewAllClients();
	}

	@Override
	public List<AuthenticationDetailsDto> viewAllScheduers() throws CustomExceptions {
		// TODO Auto-generated method stub
		return authenticationDetailsDao.viewAllScheduers();
	}

	@Override
	public AuthenticationDetailsDto viewSingleUserScheduler(AuthenticationDetailsDto aDetails) throws CustomExceptions {
		// TODO Auto-generated method stub
		return authenticationDetailsDao.viewSingleUserScheduler(aDetails);
	}

}
