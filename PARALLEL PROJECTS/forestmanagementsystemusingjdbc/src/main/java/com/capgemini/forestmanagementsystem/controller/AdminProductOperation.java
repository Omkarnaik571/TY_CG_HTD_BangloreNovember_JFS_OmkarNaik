package com.capgemini.forestmanagementsystem.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.dao.ProductDao;
import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.service.ProductService;
import com.capgemini.forestmanagementsystem.service.ProductserviceImpl;
import com.capgemini.forestmanagementsystem.validations.Validations;

public class AdminProductOperation {

	static Scanner sc=new Scanner(System.in);
	
	public static void productOperations()  {
		//		Scanner sc=new Scanner(System.in);
		ProductDetailsDto pdd=FactoryClass.getProductDetailsDto();
		ProductService pd=new ProductserviceImpl();
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
					if(pd.addProduct(pdd)) {
						System.out.println("\nPRODUCT ADDED SUCCESSFULLY !!\n");
					}
					else {
						System.err.println("\nTHE PRODUCT ID THAT YOU HAVE ENTERED, ALREADY EXISTS !!\n");
					}
				}
				catch (CustomExceptions e) {
					e.productIdAlreadyExist();
					// TODO: handle exception
				}
				break;
			case 2:
				System.out.println("ENTER PRODUCT ID: ");
				char f='n';
				String f1=null;
				while(f=='n') {
				    f1=sc.next();
					if(Validations.isNumber1(f1)) {
						f='x';
					}
					else {
						System.err.println("Enter the Product id in integer value !!");
					}
				}
				 pdd.setProductId(Integer.parseInt(f1));
				try {
					ProductDetailsDto isViewSingle=pd.viewParticularProduct(pdd);
					if (isViewSingle!=null) {
						System.out.println("\n<^^^^^^^^^^^PRODUCT DETAILS^^^^^^^^^^^^^^^>");
						System.out.println(isViewSingle);
						System.out.println("-----------------------------------------------");
					}
					else {
						System.err.println("\nTHE PRODUCT ID THAT YOU HAVE ENTERED IS NOT PRESENT !!\n");
					}
					
					
				} catch (CustomExceptions e2) {
					e2.exceptionMessage();
				}
				
				
				break;
			case 3:
				try {
					List<ProductDetailsDto> result=pd.viewAllProduct();
					if(!result.isEmpty()) {
					System.out.println("\n<^^^^^^^^^^^PRODUCT DETAILS^^^^^^^^^^^^^^^>");
					for (ProductDetailsDto cx : result) {
						System.out.println(cx);
						System.out.println("-----------------------------------------");
					}
					}//end of if
					else {
						System.err.println("\nThere are no product details present in the database..\n");
					}
					
				} catch (CustomExceptions e) {
					e.exceptionMessage();
				}
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
				try {
					if(pd.deleteProduct(pdd)) {
						System.out.println("\nPRODUCT DELETED SUCCESSFULLY !!\n");
					}
					else {
						System.err.println("\nTHE PRODUCT ID THAT YOU HAVE ENTERED DOES`NT EXISTS !!\n");
					}
				} catch (CustomExceptions e2) {
					e2.exceptionMessage();
				}
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
				try {
					if(pd.modifyProduct(pdd)) {
						System.out.println("\nPRODUCT NAME MODIFIED SUCCESSFULLY !!\n");
					}
					else {
						System.err.println("\nTHE PRODUCT ID THAT YOU HAVE ENTERED DOES`NT EXISTS !!\n");
					}
				} catch (CustomExceptions e2) {
					e2.exceptionMessage();
				}
				break;
			case 6:
				AdminPage.adminMain();
				break;
			default:
				System.out.println("\nPLEASE SELECT A VALID OPTION........\n");
				break;
			}

		}//while loop end
	}//end of product operations
}//end of class
