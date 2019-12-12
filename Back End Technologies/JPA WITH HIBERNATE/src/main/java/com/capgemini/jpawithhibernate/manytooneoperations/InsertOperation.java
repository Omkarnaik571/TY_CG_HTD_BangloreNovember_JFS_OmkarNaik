
package com.capgemini.jpawithhibernate.manytooneoperations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernatemanytoonedto.EmployeeExperince;
import com.capgemini.jpawithhibernateonetoonedto.EmployeeInfo;

public class InsertOperation {
  public static void main(String[] args) {
	  EntityManagerFactory emf=Persistence.createEntityManagerFactory("Test");
	  EntityManager em=emf.createEntityManager();
	  EntityTransaction transaction=em.getTransaction();
	  
	  EmployeeInfo ei=new EmployeeInfo();
	  ei.setEid(5);
	  ei.setName("rahul");
	  ei.setEmail("rahul571@");
	  ei.setPassword("rahul@123");
	  
	  

	  EmployeeExperince ex1=new EmployeeExperince();
	  ex1.setExpid(14);
	  ex1.setCompanyname("Oracle");
	  ex1.setDuration(2);
	  ex1.setEi(ei);
	  
	  
	  EmployeeExperince ex=new EmployeeExperince();
	  ex.setExpid(15);
	  ex.setCompanyname("Goldman sachs");
	  ex.setDuration(2);
	  ex.setEi(ei);
	  
	  transaction.begin();
	  em.persist(ex1);
	  em.persist(ex);
	  transaction.commit();
	  System.out.println("\nrecord insrted..");
	  
}
	
	
	
}
