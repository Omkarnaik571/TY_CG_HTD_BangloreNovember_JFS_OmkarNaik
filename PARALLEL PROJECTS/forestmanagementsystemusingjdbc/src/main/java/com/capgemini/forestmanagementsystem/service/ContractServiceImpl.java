package com.capgemini.forestmanagementsystem.service;

import java.util.List;

import com.capgemini.forestmanagementsystem.dao.ContractorDetailsDao;
import com.capgemini.forestmanagementsystem.dao.ContractorDetailsDaoImpl;
import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public class ContractServiceImpl implements ContractService {

	ContractorDetailsDao dao = new ContractorDetailsDaoImpl();

	@Override
	public boolean addContractor(ContractorDetailsDto cdd) throws CustomExceptions {
		
		return dao.addContractor(cdd);
	}

	@Override
	public List<ContractorDetailsDto> viewContractorDetails() throws CustomExceptions {
		
		return dao.viewContractorDetails();
	}

	@Override
	public ContractorDetailsDto viewSingleContractorDetails(ContractorDetailsDto cdd) throws CustomExceptions {
		
		return dao.viewSingleContractorDetails(cdd);
	}

	@Override
	public boolean deleteContractorDetails(ContractorDetailsDto cdd) throws CustomExceptions {
		
		return dao.deleteContractorDetails(cdd);
	}

	@Override
	public boolean modifyContractorDetails(ContractorDetailsDto cdd, int cno) throws CustomExceptions {
		
		return dao.modifyContractorDetails(cdd, cno);
	}

}
