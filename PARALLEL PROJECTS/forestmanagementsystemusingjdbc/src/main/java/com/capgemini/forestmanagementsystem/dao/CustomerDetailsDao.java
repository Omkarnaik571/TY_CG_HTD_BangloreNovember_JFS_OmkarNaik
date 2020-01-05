package com.capgemini.forestmanagementsystem.dao;

import com.capgemini.forestmanagementsystem.dto.CustomerDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public interface CustomerDetailsDao {
	 //1. add a Customer
	public boolean addCustomer(CustomerDetailsDto cdd) throws CustomExceptions;
//2. View all the Customers detail
	public boolean viewCustomerDetails();
//3. View single Customers detail
	public boolean viewSingleCustomerDetails();
//4. delete a Customers detail	
	public boolean deleteCustomerDetails(CustomerDetailsDto cdd);
//5. Modify a Customers detail	
	public boolean modifyCustomerDetails(CustomerDetailsDto cdd,int choice);
	
	
	
}
