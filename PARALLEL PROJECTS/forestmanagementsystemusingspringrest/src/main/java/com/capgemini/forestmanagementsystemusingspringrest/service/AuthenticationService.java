package com.capgemini.forestmanagementsystemusingspringrest.service;

import java.util.List;

import com.capgemini.forestmanagementsystemusingspringrest.dto.AuthenticationDetailsDto;
import com.capgemini.forestmanagementsystemusingspringrest.exception.CustomExceptions;

public interface AuthenticationService {
	
public boolean addUser(AuthenticationDetailsDto aDetails) throws CustomExceptions;
	
	public boolean delateUser(AuthenticationDetailsDto aDetails) throws CustomExceptions;
	
	public boolean modifyUser(AuthenticationDetailsDto aDetailssword) throws CustomExceptions;
	
	public AuthenticationDetailsDto viewSingleUserScheduler(AuthenticationDetailsDto aDetails) throws CustomExceptions;
	
	public List<AuthenticationDetailsDto> viewAllClients() throws CustomExceptions;
	
	public List<AuthenticationDetailsDto> viewAllScheduers() throws CustomExceptions;

	AuthenticationDetailsDto viewSingleUserClient(AuthenticationDetailsDto aDetails) throws CustomExceptions;
	
	

}
