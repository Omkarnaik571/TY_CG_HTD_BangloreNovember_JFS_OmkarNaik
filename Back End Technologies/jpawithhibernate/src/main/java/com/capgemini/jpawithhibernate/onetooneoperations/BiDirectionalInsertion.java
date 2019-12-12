package com.capgemini.jpawithhibernate.onetooneoperations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernateonetoonedto.EmployeeInfo;
import com.capgemini.jpawithhibernateonetoonedto.EmployeeOtherIfo;

public class BiDirectionalInsertion {
	 public static void main(String[] args) {
		 EntityManagerFactory emf=Persistence.createEntityManagerFactory("Test");
		  EntityManager em=emf.createEntityManager();
		  EntityTransaction transaction=em.getTransaction();
		  
		  
		  EmployeeInfo ei=new EmployeeInfo();
		  EmployeeOtherIfo eoi=new EmployeeOtherIfo();
		  
		     ei=em.find(EmployeeInfo.class, 1);
		     System.out.println("\nPan number of Emp id 1 :");
		  System.out.println(ei.getEoi().getPan());
		        
		  ei=em.find(EmployeeInfo.class, 2);
		     System.out.println("\nPan number of Emp id 2 :");
		  System.out.println(ei.getEoi().getPan());
		  
		 
		 
		 
	}
	
	

}
