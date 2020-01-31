package com.capgemini.stockmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.stockmanagementsystem.dto.InvestorDetails;
import com.capgemini.stockmanagementsystem.dto.InvestorResponse;
import com.capgemini.stockmanagementsystem.service.InvestorService;

@CrossOrigin(origins = "*" , allowedHeaders = "*", allowCredentials = "true")
@RestController
public class InvestorController {

	@Autowired
	InvestorService investorService;
	
	@PostMapping(path = "/buyACompanyStock", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public InvestorResponse buyACompanyStock(@RequestBody InvestorDetails investorDetails) {
		InvestorResponse response = new InvestorResponse();
		int added=investorService.addInvestor(investorDetails);
		if(added==1) {
			response.setStatusCode(200);
			response.setMessage( investorDetails.getCompanyStockPurchased() +"  Stock Purchased by "+investorDetails.getInvestorUserName()+" for first time successfully !!");
		}else if(added==2) {
			response.setStatusCode(700);
			response.setMessage("The stock quantity which you want to buy is exceeding the limit set by company manager !!");
		}else if(added==0) {
			response.setStatusCode(800);
			response.setMessage("This invester has already bought this company stock, try to add more stock or sell stock !!");
		}else if(added==4) {
			response.setStatusCode(800);
			response.setMessage(investorDetails.getCompanyStockPurchased()+" stock is not listed in the StockExchange !!");
		}
		else {
			response.setStatusCode(400);
			response.setMessage("Buying limit for  "+investorDetails.getCompanyStockPurchased()+" stock is  [ "+added+" ] units !!");
		}
		return response;
	}
	
	
	@PostMapping(path = "/viewSingleInvestorDetails", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<InvestorDetails> viewSingleInvestorDetails(@RequestBody InvestorDetails investorDetails) {
		List<InvestorDetails> result = investorService.viewAllStockDetailsOfAnInvestor(investorDetails);
		return result;
	}
	
	
	@PutMapping(path = "/buyMoreStock", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public InvestorResponse buyMoreStock(@RequestBody InvestorDetails investorDetails) {
		InvestorResponse response = new InvestorResponse();
		int added=investorService.buyStock(investorDetails);
		if(added==1) {
			response.setStatusCode(200);
			response.setMessage(investorDetails.getQuantityBought() +"  more "+investorDetails.getCompanyStockPurchased() +"  Stock Purchased  successfully !!");
		}else if(added==2) {
			response.setStatusCode(700);
			response.setMessage("The stock quantity which you want to buy is exceeding the limit set by company manager !!");
		}
		else {
			response.setStatusCode(400);
			response.setMessage("Buying limit for  "+investorDetails.getCompanyStockPurchased()+" stock is  [ "+added+" ] units !!");
		}
		return response;
	}
	
	@PutMapping(path = "/sellStock", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public InvestorResponse sellStock(@RequestBody InvestorDetails investorDetails) {
		InvestorResponse response = new InvestorResponse();
		int added=investorService.sellStock(investorDetails);
		if(added==1) {
			response.setStatusCode(200);
			response.setMessage(investorDetails.getQuantityBought() +"  stocks of "+investorDetails.getCompanyStockPurchased() +"  Sold successfully !!");
		}else if(added==2) {
			response.setStatusCode(700);
			response.setMessage("The stock quantity which you want to sell is more than the amount of stocks available !!");
		}
		else {
			response.setStatusCode(400);
			response.setMessage("Buy more stock failed !!");
		}
		return response;
	}
	
	
	
	
}
