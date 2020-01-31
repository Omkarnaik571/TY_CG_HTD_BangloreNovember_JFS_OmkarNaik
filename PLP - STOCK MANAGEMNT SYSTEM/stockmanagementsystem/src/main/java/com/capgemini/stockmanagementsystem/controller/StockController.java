package com.capgemini.stockmanagementsystem.controller;

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

import com.capgemini.stockmanagementsystem.dto.AuthenticationDto;
import com.capgemini.stockmanagementsystem.dto.AuthenticationResponse;
import com.capgemini.stockmanagementsystem.dto.StockDetails;
import com.capgemini.stockmanagementsystem.dto.StockResponse;
import com.capgemini.stockmanagementsystem.service.StockService;

@CrossOrigin(origins = "*" , allowedHeaders = "*", allowCredentials = "true")
@RestController
public class StockController {

	@Autowired
	StockService stockService;
	
	
	@PostMapping(path = "/addCompanyStock", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public StockResponse addCompanyStock(@RequestBody StockDetails stockDetails) {
		StockResponse response = new StockResponse();
		int added=stockService.addCompanyStock(stockDetails);
		if(added==1) {
			response.setStatusCode(200);
			response.setMessage("Stock added successfully !!");
		}else if(added==0) {
			response.setStatusCode(700);
			response.setMessage("Your max buy option exceeds, available stocks !!");
		}else {
			response.setStatusCode(400);
			response.setMessage("Duplicate stock name !!");
		}
		return response;
	}
	
	@DeleteMapping(path = "/removeCompanyStock/{stockId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public StockResponse removeCompanyStock(@PathVariable ("stockId")int stockId ) {
		StockResponse response = new StockResponse();
		StockDetails stockDetails=new StockDetails();
		stockDetails.setStockId(stockId);
		if (stockService.removeCompanyStock(stockDetails)) {
			// Added successfully
			response.setStatusCode(200);
			response.setMessage("Stock removed successfully !!");
		} else {
			// Added Unsuccessfully
			response.setStatusCode(400);
			response.setMessage("Deletion failed !!");
		}
		return response;
	}
	

	@GetMapping(path = "/viewAllStocks", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StockDetails> viewAllStocks() {
		List<StockDetails> result = stockService.viewAllStockDetails();
		return result;
	}
	
	
	@PutMapping(path = "/updateCompanyStock", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public StockResponse updateCompanyStock(@RequestBody StockDetails stockDetails) {
		StockResponse response = new StockResponse();
		int updated=stockService.updateStockDetails(stockDetails);
		if(updated==1) {
			response.setStatusCode(200);
			response.setMessage("Stock updated successfully !!");
		}else if(updated==0) {
			response.setStatusCode(700);
			response.setMessage("Your max buy option exceeds, available stocks !!");
		}else {
			response.setStatusCode(400);
			response.setMessage("Duplicate stock name !!");
		}
		return response;
	}
	
	

	
}
