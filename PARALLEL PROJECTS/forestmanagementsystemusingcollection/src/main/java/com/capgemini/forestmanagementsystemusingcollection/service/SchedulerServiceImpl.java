package com.capgemini.forestmanagementsystemusingcollection.service;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dao.SchedulerDao;
import com.capgemini.forestmanagementsystemusingcollection.dao.SchedulerDaoImpl;
import com.capgemini.forestmanagementsystemusingcollection.dto.SchedulerDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;

public class SchedulerServiceImpl implements SchedulerService {

	SchedulerDao dao = new SchedulerDaoImpl();

	
	public boolean addSchedule(SchedulerDetails bean) {

		return dao.addSchedule(bean);
	}

	
	public TreeMap<String, String> showSchedules()  {
		return dao.showSchedules();
	}

	
	public boolean modifySchedule(String userName, SchedulerDetails bean)  {

		return dao.modifySchedule(userName, bean);
	}

	
	public boolean removeSchedule(String userName) {

		return dao.removeSchedule(userName);
	}

	
	public String getSchedule(String userName){

		return dao.getSchedule(userName);
	}

}
