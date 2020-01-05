package com.capgemini.forestmanagementsystem.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.dto.AuthenticationDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.service.AuthenticationService;
import com.capgemini.forestmanagementsystem.validations.PasswordValidator;
import com.capgemini.forestmanagementsystem.validations.Validations;

public class AdminSchedulerOperation {
	static AuthenticationService authenticationService = FactoryClass.getAuthenticationServiceImpl();
    static PasswordValidator pv=new PasswordValidator();
	private static String[] args;	
	
	public static void adminSchedulerOperation() {
	
		while (true) {
	           AuthenticationDetailsDto cd=FactoryClass.getAuthenticationDetailsObject();
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
					System.out.println("Enter scheduler username");
					String username=null;
					char u = 'y';
					while(u=='y') {
						sc.nextLine();
						username= sc.nextLine();

						if(Validations.isvalidUserName(username)) {
							u='n';
						} else {
							System.err.println("User name cannot contain space, first letter should be an alphabet and length should be of 10 characters !!");
						}
					}
					cd.setUserName(username);
					System.out.println("ENTER THE SCHEDULER PASSWORD : ");
					char f='n';
					String f1=null;
					while(f=='n') {
						f1=sc.next();
						if( pv.validate(f1) ) {
							f='x';
						}
						else {
							System.err.println("Password must contains one digit from 0-9 ");
							System.err.println("one lowercase character, one uppercase character ");
							System.err.println("one special symbol in the list [@#$%],  and length between 8 characters and maximum of 20 ");
						}
					}
					cd.setPassword(f1);
					System.out.println("Enter Account Type(Client/Scheduler):");
					String accountType=null;
					char x = 'y';
					while(x=='y') {
						accountType= sc.next();

						if(Validations.isValidUserType(accountType)) {
							x='n';
						} else {
							System.err.println("Please select one option either from (client/Scheduler)");
						}
					}
					cd.setAccountType(accountType);
					 try {
						authenticationService.addUser(cd);
					} catch (CustomExceptions e) {
						e.exceptionMessage();
					}
					
					break;
				case 2:
					
					try {
				List<AuthenticationDetailsDto>	allSchedulerList=authenticationService.viewAllScheduers();
				System.out.println("\n---------SCHEDULER LISTS ARE------------");
				for (AuthenticationDetailsDto a1 : allSchedulerList) {
					System.out.println(a1);
				System.out.println("--------------------------------------");
				}		
					} catch (CustomExceptions e) {
						e.exceptionMessage();
					}

					break;
				case 3:
					System.out.println("Enter scheduler username to remove");
					String username1=null;
					char u1 = 'y';
					while(u1=='y') {
						username1= sc.next();

						if(Validations.isvalidUserName(username1)) {
							u1='n';
						} else {
							System.err.println("User name cannot contain space, first letter should be an alphabet and length should be of 10 characters !!  ");
						}
					}
					cd.setUserName(username1);
					System.out.println("ENTER THE SCHEDULER PASSWORD : ");
					char g='n';
					String g1=null;
					while(g=='n') {
						g1=sc.next();
						if( pv.validate(g1) ) {
							g='x';
						}
						else {
							System.err.println("Password must contains one digit from 0-9 ");
							System.err.println("one lowercase character, one uppercase character ");
							System.err.println("one special symbol in the list [@#$%],  and length between 8 characters and maximum of 20 ");
						}
					}
					cd.setPassword(g1);
					try {
						authenticationService.delateUser(cd);
					} catch (CustomExceptions e) {
						e.exceptionMessage();
					}
					break;
				case 4:
	                   AdminPage.main(args);
					break;

				default:
					System.err.println("\nENTER A VALID OPTION\n");
					break;
				}

				
				
		
		
		
		
		}//end of while..
		
		
		
		
		
		
	}//end of adminSchedulerOperation
	
}//end of class
