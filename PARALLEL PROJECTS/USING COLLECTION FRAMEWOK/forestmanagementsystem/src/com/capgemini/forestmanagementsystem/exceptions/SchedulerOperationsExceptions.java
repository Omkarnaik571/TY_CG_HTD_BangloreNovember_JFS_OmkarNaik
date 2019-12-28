package com.capgemini.forestmanagementsystem.exceptions;

public class SchedulerOperationsExceptions {
	public static void deleteWithoutEntryForScheduler() {
		System.err.println("\nTHERE IS NO SCHEDULER DATA IN THE DATA BASE,  INSERT DATA FIRST THEN DELETE  ....\n");
	}
	
	
	
}
