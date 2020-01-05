package com.capgemini.forestmanagementsystemusingcollection.controller;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.CustomerDetail;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileModifying;
import com.capgemini.forestmanagementsystemusingcollection.factory.FactoryClass;
import com.capgemini.forestmanagementsystemusingcollection.service.CustomerService;
import com.capgemini.forestmanagementsystemusingcollection.service.CustomerServiceImpl;
import com.capgemini.forestmanagementsystemusingcollection.validations.Validations;

public class ClientCustomerOperation  extends AdminCustomerOperation{

//	static CustomerService cService=new CustomerServiceImpl();
	
public static void clientCustomerOperation() {
		
		while(true) {
			Scanner sc=new Scanner(System.in);
			CustomerDetail cd=FactoryClass.getCustomerDetailsObject();
			System.out.println("Here are the choices: ");
			System.out.println("Press 1 to add a new Customer");
			System.out.println("Press 2 to view all the Customer Details");
			System.out.println("Press 3 to view a particular Customer ");	
			System.out.println("Press 4 to delete a customer");
			System.out.println("Press 5 to mofify a customer");
			System.out.println("Press 6 to go Admin  Page");
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
				//add customer
				System.out.println("--------ENTER THE CUSTOMER DETAILS:-----------\n");
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
				cd.setCustomerId(cc1);
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
				cd.setCustomerName(cname);
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
				cd.setPostalCode(dd1);
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
				cd.setTelephoneNo(aa1);                

				try {
					if(cService.addCustomer(cd)) {
						System.out.println("\nCUSTOMER ADDDED SUCCESSFULLY ^^^^\n");	
					}
				} catch (ExceptionWhileInserting e) {
					e.exceptionMessage();
				}

				break;
			case 2:
				try {
					TreeMap<Integer, CustomerDetail> allCustomerResult=cService.viewCustomers();
					Set<Map.Entry<Integer, CustomerDetail>> result= allCustomerResult.entrySet();
					System.out.println("\n------CUSTOMER DETAILS ARE----------\n");
					for (Map.Entry<Integer, CustomerDetail> entry : result) {
						System.out.println(entry.getValue());
						System.out.println("----------------------------------------");
					}

				} catch (ExceptionWhileDisplaying e) {
					e.exceptionMessage();
				}

				break;
			case 3:
				System.out.println("Enter the  Customer Id Which yo want to see detail Of: ");
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
				try {
					CustomerDetail singleCustomer=cService.getSingleCustomer(Integer.parseInt(dc1));
					//					singleContract=contractService.getSingleContract(cdbean.getContractNo());
					System.out.println("\n------CUSTOMER DETAILS OF CUSTOMER ID("+singleCustomer.getCustomerId()+")----------\n");
					System.out.println(singleCustomer);
					System.out.println("----------------------------------------");

				} catch (ExceptionWhileDisplaying e) {
					e.exceptionMessage();
				}
				break;
			case 4:
				System.out.println("Enter customerid to remove customer details ");
				String ch5=null;
				char c5 = 'y';
				while(c5=='y') {
					ch5= sc.next();
					if(Validations.isNumber1(ch5)) {
						c5='n';
					} else {
						System.err.println("Please enter only numbers!");
					}
				}
				Integer id1= Integer.parseInt(ch5);
				try {
					if(cService.removeCustomer(id1)) {
						System.out.println("\nCUSTOMER DELETED SUCCESSFULLY ^^^^\n");
					}

				} catch (ExceptionWhileDeleting e) {
					e.exceptionMessage();
				}

				break;
			case 5:
				System.out.println("enter customerid to modify details");
				String ch6=null;
				char c6 = 'y';
				while(c6=='y') {
					ch6= sc.next();
					if(Validations.isNumber1(ch6)) {
						c6='n';
					} else {
						System.err.println("Please enter only numbers!");
					}
				}
				Integer id2= Integer.parseInt(ch6);
				CustomerDetail modify=null;
				try {
					modify = cService.getSingleCustomer(id2);
				} catch (ExceptionWhileDisplaying e1) {
					e1.exceptionMessage();
				}
				if(modify!=null) {
					System.out.println("1 FOR MODIFING CUSTOMER STREET ADDRESS 1: ");
					System.out.println("2 FOR MODIFING CUSTOMER STREET ADDRESS 2: ");
					System.out.println("3 FOR MODIFING CUSTOMER TOWN: ");
					System.out.println("4 FOR MODIFING  CUSTOMER POSTAL CODE: ");
					System.out.println("5 FOR MODIFING CUSTOMER E-MAIL: ");
					System.out.println("6 FOR MODIFING  CUSTOMER PHONE NUMBER: ");
					char t='n';
					String choice1=null;
					while(t=='n') {
						choice1=sc.next();

						if(Validations.isNumber1(choice1)) {
							t='x';
						}
						else {
							System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
						}
					}
					int mod=Integer.parseInt(choice1);
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
						modify.setStreetAddress1(maddr2);
						try {
							cService.modifyCustomer(id2, modify);
							System.out.println("\nSTREET ADDRESS 1 MODIFIED SUCCESSFULLY !!\n");
						} catch (ExceptionWhileModifying e) {
							e.exceptionMessage();
						}
						
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
						modify.setStreetAddress2(maddr3);
						try {
							cService.modifyCustomer(id2, modify);
							System.out.println("\nSTREET ADDRESS 2 MODIFIED SUCCESSFULLY !!\n");
						} catch (ExceptionWhileModifying e) {
							e.exceptionMessage();
						}

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
						modify.setTown(ctown2);
						try {
							cService.modifyCustomer(id2, modify);
							System.out.println("\nTOWN MODIFIED SUCCESSFULLY !!\n");
						} catch (ExceptionWhileModifying e) {
							e.exceptionMessage();
						}
						
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
						modify.setPostalCode(Integer.parseInt(dd2));
						try {
							cService.modifyCustomer(id2, modify);
							System.out.println("\nPOSTAL CODE MODIFIED SUCCESSFULLY !!\n");
						} catch (ExceptionWhileModifying e) {
							e.exceptionMessage();
						}
						
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
						modify.setEmail(memail);
						try {
							cService.modifyCustomer(id2, modify);
							System.out.println("\nE-MAIL MODIFIED SUCCESSFULLY !!\n");
						} catch (ExceptionWhileModifying e) {
							e.exceptionMessage();
						}
						
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
						modify.setTelephoneNo(Long.parseLong(mphone));
						try {
							cService.modifyCustomer(id2, modify);
							System.out.println("\nPHONE NUMBER MODIFIED SUCCESSFULLY !!\n");
						} catch (ExceptionWhileModifying e) {
							e.exceptionMessage();
						}
						break;

					default:
						System.err.println("\nPLEASE SELECT A VALID OPTION !!\n");		
						break;
					}



				}//end of if



				break;
			case 6:
				AdminPage.adminPage();
				break;

			default:
				System.err.println("\nPLEASE SELECT A VALID OPTION !!\n");
				break;
			}





		}//end of while loop
	}//end of method
	
	
	
}//end of class
