package com.onebill.project1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onebill.project1.dto.Customer;
import com.onebill.project1.dto.CustomerResponse;
import com.onebill.project1.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("/customer-operations")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	
	@PostMapping(path = "/viewCustomer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CustomerResponse displayCustomer(@RequestBody Customer customer) {
		CustomerResponse response=new CustomerResponse();
		
		Customer customerFound=customerService.viewCustomer(customer);
		if(customerFound!=null) {
			response.setStatusCode(200);
			response.setMessage("Partner Details found !!");
			response.setPartnername(customerFound.getPartner().getPartnerName());
			response.setCustomer(customerFound);
		}else {
			response.setStatusCode(300);
			response.setMessage("Partner Details not found !!");
			
		}
		
		return response;
	}
	
	
	
	
	
}
