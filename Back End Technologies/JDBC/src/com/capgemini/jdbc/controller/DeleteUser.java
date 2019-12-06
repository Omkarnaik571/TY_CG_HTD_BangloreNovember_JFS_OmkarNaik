package com.capgemini.jdbc.controller;

import java.util.Scanner;

import com.capgemini.jdb.services.UserServices;
import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.factory.UserFactory;

public class DeleteUser {
   public static void main(String[] args) {
	   UserServices services=UserFactory.instanceOfUserServices();
		UserBean user=new UserBean();
	Scanner sc=new Scanner(System.in);
	
	
	System.out.println("User Id:");
	  user.setUserid(Integer.parseInt(sc.nextLine()));
	  System.out.println("Password: ");
	  user.setPassword(sc.nextLine());
	  	  
	if(services.deleteUser(user.getUserid(), user.getPassword())) {
		 System.out.println("User Deleted");
	 } 
	 else {
		 System.out.println("Something went wrong..");
	 }
	  
}
	
	
	
	
	
}
