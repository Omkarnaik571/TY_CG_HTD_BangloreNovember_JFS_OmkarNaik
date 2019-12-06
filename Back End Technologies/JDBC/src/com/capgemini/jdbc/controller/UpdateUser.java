package com.capgemini.jdbc.controller;

import java.util.Scanner;

import com.capgemini.jdb.services.UserServices;
import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.factory.UserFactory;

public class UpdateUser {
    public static void main(String[] args) {
    	UserServices service=UserFactory.instanceOfUserServices();
    	Scanner sc=new Scanner(System.in);
    	UserBean user=new UserBean();	
    	
      System.out.println("User Id:");
  	  user.setUserid(Integer.parseInt(sc.nextLine()));
  	  System.out.println("Password: ");
  	  user.setPassword(sc.nextLine());
    if(service.updateUser(user.getUserid(),user.getPassword())){
    	System.out.println("data updated....");
    }	
    else {
    	System.out.println("Something went wrong....");
    }
  	  
  	  
	}
	
	
	
	
	
	
	
     
	
	
	
}
