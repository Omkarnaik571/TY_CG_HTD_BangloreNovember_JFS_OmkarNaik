package com.capgemini.forestmanagementsystemusingcollection.service;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dao.ClientDao;
import com.capgemini.forestmanagementsystemusingcollection.dao.ClientDaoimpl;
import com.capgemini.forestmanagementsystemusingcollection.dto.ClientDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;

public class ClientServiceImpl implements ClientService {

	     ClientDao dao=new ClientDaoimpl();
	          
	
	
	public boolean addClient(ClientDetails bean) {
		// TODO Auto-generated method stub
		return dao.addClient(bean);
	}


	public TreeMap<String, String> showAllClients(){
		// TODO Auto-generated method stub
		return dao.showAllClients();
	}

	
	public boolean removeClient(String username) {
		// TODO Auto-generated method stub
		return dao.removeClient(username);
	}

	
	public boolean updateClient(ClientDetails bean) {
		return dao.updateClient(bean);
	}

	
	public boolean checkClient(String username, String password) {
		// TODO Auto-generated method stub
		return dao.checkClient(username, password);
	}

	
	public String viewSingleClient(String username) {
		// TODO Auto-generated method stub
		return dao.viewSingleClient(username);
	}

}
