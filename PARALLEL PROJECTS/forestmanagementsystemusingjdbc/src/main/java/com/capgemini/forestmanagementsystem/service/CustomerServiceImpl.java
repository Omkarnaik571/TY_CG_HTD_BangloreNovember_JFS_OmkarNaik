package com.capgemini.forestmanagementsystem.service;

import java.util.List;

import com.capgemini.forestmanagementsystem.dao.CustomerDetailsDao;
import com.capgemini.forestmanagementsystem.dao.CustomerDetailsDaoImpl;
import com.capgemini.forestmanagementsystem.dto.CustomerDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public class CustomerServiceImpl implements CustomerService {

	      CustomerDetailsDao dao=new CustomerDetailsDaoImpl();
	
	@Override
	public boolean addCustomer(CustomerDetailsDto cdd) throws CustomExceptions {
		
		return dao.addCustomer(cdd);
	}

	@Override
	public List<CustomerDetailsDto> viewCustomerDetails() throws CustomExceptions {
		
		return dao.viewCustomerDetails();
	}

	@Override
	public CustomerDetailsDto viewSingleCustomerDetails(CustomerDetailsDto cdd) throws CustomExceptions {
		
		return dao.viewSingleCustomerDetails(cdd);
	}

	@Override
	public boolean deleteCustomerDetails(CustomerDetailsDto cdd) throws CustomExceptions {
		
		return dao.deleteCustomerDetails(cdd);
	}

	@Override
	public boolean modifyCustomerDetails(CustomerDetailsDto cdd, int choice) throws CustomExceptions {
		return dao.modifyCustomerDetails(cdd, choice);
	}

}
