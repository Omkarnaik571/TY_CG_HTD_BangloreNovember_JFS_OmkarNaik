package com.capgemini.forestmanagementsystemusingcollection.controller;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.ContractDetails;
import com.capgemini.forestmanagementsystemusingcollection.dto.LandDetails;
import com.capgemini.forestmanagementsystemusingcollection.dto.ProductDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileModifying;
import com.capgemini.forestmanagementsystemusingcollection.factory.FactoryClass;
import com.capgemini.forestmanagementsystemusingcollection.service.LandService;
import com.capgemini.forestmanagementsystemusingcollection.service.LandServiceImpl;
import com.capgemini.forestmanagementsystemusingcollection.service.ProductService;
import com.capgemini.forestmanagementsystemusingcollection.service.ProductServiceImpl;
import com.capgemini.forestmanagementsystemusingcollection.validations.Validations;

public class AdminLandOperations {

	static LandService lService = new LandServiceImpl();

	public static void adminLandOperation() {
		while (true) {
			Scanner sc = new Scanner(System.in);
			LandDetails ld = FactoryClass.getLandDetailsObject();
			System.out.println("HERE ARE THE CHOICES: ");
			System.out.println("PRESS 1 TO ADD A NEW LAND DETAIL");
			System.out.println("PRESS 2 TO VIEW LAND  DETAILS");
			System.out.println("PRESS 3 TO DELETE A LAND DETAIL");
			System.out.println("PRESS 4 TO MODIFY A LAND DETAIL");
			System.out.println("PRESS 5 TO GO TO ADMIN PAGE");
			System.out.println("\nENTER YOUR CHOICE: --> ");
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
			int ch = Integer.parseInt(choice);
			switch (ch) {
			case 1:
				System.out.println("\nENTER THE PLOT NUMBER : ");
				char c = 'n';
				String c1 = null;
				while (c == 'n') {
					c1 = sc.next();
					if (Validations.isNumber1(c1)) {
						c = 'x';
					} else {
						System.err.println("Enter the Plot number in natural numbers only !!");
					}
				}
				int cc1 = Integer.parseInt(c1);
				ld.setPlotNumber(cc1);
				System.out.println("\nENTER THE OWNER NAME : ");
				String cname = null;
				char g = 'y';
				while (g == 'y') {
					sc.nextLine();
					cname = sc.nextLine();
					if (Validations.isStringOnlyAlphabet(cname)) {
						g = 'n';
					} else {
						System.err.println("Land owner name can be of alphabets only !!");
					}
				}
				ld.setOwner(cname);
				System.out.println("\nENTER THE ACQUIRED DATE : ");
				ld.setAcquiredDate(sc.next());
				System.out.println("\nENTER THE LAND PRICE: ");
				char d = 'n';
				String d1 = null;
				while (d == 'n') {
					d1 = sc.next();
					if (Validations.isNumber1(d1)) {
						d = 'x';
					} else {
						System.err.println("Enter the Land price in integer value !!");
					}
				}
				double dd1 = Double.parseDouble(d1);
				ld.setPrice(dd1);

				try {
					lService.addLandDetail(ld);
					System.out.println("\nLAND DETAIL ADDED SUCCESSFULLY !!\n");
				} catch (ExceptionWhileInserting e) {
					e.exceptionMessage();
				}
				break;
			case 2:
				try {
					TreeMap<Integer, LandDetails> allProductResult = lService.displayAllLandDetails();
					Set<Map.Entry<Integer, LandDetails>> result = allProductResult.entrySet();
					System.out.println("\n------LAND DETAILS ARE----------\n");
					for (Map.Entry<Integer, LandDetails> entry : result) {
						System.out.println(entry.getValue());
						System.out.println("----------------------------------------");
					}

				} catch (ExceptionWhileDisplaying e) {
					e.exceptionMessage();
				}

				break;
			case 3:
				System.out.println("Enter the Plot Number which you want to Delete:");
				char hh = 'n';
				String hh1 = null;
				while (hh == 'n') {
					hh1 = sc.next();
					if (Validations.isNumber1(hh1)) {
						hh = 'x';
					} else {
						System.err.println("Enter the land Id in integer value !!");
					}
				}
				try {
					if (lService.removeLandDetail(Integer.parseInt(hh1))) {
						System.out.println("\nLAND DETAIL DELETED SUCCESSFULLY ^^^^\n");
					}

				} catch (ExceptionWhileDeleting e) {
					e.exceptionMessage();
				}

				break;
			case 4:
				System.out.println("Enter Plot Number to modify details");
				String ch6 = null;
				char c6 = 'y';
				while (c6 == 'y') {
					ch6 = sc.next();
					if (Validations.isNumber1(ch6)) {
						c6 = 'n';
					} else {
						System.err.println("Please enter only numbers!");
					}
				}
				Integer id5 = Integer.parseInt(ch6);
				LandDetails conn = null;
				try {
					conn = lService.getSingleLandDetail(id5);
				} catch (ExceptionWhileDisplaying e1) {
					e1.exceptionMessage();
				}
				if (conn != null) {
					System.out.println("1 Modify OWNER NAME: ");
					System.out.println("2 Modify  ACQUIRED DATE");
					System.out.println("3 Modify  LAND PRICE");
					char t = 'n';
					String choice1 = null;
					while (t == 'n') {
						choice1 = sc.next();

						if (Validations.isNumber1(choice1)) {
							t = 'x';
						} else {
							System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
						}
					}
					int mod = Integer.parseInt(choice1);
					switch (mod) {
					case 1:
						System.out.println("--------Enter the revised Owner name:-----------\n");
						String mcname=null;
						char j='y';
						while(j=='y') {
							mcname=sc.next();
							if(Validations.isStringOnlyAlphabet(mcname)) {
								j='n';
							}
							else {
								System.err.println("Land owner name can be of alphabets only !!");
							}
						}
						conn.setOwner(mcname);
						try {
							lService.modifyLandDetail(conn);
							System.out.println("\nOWNER NAME MODIFIED SUCCESSFULLY !!\n");
						} catch (ExceptionWhileModifying e) {
							e.exceptionMessage();
						}
						
						break;
					case 2:
						System.out.println("--------Enter the revised acquireddate:-----------\n");
						conn.setAcquiredDate(sc.next());
						try {
							lService.modifyLandDetail(conn);
							System.out.println("\nACQUIRED DATE MODIFIED SUCCESSFULLY !!\n");
						} catch (ExceptionWhileModifying e) {
							e.exceptionMessage();
						}
						break;
					case 3:
						System.out.println("--------Enter the revised land price:-----------\n");						
						char k='n';
						String k1=null;
						while(k=='n') {
						    k1=sc.next();
							if(Validations.isNumber1(k1)) {
								k='x';
							}
							else {
								System.err.println("Enter the Land price in integer value !!");
							}
						}
						double dd2=Double.parseDouble(k1);
                         conn.setPrice(dd2);
                         try {
 							lService.modifyLandDetail(conn);
 							System.out.println("\nLAND PRICE MODIFIED SUCCESSFULLY !!\n");
 						} catch (ExceptionWhileModifying e) {
 							e.exceptionMessage();
 						}
						break;

					default:
						System.err.println("\nPLEASE SELECT A VALID OPTION !!\n");
						break;
					}// end of switch

				} // end of if

				break;
			case 5:
				AdminPage.adminPage();
				break;
			default:
				System.err.println("\nPLEASE SELECT A VALID OPTION !!\n");
				break;
			}

		} // while loop end..

	}// end of method..

}// end of class..
