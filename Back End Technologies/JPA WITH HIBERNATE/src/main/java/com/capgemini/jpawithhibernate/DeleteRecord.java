package com.capgemini.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernatedto.Movie;

public class DeleteRecord {
  public static void main(String[] args) {
	    Movie m1=new Movie();
	    
	    EntityManagerFactory emf=Persistence.createEntityManagerFactory("Test");
	    EntityManager em=emf.createEntityManager();
	    EntityTransaction transaction=em.getTransaction();
	    
	    m1=em.find(Movie.class, 5);
	    transaction.begin();
	   em.remove(m1);
	    System.out.println("Record Deleted..");
	    transaction.commit();
	    
	    
	    
	  
	  
	  
	  
}
	
	
	
}
