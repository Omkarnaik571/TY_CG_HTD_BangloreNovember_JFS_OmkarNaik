package com.capgemini.forestmanagementsystem.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.dao.ContractorDetailsDao;
import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.dto.CustomerDetailsDto;
import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.service.ContractService;
import com.capgemini.forestmanagementsystem.service.ContractServiceImpl;
import com.capgemini.forestmanagementsystem.service.CustomerService;
import com.capgemini.forestmanagementsystem.service.CustomerServiceImpl;
import com.capgemini.forestmanagementsystem.service.ProductService;
import com.capgemini.forestmanagementsystem.service.ProductserviceImpl;
import com.capgemini.forestmanagementsystem.validations.Validations;

public class ClientContractOperation {

static Scanner sc=new Scanner(System.in);
	
	public static void contractorOperations()  {
		ContractorDetailsDto cdd=FactoryClass.getContractorDetailsDto();
		ContractService cd=new ContractServiceImpl();
		while (true) {
			System.out.println("--------------------CONTRACT OPERATIONS------------------");
			System.out.println("1 ADD A CONTRACTOR");
			System.out.println("2 DELETE A CONTRACTOR");
			System.out.println("3 VIEW  CONTRACTOR");
			System.out.println("4 VIEW  ALL CONTRACTOR");
			System.out.println("5 MODIFY CONTRACTOR DETAILS");
			System.out.println("6 GO BACK TO ADMIN PAGE");
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

				ProductService productService = new ProductserviceImpl();
				CustomerService customerService = new CustomerServiceImpl();
				System.out.println("ENTER THE CONTRACT NO: ");
				char b = 'n';
				String b1 = null;
				while (b == 'n') {
					b1 = sc.next();
					if (Validations.isNumber1(b1)) {
						b = 'x';
					} else {
						System.err.println("Enter the contract number in integer value !!");
					}
				}
				cdd.setContractNo(Integer.parseInt(b1));
				int check = 1;
				while (check == 1) {
					System.out.println("Enter the Customer Id: ");
					char c = 'n';
					String c1 = null;
					while (c == 'n') {
						c1 = sc.next();
						if (Validations.isNumber1(c1)) {
							c = 'x';
						} else {
							System.err.println("Enter the customer id in integer value !!");
						}
					}
					cdd.setCustomerId(Integer.parseInt(c1));
					CustomerDetailsDto customerDetailsDto = FactoryClass.getCustomerDetailsDto();
					customerDetailsDto.setCustomerId(cdd.getCustomerId());
					try {
						customerDetailsDto = customerService.viewSingleCustomerDetails(customerDetailsDto);
						if (customerDetailsDto != null) {
							check = 2;
						} else {
							System.err.println("\nTHE CUSTOMER ID THAT YOU HAVE ENTERED DOES`NT EXISTS\n");
							System.out.println("SELECT YOUR CHOICE WHAT YOU WANT TO DO NOW :-->");
							System.out.println("1. TRY ENTER ANOTHER CUSTOMER ID");
							System.out.println("2. GO BACK TO ADMIN PAGE");
							char choiceForWrongCustomer = 'n';
							String inputForWrongCustomer = null;
							while (choiceForWrongCustomer == 'n') {
								inputForWrongCustomer = sc.next();
								if (Validations.isNumber1(inputForWrongCustomer)) {
									choiceForWrongCustomer = 'x';
								} else {
									System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
								}
							}
							int option = Integer.parseInt(inputForWrongCustomer);
							switch (option) {
							case 1:
                                   
								break;
							case 2:
                                    AdminPage.adminMain();
								break;

							default:
								System.out.println("\nPLEASE SELECT A VALID OPTION !!\n");
								break;
							}

						}
					} catch (CustomExceptions e2) {
						e2.exceptionMessage();
					}

				} // end while
				int checkForCorrectProductId= 1;
				while ( checkForCorrectProductId== 1) {
					System.out.println("Enter the Product Id: ");
					char d = 'n';
					String d1 = null;
					while (d == 'n') {
						d1 = sc.next();
						if (Validations.isNumber1(d1)) {
							d = 'x';
						} else {
							System.err.println("Enter the product id in integer value !!");
						}
					}
					cdd.setProductId(Integer.parseInt(d1));
					ProductDetailsDto productDetailsDto=FactoryClass.getProductDetailsDto();
					productDetailsDto.setProductId(cdd.getProductId());
					
					try {
						productDetailsDto=productService.viewParticularProduct(productDetailsDto);
					    if(productDetailsDto!=null) {
					    	checkForCorrectProductId=2;
					    }
					    else {
					    	System.err.println("\nTHE PRODUCT ID THAT YOU HAVE ENTERED DOES`NT EXISTS\n");
							System.out.println("SELECT YOUR CHOICE WHAT YOU WANT TO DO NOW :-->");
							System.out.println("1. TRY ENTER ANOTHER PRODUCT ID");
							System.out.println("2. GO BACK TO ADMIN PAGE");
							char choiceForWrongProduct = 'n';
							String inputForWrongProduct = null;
							while (choiceForWrongProduct == 'n') {
								inputForWrongProduct = sc.next();
								if (Validations.isNumber1(inputForWrongProduct)) {
									choiceForWrongProduct = 'x';
								} else {
									System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
								}
							}
							int option = Integer.parseInt(inputForWrongProduct);
							switch (option) {
							case 1:
                                   
								break;
							case 2:
                                    AdminPage.adminMain();
								break;

							default:
								System.out.println("\nPLEASE SELECT A VALID OPTION !!\n");
								break;
							}
					    	
					    }
					
					} catch (CustomExceptions e) {
						e.exceptionMessage();
					}
					
					
				}//end of while--valid product id
	
				
				System.out.println("Enter the Delivery Date: ");
				String ddate = null;
				char z = 'y';
				while (z == 'y') {
					ddate = sc.next();
					if (Validations.isValidDate(ddate)) {
						System.err.println(
								"\nEnter delivery date in (dd/mm/yyyy) format and It should be in future date only");
					} else {
						z = 'n';
					}
				}
				cdd.setDeliveryDate(ddate);
				System.out.println("Enter the Quantity:(Enter In Terms Of Kg) !! ");
				cdd.setQuantity(sc.next());

				try {
					if (cd.addContractor(cdd)) {
						System.out.println("\nCONTRACTOR ADDED SUCCESSFULLY !!\n");
					} else {
						System.err.println("\nCONTRACT NUMBER THAT YOU HAVE ENTERED ALREADY PRESENT !!\n");
					}
				} catch (CustomExceptions e1) {
					e1.exceptionMessage();
				}

				break;
			case 2:
				System.out.println("ENTER THE CONTRACT NO: ");
				char i = 'n';
				String i1 = null;
				while (i == 'n') {
					i1 = sc.next();
					if (Validations.isNumber1(i1)) {
						i = 'x';
					} else {
						System.err.println("Enter the Contractor number in integer value !!");
					}
				}
				cdd.setContractNo(Integer.parseInt(i1));
				try {
					if (cd.deleteContractorDetails(cdd)) {
						System.out.println("\nCONTRACT DELETED SUCCESSFULLY !!\n");
					} else {
						System.err.println("\nCONTRACT NUMBER THAT YOU HAVE ENTERED DOES`NT EXISTS !!\n");
					}
				} catch (CustomExceptions e1) {
					e1.exceptionMessage();
				}
				break;
			case 3:
				System.out.println("ENTER THE CONTRACT NO: ");
				char x = 'n';
				String x1 = null;
				while (x == 'n') {
					x1 = sc.next();
					if (Validations.isNumber1(x1)) {
						x = 'x';
					} else {
						System.err.println("Enter the contract number in integer value !!");
					}
				}
				cdd.setContractNo(Integer.parseInt(x1));
				try {
					ContractorDetailsDto cdt = cd.viewSingleContractorDetails(cdd);
					if (cdt != null) {
						System.out.println(cdt);
					} else {
						System.err.println("\nTHE CONTRACT NUMBER THAT YOU HAVE ENTERED IS NOT PRESENT !!\n");
					}

				} catch (CustomExceptions e1) {
					e1.exceptionMessage();
				}

				break;
			case 4:
				try {
					List<ContractorDetailsDto> result = cd.viewContractorDetails();
					if (!result.isEmpty()) {
						System.out.println("\n<^^^^^^^^^^^CONTRACT DETAILS^^^^^^^^^^^^^^^>");
						for (ContractorDetailsDto cx : result) {
							System.out.println(cx);
							System.out.println("--------------------------------------------");
						}
					} // end of if
					else {
						System.err.println("\nThere are no contract details present in the database..\n");
					}

				} catch (CustomExceptions e) {
					e.exceptionMessage();
//					System.out.println("\ncaught in admin contract operation\n");
				}

				break;
			case 5:
				System.out.println("--------------------MODIFY CONTRACT DETAILS---------------------");
				System.out.println("1.  MODIFY DELIVERY DATE: ");
				System.out.println("2.  MODIFY QUANTITY: ");
				char a1 = 'n';
				String choice1 = null;
				while (a1 == 'n') {
					choice1 = sc.next();
					if (Validations.isNumber1(choice1)) {
						a1 = 'x';
					} else {
						System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
					}
				}
				int option = Integer.parseInt(choice1);
				boolean isModified = false;
				switch (option) {
				case 1:
					System.out.println("ENTER THE CONTRACT NO: ");
					char b11 = 'n';
					String bb1 = null;
					while (b11 == 'n') {
						bb1 = sc.next();
						if (Validations.isNumber1(bb1)) {
							b11 = 'x';
						} else {
							System.err.println("Enter the contract number in integer value !!");
						}
					}
					cdd.setContractNo(Integer.parseInt(bb1));
					sc.nextLine();
					System.out.println("ENTER THE REVISED DELIVERY DATE: ");
					String ddate2 = null;
					char z2 = 'y';
					while (z2 == 'y') {
						ddate2 = sc.next();
						if (Validations.isValidDate(ddate2)) {
							System.err.println(
									"\nEnter delivery date in (dd/mm/yyyy) format and It should be in future date only");
						} else {
							z2 = 'n';
						}
					}
					cdd.setDeliveryDate(ddate2);
					try {
						if (cd.modifyContractorDetails(cdd, option)) {
							System.out.println("\nDELIVERY DATE MODIFIED SUCCESSFULLY !!\n");
						} else {
							System.err.println("\nTHE CONTRACT NUMBER THAT YOU HAVE ENTERED DOES`NT EXISTS !!\n");
						}
					} catch (CustomExceptions e) {
						e.exceptionMessage();
					}
					break;
				case 2:
					System.out.println("ENTER THE CONTRACT NO: ");
					char d11 = 'n';
					String dd1 = null;
					while (d11 == 'n') {
						dd1 = sc.next();
						if (Validations.isNumber1(dd1)) {
							d11 = 'x';
						} else {
							System.err.println("Enter the contract number in integer value !!");
						}
					}
					cdd.setContractNo(Integer.parseInt(dd1));
					sc.nextLine();
					System.out.println("ENTER THE QUANTITY: (Enter In Terms Of Kg) !! ");
					cdd.setQuantity(sc.nextLine());
					try {
						if (cd.modifyContractorDetails(cdd, option)) {
							System.out.println("\nQUANTITY MODIFIED SUCCESSFULLY !!\n");
						} else {
							System.err.println("\nTHE CONTRACT NUMBER THAT YOU HAVE ENTERED DOES`NT EXISTS !!\n");
						}
					} catch (CustomExceptions e) {
						e.exceptionMessage();
					}
					break;

				default:
					System.err.println("\nPLEASE SELECT A VALID OPTION........\n");
					break;
				}

				break;
			case 6:
				AdminPage.adminMain();
				break;
			default:
				System.err.println("\nPLEASE SELECT A VALID OPTION........\n");
				break;
			}

		} // end of while loop
		
		
	}//end of contractor operations


	
}//end of class
