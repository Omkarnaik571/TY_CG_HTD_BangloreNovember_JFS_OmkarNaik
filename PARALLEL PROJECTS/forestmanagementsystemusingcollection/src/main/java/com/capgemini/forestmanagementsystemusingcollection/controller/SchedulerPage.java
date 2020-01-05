package com.capgemini.forestmanagementsystemusingcollection.controller;

import java.util.Scanner;

import com.capgemini.forestmanagementsystemusingcollection.dto.ClientDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.validations.PasswordValidator;
import com.capgemini.forestmanagementsystemusingcollection.validations.Validations;

public class SchedulerPage extends AdminSchedulerOperation {
	
	static PasswordValidator pv=new PasswordValidator();
	public static void schedulerAuthentication() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("--------SCHEDULER PAGE------------");
		System.out.println("Enter username");
		String user=sc.next();
		System.out.println("Enter password");
		String pass=sc.next();
        String dbPass=null;
		try {
		dbPass = schedulerService.getSchedule(user);
		} catch (ExceptionWhileDisplaying e) {
			e.exceptionMessage();
		}
		if(pass.equals(dbPass)) {
			schedulerPage();
		}
		else {
			System.err.println("Incorrect Password !!");
			while(true) {
				System.out.println("\n1. Go back to Admin Page ");
				System.out.println("\n2. Try LogIn Again");
				char a='n';
				String choice=null;
				while(a=='n') {
					choice=sc.next();

					if(Validations.isNumber1(choice)) {
						a='x';
					}
					else {
						System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
					}
				}
				int option=Integer.parseInt(choice);
				switch (option) {
				case 1:
                     AdminPage.adminAuthentication();
					break;
				case 2:
                       System.out.println("------Try LogIn Again------");
                       schedulerAuthentication();
					break;
				default:
					System.err.println("\nPLEASE SELECT A VALID OPTION\n");
					break;
				}

			}//end ofwhile
		}


	}
    
	public static void schedulerPage() {
while(true) {
			
			Scanner sc=new Scanner(System.in); 
			System.out.println("\n----------------------SCHEDULER PAGE--------------------------------\n");
			System.out.println("PRESS 1 TO PERFORM CONTRACT OPERATION");  
			System.out.println("PRESS 2 TO GO TO ADMIN PAGE");
			char a='n';
			String choice=null;
			while(a=='n') {
				choice=sc.next();

				if(Validations.isNumber1(choice)) {
					a='x';
				}
				else {
					System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
				}
			}
			int option=Integer.parseInt(choice);
			switch (option) {
			case 1:
				SchedulerContractOperation.schedulerContractOperation();
				break;
			case 4:
				AdminPage.adminPage();
				break;

			default:
				System.err.println("\nPLEASE SELECT A VALID OPTION\n");
				break;
			}
		}//end of while loop

		
		
		
		
		
		
	}//end of method

}//end of class
