package com.capgemini.forestmanagementsystemusingspringrest.testdao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestmanagementsystemusingspringrest.config.OrmConfig;
import com.capgemini.forestmanagementsystemusingspringrest.dao.CustomerDetailsDao;
import com.capgemini.forestmanagementsystemusingspringrest.dto.CustomerDetailsDto;
import com.capgemini.forestmanagementsystemusingspringrest.testconfig.TestBeans;
@SpringJUnitConfig(classes = { TestBeans.class, OrmConfig.class })
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
