package com.capgemini.forestmanagementsystemusingcollection.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmanagementsystemusingcollection.dto.ClientDetails;

class ClientServiceTest {

	static ClientService clientService=new ClientServiceImpl();
	static ClientDetails clientDetails=new ClientDetails();
	
	
	@BeforeAll
	static void testAddClient() {
	  clientDetails.setClientUserName("Omkar");
		clientDetails.setClientPassword("Omkar@97");
		clientService.addClient(clientDetails);	
	}
	
	
	
	@Test
	void testAddClient1() {
		clientDetails.setClientUserName("sunil");
		clientDetails.setClientPassword("Aaryan@97");
		       boolean isAdded=clientService.addClient(clientDetails);
		assertTrue(isAdded);
	}

	@Test
	void testShowAllClients() {
		assertNotNull(clientService.showAllClients());
		
	}

	@Test
	void testRemoveClient() {
		boolean isRemoved=clientService.removeClient("Omkar");
		assertTrue(isRemoved);
	}

	@Test
	void testUpdateClient() {
		ClientDetails clientDetails1=new ClientDetails();
		clientDetails1.setClientUserName("aaryan");
		clientDetails1.setClientPassword("Omkar@97");
		boolean isModified=clientService.updateClient(clientDetails1);
		assertTrue(isModified);
	}


	@Test
	void testViewSingleClient() {
		assertNotNull(clientService.viewSingleClient("Omkar"));
		
	}

	
	
	

}
