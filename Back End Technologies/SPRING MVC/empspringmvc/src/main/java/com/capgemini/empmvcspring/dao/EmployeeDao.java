package com.capgemini.empmvcspring.dao;

import java.util.List;

import com.capgemini.empmvcspring.bean.EmployeeBean;

public interface EmployeeDao {

	public EmployeeBean authenticate(String email,String password);
	
	public boolean register(EmployeeBean bean);
	
	public List<EmployeeBean> getAllEmployees(String key);
	
	public boolean changePassword(int id,String password);
	
	
	
}
