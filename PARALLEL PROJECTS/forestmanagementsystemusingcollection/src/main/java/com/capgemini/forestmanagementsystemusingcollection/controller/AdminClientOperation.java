package com.capgemini.forestmanagementsystemusingcollection.controller;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.ClientDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;
import com.capgemini.forestmanagementsystemusingcollection.service.ClientService;
import com.capgemini.forestmanagementsystemusingcollection.service.ClientServiceImpl;
import com.capgemini.forestmanagementsystemusingcollection.validations.PasswordValidator;
import com.capgemini.forestmanagementsystemusingcollection.validations.Validations;

public class AdminClientOperation {
	static ClientService clientService=new ClientServiceImpl();
	static PasswordValidator passwordValidator=new PasswordValidator();
	public static void adminClientOperation() {

		   
				   
		while(true) {
			
			Scanner sc=new Scanner(System.in);
			System.out.println("HERE ARE THE CHOICES: ");
			System.out.println("PRESS 1 TO ADD A NEW CLIENT");
			System.out.println("PRESS 2 TO VIEW ALL THE CLIENT DETAILS");	
			System.out.println("PRESS 3 TO DELETE A CLIENT");
			System.out.println("PRESS 4 TO GO TO ADMIN OPERATIONS PAGE");
			System.out.println("\nENTER YOUR CHOICE: --> "); 
			char adminClientChoice='n';
			String choice=null;
			while(adminClientChoice=='n') {
				choice=sc.next();
				if(Validations.isNumber1(choice)) {
					adminClientChoice='x';
				}
				else {
					System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
				}
			}
			int ch=Integer.parseInt(choice);
			switch (ch) {
			case 1:
				ClientDetails clientDetails=new ClientDetails();
				System.out.println("Enter client username");
				String userName=null;
				char userNameValidation = 'y';
				while(userNameValidation=='y') {
					userName= sc.next();

					if(Validations.isStringOnlyAlphabet(userName)) {
						userNameValidation='n';
					} else {
						System.err.println("Please enter only alphabets!");
					}
				}
				clientDetails.setClientUserName(userName);
				System.out.println("Enter client password");
				char clientPasswordValidation='n';
				String clientPassword=null;
				while(clientPasswordValidation=='n') {
					clientPassword=sc.next();
					if( passwordValidator.validate(clientPassword) ) {
						clientPasswordValidation='x';
					}
					else {
						System.err.println("Password must contains one digit from 0-9 ");
						System.err.println("one lowercase character, one uppercase character ");
						System.err.println("one special symbol in the list [@#$%],  and length between 8 characters and maximum of 20 ");
					}
				}
				clientDetails.setClientPassword(clientPassword);
                try {
					if(clientService.addClient(clientDetails)) {
						System.out.println("\nACCOUNT CREATED FOR CLIENT\n");
					}
				} catch (ExceptionWhileInserting e) {
					e.exceptionMessage();
				}
				
				break;
			case 2:
				try {
				TreeMap<String, String> viewAllClientResult=clientService.showAllClients();
				Set<Map.Entry<String, String>> viewAllClientSet=viewAllClientResult.entrySet();
				for (Map.Entry<String, String> entry : viewAllClientSet) {
					System.out.println("--------------");
					System.out.println("Client username :"+entry.getKey());
					System.out.println("Client password :"+entry.getValue());
					System.out.println("---------------\n");
				}
			} catch (ExceptionWhileDisplaying e) {
			        e.exceptionMessage();	
			}
				
				break;
			case 3:
				System.out.println("Enter client username to remove");
				String userName1=null;
				char userNameChoice = 'y';
				while(userNameChoice=='y') {
					userName1= sc.next();

					if(Validations.isStringOnlyAlphabet(userName1)) {
						userNameChoice='n';
					} else {
						System.err.println("Please enter only alphabets!");
					}
				}
				try {
					if(clientService.removeClient(userName1)) {
						System.out.println("client account removed");
					}
				} catch (ExceptionWhileDeleting e) {
				   e.exceptionMessage();
				} 
				
				
				break;
			case 4:
               AdminPage.adminPage();
				break;
			default:
				System.err.println("\nENTER A VALID OPTION\n");
				break;
			}



		}//end of while
	}//end of method


}//end of class
