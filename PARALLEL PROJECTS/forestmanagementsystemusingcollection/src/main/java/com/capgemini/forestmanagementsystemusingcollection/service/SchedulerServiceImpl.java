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

	@Override
	public boolean addSchedule(SchedulerDetails bean) throws ExceptionWhileInserting {

		return dao.addSchedule(bean);
	}

	@Override
	public TreeMap<String, String> showSchedules() throws ExceptionWhileDisplaying {
		return dao.showSchedules();
	}

	@Override
	public boolean modifySchedule(String userName, SchedulerDetails bean) throws ExceptionWhileDisplaying {

		return dao.modifySchedule(userName, bean);
	}

	@Override
	public boolean removeSchedule(String userName) throws ExceptionWhileDeleting {

		return dao.removeSchedule(userName);
	}

	@Override
	public String getSchedule(String userName) throws ExceptionWhileDisplaying {

		return dao.getSchedule(userName);
	}

}
