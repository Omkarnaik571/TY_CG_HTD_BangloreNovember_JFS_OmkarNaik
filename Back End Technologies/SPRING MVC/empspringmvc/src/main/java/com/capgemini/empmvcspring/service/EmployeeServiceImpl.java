package com.capgemini.empmvcspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.empmvcspring.bean.EmployeeAddressBean;
import com.capgemini.empmvcspring.bean.EmployeeBean;
import com.capgemini.empmvcspring.dao.EmployeeDao;
import com.capgemini.empmvcspring.dao.EmployeeDaoImpl;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	
	@Autowired
	private EmployeeDao dao;
	
	
	
	
	@Override
	public EmployeeBean authenticate(String email, String password) {
		
		
		return dao.authenticate(email,password);
	}

	@Override
	public boolean register(EmployeeBean bean) {
		
		String encodedPassword=encoder.encode(bean.getPassword());
		bean.setPassword(encodedPassword);
			
		List<EmployeeAddressBean> addressBeans=bean.getAddressBeans();
		for (EmployeeAddressBean employeeAddressBean : addressBeans) {
			employeeAddressBean.setEmployeeBean(bean);
		}
		
		return dao.register(bean);
	}

	@Override
	public List<EmployeeBean> getAllEmployees(String key) {
		
		return dao.getAllEmployees(key);
	}

	@Override
	public boolean changePassword(int id, String password) {
		
		String encodePassword=encoder.encode(password);
		return dao.changePassword(id,password);
	}

}
