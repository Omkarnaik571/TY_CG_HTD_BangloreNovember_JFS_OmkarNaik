package com.capgemini.forestmanagementsystem.service;

import java.util.List;

import com.capgemini.forestmanagementsystem.dao.ContractDetailsDaoImpl;
import com.capgemini.forestmanagementsystem.dao.ContractorDetailsDao;
import com.capgemini.forestmanagementsystem.dao.ProductDetailsDaoImpl;
import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.ContractCustomException;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public class ContractorServiceImpl implements ContractService{

	ContractorDetailsDao dao=new ContractDetailsDaoImpl();
	
	public boolean addContractor(ContractorDetailsDto cdd) throws ContractCustomException {
		
		return dao.addContractor(cdd);
	}

	public List<ContractorDetailsDto> viewContractorDetails() throws CustomExceptions {
		
		return dao.viewContractorDetails();
	}

	public ContractorDetailsDto viewSingleContractorDetails(ContractorDetailsDto cdd) throws CustomExceptions {
		
		return dao.viewSingleContractorDetails(cdd);
	}

	public boolean deleteContractorDetails(ContractorDetailsDto cdd) throws CustomExceptions {
		
		return dao.deleteContractorDetails(cdd);
	}

	public boolean modifyContractorDetails(ContractorDetailsDto cdd, int cno) throws CustomExceptions {

		return dao.modifyContractorDetails(cdd, cno);
	}

}
