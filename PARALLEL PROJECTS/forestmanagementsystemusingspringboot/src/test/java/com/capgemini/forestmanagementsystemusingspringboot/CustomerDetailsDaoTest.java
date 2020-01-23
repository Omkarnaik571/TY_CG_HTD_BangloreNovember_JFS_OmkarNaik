package com.capgemini.forestmanagementsystemusingspringboot;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.forestmanagementsystemusingspringboot.dao.CustomerDetailsDao;
import com.capgemini.forestmanagementsystemusingspringboot.dto.CustomerDetailsDto;
@SpringBootTest
class CustomerDetailsDaoTest {

	@Autowired
	CustomerDetailsDao customerDao;
	
	
	@Test
	void testAddCustomer() {
		CustomerDetailsDto customerDetailsDto=new CustomerDetailsDto();
		customerDetailsDto.setCustomerId(100);
		customerDetailsDto.setCustomerName("Omkar");
		customerDetailsDto.setEmail("omkar@gmail.com");
		customerDetailsDto.setPostalCode(123456);
		customerDetailsDto.setTelephoneNo(9938311438l);
		 boolean isAdded=customerDao.addCustomer(customerDetailsDto);
	     assertTrue(isAdded);
	     customerDao.deleteCustomerDetails(customerDetailsDto.getCustomerId());
	}

	@Test
	void testViewCustomerDetails() {
	   assertNotNull(customerDao.viewCustomerDetails());
	}

	@Test
	void testViewSingleCustomerDetails() {
		CustomerDetailsDto customerDetailsDto=new CustomerDetailsDto();
		customerDetailsDto.setCustomerId(100);
		customerDetailsDto.setCustomerName("Omkar");
		customerDetailsDto.setEmail("omkar@gmail.com");
		customerDetailsDto.setPostalCode(123456);
		customerDetailsDto.setTelephoneNo(9938311438l);
		customerDao.addCustomer(customerDetailsDto);
	    customerDetailsDto=customerDao.viewSingleCustomerDetails(customerDetailsDto);
	    assertNotNull(customerDetailsDto); 
	    customerDao.deleteCustomerDetails(customerDetailsDto.getCustomerId());
		
	}

	@Test
	void testDeleteCustomerDetails() {
		CustomerDetailsDto customerDetailsDto=new CustomerDetailsDto();
		customerDetailsDto.setCustomerId(100);
		customerDetailsDto.setCustomerName("Omkar");
		customerDetailsDto.setEmail("omkar@gmail.com");
		customerDetailsDto.setPostalCode(123456);
		customerDetailsDto.setTelephoneNo(9938311438l);
		customerDao.addCustomer(customerDetailsDto);
		boolean isRemoved=customerDao.deleteCustomerDetails(customerDetailsDto.getCustomerId());
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
		customerDao.addCustomer(customerDetailsDto);
		boolean isModified=customerDao.modifyCustomerDetails(customerDetailsDto);
		assertTrue(isModified);
		customerDao.deleteCustomerDetails(customerDetailsDto.getCustomerId());

	}

}
