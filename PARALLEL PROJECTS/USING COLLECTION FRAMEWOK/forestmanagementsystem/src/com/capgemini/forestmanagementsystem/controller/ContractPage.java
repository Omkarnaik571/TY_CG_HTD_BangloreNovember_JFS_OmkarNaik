package com.capgemini.forestmanagementsystem.controller;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.forestmanagementsystem.dao.ForestDao;
import com.capgemini.forestmanagementsystem.dto.ContractDetails;
import com.capgemini.forestmanagementsystem.exceptions.DisplayingDataWithoutEntry;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.validations.Validations;

public class ContractPage {

	static Map<Integer, ContractDetails> result=null;

	public static void adminContractOperation() {

		ForestDao fd=FactoryClass.getForestDAOImplObject();

		ContractDetails cdbean=FactoryClass.getContractDetailsObject();
//		try(Scanner sc=new Scanner(System.in);){
			while(true) {
				Scanner sc=new Scanner(System.in);
				System.out.println("Here are the choices: ");
				System.out.println("Press 1 to add a new Contract Details");
				System.out.println("Press 2 to view all the Contract Details through Contract No");
				System.out.println("Press 3 to view a particular Contract Detail through Contract No");
				System.out.println("Press 4 to viws how many  contractors are there");	
				System.out.println("Press 5 to delete a Contractor");
				System.out.println("Press 6 to Modify a Contractor Detail");
				System.out.println("Press 7 to go Admin Page");
				System.out.println("Press 8 to go Client Page");
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
					cdbean.setContractno(bb1);
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
					cdbean.setCustomerid(cc1);
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
					cdbean.setProductid(dd1);
					//4. Haulier Id:
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
					int ff1=Integer.parseInt(f1);
					cdbean.setHaulierid(ff1);
					//							System.out.println();
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
					cdbean.setDeliverydate(ddate);
					//6. Delivery day
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
					cdbean.setDeliveryday(day);
					//7.
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

					//Calling the ForestDAO impl
					result=fd.addTheContractDetails(cdbean);	
					System.out.println("\nCONTRACTOR ADDDED SUCCESSFULLY ^^^^\n");

					break;
				case 2:
					try {
						Set<Map.Entry<Integer, ContractDetails>>  s1=result.entrySet();                                
						System.out.println("\n----------THE CONTRACT DETAILS ARE:------------");
						System.out.println("*************************************************");
						for (Map.Entry<Integer, ContractDetails> entry : s1) {
							System.out.println("Details of Contractor number ("+entry.getKey()+")  ARE: ");
							System.out.print(entry.getValue()+"\n");
						}
						System.out.println("*************************************************");		
						System.out.println("------------------------------------------------");
					}
					catch (NullPointerException n) {
						DisplayingDataWithoutEntry e= new DisplayingDataWithoutEntry();
						e.dataWithoutEntryForContract();
					}
					break;

				case 3:
					System.out.println("Enter the Contract Number Which yo want to see detail Of: ");
					String k1=null;
					try {
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
                     int detail=Integer.parseInt(k1);
					
                     boolean  yes=result.containsKey(detail);
 					if(yes) {
 						System.out.println("\n----------THE CONTRACT DETAILS ARE:------------");
 						System.out.println("*************************************************");
 						System.out.println("Details of Contractor number "+detail+" is:");      
 						Set<Map.Entry<Integer, ContractDetails>> s2=   result.entrySet();
 						System.out.println(result.get(detail));	
 						System.out.println("*************************************************");		
 						System.out.println("------------------------------------------------");
 					}
 					else {
 						System.err.println("\nThe Contractor Number that you have entered is not in the data base !!\n");
 					}	
					}
					catch (Exception e) {
					      DisplayingDataWithoutEntry dde=new DisplayingDataWithoutEntry();
					      dde.dataWithoutEntryForContract();
					}
					
					
					break;
				case 4:
					try {
						int size=result.size();
						System.out.println("\nNumber of Contractors in the Database = "+size+"\n");
					}
					catch (NullPointerException n) {
						DisplayingDataWithoutEntry e= new DisplayingDataWithoutEntry();
						e.dataWithoutEntryForContract();
					}
					break; 

				case 5:
					try {
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
					if(result.containsKey(delete)) {
					result.remove(delete);
					System.out.println("\nCONTRACTOR DELETED SUCCESSFULLY ^^^^\n");
					}
					else {
						System.err.println("\nThe contractor number that you have entered is not present\n");
					}
					}//end of try
					catch (NullPointerException n) {
						DisplayingDataWithoutEntry e= new DisplayingDataWithoutEntry();
						e.dataWithoutEntryForContract();
					}
					break;
				case 6:
					System.out.println("Enter the Contract Number Which yo want to Modify: ");
					int modify=sc.nextInt();
					if(result.containsKey(modify)) {
						ContractDetails cd=result.get(modify);
						System.out.println("1 Modify Delivery Date: ");
						System.out.println("2 Modify Delivery Day: ");
						System.out.println("3 Modify Quantity: ");
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
							cd.setDeliverydate(sc.next());
							result.replace(modify, cd);
							System.out.println("\nDELIVERY DATE MODIFIED SUCCESSFULLY !!\n");
							break;
						case 2:
							System.out.println("--------Enter the revised Delivery Day:-----------\n");
							String day1=null;
							char k='y';
							while(k=='y') {
								day1=sc.next();
								if(Validations.isValidDay(day1)) {
									k='n';
								}
								else {
									System.err.println("Please enter a day according to the calender (i.e Sunday, Monday) !!");
								}
							}
							cd.setDeliveryday(day1);
							result.replace(modify, cd);
							System.out.println("\nDELIVERY DAY MODIFIED SUCCESSFULLY !!\n");
							break;
						case 3:
							System.out.println("--------Enter the revised Quantity:-----------\n");
							char l='n';
							String l1=null;
							while(l=='n') {
							    l1=sc.next();
								if(Validations.isNumber1(l1)) {
									l='x';
								}
								else {
									System.err.println("Enter the product id in integer value !!");
								}
							}
							int ll1=Integer.parseInt(l1);
							cd.setQuantity(ll1);
							result.replace(modify, cd);
							System.out.println("\nQUANTITY MODIFIED SUCCESSFULLY !!\n");
							break;
						default:
							System.err.println("\nPLEASE SELECT A VALID OPTION !!\n");
							break;
						}
					}
					else {
						System.err.println("\nTHE CONTRACTOR NUMBER THAT YOU HAVE ENTERED IS NOT IN THE DATABASE !!!!!!!\n");
					} 
					break;
				case 7:
					AdminPage.adminPage();
					break;
				case 8:
					ClientPage.clientPage();
					break;

				default:
					System.err.println("\nPLEASE SELECT A VALID OPTION\n");
					break;
				}


			}
			//While End
		}
		//Try end

//		catch (Exception e) {
//			// TODO: handle exception
//		}






	}

