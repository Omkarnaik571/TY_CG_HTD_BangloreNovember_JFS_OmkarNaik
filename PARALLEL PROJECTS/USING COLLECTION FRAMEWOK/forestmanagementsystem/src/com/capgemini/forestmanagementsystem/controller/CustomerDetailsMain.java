package com.capgemini.forestmanagementsystem.controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.forestmanagementsystem.dao.ForestDao;
import com.capgemini.forestmanagementsystem.dto.CustomerDetail;
import com.capgemini.forestmanagementsystem.exceptions.DisplayingDataWithoutEntry;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.validations.Validations;

public class CustomerDetailsMain {
	static Map<Integer, CustomerDetail> result=null;

	public static void customerDetailsmain() {
		



		while(true) {
			Scanner sc=new Scanner(System.in);
			ForestDao fd=FactoryClass.getForestDAOImplObject();
			CustomerDetail cd=FactoryClass.getCustomerDetailsObject();
			System.out.println("Here are the choices: ");
			System.out.println("Press 1 to add a new Customer");
			System.out.println("Press 2 to view all the Customer Details");
			System.out.println("Press 3 to view a particular Customer ");
			System.out.println("Press 4 to view how many  Customer are there");	
			System.out.println("Press 5 to delete a customer");
			System.out.println("Press 6 to mofify a customer");
			System.out.println("Press 7 to go Admin  Page");
			System.out.println("\nEnter your Chice: --> "); 
			char b='n';
			String choice=null;
			while(b=='n') {
			    choice=sc.next();
			    
				if(Validations.isNumber1(choice)) {
					b='x';
				}
				else {
					System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
				}
			}
			int ch=Integer.parseInt(choice);
			switch (ch) {
			case 1:
				System.out.println("--------ENTER THE USER DETAILS:-----------\n");
				//1. Customer Id
				System.out.println("ENTER THE CUSTOMER ID: ");
				char c='n';
				String c1=null;
				while(c=='n') {
				    c1=sc.next();
					if(Validations.isNumber1(c1)) {
						c='x';
					}
					else {
						System.err.println("Enter the customer id in integer value !!");
					}
				}
				int cc1=Integer.parseInt(c1);
				cd.setCustomerid(cc1);
				//2.CustomerName
				System.out.println("ENTER THE CUSTOMER  NAME: ");
				String cname=null;
				char g='y';
				while(g=='y') {
					cname=sc.next();
					if(Validations.isStringOnlyAlphabet(cname)) {
						g='n';
					}
					else {
						System.err.println("Customer Name can be of alphabets only !!");
					}
				}
				cd.setCustomername(cname);
				//3.StreetAddress1
				System.out.println("ENTER THE CUSTOMER STREET ADDRESS 1: ");
				String caddr1=null;
				char h='y';
				while(h=='y') {
					caddr1=sc.next();
					if(Validations.isStringOnlyAlphabet(caddr1)) {
						h='n';
					}
					else {
						System.err.println("Customer Street Address 1 can be of alphabets only !!");
					}
				}
				cd.setStreetAddress1(caddr1);
				//4.StreetAddress2
				System.out.println("ENTER THE CUSTOMER STREET ADDRESS 2: ");
				String caddr2=null;
				char i='y';
				while(i=='y') {
					caddr2=sc.next();
					if(Validations.isStringOnlyAlphabet(caddr2)) {
						i='n';
					}
					else {
						System.err.println("Customer Street Address2 can be of alphabets only !!");
					}
				}
				cd.setStreetAddress2(caddr2);
				//5.Town
				System.out.println("ENTER THE CUSTOMER TOWN: ");
				String ctown=null;
				char j='y';
				while(j=='y') {
					ctown=sc.next();
					if(Validations.isStringOnlyAlphabet(ctown)) {
						j='n';
					}
					else {
						System.err.println("Customer town can be of alphabets only !!");
					}
				}
				cd.setTown(ctown);
				//6. Postal Code
				System.out.println("ENTER THE CUSTOMER POSTAL CODE: ");
				char d='n';
				String d1=null;
				while(d=='n') {
				    d1=sc.next();
					if(Validations.isNumber1(d1) && Validations.isVaidPostalCode(d1)) {
						d='x';
					}
					else {
						System.err.println("Postal Code length should be of 6 digits and it can only contain natural numbers !!");
					}
				}
				int dd1=Integer.parseInt(d1);
				cd.setPostalcode(dd1);
				//7.E mail
				System.out.println("ENTER THE CUSTOMER E-MAIL: ");
				String cemail=null;
				char k='y';
				while(k=='y') {
					cemail=sc.next();
					if(Validations.isValid(cemail)) {
						k='n';
					}
					else {
						System.err.println("user name must be of lower case only  !!");
						System.err.println(" must contain an @ symbol followed by mail address !!");
					}
				}
				cd.setEmail(cemail);
				//8. Phone number
				System.out.println("ENTER THE CUSTOMER PHONE NUMBER: ");
				char a='n';
				String a1=null;
				while(a=='n') {
				    a1=sc.next();
					if(Validations.isNumber1(a1) && Validations.isVaidPhoneNumber(a1)) {
						a='x';
					}
					else {
						System.err.println("Phone Number Should be of 10 digits, and can only be of natural numbers !!");
					}
				}
				long aa1=Long.parseLong(a1);
				cd.setTelephoneno(aa1);
				result=fd.addTheCustomerDetails(cd);
				System.out.println("\nCUSTOMER ADDED SUCCESSFULLY !!\n");
				break;
			case 2:
				try {
					Set<Map.Entry<Integer, CustomerDetail>>  s1=result.entrySet();                                
					System.out.println("\n----------THE CUSTOMER DETAILS ARE:------------");
					System.out.println("*************************************************");
					for (Map.Entry<Integer, CustomerDetail> entry : s1) {
						System.out.println("DETAIL OF THE CUSTOMER ("+entry.getKey()+") are: ");
						System.out.print(entry.getValue()+"\n");
					}
					System.out.println("*************************************************");		
					System.out.println("------------------------------------------------");
				}
				catch (NullPointerException n) {
					DisplayingDataWithoutEntry e= new DisplayingDataWithoutEntry();
					e.dataWithoutEntryForCustomer();
				}
				break;
			case 3:
				try {
				System.out.println("ENTER THE USER NUMBER WHICH YOU WANT TO SEE DETAIL OF: ");
				char dc='n';
				String dc1=null;
				while(dc=='n') {
				    dc1=sc.next();
					if(Validations.isNumber1(dc1)) {
						dc='x';
					}
					else {
						System.err.println("Enter the customer id in integer value !!");
					}
				}
				
				
				int detail=Integer.parseInt(dc1);
				boolean yes=result.containsKey(detail);
				if(yes==true) {
					System.out.println("\n----------THE CUSTOMER DETAILS ARE:------------");
					System.out.println("*************************************************");
					System.out.println("DETAIL OF THE CUSTOMER NUMBER "+detail+" IS:");       
					System.out.println(result.get(detail));
					System.out.println("*************************************************");		
					System.out.println("------------------------------------------------");
				}
				else {
					System.out.println("\n THE CUSTOMER NUMBER WHICH YOU HAVE ENTERED IS NOT IN THE DATABASE !!\n");
				}
				}//end of try
				catch (Exception e) {
					throw new DisplayingDataWithoutEntry();
					// TODO: handle exception
				}
				break;
			case 4:
				try {
					int size=result.size();
					System.out.println("\nTOTAL NUMBER OF USERS PRESENT IN THE DATABASE = "+size+"\n");
				}
				catch (NullPointerException n) {
					DisplayingDataWithoutEntry e= new DisplayingDataWithoutEntry();
					e.dataWithoutEntryForCustomer();
				}
				break;

			case 5:
				try {
				System.out.println("ENTER THE CUSTOMER NUMBER WHICH YOU WANT TO DELETE:");
				int delete=sc.nextInt();
				if(result.containsKey(delete)) {
				result.remove(delete);
				System.out.println("\nCUSTOMER DELETED SUCCESSFULLY !!\n");
				}
				else {
					System.err.println("The Customer number that you have entered is not present in the database !! ");
				}
				}//end of try
				catch (NullPointerException e) {
					DisplayingDataWithoutEntry ee= new DisplayingDataWithoutEntry();
					ee.dataWithoutEntryForCustomer();
					// TODO: handle exception
				}
				break;

			case 6:
				try {
				System.out.println("ENTER THE USER NUMBER WHICH YOU WANT TO MODIFY: ");
				int modify=sc.nextInt();
				CustomerDetail cd1=result.get(modify);
				if(result.containsKey(modify)) {
					System.out.println("1 FOR MODIFING CUSTOMER STREET ADDRESS 1: ");
					System.out.println("2 FOR MODIFING CUSTOMER STREET ADDRESS 2: ");
					System.out.println("3 FOR MODIFING CUSTOMER TOWN: ");
					System.out.println("4 FOR MODIFING  CUSTOMER POSTAL CODE: ");
					System.out.println("5 FOR MODIFING CUSTOMER E-MAIL: ");
					System.out.println("6 FOR MODIFING  CUSTOMER PHONE NUMBER: ");
					char e='n';
					String option=null;
					while(e=='n') {
						option=sc.next();
					    
						if(Validations.isNumber1(option)) {
							e='x';
						}
						else {
							System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
						}
					}
					int mod=Integer.parseInt(option);
					switch (mod) {
					case 1:
						System.out.println("\n--------ENTER THE REVISED CUSTOMER STREET ADDRESS 1:-----------\n");
						String maddr2=null;
						char m2='y';
						while(m2=='y') {
							maddr2=sc.next();
							if(Validations.isStringOnlyAlphabet(maddr2)) {
								m2='n';
							}
							else {
								System.err.println("Customer Street Address 1 can be of alphabets only !!");
							}
						}
						cd1.setStreetAddress1(maddr2);
						result.replace(modify, cd1);
						System.out.println("\nSTREET ADDRESS 1 MODIFIED SUCCESSFULLY !!\n");
						break;
					case 2:
						
						System.out.println("\n--------ENTER THE REVISED CUSTOMER STREET ADDRESS 2:-----------\n");
						String maddr3=null;
						char m3='y';
						while(m3=='y') {
							maddr3=sc.next();
							if(Validations.isStringOnlyAlphabet(maddr3)) {
								m3='n';
							}
							else {
								System.err.println("Customer Street Address 2 can be of alphabets only !!");
							}
						}
						cd1.setStreetAddress1(maddr3);
						result.replace(modify, cd1);
						System.out.println("\nSTREET ADDRESS 2 MODIFIED SUCCESSFULLY !!\n");
						break;
					case 3:
						System.out.println("\n--------ENTER THE REVISED CUSTOMER TOWN:-----------\n");
						String ctown2=null;
						char j2='y';
						while(j2=='y') {
							ctown2=sc.next();
							if(Validations.isStringOnlyAlphabet(ctown2)) {
								j2='n';
							}
							else {
								System.err.println("Customer town can be of alphabets only !!");
							}
						}
						cd1.setTown(ctown2);
						result.replace(modify, cd1);
						System.out.println("\nTOWN MODIFIED SUCCESSFULLY !!\n");
						break;
					case 4:
						System.out.println("\n--------ENTER THE REVISED CUSTOMER POSTAL CODE:-----------\n");
						char d2='n';
						String dd2=null;
						while(d2=='n') {
						    dd2=sc.next();
							if(Validations.isNumber1(dd2) && Validations.isVaidPostalCode(dd2)) {
								d2='x';
							}
							else {
								System.err.println("Postal Code length should be of 6 digits and it can only contain natural numbers !!");
							}
						}
						int d4=Integer.parseInt(dd2);
						cd1.setPostalcode(d4);
						result.replace(modify, cd1);
						System.out.println("\nPOSTAL CODE MODIFIED SUCCESSFULLY !!\n");
						break;
					case 5:
						System.out.println("\n--------ENTER THE REVISED CUSTOMER E-MAIL:-----------\n");
						String memail=null;
						char k1='y';
						while(k1=='y') {
							memail=sc.next();
							if(Validations.isValid(memail)) {
								k1='n';
							}
							else {
								System.err.println("user name must be of lower case only  !!");
								System.err.println(" must contain an @ symbol followed by mail address !!");
							}
						}        
						cd1.setEmail(memail);
                         result.replace(modify, cd1);
                         System.out.println("\nE-MAIL MODIFIED SUCCESSFULLY !!\n");
                         break;
					case 6:
						System.out.println("\n--------ENTER THE REVISED CUSTOMER PHONE NUMBER:-----------\n");
						char cn='n';
						String mphone=null;
						while(cn=='n') {
							mphone=sc.next();
							if(Validations.isNumber1(mphone) && Validations.isVaidPhoneNumber(mphone)) {
								cn='x';
							}
							else {
								System.err.println("Phone Number Should be of 10 digits, and can only be of natural numbers !!");
							}
						}
						long ax=Long.parseLong(mphone);
						cd1.setTelephoneno(ax);
                        result.replace(modify, cd1);
                        System.out.println("\nPHONE NUMBER MODIFIED SUCCESSFULLY !!\n");
						break;
					default:
						System.err.println("\nPLEASE SELECT A VALID OPTION !!\n");
						break;
					}
					
				}
				else {
					System.err.println("\nTHE CUSTOMER NUMBER THAT YOU HAVE ENTERED IS NOT IN THE DATABASE !!!!!!!\n");
				}  
				}//End of try block-Modify
				catch (NullPointerException e) {
					DisplayingDataWithoutEntry ee= new DisplayingDataWithoutEntry();
					ee.dataWithoutEntryForCustomer();
					// TODO: handle exception
				}
				break;

			case 7:
				AdminPage.adminPage();
				break;
			default:
				break;
			}




		}






	}






}
