package com.capgemini.forestmanagementsystemusingspringrest.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestmanagementsystemusingspringrest.dao.ContractorDetailsDao;
import com.capgemini.forestmanagementsystemusingspringrest.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystemusingspringrest.dto.CustomerDetailsDto;
import com.capgemini.forestmanagementsystemusingspringrest.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystemusingspringrest.exception.CustomExceptions;
@Service
public class ContractorServiceImpl implements ContractService{

	@Autowired
	ContractorDetailsDao contractorDetailsDao;
	CustomerDetailsDto customerDetailsDto=new CustomerDetailsDto();
	ProductDetailsDto productDetailsDto=new ProductDetailsDto();
	@PersistenceUnit
	EntityManagerFactory emf;
	

	public List<ContractorDetailsDto> viewContractorDetails() throws CustomExceptions {
		
		return contractorDetailsDao.viewContractorDetails();
	}

	public ContractorDetailsDto viewSingleContractorDetails(ContractorDetailsDto cdd) throws CustomExceptions {
		
		return contractorDetailsDao.viewSingleContractorDetails(cdd);
	}

	public boolean deleteContractorDetails(int contractNo) throws CustomExceptions {
		
		return contractorDetailsDao.deleteContractorDetails(contractNo);
	}


	@Override
	public boolean addContractor(ContractorDetailsDto cdd) throws CustomExceptions {
		try {	
			//find customer details present or not, first
			EntityManager em=emf.createEntityManager();
		    customerDetailsDto=em.find(CustomerDetailsDto.class, cdd.getCustomerId());
			if(customerDetailsDto == null) {
				return false;
			}
			}
			catch (Exception e) {
			    throw new CustomExceptions("The customer id that you have entered does`nt exists !!");	
			}
			try {	
				//find customer details present or not, first
				EntityManager em=emf.createEntityManager();
			    productDetailsDto=em.find(ProductDetailsDto.class, cdd.getProductId());
				if(productDetailsDto == null) {
					return false;
				}
				}
				catch (Exception e) {
				    throw new CustomExceptions("The product id that you have entered does`nt exists !!");	
				}
		return contractorDetailsDao.addContractor(cdd);
	}

	@Override
	public boolean modifyContractDetails(ContractorDetailsDto contractorDetailsDto) {
		
		return contractorDetailsDao.modifyContractDetails(contractorDetailsDto);
	}


}
