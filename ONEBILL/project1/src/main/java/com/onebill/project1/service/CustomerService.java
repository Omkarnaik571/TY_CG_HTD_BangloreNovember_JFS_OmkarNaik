package com.onebill.project1.service;

import com.onebill.project1.dto.Customer;

public interface CustomerService {

	public int addCustomer(Customer customer);

	public boolean deleteCustomer(Customer customer);

	public Customer viewCustomer(Customer customer);

}
