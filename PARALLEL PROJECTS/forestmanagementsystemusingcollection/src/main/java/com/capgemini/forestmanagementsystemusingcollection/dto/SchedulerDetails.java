package com.capgemini.forestmanagementsystemusingcollection.dto;

public class SchedulerDetails {
	
	private String schedulerUserName;
	private String schedulerPassword;
	
	
	public String getSchedulerUserName() {
		return schedulerUserName;
	}
	public void setClientUserName(String schedulerUserName) {
		this.schedulerUserName = schedulerUserName;
	}
	public String getSchedulerPassword() {
		return schedulerPassword;
	}
	public void setClientPassword(String schedulerPassword) {
		this.schedulerPassword = schedulerPassword;
	}
	@Override
	public String toString() {
		return "Scheduler User Name = " + schedulerUserName + "\nScheduler Password=" + schedulerPassword;
	}
	

	
	
	
	
}
