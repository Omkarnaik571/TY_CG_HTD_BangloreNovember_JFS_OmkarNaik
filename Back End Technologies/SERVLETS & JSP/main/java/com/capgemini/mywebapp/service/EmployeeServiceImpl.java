package com.capgemini.mywebapp.service;

import java.util.List;

import com.capgemini.mywebapp.bin.EmployeeInfoBean;
import com.capgemini.mywebapp.dao.EmployeeDao;
import com.capgemini.mywebapp.dao.EmployeeDaoImpl;
import com.capgemini.mywebapp.servlets.EmployeeInfoBin;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao dao=new EmployeeDaoImpl();
	
	
	@Override
	public EmployeeInfoBean searchEmployee(int empId) {
		
		return dao.searchEmployee(empId);
	}


	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {
		return dao.authenticate(empId, password);
	}


	@Override
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean) {
		// TODO Auto-generated method stub
		return dao.addEmployee(employeeInfoBean);
	}


	@Override
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean) {
		// TODO Auto-generated method stub
		return dao.updateEmployee(employeeInfoBean);
	}


	@Override
	public boolean deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		return dao.deleteEmployee(empId);
	}


	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		// TODO Auto-generated method stub
		return dao.getAllEmployees();
	}


	
	

	
	
}
