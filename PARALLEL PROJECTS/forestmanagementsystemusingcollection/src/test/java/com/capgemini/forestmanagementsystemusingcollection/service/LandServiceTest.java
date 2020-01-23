package com.capgemini.forestmanagementsystemusingcollection.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.TreeMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmanagementsystemusingcollection.dto.LandDetails;

class LandServiceTest {

	
	static LandService landService=new LandServiceImpl();
	static LandDetails landDetails=new LandDetails();
	
	
	@BeforeAll
	static void testAddLandDetail() {
		landDetails.setPlotNumber(1);
		landDetails.setOwner("Omkar");
		landDetails.setAcquiredDate("12/10/2019");
		landDetails.setPrice(1200000);
			landService.addLandDetail(landDetails);
	}
	
	@Test
       void testAddLandDetail2() {
		LandDetails landDetails=new LandDetails();
		landDetails.setPlotNumber(2);
		landDetails.setOwner("Omkar");
		landDetails.setAcquiredDate("12/10/2019");
		landDetails.setPrice(1200000);
		boolean add = landService.addLandDetail(landDetails);
		assertTrue(add);
		
	}

	@Test
	void testRemoveLandDetail() {
	boolean isDeleted=landService.removeLandDetail(landDetails.getPlotNumber());
	assertTrue(isDeleted);
	}

	@Test
	void testDisplayAllLandDetails() {
		TreeMap<Integer, LandDetails> allland=landService.displayAllLandDetails();
		assertNotNull(allland);
		
	}

	@Test
	void testGetSingleLandDetail() {
		    landDetails=landService.getSingleLandDetail(1);
		      assertNotNull(landDetails);		
	}
	
	
	@Test
	void testModifyLandDetail() {
		 boolean isModified=landService.modifyLandDetail(landDetails);
		assertTrue(isModified);
		
	}
	
	
}
