package com.capgemini.forestmanagementsystemusingspringboot;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.forestmanagementsystemusingspringboot.dao.LandDao;
import com.capgemini.forestmanagementsystemusingspringboot.dto.LandDetailsDto;
@SpringBootTest
class LandDaoTest {


	@Autowired
	LandDao landDao;
	
	
	@Test
	void testAddLand() {
		LandDetailsDto landDetailsDto=new LandDetailsDto();
		landDetailsDto.setPlotNumber(100);
		landDetailsDto.setLandValue("10000");
		landDetailsDto.setAcquiredDate("10/1/2019");
		landDetailsDto.setLocation("Marathalli");
		 boolean isAdded=landDao.addLand(landDetailsDto);
		assertTrue(isAdded);
		landDao.deleteLand(landDetailsDto.getPlotNumber());
	}

	
	
	
	@Test
	void testViewAllLand() {
		assertNotNull(landDao.viewAllLand());
	}

	@Test
	void testDeleteLand() {
		
		LandDetailsDto landDetailsDto=new LandDetailsDto();
		landDetailsDto.setPlotNumber(100);
		landDetailsDto.setLandValue("10000");
		landDetailsDto.setAcquiredDate("10/1/2019");
		landDetailsDto.setLocation("Marathalli");
		landDao.addLand(landDetailsDto);
		 boolean isDeleted=landDao.deleteLand(landDetailsDto.getPlotNumber());
		assertTrue(isDeleted);
	}

	@Test
	void testModifyLand() {
		LandDetailsDto landDetailsDto=new LandDetailsDto();
		landDetailsDto.setPlotNumber(100);
		landDetailsDto.setLandValue("10000");
		landDetailsDto.setAcquiredDate("10/1/2019");
		landDetailsDto.setLocation("Marathalli");
		landDao.addLand(landDetailsDto);
		 boolean isModify=landDao.modifyLand(landDetailsDto);
		assertTrue(isModify);
		landDao.deleteLand(landDetailsDto.getPlotNumber());
		
	}

}
