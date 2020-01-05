package com.capgemini.forestmanagementsystem.controller;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder.In;

import com.capgemini.forestmanagementsystem.dto.AuthenticationDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.service.AuthenticationService;
import com.capgemini.forestmanagementsystem.validations.PasswordValidator;
import com.capgemini.forestmanagementsystem.validations.Validations;

public class HomePage {
	
	static AuthenticationService authenticationService = FactoryClass.getAuthenticationServiceImpl();	
 static	EntityManagerFactory emf=Persistence.createEntityManagerFactory("forestmanagement");
	public static void main(String[] args) {
		PasswordValidator pv=new PasswordValidator();
		
		Scanner sc=new Scanner(System.in);
		while(true) {
		System.out.println("\n--------------------------WELCOME TO FOREST MANAGEMENT SYSTEM-------------------\n");
		System.out.println("1. ADMIN PAGE");	
		System.out.println("2. CLIENT PAGE");
		System.out.println("3. SCHEDULER PAGE");
		System.out.println("\nSELECT YOUR CHOICE--------->>>>>>>");
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
			//Admin page
			System.out.println("ENTER USERNAME FOR ADMIN: ");
			String usn=null;
			char o='n';
			while(o=='n') {
				usn=sc.next();
				if(Validations.isStringOnlyAlphabet(usn)) {
					o='x';
				}
				else {
					System.err.println("ClIENT USER NAME CAN BE OF ALPHABETS ONLY !!");
				}
			}//end of user name validation while
			System.out.println("ENTER PASSWORD FOR ADMIN: ");
			String pass=sc.next();
			
			if(usn.equals("admin")&&pass.equals("root")) {
				AdminPage.main(args);
			}
			else {
				System.err.println("\n # AUTHENTICATION FAILURE !! #\n");
				System.err.println("\nINVALID USERNAME OR PASSWORDn");
			}
			
			break;
		case 2:
			 AuthenticationDetailsDto cd=FactoryClass.getAuthenticationDetailsObject();
			System.out.println("Enter client username");
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
			System.out.println("ENTER THE CLIENT PASSWORD : ");
			String f1=sc.next();
			cd.setPassword(f1);
			AuthenticationDetailsDto fromDataBase=null;
			try {
			fromDataBase=authenticationService.viewSingleUserClient(cd);
			} catch (CustomExceptions e) {
				e.exceptionMessage();
			}	
			if(fromDataBase!=null) {
				ClientPage.main(args);
			}
			else {
				System.err.println("\nINVALID CLIENT USERNAME AND PASSWORD !!\n");
			}
		   
			break;
		case 3:
			
			 AuthenticationDetailsDto ad=FactoryClass.getAuthenticationDetailsObject();
				System.out.println("Enter scheduler username");
				String schedulerUsername=null;
				char u1 = 'y';
				while(u1=='y') {
					sc.nextLine();
					schedulerUsername= sc.nextLine();

					if(Validations.isvalidUserName(schedulerUsername)) {
						u1='n';
					} else {
						System.err.println("User name cannot contain space, first letter should be an alphabet and length should be of 15 characters !!");
					}
				}
				ad.setUserName(schedulerUsername);
				System.out.println("ENTER THE SCHEDULER PASSWORD : ");
				String g1=sc.next();
				ad.setPassword(g1);
				AuthenticationDetailsDto fromDataBaseScheduler=null;
				try {
					fromDataBaseScheduler=authenticationService.viewSingleUserScheduler(ad);
				} catch (CustomExceptions e) {
					e.exceptionMessage();
				}	
				if(fromDataBaseScheduler!=null) {
					SchedulerPage.main(args);
				}
				else {
					System.err.println("\nINVALID SCHEDULER USERNAME AND PASSWORD !!\n");
				}
			break;
		default:
			System.err.println("\nPLEASE SELECT A VALID OPTION........\n");
			break;
		}

		}//end of while
	}//end of method





}//end of class
