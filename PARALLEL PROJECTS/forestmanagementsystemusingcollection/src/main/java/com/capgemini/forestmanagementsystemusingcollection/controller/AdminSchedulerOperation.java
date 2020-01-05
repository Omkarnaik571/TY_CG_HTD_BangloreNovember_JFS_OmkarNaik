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
	static PasswordValidator pv = new PasswordValidator();

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
				SchedulerDetails cd = new SchedulerDetails();
				System.out.println("Enter Scheduler username");
				String username = null;
				char u = 'y';
				while (u == 'y') {
					username = sc.next();

					if (Validations.isStringOnlyAlphabet(username)) {
						u = 'n';
					} else {
						System.err.println("Please enter only alphabets!");
					}
				}
				cd.setSchedulerUserName(username);
				System.out.println("Enter scheduler password");
				char f = 'n';
				String f1 = null;
				while (f == 'n') {
					f1 = sc.next();
					if (pv.validate(f1)) {
						f = 'x';
					} else {
						System.err.println("Password must contains one digit from 0-9 ");
						System.err.println("one lowercase character, one uppercase character ");
						System.err.println(
								"one special symbol in the list [@#$%],  and length between 8 characters and maximum of 20 ");
					}
				}
				cd.setSchedulerPassword(f1);
				try {
					if (schedulerService.addSchedule(cd)) {
						System.out.println("\nACCOUNT CREATED FOR CLIENT\n");
					}
				} catch (ExceptionWhileInserting e) {
					e.exceptionMessage();
				}

				break;
			case 2:
				try {
					TreeMap<String, String> client = schedulerService.showSchedules();
					Set<Map.Entry<String, String>> s1 = client.entrySet();
					for (Map.Entry<String, String> entry : s1) {
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
				String username1 = null;
				char u1 = 'y';
				while (u1 == 'y') {
					username1 = sc.next();

					if (Validations.isStringOnlyAlphabet(username1)) {
						u1 = 'n';
					} else {
						System.err.println("Please enter only alphabets!");
					}
				}
				try {
					if (schedulerService.removeSchedule(username1)) {
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
