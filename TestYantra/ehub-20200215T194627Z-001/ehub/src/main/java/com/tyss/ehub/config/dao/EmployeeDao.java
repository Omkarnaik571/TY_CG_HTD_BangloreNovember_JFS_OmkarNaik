package com.tyss.ehub.config.dao;

import com.tyss.ehub.config.dto.EmpDetails;

public interface EmployeeDao {

	public boolean addEmployee(EmpDetails empDetails);
	
	public boolean removeEmployee(EmpDetails empDetails);
	
	
	public EmpDetails findEmployee(EmpDetails empDetails);
	
}
