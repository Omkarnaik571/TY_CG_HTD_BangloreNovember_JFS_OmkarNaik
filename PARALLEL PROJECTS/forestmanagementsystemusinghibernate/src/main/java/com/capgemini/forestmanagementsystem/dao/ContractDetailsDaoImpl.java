package com.capgemini.forestmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.ContractCustomException;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public class ContractDetailsDaoImpl implements ContractorDetailsDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("forestmanagement");

	public boolean addContractor(ContractorDetailsDto pdt) throws ContractCustomException {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(pdt);
			transaction.commit();
			System.out.println("\nCONTRACT ADDED SUCCESFULLY !! \n");

		}
		catch (Exception e) {

			throw new ContractCustomException();
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




	public boolean deleteContractorDetails(ContractorDetailsDto pdt) throws CustomExceptions {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			ContractorDetailsDto pddto=entityManager.find(ContractorDetailsDto.class, pdt.getContractNo());
			entityManager.remove(pddto);
			transaction.commit();
			System.out.println("\nCONTRACT DELETED SUCCESFULLY !! \n");
			return true;
		}
		catch (Exception e) {
			throw new CustomExceptions("THE CONTRCAT NO THAT YOU HAVE ENTERED IS NOT PRESENT  ");
			// TODO: handle exception
		}
	}//end of delete contractor


	public boolean modifyContractorDetails(ContractorDetailsDto pdt, int cno) throws CustomExceptions {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		switch (cno) {
		case 1:
			//d date
			try {
				transaction.begin();
				ContractorDetailsDto pddto=entityManager.find(ContractorDetailsDto.class, pdt.getContractNo());
				pddto.setDeliveryDate(pdt.getDeliveryDate());
				entityManager.persist(pddto);
				System.out.println("\nDelivery date modified successfully !!\n");
				transaction.commit();
			}
			catch (Exception e) {
				throw new CustomExceptions("THE CONTRACT NUMBER THAT YOU HAVE ENTERED IS NOT PRESENT !! ");
			}

			break;
		case 2:
			//quantity
			try {
				transaction.begin();
				ContractorDetailsDto pddto=entityManager.find(ContractorDetailsDto.class, pdt.getContractNo());
				pddto.setQuantity(pdt.getQuantity());
				entityManager.persist(pddto);
				System.out.println("\nQuantity modified successfully !!\n");
				transaction.commit();
			}
			catch (Exception e) {
				throw new CustomExceptions("THE CONTRACT NUMBER THAT YOU HAVE ENTERED IS NOT PRESENT !! ");
			}

			break;
		case 3:
			//quantity
			try {
				transaction.begin();
				ContractorDetailsDto pddto=entityManager.find(ContractorDetailsDto.class, pdt.getContractNo());
				pddto.setContractStatus(pdt.getContractStatus());
				entityManager.persist(pddto);
				System.out.println("\nContract Status modified successfully !!\n");
				transaction.commit();
			}
			catch (Exception e) {
				throw new CustomExceptions("THE CONTRACT NUMBER THAT YOU HAVE ENTERED IS NOT PRESENT !! ");
			}

			break;
		default:
			break;
		}

		return true;
	}//end of modify contractor













}
