package com.capgemini.forestmanagementsystem.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmanagementsystem.dto.AuthenticationDetailsDto;

class AuthenticationDetailsDaoTest {

	static AuthenticationDetailsDao authenticationDetailsDao=new AuthenticationDetailsDaoImpl();
	static AuthenticationDetailsDto authenticationDetailsDto=new AuthenticationDetailsDto();
	static AuthenticationDetailsDto authenticationDetailsDto1;
	
	
	@BeforeAll
	static void testAddUser() {
		authenticationDetailsDto.setUserName("OmkarNaik");
		authenticationDetailsDto.setPassword("Omkar@98");
		authenticationDetailsDto.setRole("client");
		authenticationDetailsDao.addUser(authenticationDetailsDto);
	}
	
	@Test
     void testAddUser1() {
		authenticationDetailsDto1=new AuthenticationDetailsDto();
		authenticationDetailsDto1.setUserName("AaaryanNaik");
		authenticationDetailsDto1.setPassword("Aaryan@98");
		authenticationDetailsDto1.setRole("client");
		 boolean isAdded=authenticationDetailsDao.addUser(authenticationDetailsDto1);
	     assertTrue(isAdded);
	}
	

	@Test
	void testDeleteUser() {
		boolean isDeleted=authenticationDetailsDao.deleteUser(authenticationDetailsDto1);
		assertTrue(isDeleted);
	}

	@Test
	void testModifyUser() {
		boolean isModified=authenticationDetailsDao.modifyUser(authenticationDetailsDto, "dhfbjdf");
		assertTrue(isModified);
	}


	@Test
	void testViewAllClients() {
		assertNotNull(authenticationDetailsDao.viewAllClients());
	}

	@Test
	void testViewAllScheduers() {
		assertNotNull(authenticationDetailsDao.viewAllScheduers());
	}

	@Test
	void testCheckUser() {
		
		assertNotNull(authenticationDetailsDao.checkUser(authenticationDetailsDto));
	}

}
