package com.capgemini.jdb.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.dao.UserDAO;
import com.capgemini.jdbc.factory.UserFactory;

public class UserServicesImpl implements UserServices {
  
	UserDAO dao=UserFactory.instanceOfUserDAOImpl();
	
	//2. allUser()
	
	@Override
	public List<UserBean> getAllUsers() {
		// TODO Auto-generated method stub
		return dao.getAllUsers();
	}
	
	//1. Login
	@Override
	public UserBean userLogin(String user_name, String password) {
		
		return dao.userLogin(user_name, password);
	}

	//3.updateUser()
	@Override
	public boolean updateUser(int userid, String password) {
		// TODO Auto-generated method stub
		return dao.updateUser(userid, password);
	}

	
	//4.insertUser()
	@Override
	public boolean insertUser(UserBean user) {
		

		return dao.insertUser(user);
	}

	
	//5.
	@Override
	public boolean deleteUser(int userid, String password) {

		return dao.deleteUser(userid, password);
	}
	
	
}
