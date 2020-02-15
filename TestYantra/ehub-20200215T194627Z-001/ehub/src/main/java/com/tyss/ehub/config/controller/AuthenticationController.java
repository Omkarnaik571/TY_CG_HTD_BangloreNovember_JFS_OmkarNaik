package com.tyss.ehub.config.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.ehub.config.dto.AuthenticationDto;
import com.tyss.ehub.config.dto.AuthenticationResponse;
import com.tyss.ehub.config.service.AuthenticationService;

@CrossOrigin(origins = "*" , allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("/adminOperations")
public class AuthenticationController {

	@Autowired
	AuthenticationService authenticationService;
	
	
	
	
	@PostMapping(path = "/addUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AuthenticationResponse addUser(@RequestBody AuthenticationDto authenticationDto) {
		AuthenticationResponse adminResponse = new AuthenticationResponse();
		if (authenticationService.addUser(authenticationDto)) {
			adminResponse.setStatusCode(201);
			adminResponse.setMessage("Success");
		}
		return adminResponse;
	}
	
	@PostMapping(path = "/authenticateUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AuthenticationResponse authenticateUser(@RequestBody AuthenticationDto authenticationDto) {
		AuthenticationResponse adminResponse = new AuthenticationResponse();
		 AuthenticationDto userFound=authenticationService.getUser(authenticationDto);
		if(userFound != null) {
			adminResponse.setStatusCode(201);
		    adminResponse.setMessage("User Found");
		    adminResponse.setUserDetails(userFound);
		}else {
			adminResponse.setStatusCode(406);
		    adminResponse.setMessage("Incorrect password");
		    adminResponse.setUserDetails(null);
		}
		 return adminResponse;
	}
	
	
	@PostMapping(path = "/updateUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AuthenticationResponse updateUser(@RequestBody AuthenticationDto authenticationDto) {
		AuthenticationResponse adminResponse = new AuthenticationResponse();
		if (authenticationService.updateUser(authenticationDto)) {
			adminResponse.setStatusCode(201);
			adminResponse.setMessage("Password updated successfully !!");
		}else {
			adminResponse.setStatusCode(406);
			adminResponse.setMessage("User Updation Failed");
		}
		return adminResponse;
	}
	
	
	@PostMapping(path = "/deleteUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AuthenticationResponse deleteUser(@RequestBody AuthenticationDto authenticationDto) {
		AuthenticationResponse adminResponse = new AuthenticationResponse();
		if (authenticationService.deleteUser(authenticationDto)) {
			adminResponse.setStatusCode(201);
			adminResponse.setMessage("User deleted successfully !!");
		}else {
			adminResponse.setStatusCode(406);
			adminResponse.setMessage("User deletion Failed");
		}
		return adminResponse;
	}
	
	
	
	
	
	
}
