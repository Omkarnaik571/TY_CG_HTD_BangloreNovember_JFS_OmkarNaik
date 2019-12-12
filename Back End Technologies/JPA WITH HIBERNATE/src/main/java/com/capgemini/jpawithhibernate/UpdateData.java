package com.capgemini.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernatedto.Movie;

public class UpdateData {
   public static void main(String[] args) {
	   
	Movie m1=new Movie();
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("Test");
	EntityManager em=emf.createEntityManager();
	EntityTransaction transaction=em.getTransaction();
	
	m1=em.find(Movie.class, 1);
	System.out.println(" --------------------------Data Are---------------------");
	System.out.println("Id = "+m1.getId());
	System.out.println("Name = "+m1.getName());
	System.out.println("Rating = "+m1.getRating());
	System.out.println("----------------------------------------------------------------");
	transaction.begin();
	m1.setName("The Imitation Game");
	System.out.println("\nUpdation completed Successfully....");
	transaction.commit();
	System.out.println("\n--------------------------After Updation---------------------");
	System.out.println("Id = "+m1.getId());
	System.out.println("Name = "+m1.getName());
	System.out.println("Rating = "+m1.getRating());
	
	
	
	   
}
	
	
	
	
}
