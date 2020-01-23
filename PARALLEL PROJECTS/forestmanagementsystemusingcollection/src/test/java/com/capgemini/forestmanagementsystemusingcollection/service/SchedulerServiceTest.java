package com.capgemini.forestmanagementsystemusingcollection.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmanagementsystemusingcollection.dto.SchedulerDetails;

class SchedulerServiceTest {

	static SchedulerService schedulerService=new SchedulerServiceImpl();
	static SchedulerDetails schedulerDetails=new SchedulerDetails();
	
	
	@BeforeAll
	static void testAddSchedule() {
	  schedulerDetails.setClientUserName("Omkar");
		schedulerDetails.setClientPassword("Omkar@97");
		schedulerService.addSchedule(schedulerDetails);	
	}
	
	@Test
	void testAddSchedule1() {
	  schedulerDetails.setClientUserName("aaryan");
		schedulerDetails.setClientPassword("Omkar@97");
		       boolean isAdded=schedulerService.addSchedule(schedulerDetails);
		assertTrue(isAdded);
	}

	@Test
	void testShowSchedules() {
		assertNotNull(schedulerService.showSchedules());
	}

	@Test
	void testModifySchedule() {
		
		SchedulerDetails schedulerDetails1=new SchedulerDetails();
		schedulerDetails1.setClientUserName("aaryan");
		schedulerDetails1.setClientPassword("Omkar@97");
		boolean isModified=schedulerService.modifySchedule("aaryan", schedulerDetails1);
		assertTrue(isModified);
		
	}

	@Test
	void testRemoveSchedule() {
		boolean isRemoved=schedulerService.removeSchedule("Omkar");
		assertTrue(isRemoved);
	}

	@Test
	void testGetSchedule() {
		assertNotNull(schedulerService.getSchedule("Omkar"));
	}


}
