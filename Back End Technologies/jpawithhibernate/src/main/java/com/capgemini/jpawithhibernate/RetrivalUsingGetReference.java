package com.capgemini.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernatedto.Movie;

public class RetrivalUsingGetReference {
  public static void main(String[] args) {
	   Movie m1=new Movie();
	   
	   EntityManagerFactory emf=Persistence.createEntityManagerFactory("Test");
	  EntityManager em=emf.createEntityManager();
	  
	  
	   m1=em.getReference(Movie.class, 3);
	   System.out.println("\n------------------------------------------------------");
	  System.out.println("Id : "+m1.getId());
	   System.out.println("Name : "+m1.getName());
	   System.out.println("Rating : "+m1.getRating());
	  System.out.println("-------------------------------------------------------------");
	  
	  System.out.println();
	  
	  
	  
}
	
	
	
	
	
}
