package com.capgemini.forestmanagementsystemusingcollection.controller;

import java.util.Scanner;

import com.capgemini.forestmanagementsystemusingcollection.dto.ClientDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.factory.FactoryClass;
import com.capgemini.forestmanagementsystemusingcollection.service.ClientService;
import com.capgemini.forestmanagementsystemusingcollection.service.ClientServiceImpl;
import com.capgemini.forestmanagementsystemusingcollection.validations.PasswordValidator;
import com.capgemini.forestmanagementsystemusingcollection.validations.Validations;


public class ClientPage extends AdminClientOperation {
//	static ClientService clientService1=new ClientServiceImpl();
    
	static PasswordValidator pv=new PasswordValidator();
	public static void clientAuthentication() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("--------CLIENT PAGE------------");
		System.out.println("Enter username");
		String user=sc.next();
		System.out.println("Enter password");
		String pass=sc.next();
		if(clientService.checkClient(user, pass)) {
			clientPage();
		}//end of if statement
		else {
			System.err.println("\nINVALID CLIENT USERNAME AND PASSWORD\n");
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
                       clientAuthentication();
					break;
				default:
					System.err.println("\nPLEASE SELECT A VALID OPTION\n");
					break;
				}

			}//end ofwhile
		}


	}







	public static void clientPage() {
		while(true) {
			
			Scanner sc=new Scanner(System.in); 
			System.out.println("\n----------------------CLIENT PAGE--------------------------------\n");
			System.out.println("PRESS 1 TO PERFORM CONTRACT OPERATION");  
			System.out.println("PRESS 2 TO PERFORM CUSTOMER OPERATION");
			System.out.println("PRESS 3 TO MODIFY CLIENT PASSWORD");
			System.out.println("PRESS 4 TO GO TO ADMIN PAGE");
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
				ClientContractOperation.clientContractOperation();
				break;
			case 2:
				ClientCustomerOperation.clientCustomerOperation();
				break;
			case 3:
				ClientDetails cd=new ClientDetails();
				System.out.println("Enter Client username");
				String user=sc.next();
				cd.setClientUserName(user);
				System.out.println("Enter revised Client password");
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
				String pass=f1;
				cd.setClientPassword(pass);
				try {
					clientService.updateClient(cd);
				} catch (ExceptionWhileDisplaying e) {
					e.exceptionMessage();
				}
				break;
			case 4:
				AdminPage.adminPage();
				break;

			default:
				System.err.println("\nPLEASE SELECT A VALID OPTION\n");
				break;
			}


		}//end of while loop

	}//end of client page method


}//end of class
