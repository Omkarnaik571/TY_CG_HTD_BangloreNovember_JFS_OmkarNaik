package com.tyss.ehub.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.ehub.config.dto.AuthenticationResponse;
import com.tyss.ehub.config.dto.EmpDetails;
import com.tyss.ehub.config.dto.EmployeeIdentificationDetails;
import com.tyss.ehub.config.dto.EmployeeResponse;
import com.tyss.ehub.config.dto.TemporaryAddress;
import com.tyss.ehub.config.service.EmployeeServ;

@CrossOrigin(origins = "*" , allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("/employeeOperations")
public class EmployeeController {

	
	@Autowired
	EmployeeServ employeeServ;
	
	
	
	@PostMapping(path = "/addEmployee", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AuthenticationResponse insertEmployee(@RequestBody EmpDetails empDetails) {
		AuthenticationResponse adminResponse = new AuthenticationResponse();
		if (employeeServ.addEmployee(empDetails)) {
			adminResponse.setStatusCode(201);
			adminResponse.setMessage("Employee added Successfully !!");
		}
		return adminResponse;
	}
	
	
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AuthenticationResponse removeEmployee(@RequestBody EmpDetails empDetails) {
		AuthenticationResponse adminResponse = new AuthenticationResponse();
		if (employeeServ.removeEmployee(empDetails)) {
			adminResponse.setStatusCode(201);
			adminResponse.setMessage("Employee removed Successfully !!");
		}
		return adminResponse;
	}
	
	
	@PostMapping(path = "/searchEmployee",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmpDetails findEmployee(@RequestBody EmpDetails empDetails) {
		
	    EmpDetails emp=employeeServ.findEmployee(empDetails);
	    
	    if(emp != null) {
	    return emp;
	    }
	     return null;
	}

	@PostMapping(path = "/searchEmployeePan",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse findEmployeeThroghtPan(@RequestBody EmployeeIdentificationDetails empDetails) {
		EmployeeResponse response=new EmployeeResponse();
		
	    EmployeeIdentificationDetails emp=employeeServ.findEmployeeThroughPan(empDetails);
	    
	    if(emp != null) {
	    response.setStstusCode(200);
	    response.setMessage("Found !!");
	    response.setEmployeeName(emp.getEmployeeDetails().getName());
	    response.setEmpDetails(emp.getEmployeeDetails());
	    }
	     return response;
	}

	
	@PostMapping(path = "/searchEmployeeAddress",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse findEmployeeThroghtAddress(@RequestBody TemporaryAddress temporaryAddress) {
		EmployeeResponse response=new EmployeeResponse();
		
		String temp=temporaryAddress.getCity().trim();
		if(temp.isEmpty()) {
			response.setStstusCode(200);
		    response.setMessage("There is no content present inside the object !!");
		    return response;
		}
	    TemporaryAddress emp=employeeServ.findEmployeeThroughAddressId(temporaryAddress);
	    
	    if(emp != null) {
	    response.setStstusCode(200);
	    response.setMessage("Found !!");
	    response.setEmployeeName(emp.getEmpDetails().getName());
	    response.setEmpDetails(emp.getEmpDetails());
	    }
	     return response;
	}

}
