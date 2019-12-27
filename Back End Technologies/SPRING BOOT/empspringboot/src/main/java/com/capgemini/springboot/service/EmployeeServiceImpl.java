package com.capgemini.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.springboot.dto.EmployeeAddressBean;
import com.capgemini.springboot.dto.EmployeeBean;
import com.capgemini.springboot.exception.EmployeeException;
import com.capgemini.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	private EmployeeRepository repository;
	
	private  BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	

	@Override
	public EmployeeBean authenticate(String email, String password) {
		EmployeeBean bean=repository.findByEmail(email);
		if(bean != null) {
			if(encoder.matches(password, bean.getPassword())) {
				return bean;
			}
			else {
			throw new EmployeeException("Password Not Matching");	
			}
			}
		else {
			throw new EmployeeException("Employee Not found");
		}
		
}

	@Override
	public boolean register(EmployeeBean bean) {
		bean.setPassword(encoder.encode(bean.getPassword()));
		for (EmployeeAddressBean addressBean : bean.getAddressBeans()) {
			addressBean.setEmployeeBean(bean);
		}
		
		
		repository.save(bean);
		return true;
	}

	@Override
	public List<EmployeeBean> getAllEmployees(String key) {
	   return	repository.findByKey(key);
		
	}

	@Override
	public boolean changePassword(int id, String password) {
		repository.changePassword(id, encoder.encode(password));
		
		return true;
	}

	@Override
	public boolean deleteEmployee(int id) {
		repository.deleteById(id);
		return true;
	}

	
	
	
}
