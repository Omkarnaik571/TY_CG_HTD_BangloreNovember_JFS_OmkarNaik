package com.capgemini.forestmanagementsystemusingcollection.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmanagementsystemusingcollection.dto.CustomerDetail;

class CustomerServiceTest {

	static CustomerService customerService=new CustomerServiceImpl();
	static CustomerDetail customerDetail=new CustomerDetail();
	
	
	@BeforeAll
	static void testAddCustomer() {
	   customerDetail.setCustomerId(1);
	   customerDetail.setCustomerName("Omkar");
	   customerDetail.setEmail("Omkar@gmail.com");
	   customerDetail.setPostalCode(123456);
	   customerDetail.setStreetAddress1("Bhubaneswar");
	   customerDetail.setStreetAddress2("Sundargarh");
		customerDetail.setTelephoneNo(8018812508l);
		customerDetail.setTown("Sundargarh");
		customerService.addCustomer(customerDetail);
	}
	
	
	
	@Test
	void testAddCustomer1() {
	   customerDetail.setCustomerId(2);
	   customerDetail.setCustomerName("Aaryan");
	   customerDetail.setEmail("Omkar@gmail.com");
	   customerDetail.setPostalCode(123456);
	   customerDetail.setStreetAddress1("Bhubaneswar");
	   customerDetail.setStreetAddress2("Sundargarh");
		customerDetail.setTelephoneNo(8018812508l);
		customerDetail.setTown("Sundargarh");
		  boolean isadded=customerService.addCustomer(customerDetail);
		assertTrue(isadded);
	}
	

	@Test
	void testViewCustomers() {
		assertNotNull(customerService.viewCustomers());
	}

	@Test
	void testRemoveCustomer() {
	    boolean isDeleted=customerService.removeCustomer(2);
		
	}

	@Test
	void testModifyCustomer() {
		boolean isModified=customerService.modifyCustomer(1, customerDetail);
	   assertTrue(isModified);
	}

	@Test
	void testGetSingleCustomer() {
		assertNotNull(customerService.getSingleCustomer(1));
	}

	
	
	

}
