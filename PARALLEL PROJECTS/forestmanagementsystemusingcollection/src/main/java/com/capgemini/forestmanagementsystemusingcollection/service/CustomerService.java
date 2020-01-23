package com.capgemini.forestmanagementsystemusingcollection.service;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.CustomerDetail;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileModifying;

public interface CustomerService {

public boolean addCustomer(CustomerDetail details) ;
	
	public TreeMap<Integer,CustomerDetail> viewCustomers() ;
	
	public boolean removeCustomer(Integer customerid) ;
	
	public boolean modifyCustomer(Integer id,CustomerDetail details) ;
	
	public CustomerDetail getSingleCustomer(Integer id);
	
	
	
}
