package com.capgemini.forestmanagementsystemusingspringrest.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestmanagementsystemusingspringrest.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystemusingspringrest.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystemusingspringrest.dto.AuthenticationDetailsDto;
import com.capgemini.forestmanagementsystemusingspringrest.dto.ContractResponse;
import com.capgemini.forestmanagementsystemusingspringrest.dto.ContractResponse;
import com.capgemini.forestmanagementsystemusingspringrest.dto.ContractResponse;
import com.capgemini.forestmanagementsystemusingspringrest.dto.ContractResponse;
import com.capgemini.forestmanagementsystemusingspringrest.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystemusingspringrest.service.ContractService;

@CrossOrigin(origins = "*" , allowedHeaders = "*", allowCredentials = "true")
@RestController
public class ContractOperationController {
     
	@Autowired
	ContractService contractService;
     
	
     @PostMapping(path = "/addContract", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
 	public ContractResponse addContract(@RequestBody ContractorDetailsDto bean) {
 		ContractResponse response = new ContractResponse();
 		if (contractService.addContractor(bean)) {
 			// Added successfully
 			response.setStatuscode(200);
 			response.setMessage("contract added succefully !!");
 			response.setDescription("contract added succefully !!");
 		} else {
 			// Added Unsuccessfully
 			response.setStatuscode(500);
 			response.setMessage("Either the customer id or product id that you have entered does`nt exists !!");
 			response.setDescription("Contract could`nt be added !!");
 		}

 		return response;
 	}// end of add Contract
     
     
     @GetMapping(path = "/viewallContract", produces = MediaType.APPLICATION_JSON_VALUE)
 	public ContractResponse viewallContract() {
 		ContractResponse response = new ContractResponse();
 		List<ContractorDetailsDto> result = contractService.viewContractorDetails();
 		if(!result.isEmpty()) {
 			response.setStatuscode(200);
 	 		response.setMessage("Contract details found !! ");
 	 		response.setDescription("Contract details are !!");
 	 		response.setBean(result);	
 		}
      else {
			
			response.setStatuscode(500);
			response.setMessage("No contracts available data not found");
			response.setDescription("customer data not found");
		}
 		
 		
 		
 		return response;

 	}// end of view all Contract
     
     
     @PostMapping(path = "/viewSingleContract", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
 	public ContractResponse viewSingleContract(@RequestBody ContractorDetailsDto bean) {
 		ContractorDetailsDto contractDetailsDto = contractService.viewSingleContractorDetails(bean);

 		ContractResponse response = new ContractResponse();
 		if (contractDetailsDto != null) {
 			response.setStatuscode(201);
 			response.setMessage("Success");
 			response.setDescription("Contract data found !!");
 			response.setBean(Arrays.asList(contractDetailsDto));

 		} else {
 			response.setStatuscode(444);
 			response.setMessage("failure");
 			response.setDescription("Invalid contract number !! ");
 		}
 		return response;
 	}// end of add User
     
     
   
     
     
     @PutMapping(path = "/modifyContract",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
 	public ContractResponse modifyContract(@RequestBody ContractorDetailsDto bean) {
    	 ContractResponse response=new ContractResponse();
 		if(contractService.modifyContractDetails(bean)) {
 			response.setStatuscode(200);
 			response.setMessage("Contract Modified successfully !!");
 			response.setDescription("Contract successfully !!");
 			
 		}
 		else {
 			response.setStatuscode(444);
 			response.setMessage("Contract couldn`t modified !!");
 			response.setMessage("Contract Modification !!");
 			
 		}
 		
 		return response;
 	}
     
     
     @DeleteMapping(path = "/deleteContract/{contractNo}",produces = MediaType.APPLICATION_JSON_VALUE)
 	public ContractResponse deleteContract(@PathVariable("contractNo")int id) {
 		ContractResponse response = new ContractResponse();
 		ContractorDetailsDto customerDetailsDto=new ContractorDetailsDto();
 		customerDetailsDto.setCustomerId(id);
 		if(contractService.deleteContractorDetails(id)) {
 			//Deletion successfully
 			response.setStatuscode(200);
 			response.setMessage("Success !!");
 			response.setDescription("Contract deleted Successfully !!");
 		}
 		else {
 			//Deletion unsuccessful Unsuccessfully
 			response.setStatuscode(444);
 			response.setMessage("Failure !!");
 			response.setMessage("Contract deletion unsuccessful !!");
 		}
 		return response;
 	}//end of delete contract
     
     
     
     
	
	
	
}
