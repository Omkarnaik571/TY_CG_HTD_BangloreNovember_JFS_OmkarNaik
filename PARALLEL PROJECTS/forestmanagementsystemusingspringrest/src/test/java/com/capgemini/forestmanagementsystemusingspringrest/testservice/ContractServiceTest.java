package com.capgemini.forestmanagementsystemusingspringrest.testservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestmanagementsystemusingspringrest.config.OrmConfig;
import com.capgemini.forestmanagementsystemusingspringrest.dao.ContractorDetailsDao;
import com.capgemini.forestmanagementsystemusingspringrest.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystemusingspringrest.service.ContractService;
import com.capgemini.forestmanagementsystemusingspringrest.testconfig.TestBeans;

@SpringJUnitConfig(classes = { TestBeans.class, OrmConfig.class })
class ContractServiceTest {

	
	@Autowired
	ContractService contractService;
	
	
		
	@Test
	void testAddContractor() {
		ContractorDetailsDto contractorDetailsDto=new ContractorDetailsDto();
		contractorDetailsDto.setContractNo(100);
		contractorDetailsDto.setCustomerId(1);
		contractorDetailsDto.setProductId(1);
		contractorDetailsDto.setDeliveryDate("12/12/2020");
		contractorDetailsDto.setContractStatus("Pending");
		boolean isAdded=contractService.addContractor(contractorDetailsDto);
		assertTrue(isAdded);
		contractService.deleteContractorDetails(contractorDetailsDto.getContractNo());
		
	}

	@Test
	void testViewContractorDetails() {
		assertNotNull(contractService.viewContractorDetails());
	}

	@Test
	void testViewSingleContractorDetails() {
		ContractorDetailsDto contractorDetailsDto=new ContractorDetailsDto();
		contractorDetailsDto.setContractNo(100);
		contractorDetailsDto.setCustomerId(1);
		contractorDetailsDto.setProductId(1);
		contractorDetailsDto.setDeliveryDate("12/12/2020");
		contractorDetailsDto.setContractStatus("Pending");
		boolean isFound=contractService.addContractor(contractorDetailsDto);
		assertTrue(isFound);
		contractService.deleteContractorDetails(contractorDetailsDto.getContractNo());
	}

	@Test
	void testDeleteContractorDetails() {
		ContractorDetailsDto contractorDetailsDto=new ContractorDetailsDto();
		contractorDetailsDto.setContractNo(100);
		contractorDetailsDto.setCustomerId(1);
		contractorDetailsDto.setProductId(1);
		contractorDetailsDto.setDeliveryDate("12/12/2020");
		contractorDetailsDto.setContractStatus("Pending");
	    contractService.addContractor(contractorDetailsDto);
	    boolean isRemoved=contractService.deleteContractorDetails(contractorDetailsDto.getContractNo()); 
	    assertTrue(isRemoved);
	}

	@Test
	void testModifyContractDetails() {
		ContractorDetailsDto contractorDetailsDto=new ContractorDetailsDto();
		contractorDetailsDto.setContractNo(100);
		contractorDetailsDto.setCustomerId(1);
		contractorDetailsDto.setProductId(1);
		contractorDetailsDto.setDeliveryDate("12/12/2020");
		contractorDetailsDto.setContractStatus("Pending");
	    contractService.addContractor(contractorDetailsDto);
	    boolean isModified=contractService.modifyContractDetails(contractorDetailsDto);
	    assertTrue(isModified);
	    contractService.deleteContractorDetails(contractorDetailsDto.getContractNo());
	    
	}

	
	
	
	

}
