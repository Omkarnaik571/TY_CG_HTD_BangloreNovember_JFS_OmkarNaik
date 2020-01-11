package com.capgemini.moduletesttwo.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.moduletesttwo.dto.ProductInfo;
import com.capgemini.moduletesttwo.dto.ProductResponse;
import com.capgemini.moduletesttwo.dto.UserInfo;
import com.capgemini.moduletesttwo.dto.UserInfoResponse;
import com.capgemini.moduletesttwo.service.UserService;

@RestController
public class UserOperationsController {
    @Autowired
	UserService UserService;
	
   
    
    @PostMapping(path = "/addUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
   	public UserInfoResponse addUser(@RequestBody UserInfo bean) {
    	UserInfoResponse response = new UserInfoResponse();
   		if (UserService.addUser(bean)) {
   			// Added successfully
   			response.setStatusCode(200);
   			response.setMessage("user added succefully !!");
   		} else {
   			// Added Unsuccessfully
   			response.setStatusCode(500);
   			response.setMessage("user could`nt be added !!");
   		}

   		return response;
   	}// end of add user
    
    
    @PostMapping(path = "/authenticateUser", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
   	public UserInfoResponse authenticateUser(@RequestBody UserInfo bean) {
    	UserInfoResponse response = new UserInfoResponse();
   		UserInfo userInfo=UserService.authenticateUser(bean);
    	if(userInfo!=null) {
    		response.setStatusCode(200);
   			response.setMessage("Email and password matched succefully !!");
   			response.setBean(userInfo);
    	}
    	else {
    		response.setStatusCode(500);
   			response.setMessage("Email and password  did`nt matched succefully !!");
    	}
    	

   		return response;
   	}// end of authenticate user
    
    @PutMapping(path = "/modifyUser",produces = MediaType.APPLICATION_JSON_VALUE)
	public UserInfoResponse modifyUser(@RequestParam("email")String email,@RequestParam("oldpassword")String oldPwd,@RequestParam("newpassword")String newPwd) {
    	UserInfoResponse response=new UserInfoResponse();
		  UserInfo userInfo= UserService.modifyUser(email, oldPwd, newPwd);
		  if(userInfo!=null) {
	    		response.setStatusCode(200);
	   			response.setMessage("Password modified succefully !!");
	   			response.setBean(userInfo);
	    	}
	    	else {
	    		response.setStatusCode(500);
	   			response.setMessage("Email and password  did`nt matched succefully !!");
	    	}
    	
		
		return response;
	}
    
    
    @PostMapping(path = "/addProduct", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
   	public ProductResponse addProduct(@RequestBody ProductInfo bean) {
    	ProductResponse response = new ProductResponse();
   		if (UserService.addProduct(bean)) {
   			// Added successfully
   			response.setStatusCode(200);
   			response.setMessage("product added succefully !!");
   			response.setBean(bean);
   		} else {
   			// Added Unsuccessfully
   			response.setStatusCode(500);
   			response.setMessage("product could`nt be added !!");
   		}

   		return response;
   	}// end of add product
    
    
    @PostMapping(path = "/viewProduct/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
 	public ProductResponse viewProduct(@PathVariable("id")int id) {
    	ProductResponse response = new ProductResponse();
 		        ProductInfo productInfo=UserService.searchProduct(id);
 		       if(productInfo!=null) {
 		    	  response.setStatusCode(200);
 		   			response.setMessage("The product data found !!");
 		   			response.setBean(productInfo);
 		       }
 		      else {
 		   			// Added Unsuccessfully
 		   			response.setStatusCode(500);
 		   			response.setMessage("Invalid product id !!");
 		   		     response.setBean(productInfo);
 		      }
    	
    	
 		return response;
 	}//end of view product
    
    
    
    
    
	
	
}
