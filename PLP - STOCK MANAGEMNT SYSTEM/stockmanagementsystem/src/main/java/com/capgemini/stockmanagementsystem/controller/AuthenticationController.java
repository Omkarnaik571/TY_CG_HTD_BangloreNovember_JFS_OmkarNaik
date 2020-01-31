package com.capgemini.stockmanagementsystem.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.stockmanagementsystem.dto.AuthenticationDto;
import com.capgemini.stockmanagementsystem.dto.AuthenticationResponse;
import com.capgemini.stockmanagementsystem.service.AuthenticationService;

@CrossOrigin(origins = "*" , allowedHeaders = "*", allowCredentials = "true")
@RestController
public class AuthenticationController {

	
	@Autowired
	private AuthenticationService authenticationService;
	
	
	@PostMapping(path = "/userAuthentication", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AuthenticationResponse userAuthentication(@RequestBody AuthenticationDto authenticationDto) {
		AuthenticationDto authenticationDetailsDto = authenticationService.verifyUser(authenticationDto);

		AuthenticationResponse response = new AuthenticationResponse();
		if (authenticationDetailsDto != null) {
			response.setStatusCode(200);
			response.setMessage("User name and password matched successfully !!");
			response.setBean(Arrays.asList(authenticationDetailsDto));

		} else {
			response.setStatusCode(400);
			response.setMessage("User name and password did`nt matched !!");
		}
		return response;

	}
	
	
	@PostMapping(path = "/deleteUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AuthenticationResponse deleteUser(@RequestBody AuthenticationDto authenticationDto) {
		AuthenticationResponse response = new AuthenticationResponse();
		if (authenticationService.removeUser(authenticationDto)) {
			// Added successfully
			response.setStatusCode(200);
			response.setMessage("User deleted succefully !!");
		} else {
			// Added Unsuccessfully
			response.setStatusCode(400);
			response.setMessage("Incorrect User id and password, Unable to delete !!");

		}

		return response;
	}// end of delete User
	
	@GetMapping(path = "/viewallUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AuthenticationDto> viewAllUsers() {
		AuthenticationResponse response = new AuthenticationResponse();
		List<AuthenticationDto> result = authenticationService.viewAllUsers();
		return result;

	}// end of view all Client

	@PostMapping(path = "/addUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AuthenticationResponse addUser(@RequestBody AuthenticationDto authenticationDto) {
		AuthenticationResponse response = new AuthenticationResponse();
		if (authenticationService.addUser(authenticationDto)) {
			// Added successfully
			response.setStatusCode(200);
			response.setMessage("User added successfully !!");
		} else {
			// Added Unsuccessfully
			response.setStatusCode(400);
			response.setMessage("User Name that you have entered already exist, try to create the account with different username !!");

		}
		return response;
	}
	
	
	@PostMapping(path = "/updateUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AuthenticationResponse updateUser(@RequestBody AuthenticationDto authenticationDto) {
		AuthenticationResponse response = new AuthenticationResponse();
		if (authenticationService.updateUser(authenticationDto)) {
			// Added successfully
			response.setStatusCode(200);
			response.setMessage("User updated successfully !!");
		} else {
			// Added Unsuccessfully
			response.setStatusCode(400);
			response.setMessage("Updation failed");

		}
		return response;
	}
	
	
	
}
