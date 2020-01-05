package com.capgemini.forestmanagementsystemusingcollection.service;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dao.CustomerDao;
import com.capgemini.forestmanagementsystemusingcollection.dao.CustomerDaoImpl;
import com.capgemini.forestmanagementsystemusingcollection.dto.CustomerDetail;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileModifying;

public class CustomerServiceImpl implements CustomerService{
        CustomerDao dao=new CustomerDaoImpl();
	
	@Override
	public boolean addCustomer(CustomerDetail details) throws ExceptionWhileInserting {
		// TODO Auto-generated method stub
		return dao.addCustomer(details);
	}

	@Override
	public TreeMap<Integer, CustomerDetail> viewCustomers() throws ExceptionWhileDisplaying {
		// TODO Auto-generated method stub
		return dao.viewCustomers();
	}

	@Override
	public boolean removeCustomer(Integer customerid) throws ExceptionWhileDeleting {
		// TODO Auto-generated method stub
		return dao.removeCustomer(customerid);
	}

	@Override
	public boolean modifyCustomer(Integer id, CustomerDetail details) throws ExceptionWhileModifying {
		// TODO Auto-generated method stub
		return dao.modifyCustomer(id, details);
	}

	@Override
	public CustomerDetail getSingleCustomer(Integer id) throws ExceptionWhileDisplaying {
		// TODO Auto-generated method stub
		return dao.getSingleCustomer(id);
	}

}
