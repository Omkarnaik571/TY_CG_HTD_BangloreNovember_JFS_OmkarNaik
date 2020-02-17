package com.tyss.ehub.config.dao;

import com.tyss.ehub.config.dto.EmpDetails;
import com.tyss.ehub.config.dto.EmployeeIdentificationDetails;
import com.tyss.ehub.config.dto.TemporaryAddress;

public interface EmployeeDao {

	public boolean addEmployee(EmpDetails empDetails);
	
	public boolean removeEmployee(EmpDetails empDetails);
	
	
	public EmpDetails findEmployee(EmpDetails empDetails);

	public EmployeeIdentificationDetails findEmployeeThroughPan(EmployeeIdentificationDetails employeeIdentificationDetails);

	public TemporaryAddress findEmployeeThroughAddressId(TemporaryAddress temporaryAddress);
	
}
