package com.capgemini.forestmanagementsystem.controller;

import java.util.Scanner;

import com.capgemini.forestmanagementsystem.dto.AuthenticationDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;
import com.capgemini.forestmanagementsystem.service.AuthenticationService;
import com.capgemini.forestmanagementsystem.service.AuthenticationServiceImpl;
import com.capgemini.forestmanagementsystem.validations.Validations;

public class SchedulerPage {
	private static String[] args;
	static Scanner sc=new Scanner(System.in);

	
	
	public static void scheulerAuthentication() {
		AuthenticationDetailsDto adt=new AuthenticationDetailsDto();
		AuthenticationService authenticationService = new AuthenticationServiceImpl();
		System.out.println("ENTER USER NAME FOR SCHEDULER :");
		String usn=sc.next();
		System.out.println("ENTER PASSWORD FOR SCHEDULER :");
		String pass=sc.next();
		adt.setUserName(usn);
		adt.setPassword(pass);
		
		try {
	      adt=authenticationService.checkUser(adt);
	      if(adt.getUserName().equals(usn)&& adt.getPassword().equals(pass)) {
				schedulerMain();
			}
			else {
				System.out.println("\nUSER NAME AND PASSWORD DID`NT MATCHED !!\n");
				HomePage.main(args);
			}
		} catch (CustomExceptions e) {
			e.exceptionMessage();
		}
		catch (NullPointerException e) {
			System.err.println("\n INVALID USER ANME AND PASSWORD !!\n");
		}
		   HomePage.main(args);
	}// end of method..

	
	public static void schedulerMain() {
		
		System.out.println("\n------------------------SCHEDULER PAGE-----------------------------\n");
		System.out.println("1 FOR CONTRACTOR  OPEARTION");
		System.out.println("2 FOR HOME PAGE");
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
		int ch=Integer.parseInt(choice);
		switch (ch) {
		case 1:
           SchedulerContractOperation.contractorOperations();         
			break;
		case 2:
               HomePage.main(args);
			break;

		default:
			System.err.println("\nPLEASE SELECT A VALID OPTION\n");
			break;
		}

		
	}//main method end
	
	

}//end of class
