package com.capgemini.forestmanagementsystem.dao;

import java.util.List;

import com.capgemini.forestmanagementsystem.dto.AuthenticationDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public interface AuthenticationDetailsDao {

	public boolean addUser(AuthenticationDetailsDto aDetails) throws CustomExceptions;
	
	public boolean delateUser(AuthenticationDetailsDto aDetails) throws CustomExceptions;
	
	public boolean modifyUser(AuthenticationDetailsDto aDetails,String newPassword) throws CustomExceptions;
	
	public AuthenticationDetailsDto viewSingleUserClient(AuthenticationDetailsDto aDetails) throws CustomExceptions;
	
	public AuthenticationDetailsDto viewSingleUserScheduler(AuthenticationDetailsDto aDetails) throws CustomExceptions;
	
	public List<AuthenticationDetailsDto> viewAllClients() throws CustomExceptions;
	
	public List<AuthenticationDetailsDto> viewAllScheduers() throws CustomExceptions;
	
}
