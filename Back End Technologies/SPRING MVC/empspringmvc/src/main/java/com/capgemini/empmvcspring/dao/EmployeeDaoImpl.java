package com.capgemini.empmvcspring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.capgemini.empmvcspring.bean.EmployeeBean;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@PersistenceUnit
   private	EntityManagerFactory entityManagerFactory;
	 
	
	
	@Override
	public EmployeeBean authenticate(String email, String password) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		String jpql="from EmployeeBean where email=:email";
		TypedQuery<EmployeeBean> query=entityManager.createQuery(jpql,EmployeeBean.class);
		query.setParameter("email", email);
//		query.setParameter("password", password);
		try {
		EmployeeBean bean=query.getSingleResult();
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		if(encoder.matches(password, bean.getPassword())) {
			
			return bean;
		} else {
			return null;
		}
		}
		catch (Exception e) {
			return null;
			// TODO: handle exception
		}

	}

	@Override
	public boolean register(EmployeeBean bean) {
		EntityManager manager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		try {
		manager.persist(bean);
		transaction.commit();
		return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
/*
	@Override
	public EmployeeBean getEmployee(String email) {
		EntityManager manager=entityManagerFactory.createEntityManager();
		String jpql="from EmployeeBean where email=:email and password=:password";
		TypedQuery<EmployeeBean> query=manager.createQuery(jpql,EmployeeBean.class);
		query.setParameter("email", email);
		try {
			return query.getSingleResult();
		}
		catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	*/

	@Override
	public List<EmployeeBean> getAllEmployees(String key) {
		EntityManager manager=entityManagerFactory.createEntityManager();
		String jpql="from EmployeeBean where name=:name or email=:email";
		TypedQuery<EmployeeBean> query=manager.createQuery(jpql,EmployeeBean.class);
		query.setParameter("name", key);
		query.setParameter("email", key);
			return query.getResultList();
			
	}
	
	

	@Override
	public boolean changePassword(int id, String password) {
		EntityManager manager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		transaction.begin();
		EmployeeBean bean=manager.find(EmployeeBean.class, id);
		bean.setPassword(password);
		transaction.commit();
		
		return true;
	}
	
	

}
