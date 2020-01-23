package com.capgemini.forestmanagementsystemusingspringboot;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.forestmanagementsystemusingspringboot.dao.ContractorDetailsDao;
import com.capgemini.forestmanagementsystemusingspringboot.dto.ContractorDetailsDto;

@SpringBootTest
class ContractorDetailsDaoTest {

	@Autowired
	ContractorDetailsDao contractorDetailsDao;
	
	
		
	@Test
	void testAddContractor() {
		ContractorDetailsDto contractorDetailsDto=new ContractorDetailsDto();
		contractorDetailsDto.setContractNo(100);
		contractorDetailsDto.setCustomerId(100);
		contractorDetailsDto.setProductId(100);
		contractorDetailsDto.setDeliveryDate("12/12/2020");
		contractorDetailsDto.setContractStatus("Pending");
		boolean isAdded=contractorDetailsDao.addContractor(contractorDetailsDto);
		assertTrue(isAdded);
		contractorDetailsDao.deleteContractorDetails(contractorDetailsDto.getContractNo());
		
	}

	@Test
	void testViewContractorDetails() {
		assertNotNull(contractorDetailsDao.viewContractorDetails());
	}

	@Test
	void testViewSingleContractorDetails() {
		ContractorDetailsDto contractorDetailsDto=new ContractorDetailsDto();
		contractorDetailsDto.setContractNo(100);
		contractorDetailsDto.setCustomerId(100);
		contractorDetailsDto.setProductId(100);
		contractorDetailsDto.setDeliveryDate("12/12/2020");
		contractorDetailsDto.setContractStatus("Pending");
		boolean isFound=contractorDetailsDao.addContractor(contractorDetailsDto);
		assertTrue(isFound);
		contractorDetailsDao.deleteContractorDetails(contractorDetailsDto.getContractNo());
	}

	@Test
	void testDeleteContractorDetails() {
		ContractorDetailsDto contractorDetailsDto=new ContractorDetailsDto();
		contractorDetailsDto.setContractNo(100);
		contractorDetailsDto.setCustomerId(100);
		contractorDetailsDto.setProductId(100);
		contractorDetailsDto.setDeliveryDate("12/12/2020");
		contractorDetailsDto.setContractStatus("Pending");
	    contractorDetailsDao.addContractor(contractorDetailsDto);
	    boolean isRemoved=contractorDetailsDao.deleteContractorDetails(contractorDetailsDto.getContractNo()); 
	    assertTrue(isRemoved);
	}

	@Test
	void testModifyContractDetails() {
		ContractorDetailsDto contractorDetailsDto=new ContractorDetailsDto();
		contractorDetailsDto.setContractNo(100);
		contractorDetailsDto.setCustomerId(100);
		contractorDetailsDto.setProductId(100);
		contractorDetailsDto.setDeliveryDate("12/12/2020");
		contractorDetailsDto.setContractStatus("Pending");
	    contractorDetailsDao.addContractor(contractorDetailsDto);
	    boolean isModified=contractorDetailsDao.modifyContractDetails(contractorDetailsDto);
	    assertTrue(isModified);
	    contractorDetailsDao.deleteContractorDetails(contractorDetailsDto.getContractNo());
	    
	}

}
