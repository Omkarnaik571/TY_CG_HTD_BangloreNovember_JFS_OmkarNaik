package com.capgemini.forestmanagementsystemusingcollection.dao;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.SchedulerDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;

public interface SchedulerDao {

	public boolean addSchedule(SchedulerDetails bean) throws ExceptionWhileInserting;

	public TreeMap<String, String> showSchedules() throws ExceptionWhileDisplaying;

	boolean modifySchedule(String userName, SchedulerDetails bean) throws ExceptionWhileDisplaying;

	boolean removeSchedule(String userName) throws ExceptionWhileDeleting;

	String getSchedule(String userName) throws ExceptionWhileDisplaying;

}
