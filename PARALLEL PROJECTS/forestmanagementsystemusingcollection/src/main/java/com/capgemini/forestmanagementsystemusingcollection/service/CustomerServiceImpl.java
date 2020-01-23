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
	
	
	public boolean addCustomer(CustomerDetail details) {
		// TODO Auto-generated method stub
		return dao.addCustomer(details);
	}

	
	public TreeMap<Integer, CustomerDetail> viewCustomers(){
		// TODO Auto-generated method stub
		return dao.viewCustomers();
	}

	
	public boolean removeCustomer(Integer customerid) {
		// TODO Auto-generated method stub
		return dao.removeCustomer(customerid);
	}

	
	public boolean modifyCustomer(Integer id, CustomerDetail details) {
		// TODO Auto-generated method stub
		return dao.modifyCustomer(id, details);
	}

	
	public CustomerDetail getSingleCustomer(Integer id) {
		// TODO Auto-generated method stub
		return dao.getSingleCustomer(id);
	}

}
