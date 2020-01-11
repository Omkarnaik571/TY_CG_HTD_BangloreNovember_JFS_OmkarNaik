package com.capgemini.moduletesttwo.dao;

import com.capgemini.moduletesttwo.dto.ProductInfo;
import com.capgemini.moduletesttwo.dto.UserInfo;

public interface UserDao {
	
	
	public boolean addUser(UserInfo userInfo);
	
	public UserInfo authenticateUser(UserInfo userInfo);

	public UserInfo modifyUser(String email,String oldPwd,String newPwd);
	
	public boolean addProduct(ProductInfo productInfo);
	
	public ProductInfo searchProduct(int productId);
	
}
