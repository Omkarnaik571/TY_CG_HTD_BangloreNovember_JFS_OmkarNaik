package com.capgemini.forestmanagementsystem.controller;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.dto.ClientDetailsDto;
import com.capgemini.forestmanagementsystem.dto.SchedulerDetailsDto;
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
				AdminPage.main(args);
			}
			else {
				System.err.println("\n # AUTHENTICATION FAILURE !! #\n");
				System.err.println("\nINVALID USERNAME OR PASSWORDn");
				main(args);
			}

			break;
		case 2:
            ClientDetailsDto cdd=FactoryClass.getClientDetailsDto();
			FileReader reader=null;
			Properties prop=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				reader=new FileReader("operations.properties");
				prop=new Properties();
				prop.load(reader);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
					prop.getProperty("dbname"),prop.getProperty("dbpass"));
					PreparedStatement stmt=conn.prepareStatement(prop.getProperty("findclient"))

					){	
				System.out.println("ENTER  CLIENT ID: ");
				String temp=null;
				char o1='n';
				while(o1=='n') {
					temp=sc.next();
					if(Validations.isNumber1(temp)) {
						o1='x';
					}
					else {
						System.err.println("CLIENT ID CANNOT CONTAIN ALPHABETS OR SPECIAL CHARACTERS, ENTER INTEGER ONLY !!");
					}
				}
				cdd.setClientId(Integer.parseInt(temp));
				stmt.setInt(1, cdd.getClientId());
				int clientid=cdd.getClientId();
				System.out.println("ENTER  CLIENT PASSWORD:");
				char f='n';
				String f1=null;
				while(f=='n') {
					f1=sc.next();
					PasswordValidator pv=new PasswordValidator();
					if( pv.validate(f1) ) {
						f='x';
					}
				String clientpassword=f1;
				ResultSet rs=stmt.executeQuery();
				
				int fianlclientid=0;
				String finalclientpassword="";
				while(rs.next()) {
					fianlclientid=rs.getInt(1);
					finalclientpassword=rs.getString(3);
				}
				
				if( clientid == fianlclientid && clientpassword.equals(finalclientpassword) ) {
					ClientPage.main(args);
				}
				else {
					System.err.println("\nINVALID CLIENT USER ID AND PASSWORD..\n");
					main(args);
				}
				
			
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
			break;
		case 3:
		
			SchedulerDetailsDto sdd=FactoryClass.getSchedulerDetailsDto();
			FileReader reader1=null;
			Properties prop1=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				reader1=new FileReader("operations.properties");
				prop1=new Properties();
				prop1.load(reader1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			try(Connection conn=DriverManager.getConnection(prop1.getProperty("dburl"),
					prop1.getProperty("dbname"),prop1.getProperty("dbpass"));
					PreparedStatement stmt=conn.prepareStatement(prop1.getProperty("findscheduler"))

					){	
				System.out.println("ENTER  SCHEDULER ID: ");
				String temp=null;
				char o1='n';
				while(o1=='n') {
					temp=sc.next();
					if(Validations.isNumber1(temp)) {
						o1='x';
					}
					else {
						System.err.println("SCHEDULER ID CANNOT CONTAIN ALPHABETS OR SPECIAL CHARACTERS, ENTER INTEGER ONLY !!");
					}
				}
				sdd.setSchedulerId(Integer.parseInt(temp));
				stmt.setInt(1, sdd.getSchedulerId());
				int schedulerid=sdd.getSchedulerId();
				System.out.println("ENTER  SCHEDULER PASSWORD:");
				char f='n';
				String f1=null;
				while(f=='n') {
					f1=sc.next();
					PasswordValidator pv=new PasswordValidator();
					if( pv.validate(f1) ) {
						f='x';
					}
				String schedulerpassword=f1;
				ResultSet rs=stmt.executeQuery();
				
				int fianlschedulerid=0;
				String finalschedulerpassword="";
				while(rs.next()) {
					fianlschedulerid=rs.getInt(1);
					finalschedulerpassword=rs.getString(3);
				}
				
				if( schedulerid == fianlschedulerid && schedulerpassword.equals(finalschedulerpassword) ) {
					System.out.println("\nSCHEDULER ID AND PASSWORD MATCHED SUCCESSFULLY !!  \n");
					SchedulerPage.main(args);
				}
				else {
					System.err.println("\nINVALID scheduler USER ID AND PASSWORD..\n");
					main(args);
				}
				
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle
			}//catch block end
			
			break;
		

		default:
			System.err.println("\nPLEASE SELECT A VALID OPTION........\n");
			main(args);
			break;
		}

	}//end of method





}//end of class
