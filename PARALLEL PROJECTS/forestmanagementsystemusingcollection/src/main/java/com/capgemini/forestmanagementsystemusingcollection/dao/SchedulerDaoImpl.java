package com.capgemini.forestmanagementsystemusingcollection.dao;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.SchedulerDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;

public class SchedulerDaoImpl implements SchedulerDao {

	TreeMap<String, String> mapForScheduler = new TreeMap<String, String>();

	@Override
	public boolean addSchedule(SchedulerDetails bean) throws ExceptionWhileInserting {
		if (mapForScheduler.containsKey(bean.getSchedulerUserName())) {
			throw new ExceptionWhileInserting("Scheduler username already exists duplicate schedule id not allowed");
		} else {
			mapForScheduler.put(bean.getSchedulerUserName(), bean.getSchedulerPassword());
			return true;
		}
	}

	@Override
	public boolean removeSchedule(String userName) throws ExceptionWhileDeleting {
		if (mapForScheduler.containsKey(userName)) {
			mapForScheduler.remove(userName);
			return true;
		} else {
			throw new ExceptionWhileDeleting("Scheduler account does not exist");
		}

	}

	@Override
	public TreeMap<String, String> showSchedules() throws ExceptionWhileDisplaying {
		if (mapForScheduler.size() != 0) {
			return mapForScheduler;
		} else {
			throw new ExceptionWhileDisplaying("There are no schedulers present in the database");
		}
	}

	@Override
	public boolean modifySchedule(String userName, SchedulerDetails bean) throws ExceptionWhileDisplaying {
		try {
			if (mapForScheduler.containsKey(userName)) {
				mapForScheduler.put(userName, bean.getSchedulerPassword());

			}
		} // end of try
		catch (Exception e) {
			throw new ExceptionWhileDisplaying("scheduler username and password didn`t matched !! ");
		}
		return true;
	}

	@Override
	public String getSchedule(String userName) throws ExceptionWhileDisplaying {
		if (mapForScheduler.containsKey(userName)) {
			String password = mapForScheduler.get(userName);
			return password;
		} else {
			throw new ExceptionWhileDisplaying("scheduler account not found");
		}

	}

}// end of class
