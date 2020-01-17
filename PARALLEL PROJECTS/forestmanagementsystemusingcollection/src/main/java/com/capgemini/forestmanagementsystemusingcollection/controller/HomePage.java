package com.capgemini.forestmanagementsystemusingcollection.controller;

import java.util.Scanner;

import com.capgemini.forestmanagementsystemusingcollection.service.ClientService;
import com.capgemini.forestmanagementsystemusingcollection.service.ClientServiceImpl;
import com.capgemini.forestmanagementsystemusingcollection.validations.Validations;

public class HomePage {
	public static void main(String[] args) {
		while (true) {
			System.out.println("\n--------------------------FOREST MANAGEMENT SYSTEM-------------------\n");
			System.out.println("1 Admin Page");
			System.out.println("2 Client Page");
			System.out.println("3 Scheduler Page");
			Scanner sc = new Scanner(System.in);
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
			int page = Integer.parseInt(choice);
			switch (page) {
			case 1:
				AdminPage.adminAuthentication();
				break;
			case 2:
				ClientPage.clientAuthentication();
				break;
			case 3:
	        SchedulerPage.schedulerAuthentication();      
				break;
			default:
				System.err.println("\nPLEASE SELECT A VALID OPTION \n");
				break;
			}

		}
	}

}
