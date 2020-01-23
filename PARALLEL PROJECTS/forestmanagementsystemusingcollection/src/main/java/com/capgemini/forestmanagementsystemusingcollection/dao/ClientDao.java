package com.capgemini.forestmanagementsystemusingcollection.dao;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.ClientDetails;


public interface ClientDao {

	public boolean addClient(ClientDetails bean) ;

	public TreeMap<String, String> showAllClients() ;

	public boolean removeClient(String username) ;

	public boolean updateClient(ClientDetails bean) ;

	public boolean checkClient(String username,String password);

	public String viewSingleClient(String username) ;
	
	
	
	
}
