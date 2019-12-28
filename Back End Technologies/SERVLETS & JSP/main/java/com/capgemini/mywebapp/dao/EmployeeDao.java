package com.capgemini.mywebapp.dao;

import com.capgemini.mywebapp.bin.EmployeeInfoBean;
import com.capgemini.mywebapp.servlets.EmployeeInfoBin;

import antlr.collections.List;

public interface EmployeeDao {

	public EmployeeInfoBean searchEmployee(int empId);
	
	public EmployeeInfoBean authenticate(int empId,String password);
	
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean);
	
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean);
	
	public boolean deleteEmployee(int empId);
	
	public java.util.List<EmployeeInfoBean> getAllEmployees();
}