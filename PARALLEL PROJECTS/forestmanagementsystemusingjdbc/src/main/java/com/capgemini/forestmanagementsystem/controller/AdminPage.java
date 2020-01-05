package com.capgemini.forestmanagementsystem.controller;

import java.util.Scanner;

import com.capgemini.forestmanagementsystem.dao.ClientDetailsDao;
import com.capgemini.forestmanagementsystem.dao.ContractorDetailsDao;
import com.capgemini.forestmanagementsystem.dao.CustomerDetailsDao;
import com.capgemini.forestmanagementsystem.dao.LandDao;
import com.capgemini.forestmanagementsystem.dao.ProductDao;
import com.capgemini.forestmanagementsystem.dao.SchedulerDetailsDao;
import com.capgemini.forestmanagementsystem.dto.ClientDetailsDto;
import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.dto.CustomerDetailsDto;
import com.capgemini.forestmanagementsystem.dto.LandDetailsDto;
import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.dto.SchedulerDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.ContractCustomException;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.validations.PasswordValidator;
import com.capgemini.forestmanagementsystem.validations.Validations;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class AdminPage {

	private static String[] args;

	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		ClientDetailsDto cld=FactoryClass.getClientDetailsDto();
		CustomerDetailsDto cud=FactoryClass.getCustomerDetailsDto();
		LandDetailsDto ld=FactoryClass.getLandDetailsDto();
		//		Scanner sc=new Scanner(System.in);

		System.out.println("\n------------------------ADMIN PAGE-----------------------------\n");
		System.out.println("1 FOR CLIENT  OPEARTION");
		System.out.println("2 FOR SCHEDULER  OPEARTION");
		System.out.println("3 FOR CUSTOMER  OPEARTION");
		System.out.println("4 FOR LAND  OPEARTION");
		System.out.println("5 FOR CONTRACT  OPEARTION");
		System.out.println("6 FOR PRODUCT  OPEARTION");
		System.out.println("7 FOR GOING BACK TO HOME PAGE");
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
			clientOperations();
			break;
		case 2:
             schedulerOperations();
			break;
		case 3:
			customerOperations();
			break;
		case 4:
			landOperations();
			break;
		case 5:
			contractorOperations();
			break;
		case 6:
			productOperations();
			break;
		case 7:
			HomePage.main(args);
			break;

		default:
			System.err.println("\nPLEASE SELECT A VALID OPTION........\n");
			main(args);
			break;
		}

	}


	public static void schedulerOperations() {
		PasswordValidator pv=new PasswordValidator();
		SchedulerDetailsDto cld=FactoryClass.getSchedulerDetailsDto();
		SchedulerDetailsDao cdd=FactoryClass.getSchedulerDetailsDaoImplObject();		

		while(true) {	
			System.out.println("--------------------CLIENT OPERATIONS------------------");
			System.out.println("1 ADD A SCHEDULER");
			System.out.println("2 DELETE A SCHEDULER");
			System.out.println("3 VIEW  SCHEDULER LISTS");
			System.out.println("4 MODIFY SCHEDULER DETAILS");
			System.out.println("5 GO BACK TO ADMIN PAGE");
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
				System.out.println("ENTER THE SCHEDULER ID : ");
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
				cld.setSchedulerId(Integer.parseInt(b1));
				sc.nextLine();
				System.out.println("ENTER THE SCHEDULER NAME : ");
				String cname=null;
				char g='y';
				while(g=='y') {
					cname=sc.nextLine();
					if(Validations.isStringOnlyAlphabet(cname)) {
						g='n';
					}
					else {
						System.err.println("SCHEDULER Name can be of alphabets only !!");
					}
				}
				cld.setSchedulerName(cname);
				System.out.println("ENTER THE SCHEDULER PASSWORD : ");
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
				cld.setPassword(f1);
				try {
					boolean isAdded= cdd.addScheduler(cld);
				} catch (CustomExceptions e) {
					
					e.schedulerIdAlreadyExist();
				}
				break;
			case 2:
				System.out.println("ENTER THE SCHEDULER ID : ");
				char b12='n';
				String bb1=null;
				while(b12=='n') {
					bb1=sc.next();
					if(Validations.isNumber1(bb1)) {
						b12='x';
					}
					else {
						System.err.println("ENTER THE CLIENT ID IN INTEGER VALUES !!");
					}
				}			
				cld.setSchedulerId(Integer.parseInt(bb1));
				System.out.println("ENTER THE SCHEDULER PASSWORD : ");
				char f12='n';
				String ff1=null;
				while(f12=='n') {
					ff1=sc.next();
					if( pv.validate(ff1) ) {
						f12='x';
					}
					else {
						System.err.println("Password must contains one digit from 0-9 ");
						System.err.println("one lowercase character, one uppercase character ");
						System.err.println("one special symbol in the list [@#$%],  and length between 8 characters and maximum of 20 ");
					}
				}

				cld.setPassword(ff1);
				boolean isDeleted= cdd.deleteScheduler(cld);
				break;
			case 3:
				boolean isViewAll=cdd.viewAllScheduler();
				break;
			case 4:
				break;
			case 5:
				main(args);
				break;
			default:
				System.err.println("\nPLEASE SELECT A VALID OPTION........\n");
				break;
			}
		}//while loop end	




	}//end of scheduler operation






	public static void clientOperations() {
		PasswordValidator pv=new PasswordValidator();
		ClientDetailsDto cld=FactoryClass.getClientDetailsDto();
		ClientDetailsDao cdd=FactoryClass.getClientDetailsDaoImpl();
		//		Scanner sc=new Scanner(System.in);
		while(true) {	
			System.out.println("--------------------CLIENT OPERATIONS------------------");
			System.out.println("1 ADD A CLIENT");
			System.out.println("2 DELETE A CLIENT");
			System.out.println("3 VIEW  CLIENT LISTS");
			System.out.println("4 MODIFY CLIENT DETAILS");
			System.out.println("5 GO BACK TO ADMIN PAGE");
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
				System.out.println("ENTER THE CLIENT ID : ");
				char b='n';
				String b1=null;
				while(b=='n') {
					b1=sc.next();
					if(Validations.isNumber1(b1)) {
						b='x';
					}
					else {
						System.err.println("ENTER THE CLIENT ID IN INTEGER VALUES !!");
					}
				}
				cld.setClientId(Integer.parseInt(b1));
				sc.nextLine();
				System.out.println("ENTER THE CLIENT NAME : ");
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
				cld.setClientName(cname);
				System.out.println("ENTER THE CLIENT PASSWORD : ");
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
				cld.setPassword(f1);
				boolean isAdded= cdd.addClient(cld);
				break;
			case 2:
				System.out.println("ENTER THE CLIENT ID : ");
				char b12='n';
				String bb1=null;
				while(b12=='n') {
					bb1=sc.next();
					if(Validations.isNumber1(bb1)) {
						b12='x';
					}
					else {
						System.err.println("ENTER THE CLIENT ID IN INTEGER VALUES !!");
					}
				}			
				cld.setClientId(Integer.parseInt(bb1));
				System.out.println("ENTER THE CLIENT PASSWORD : ");
				char f12='n';
				String ff1=null;
				while(f12=='n') {
					ff1=sc.next();
					if( pv.validate(ff1) ) {
						f12='x';
					}
					else {
						System.err.println("Password must contains one digit from 0-9 ");
						System.err.println("one lowercase character, one uppercase character ");
						System.err.println("one special symbol in the list [@#$%],  and length between 8 characters and maximum of 20 ");
					}
				}

				cld.setPassword(ff1);
				boolean isDeleted= cdd.deleteClient(cld);
				break;
			case 3:
				boolean isViewAll=cdd.viewAllClient();
				break;
			case 4:
				System.out.println("ENTER THE CLIENT ID : ");
				char e='n';
				String e1=null;
				while(e=='n') {
					e1=sc.next();
					if(Validations.isNumber1(e1)) {
						e='x';
					}
					else {
						System.err.println("ENTER THE CLIENT ID IN INTEGER VALUES !!");
					}
				}		
				cld.setClientId(Integer.parseInt(e1));
				System.out.println("ENTER THE CLIENT PASSWORD : ");
				char o1='n';
				String oldpwd=null;
				while(o1=='n') {
					oldpwd=sc.next();
					if( pv.validate(oldpwd) ) {
						o1='x';
					}
					else {
						System.err.println("Password must contains one digit from 0-9 ");
						System.err.println("one lowercase character, one uppercase character ");
						System.err.println("one special symbol in the list [@#$%],  and length between 8 characters and maximum of 20 ");
					}
				}
				String pass=oldpwd;
				System.out.println("ENTER THE REVISED PASSWORD : ");
				char o2='n';
				String newpwd=null;
				while(o2=='n') {
					newpwd=sc.next();
					if( pv.validate(newpwd) ) {
						o2='x';
					}
					else {
						System.err.println("Password must contains one digit from 0-9 ");
						System.err.println("one lowercase character, one uppercase character ");
						System.err.println("one special symbol in the list [@#$%],  and length between 8 characters and maximum of 20 ");
					}
				}

				cld.setPassword(newpwd);
				boolean isModified=cdd.modifyClient(cld,pass );
				break;
			case 5:
				main(args);
				break;
			default:
				System.err.println("\nPLEASE SELECT A VALID OPTION........\n");
				break;
			}
		}//while loop end	

	}
	//client opeartion end

	public static void customerOperations() {
		CustomerDetailsDao cdd=FactoryClass.getCustomerDetailsDaoImpl();
		CustomerDetailsDto cd=FactoryClass.getCustomerDetailsDto();

		while(true) {
			System.out.println("--------ENTER THE USER DETAILS:-----------\n");
			System.out.println("Press 1 to add a new Customer Details");
			System.out.println("Press 2 to view all the Customer Details");
			System.out.println("Press 3 to view a particular Customer Detail ");	
			System.out.println("Press 4 to delete a Customer");
			System.out.println("Press 5 to Modify a Customer");
			System.out.println("press 6 GO BACK TO ADMIN PAGE");
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
				cd.setTelephoneno(Long.parseLong(a1));

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
				boolean isViewAll= cdd.viewCustomerDetails();

				break;
			case 3:
				//View a particular customer
				boolean isViewSingle=cdd.viewSingleCustomerDetails();
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
				boolean isDeleted=cdd.deleteCustomerDetails(cd);
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
					isModified=cdd.modifyCustomerDetails(cd, opt);
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
					isModified=cdd.modifyCustomerDetails(cd, opt);

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
					isModified=cdd.modifyCustomerDetails(cd, opt);

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
					isModified=cdd.modifyCustomerDetails(cd, opt);
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
					isModified=cdd.modifyCustomerDetails(cd, opt);
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
					cd.setTelephoneno(Long.parseLong(mphone));
					isModified=cdd.modifyCustomerDetails(cd, opt);

					break;

				default:
					System.err.println("\nPLEASE SELECT A VALID OPTION........\n");
					break;
				}

				break;
			case 6:
				main(args);
				break;
			default:
				System.out.println("\nPLEASE SELECT A VALID OPTION........\n");
				break;

			}

		}//while end
	}
	//customer operation end

	public static void landOperations() {
		LandDetailsDto ldd=FactoryClass.getLandDetailsDto();
		LandDao ld=FactoryClass.getLandDaoImpl();
		while(true) {

			System.out.println("--------------------CLIENT OPERATIONS------------------");
			System.out.println("1 ADD A LAND DETAIL");
			System.out.println("2 DELETE A LAND DETAIL");
			System.out.println("3 VIEW  LAND DETAILS");
			System.out.println("4 MODIFY LAND DETAILS");
			System.out.println("5 GO BACK TO ADMIN PAGE");
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
				System.out.println("ENTER THE PLOT NUMBER : ");
				char c='n';
				String c1=null;
				while(c=='n') {
					c1=sc.next();
					if(Validations.isNumber1(c1)) {
						c='x';
					}
					else {
						System.err.println("Enter the Plot number in natural numbers only !!");
					}
				}
				ldd.setPlotNumber(Integer.parseInt(c1));
				System.out.println("ENTER THE ACQUIRED DATE : ");
				ldd.setAcquireDdate(sc.next());
				System.out.println("ENTER THE LAND VALUE : ");
				char d='n';
				String d1=null;
				while(d=='n') {
					d1=sc.next();
					if(Validations.isNumber1(d1)) {
						d='x';
					}
					else {
						System.err.println("Enter the Land price in integer value !!");
					}
				}
				ldd.setLandValue(d1);
				System.out.println("ENTER THE LOCATION : ");
				char e='n';
				String e1=null;
				while(e=='n') {
					e1=sc.next();
					if(Validations.isStringOnlyAlphabet(e1)) {
						e='x';
					}
					else {
						System.err.println("Enter the location in alphabets only !!");
					}
				}
				ldd.setLocation(e1);
				try {
					boolean isAdded=  ld.addLand(ldd);
				}
				catch (CustomExceptions n) {
					n.plotNumberAlreadyExist();
					// TODO: handle exception
				}
				break;
			case 2:
				System.out.println("ENTER THE PLOT NUMBER : ");
				char plot1='n';
				String plotno1=null;
				while(plot1=='n') {
					plotno1=sc.next();
					if(Validations.isNumber1(plotno1)) {
						plot1='x';
					}
					else {
						System.err.println("Enter the Plot number in natural numbers only !!");
					}
				}
				ldd.setPlotNumber(Integer.parseInt(plotno1));
				boolean isDeleted= ld.deleteLand(ldd);
				break;
			case 3:
				boolean viewAll=ld.viewAllLand();
				break;
			case 4:
				boolean isModified=false;
				System.out.println("1 TO MODIFY ACQUIRED DATE : ");
				System.out.println("2 TO MODIFY LAND VALUE : ");
				char n='n';
				String choicen=null;
				while(n=='n') {
					choicen=sc.next();

					if(Validations.isNumber1(choicen)) {
						n='x';
					}
					else {
						System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
					}
				}

				int option=Integer.parseInt(choicen);
				switch (option) {
				case 1:
					System.out.println("ENTER THE PLOT NUMBER : ");
					char plot2='n';
					String plotno2=null;
					while(plot2=='n') {
						plotno2=sc.next();
						if(Validations.isNumber1(plotno2)) {
							plot2='x';
						}
						else {
							System.err.println("Enter the Plot number in natural numbers only !!");
						}
					}
					ldd.setPlotNumber(Integer.parseInt(plotno2));
					System.out.println("ENTER THE  REVISED ACQUIRED DATE : ");
					sc.nextLine();
					ldd.setAcquireDdate(sc.nextLine());
					isModified=ld.modifyLand(ldd, option);

					break;
				case 2:
					System.out.println("ENTER THE PLOT NUMBER : ");
					char plot3='n';
					String plotno3=null;
					while(plot3=='n') {
						plotno3=sc.next();
						if(Validations.isNumber1(plotno3)) {
							plot3='x';
						}
						else {
							System.err.println("Enter the Plot number in natural numbers only !!");
						}
					}
					ldd.setPlotNumber(Integer.parseInt(plotno3));
					System.out.println("ENTER THE REVISED LAND VALUE : ");
					char g='n';
					String g1=null;
					while(g=='n') {
						g1=sc.next();
						if(Validations.isNumber1(g1)) {
							g='x';
						}
						else {
							System.err.println("Enter the Land price in integer value !!");
						}
					}
					ldd.setLandValue(g1);
					isModified=ld.modifyLand(ldd, option);

					break;
				default:
					System.err.println("/nPLEASE SELECT A VALID OPTION/n");

					break;
				}
				break;
			case 5:
				main(args);
				break;
			default:
				System.err.println("\nPLEASE SELECT A VALID OPTION........\n");
				break;
			}

		}//end of while loop

	}
	//land opeartion end

	public static void productOperations()  {
		//		Scanner sc=new Scanner(System.in);
		ProductDetailsDto pdd=FactoryClass.getProductDetailsDto();
		ProductDao pd=FactoryClass.getProductDaoImpl();
		while(true) {
			System.out.println("Press 1 to add a new Product Details");
			System.out.println("Press 2 to view a particular  Product Detail ");	
			System.out.println("Press 3 to view All  Product Detail ");	
			System.out.println("Press 4 to delete a  Product");
			System.out.println("Press 5 to Modify a  Product Detail");
			System.out.println("Press 6 to go Admin Page");
			System.out.println("\nEnter your Chice: --> "); 
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
				System.out.println("ENTER PRODUCT ID: ");
				char c='n';
				String c1=null;
				while(c=='n') {
					c1=sc.next();
					if(Validations.isNumber1(c1) && c1.length()<=9) {
						c='x';
					}
					else {
						System.err.println("Enter the Product id in integer value, and length should be less than 10 digits !!");
					}
				}
				pdd.setProductId(Integer.parseInt(c1));
				System.out.println("ENTER PRODUCT NAME:");
				String cname=null;
				char g='y';
				while(g=='y') {
					cname=sc.next();
					if(Validations.isStringOnlyAlphabet(cname)) {
						g='n';
					}
					else {
						System.err.println("Product Name can be of alphabets only !!");
					}
				}
				pdd.setProductName(cname);
				try {
					boolean isAdded=pd.addProduct(pdd);
				}
				catch (CustomExceptions e) {
					e.productIdAlreadyExist();
					// TODO: handle exception
				}
				break;
			case 2:
				boolean isViewSingle=pd.viewParticularProduct();
				break;
			case 3:
				boolean isViewAll=pd.viewAllProduct();
				break;
			case 4:
				System.out.println("ENTER PRODUCT ID: ");
				char d='n';
				String d1=null;
				while(d=='n') {
					d1=sc.next();
					if(Validations.isNumber1(d1)) {
						d='x';
					}
					else {
						System.err.println("Enter the Product id in integer value, and length should be less than 10 digits !!");
					}
				}
				pdd.setProductId(Integer.parseInt(d1));
				boolean isDeleted= pd.deleteProduct(pdd);
				break;
			case 5:
				System.out.println("ENTER PRODUCT ID: ");
				char e='n';
				String e1=null;
				while(e=='n') {
					e1=sc.next();
					if(Validations.isNumber1(e1) && e1.length()<=9) {
						e='x';
					}
					else {
						System.err.println("Enter the Product id in integer value, and length should be less than 10 digits !!");
					}
				}
				pdd.setProductId(Integer.parseInt(e1));
				System.out.println("ENTER REVISED PRODUCT NAME:");
				String mcname=null;
				char j='y';
				while(j=='y') {
					mcname=sc.next();
					if(Validations.isStringOnlyAlphabet(mcname)) {
						j='n';
					}
					else {
						System.err.println("Product Name can be of alphabets only !!");
					}
				}
				pdd.setProductName(mcname);
				boolean isModified=pd.modifyProduct(pdd);
				break;
			case 6:
				main(args);
				break;
			default:
				System.out.println("\nPLEASE SELECT A VALID OPTION........\n");
				break;
			}

		}//while loop end
	}//end of product operations


	public static void contractorOperations() {
		ContractorDetailsDto cdd=FactoryClass.getContractorDetailsDto();
		ContractorDetailsDao cd=FactoryClass.getContractorDaoImpl();
		while(true) {
			System.out.println("--------------------CONTRACT OPERATIONS------------------");
			System.out.println("1 ADD A CONTRACTOR");
			System.out.println("2 DELETE A CONTRACTOR");
			System.out.println("3 VIEW  CONTRACTOR");
			System.out.println("4 VIEW  ALL CONTRACTOR");
			System.out.println("5 MODIFY CONTRACTOR DETAILS");
			System.out.println("6 GO BACK TO ADMIN PAGE");
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
				System.out.println("ENTER THE CONTRACT NO: ");
				char b='n';
				String b1=null;
				while(b=='n') {
					b1=sc.next();
					if(Validations.isNumber1(b1)) {
						b='x';
					}
					else {
						System.err.println("Enter the contract number in integer value !!");
					}
				}
				cdd.setContractNo(Integer.parseUnsignedInt(b1));
				System.out.println("Enter the Customer Id: ");
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
				cdd.setCustomerId(Integer.parseUnsignedInt(c1));
				System.out.println("Enter the Product Id: ");
				char d='n';
				String d1=null;
				while(d=='n') {
					d1=sc.next();
					if(Validations.isNumber1(d1)) {
						d='x';
					}
					else {
						System.err.println("Enter the product id in integer value !!");
					}
				}
				cdd.setProductId(Integer.parseInt(d1));
				System.out.println("Enter the Haulier Id: ");
				char f='n';
				String f1=null;
				while(f=='n') {
					f1=sc.next();
					if(Validations.isNumber1(f1)) {
						f='x';
					}
					else {
						System.err.println("Enter the haulier id in integer value !!");
					}
				}
				cdd.setHaulierId(Integer.parseUnsignedInt(f1));
				sc.nextLine();
				System.out.println("Enter the Delivery Date: ");
				String ddate=null;
				char z='y';
				while(z=='y') {
					ddate=sc.next();
					if( Validations.isValidDate(ddate)) {
						System.err.println("\nEnter delivery date in (dd/mm/yyyy) format and It should be in future date only");
					}
					else {
						z='n';
					}
				}
				cdd.setDeliveryDate(ddate);
				System.out.println("Enter the Delivery Day: ");
				String day=null;
				char g='y';
				while(g=='y') {
					day=sc.next();
					if(Validations.isValidDay(day)) {
						g='n';
					}
					else {
						System.err.println("Please enter a day according to the calender (i.e Sunday, Monday) !!");
					}
				}
				cdd.setDeliveryDay(day);
				System.out.println("Enter the Quantity:(Enter In Terms Of Kg) !! ");
				cdd.setQuantity(sc.next());
				try {
					boolean isadded=cd.addContractor(cdd);
				}
				catch (ContractCustomException e) {
					e.primarykeyviolation();
				}
				catch (MySQLIntegrityConstraintViolationException e) {
					System.err.println("Primary key is getting violated");
					// TODO: handle exception
				}
				break;
			case 2:
				System.out.println("ENTER THE CONTRACT NO: ");
				char i='n';
				String i1=null;
				while(i=='n') {
					i1=sc.next();
					if(Validations.isNumber1(i1)) {
						i='x';
					}
					else {
						System.err.println("Enter the Contractor number in integer value !!");
					}
				}
				cdd.setContractNo(Integer.parseInt(i1));
				boolean isDeleted=cd.deleteContractorDetails(cdd);
				break;
			case 3:
				boolean isViewSingle= cd.viewSingleContractorDetails();
				break;
			case 4:
				boolean isViewAll=cd.viewContractorDetails();
				break;
			case 5:
				System.out.println("--------------------MODIFY CUSTOMER DETAILS---------------------");
				System.out.println("1.  MODIFY DELIVERY DATE: ");
				System.out.println("2.  MODIFY DELIVERY DAY: ");
				System.out.println("3.  MODIFY QUANTITY: ");
				char a1='n';
				String choice1=null;
				while(a1=='n') {
					choice1=sc.next();
					if(Validations.isNumber1(choice1)) {
						a1='x';
					}
					else {
						System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
					}
				}
				int option=Integer.parseInt(choice1);
				boolean isModified=false;
				switch (option) {
				case 1:
					System.out.println("ENTER THE CONTRACT NO: ");
					char b11='n';
					String bb1=null;
					while(b11=='n') {
						bb1=sc.next();
						if(Validations.isNumber1(bb1)) {
							b11='x';
						}
						else {
							System.err.println("Enter the contract number in integer value !!");
						}
					}
					cdd.setContractNo(Integer.parseInt(bb1));
					sc.nextLine();
					System.out.println("ENTER THE REVISED DELIVERY DATE: ");
					String ddate2=null;
					char z2='y';
					while(z2=='y') {
						ddate2=sc.next();
						if( Validations.isValidDate(ddate2)) {
							System.err.println("\nEnter delivery date in (dd/mm/yyyy) format and It should be in future date only");
						}
						else {
							z2='n';
						}
					}
					cdd.setDeliveryDate(ddate2);
					isModified=cd.modifyContractorDetails(cdd,option);
					break;
				case 2:
					System.out.println("ENTER THE CONTRACT NO: ");
					char c11='n';
					String cc1=null;
					while(c11=='n') {
						cc1=sc.next();
						if(Validations.isNumber1(cc1)) {
							c11='x';
						}
						else {
							System.err.println("Enter the contract number in integer value !!");
						}
					}
					cdd.setContractNo(Integer.parseInt(cc1));
					sc.nextLine();
					System.out.println("ENTER THE REVISED DELIVERY DAY: ");
					String day2=null;
					char g2='y';
					while(g2=='y') {
						day2=sc.next();
						if(Validations.isValidDay(day2)) {
							g2='n';
						}
						else {
							System.err.println("Please enter a day according to the calender (i.e Sunday, Monday) !!");
						}
					}

					cdd.setDeliveryDay(day2);
					isModified=cd.modifyContractorDetails(cdd, option);
					break;
				case 3:
					System.out.println("ENTER THE CONTRACT NO: ");
					char d11='n';
					String dd1=null;
					while(d11=='n') {
						dd1=sc.next();
						if(Validations.isNumber1(dd1)) {
							d11='x';
						}
						else {
							System.err.println("Enter the contract number in integer value !!");
						}
					}
					cdd.setContractNo(Integer.parseInt(dd1));
					sc.nextLine();
					System.out.println("ENTER THE QUANTITY: (Enter In Terms Of Kg) !! ");
					cdd.setQuantity(sc.nextLine());
					isModified=cd.modifyContractorDetails(cdd, option);
					break;

				default:
					System.err.println("\nPLEASE SELECT A VALID OPTION........\n");
					break;
				}

				break;
			case 6:
				main(args);
				break;
			default:
				System.err.println("\nPLEASE SELECT A VALID OPTION........\n");
				break;
			}


		}//end of while loop
	}//end of contractor operations








}
