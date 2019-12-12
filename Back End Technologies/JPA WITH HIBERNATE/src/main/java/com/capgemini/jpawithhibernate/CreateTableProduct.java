package com.capgemini.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernatedto.ProductDto;

public class CreateTableProduct {
public static void main(String[] args) {
	ProductDto pt=new ProductDto();
	
	pt.setId(4);
	pt.setName("Apple Watch");
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Test");
	EntityManager em=emf.createEntityManager();
	EntityTransaction transaction=em.getTransaction();
	
	/*
	transaction.begin();
	em.persist(pt);
	System.out.println("record Inserted..");
    transaction.commit();
    */
	 System.out.println("-------------------Product_Info------------------------------- ");
	for (int i = 1; i <=4; i++) {
		  pt=em.find(ProductDto.class, i);
		    System.out.println("Id : "+pt.getId());
		    System.out.println("Name : "+pt.getName());
		    System.out.println("----------------------------------------------------------------");	
	}
	
	
  
   
    
    
    
    
    
    
    
    
    
    
    
    
	
	
}
	
	
	
	
}
