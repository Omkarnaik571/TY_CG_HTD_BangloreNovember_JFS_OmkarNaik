package com.capgemini.forestmanagementsystemusingcollection.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmanagementsystemusingcollection.dto.ClientDetails;

class ClientDaoTest {

	static ClientDao clientDao=new ClientDaoimpl();
	static ClientDetails clientDetails=new ClientDetails();
	
	
	@BeforeAll
	static void testAddClient() {
	  clientDetails.setClientUserName("Omkar");
		clientDetails.setClientPassword("Omkar@97");
		clientDao.addClient(clientDetails);	
	}
	
	
	
	@Test
	void testAddClient1() {
		clientDetails.setClientUserName("sunil");
		clientDetails.setClientPassword("Aaryan@97");
		       boolean isAdded=clientDao.addClient(clientDetails);
		assertTrue(isAdded);
	}

	@Test
	void testShowAllClients() {
		assertNotNull(clientDao.showAllClients());
		
	}

	@Test
	void testRemoveClient() {
		boolean isRemoved=clientDao.removeClient("Omkar");
		assertTrue(isRemoved);
	}

	@Test
	void testUpdateClient() {
		ClientDetails clientDetails1=new ClientDetails();
		clientDetails1.setClientUserName("aaryan");
		clientDetails1.setClientPassword("Omkar@97");
		boolean isModified=clientDao.updateClient(clientDetails1);
		assertTrue(isModified);
	}


	@Test
	void testViewSingleClient() {
		assertNotNull(clientDao.viewSingleClient("Omkar"));
		
	}

}
