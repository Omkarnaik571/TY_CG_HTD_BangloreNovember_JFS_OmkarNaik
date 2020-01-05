package com.capgemini.forestmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.dto.CustomerDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.ContractCustomException;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public class CustomerDetailsDaoImpl implements CustomerDetailsDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("forestmanagement");

	public boolean addCustomer(CustomerDetailsDto pdt) throws CustomExceptions {

		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(pdt);
			transaction.commit();
			System.out.println("\nCUSTOMER ADDED SUCCESFULLY !! \n");

		}
		catch (Exception e) {
			throw new CustomExceptions();
		}

		return true;
	}

	public List<CustomerDetailsDto> viewCustomerDetails() throws CustomExceptions {
		try {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String viewall="from CustomerDetailsDto";  
		Query query=entityManager.createQuery(viewall);
		List<CustomerDetailsDto> result= query.getResultList();
		
		return result;
		}
		catch (Exception e) {
			throw new CustomExceptions("THERE ARE NO CUSTOMER DETAILS  PRESENT IN THE DATABASE!!");
		}
	}

	public CustomerDetailsDto viewSingleCustomerDetails(CustomerDetailsDto pdt) throws CustomExceptions {
		try {
		EntityManager entityManager=entityManagerFactory.createEntityManager();	
		CustomerDetailsDto pdd=entityManager.find(CustomerDetailsDto.class, pdt.getCustomerId());
		return pdd;
		}
		catch (Exception e) {
			throw new CustomExceptions("THERE CUSTOMER ID THAT YOU HAVE ENTERED IS NOT PRESENT IN THE DATABASE!!");
		}
		
}

	public boolean deleteCustomerDetails(CustomerDetailsDto pdt) throws CustomExceptions {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			CustomerDetailsDto pddto=entityManager.find(CustomerDetailsDto.class, pdt.getCustomerId());
			entityManager.remove(pddto);
			transaction.commit();
			System.out.println("\nCUSTOMER DELETED SUCCESFULLY !! \n");
		}
		catch (Exception e) {
			throw new CustomExceptions("THERE CUSTOMER ID THAT YOU HAVE ENTERED IS NOT PRESENT IN THE DATABASE!!");
			// TODO: handle exception
		}


		return true;

	}

	public boolean modifyCustomerDetails(CustomerDetailsDto pdt, int choice) throws CustomExceptions {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		switch (choice) {
		case 1:
			//Street address 1
			try {
				transaction.begin();
				CustomerDetailsDto pddto=entityManager.find(CustomerDetailsDto.class, pdt.getCustomerId());
				pddto.setStreetAddress1(pdt.getStreetAddress1());
				entityManager.persist(pddto);
				System.out.println("\nStreet Address 1 modified successfully !!\n");
				transaction.commit();
				
				}
				catch (Exception e) {
					throw new CustomExceptions("THE CUSTOMER ID THAT YOU HAVE ENTERED IS NOT PRESENT IN THE DATABASE!!");
				}
			
			break;
		case 2:
			//Street address 2
			try {
				transaction.begin();
				CustomerDetailsDto pddto=entityManager.find(CustomerDetailsDto.class, pdt.getCustomerId());
				pddto.setStreetAddress2(pdt.getStreetAddress2());
				entityManager.persist(pddto);
				System.out.println("\nStreet Address 2 modified successfully !!\n");
				transaction.commit();
				
				}
				catch (Exception e) {
					throw new CustomExceptions("THE CUSTOMER ID THAT YOU HAVE ENTERED IS NOT PRESENT IN THE DATABASE!!");
				}
			break;
		case 3:
          //town
			try {
				transaction.begin();
				CustomerDetailsDto pddto=entityManager.find(CustomerDetailsDto.class, pdt.getCustomerId());
				pddto.setTown(pdt.getTown());
				entityManager.persist(pddto);
				System.out.println("\nTown modified successfully !!\n");
				transaction.commit();
				
				}
				catch (Exception e) {
					throw new CustomExceptions("THE CUSTOMER ID THAT YOU HAVE ENTERED IS NOT PRESENT IN THE DATABASE!!");
				}
			break;
		case 4:
          //postal code
			try {
				transaction.begin();
				CustomerDetailsDto pddto=entityManager.find(CustomerDetailsDto.class, pdt.getCustomerId());
				pddto.setPostalCode(pdt.getPostalCode());
				entityManager.persist(pddto);
				System.out.println("\nPostal Code modified successfully !!\n");
				transaction.commit();
				
				}
				catch (Exception e) {
					throw new CustomExceptions("THE CUSTOMER ID THAT YOU HAVE ENTERED IS NOT PRESENT IN THE DATABASE!!");
				}
			break;
		case 5:
           //email
			try {
				transaction.begin();
				CustomerDetailsDto pddto=entityManager.find(CustomerDetailsDto.class, pdt.getCustomerId());
				pddto.setEmail(pdt.getEmail());
				entityManager.persist(pddto);
				System.out.println("\nE-mail modified successfully !!\n");
				transaction.commit();
				
				}
				catch (Exception e) {
					throw new CustomExceptions("THE CUSTOMER ID THAT YOU HAVE ENTERED IS NOT PRESENT IN THE DATABASE!!");
				}
			break;
		case 6:
          //telephone number
			try {
				transaction.begin();
				CustomerDetailsDto pddto=entityManager.find(CustomerDetailsDto.class, pdt.getCustomerId());
				pddto.setTelephoneNo(pdt.getTelephoneNo());
				entityManager.persist(pddto);
				System.out.println("\nTelephone number modified successfully !!\n");
				transaction.commit();
				
				}
				catch (Exception e) {
					throw new CustomExceptions("THE CUSTOMER ID THAT YOU HAVE ENTERED IS NOT PRESENT IN THE DATABASE!!");
				}
			
			break;
		default:
			break;
		}

		return true;
	}






}
