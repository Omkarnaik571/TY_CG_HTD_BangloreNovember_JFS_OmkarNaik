package com.capgemini.empmvcspring.service;

import java.util.List;

import com.capgemini.empmvcspring.bean.EmployeeBean;

public interface EmployeeService {
   
public EmployeeBean authenticate(String email,String password);
	
	public boolean register(EmployeeBean bean);
	
	public List<EmployeeBean> getAllEmployees(String key);
	
	public boolean changePassword(int id,String password);
	
	
	
	
}
