package com.capgemini.jpawithhibernate;

import java.util.Map;

import javax.persistence.Cache;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;

import com.capgemini.jpawithhibernatedto.Movie;

public class InsertDemo {
 public static void main(String[] args) {
	Movie movie =new Movie();
	movie.setId(5);
	movie.setName("Sherlock homes:Game of Shadows");
	movie.setRating("Great"); 
	EntityManagerFactory entityManagerFactory=null;
	EntityManager entityManager=null;
	EntityTransaction transaction=null;

	
	try {
	 entityManagerFactory=Persistence.createEntityManagerFactory("Test");
	 entityManager=entityManagerFactory.createEntityManager();
	transaction=entityManager.getTransaction();
	transaction.begin();
	entityManager.persist(movie);
	System.out.println("Record Inserted....");
	transaction.commit();
//	entityManager.close();
	 }
	 catch (Exception e) {
		 e.printStackTrace();
		 transaction.rollback();
		// TODO: handle exception
	}
	 transaction.commit();
	 entityManager.close();
	
	
	
}
	//End of main method()
	
}
//End of class