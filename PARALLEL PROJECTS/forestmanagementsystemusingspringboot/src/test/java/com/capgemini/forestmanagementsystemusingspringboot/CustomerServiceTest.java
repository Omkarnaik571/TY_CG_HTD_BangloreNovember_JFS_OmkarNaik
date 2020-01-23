package com.capgemini.forestmanagementsystemusingspringboot;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.forestmanagementsystemusingspringboot.dto.CustomerDetailsDto;
import com.capgemini.forestmanagementsystemusingspringboot.service.CustomerService;
@SpringBootTest
class CustomerServiceTest {

	
	@Autowired
	CustomerService customerService;
	
	
	@Test
	void testAddCustomer() {
		CustomerDetailsDto customerDetailsDto=new CustomerDetailsDto();
		customerDetailsDto.setCustomerId(100);
		customerDetailsDto.setCustomerName("Omkar");
		customerDetailsDto.setEmail("omkar@gmail.com");
		customerDetailsDto.setPostalCode(123456);
		customerDetailsDto.setTelephoneNo(9938311438l);
		 boolean isAdded=customerService.addCustomer(customerDetailsDto);
	     assertTrue(isAdded);
	     customerService.deleteCustomerDetails(customerDetailsDto.getCustomerId());
	}

	@Test
	void testViewCustomerDetails() {
	   assertNotNull(customerService.viewCustomerDetails());
	}

	@Test
	void testViewSingleCustomerDetails() {
		CustomerDetailsDto customerDetailsDto=new CustomerDetailsDto();
		customerDetailsDto.setCustomerId(100);
		customerDetailsDto.setCustomerName("Omkar");
		customerDetailsDto.setEmail("omkar@gmail.com");
		customerDetailsDto.setPostalCode(123456);
		customerDetailsDto.setTelephoneNo(9938311438l);
		customerService.addCustomer(customerDetailsDto);
	    customerDetailsDto=customerService.viewSingleCustomerDetails(customerDetailsDto);
	    assertNotNull(customerDetailsDto); 
	    customerService.deleteCustomerDetails(customerDetailsDto.getCustomerId());
		
	}

	@Test
	void testDeleteCustomerDetails() {
		CustomerDetailsDto customerDetailsDto=new CustomerDetailsDto();
		customerDetailsDto.setCustomerId(100);
		customerDetailsDto.setCustomerName("Omkar");
		customerDetailsDto.setEmail("omkar@gmail.com");
		customerDetailsDto.setPostalCode(123456);
		customerDetailsDto.setTelephoneNo(9938311438l);
		customerService.addCustomer(customerDetailsDto);
		boolean isRemoved=customerService.deleteCustomerDetails(customerDetailsDto.getCustomerId());
		assertTrue(isRemoved);
	}

	@Test
	void testModifyCustomerDetails() {
		CustomerDetailsDto customerDetailsDto=new CustomerDetailsDto();
		customerDetailsDto.setCustomerId(100);
		customerDetailsDto.setCustomerName("Omkar");
		customerDetailsDto.setEmail("omkar@gmail.com");
		customerDetailsDto.setPostalCode(123456);
		customerDetailsDto.setTelephoneNo(9938311438l);
		customerService.addCustomer(customerDetailsDto);
		boolean isModified=customerService.modifyCustomerDetails(customerDetailsDto);
		assertTrue(isModified);
		customerService.deleteCustomerDetails(customerDetailsDto.getCustomerId());

	}

	
	
	
	

}
