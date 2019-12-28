package com.capgemini.forestmanagementsystem.controller;

import java.util.Map;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.dao.ForestDao;
import com.capgemini.forestmanagementsystem.exceptions.ClientOperationsExceptions;
import com.capgemini.forestmanagementsystem.exceptions.InvalidUserIdAndPassword;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.validations.PasswordValidator;
import com.capgemini.forestmanagementsystem.validations.Validations;

public class ClientPage {
	static Map<Integer, String> result=null;
	private static String[] args;

	public static void clientPage() {
		Scanner sc=new Scanner(System.in); 
		ForestDao fd=FactoryClass.getForestDAOImplObject();

		result=ClientDetailsMain.getTheClientDetails();

		System.out.println("--------Enter Your Login Id and password----------");
		System.out.println("Enter the Client Id:");
		String temp=null;
		char o='n';
		while(o=='n') {
			temp=sc.next();
			if(Validations.isNumber1(temp)) {
				o='x';
			}
			else {
				System.err.println("CLIENT ID CANNOT CONTAIN ALPHABETS OR SPECIAL CHARACTERS, ENTER INTEGER ONLY !!");
			}
		}
		int usn=Integer.parseInt(temp);
		System.out.println("Enter the Client Password");
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
				System.out.println("\nCLIENT ID AND PASSWORD MATCHED SUCCESSFULLY\n");
				clientOperation();
			}
			else {
				System.err.println("\nINVALID USER ID AND PASSWORD !!\n");
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
                      ClientPage.clientPage();
					break;	
				default:
					System.err.println("\nPLEASE SELECT A VALID OPTION\n");
					break;
				}//end of switch..
			}//end of login fail else
			}
			else {
				System.err.println("\nThe Client Id that You have entered is not present\n");
			  clientPage();
			}
			
		}//end of try bloack
		catch (NullPointerException e) {
			InvalidUserIdAndPassword iu=new InvalidUserIdAndPassword();
			iu.invalidUserIdandPassword();
			HomePage.main(args);
			// TODO: handle exception
		}//end of catch block

	} //end of method..

	public static void clientOperation() {
		while(true) {
			Scanner sc=new Scanner(System.in); 
			System.out.println("\n----------------------CLIENT PAGE--------------------------------\n");
			System.out.println("PRESS 1 TO PERFORM CONTRACT OPERATION");  
			System.out.println("PRESS 2 TO PERFORM PRODUCT OPERATION");
			System.out.println("PRESS 3 TO MODIFY CLIENT PASSWORD");
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
				ProductDetailsMain.productDetailsmain();
				break;
				
			case 3:
				//Modify Client Password
				try {
					PasswordValidator pv=new PasswordValidator();
					System.out.println("ENTER THE CLIENT ID  : ");
					char c='n';
					String c1=null;
					while(c=='n') {
					    c1=sc.next();
						if(Validations.isNumber1(c1)) {
							c='x';
						}
						else {
							System.err.println("ENTER THE CLIENT ID IN INTEGER VALUES !!");
						}
					}
					int modifyid=Integer.parseInt(c1);
					sc.nextLine();
					if(result.containsKey(modifyid) ) {
						System.out.println("ENTER THE REVISED CLIENT PASSWORD");
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
						System.out.println("\nCLIENT PASSWORD MODIFIED SUCCESSFULLY !!\n");	   
					}
					else {
	                     System.err.println("\nTHE CLIENT ID THAT YOU HAVE ENTERED IS NOT PRESENT IN THE DATABASE !!\n");;
					}
					}//end of try block
					catch (NullPointerException e) {
						ClientOperationsExceptions.deleteWithoutEntryForClient();
						// TODO: handle exception
					}
				
				
				break;
			default:
				System.err.println("\nPLEASE SELECT A VALID OPTION\n");
				break;
			}

		}

	}





}
