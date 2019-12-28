package com.capgemini.forestmanagementsystem.controller;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.forestmanagementsystem.dao.ForestDao;
import com.capgemini.forestmanagementsystem.exceptions.ClientOperationsExceptions;
import com.capgemini.forestmanagementsystem.exceptions.DisplayingDataWithoutEntry;
import com.capgemini.forestmanagementsystem.exceptions.SchedulerOperationsExceptions;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.validations.PasswordValidator;
import com.capgemini.forestmanagementsystem.validations.Validations;

public class SchedulerDetailsMain {
	static Map<Integer, String> result=null;
	private static String[] args;

	public static void schedulerDetailsMain() {
		Scanner sc=new Scanner(System.in);
		ForestDao fd=FactoryClass.getForestDAOImplObject();
		while(true) {
			System.out.println("HERE ARE THE CHOICES: ");
			System.out.println("PRESS 1 TO ADD A NEW SCHEDULER");
			System.out.println("PRESS 2 TO VIEW ALL THE SCHEDULER DETAILS");	
			System.out.println("PRESS 3 TO DELETE A SCHEDULER");
			System.out.println("PRESS 4 TO MODIFY A SCHEDULER");
			System.out.println("PRESS 5 TO GO TO SCHEDULER");
			System.out.println("PRESS 6 TO GO TO ADMIN PAGE");
			System.out.println("\nENTER YOUR CHOICE: --> "); 
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
				result=fd.addTheSchedulerDetails();
				System.out.println("\nSCHEDULER ADDED SUCCESSFULLY !!\n");
				break;
			case 2:
				try {  
					Set<Map.Entry<Integer, String>> s1= result.entrySet();
					System.out.println("^^^^^^^^^^^^^^^^THE SCHEDULER DETAILS ARE^^^^^^^^^^^^^^^^^^");
					for (Map.Entry<Integer, String> entry : s1) {
						System.out.println("SCHEDULER Id : "+entry.getKey());
						System.out.println("PASSWORD : "+entry.getValue());
						System.out.println("----------------------------------------------------------------------------------------------");
					}
				} 
				catch (NullPointerException n) {
					DisplayingDataWithoutEntry e= new DisplayingDataWithoutEntry();
					e.dataWithoutEntryForScheduler();
				}
				break;
			case 3:
				System.out.println("ENTER THE SCHEDULER ID WHICH YOU WANT TO DELETE : ");
				char b='n';
				String b1=null;
				while(b=='n') {
					b1=sc.next();
					if(Validations.isNumber1(b1)) {
						b='x';
					}
					else {
						System.err.println("ENTER THE SCHEDULER ID IN INTEGER VALUES !!");
					}
				}
				int delete=Integer.parseInt(b1);
				try {
					if(result.containsKey(delete)) {
						result.remove(delete);
						System.out.println("\nSCHEDULER DELETED SUCCESSFULLY !!\n");
					}
					else {
						System.err.println("\nTHE SCHEDULER ID THAT YOU HAVE ENTERED IS NOT PRESENT   ....\n");
					}
				}//end of try
				catch (NullPointerException e) {
					SchedulerOperationsExceptions.deleteWithoutEntryForScheduler();
					// TODO: handle exception
				}
				break;
			case 4:
				try {
					PasswordValidator pv=new PasswordValidator();
					System.out.println("ENTER THE SCHEDULER ID  : ");
					char c='n';
					String c1=null;
					while(c=='n') {
						c1=sc.next();
						if(Validations.isNumber1(c1)) {
							c='x';
						}
						else {
							System.err.println("ENTER THE SCHEDULER ID IN INTEGER VALUES !!");
						}
					}
					int modifyid=Integer.parseInt(c1);
					sc.nextLine();
					if(result.containsKey(modifyid) ) {
						System.out.println("ENTER THE REVISED SCHEDULER PASSWORD");
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
						String modifypass=f1; 
						result.replace(modifyid, modifypass);
						System.out.println("\nSCHEDULER PASSWORD MODIFIED SUCCESSFULLY !!\n");	   
					}
					else {
						System.err.println("\nTHE SCHEDULER ID THAT YOU HAVE ENTERED IS NOT PRESENT IN THE DATABASE !!\n");;
					}
				}//end of try
				catch (NullPointerException e) {
					SchedulerOperationsExceptions.deleteWithoutEntryForScheduler();
					// TODO: handle exception
				}
				break;
			case 5:
				SchedulerPage.schedulerPage();
				break;
			case 6:
				AdminPage.adminPage();
				break;
			default:
				System.err.println("\nENTER A VALID OPTION\n");
				break;
			}




		}//end of while loop

	}//scheduler details main method end

	public static Map<Integer, String> getTheSchedulerDetails() {

		return result;
	}




}//end of scheduler details main class
