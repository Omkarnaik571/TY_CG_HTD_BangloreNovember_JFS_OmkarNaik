package com.capgemini.forestmanagementsystemusingspringboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestmanagementsystemusingspringboot.dto.CustomerDetailsDto;
import com.capgemini.forestmanagementsystemusingspringboot.dto.CustomerResponse;
import com.capgemini.forestmanagementsystemusingspringboot.service.CustomerService;

@CrossOrigin(origins = "*" , allowedHeaders = "*", allowCredentials = "true")
@RestController
public class CustomerOperationController {

	@Autowired
	CustomerService customerService;
	
	
	@PostMapping(path = "/addCustomer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
 	public CustomerResponse addCustomer(@RequestBody CustomerDetailsDto bean) {
		CustomerResponse response = new CustomerResponse();
 		if (customerService.addCustomer(bean)) {
 			// Added successfully
 			response.setStatuscode(200);
 			response.setMessage("Success !!");
 			response.setDescription("customer added succefully !! !!");
 		} else {
 			// Added Unsuccessfully
 			response.setStatuscode(404);
 			response.setMessage("Failure !!");
 			response.setMessage("Customer could`nt be added !!");
 		}

 		return response;
 	}// end of add Customer
	
	
	@DeleteMapping(path = "/deleteCustomer/{customerId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerResponse deleteCustomer(@PathVariable("customerId")int id) {
		CustomerResponse response = new CustomerResponse();
		if(customerService.deleteCustomerDetails(id)) {
			//Deletion successfully
			response.setStatuscode(200);
			response.setMessage("Success !!");
			response.setDescription("Customer deleted Successfully !!");
		}
		else {
			//Deletion unsuccessful Unsuccessfully
			response.setStatuscode(444);
			response.setMessage("Failure !!");
			response.setMessage("Customer deletion unsuccessful !!");
		}
		return response;
	}//end of delete customer
	
	 @GetMapping(path = "/viewallCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
	 	public CustomerResponse viewallCustomer() {
	 		CustomerResponse response = new CustomerResponse();
	 		List<CustomerDetailsDto> result = customerService.viewCustomerDetails();
	 		if(!result.isEmpty()) {
	 			response.setStatuscode(200);
	 	 		response.setMessage("Success ");
	 	 		response.setDescription("Customer details are !!");
	 	 		response.setBean(result);	
	 		}
	      else {
				
				response.setStatuscode(404);
				response.setMessage("Failure !!");
				response.setDescription("customers data not found");
			}
	 		
	 		return response;
	 	}// end of view all Customer
	
	 @PostMapping(path = "/viewSingleCustomer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	 	public CustomerResponse viewSingleCustomer(@RequestBody CustomerDetailsDto bean) {
	 		CustomerDetailsDto customerDetailsDto = customerService.viewSingleCustomerDetails(bean);

	 		CustomerResponse response = new CustomerResponse();
	 		if (customerDetailsDto != null) {
	 			response.setStatuscode(201);
	 			response.setMessage("Success");
	 			response.setDescription("Customer data found !!");
	 			response.setBean(Arrays.asList(customerDetailsDto));

	 		} else {
	 			response.setStatuscode(401);
	 			response.setMessage("failure");
	 			response.setDescription("Invalid Customer Id !! ");
	 		}
	 		return response;
	 	}// end of add User
	
	 @PutMapping(path = "/modifyCustomer",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	 	public CustomerResponse modifyCustomer(@RequestBody CustomerDetailsDto bean) {
	    	 CustomerResponse response=new CustomerResponse();
	 		if(customerService.modifyCustomerDetails(bean)) {
	 			response.setStatuscode(200);
	 			response.setMessage("Success !!");
	 			response.setDescription("Customer data modified succesfully  !!");
	 			
	 		}
	 		else {
	 			response.setStatuscode(444);
	 			response.setMessage("Failure !!");
	 			response.setMessage(" Modification unsuccessful!!");
	 			
	 		}
	 		
	 		return response;
	 	}
	 
	 
	
	
	
}
