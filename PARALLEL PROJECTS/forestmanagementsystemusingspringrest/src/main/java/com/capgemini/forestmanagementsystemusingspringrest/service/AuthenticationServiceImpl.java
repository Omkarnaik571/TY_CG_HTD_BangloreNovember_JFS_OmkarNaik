package com.capgemini.forestmanagementsystemusingspringrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestmanagementsystemusingspringrest.dao.AuthenticationDetailsDao;
import com.capgemini.forestmanagementsystemusingspringrest.dao.AuthenticationDetailsDaoImpl;
import com.capgemini.forestmanagementsystemusingspringrest.dto.AuthenticationDetailsDto;
import com.capgemini.forestmanagementsystemusingspringrest.exception.CustomExceptions;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	AuthenticationDetailsDao authenticationDetailsDao;
	
	
	
	@Override
	public boolean addUser(AuthenticationDetailsDto aDetails) throws CustomExceptions {
		return authenticationDetailsDao.addUser(aDetails);
	}

	@Override
	public boolean delateUser(AuthenticationDetailsDto aDetails) throws CustomExceptions {
		
		return authenticationDetailsDao.delateUser(aDetails);
	}

	@Override
	public boolean modifyUser(AuthenticationDetailsDto aDetails) throws CustomExceptions {
		
		return authenticationDetailsDao.modifyUser(aDetails);
	}

	@Override
	public AuthenticationDetailsDto viewSingleUserClient(AuthenticationDetailsDto aDetails) throws CustomExceptions {
		
		return authenticationDetailsDao.viewSingleUserClient(aDetails);
	}

	@Override
	public List<AuthenticationDetailsDto> viewAllClients() throws CustomExceptions {
		
		return authenticationDetailsDao.viewAllClients();
	}

	@Override
	public List<AuthenticationDetailsDto> viewAllScheduers() throws CustomExceptions {
		
		return authenticationDetailsDao.viewAllScheduers();
	}

	@Override
	public AuthenticationDetailsDto viewSingleUserScheduler(AuthenticationDetailsDto aDetails) throws CustomExceptions {
		
		return authenticationDetailsDao.viewSingleUserScheduler(aDetails);
	}

}
