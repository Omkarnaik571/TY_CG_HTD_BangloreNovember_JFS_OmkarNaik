package com.onebill.project1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onebill.project1.dto.Partner;
import com.onebill.project1.dto.PartnerResponse;
import com.onebill.project1.service.PartnerService;

@RestController
@CrossOrigin
@RequestMapping("/partner-operations")
public class PartnerController {

	@Autowired
	PartnerService partnerService;
	
	
	@PostMapping(path = "/addPartner", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PartnerResponse insertPartner(@RequestBody Partner partner) {
		PartnerResponse response=new PartnerResponse();
		
		int isadded=partnerService.addPartner(partner);
		if(isadded ==1) {
			response.setStatusCode(200);
			response.setMessage("Partner Details Added successfully !!");
		}else {
			response.setStatusCode(300);
			response.setMessage("Partner Details could`nt be added !!");
		}
		
		return response;
	}
	
   
	@PostMapping(path = "/viewPartner", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PartnerResponse displayPartner(@RequestBody Partner partner) {
		PartnerResponse response=new PartnerResponse();
		
		Partner partnerFound=partnerService.viewPartner(partner);
		if(partnerFound!=null) {
			response.setStatusCode(200);
			response.setMessage("Partner Details found !!");
			response.setPartner(partnerFound);
		}else {
			response.setStatusCode(300);
			response.setMessage("Partner Details not found !!");
			response.setPartner(null);
		}
		
		return response;
	}

	
	
	
}
