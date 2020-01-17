package com.capgemini.forestmanagementsystemusingspringboot.service;

import java.util.List;

import com.capgemini.forestmanagementsystemusingspringboot.dto.CustomerDetailsDto;
import com.capgemini.forestmanagementsystemusingspringboot.exception.CustomExceptions;

public interface CustomerService {

	 //1. add a Customer
		public boolean addCustomer(CustomerDetailsDto cdd) throws CustomExceptions;
	//2. View all the Customers detail
		public List<CustomerDetailsDto> viewCustomerDetails() throws CustomExceptions;
	//3. View single Customers detail
		public CustomerDetailsDto viewSingleCustomerDetails(CustomerDetailsDto cdd) throws CustomExceptions;
	//4. delete a Customers detail	
		public boolean deleteCustomerDetails(int customerId) throws CustomExceptions;
	//5. Modify a Customers detail	
		public boolean modifyCustomerDetails(CustomerDetailsDto cdd) throws CustomExceptions;
	
	
	
}
