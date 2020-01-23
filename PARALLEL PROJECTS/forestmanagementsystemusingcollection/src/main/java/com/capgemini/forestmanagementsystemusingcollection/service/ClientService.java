package com.capgemini.forestmanagementsystemusingcollection.service;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.ClientDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;

public interface ClientService {

	public boolean addClient(ClientDetails bean) ;

	public TreeMap<String, String> showAllClients();

	public boolean removeClient(String username);

	public boolean updateClient(ClientDetails bean);

	public boolean checkClient(String username,String password);

	public String viewSingleClient(String username);
	
	
	
	
	
}
