package com.onebill.project1.dao;

import com.onebill.project1.dto.Customer;

public interface CustomerDao {

	public int addCustomer(Customer customer);
	
	public boolean deleteCustomer(Customer customer);

	public Customer viewCustomer(Customer customer);
	

}
