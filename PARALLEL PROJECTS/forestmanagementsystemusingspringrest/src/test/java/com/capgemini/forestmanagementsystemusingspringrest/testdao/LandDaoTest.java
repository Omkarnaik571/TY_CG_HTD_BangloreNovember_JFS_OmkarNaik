package com.capgemini.forestmanagementsystemusingspringrest.testdao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestmanagementsystemusingspringrest.config.OrmConfig;
import com.capgemini.forestmanagementsystemusingspringrest.dao.CustomerDetailsDao;
import com.capgemini.forestmanagementsystemusingspringrest.dao.LandDao;
import com.capgemini.forestmanagementsystemusingspringrest.dto.LandDetailsDto;
import com.capgemini.forestmanagementsystemusingspringrest.testconfig.TestBeans;
@SpringJUnitConfig(classes = { TestBeans.class, OrmConfig.class })
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
