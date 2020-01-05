package com.capgemini.forestmanagementsystem.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.dto.CustomerDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.service.CustomerService;
import com.capgemini.forestmanagementsystem.validations.Validations;

public class ClientCustomerOperation {

	static Scanner sc=new Scanner(System.in);
	private static String[] args;
	
	public static void clientCustomerOperation() {
		
		CustomerService cdd=FactoryClass.getCustomerDetailsServiceImpl();
		CustomerDetailsDto cd=FactoryClass.getCustomerDetailsDto();

		while(true) {
			System.out.println("--------ENTER THE USER DETAILS:-----------\n");
			System.out.println("Press 1 to add a new Customer Details");
			System.out.println("Press 2 to view all the Customer Details");
			System.out.println("Press 3 to view a particular Customer Detail ");	
			System.out.println("Press 4 to delete a Customer");
			System.out.println("Press 5 to Modify a Customer");
			System.out.println("press 6 GO BACK TO CLIENT PAGE");
			System.out.println("Select your choices--->");
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

			int option=Integer.parseInt(choice);
			switch (option) {
			case 1:
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
				cd.setCustomerId(Integer.parseInt(c1));
				sc.nextLine();
				System.out.println("ENTER THE CUSTOMER NAME: ");
				String cname=null;
				char g='y';
				while(g=='y') {
					cname=sc.nextLine();
					if(Validations.isStringOnlyAlphabet(cname)) {
						g='n';
					}
					else {
						System.err.println("Customer Name can be of alphabets only !!");
					}
				}
				cd.setCustomerName(cname);
				System.out.println("ENTER THE STREET ADDRESS 1: ");
				String caddr1=null;
				char h='y';
				while(h=='y') {
					caddr1=sc.nextLine();
					if(Validations.isStringOnlyAlphabet(caddr1)) {
						h='n';
					}
					else {
						System.err.println("Customer Street Address 1 can be of alphabets only !!");
					}
				}
				cd.setStreetAddress1(caddr1);
				System.out.println("ENTER THE STREET ADDRESS 2: ");
				String caddr2=null;
				char i='y';
				while(i=='y') {
					caddr2=sc.nextLine();
					if(Validations.isStringOnlyAlphabet(caddr2)) {
						i='n';
					}
					else {
						System.err.println("Customer Street Address2 can be of alphabets only !!");
					}
				}
				cd.setStreetAddress2(caddr2);
				System.out.println("ENTER THE TOWN: ");
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
				System.out.println("ENTER THE POSTAL CODE: ");
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
				cd.setPostalCode(Integer.parseInt(d1));
				System.out.println("ENTER THE E-MAIL: ");
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
				System.out.println("ENTER THE TELEPHONE NUMBER: ");
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
				cd.setTelephoneNo(Long.parseLong(a1));

				//Add a customer detail
				try {
					boolean isAdded=cdd.addCustomer(cd);
				}
				catch (CustomExceptions e) {
					e.customerIdAlreadyExist();
					// TODO: handle exception
				}
				break;
			case 2:
				//View all customer detail
				try {
					List<CustomerDetailsDto> result= cdd.viewCustomerDetails();
					System.out.println("\n---------CUSTOMER DETAILS------------------");
					for (CustomerDetailsDto r1 : result) {
						System.out.println(r1);
						System.out.println("--------------------------------------------");
					}

					if(result.isEmpty()) {
						System.err.println("\nTHERE ARE NO CUSTOMER DETAILS  PRESENT IN THE DATABASE!!\n");
					}
				
				} catch (CustomExceptions e) {
					e.exceptionMessage();
				}

				break;
			case 3:
				//View a particular customer
				System.out.println("ENTER THE CUSTOMER ID: ");
				char xc='n';
				String xc1=null;
				while(xc=='n') {
					xc1=sc.next();
					if(Validations.isNumber1(xc1)) {
						xc='x';
					}
					else {
						System.err.println("Enter the customer id in integer value !!");
					}
				}
				CustomerDetailsDto isViewSingle=null;
				cd.setCustomerId(Integer.parseInt(xc1));
			     try {
					isViewSingle=cdd.viewSingleCustomerDetails(cd);
				} catch (CustomExceptions e) {
					e.exceptionMessage();
				}
			 if(isViewSingle == null) {
					System.err.println("\nThe customer id that you have entered is not present !!\n");
				}
				else {
				System.out.println("\n---------PRODUCT DETAILS------------------");
				System.out.println("Customer id : "+isViewSingle.getCustomerId());
				System.out.println("Customer Name : "+isViewSingle.getCustomerName());
				System.out.println("Street Address 1 : "+isViewSingle.getStreetAddress1());
				System.out.println("Street Address 2 : "+isViewSingle.getStreetAddress2());
				System.out.println("E-mail: "+isViewSingle.getEmail());
				System.out.println("Postal Code : "+isViewSingle.getPostalCode());
				System.out.println("Town : "+isViewSingle.getTown());
				System.out.println("Telephone Number : "+isViewSingle.getTelephoneNo());
				System.out.println("--------------------------------------------");
				}	
			 
			 
				
				break;
			case 4:
				//delete a customer
				System.out.println("ENTER THE CUSTOMER ID: ");
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
				cd.setCustomerId(Integer.parseInt(dc1));
				try {
					boolean isDeleted=cdd.deleteCustomerDetails(cd);
				} catch (CustomExceptions e) {
					e.exceptionMessage();
				}
				break;
			case 5:
				//modify a customer
				boolean isModified;
				System.out.println("--------------------MODIFY CUSTOMER DETAILS---------------------");
				System.out.println("1.  STREET ADDRESS 1: ");
				System.out.println("2.  STREET ADDRESS 2: ");
				System.out.println("3.  TOWN: ");
				System.out.println("4.  POSTAL CODE: ");
				System.out.println("5.  E-MAIL: ");
				System.out.println("6.  TELEPHONE NUMBER: ");
				char am='n';
				String mod=null;
				while(am=='n') {
					mod=sc.next();

					if(Validations.isNumber1(mod)) {
						am='x';
					}
					else {
						System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
					}
				}
				int opt=Integer.parseInt(mod);
				switch (opt) {
				case 1:
					System.out.println("ENTER THE CUSTOMER ID: ");
					char mc1='n';
					String modifycustomer1=null;
					while(mc1=='n') {
						modifycustomer1=sc.next();
						if(Validations.isNumber1(modifycustomer1)) {
							mc1='x';
						}
						else {
							System.err.println("Enter the customer id in integer value !!");
						}
					}
					cd.setCustomerId(Integer.parseInt(modifycustomer1));
					System.out.println("1. ENTER THE  REVISED STREET ADDRESS 1: ");
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
					cd.setStreetAddress1(maddr2);
					try {
						isModified=cdd.modifyCustomerDetails(cd, opt);
					} catch (CustomExceptions e) {
						e.exceptionMessage();
					}
					break;
				case 2:
					System.out.println("ENTER THE CUSTOMER ID: ");
					char mc2='n';
					String modifycustomer2=null;
					while(mc2=='n') {
						modifycustomer2=sc.next();
						if(Validations.isNumber1(modifycustomer2)) {
							mc2='x';
						}
						else {
							System.err.println("Enter the customer id in integer value !!");
						}
					}
					cd.setCustomerId(Integer.parseInt(modifycustomer2));
					System.out.println("1. ENTER THE  REVISED STREET ADDRESS 2: ");
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
					cd.setStreetAddress2(maddr3);
					try {
						isModified=cdd.modifyCustomerDetails(cd, opt);
					} catch (CustomExceptions e) {
						e.exceptionMessage();
					}

					break;
				case 3:
					System.out.println("ENTER THE CUSTOMER ID: ");
					char mc3='n';
					String modifycustomer3=null;
					while(mc3=='n') {
						modifycustomer3=sc.next();
						if(Validations.isNumber1(modifycustomer3)) {
							mc3='x';
						}
						else {
							System.err.println("Enter the customer id in integer value !!");
						}
					}
					cd.setCustomerId(Integer.parseInt(modifycustomer3));
					System.out.println("1. ENTER THE  REVISED TOWN: ");
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

					cd.setTown(ctown2);
					try {
						isModified=cdd.modifyCustomerDetails(cd, opt);
					} catch (CustomExceptions e) {
						e.exceptionMessage();
					}

					break;
				case 4:
					System.out.println("ENTER THE CUSTOMER ID: ");
					char mc4='n';
					String modifycustomer4=null;
					while(mc4=='n') {
						modifycustomer4=sc.next();
						if(Validations.isNumber1(modifycustomer4)) {
							mc4='x';
						}
						else {
							System.err.println("Enter the customer id in integer value !!");
						}
					}
					cd.setCustomerId(Integer.parseInt(modifycustomer4));
					System.out.println("1. ENTER THE  REVISED POSTAL CODE: ");
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
					cd.setPostalCode(Integer.parseInt(dd2));
					try {
						isModified=cdd.modifyCustomerDetails(cd, opt);
					} catch (CustomExceptions e) {
						e.exceptionMessage();
					}
					break;
				case 5:
					System.out.println("ENTER THE CUSTOMER ID: ");
					char mc5='n';
					String modifycustomer5=null;
					while(mc5=='n') {
						modifycustomer5=sc.next();
						if(Validations.isNumber1(modifycustomer5)) {
							mc5='x';
						}
						else {
							System.err.println("Enter the customer id in integer value !!");
						}
					}
					cd.setCustomerId(Integer.parseInt(modifycustomer5));
					System.out.println("1. ENTER THE  REVISED E-MAIL: ");
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
					cd.setEmail(memail);
					try {
						isModified=cdd.modifyCustomerDetails(cd, opt);
					} catch (CustomExceptions e) {
						e.exceptionMessage();
					}
					break;
				case 6:
					System.out.println("ENTER THE CUSTOMER ID: ");
					char mc6='n';
					String modifycustomer6=null;
					while(mc6=='n') {
						modifycustomer6=sc.next();
						if(Validations.isNumber1(modifycustomer6)) {
							mc6='x';
						}
						else {
							System.err.println("Enter the customer id in integer value !!");
						}
					}
					cd.setCustomerId(Integer.parseInt(modifycustomer6));
					System.out.println("1. ENTER THE  REVISED TELEPHONE NUMBER: ");
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
					cd.setTelephoneNo(Long.parseLong(mphone));
					try {
						isModified=cdd.modifyCustomerDetails(cd, opt);
					} catch (CustomExceptions e) {
						e.exceptionMessage();
					}

					break;

				default:
					System.err.println("\nPLEASE SELECT A VALID OPTION........\n");
					break;
				}

				break;
			case 6:
				ClientPage.main(args);
				break;
			default:
				System.out.println("\nPLEASE SELECT A VALID OPTION........\n");
				break;

			}

		}//while end
		
		
		
		
		
		
		
		
	}//end of method
	
}//end of class
