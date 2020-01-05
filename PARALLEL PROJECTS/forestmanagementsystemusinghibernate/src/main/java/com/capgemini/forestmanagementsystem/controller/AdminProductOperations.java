package com.capgemini.forestmanagementsystem.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.dao.ProductDao;
import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.service.ProductService;
import com.capgemini.forestmanagementsystem.validations.Validations;

public class AdminProductOperations {

	static Scanner sc = new Scanner(System.in);

	public static void adminProductOperation() {
		ProductService pd = FactoryClass.getProductDetailsServiceImpl();
		ProductDetailsDto pdd = FactoryClass.getProductDetailsDto();

		while (true) {
			System.out.println("Press 1 to add a new Product Details");
			System.out.println("Press 2 to view a particular  Product Detail ");
			System.out.println("Press 3 to view All  Product Detail ");
			System.out.println("Press 4 to delete a  Product");
			System.out.println("Press 5 to Modify a  Product Detail");
			System.out.println("Press 6 to go Client Page");
			System.out.println("\nEnter your Chice: --> ");
			char a = 'n';
			String choice = null;
			while (a == 'n') {
				choice = sc.next();
				if (Validations.isNumber1(choice)) {
					a = 'x';
				} else {
					System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
				}
			}
			int option = Integer.parseInt(choice);
			switch (option) {
			case 1:
				System.out.println("ENTER PRODUCT ID: ");
				char c = 'n';
				String c1 = null;
				while (c == 'n') {
					c1 = sc.next();

					if (Validations.isNumber1(c1) && c1.length() <= 9) {
						c = 'x';
					} else {
						System.err.println(
								"Enter the Product id in integer value, and length should be less than 10 digits !!");
					}
				}
				pdd.setProductId(Integer.parseInt(c1));
				System.out.println("ENTER PRODUCT NAME:");
				String cname = null;
				char g = 'y';
				while (g == 'y') {
					cname = sc.next();
					if (Validations.isStringOnlyAlphabet(cname)) {
						g = 'n';
					} else {
						System.err.println("Product Name can be of alphabets only !!");
					}
				}
				pdd.setProductName(cname);
				try {
					boolean isAdded = pd.addProduct(pdd);
				} catch (CustomExceptions e2) {
					e2.productIdAlreadyExist();
				}

				break;
			case 2:
				System.out.println("ENTER PRODUCT ID: ");
				char f = 'n';
				String f1 = null;
				while (f == 'n') {
					f1 = sc.next();
					if (Validations.isNumber1(f1)) {
						f = 'x';
					} else {
						System.err.println(
								"Enter the Product id in integer value, and length should be less than 10 digits !!");
					}
				}
				ProductDetailsDto isViewSingle = null;
				pdd.setProductId(Integer.parseInt(f1));
				try {
					isViewSingle = pd.viewParticularProduct(pdd);
				} catch (CustomExceptions e3) {
					e3.exceptionMessage();
				}
				System.out.println(isViewSingle);
				if (isViewSingle == null) {
					System.err.println("\nThe product id that you have entered is not present !!\n");
				} else {
					System.out.println("\n---------PRODUCT DETAILS------------------");
					System.out.println("Product ID : " + isViewSingle.getProductId());
					System.out.println("Product Name : " + isViewSingle.getProductName());
					System.out.println("--------------------------------------------");
				}
				break;
			case 3:
				try {
					List<ProductDetailsDto> result = pd.viewAllProduct();
					System.out.println("\n---------PRODUCT DETAILS------------------");
					for (ProductDetailsDto r1 : result) {
						System.out.println(r1);
						System.out.println("--------------------------------------------");
					}

					if (result.isEmpty()) {
						System.out.println("\nTHERE ARE NO PRODUCT DETAILS  PRESENT IN THE DATABASE!!\n");
					}

				} catch (CustomExceptions e2) {
					e2.exceptionMessage();
				}
				break;
			case 4:
				System.out.println("ENTER PRODUCT ID: ");
				char d = 'n';
				String d1 = null;
				while (d == 'n') {
					d1 = sc.next();
					if (Validations.isNumber1(d1)) {
						d = 'x';
					} else {
						System.err.println(
								"Enter the Product id in integer value, and length should be less than 10 digits !!");
					}
				}
				pdd.setProductId(Integer.parseInt(d1));
				try {
					boolean isDeleted = pd.deleteProduct(pdd);
				} catch (CustomExceptions e2) {
					e2.exceptionMessage();
				}
				break;
			case 5:
				System.out.println("ENTER PRODUCT ID: ");
				char e = 'n';
				String e1 = null;
				while (e == 'n') {
					e1 = sc.next();
					if (Validations.isNumber1(e1)) {
						e = 'x';
					} else {
						System.err.println(
								"Enter the Product id in integer value, and length should be less than 10 digits !!");
					}
				}
				pdd.setProductId(Integer.parseInt(e1));
				System.out.println("ENTER REVISED PRODUCT NAME:");
				String mcname = null;
				char j = 'y';
				while (j == 'y') {
					mcname = sc.next();
					if (Validations.isStringOnlyAlphabet(mcname)) {
						j = 'n';
					} else {
						System.err.println("Product Name can be of alphabets only !!");
					}
				}
				pdd.setProductName(mcname);

				try {
					boolean isModified = pd.modifyProduct(pdd);
				} catch (CustomExceptions e2) {
					e2.exceptionMessage();
				}
				break;
			case 6:

				break;
			default:
				System.out.println("\nPLEASE SELECT A VALID OPTION........\n");
				break;
			}

		} // while loop end

	}// end of method

}// end of class
