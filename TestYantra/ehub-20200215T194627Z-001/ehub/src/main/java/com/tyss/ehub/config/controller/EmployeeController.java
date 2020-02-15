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
}
