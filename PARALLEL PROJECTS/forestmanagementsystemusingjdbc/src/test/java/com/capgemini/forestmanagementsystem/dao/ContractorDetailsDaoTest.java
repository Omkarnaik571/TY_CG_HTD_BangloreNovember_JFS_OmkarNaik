package com.capgemini.forestmanagementsystem.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;

class ContractorDetailsDaoTest {

	static ContractorDetailsDao contractorDao = new ContractorDetailsDaoImpl();
	static ContractorDetailsDto contractorDetailsDto = new ContractorDetailsDto();
     static ContractorDetailsDto contractorDetailsDto2 = new ContractorDetailsDto();
     
	@BeforeAll
	static void testAddContractor() {
		contractorDetailsDto.setContractNo(44);
		contractorDetailsDto.setCustomerId(1);
		contractorDetailsDto.setProductId(1);
		contractorDetailsDto.setDeliveryDate("12/12/2020");
		contractorDetailsDto.setQuantity("123");
		contractorDao.addContractor(contractorDetailsDto);
		
	}
	
	
	@AfterAll
	 static void delete() {
		contractorDao.deleteContractorDetails(contractorDetailsDto); 
	     contractorDao.deleteContractorDetails(contractorDetailsDto2);
	}

	
	
	@Test
	void testAddContractor1() {
		contractorDetailsDto2.setContractNo(46);
		contractorDetailsDto2.setCustomerId(1);
		contractorDetailsDto2.setProductId(1);
		contractorDetailsDto2.setDeliveryDate("12/12/2020");
		contractorDetailsDto2.setQuantity("123");
		boolean isadded = contractorDao.addContractor(contractorDetailsDto2);
		assertTrue(isadded);
	}
      
	@Test
	void testDeleteContractorDetails() {
		ContractorDetailsDto contractorDetailsDto1=new ContractorDetailsDto();
		contractorDetailsDto1.setContractNo(47);
		contractorDetailsDto1.setCustomerId(1);
		contractorDetailsDto1.setProductId(1);
		contractorDetailsDto1.setDeliveryDate("12/12/2020");
		contractorDetailsDto1.setQuantity("123");
		contractorDao.addContractor(contractorDetailsDto1);
		
		   boolean isDeleted=contractorDao.deleteContractorDetails(contractorDetailsDto1);
		assertTrue(isDeleted);
	}
	
	
	@Test
	void testViewContractorDetails() {
		assertNotNull(contractorDao.viewContractorDetails());
	}

	@Test
	void testViewSingleContractorDetails() {
		assertNotNull(contractorDao.viewSingleContractorDetails(contractorDetailsDto));
	}

	

	@Test
	void testModifyContractorDetails() {
		boolean isModified=contractorDao.modifyContractorDetails(contractorDetailsDto,1);
	    assertTrue(isModified);
	}

}
