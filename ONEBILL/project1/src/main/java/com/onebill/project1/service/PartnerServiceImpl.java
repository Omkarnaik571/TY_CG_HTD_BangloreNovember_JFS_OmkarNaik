package com.onebill.project1.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.project1.dao.PartnerDao;
import com.onebill.project1.dto.Address;
import com.onebill.project1.dto.Customer;
import com.onebill.project1.dto.Email;
import com.onebill.project1.dto.Partner;

@Service
public class PartnerServiceImpl implements PartnerService{

	@Autowired
	PartnerDao partnerDao;
	
	
	@Override
	public int addPartner(Partner partner) {
		
		//To check whether identification id is present or not
		if(partner.getPartnerIdentificationId()==0) {
			return 2;
		}
		
		//If customer data are added with partner data
		ArrayList<Customer> customers=(ArrayList<Customer>) partner.getCustomers();
		  
		if(!customers.isEmpty()) {
			
			for (Customer c1 : customers) {
				//Setting up the addresses for each customers
				ArrayList<Address> customerAddress=(ArrayList<Address>) c1.getCustomerAddresses();
			     for (Address cAddrs : customerAddress) {
					cAddrs.setCustomerForAddress(c1);
					c1.setCustomerAddresses(customerAddress);
				}
			   //Setting up the email for each customers
			   ArrayList<Email> customerEmails=(ArrayList<Email>) c1.getCustomerEmails();
			   for (Email cEmails : customerEmails) {
				cEmails.setCustomerEmail(c1);
				c1.setCustomerEmails(customerEmails);
			}
			     
				c1.setPartner(partner);
			}
			partner.setCustomers(customers);	
			
		}
				
		
		//Setting the addresses for partner
		ArrayList<Address> addresses=(ArrayList<Address>) partner.getPartnerAddresses();
		if(!addresses.isEmpty()) {
			for (Address a1 : addresses) {
				a1.setPartnerForAddress(partner);
			}
			partner.setPartnerAddresses(addresses);	
		}
		
		//Setting the email for partner
		ArrayList<Email> emails=(ArrayList<Email>) partner.getPartnerEmails();
		
		if(!emails.isEmpty()) {
			for (Email e1 : emails) {
				e1.setPartnerEmail(partner);
			}
			partner.setPartnerEmails(emails);	
		}
		
		
		
		return partnerDao.addPartner(partner);
	}

	@Override
	public Partner viewPartner(Partner partner) {
		
		return partnerDao.viewPartner(partner);
	}

	
	
	
	
	
}
