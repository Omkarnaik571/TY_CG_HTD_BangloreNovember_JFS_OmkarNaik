package com.capgemini.jpawithhibernatejpql;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.jpawithhibernatedto.Movie;

public class DisplayAllTherecords {
   public static void main(String[] args) {
	   
	   Movie m1=new Movie();
	     String result="Select id from Movie";
	     String getmovie="Select name from Movie";
	   
	   EntityManagerFactory emf=Persistence.createEntityManagerFactory("Test");
	   EntityManager em=emf.createEntityManager();
	  EntityTransaction transaction=em.getTransaction();
	  
	  Query q1=em.createQuery(getmovie);
	  Query query=em.createQuery(result);
	   List<Integer> l1=query.getResultList();
	  System.out.println("The Id`s are : ");
	   for (Integer s1 : l1) {
		System.out.println(s1);
	}
	   System.out.println("\nThe Names are :\n ");
	   List<String> l2=q1.getResultList();
	   for (String s2 : l2) {
		System.out.println(s2);
	}
	   
	   
	  
	   
	 
	 
	 
	 
	   
}
	
}
