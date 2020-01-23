package com.capgemini.forestmanagementsystem.service;

import java.util.List;

import com.capgemini.forestmanagementsystem.dao.AuthenticationDetailsDao;
import com.capgemini.forestmanagementsystem.dao.AuthenticationDetailsDaoImpl;
import com.capgemini.forestmanagementsystem.dto.AuthenticationDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public class AuthenticationServiceImpl implements AuthenticationService {

	            AuthenticationDetailsDao dao=new AuthenticationDetailsDaoImpl();
	
	@Override
	public boolean addUser(AuthenticationDetailsDto aDetails) throws CustomExceptions {
		
		return dao.addUser(aDetails);
	}

	@Override
	public boolean deleteUser(AuthenticationDetailsDto aDetails) throws CustomExceptions {
		
		return dao.deleteUser(aDetails);
	}

	@Override
	public boolean modifyUser(AuthenticationDetailsDto aDetails, String newPassword) throws CustomExceptions {
		
		return dao.modifyUser(aDetails, newPassword);
	}

	@Override
	public AuthenticationDetailsDto viewSingleUser(AuthenticationDetailsDto aDetails) throws CustomExceptions {
		
		return dao.viewSingleUser(aDetails);
	}

	@Override
	public List<AuthenticationDetailsDto> viewAllClients() throws CustomExceptions {
		
		return dao.viewAllClients();
	}

	@Override
	public List<AuthenticationDetailsDto> viewAllScheduers() throws CustomExceptions {
		
		return dao.viewAllScheduers();
	}

	@Override
	public AuthenticationDetailsDto checkUser(AuthenticationDetailsDto aDetails) throws CustomExceptions {
		
		return dao.checkUser(aDetails);
	}

	
	
	
	
}
