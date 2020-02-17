package com.onebill.project1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.project1.dao.CustomerDao;
import com.onebill.project1.dto.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	
	@Override
	public int addCustomer(Customer customer) {
		
		return customerDao.addCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		
		return customerDao.deleteCustomer(customer);
	}

	@Override
	public Customer viewCustomer(Customer customer) {
		
		return customerDao.viewCustomer(customer);
	}

	
	
	
}
