package com.capgemini.jdbc.dao;



import java.util.List;

import com.capgemini.jdbc.bean.UserBean;

public interface UserDAO {
	
	//1. getAllUsers()
	public List<UserBean> getAllUsers();
	
	   //2. User Login
		public UserBean userLogin(String user_name,String password);
		
		//3. Update
		public boolean updateUser(int userid,String password);
		
		//4. Insert
	   public boolean insertUser(UserBean user);
		
		//5. Delete
		public boolean deleteUser(int userid,String password);
	
	
	
	
}
