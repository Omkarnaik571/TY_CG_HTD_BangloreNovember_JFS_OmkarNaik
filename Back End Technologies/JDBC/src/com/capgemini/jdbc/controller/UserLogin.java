package com.capgemini.jdbc.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.capgemini.jdb.services.UserServices;
import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.factory.UserFactory;

public class UserLogin {
  public static void main(String[] args) {
	  Scanner sc=new Scanner(System.in);
	  UserServices services= UserFactory.instanceOfUserServices();
	  UserBean user=new UserBean();
	  
	  System.out.println("user Name: ");
	  user.setUser_name(sc.nextLine());
	  System.out.println("Password: ");
	  user.setPassword(sc.nextLine());
	  
	  UserBean user1=services.userLogin(user.getUser_name(), user.getPassword());
//	 System.out.println(user1);
	 if(user1 != null) {
		 System.out.println("User Id : "+user1.getUserid());
		 System.out.println("User Name : "+user1.getUser_name());
	     System.out.println("E-Mail : "+user1.getEmail());
	 }
	 else {
		 System.out.println("Something went wrong....");
	 }
	 
	 
	 
	 
	  	  
}
	
	
	
}
