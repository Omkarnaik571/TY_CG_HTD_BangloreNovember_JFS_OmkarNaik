package com.capgemini.springrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.capgemini.springrest.dto.EmployeeBean;
import com.capgemini.springrest.exception.EmployeeException;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
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
			if(encoder.matches(password, bean.getPassword())) {
				System.out.println(password);
				return bean;
			} else {
				System.out.println("Return Null "+password);
				throw new EmployeeException("Password Invalid");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new EmployeeException("Password Invalid");
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
			throw new EmployeeException("Email alreday exists");
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

	@Override
	public boolean deleteEmployee(int id) {
		EntityManager manager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		transaction.begin();
		EmployeeBean bean=manager.find(EmployeeBean.class, id);
		if(bean != null) {
			manager.remove(bean);
			transaction.commit();
			return true;
			
		}
	    throw new EmployeeException("Employee Not Found");
	}



}
