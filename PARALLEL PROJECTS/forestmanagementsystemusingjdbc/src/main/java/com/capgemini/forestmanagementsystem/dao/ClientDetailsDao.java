package com.capgemini.forestmanagementsystem.dao;

import com.capgemini.forestmanagementsystem.dto.ClientDetailsDto;

public interface ClientDetailsDao {

	public boolean addClient(ClientDetailsDto cld);
	
	public boolean deleteClient(ClientDetailsDto cld);
	
	public boolean modifyClient(ClientDetailsDto cld,String pass);
	
	public boolean viewAllClient();
	
}
