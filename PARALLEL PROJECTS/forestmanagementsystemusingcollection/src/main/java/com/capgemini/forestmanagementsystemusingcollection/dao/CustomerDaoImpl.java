package com.capgemini.forestmanagementsystemusingcollection.dao;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.CustomerDetail;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileModifying;

public class CustomerDaoImpl implements CustomerDao {

	TreeMap<Integer, CustomerDetail> mapForCustomer=new TreeMap<Integer, CustomerDetail>();
	
	
	@Override
	public boolean addCustomer(CustomerDetail details) throws ExceptionWhileInserting {
		if(mapForCustomer.containsKey(details.getCustomerId())) {
			throw new ExceptionWhileInserting("Customer id that you have entered alreday exists");
		}
		else {
			mapForCustomer.put(details.getCustomerId(), details);
			return true;	
		}	
		
		
	}

	@Override
	public TreeMap<Integer, CustomerDetail> viewCustomers() throws ExceptionWhileDisplaying {
          if(mapForCustomer.isEmpty()) {
        	  throw new ExceptionWhileDisplaying("There are no customers present");
          }
          else {
		return mapForCustomer;
          }
     }

	@Override
	public boolean removeCustomer(Integer customerid) throws ExceptionWhileDeleting {
		if(mapForCustomer.containsKey(customerid)) {
			mapForCustomer.remove(customerid);
			return true;
		}
		else {
			throw new ExceptionWhileDeleting("The customer id that you have entered is not present");
		}
	
	}
	

	@Override
	public boolean modifyCustomer(Integer id, CustomerDetail details) throws ExceptionWhileModifying {
		if(mapForCustomer.containsKey(id)) {
			mapForCustomer.put(id, details);
			return true;
		}
		else {
			throw new ExceptionWhileModifying("The customer id that you have entered is not present");
		}
		
	}

	@Override
	public CustomerDetail getSingleCustomer(Integer id) throws ExceptionWhileDisplaying {
		if(mapForCustomer.containsKey(id)) {
			return mapForCustomer.get(id);
		}
		else {
			throw new ExceptionWhileDisplaying("Customer id that you have entered is not present");
		}
		
	}

}
