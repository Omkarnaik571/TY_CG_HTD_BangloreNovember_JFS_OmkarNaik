package com.capgemini.forestmanagementsystem.controller;

import java.util.NoSuchElementException;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.dao.ContractorDetailsDao;
import com.capgemini.forestmanagementsystem.dao.CustomerDetailsDao;
import com.capgemini.forestmanagementsystem.dao.ProductDao;
import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.ContractCustomException;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.validations.Validations;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class ClientPage {

	static Scanner sc=new Scanner(System.in);


	private static String[] args;

	public static void main(String[] args) {
		//		 Scanner sc1=new Scanner(System.in);
		while(true) {
			System.out.println("\n------------------------CLIENT PAGE-----------------------------\n");
			System.out.println("1 FOR CONTRACTOR  OPEARTION");
			System.out.println("2 FOR PRODUCT  OPEARTION");
			System.out.println("3 FOR GOING BACK TO HOME PAGE");
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
				contractorOperations();
				break;
			case 2:
				productOperations();
				break;
			case 3:
				HomePage.main(args);
				break;
			default:
				System.err.println("\nPLEASE SELECT A VALID OPTION........");
				break;
			}
		}//end of while loop

	}


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
			System.out.println("6 GO BACK TO CLIENT PAGE");
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
				//			sc.nextLine();
				cdd.setQuantity(sc.next());
				try {
					boolean isadded=cd.addContractor(cdd);
				}
				catch (ContractCustomException x) {
					x.primarykeyviolation();
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

	public static void productOperations()  {
		ProductDetailsDto pdd=FactoryClass.getProductDetailsDto();
		ProductDao pd=FactoryClass.getProductDaoImpl();
		while(true) {
			System.out.println("Press 1 to add a new Product Details");
			System.out.println("Press 2 to view a particular  Product Detail ");	
			System.out.println("Press 3 to view All  Product Detail ");	
			System.out.println("Press 4 to delete a  Product");
			System.out.println("Press 5 to Modify a  Product Detail");
			System.out.println("Press 6 to go Client Page");
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
				boolean isViewSigle=pd.viewParticularProduct();
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
					if(Validations.isNumber1(e1)) {
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


}
