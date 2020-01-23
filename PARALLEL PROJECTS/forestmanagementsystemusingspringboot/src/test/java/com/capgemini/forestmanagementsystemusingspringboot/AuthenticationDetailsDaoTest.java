package com.capgemini.forestmanagementsystemusingspringboot;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.capgemini.forestmanagementsystemusingspringboot.dao.AuthenticationDetailsDao;
import com.capgemini.forestmanagementsystemusingspringboot.dto.AuthenticationDetailsDto;

@SpringBootTest
class AuthenticationDetailsDaoTest {

	@Autowired
	AuthenticationDetailsDao authenticationDetailsDao;

	@Test
	void testAddUser() {
		AuthenticationDetailsDto authenticationDetailsDto1 = new AuthenticationDetailsDto();
		authenticationDetailsDto1.setUserName("Aaryannaik007");
		authenticationDetailsDto1.setPassword("AaryanNaik@007");
		authenticationDetailsDto1.setAccountType("client");
        boolean isAdded=authenticationDetailsDao.addUser(authenticationDetailsDto1);
		assertTrue(isAdded);
		authenticationDetailsDao.delateUser(authenticationDetailsDto1);
	}

	@Test
	void testDelateUser() {
		AuthenticationDetailsDto authenticationDetailsDto3 = new AuthenticationDetailsDto();
		authenticationDetailsDto3.setUserName("Aaryannaik007");
		authenticationDetailsDto3.setPassword("AaryanNaik@007");
		authenticationDetailsDto3.setAccountType("client");
		authenticationDetailsDao.addUser(authenticationDetailsDto3);
		boolean isRemoved=authenticationDetailsDao.delateUser(authenticationDetailsDto3);
		assertTrue(isRemoved);
	}

	@Test
	void testModifyUser() {
		AuthenticationDetailsDto authenticationDetailsDto2 = new AuthenticationDetailsDto();
		authenticationDetailsDto2.setUserName("Sunilnnaik007");
		authenticationDetailsDto2.setPassword("AaryanNaik@007");
		authenticationDetailsDto2.setAccountType("client");
		authenticationDetailsDao.addUser(authenticationDetailsDto2);
		 boolean isModified=authenticationDetailsDao.modifyUser(authenticationDetailsDto2);
		 assertTrue(isModified);
		 authenticationDetailsDao.delateUser(authenticationDetailsDto2);
	}

	@Test
	void testViewSingleUserClient() {
		AuthenticationDetailsDto authenticationDetailsDto = new AuthenticationDetailsDto();
		authenticationDetailsDto.setUserName("Sunilnnaik007");
		authenticationDetailsDto.setPassword("AaryanNaik@007");
		authenticationDetailsDto.setAccountType("client");
		authenticationDetailsDao.addUser(authenticationDetailsDto);
		assertNotNull(authenticationDetailsDao.viewSingleUserClient(authenticationDetailsDto));
	    authenticationDetailsDao.delateUser(authenticationDetailsDto);
	}

	
	@Test
	void testViewAllClients() {
	    assertNotNull(authenticationDetailsDao.viewAllClients());	
	}

	@Test
	void testViewAllScheduers() {
		assertNotNull(authenticationDetailsDao.viewAllScheduers());	
	}
	
	

}
