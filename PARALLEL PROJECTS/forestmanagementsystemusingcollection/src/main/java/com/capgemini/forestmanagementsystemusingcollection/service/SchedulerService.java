package com.capgemini.forestmanagementsystemusingcollection.service;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.SchedulerDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;

public interface SchedulerService {

	public boolean addSchedule(SchedulerDetails bean);

	public TreeMap<String, String> showSchedules();

	boolean modifySchedule(String userName, SchedulerDetails bean);

	boolean removeSchedule(String userName);

	String getSchedule(String userName);

}
