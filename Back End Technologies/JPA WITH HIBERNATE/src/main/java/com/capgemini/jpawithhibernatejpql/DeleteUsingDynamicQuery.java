package com.capgemini.jpawithhibernatejpql;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteUsingDynamicQuery {
  public static void main(String[] args) {
	  
	  Scanner sc=new Scanner(System.in);
	  
	  EntityManagerFactory emf=Persistence.createEntityManagerFactory("Test");
	  EntityManager em=emf.createEntityManager();
	  EntityTransaction transaction=em.getTransaction();
	  
	  String query="delete from movie where id=:id";
	  Query q1=em.createNativeQuery(query);
	  System.out.println("Enter the Id which you want to delete : ");
	  q1.setParameter("id", sc.nextInt());
	  transaction.begin();
	  int result=q1.executeUpdate();
	  transaction.commit();
	  if(result>0 ) {
		  System.out.println("Record deleted successfully....");
	  }
	  
	  
	  
	  
}
	
	
	
	
	
}
