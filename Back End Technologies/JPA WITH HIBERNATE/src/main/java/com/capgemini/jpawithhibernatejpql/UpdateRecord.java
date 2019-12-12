package com.capgemini.jpawithhibernatejpql;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateRecord {
   public static void main(String[] args) {
	
	   Scanner sc=new Scanner(System.in);
	   
	   EntityManagerFactory emf=Persistence.createEntityManagerFactory("Test");
	   EntityManager em=emf.createEntityManager();
	   EntityTransaction transaction=em.getTransaction();
	   
	   String update="update Movie set name='Avengers-End Game' where id=7";
	   
	   Query q1=em.createNativeQuery(update);
	   transaction.begin();
	   int result=q1.executeUpdate();
	   transaction.commit();
	   if(result>0) {
		   System.out.println("\nRecord modified successfully..");
	   }
	   
	   
}
	
	
	
}
