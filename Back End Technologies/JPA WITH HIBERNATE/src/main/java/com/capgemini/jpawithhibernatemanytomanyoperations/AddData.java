package com.capgemini.jpawithhibernatemanytomanyoperations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernate.mamytomanydto.TrainingInfo;
import com.capgemini.jpawithhibernateonetoonedto.EmployeeInfo;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class AddData {
   public static void main(String[] args) {
	
	   EntityManagerFactory emf=Persistence.createEntityManagerFactory("Test");
		  EntityManager em=emf.createEntityManager();
		  EntityTransaction transaction=em.getTransaction();
		  
		  EmployeeInfo ei=new EmployeeInfo();
		  ei.setEid(10);
		  ei.setName("Ram");
		  ei.setEmail("ram571@");
		  ei.setPassword("ra,@123");
	   
		  EmployeeInfo ei2=new EmployeeInfo();
		  ei2.setEid(11);
		  ei2.setName("Shyam");
		  ei2.setEmail("shyam571@");
		  ei2.setPassword("shyam@123");
		 
		  ArrayList<EmployeeInfo> a1=new ArrayList<EmployeeInfo>();
		  
		  a1.add(ei);
		  a1.add(ei2);
		  
		  TrainingInfo ti=new TrainingInfo();
		  ti.setTid(102);
		  ti.setTname("Java Fstc");
		  ti.setElist(a1);
		  
		 transaction.begin(); 
		 em.persist(ti);
		 transaction.commit();
		 System.out.println("\nRecord inserted successfully..");
		  
		  
		  
		  
	   
}
	
	
	
	
}
