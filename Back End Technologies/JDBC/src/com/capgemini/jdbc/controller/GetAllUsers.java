package com.capgemini.jdbc.controller;

import java.util.List;

import com.capgemini.jdb.services.UserServices;
import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.factory.UserFactory;

public class GetAllUsers {
  public static void main(String[] args) {
	UserServices serivices=UserFactory.instanceOfUserServices();
	
//	  serivices.getAllUsers();
	  
	  List<UserBean> list=serivices.getAllUsers();
	  
	  if(list != null) {
		  for(UserBean user:list) {
			  System.out.println(user);
			  
		  }
	  }
	  
	  
	  
}
	
	
	
	
}
