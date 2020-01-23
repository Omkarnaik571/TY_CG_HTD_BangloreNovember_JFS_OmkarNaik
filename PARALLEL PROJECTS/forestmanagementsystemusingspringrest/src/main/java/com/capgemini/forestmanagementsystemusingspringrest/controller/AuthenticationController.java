package com.capgemini.forestmanagementsystemusingspringrest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestmanagementsystemusingspringrest.dto.AuthenticationDetailsDto;
import com.capgemini.forestmanagementsystemusingspringrest.dto.AuthenticationResponse;
import com.capgemini.forestmanagementsystemusingspringrest.exception.CustomExceptions;
import com.capgemini.forestmanagementsystemusingspringrest.service.AuthenticationService;

@CrossOrigin(origins = "*" , allowedHeaders = "*", allowCredentials = "true")
@RestController
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping(path = "/userAuthentication", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AuthenticationResponse userAuthentication(@RequestBody AuthenticationDetailsDto bean) {
		AuthenticationDetailsDto authenticationDetailsDto = authenticationService.viewSingleUserClient(bean);

		AuthenticationResponse response = new AuthenticationResponse();
		if (authenticationDetailsDto != null) {
			response.setStatuscode(201);
			response.setMessage("Success");
			response.setDescription("User name and password matched successfully !!");
			response.setBean(Arrays.asList(authenticationDetailsDto));

		} else {
			response.setStatuscode(404);
			response.setMessage("failure");
			response.setDescription("Invalid user id and Password !! ");
		}
		return response;

	}

	@PostMapping(path = "/addClient", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AuthenticationResponse addClient(@RequestBody AuthenticationDetailsDto bean) {
		AuthenticationResponse response = new AuthenticationResponse();
		bean.setAccountType("client");
		if (authenticationService.addUser(bean)) {
			// Added successfully
			response.setStatuscode(200);
			response.setMessage("Success !!");
			response.setDescription("User added succefully !! !!");
		} else {
			// Added Unsuccessfully
			response.setStatuscode(404);
			response.setMessage("Failure !!");
			response.setMessage(
					"User Name that you have entered already exist, try to create the account with different username !!");

		}

		return response;
	}// end of add Client
	
	
	@PostMapping(path = "/addScheduler", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AuthenticationResponse Scheduler(@RequestBody AuthenticationDetailsDto bean) {
		AuthenticationResponse response = new AuthenticationResponse();
		bean.setAccountType("scheduler");
		if (authenticationService.addUser(bean)) {
			// Added successfully
			response.setStatuscode(200);
			response.setMessage("Success !!");
			response.setDescription("User added succefully !! !!");
		} else {
			// Added Unsuccessfully
			response.setStatuscode(404);
			response.setMessage("Failure !!");
			response.setMessage(
					"User Name that you have entered already exist, try to create the account with different username !!");

		}

		return response;
	}// end of add Scheduler
	
	
	
	

	@PostMapping(path = "/deleteUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AuthenticationResponse deleteUser(@RequestBody AuthenticationDetailsDto bean) {
		AuthenticationResponse response = new AuthenticationResponse();
		if (authenticationService.delateUser(bean)) {
			// Added successfully
			response.setStatuscode(200);
			response.setMessage("Success !!");
			response.setDescription("User deleated succefully !! !!");
		} else {
			// Added Unsuccessfully
			response.setStatuscode(404);
			response.setMessage("Failure !!");
			response.setMessage("Incorrect User id and password, Unable to delete !!");

		}

		return response;
	}// end of delete User

	@GetMapping(path = "/viewallClient", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AuthenticationDetailsDto> viewAllClient() {
		AuthenticationResponse response = new AuthenticationResponse();
		List<AuthenticationDetailsDto> result = authenticationService.viewAllClients();
		return result;

	}// end of view all Client

	@GetMapping(path = "/viewallScheduler", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AuthenticationDetailsDto> viewAllScheduler() {
		AuthenticationResponse response = new AuthenticationResponse();
		List<AuthenticationDetailsDto> result = authenticationService.viewAllScheduers();
		return result;

	}// end of view all Scheduler

	@PostMapping(path = "/viewSingleUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AuthenticationResponse viewSingleUser(@RequestBody AuthenticationDetailsDto bean) {
		AuthenticationDetailsDto authenticationDetailsDto = authenticationService.viewSingleUserClient(bean);

		AuthenticationResponse response = new AuthenticationResponse();
		if (authenticationDetailsDto != null) {
			response.setStatuscode(201);
			response.setMessage("Success");
			response.setDescription("User Data Found!!");
			response.setBean(Arrays.asList(authenticationDetailsDto));

		} else {
			response.setStatuscode(401);
			response.setMessage("failure");
			response.setDescription("Invalid user name and Password !! ");
		}
		return response;
	}// end of viewSingle
	
	
	@PutMapping(path = "/modifyUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AuthenticationResponse modifyUser(@RequestBody AuthenticationDetailsDto bean) {
		AuthenticationResponse response = new AuthenticationResponse();
		if (authenticationService.addUser(bean)) {
			// Added successfully
			response.setStatuscode(200);
			response.setMessage("Success !!");
			response.setDescription("User modified succefully !! !!");
		} else {
			// Added Unsuccessfully
			response.setStatuscode(404);
			response.setMessage("Failure !!");
			response.setDescription("User Name and password didn`t matched !!");

		}

		return response;
	}// end of add Client
	
	
	
	
	
	
	
	
	
	
	
	

}
