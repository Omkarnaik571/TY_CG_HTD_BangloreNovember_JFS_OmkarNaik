package com.capgemini.jpawithhibernatejpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.*;

import com.capgemini.jpawithhibernatedto.Movie;

public class SelectAllTherecordsFromTable {
   public static void main(String[] args) {
	
	   
	   EntityManagerFactory emf=Persistence.createEntityManagerFactory("Test");
	   EntityManager em=emf.createEntityManager();
	   EntityTransaction transaction=em.getTransaction();
	  
	   transaction.begin();
	   String query=" insert into movie values (6, 'Hello', 'Hi' ) ";
	   Query result=em.createNativeQuery(query);
	   if( result.executeUpdate()>0) {
		   System.out.println("Record inserted..");
		   transaction.commit();
	   }
	
	   /*
	   String display="from Movie";
	   Query disp=em.createQuery(display);
	    List<Movie> l1=disp.getResultList();
	    
	    for (Movie m1 : l1) {
			System.out.println(m1);
			System.out.println("-------------------------------");
		}
	    
	    */
	   
	   
	   
	   
	   
	   
	   
}
	
	
	
	
	
}
