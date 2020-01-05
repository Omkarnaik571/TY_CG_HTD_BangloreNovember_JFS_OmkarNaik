package com.capgemini.forestmanagementsystem.controller;

import java.util.Scanner;


import com.capgemini.forestmanagementsystem.dao.ContractorDetailsDao;
import com.capgemini.forestmanagementsystem.dao.CustomerDetailsDao;
import com.capgemini.forestmanagementsystem.dao.LandDao;
import com.capgemini.forestmanagementsystem.dao.ProductDao;

import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.dto.CustomerDetailsDto;
import com.capgemini.forestmanagementsystem.dto.LandDetailsDto;
import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;

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
			AdminClientOperation.adminClientOperation();
			break;
		case 2:
			AdminSchedulerOperation.adminSchedulerOperation();
			break;
		case 3:
			AdminCustomerOperations.adminCustomerOperation();
			break;
		case 4:
			AdminLandOperations.adminLandOperation();
			break;
		case 5:
			AdminContractOperations.adminContractOperation();
			break;
		case 6:
			AdminProductOperations.adminProductOperation();
			break;
		case 7:
			HomePage.main(args);
			break;

		default:
			System.err.println("\nPLEASE SELECT A VALID OPTION........\n");
			main(args);
			break;
		}//end of switch case

	}//end of main method


	
}//end of class
