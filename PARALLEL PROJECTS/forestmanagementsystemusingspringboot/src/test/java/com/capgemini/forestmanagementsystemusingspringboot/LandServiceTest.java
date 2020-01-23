package com.capgemini.forestmanagementsystemusingspringboot;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.forestmanagementsystemusingspringboot.dto.LandDetailsDto;
import com.capgemini.forestmanagementsystemusingspringboot.service.LandService;
@SpringBootTest
class LandServiceTest {

	

	@Autowired
	LandService landService;
	
	
	@Test
	void testAddLand() {
		LandDetailsDto landDetailsDto=new LandDetailsDto();
		landDetailsDto.setPlotNumber(100);
		landDetailsDto.setLandValue("10000");
		landDetailsDto.setAcquiredDate("10/1/2019");
		landDetailsDto.setLocation("Marathalli");
		 boolean isAdded=landService.addLand(landDetailsDto);
		assertTrue(isAdded);
		landService.deleteLand(landDetailsDto.getPlotNumber());
	}

	
	
	
	@Test
	void testViewAllLand() {
		assertNotNull(landService.viewAllLand());
	}

	@Test
	void testDeleteLand() {
		
		LandDetailsDto landDetailsDto=new LandDetailsDto();
		landDetailsDto.setPlotNumber(100);
		landDetailsDto.setLandValue("10000");
		landDetailsDto.setAcquiredDate("10/1/2019");
		landDetailsDto.setLocation("Marathalli");
		landService.addLand(landDetailsDto);
		 boolean isDeleted=landService.deleteLand(landDetailsDto.getPlotNumber());
		assertTrue(isDeleted);
	}

	@Test
	void testModifyLand() {
		LandDetailsDto landDetailsDto=new LandDetailsDto();
		landDetailsDto.setPlotNumber(100);
		landDetailsDto.setLandValue("10000");
		landDetailsDto.setAcquiredDate("10/1/2019");
		landDetailsDto.setLocation("Marathalli");
		landService.addLand(landDetailsDto);
		 boolean isModify=landService.modifyLand(landDetailsDto);
		assertTrue(isModify);
		landService.deleteLand(landDetailsDto.getPlotNumber());
		
	}

	
	
	
	
}
