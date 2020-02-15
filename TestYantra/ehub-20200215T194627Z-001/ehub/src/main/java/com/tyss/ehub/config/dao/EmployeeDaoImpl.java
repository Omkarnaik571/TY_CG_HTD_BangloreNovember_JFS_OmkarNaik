package com.tyss.ehub.config.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.tyss.ehub.config.dto.EmpDetails;
import com.tyss.ehub.config.dto.EmployeeIdentificationDetails;
import com.tyss.ehub.config.dto.TemporaryAddress;
import com.tyss.ehub.config.exception.CustomException;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	
	
	@Override
	public boolean addEmployee(EmpDetails empDetails) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			
			EmployeeIdentificationDetails details = empDetails.getIdentification();
			details.setEmployeeDetails(empDetails);
			empDetails.setIdentification(details);
			
			ArrayList<TemporaryAddress> arr=(ArrayList<TemporaryAddress>) empDetails.getTempAddress();
			for (TemporaryAddress ta : arr) {
				ta.setEmpDetails(empDetails);
			}
			empDetails.setTempAddress(arr);
			
			
			transaction.begin();
			entityManager.persist(empDetails);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			throw new CustomException("exception at dao layer !!");
		}
	}



	@Override
	public boolean removeEmployee(EmpDetails empDetails) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			
			EmpDetails emp=entityManager.find(EmpDetails.class, empDetails.getEmpId());
			transaction.begin();
			entityManager.remove(emp);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			throw new CustomException("exception at dao layer remove method !!");
		}
		
		
	}



	@Override
	public EmpDetails findEmployee(EmpDetails empDetails) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			
			EmpDetails emp=entityManager.find(EmpDetails.class, empDetails.getEmpId());
			
			return emp;
		} catch (Exception e) {
			transaction.rollback();
			throw new CustomException("exception at dao layer remove method !!");
		}
		
		
	}

	
	
	
	
}
