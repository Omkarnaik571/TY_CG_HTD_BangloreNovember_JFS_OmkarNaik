package com.capgemini.forestmanagementsystemusingcollection.controller;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.ContractDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileModifying;
import com.capgemini.forestmanagementsystemusingcollection.factory.FactoryClass;
import com.capgemini.forestmanagementsystemusingcollection.service.ContractService;
import com.capgemini.forestmanagementsystemusingcollection.service.ContractServiceImpl;
import com.capgemini.forestmanagementsystemusingcollection.validations.Validations;


public class AdminContractOperations {
	static ContractService contractService=new ContractServiceImpl();
	
	public static void adminContractOperation() {
		
		while(true) {
			
			ContractDetails cdbean=FactoryClass.getContractDetailsObject();
			Scanner sc=new Scanner(System.in);
			System.out.println("Here are the choices: ");
			System.out.println("Press 1 to add a new Contract Detail");
			System.out.println("Press 2 to view all the Contract Details");
			System.out.println("Press 3 to view a particular Contract Detail");	
			System.out.println("Press 4 to delete a Contract");
			System.out.println("Press 4 to Modify a Contract Detail");
			System.out.println("Press 6 to go Admin Page");
			System.out.println("Press 7 to go Client Page");
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
			int ch=Integer.parseInt(choice);
			switch (ch) {
			case 1:
				System.out.println("--------Enter the Contract Details:-----------\n");
				//1. Contract Number
				System.out.println("Enter the Contract Number: ");
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
				int bb1=Integer.parseInt(b1);
				cdbean.setContractNo(bb1);
				//2. Customer Id
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
				int cc1=Integer.parseInt(c1);
				cdbean.setCustomerId(cc1);
				//3.Product Id:
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
				int dd1=Integer.parseInt(d1);
				cdbean.setProductId(dd1);
				//5. Delivery Date:
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
				cdbean.setDeliveryDate(ddate);
				//Enter quantity
				System.out.println("Enter the Quantity: ");
				char h='n';
				String h1=null;
				while(h=='n') {
					h1=sc.next();
					if(Validations.isNumber1(h1)) {
						h='x';
					}
					else {
						System.err.println("Qunatity will be of number only (Enter In Terms Of Kg) !!");
					}
				}
				int hh1=Integer.parseInt(h1);
				cdbean.setQuantity(hh1);
				try {
					if(contractService.addContract(cdbean)) {
						System.out.println("\nCONTRACT ADDDED SUCCESSFULLY ^^^^\n");	
					}
				} catch (ExceptionWhileInserting e) {
					e.exceptionMessage();
				}

				break;
			case 2:
				try {
					TreeMap<Integer, ContractDetails> allContractResult=contractService.getAllContract();
					Set<Map.Entry<Integer, ContractDetails>> result= allContractResult.entrySet();
					System.out.println("\n------CONTRACT DETAILS ARE----------\n");
					for (Map.Entry<Integer, ContractDetails> entry : result) {
						System.out.println(entry.getValue());
						System.out.println("----------------------------------------");
					}

				} catch (ExceptionWhileDisplaying e) {
					e.exceptionMessage();
				}
				break;
			case 3:
				System.out.println("Enter the Contract Number Which yo want to see detail Of: ");
				String k1=null;
				char k='n';
				while(k=='n') {
					k1=sc.next();
					if(Validations.isNumber1(k1)) {
						k='x';
					}
					else {
						System.err.println("Enter the Contractor number in integer value !!");
					}
				}
//				cdbean.setContractNo(Integer.parseInt(k1));
				try {
					ContractDetails singleContract=contractService.getSingleContract(Integer.parseInt(k1));
//					singleContract=contractService.getSingleContract(cdbean.getContractNo());
					System.out.println("\n------CONTRACT DETAILS OF CONTRACT NO("+singleContract.getContractNo()+")----------\n");
					System.out.println(singleContract);
					System.out.println("----------------------------------------");

				} catch (ExceptionWhileDisplaying e) {
					e.exceptionMessage();
				}
				break;
			case 4:
				System.out.println("Enter the Contractor number which you want to Delete:");
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
				int delete=Integer.parseInt(i1);
				try {
					if(contractService.removeContract(delete)) {
						System.out.println("\nCONTRACT DELETED SUCCESSFULLY ^^^^\n");
					}

				} catch (ExceptionWhileDeleting e) {
					e.exceptionMessage();
				}

				break;
			case 5:
				System.out.println("Enter contract Number to modify details");
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
				ContractDetails conn=null;
				try {
					conn = contractService.getSingleContract(id5);
				} catch (ExceptionWhileDisplaying e1) {
					e1.exceptionMessage();
				}
				if(conn!=null) {
					System.out.println("1 Modify Delivery Date: ");
					System.out.println("2 Modify Quantity: ");					
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
						System.out.println("--------Enter the revised Delivery Date:-----------\n");
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
						conn.setDeliveryDate(ddate2);
						try {
							contractService.modifyContract(conn);
							System.out.println("\nDELIVERY DATE MODIFIED SUCCESSFULLY !!\n");
						} catch (ExceptionWhileModifying e) {
							e.exceptionMessage();
						}
						
						break;
					case 2:
						System.out.println("--------Enter the revised Quantity:-----------\n");
						char l='n';
						String l1=null;
						while(l=='n') {
						    l1=sc.next();
							if(Validations.isNumber1(l1)) {
								l='x';
							}
							else {
								System.err.println("Enter the quantity in integer value !!");
							}
						}
						int ll1=Integer.parseInt(l1);
						conn.setQuantity(ll1);
						try {
							contractService.modifyContract(conn);
							System.out.println("\nQUANTITY MODIFIED SUCCESSFULLY !!\n");
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
			case 7:
                      ClientPage.clientAuthentication();
				break;
			default:
				System.err.println("\nPLEASE SELECT A VALID OPTION !!\n");
				break;
			}




		}//end of while loop 

	}//end of method




}//end of class
