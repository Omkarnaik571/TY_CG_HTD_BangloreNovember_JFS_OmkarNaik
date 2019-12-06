package com.capgemini.jdb.services;



import java.util.List;

import com.capgemini.jdbc.bean.UserBean;

public interface UserServices {
  
   public List<UserBean> getAllUsers();
   //User Login
	public UserBean userLogin(String user_name,String password);
	
	//Update
	public boolean updateUser(int userid,String password);
	
	//Insert
   public boolean insertUser(UserBean user);
	
	//Delete
	public boolean deleteUser(int userid,String password);
	
	
}
