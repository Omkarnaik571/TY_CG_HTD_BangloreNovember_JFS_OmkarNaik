package com.capgemini.forestmanagementsystemusingcollection.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmanagementsystemusingcollection.dto.SchedulerDetails;

class SchedulerDaoTest {

	static SchedulerDao schedulerDao=new SchedulerDaoImpl();
	static SchedulerDetails schedulerDetails=new SchedulerDetails();
	
	
	@BeforeAll
	static void testAddSchedule() {
	  schedulerDetails.setClientUserName("Omkar");
		schedulerDetails.setClientPassword("Omkar@97");
		schedulerDao.addSchedule(schedulerDetails);	
	}
	
	@Test
	void testAddSchedule1() {
	  schedulerDetails.setClientUserName("aaryan");
		schedulerDetails.setClientPassword("Omkar@97");
		       boolean isAdded=schedulerDao.addSchedule(schedulerDetails);
		assertTrue(isAdded);
	}

	@Test
	void testShowSchedules() {
		assertNotNull(schedulerDao.showSchedules());
	}

	@Test
	void testModifySchedule() {
		
		SchedulerDetails schedulerDetails1=new SchedulerDetails();
		schedulerDetails1.setClientUserName("aaryan");
		schedulerDetails1.setClientPassword("Omkar@97");
		boolean isModified=schedulerDao.modifySchedule("aaryan", schedulerDetails1);
		assertTrue(isModified);
		
	}

	@Test
	void testRemoveSchedule() {
		boolean isRemoved=schedulerDao.removeSchedule("Omkar");
		assertTrue(isRemoved);
	}

	@Test
	void testGetSchedule() {
		assertNotNull(schedulerDao.getSchedule("Omkar"));
	}

}
