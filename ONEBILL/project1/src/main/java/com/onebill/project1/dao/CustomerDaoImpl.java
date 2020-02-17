package com.onebill.project1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.onebill.project1.dto.Customer;
import com.onebill.project1.exception.CustomException;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	@Override
	public int addCustomer(Customer customer) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(customer);
			transaction.commit();
			
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("Enter a different email id`s");
		}
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer viewCustomer(Customer customer) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			Customer customerFound=entityManager.find(Customer.class, customer.getCustomerId());
			
			return customerFound;
		}catch (Exception e) {
			throw new CustomException("Error while retriving values from customer dao");
		}
		
	}

	
	
	
	
}
