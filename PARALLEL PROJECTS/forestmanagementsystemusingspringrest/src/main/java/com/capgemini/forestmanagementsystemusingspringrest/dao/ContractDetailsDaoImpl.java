package com.capgemini.forestmanagementsystemusingspringrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capgemini.forestmanagementsystemusingspringrest.dto.ContractResponse;
import com.capgemini.forestmanagementsystemusingspringrest.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystemusingspringrest.dto.CustomerDetailsDto;
import com.capgemini.forestmanagementsystemusingspringrest.dto.LandResponse;
import com.capgemini.forestmanagementsystemusingspringrest.exception.ContractCustomException;
import com.capgemini.forestmanagementsystemusingspringrest.exception.CustomExceptions;
@Repository
public class ContractDetailsDaoImpl implements ContractorDetailsDao {
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	public boolean addContractor(ContractorDetailsDto pdt) throws CustomExceptions {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(pdt);
			transaction.commit();
		}
		catch (Exception e) {
			throw new CustomExceptions("The contract number that you have entered already exists !!");
		}

		return true;
	}//end of add contractor



	
	
	

	public List<ContractorDetailsDto> viewContractorDetails() throws CustomExceptions {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String viewall="from ContractorDetailsDto";  
		Query query=entityManager.createQuery(viewall);
		try {
		List<ContractorDetailsDto> result= query.getResultList();
		return result;
		}
		catch (Exception e) {
			throw new CustomExceptions("\nThere are no contract details present in the database !!\n");
		}

		
	}//end of view all contractor



	public ContractorDetailsDto viewSingleContractorDetails(ContractorDetailsDto pdt) throws CustomExceptions {
		EntityManager entityManager=entityManagerFactory.createEntityManager();	
		try {
		ContractorDetailsDto pdd=entityManager.find(ContractorDetailsDto.class,pdt.getContractNo() );
		return pdd;
		}
		catch (Exception e) {
			throw new CustomExceptions("The contract number that you have ebtered doesn`t exists !!");
		}
	}//end of view single contractor




	public boolean deleteContractorDetails(int contractNo) throws CustomExceptions {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			ContractorDetailsDto pddto=entityManager.find(ContractorDetailsDto.class, contractNo);
			entityManager.remove(pddto);
			transaction.commit();
		}
		catch (Exception e) {
			throw new CustomExceptions("THE CONTRCAT NO THAT YOU HAVE ENTERED IS NOT PRESENT  ");
			// TODO: handle exception
		}
		return true;
	}//end of delete contractor


	


	public boolean modifyContractDetails(ContractorDetailsDto contractorDetailsDto) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			ContractorDetailsDto pddto=entityManager.find(ContractorDetailsDto.class, contractorDetailsDto.getContractNo());
			pddto.setQuantity(contractorDetailsDto.getQuantity());
			pddto.setDeliveryDate(contractorDetailsDto.getDeliveryDate());
			pddto.setDeliveryDate(contractorDetailsDto.getDeliveryDate());
			pddto.setContractStatus(contractorDetailsDto.getContractStatus());
			entityManager.persist(pddto);
			transaction.commit();
		}
		catch (Exception e) {
			throw new CustomExceptions("THE CONTRACT NUMBER THAT YOU HAVE ENTERED IS NOT PRESENT !! ");
		}
		return true;
	}
	
	
	
	










}
