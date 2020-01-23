package com.capgemini.forestmanagementsystem.controller;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.validations.PasswordValidator;
import com.capgemini.forestmanagementsystem.validations.Validations;

public class HomePage {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
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
				AdminPage.adminMain();
			}
			else {
				System.err.println("\n # AUTHENTICATION FAILURE !! #\n");
				System.err.println("\nINVALID USERNAME OR PASSWORDn");
				main(args);
			}

			break;
		case 2:
             ClientPage.clientAuthentication();    
			break;
		case 3:
	          SchedulerPage.scheulerAuthentication();	
			break;
		
		default:
			System.err.println("\nPLEASE SELECT A VALID OPTION........\n");
			main(args);
			break;
		}

	}//end of method





}//end of class
