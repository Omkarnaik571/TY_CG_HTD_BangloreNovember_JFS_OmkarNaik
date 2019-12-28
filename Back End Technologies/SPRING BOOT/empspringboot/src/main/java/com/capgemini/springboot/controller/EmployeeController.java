package com.capgemini.springboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springboot.dto.EmployeeBean;
import com.capgemini.springboot.dto.EmployeeResponse;
import com.capgemini.springboot.service.EmployeeService;


@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	
	@PostMapping(path="/auth",produces = MediaType.APPLICATION_JSON_VALUE
			,consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse auth(@RequestBody EmployeeBean bean) {

		EmployeeBean employeeBean=service.authenticate(bean.getEmail(), bean.getPassword());
	    EmployeeResponse response=new EmployeeResponse();
		if(employeeBean != null) {
	    	response.setStatuscode(201);
	    	response.setMessage("Success");
	    	response.setDescription("Employee Found for the credential ");
	         response.setBeans(Arrays.asList(employeeBean));
	               
	         
		}
		else {
			response.setStatuscode(401);
	    	response.setMessage("failure");
	    	response.setDescription("Credential Invalid ");
			
	    
		}
		return response;
		
	}

	
	@PostMapping(path="/register",produces = MediaType.APPLICATION_JSON_VALUE
		,consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse register(@RequestBody EmployeeBean bean) {
		EmployeeResponse response=new  EmployeeResponse();
		if(service.register(bean)) {
			response.setStatuscode(201);
			response.setMessage("Success");
			response.setDescription("Registration Successful");
		}
		else {
			response.setStatuscode(401);
			response.setMessage("Failure");
			response.setDescription("Registration unsuccessful");
		}
		
		return response;
	}

	
	@GetMapping(path="/get",produces = MediaType.APPLICATION_JSON_VALUE)
	public  EmployeeResponse  searchEmployee(@RequestParam("key") String key) {
          EmployeeResponse response=new EmployeeResponse();
             List<EmployeeBean> l1=service.getAllEmployees(key); 
        
             if(! l1.isEmpty()) {
  			response.setStatuscode(201);
  			response.setMessage("Success");
  			response.setDescription("Employee Data found");
  			response.setBeans(l1);
  		}
  		else {
  			response.setStatuscode(401);
  			response.setMessage("Failure");
  			response.setDescription("Employee Data not found");
  		}
  		
  		return response;
	}

	
	@PutMapping(path="/change-password",produces = MediaType.APPLICATION_JSON_VALUE
			, consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse changePasssword(@RequestBody EmployeeBean bean) {
         EmployeeResponse response=new EmployeeResponse();
		if(service.changePassword(bean.getId(), bean.getPassword())){
			response.setStatuscode(201);
  			response.setMessage("Success");
  			response.setDescription("Password Changed successfully");
		}
		else {
			response.setStatuscode(401);
  			response.setMessage("Failure");
  			response.setDescription("Password modification unsuccessful");
		}
		
	   return response;
	}
	
	@DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse deleteEmployee(@PathVariable("id")int id) {
		EmployeeResponse response=new EmployeeResponse();
		service.deleteEmployee(id);
	    response.setStatuscode(201);
		response.setMessage("Success");
		response.setDescription("Employee deleteed successfully");
		return response;
	}
	
	



}
