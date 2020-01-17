package com.capgemini.forestmanagementsystemusingspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestmanagementsystemusingspringboot.dao.CustomerDetailsDao;
import com.capgemini.forestmanagementsystemusingspringboot.dto.CustomerDetailsDto;
import com.capgemini.forestmanagementsystemusingspringboot.exception.CustomExceptions;

@Service
public class CustomerServiceImpl implements CustomerService {

	  @Autowired
	  CustomerDetailsDao customerDetailsDao;
	
	public boolean addCustomer(CustomerDetailsDto cdd) throws CustomExceptions {
		
		return customerDetailsDao.addCustomer(cdd);
	}

	public List<CustomerDetailsDto> viewCustomerDetails() throws CustomExceptions {
		
		return customerDetailsDao.viewCustomerDetails();
	}

	public CustomerDetailsDto viewSingleCustomerDetails(CustomerDetailsDto cdd) throws CustomExceptions {
		
		return customerDetailsDao.viewSingleCustomerDetails(cdd);
	}

	public boolean deleteCustomerDetails(int customerId) throws CustomExceptions {
		
		return customerDetailsDao.deleteCustomerDetails(customerId);
	}

	public boolean modifyCustomerDetails(CustomerDetailsDto cdd) throws CustomExceptions {
		
		return customerDetailsDao.modifyCustomerDetails(cdd);
	}

	
	
	
	
	
	
	
	
	
}
