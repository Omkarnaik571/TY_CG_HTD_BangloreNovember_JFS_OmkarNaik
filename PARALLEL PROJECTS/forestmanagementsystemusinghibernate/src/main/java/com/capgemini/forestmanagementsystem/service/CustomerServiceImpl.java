package com.capgemini.forestmanagementsystem.service;

import java.util.List;

import com.capgemini.forestmanagementsystem.dao.CustomerDetailsDao;
import com.capgemini.forestmanagementsystem.dao.CustomerDetailsDaoImpl;
import com.capgemini.forestmanagementsystem.dto.CustomerDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public class CustomerServiceImpl implements CustomerService {

	  CustomerDetailsDao dao=new CustomerDetailsDaoImpl();
	
	public boolean addCustomer(CustomerDetailsDto cdd) throws CustomExceptions {
		
		return dao.addCustomer(cdd);
	}

	public List<CustomerDetailsDto> viewCustomerDetails() throws CustomExceptions {
		
		return dao.viewCustomerDetails();
	}

	public CustomerDetailsDto viewSingleCustomerDetails(CustomerDetailsDto cdd) throws CustomExceptions {
		
		return dao.viewSingleCustomerDetails(cdd);
	}

	public boolean deleteCustomerDetails(CustomerDetailsDto cdd) throws CustomExceptions {
		
		return dao.deleteCustomerDetails(cdd);
	}

	public boolean modifyCustomerDetails(CustomerDetailsDto cdd, int choice) throws CustomExceptions {
		
		return dao.modifyCustomerDetails(cdd, choice);
	}

	
	
	
	
	
	
	
	
	
}
