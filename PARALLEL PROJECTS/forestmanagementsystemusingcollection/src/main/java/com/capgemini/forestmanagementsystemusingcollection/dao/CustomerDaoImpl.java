package com.capgemini.forestmanagementsystemusingcollection.dao;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.CustomerDetail;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileModifying;

public class CustomerDaoImpl implements CustomerDao {

	 public static TreeMap<Integer, CustomerDetail> mapForCustomer=new TreeMap<Integer, CustomerDetail>();
	
	
	    
	
	public boolean addCustomer(CustomerDetail details)  {
		if(mapForCustomer.containsKey(details.getCustomerId())) {
			throw new ExceptionWhileInserting("Customer id that you have entered alreday exists");
		}
		else {
			mapForCustomer.put(details.getCustomerId(), details);
			return true;	
		}	
		
		
	}

	
	public TreeMap<Integer, CustomerDetail> viewCustomers()  {
          if(mapForCustomer.isEmpty()) {
        	  throw new ExceptionWhileDisplaying("There are no customers present");
          }
          else {
		return mapForCustomer;
          }
     }

	
	public boolean removeCustomer(Integer customerid)  {
		if(mapForCustomer.containsKey(customerid)) {
			mapForCustomer.remove(customerid);
			return true;
		}
		else {
			throw new ExceptionWhileDeleting("The customer id that you have entered is not present");
		}
	
	}
	

	
	public boolean modifyCustomer(Integer id, CustomerDetail details)  {
		if(mapForCustomer.containsKey(id)) {
			mapForCustomer.put(id, details);
			return true;
		}
		else {
			throw new ExceptionWhileModifying("The customer id that you have entered is not present");
		}
		
	}


	public CustomerDetail getSingleCustomer(Integer id)  {
		if(mapForCustomer.containsKey(id)) {
			return mapForCustomer.get(id);
		}
		else {
			throw new ExceptionWhileDisplaying("Customer id that you have entered is not present");
		}
		
	}

}
