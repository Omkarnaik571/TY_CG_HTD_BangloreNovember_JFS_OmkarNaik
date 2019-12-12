package com.capgemini.jpawithhibernatejpql;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdationUsingDynamicInputs {
   public static void main(String[] args) {
	  
	   Scanner sc=new Scanner(System.in);
	   EntityManagerFactory emf=Persistence.createEntityManagerFactory("Test");
	   EntityManager em=emf.createEntityManager();
	   EntityTransaction transaction=em.getTransaction();
	   
	   String dynamicupdate="update Movie set name=:name where id=:id";
	   
	 Query q1=  em.createNativeQuery(dynamicupdate);
	   System.out.println("enter the Id Which you want to modify : ");
	   q1.setParameter("id", sc.nextInt());
	   sc.nextLine();
	   System.out.println("enter the revised name : ");   
	   q1.setParameter("name", sc.nextLine());
	   transaction.begin();
	   int result=q1.executeUpdate();
	   transaction.commit();
	   if(result>0) {
		   System.out.println("updated..");
	   }
	   
	   
	   
	   
	   
	   
	   
}
	
	
	
}
