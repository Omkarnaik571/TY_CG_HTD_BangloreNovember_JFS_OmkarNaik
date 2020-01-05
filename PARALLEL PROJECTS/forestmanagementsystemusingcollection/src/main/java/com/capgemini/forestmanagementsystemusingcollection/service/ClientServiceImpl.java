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
	          
	
	@Override
	public boolean addClient(ClientDetails bean) throws ExceptionWhileInserting {
		// TODO Auto-generated method stub
		return dao.addClient(bean);
	}

	@Override
	public TreeMap<String, String> showAllClients() throws ExceptionWhileDisplaying {
		// TODO Auto-generated method stub
		return dao.showAllClients();
	}

	@Override
	public boolean removeClient(String username) throws ExceptionWhileDeleting {
		// TODO Auto-generated method stub
		return dao.removeClient(username);
	}

	@Override
	public boolean updateClient(ClientDetails bean) throws ExceptionWhileDisplaying {
		return dao.updateClient(bean);
	}

	@Override
	public boolean checkClient(String username, String password) {
		// TODO Auto-generated method stub
		return dao.checkClient(username, password);
	}

	@Override
	public String viewSingleClient(String username) throws ExceptionWhileDisplaying {
		// TODO Auto-generated method stub
		return dao.viewSingleClient(username);
	}

}
