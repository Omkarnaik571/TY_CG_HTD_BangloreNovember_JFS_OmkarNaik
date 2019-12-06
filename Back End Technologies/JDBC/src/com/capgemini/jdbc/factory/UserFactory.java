package com.capgemini.jdbc.factory;
import com.capgemini.jdb.services.UserServices;
import com.capgemini.jdb.services.UserServicesImpl;
import com.capgemini.jdbc.dao.*;

public class UserFactory {
	
	public UserFactory() {
		
		
	}
	
	public static UserDAO instanceOfUserDAOImpl() {
		UserDAO dao=new UserDAOImpl();
		return dao;
	}
	
	
	
	public static UserServices instanceOfUserServices() {
		UserServices services=new UserServicesImpl();
		return services;
		
		
	}
	
	

}
