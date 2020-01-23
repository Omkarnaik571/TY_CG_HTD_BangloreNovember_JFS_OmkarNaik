package com.capgemini.forestmanagementsystemusingspringboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.forestmanagementsystemusingspringboot.dto.CustomerDetailsDto;
import com.capgemini.forestmanagementsystemusingspringboot.exception.CustomExceptions;
@Repository
public class CustomerDetailsDaoImpl implements CustomerDetailsDao {
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	public boolean addCustomer(CustomerDetailsDto pdt) throws CustomExceptions {

		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(pdt);
			transaction.commit();
		}
		catch (Exception e) {
			throw new CustomExceptions("The Customer Id that you have entered, already exists !!");
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

	public boolean deleteCustomerDetails(int customerId) throws CustomExceptions {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			CustomerDetailsDto pddto=entityManager.find(CustomerDetailsDto.class, customerId);
			entityManager.remove(pddto);
			transaction.commit();
		}
		catch (Exception e) {
			throw new CustomExceptions("THERE CUSTOMER ID THAT YOU HAVE ENTERED IS NOT PRESENT IN THE DATABASE!!");
		}
		return true;
	}

	
	
	
	public boolean modifyCustomerDetails(CustomerDetailsDto pdt) throws CustomExceptions {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
		CustomerDetailsDto customerDetailsDto=entityManager.find(CustomerDetailsDto.class, pdt.getCustomerId());
		customerDetailsDto.setEmail(pdt.getEmail());
		customerDetailsDto.setPostalCode(pdt.getPostalCode());
		customerDetailsDto.setStreetAddress1(pdt.getStreetAddress1());
		customerDetailsDto.setStreetAddress2(pdt.getStreetAddress2());
		customerDetailsDto.setTelephoneNo(pdt.getTelephoneNo());
		customerDetailsDto.setTown(pdt.getTown());
		entityManager.persist(customerDetailsDto);
		transaction.commit();
		return true;
		}
		catch (Exception e) {
			throw new CustomExceptions("THERE CUSTOMER ID THAT YOU HAVE ENTERED IS NOT PRESENT IN THE DATABASE!!");
		}

	}






}
