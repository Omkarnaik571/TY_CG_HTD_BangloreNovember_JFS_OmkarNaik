package com.capgemini.forestmanagementsystem.dao;

import com.capgemini.forestmanagementsystem.dto.ClientDetailsDto;
import com.capgemini.forestmanagementsystem.dto.SchedulerDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public interface SchedulerDetailsDao {

public boolean addScheduler(SchedulerDetailsDto cld) throws CustomExceptions;
	
	public boolean deleteScheduler(SchedulerDetailsDto cld);
	
	public boolean modifyScheduler(SchedulerDetailsDto cld,String pass);
	
	public boolean viewAllScheduler();
	
	
}
