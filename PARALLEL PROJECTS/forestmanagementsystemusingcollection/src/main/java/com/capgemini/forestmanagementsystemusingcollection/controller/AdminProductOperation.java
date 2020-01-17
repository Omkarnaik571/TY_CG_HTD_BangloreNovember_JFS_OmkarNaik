package com.capgemini.forestmanagementsystemusingcollection.controller;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.ContractDetails;
import com.capgemini.forestmanagementsystemusingcollection.dto.ProductDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileModifying;
import com.capgemini.forestmanagementsystemusingcollection.factory.FactoryClass;
import com.capgemini.forestmanagementsystemusingcollection.service.ProductService;
import com.capgemini.forestmanagementsystemusingcollection.service.ProductServiceImpl;
import com.capgemini.forestmanagementsystemusingcollection.validations.Validations;


public class AdminProductOperation {

	static ProductService pService =new ProductServiceImpl();
	public static void adminProductOperation() {
        


		while(true) {
			Scanner sc=new Scanner(System.in);
			ProductDetails pd=FactoryClass.getproductDetailsObject();

			System.out.println("HERE ARE THE CHOICES: ");
			System.out.println("PRESS 1 TO ADD A NEW PRODUCT DETAIL");
			System.out.println("PRESS 2 TO VIEW ALL THE PRODUCT DETAILS");
			System.out.println("PRESS 3 TO VIEW A PARTICULAR PRODUCT DETAIL");	
			System.out.println("PRESS 4 TO DELETE A PRODUCT");
			System.out.println("PRESS 5 TO MODIFY A PRODUT");
			System.out.println("PRESS 6 TO GO TO ADMIN PAGE");
			System.out.println("\nENTER YOUR CHOICE: --> "); 
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
				System.out.println("--------ENTER THE PRODUCT DETAILS:-----------\n");
				//1. PRODUCT ID
				System.out.println("ENTER THE PRODUCT ID: ");
				char c='n';
				String c1=null;
				while(c=='n') {
				    c1=sc.next();
					if(Validations.isNumber1(c1)) {
						c='x';
					}
					else {
						System.err.println("Enter the Product id in integer value !!");
					}
				}
				pd.setProductId(Integer.parseInt(c1));
				//2. PRODUCT NAME
				System.out.println("ENTER THE PRODUCT NAME: ");
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
				pd.setProductName(cname);
				try {
					if(pService.addProduct(pd)) {
						System.out.println("\nPRODUCT ADDDED SUCCESSFULLY ^^^^\n");	
					}
				} catch (ExceptionWhileInserting e) {
					e.exceptionMessage();
				}
				
				break;
			case 2:
				try {
					TreeMap<Integer, ProductDetails> allProductResult=pService.displayAllProduct();
					Set<Map.Entry<Integer,  ProductDetails>> result=allProductResult.entrySet();
					System.out.println("\n------PRODUCT DETAILS ARE----------\n");
					for (Map.Entry<Integer,  ProductDetails> entry : result) {
						System.out.println(entry.getValue());
						System.out.println("----------------------------------------");
					}

				} catch (ExceptionWhileDisplaying e) {
					e.exceptionMessage();
				} 
				
				break;
			case 3:
				System.out.println("Enter the product Id Which yo want to see detail Of: ");
				char h='n';
				String h1=null;
				while(h=='n') {
				    h1=sc.next();
					if(Validations.isNumber1(h1)) {
						h='x';
					}
					else {
						System.err.println("Enter the Product Id in integer value !!");
					}
				}
				try {
					ProductDetails singleProduct=pService.getSingleProduct(Integer.parseInt(h1));
					System.out.println("\n------PRODUCT DETAILS OF PRODUCT Id("+singleProduct.getProductId()+")----------\n");
					System.out.println(singleProduct);
					System.out.println("----------------------------------------");

				} catch (ExceptionWhileDisplaying e) {
					e.exceptionMessage();
				}
				
				break;
			case 4:
				System.out.println("Enter the Product Id which you want to Delete:");
				char hh='n';
				String hh1=null;
				while(hh=='n') {
				    hh1=sc.next();
					if(Validations.isNumber1(hh1)) {
						hh='x';
					}
					else {
						System.err.println("Enter the Product Id in integer value !!");
					}
				}
				try {
					if(pService.removeProduct(Integer.parseInt(hh1))) {
						System.out.println("\nPRODUCT DELETED SUCCESSFULLY ^^^^\n");
					}

				} catch (ExceptionWhileDeleting e) {
					e.exceptionMessage();
				}
				
				break;
			case 5:
				System.out.println("Enter Product Id to modify details");
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
				Integer id5 = Integer.parseInt(ch6);
				ProductDetails conn=null;
				try {
					conn = pService.getSingleProduct(id5);
				} catch (ExceptionWhileDisplaying e1) {
					e1.exceptionMessage();
				}
				if(conn!=null) {
					System.out.println("ENTER THE REVISED PRODUCT NAME: ");
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
					conn.setProductName(mcname);
					try {
						pService.modifyProduct(conn);
						System.out.println("\nPRODUCT NAME MODIFIED SUCCESSFULLY !!\n");
					} catch (ExceptionWhileModifying e) {
						e.exceptionMessage();
					}
					
				}//end of if
				break;
			case 6:
                   AdminPage.adminPage();
				break;

			default:
				System.err.println("\nPLEASE SELECT A VALID OPTION !!\n");
				break;
			}//end of main switch case



		}//end of while

	}//end of admin product method

}//end of class
