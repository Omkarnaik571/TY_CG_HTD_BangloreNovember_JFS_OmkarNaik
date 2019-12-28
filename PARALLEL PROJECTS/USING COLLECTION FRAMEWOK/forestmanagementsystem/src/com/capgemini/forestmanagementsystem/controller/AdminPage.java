package com.capgemini.forestmanagementsystem.controller;

import java.util.NoSuchElementException;
import java.util.Scanner;
import com.capgemini.forestmanagementsystem.validations.Validations;

public class AdminPage {
	
	

	public static void adminPage() {
		
		
		while(true) {
			Scanner sc=new Scanner(System.in); 
			String adminname="admin";
			String adminpassword="root";
			System.out.println("-----------------AUTHENTICATE YOURSELF FIRST-----------------");
			System.out.println("ADMIN USERNAME: ");
			String usn=null;
			char o='n';
			while(o=='n') {
				usn=sc.next();
				if(Validations.isStringOnlyAlphabet(usn)) {
					o='x';
				}
				else {
					System.err.println("ADMIN USER NAME CAN BE OF ALPHABETS ONLY !!");
				}
			}
			System.out.println("ADMIN PASSWORD: ");
			String pass=sc.next();
				
			if(usn.equals(adminname)&& pass.equals(adminpassword)) {
				System.out.println("\n--------------------------ADMIN PAGE-------------------\n"); 
				System.out.println("PRESS 1 TO PERFORM CONTRACT OPERATION"); 
				System.out.println("PRESS 2 TO PERFORM CUSTOMER OPERATION");
				System.out.println("PRESS 3 TO PERFORM PRODUCT OPERATION");
				System.out.println("PRESS 4 TO PERFORM LAND OPERATION");
				System.out.println("PRESS 5 TO PERFORM CLIENT OPERATION");
				System.out.println("PRESS 6 TO PERFORM SCHEDULER OPERATION");
				System.out.println("**********************************************************************");

				System.out.println("Enter your choice  -----:>");  
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
					ContractPage.adminContractOperation();
					break;
				case 2:
					CustomerDetailsMain.customerDetailsmain();
					break;
				case 3:
					ProductDetailsMain.productDetailsmain();
					break;
				case 4:
                    LandDetailsMain.landDetailsMain();
					break;
				case 5:
					ClientDetailsMain.clientDetailsMain();
					break;
				case 6:
					SchedulerDetailsMain.schedulerDetailsMain();
					break;
				default:
					System.err.println("\nPLEASE SELECT A VALID OPTION\n");
					break;
				}//end of switch			
			}//end of if
			else {
				System.err.println("\nINVALID  USERNAME AND PASSWORD  FOR ADMIN  !!\n ");
			}
		}//end of while loop

	}//end of method
}//end of class
