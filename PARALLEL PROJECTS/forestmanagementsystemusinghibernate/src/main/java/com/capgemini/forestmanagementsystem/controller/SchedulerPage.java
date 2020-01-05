package com.capgemini.forestmanagementsystem.controller;

import java.util.Scanner;

import com.capgemini.forestmanagementsystem.dao.ContractorDetailsDao;
import com.capgemini.forestmanagementsystem.dto.AuthenticationDetailsDto;
import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.ContractCustomException;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.service.AuthenticationService;
import com.capgemini.forestmanagementsystem.validations.PasswordValidator;
import com.capgemini.forestmanagementsystem.validations.Validations;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class SchedulerPage {
	static AuthenticationService authenticationService = FactoryClass.getAuthenticationServiceImpl();	
	static Scanner sc=new Scanner(System.in);
	private static String[] args;

	public static void main(String[] args) {
		PasswordValidator pv=new PasswordValidator();
		
		while(true) {
		System.out.println("\n------------------------SCHEDULER PAGE-----------------------------\n");
		System.out.println("1 FOR CONTRACTOR  OPEARTION");
		System.out.println("2 FOR PASSWORD MODIFICATION");
		System.out.println("3 GO BACK TO HOME PAGE");
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
             SchedulerContractOperations.schedulerSchedulerOperation();
			break;
		case 2:
			AuthenticationDetailsDto cd=FactoryClass.getAuthenticationDetailsObject();
			System.out.println("Enter scheduler username");
			String username=null;
			char u = 'y';
			while(u=='y') {
				sc.nextLine();
				username= sc.nextLine();

				if(Validations.isvalidUserName(username)) {
					u='n';
				} else {
					System.err.println("User name cannot contain space, first letter should be an alphabet and length should be of 15 characters !!");
				}
			}
			cd.setUserName(username);
			System.out.println("ENTER THE SCHEDULER PASSWORD : ");
			String f1=sc.next();
			cd.setPassword(f1);
			System.out.println("ENTER THE  REVISED SCHEDULER PASSWORD : ");
			String newPassword=sc.next();
        boolean isModified=false;
		try {
		isModified=authenticationService.modifyUser(cd, newPassword);
		} catch (CustomExceptions e) {
			e.exceptionMessage();
		}
		if(isModified==false) {
			System.out.println("\nINVALID SCHEDULER USERNAME AND PASSWORD, MODIFICATION UNSUCCESSFUL !!\n");
		}
			break;
		case 3:
			HomePage.main(args);
			break;

		default:
			System.err.println("\nPLEASE SELECT A VALID OPTION\n");
			break;
		}

		}//end of while loop
		
	}//main method end
	
	



}//end of class
