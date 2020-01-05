package com.capgemini.forestmanagementsystemusingcollection.dao;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.ClientDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;

public class ClientDaoimpl implements ClientDao {

	TreeMap<String, String> mapForClient = new TreeMap<String, String>();

	@Override
	public boolean addClient(ClientDetails bean) throws ExceptionWhileInserting {
		if (mapForClient.containsKey(bean.getClientUserName())) {
			throw new ExceptionWhileInserting("Client account with duplicate username not allowed");
		} else {
			mapForClient.put(bean.getClientUserName(), bean.getClientPassword());
			return true;
		}

	}

	@Override
	public TreeMap<String, String> showAllClients() throws ExceptionWhileDisplaying {
		if (mapForClient.size() != 0) {
			return mapForClient;
		} else {
			throw new ExceptionWhileDisplaying("There are no clients present in the database");
		}
	}

	@Override
	public boolean removeClient(String username) throws ExceptionWhileDeleting {
		if (mapForClient.containsKey(username)) {
			mapForClient.remove(username);
			return true;
		} else {
			throw new ExceptionWhileDeleting("Client account does not exist");
		}
	}

	@Override
	public boolean updateClient(ClientDetails bean) throws ExceptionWhileDisplaying {
		try {
			mapForClient.put(bean.getClientUserName(), bean.getClientPassword());
			System.out.println("Password updated");
			return true;
		} catch (Exception e) {
			throw new ExceptionWhileDisplaying("Client username and password didn`t matched !! ");
		}
	}

	@Override
	public boolean checkClient(String username, String password) {
		String passInMap = mapForClient.get(username);
		if (mapForClient.containsKey(username) && passInMap.equals(password)) {
			System.out.println("Client Found");
			return true;
		}
		System.out.println("Client not found");
		return false;
	}

	@Override
	public String viewSingleClient(String username) throws ExceptionWhileDisplaying {
		if (mapForClient.containsKey(username)) {
			String password = mapForClient.get(username);
			return password;
		} else {
			throw new ExceptionWhileDisplaying("Client account not found");
		}
	}

}
