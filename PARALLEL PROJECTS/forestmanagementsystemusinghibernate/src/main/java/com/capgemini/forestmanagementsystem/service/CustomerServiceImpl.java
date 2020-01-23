package com.capgemini.forestmanagementsystem.service;

import java.util.List;

import com.capgemini.forestmanagementsystem.dao.CustomerDetailsDao;
import com.capgemini.forestmanagementsystem.dao.CustomerDetailsDaoImpl;
import com.capgemini.forestmanagementsystem.dto.CustomerDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public class CustomerServiceImpl implements CustomerService {

	  CustomerDetailsDao customerDetailsDao=new CustomerDetailsDaoImpl();
	
	public boolean addCustomer(CustomerDetailsDto cdd) throws CustomExceptions {
		
		return customerDetailsDao.addCustomer(cdd);
	}

	public List<CustomerDetailsDto> viewCustomerDetails() throws CustomExceptions {
		
		return customerDetailsDao.viewCustomerDetails();
	}

	public CustomerDetailsDto viewSingleCustomerDetails(CustomerDetailsDto cdd) throws CustomExceptions {
		
		return customerDetailsDao.viewSingleCustomerDetails(cdd);
	}

	public boolean deleteCustomerDetails(CustomerDetailsDto cdd) throws CustomExceptions {
		
		return customerDetailsDao.deleteCustomerDetails(cdd);
	}

	public boolean modifyCustomerDetails(CustomerDetailsDto cdd, int choice) throws CustomExceptions {
		
		return customerDetailsDao.modifyCustomerDetails(cdd, choice);
	}

	
	
	
	
	
	
	
	
	
}
