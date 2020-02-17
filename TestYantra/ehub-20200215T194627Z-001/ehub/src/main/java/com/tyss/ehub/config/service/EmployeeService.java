package com.tyss.ehub.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.ehub.config.dao.EmployeeDao;
import com.tyss.ehub.config.dto.EmpDetails;
import com.tyss.ehub.config.dto.EmployeeIdentificationDetails;
import com.tyss.ehub.config.dto.TemporaryAddress;

@Service
public class EmployeeService implements EmployeeServ {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public boolean addEmployee(EmpDetails empDetails) {
		
		return employeeDao.addEmployee(empDetails);
	}

	@Override
	public boolean removeEmployee(EmpDetails empDetails) {
		
		return employeeDao.removeEmployee(empDetails);
	}

	@Override
	public EmpDetails findEmployee(EmpDetails empDetails) {
		
		return employeeDao.findEmployee(empDetails);
	}

	@Override
	public EmployeeIdentificationDetails findEmployeeThroughPan(
			EmployeeIdentificationDetails employeeIdentificationDetails) {
		
		return employeeDao.findEmployeeThroughPan(employeeIdentificationDetails);
	}

	@Override
	public TemporaryAddress findEmployeeThroughAddressId(TemporaryAddress temporaryAddress) {
		
		return employeeDao.findEmployeeThroughAddressId(temporaryAddress);
	}
	
	
	
	
}
