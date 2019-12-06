package com.capgemini.jdbc.controller;

import java.util.Scanner;

import com.capgemini.jdb.services.UserServices;
import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.factory.UserFactory;

public class InsertUser {
  public static void main(String[] args) {
	UserServices services=UserFactory.instanceOfUserServices();
	
	UserBean user=new UserBean();
	Scanner sc=new Scanner(System.in);
	
	System.out.println("User Id:");
	  user.setUserid(Integer.parseInt(sc.nextLine()));
	  System.out.println("user Name: ");
	  user.setUser_name(sc.nextLine());
	  System.out.println("E Mail: ");
	  user.setEmail(sc.nextLine());
	  System.out.println("Password: ");
	  user.setPassword(sc.nextLine());
	  
	  if(services.insertUser(user)) {
		  System.out.println("User inserted...");
	  }
	  else {
		  System.out.println("something went wrong..");
	  }
	  
	 
	  
}
	
	
	
	
}
