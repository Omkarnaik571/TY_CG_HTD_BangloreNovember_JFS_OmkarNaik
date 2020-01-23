package com.capgemini.forestmanagementsystemusingcollection.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmanagementsystemusingcollection.dto.ContractDetails;

class ContractDaoTest {

	
	static ContractDao contractDao=new ContractDaoImpl();
	static ContractDetails contractDetails=new ContractDetails();
	
	
	@BeforeAll
	static void testAddContract() {
		contractDetails.setContractNo(1);
		contractDetails.setCustomerId(1);
		contractDetails.setProductId(1);
		contractDetails.setQuantity(100);
		contractDetails.setDeliveryDate("12/12/2020");
		contractDao.addContract(contractDetails);
	}
	
	
	@Test
	 void testAddContract1() {
		contractDetails.setContractNo(2);
		contractDetails.setCustomerId(1);
		contractDetails.setProductId(1);
		contractDetails.setQuantity(100);
		contractDetails.setDeliveryDate("12/12/2020");
		
		boolean isadded=contractDao.addContract(contractDetails);
		assertTrue(isadded);
	}

	@Test
	void testRemoveContract() {
		boolean isDeleted=contractDao.removeContract(2);
	    assertTrue(isDeleted);
	}

	@Test
	void testGetAllContract() {
		assertNotNull(contractDao.getAllContract());
	}

	@Test
	void testModifyContract() {
		ContractDetails contractDetails1=new ContractDetails();
		contractDetails1.setContractNo(2);
		contractDetails1.setCustomerId(1);
		contractDetails1.setProductId(1);
		contractDetails1.setQuantity(100);
		contractDetails1.setDeliveryDate("12/12/2020");
		boolean isModified=contractDao.modifyContract(contractDetails);
		assertTrue(isModified);
	}

	@Test
	void testGetSingleContract() {
	     assertNotNull(contractDao.getSingleContract(1));
	}

}
