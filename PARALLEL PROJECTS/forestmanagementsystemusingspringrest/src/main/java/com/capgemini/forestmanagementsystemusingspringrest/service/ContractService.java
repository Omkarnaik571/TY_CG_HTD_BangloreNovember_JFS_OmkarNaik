package com.capgemini.forestmanagementsystemusingspringrest.service;

import java.util.List;

import com.capgemini.forestmanagementsystemusingspringrest.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystemusingspringrest.exception.ContractCustomException;
import com.capgemini.forestmanagementsystemusingspringrest.exception.CustomExceptions;

public interface ContractService {

	 //1. add a Contractor
	public boolean addContractor(ContractorDetailsDto cdd ) throws CustomExceptions;
//2. View all the Contractor detail
	public List<ContractorDetailsDto> viewContractorDetails() throws CustomExceptions;
//3. View single Contractor detail
	public ContractorDetailsDto viewSingleContractorDetails(ContractorDetailsDto cdd ) throws CustomExceptions;
//4. delete a Contractor detail	
	public boolean deleteContractorDetails(int contractNo ) throws CustomExceptions;
//5. Modify a Contractor detail	
	public boolean modifyContractDetails(ContractorDetailsDto contractorDetailsDto);	
	
}
