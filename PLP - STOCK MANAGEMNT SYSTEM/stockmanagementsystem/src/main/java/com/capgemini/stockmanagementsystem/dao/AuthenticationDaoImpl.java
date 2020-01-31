package com.capgemini.stockmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.stockmanagementsystem.dto.AuthenticationDto;
import com.capgemini.stockmanagementsystem.exception.CustomException;

@Repository
public class AuthenticationDaoImpl implements AuthenticationDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	
	
	@Override
	public boolean addUser(AuthenticationDto authenticationDto) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
		transaction.begin();
		entityManager.persist(authenticationDto);
		transaction.commit();
		return true;
		}
		catch (Exception e) {
		     throw new CustomException("The Username that you have entered, already exists !!");
		}
	}

	@Override
	public boolean removeUser(AuthenticationDto authenticationDto) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			String jpql="delete from AuthenticationDto where userName=:uName";
			Query deleteQuery=entityManager.createQuery(jpql);
			deleteQuery.setParameter("uName", authenticationDto.getUserName());
			transaction.begin();
			 int result=deleteQuery.executeUpdate();
			transaction.commit();
	          if(result >0) {
	        	  return true;
	          }
	          else {
	        	  return false;
	          }
		}
		catch (Exception e) {
			throw new CustomException("User could`nt be deleted !!");
		}
	}

	@Override
	public boolean updateUser(AuthenticationDto authenticationDto) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
		     AuthenticationDto userInfo=entityManager.find(AuthenticationDto.class, authenticationDto.getId()); 
			 userInfo.setUserName(authenticationDto.getUserName());
			 userInfo.setPassword(authenticationDto.getPassword());
			 transaction.begin();
			 entityManager.persist(userInfo);
		     transaction.commit();
		     return true;
		}catch (Exception e) {
			throw new CustomException("Updation failed !!");
		}
		
	}

	@Override
	public AuthenticationDto verifyUser(AuthenticationDto authenticationDto) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try {
		String jpql="from AuthenticationDto where username=:uName and password=:pwd";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("uName", authenticationDto.getUserName());
		query.setParameter("pwd", authenticationDto.getPassword());
		
		AuthenticationDto result=(AuthenticationDto) query.getSingleResult();
		return result;
		}
		catch (Exception e) {
			throw new CustomException("User name and password did`nt matched !!");
		}
		
	}

	@Override
	public List<AuthenticationDto> viewAllUsers() {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try {   
		String jpql="from AuthenticationDto";
		Query query=entityManager.createQuery(jpql);
		
		List<AuthenticationDto> viewAllUsers=query.getResultList();
		return viewAllUsers;
		}
		catch (Exception e) {
			throw new CustomException("There are no users present in the database !!");
		}
	}

}
