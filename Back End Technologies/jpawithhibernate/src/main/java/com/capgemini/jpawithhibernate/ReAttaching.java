package com.capgemini.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernatedto.Movie;
import com.capgemini.jpawithhibernatedto.ProductDto;

public class ReAttaching {
 public static void main(String[] args) {
	 
	 ProductDto pt=new ProductDto();
	 
	 EntityManagerFactory emf=Persistence.createEntityManagerFactory("Test");
		EntityManager em=emf.createEntityManager();
		EntityTransaction transaction=em.getTransaction();
	 
	     pt=em.find(ProductDto.class, 2);
	     
	     System.out.println(em.contains(pt)); 
	     transaction.begin();
	     pt.setName("i pod");
	     System.out.println("Record Updated..");
		transaction.commit();
		
	     em.detach(pt);
		System.out.println("Object Detached");
		System.out.println(em.contains(pt));
	   transaction.begin();
		ProductDto pt1=em.merge(pt);
	    pt1.setName("Apple tv");
	    transaction.commit();
	   System.out.println("Record Updated..");
}
	
	
	
}
