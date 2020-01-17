package com.capgemini.forestmanagementsystemusingspringrest.controller;

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

import com.capgemini.forestmanagementsystemusingspringrest.dto.CustomerDetailsDto;
import com.capgemini.forestmanagementsystemusingspringrest.dto.CustomerResponse;
import com.capgemini.forestmanagementsystemusingspringrest.dto.LandDetailsDto;
import com.capgemini.forestmanagementsystemusingspringrest.dto.LandResponse;
import com.capgemini.forestmanagementsystemusingspringrest.service.CustomerService;
import com.capgemini.forestmanagementsystemusingspringrest.service.LandService;

@CrossOrigin(origins = "*" , allowedHeaders = "*", allowCredentials = "true")
@RestController
public class LandOperationController {
	
	@Autowired
	LandService landService;	
	
	@PostMapping(path = "/addLand", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
 	public LandResponse addLand(@RequestBody LandDetailsDto bean) {
		LandResponse response = new LandResponse();
 		if (landService.addLand(bean)) {
 			// Added successfully
 			response.setStatuscode(200);
 			response.setMessage("land added succefully !!");
 			response.setDescription("land added succefully !!");
 		} else {
 			// Added Unsuccessfully
 			response.setStatuscode(444);
 			response.setMessage("land could`nt be added !!");
 			response.setMessage("land could`nt be added !!");
 		}

 		return response;
 	}// end of add land
	
	
	
	@DeleteMapping(path = "/deleteLand/{plotNumber}",produces = MediaType.APPLICATION_JSON_VALUE)
	public LandResponse deleteLand(@PathVariable("plotNumber")int id) {
		LandResponse response = new LandResponse();
		CustomerDetailsDto customerDetailsDto=new CustomerDetailsDto();
		customerDetailsDto.setCustomerId(id);
		if(landService.deleteLand(id)) {
			//Deletion successfully
			response.setStatuscode(200);
			response.setMessage("Land deleted Successfully !!");
			response.setDescription("Land deleted Successfully !!");
		}
		else {
			//Deletion unsuccessful Unsuccessfully
			response.setStatuscode(444);
			response.setMessage("Land deletion unsuccessful !!");
			response.setMessage("Land deletion unsuccessful !!");
		}
		return response;
	}//end of delete land
	
	
	
	@GetMapping(path = "/viewallLand", produces = MediaType.APPLICATION_JSON_VALUE)
 	public LandResponse viewallLand() {
		LandResponse response = new LandResponse();
 		List<LandDetailsDto> result = landService.viewAllLand();
 		if(!result.isEmpty()) {
 			response.setStatuscode(200);
 	 		response.setMessage("All land details found !!");
 	 		response.setDescription("All land details found !!");
 	 		response.setBean(result);	
 		}
      else {
			
			response.setStatuscode(444);
			response.setMessage("land data  not found !!");
			response.setDescription("land data  not found");
		}
 		
 		return response;
 	}// end of view all land
	
	
	
	@PutMapping(path = "/modifyLand",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
 	public LandResponse modifyLand(@RequestBody LandDetailsDto bean) {
		LandResponse response=new LandResponse();
 		if(landService.modifyLand(bean)) {
 			response.setStatuscode(200);
 			response.setMessage("land data modified succesfully  !!");
 			response.setDescription("land data modified succesfully  !!");
 			
 		}
 		else {
 			response.setStatuscode(444);
 			response.setMessage("land Modification unsuccessful !!");
 			response.setMessage("land Modification unsuccessful !!");
 			
 		}
 		
 		return response;
 	}
	
	
	
	
	

}
