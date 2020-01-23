package com.capgemini.forestmanagementsystemusingcollection.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmanagementsystemusingcollection.dto.ContractDetails;

class ContractServiceTest {

	
	static ContractService contractService=new ContractServiceImpl();
	static ContractDetails contractDetails=new ContractDetails();
	
	
	@BeforeAll
	static void testAddContract() {
		contractDetails.setContractNo(1);
		contractDetails.setCustomerId(1);
		contractDetails.setProductId(1);
		contractDetails.setQuantity(100);
		contractDetails.setDeliveryDate("12/12/2020");
		contractService.addContract(contractDetails);
	}
	
	
	@Test
	 void testAddContract1() {
		contractDetails.setContractNo(2);
		contractDetails.setCustomerId(1);
		contractDetails.setProductId(1);
		contractDetails.setQuantity(100);
		contractDetails.setDeliveryDate("12/12/2020");
		
		boolean isadded=contractService.addContract(contractDetails);
		assertTrue(isadded);
	}

	@Test
	void testRemoveContract() {
		boolean isDeleted=contractService.removeContract(2);
	    assertTrue(isDeleted);
	}

	@Test
	void testGetAllContract() {
		assertNotNull(contractService.getAllContract());
	}

	@Test
	void testModifyContract() {
		ContractDetails contractDetails1=new ContractDetails();
		contractDetails1.setContractNo(2);
		contractDetails1.setCustomerId(1);
		contractDetails1.setProductId(1);
		contractDetails1.setQuantity(100);
		contractDetails1.setDeliveryDate("12/12/2020");
		boolean isModified=contractService.modifyContract(contractDetails);
		assertTrue(isModified);
	}

	@Test
	void testGetSingleContract() {
	     assertNotNull(contractService.getSingleContract(1));
	}

	
	
}
