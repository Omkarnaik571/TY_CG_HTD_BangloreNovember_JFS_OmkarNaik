package com.capgemini.moduletesttwo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.moduletesttwo.dto.ProductInfo;
import com.capgemini.moduletesttwo.dto.UserInfo;
import com.capgemini.moduletesttwo.exception.CustomExceptions;

@Repository
public class UserDaoImpl implements UserDao{

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	
	
	public boolean addUser(UserInfo userInfo) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
		transaction.begin();
		entityManager.persist(userInfo);
		transaction.commit();
		}
		catch (Exception e) {
			throw new CustomExceptions("duplicate email id");
		}
		
		return true;
	}
	
	
	public UserInfo authenticateUser(UserInfo userInfo) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try {
		String jpql="from UserInfo where email=:email and password=:pwd";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("email", userInfo.getEmail());
		query.setParameter("pwd", userInfo.getPassword());
		
		UserInfo usInfo=(UserInfo)query.getSingleResult();
		if(usInfo!=null) {
			return usInfo;
		}
		}
		catch (Exception e) {
			throw new CustomExceptions("Email and password does`nt match !!");
		}
		
		
		return null;
	}


	@Override
	public UserInfo modifyUser(String email, String oldPwd, String newPwd) {
		
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
		String jpql="from UserInfo where email=:email and password=:pwd";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("email", email);
		query.setParameter("pwd", oldPwd);
		UserInfo usInfo=(UserInfo)query.getSingleResult();
		if(usInfo!=null) {
			usInfo.setPassword(newPwd);
			transaction.begin();
			entityManager.persist(usInfo);
			transaction.commit();
			return usInfo;
		}
		}
		catch (Exception e) {
			throw new CustomExceptions("Email and password does`nt match !!");
		}
		return null;
	}


	@Override
	public boolean addProduct(ProductInfo productInfo) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
		transaction.begin();
		entityManager.persist(productInfo);
		transaction.commit();
		}
		catch (Exception e) {
			throw new CustomExceptions("duplicate product id");
		}
		
		return true;
	}


	public ProductInfo searchProduct(int productId) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try {
		ProductInfo prInfo=entityManager.find(ProductInfo.class, productId);
		
		if(prInfo!=null) {
			return prInfo;
		}
		}
		catch (Exception e) {
			throw new CustomExceptions("Product Id does`nt exists !!");
		}
		
		
		return null;
	}

	
	public int duesPending(String userName,String password) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
		String jpql="from UserInfo where email=:email and password=:pwd";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("email", userName);
		query.setParameter("pwd", password);
		UserInfo usInfo=(UserInfo)query.getSingleResult();
		if(usInfo!=null) {
		    String cost="from ProductInfo where id=:id"; 
			Query query2=entityManager.createQuery(cost);	
		}
		}
		catch (Exception e) {
			throw new CustomExceptions("Email and password does`nt match !!");
		}

		return 0;
	}
	
	
	
	
	
	
	
}
