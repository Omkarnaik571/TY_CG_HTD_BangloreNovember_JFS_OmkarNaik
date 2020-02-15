package com.tyss.ehub.config.service;

import com.tyss.ehub.config.dto.EmpDetails;

public interface EmployeeServ {

	public boolean addEmployee(EmpDetails empDetails);
	
	public boolean removeEmployee(EmpDetails empDetails);
	
	public EmpDetails findEmployee(EmpDetails empDetails);
	
}
