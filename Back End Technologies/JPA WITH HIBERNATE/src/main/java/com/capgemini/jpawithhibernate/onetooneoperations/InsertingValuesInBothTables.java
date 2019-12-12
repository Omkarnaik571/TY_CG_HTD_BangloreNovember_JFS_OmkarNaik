package com.capgemini.jpawithhibernate.onetooneoperations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernateonetoonedto.EmployeeInfo;
import com.capgemini.jpawithhibernateonetoonedto.EmployeeOtherIfo;

public class InsertingValuesInBothTables {

	  public static void main(String[] args) {
		
		  EntityManagerFactory emf=Persistence.createEntityManagerFactory("Test");
		  EntityManager em=emf.createEntityManager();
		  EntityTransaction transaction=em.getTransaction();
		  
		  EmployeeInfo ei=new EmployeeInfo();
		  ei.setEid(2);
		  ei.setName("Aaryan");
		  ei.setEmail("aaryan571@");
		  ei.setPassword("aarya@123");
		  
		  EmployeeOtherIfo eoi=new EmployeeOtherIfo();
		  eoi.setId(14);
		  eoi.setPan("Ax394gf");
		  eoi.setFname("Dilip");
		  eoi.setMname("Basanti");
		  eoi.setEnf(ei);
		 
		  
		  transaction.begin();
		  em.persist(eoi);
		  transaction.commit();
		  System.out.println("\nRecord added successfully ..");
		  
		  
	}
	
	
	
	
}
