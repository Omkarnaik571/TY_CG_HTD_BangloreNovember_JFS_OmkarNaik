package com.capgemini.forestmanagementsystemusingcollection.controller;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.ClientDetails;
import com.capgemini.forestmanagementsystemusingcollection.dto.SchedulerDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;
import com.capgemini.forestmanagementsystemusingcollection.service.ClientService;
import com.capgemini.forestmanagementsystemusingcollection.service.ClientServiceImpl;
import com.capgemini.forestmanagementsystemusingcollection.service.SchedulerService;
import com.capgemini.forestmanagementsystemusingcollection.service.SchedulerServiceImpl;
import com.capgemini.forestmanagementsystemusingcollection.validations.PasswordValidator;
import com.capgemini.forestmanagementsystemusingcollection.validations.Validations;

public class AdminSchedulerOperation {
	static SchedulerService schedulerService = new SchedulerServiceImpl();
	static PasswordValidator passwordValidator = new PasswordValidator();

	public static void adminSchedulerOperation() {
		while (true) {

			Scanner sc = new Scanner(System.in);
			System.out.println("HERE ARE THE CHOICES: ");
			System.out.println("PRESS 1 TO ADD A NEW SCHEDULER");
			System.out.println("PRESS 2 TO VIEW ALL THE SCHEDULER DETAILS");
			System.out.println("PRESS 3 TO DELETE A SCHEDULER");
			System.out.println("PRESS 4 TO GO TO ADMIN OPERATIONS PAGE");
			System.out.println("\nENTER YOUR CHOICE: --> ");
			char a = 'n';
			String choice = null;
			while (a == 'n') {
				choice = sc.next();
				if (Validations.isNumber1(choice)) {
					a = 'x';
				} else {
					System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
				}
			}
			int ch = Integer.parseInt(choice);
			switch (ch) {
			case 1:
				SchedulerDetails schedulerDetails = new SchedulerDetails();
				System.out.println("Enter Scheduler username");
				String userName = null;
				char userNameChoice = 'y';
				while (userNameChoice == 'y') {
					userName = sc.next();

					if (Validations.isStringOnlyAlphabet(userName)) {
						userNameChoice = 'n';
					} else {
						System.err.println("Please enter only alphabets!");
					}
				}
				schedulerDetails.setSchedulerUserName(userName);
				System.out.println("Enter scheduler password");
				char schedulerPasswordChoice = 'n';
				String schedulerPassword = null;
				while (schedulerPasswordChoice == 'n') {
					schedulerPassword = sc.next();
					if (passwordValidator.validate(schedulerPassword)) {
						schedulerPasswordChoice = 'x';
					} else {
						System.err.println("Password must contains one digit from 0-9 ");
						System.err.println("one lowercase character, one uppercase character ");
						System.err.println(
								"one special symbol in the list [@#$%],  and length between 8 characters and maximum of 20 ");
					}
				}
				schedulerDetails.setSchedulerPassword(schedulerPassword);
				try {
					if (schedulerService.addSchedule(schedulerDetails)) {
						System.out.println("\nACCOUNT CREATED FOR CLIENT\n");
					}
				} catch (ExceptionWhileInserting e) {
					e.exceptionMessage();
				}

				break;
			case 2:
				try {
					TreeMap<String, String> viewAllschedulerResult = schedulerService.showSchedules();
					Set<Map.Entry<String, String>> viewAllSchedulerSet = viewAllschedulerResult.entrySet();
					for (Map.Entry<String, String> entry : viewAllSchedulerSet) {
						System.out.println("------SCHEDULER DETAILS----------");
						System.out.println("Scheduler username :" + entry.getKey());
						System.out.println(entry.getValue());
						System.out.println("---------------\n");
					}
				} catch (ExceptionWhileDisplaying e) {
					e.exceptionMessage();
				}

				break;
			case 3:
				System.out.println("Enter Scheduler username to remove");
				String schedulerUserNameToRemove = null;
				char u1 = 'y';
				while (u1 == 'y') {
					schedulerUserNameToRemove = sc.next();

					if (Validations.isStringOnlyAlphabet(schedulerUserNameToRemove)) {
						u1 = 'n';
					} else {
						System.err.println("Please enter only alphabets!");
					}
				}
				try {
					if (schedulerService.removeSchedule(schedulerUserNameToRemove)) {
						System.out.println("Scheduler account removed");
					}
				} catch (ExceptionWhileDeleting e) {
					e.exceptionMessage();
				}

				break;
			case 4:
				AdminPage.adminPage();
				break;
			default:
				System.err.println("\nENTER A VALID OPTION\n");
				break;
			}

		} // end of while

	}// end of method

}// end of class..
