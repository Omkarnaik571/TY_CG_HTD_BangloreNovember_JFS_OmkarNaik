package com.capgemini.forestmanagementsystemusingcollection.dao;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.ClientDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;

public class ClientDaoimpl implements ClientDao {

	TreeMap<String, String> mapForClient = new TreeMap<String, String>();

	
	public boolean addClient(ClientDetails bean)  {
		if (mapForClient.containsKey(bean.getClientUserName())) {
			throw new ExceptionWhileInserting("Client account with duplicate username not allowed");
		} else {
			mapForClient.put(bean.getClientUserName(), bean.getClientPassword());
			return true;
		}

	}

	
	public TreeMap<String, String> showAllClients()  {
		if (mapForClient.size() != 0) {
			return mapForClient;
		} else {
			throw new ExceptionWhileDisplaying("There are no clients present in the database");
		}
	}

	
	public boolean removeClient(String username)  {
		if (mapForClient.containsKey(username)) {
			mapForClient.remove(username);
			return true;
		} else {
			throw new ExceptionWhileDeleting("Client account does not exist");
		}
	}

	
	public boolean updateClient(ClientDetails bean) {
		try {
			mapForClient.put(bean.getClientUserName(), bean.getClientPassword());
			return true;
		} catch (Exception e) {
			throw new ExceptionWhileDisplaying("Client username and password didn`t matched !! ");
		}
	}

	
	public boolean checkClient(String username, String password) {
		String passInMap = mapForClient.get(username);
		if (mapForClient.containsKey(username) && passInMap.equals(password)) {
			return true;
		}
		return false;
	}

	
	public String viewSingleClient(String username) {
		if (mapForClient.containsKey(username)) {
			String password = mapForClient.get(username);
			return password;
		} else {
			throw new ExceptionWhileDisplaying("Client account not found");
		}
	}
	

	

}
