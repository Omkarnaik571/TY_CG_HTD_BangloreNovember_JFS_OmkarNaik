package com.capgemini.forestmanagementsystem.controller;

import java.util.Map;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.dao.ForestDao;
import com.capgemini.forestmanagementsystem.exceptions.ClientOperationsExceptions;
import com.capgemini.forestmanagementsystem.exceptions.InvalidUserIdAndPassword;
import com.capgemini.forestmanagementsystem.exceptions.SchedulerOperationsExceptions;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.validations.PasswordValidator;
import com.capgemini.forestmanagementsystem.validations.Validations;

public class SchedulerPage {
        
	static Map<Integer, String> result=null;
	private static String[] args;
	
	public static void schedulerPage() {
		ForestDao fd=FactoryClass.getForestDAOImplObject();
	   while(true) {		   
      Scanner sc=new Scanner(System.in); 
      result=SchedulerDetailsMain.getTheSchedulerDetails();

      System.out.println("--------Enter Your Login Id and password----------");
		System.out.println("Enter the Scheduler Id:");
		String temp=null;
		char o='n';
		while(o=='n') {
			temp=sc.nextLine();
			if(Validations.isNumber1(temp)) {
				o='x';
			}
			else {
				System.err.println("Scheduler ID CANNOT CONTAIN ALPHABETS OR SPECIAL CHARACTERS, ENTER INTEGER ONLY !!");
			}
		}
		int usn=Integer.parseInt(temp);
		System.out.println("Enter the Scheduler Password");
		char f='n';
		String f1=null;
		while(f=='n') {
			f1=sc.next();
			PasswordValidator pv=new PasswordValidator();
			if( pv.validate(f1) ) {
				f='x';
			}
			else {
				System.err.println("Password must contains one digit from 0-9 ");
				System.err.println("one lowercase character, one uppercase character ");
				System.err.println("one special symbol in the list [@#$%],  and length between 8 characters and maximum of 20 ");
			}
		}
		String pass=f1;
		try {
			if(result.containsKey(usn)) {
			
			if(result.get(usn).equals(pass)) {
				System.out.println("\nSCHEDULER ID AND PASSWORD MATCHED SUCCESSFULLY\n");
				schedulerOperations();
			}
			else {
				System.err.println("\nINVALID SCHEDULER ID AND PASSWORD !!\n");
				System.out.println("1 GO BACK TO ADMIN PAGE");
				System.out.println("2 TO LOGIN AGAIN");
				char e='n';
				String choice=null;
				while(e=='n') {
					choice=sc.next();
					if(Validations.isNumber1(choice)) {
						e='x';
					}
					else {
						System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
					}
				}
				int option=Integer.parseInt(choice);
				switch (option) {
				case 1:
                       AdminPage.adminPage();
					break;
				case 2:
                      SchedulerPage.schedulerPage();
					break;	
				default:
					System.err.println("\nPLEASE SELECT A VALID OPTION\n");
					break;
				}//end of switch..
			}//end of login fail else
			}
			else {
				System.err.println("The Scheduler id that you have entered is not present");
			}
		}//end of try bloack
		catch (NullPointerException e) {
			InvalidUserIdAndPassword iu=new InvalidUserIdAndPassword();
			iu.invalidUserIdandPasswordForSchesuler();
			HomePage.main(args);
			// TODO: handle exception
		}//end of catch block
		      
	   }//end of while loop
	
	}//end of scheduler page method
	
	
	
	public static void schedulerOperations() {
		while(true) {
			Scanner sc=new Scanner(System.in); 
			System.out.println("\n----------------------SCHEDULER PAGE--------------------------------\n");
			System.out.println("PRESS 1 TO PERFORM CONTRACT OPERATION");  
			System.out.println("PRESS 2 TO MODIFY PASSWORD");
			System.out.println("PRESS 3 TO Go BACK TO SCHEDULER PAGE");
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
				ContractPage.adminContractOperation();
				break;
			case 2:
			    //Modify password
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
			case 3:
				SchedulerPage.schedulerPage();
				break;
			default:
				System.err.println("\nPLEASE SELECT A VALID OPTION\n");
				break;
			}			
			
		}
		
	}//end of scheduler operations method
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//end of class
