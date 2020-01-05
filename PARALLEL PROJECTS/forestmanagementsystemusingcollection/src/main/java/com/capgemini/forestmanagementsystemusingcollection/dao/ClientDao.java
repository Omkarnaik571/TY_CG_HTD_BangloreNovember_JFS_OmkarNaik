package com.capgemini.forestmanagementsystemusingcollection.dao;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.ClientDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;


public interface ClientDao {

	public boolean addClient(ClientDetails bean) throws ExceptionWhileInserting;

	public TreeMap<String, String> showAllClients() throws ExceptionWhileDisplaying;

	public boolean removeClient(String username) throws ExceptionWhileDeleting;

	public boolean updateClient(ClientDetails bean) throws ExceptionWhileDisplaying;

	public boolean checkClient(String username,String password);

	public String viewSingleClient(String username) throws ExceptionWhileDisplaying;
	
	
	
	
}
