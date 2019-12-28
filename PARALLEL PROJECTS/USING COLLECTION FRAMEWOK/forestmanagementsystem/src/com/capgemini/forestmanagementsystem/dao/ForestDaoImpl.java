package com.capgemini.forestmanagementsystem.dao;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.capgemini.forestmanagementsystem.controller.ClientDetailsMain;
import com.capgemini.forestmanagementsystem.dto.ContractDetails;
import com.capgemini.forestmanagementsystem.dto.CustomerDetail;
import com.capgemini.forestmanagementsystem.dto.LandDetails;
import com.capgemini.forestmanagementsystem.dto.ProductDetails;
import com.capgemini.forestmanagementsystem.validations.PasswordValidator;
import com.capgemini.forestmanagementsystem.validations.Validations;


public class ForestDaoImpl implements ForestDao {
	Scanner sc=new Scanner(System.in);
	
	Map<Integer, ContractDetails> m1=new TreeMap<Integer, ContractDetails>();
	Map<Integer, CustomerDetail> m2=new TreeMap<Integer, CustomerDetail>();
	Map<Integer, ProductDetails> m3=new TreeMap<Integer, ProductDetails>();
	Map<Integer, String> m4=new TreeMap<Integer, String>();	//client map
	Map<Integer, LandDetails> m5=new TreeMap<Integer, LandDetails>();
	Map<Integer, String> m6=new TreeMap<Integer, String>();//scheduler map
	@Override
	public Map<Integer, ContractDetails> addTheContractDetails(ContractDetails cdbean) {
		
		System.out.println("Enter the Contractor Number: ");
		char b='n';
		String b1=null;
		while(b=='n') {
		    b1=sc.next();
			if(Validations.isNumber1(b1)) {
				b='x';
			}
			else {
				System.err.println("ENTER THE CONTRACTOR IN INTEGER VALUES !!");
			}
		}
		int contractorno=Integer.parseInt(b1);
		m1.put(contractorno, cdbean);
		
		return m1;
	}

	@Override
	public Map<Integer, CustomerDetail> addTheCustomerDetails(CustomerDetail cd) {
//		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the User Number: ");
		char b='n';
		String b1=null;
		while(b=='n') {
		    b1=sc.next();
			if(Validations.isNumber1(b1)) {
				b='x';
			}
			else {
				System.err.println("ENTER THE CUSTOMER ID IN INTEGER VALUES !!");
			}
		}
		int userno=Integer.parseInt(b1);
		m2.put(userno, cd);
		
		return m2;
	}

	@Override
	public Map<Integer,ProductDetails> addTheProductDetails(ProductDetails pd) {
//		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Product Number: ");
		char b='n';
		String b1=null;
		while(b=='n') {
		    b1=sc.next();
			if(Validations.isNumber1(b1)) {
				b='x';
			}
			else {
				System.err.println("ENTER THE PRODUCT NUMBER IN INTEGER VALUES !!");
			}
		}
		int productno=Integer.parseInt(b1);
		m3.put(productno, pd);
		return m3;
	}

	@Override
	public Map<Integer, LandDetails> addTheLandDetails(LandDetails ld) {
//		Scanner sc=new Scanner(System.in);
		System.out.println("\nENTER THE LAND ID : ");
		char b='n';
		String b1=null;
		while(b=='n') {
		    b1=sc.next();
			if(Validations.isNumber1(b1)) {
				b='x';
			}
			else {
				System.err.println("ENTER THE LAND ID IN INTEGER VALUES !!");
			}
		}
		int landid=Integer.parseInt(b1);
		m5.put(landid, ld);
		
		return m5;
	}

	
	@Override
	public Map<Integer, String> addTheClientDetails() {
	PasswordValidator pv=new PasswordValidator();
//		Scanner sc=new Scanner(System.in);
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
		int clientid=Integer.parseInt(b1);
		if(m4.containsKey(clientid)) {
			System.err.println("\nENTER A DIFFERENT USER ID , THIS ID IS ALREADY PRESENT\n");
			ClientDetailsMain.clientDetailsMain();
		}
		sc.nextLine();
		System.out.println("ENTER THE CLIENT PASSWORD");
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
		String clientpass=f1;
		m4.put(clientid, clientpass);
		return m4;
	}

	@Override
	public Map<Integer, String> getTheClientDetails() {
		
		return m4;
	}

	@Override
	public Map<Integer, String> addTheSchedulerDetails() {
		PasswordValidator pv=new PasswordValidator();
//		Scanner sc=new Scanner(System.in);
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
		int clientid=Integer.parseInt(b1);
		if(m6.containsKey(clientid)) {
			System.err.println("\nENTER A DIFFERENT SCHEDULER ID , THIS ID IS ALREADY PRESENT\n");
			
		}
		sc.nextLine();
		System.out.println("ENTER THE SCHEDULER	PASSWORD");
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
		String clientpass=f1;
		m6.put(clientid, clientpass);
		return m6;
	}

	@Override
	public Map<Integer, String> getTheSchedulerDetails() {
		
		return m6;
	}

	

	
	
	
	
}
