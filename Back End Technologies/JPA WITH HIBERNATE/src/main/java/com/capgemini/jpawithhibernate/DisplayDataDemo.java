package com.capgemini.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.jpawithhibernatedto.Movie;

public class DisplayDataDemo {
	public static void main(String[] args) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		
		
		emf=Persistence.createEntityManagerFactory("Test");
		em=emf.createEntityManager();
		
		Movie m=em.find(Movie.class, 3);
		System.out.println("\n----------------------------------------------");
		System.out.println("Movie Id --> "+m.getId());
		System.out.println("Movie Name --> "+m.getName());
		System.out.println("Movie Rating --> "+m.getRating());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		
		/*
		for (int i = 1; i <=5; i++) {
			Movie m=em.find(Movie.class, i);
			System.out.println("------------------------------------------");
			System.out.println("Movie Id --> "+m.getId());
			System.out.println("Movie Name --> "+m.getName());
			System.out.println("Movie Rating --> "+m.getRating());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		}
		*/
		
		
		
		
		
	}
	
	
	
	

}
