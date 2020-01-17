package com.capgemini.forestmanagementsystemusingcollection.dao;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.CustomerDetail;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileModifying;


public interface CustomerDao {

public boolean addCustomer(CustomerDetail details) throws ExceptionWhileInserting;
	
	public TreeMap<Integer,CustomerDetail> viewCustomers() throws ExceptionWhileDisplaying;
	
	public boolean removeCustomer(Integer customerid) throws ExceptionWhileDeleting;
	
	public boolean modifyCustomer(Integer id,CustomerDetail details) throws ExceptionWhileModifying;
	
	public CustomerDetail getSingleCustomer(Integer id) throws ExceptionWhileDisplaying;
	
	
	
	
}
