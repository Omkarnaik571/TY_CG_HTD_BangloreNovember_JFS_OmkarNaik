package com.capgemini.forestmanagementsystemusingcollection.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.TreeMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmanagementsystemusingcollection.dto.LandDetails;

class LandDaoImplTest {

	static LandDao landDao=new LandDaoImpl();
	static LandDetails landDetails=new LandDetails();
	
	
	@BeforeAll
	static void testAddLandDetail() {
		landDetails.setPlotNumber(1);
		landDetails.setOwner("Omkar");
		landDetails.setAcquiredDate("12/10/2019");
		landDetails.setPrice(1200000);
			landDao.addLandDetail(landDetails);
	}
	
	@Test
       void testAddLandDetail2() {
		LandDetails landDetails=new LandDetails();
		landDetails.setPlotNumber(2);
		landDetails.setOwner("Omkar");
		landDetails.setAcquiredDate("12/10/2019");
		landDetails.setPrice(1200000);
		boolean add = landDao.addLandDetail(landDetails);
		assertTrue(add);
		
	}

	@Test
	void testRemoveLandDetail() {
	boolean isDeleted=landDao.removeLandDetail(landDetails.getPlotNumber());
	assertTrue(isDeleted);
	}

	@Test
	void testDisplayAllLandDetails() {
		TreeMap<Integer, LandDetails> allland=landDao.displayAllLandDetails();
		assertNotNull(allland);
		
	}

	@Test
	void testGetSingleLandDetail() {
		    landDetails=landDao.getSingleLandDetail(1);
		      assertNotNull(landDetails);		
	}
	
	
	@Test
	void testModifyLandDetail() {
		 boolean isModified=landDao.modifyLandDetail(landDetails);
		assertTrue(isModified);
		
	}

}
