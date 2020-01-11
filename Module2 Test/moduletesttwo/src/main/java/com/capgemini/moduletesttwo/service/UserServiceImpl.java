package com.capgemini.moduletesttwo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.moduletesttwo.dao.UserDao;
import com.capgemini.moduletesttwo.dto.ProductInfo;
import com.capgemini.moduletesttwo.dto.UserInfo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	
	@Override
	public boolean addUser(UserInfo userInfo) {
		
		return userDao.addUser(userInfo);
	}

	@Override
	public UserInfo authenticateUser(UserInfo userInfo) {
		
		return userDao.authenticateUser(userInfo);
	}

	@Override
	public UserInfo modifyUser(String email, String oldPwd, String newPwd) {
		
		return userDao.modifyUser(email, oldPwd, newPwd);
	}

	@Override
	public boolean addProduct(ProductInfo productInfo) {
		return userDao.addProduct(productInfo);
	}

	@Override
	public ProductInfo searchProduct(int productId) {
		return userDao.searchProduct( productId);
	}

}
