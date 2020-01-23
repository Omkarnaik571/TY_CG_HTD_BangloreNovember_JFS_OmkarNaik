package com.capgemini.forestmanagementsystem.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.dto.AuthenticationDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.service.AuthenticationService;
import com.capgemini.forestmanagementsystem.validations.PasswordValidator;
import com.capgemini.forestmanagementsystem.validations.Validations;

public class AdminClientOperation {

	static AuthenticationService authenticationService = FactoryClass.getAuthenticationServiceImpl();
     static PasswordValidator passwordValidator=new PasswordValidator();
	
     public static void adminClientOperation() {
		while (true) {
           AuthenticationDetailsDto authenticationDetailsDto=FactoryClass.getAuthenticationDetailsObject();
			Scanner sc = new Scanner(System.in);
			System.out.println("HERE ARE THE CHOICES: ");
			System.out.println("PRESS 1 TO ADD A NEW CLIENT");
			System.out.println("PRESS 2 TO VIEW ALL THE CLIENT DETAILS");
			System.out.println("PRESS 3 TO DELETE A CLIENT");
			System.out.println("PRESS 4 TO GO TO ADMIN OPERATIONS PAGE");
			System.out.println("\nENTER YOUR CHOICE: --> ");
			char adminClientOperationSwitch = 'n';
			String adminClientOperationSwitchInput = null;
			while (adminClientOperationSwitch == 'n') {
				adminClientOperationSwitchInput = sc.next();
				if (Validations.isNumber1(adminClientOperationSwitchInput)) {
					adminClientOperationSwitch = 'x';
				} else {
					System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
				}
			}
			int ch = Integer.parseInt(adminClientOperationSwitchInput);
			switch (ch) {
			case 1:
				System.out.println("Enter client username");
				String username=null;
				char clientUserNameChoice = 'y';
				while(clientUserNameChoice=='y') {
					sc.nextLine();
					username= sc.nextLine();

					if(Validations.isStringOnlyAlphabet(username)) {
						clientUserNameChoice='n';
					} else {
						System.err.println("User name cannot contain space, first letter should be an alphabet and length should be of 10 characters !!");
					}
				}
				authenticationDetailsDto.setUserName(username);
				System.out.println("ENTER THE CLIENT PASSWORD : ");
				char clientPasswordChoice='n';
				String f1=null;
				while(clientPasswordChoice=='n') {
					f1=sc.next();
					if( passwordValidator.validate(f1) ) {
						clientPasswordChoice='x';
					}
					else {
						System.err.println("Password must contains one digit from 0-9 ");
						System.err.println("one lowercase character, one uppercase character ");
						System.err.println("one special symbol in the list [@#$%],  and length between 8 characters and maximum of 20 ");
					}
				}
				authenticationDetailsDto.setPassword(f1);
				authenticationDetailsDto.setAccountType("client");
				 try {
					if(authenticationService.addUser(authenticationDetailsDto)) {
						System.out.println("\nCLIENT ACCOUNT CREATED SUCCESSFULLT !!\n");
					}
					else {
						System.err.println("\nTHE USER NAME THAT YOU HAVE ENTERED, ALREADY TAKEN BY SOMEONE ELSE, TRY WITH DIFFERENT USERNAME !!\n");
					}
				} catch (CustomExceptions e) {
					e.exceptionMessage();
				}
				
				break;
			case 2:
				
				try {
			List<AuthenticationDetailsDto>	allClientList=authenticationService.viewAllClients();
			System.out.println("\n---------CLIENT LISTS ARE------------");
			for (AuthenticationDetailsDto a1 : allClientList) {
				System.out.println(a1);
			System.out.println("--------------------------------------");
			}		
			
				} catch (CustomExceptions e) {
					e.exceptionMessage();
				}

				break;
			case 3:
				System.out.println("Enter client username to remove");
				String username1=null;
				char u1 = 'y';
				while(u1=='y') {
					username1= sc.next();

					if(Validations.isvalidUserName(username1)) {
						u1='n';
					} else {
						System.err.println("Please enter only alphabets!");
					}
				}
				authenticationDetailsDto.setUserName(username1);
				System.out.println("ENTER THE CLIENT PASSWORD : ");
				char clientPaswordWhile='n';
				String clientPasswordToDelete=null;
				while(clientPaswordWhile=='n') {
					clientPasswordToDelete=sc.next();
					if( passwordValidator.validate(clientPasswordToDelete) ) {
						clientPaswordWhile='x';
					}
					else {
						System.err.println("Password must contains one digit from 0-9 ");
						System.err.println("one lowercase character, one uppercase character ");
						System.err.println("one special symbol in the list [@#$%],  and length between 8 characters and maximum of 20 ");
					}
				}
				authenticationDetailsDto.setPassword(clientPasswordToDelete);
				try {
					if(authenticationService.delateUser(authenticationDetailsDto)){
						System.out.println("\nACCOUNT DELETED SUCCESSFULLY !!\n");
					}
					else {
						System.err.println("\n INVALID USERNAME AND PASSWORD !!\n");
					}
				} catch (CustomExceptions e) {
					e.exceptionMessage();
				}
				break;
			case 4:
				AdminPage.adminMain();
				break;

			default:
				System.err.println("\nENTER A VALID OPTION\n");
				break;
			}

		} // end of while
	}// end of method..

}// end of class..
