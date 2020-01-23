package com.capgemini.forestmanagementsystemusingcollection.controller;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.ContractDetails;
import com.capgemini.forestmanagementsystemusingcollection.dto.CustomerDetail;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileModifying;
import com.capgemini.forestmanagementsystemusingcollection.factory.FactoryClass;
import com.capgemini.forestmanagementsystemusingcollection.service.CustomerService;
import com.capgemini.forestmanagementsystemusingcollection.service.CustomerServiceImpl;
import com.capgemini.forestmanagementsystemusingcollection.validations.Validations;



public class AdminCustomerOperation {
	static CustomerService customerService=new CustomerServiceImpl();
	
	public static void adminCustomerOperation() {
		
		while(true) {
			Scanner scanner=new Scanner(System.in);
			CustomerDetail customerDetail=FactoryClass.getCustomerDetailsObject();
			System.out.println("Here are the choices: ");
			System.out.println("Press 1 to add a new Customer");
			System.out.println("Press 2 to view all the Customer Details");
			System.out.println("Press 3 to view a particular Customer ");	
			System.out.println("Press 4 to delete a customer");
			System.out.println("Press 5 to mofify a customer");
			System.out.println("Press 6 to go Admin  Page");
			System.out.println("\nEnter your Chice: --> "); 
			char choiceOption='n';
			String choice=null;
			while(choiceOption=='n') {
				choice=scanner.next();

				if(Validations.isNumber1(choice)) {
					choiceOption='x';
				}
				else {
					System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
				}
			}
			int choiceForSwitch=Integer.parseInt(choice);
			switch (choiceForSwitch) {
			case 1:
				//add customer
				System.out.println("--------ENTER THE CUSTOMER DETAILS:-----------\n");
				//1. Customer Id
				System.out.println("ENTER THE CUSTOMER ID: ");
				char customerIdChoice='n';
				String customerIdInput=null;
				while(customerIdChoice=='n') {
					customerIdInput=scanner.next();
					if(Validations.isNumber1(customerIdInput)) {
						customerIdChoice='x';
					}
					else {
						System.err.println("Enter the customer id in integer value !!");
					}
				}
				int customerInputAfterConverting=Integer.parseInt(customerIdInput);
				customerDetail.setCustomerId(customerInputAfterConverting);
				//2.CustomerName
				System.out.println("ENTER THE CUSTOMER  NAME: ");
				String customerNameInput=null;
				char customerNameChoice='y';
				while(customerNameChoice=='y') {
					customerNameInput=scanner.next();
					if(Validations.isStringOnlyAlphabet(customerNameInput)) {
						customerNameChoice='n';
					}
					else {
						System.err.println("Customer Name can be of alphabets only !!");
					}
				}
				customerDetail.setCustomerName(customerNameInput);
				//3.StreetAddress1
				System.out.println("ENTER THE CUSTOMER STREET ADDRESS 1: ");
				String streetAddress1Input=null;
				char streetAddress1Choice='y';
				while(streetAddress1Choice=='y') {
					streetAddress1Input=scanner.next();
					if(Validations.isStringOnlyAlphabet(streetAddress1Input)) {
						streetAddress1Choice='n';
					}
					else {
						System.err.println("Customer Street Address 1 can be of alphabets only !!");
					}
				}
				customerDetail.setStreetAddress1(streetAddress1Input);
				//4.StreetAddress2
				System.out.println("ENTER THE CUSTOMER STREET ADDRESS 2: ");
				String streetAddress2Input=null;
				char streetAddress2Choice='y';
				while(streetAddress2Choice=='y') {
					streetAddress2Input=scanner.next();
					if(Validations.isStringOnlyAlphabet(streetAddress2Input)) {
						streetAddress2Choice='n';
					}
					else {
						System.err.println("Customer Street Address2 can be of alphabets only !!");
					}
				}
				customerDetail.setStreetAddress2(streetAddress2Input);
				//5.Town
				System.out.println("ENTER THE CUSTOMER TOWN: ");
				String customerTownInput=null;
				char customerTownChoice='y';
				while(customerTownChoice=='y') {
					customerTownInput=scanner.next();
					if(Validations.isStringOnlyAlphabet(customerTownInput)) {
						customerTownChoice='n';
					}
					else {
						System.err.println("Customer town can be of alphabets only !!");
					}
				}
				customerDetail.setTown(customerTownInput);
				//6. Postal Code
				System.out.println("ENTER THE CUSTOMER POSTAL CODE: ");
				char customerPostalCodeChoice='n';
				String customerPostalCodeInput=null;
				while(customerPostalCodeChoice=='n') {
					customerPostalCodeInput=scanner.next();
					if(Validations.isNumber1(customerPostalCodeInput) && Validations.isVaidPostalCode(customerPostalCodeInput)) {
						customerPostalCodeChoice='x';
					}
					else {
						System.err.println("Postal Code length should be of 6 digits and it can only contain natural numbers !!");
					}
				}
				int customerPostalCodeAfterConverting=Integer.parseInt(customerPostalCodeInput);
				customerDetail.setPostalCode(customerPostalCodeAfterConverting);
				//7.E mail
				System.out.println("ENTER THE CUSTOMER E-MAIL: ");
				String customerEmailInput=null;
				char customerEmailChoice='y';
				while(customerEmailChoice=='y') {
					customerEmailInput=scanner.next();
					if(Validations.isValid(customerEmailInput)) {
						customerEmailChoice='n';
					}
					else {
						System.err.println("user name must be of lower case only  !!");
						System.err.println(" must contain an @ symbol followed by mail address !!");
					}
				}
				customerDetail.setEmail(customerEmailInput);
				//8. Phone number
				System.out.println("ENTER THE CUSTOMER PHONE NUMBER: ");
				char customerPhoneNumberChoice='n';
				String customerPhoneNumberInput=null;
				while(customerPhoneNumberChoice=='n') {
					customerPhoneNumberInput=scanner.next();
					if(Validations.isNumber1(customerPhoneNumberInput) && Validations.isVaidPhoneNumber(customerPhoneNumberInput)) {
						customerPhoneNumberChoice='x';
					}
					else {
						System.err.println("Phone Number Should be of 10 digits, and can only be of natural numbers !!");
					}
				}
				long customerPhoneNumberAfterConverting=Long.parseLong(customerPhoneNumberInput);
				customerDetail.setTelephoneNo(customerPhoneNumberAfterConverting);                

				try {
					if(customerService.addCustomer(customerDetail)) {
						System.out.println("\nCUSTOMER ADDDED SUCCESSFULLY ^^^^\n");	
					}
				} catch (ExceptionWhileInserting e) {
					e.exceptionMessage();
				}

				break;
			case 2:
				try {
					TreeMap<Integer, CustomerDetail> allCustomerResult=customerService.viewCustomers();
					Set<Map.Entry<Integer, CustomerDetail>> result= allCustomerResult.entrySet();
					System.out.println("\n------CUSTOMER DETAILS ARE----------\n");
					for (Map.Entry<Integer, CustomerDetail> entry : result) {
						System.out.println(entry.getValue());
						System.out.println("----------------------------------------");
					}

				} catch (ExceptionWhileDisplaying e) {
					e.exceptionMessage();
				}

				break;
			case 3:
				System.out.println("Enter the  Customer Id Which yo want to see detail Of: ");
				char customerIdToSeeDetailOfChoice='n';
				String customerIdToSeeDetailOfInput=null;
				while(customerIdToSeeDetailOfChoice=='n') {
					customerIdToSeeDetailOfInput=scanner.next();
					if(Validations.isNumber1(customerIdToSeeDetailOfInput)) {
						customerIdToSeeDetailOfChoice='x';
					}
					else {
						System.err.println("Enter the customer id in integer value !!");
					}
				}
				try {
					CustomerDetail singleCustomer=customerService.getSingleCustomer(Integer.parseInt(customerIdToSeeDetailOfInput));
					//					singleContract=contractService.getSingleContract(cdbean.getContractNo());
					System.out.println("\n------CUSTOMER DETAILS OF CUSTOMER ID("+singleCustomer.getCustomerId()+")----------\n");
					System.out.println(singleCustomer);
					System.out.println("----------------------------------------");

				} catch (ExceptionWhileDisplaying e) {
					e.exceptionMessage();
				}
				break;
			case 4:
				System.out.println("Enter customerid to remove customer details ");
				String customerIdToRemove=null;
				char customerIdToRemoveChoice = 'y';
				while(customerIdToRemoveChoice=='y') {
					customerIdToRemove= scanner.next();
					if(Validations.isNumber1(customerIdToRemove)) {
						customerIdToRemoveChoice='n';
					} else {
						System.err.println("Please enter only numbers!");
					}
				}
				Integer customerIdAfterConverting= Integer.parseInt(customerIdToRemove);
				try {
					if(customerService.removeCustomer(customerIdAfterConverting)) {
						System.out.println("\nCUSTOMER DELETED SUCCESSFULLY ^^^^\n");
					}

				} catch (ExceptionWhileDeleting e) {
					e.exceptionMessage();
				}

				break;
			case 5:
				System.out.println("enter customerid to modify details");
				String customerIdToModifyInput=null;
				char customerIdToModifyChoice = 'y';
				while(customerIdToModifyChoice=='y') {
					customerIdToModifyInput= scanner.next();
					if(Validations.isNumber1(customerIdToModifyInput)) {
						customerIdToModifyChoice='n';
					} else {
						System.err.println("Please enter only numbers!");
					}
				}
				Integer customerIdModifyAfterConverting= Integer.parseInt(customerIdToModifyInput);
				CustomerDetail customerDetailsModify=null;
				try {
					customerDetailsModify = customerService.getSingleCustomer(customerIdModifyAfterConverting);
				} catch (ExceptionWhileDisplaying e1) {
					e1.exceptionMessage();
				}
				if(customerDetailsModify!=null) {
					System.out.println("1 FOR MODIFING CUSTOMER STREET ADDRESS 1: ");
					System.out.println("2 FOR MODIFING CUSTOMER STREET ADDRESS 2: ");
					System.out.println("3 FOR MODIFING CUSTOMER TOWN: ");
					System.out.println("4 FOR MODIFING  CUSTOMER POSTAL CODE: ");
					System.out.println("5 FOR MODIFING CUSTOMER E-MAIL: ");
					System.out.println("6 FOR MODIFING  CUSTOMER PHONE NUMBER: ");
					char modifyChoices='n';
					String modifyInput=null;
					while(modifyChoices=='n') {
						modifyInput=scanner.next();

						if(Validations.isNumber1(modifyInput)) {
							modifyChoices='x';
						}
						else {
							System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
						}
					}
					int mod=Integer.parseInt(modifyInput);
					switch (mod) {
					case 1:
						System.out.println("\n--------ENTER THE REVISED CUSTOMER STREET ADDRESS 1:-----------\n");
						String modifyStreetAddress1Input=null;
						char modifyStreetAddress1Choice='y';
						while(modifyStreetAddress1Choice=='y') {
							modifyStreetAddress1Input=scanner.next();
							if(Validations.isStringOnlyAlphabet(modifyStreetAddress1Input)) {
								modifyStreetAddress1Choice='n';
							}
							else {
								System.err.println("Customer Street Address 1 can be of alphabets only !!");
							}
						}
						customerDetailsModify.setStreetAddress1(modifyStreetAddress1Input);
						try {
							customerService.modifyCustomer(customerIdModifyAfterConverting, customerDetailsModify);
							System.out.println("\nSTREET ADDRESS 1 MODIFIED SUCCESSFULLY !!\n");
						} catch (ExceptionWhileModifying e) {
							e.exceptionMessage();
						}
						
						break;
					case 2:
						System.out.println("\n--------ENTER THE REVISED CUSTOMER STREET ADDRESS 2:-----------\n");
						String modifyStreetAddress2Input=null;
						char modifyStreetAddress2Choice='y';
						while(modifyStreetAddress2Choice=='y') {
							modifyStreetAddress2Input=scanner.next();
							if(Validations.isStringOnlyAlphabet(modifyStreetAddress2Input)) {
								modifyStreetAddress2Choice='n';
							}
							else {
								System.err.println("Customer Street Address 2 can be of alphabets only !!");
							}
						}
						customerDetailsModify.setStreetAddress2(modifyStreetAddress2Input);
						try {
							customerService.modifyCustomer(customerIdModifyAfterConverting, customerDetailsModify);
							System.out.println("\nSTREET ADDRESS 2 MODIFIED SUCCESSFULLY !!\n");
						} catch (ExceptionWhileModifying e) {
							e.exceptionMessage();
						}

						break;
					case 3:
						System.out.println("\n--------ENTER THE REVISED CUSTOMER TOWN:-----------\n");
						String modifyCustomerTownInput=null;
						char modifyCustomerTownChoice='y';
						while(modifyCustomerTownChoice=='y') {
							modifyCustomerTownInput=scanner.next();
							if(Validations.isStringOnlyAlphabet(modifyCustomerTownInput)) {
								modifyCustomerTownChoice='n';
							}
							else {
								System.err.println("Customer town can be of alphabets only !!");
							}
						}
						customerDetailsModify.setTown(modifyCustomerTownInput);
						try {
							customerService.modifyCustomer(customerIdModifyAfterConverting, customerDetailsModify);
							System.out.println("\nTOWN MODIFIED SUCCESSFULLY !!\n");
						} catch (ExceptionWhileModifying e) {
							e.exceptionMessage();
						}
						
						break;
					case 4:
						System.out.println("\n--------ENTER THE REVISED CUSTOMER POSTAL CODE:-----------\n");
						char modifyPostalCodeChoice='n';
						String modifyPostalCodeInput=null;
						while(modifyPostalCodeChoice=='n') {
						    modifyPostalCodeInput=scanner.next();
							if(Validations.isNumber1(modifyPostalCodeInput) && Validations.isVaidPostalCode(modifyPostalCodeInput)) {
								modifyPostalCodeChoice='x';
							}
							else {
								System.err.println("Postal Code length should be of 6 digits and it can only contain natural numbers !!");
							}
						}
						customerDetailsModify.setPostalCode(Integer.parseInt(modifyPostalCodeInput));
						try {
							customerService.modifyCustomer(customerIdModifyAfterConverting, customerDetailsModify);
							System.out.println("\nPOSTAL CODE MODIFIED SUCCESSFULLY !!\n");
						} catch (ExceptionWhileModifying e) {
							e.exceptionMessage();
						}
						
						break;
					case 5:
						System.out.println("\n--------ENTER THE REVISED CUSTOMER E-MAIL:-----------\n");
						String modifyCustomerEmailInput=null;
						char modifyCustomerEmailChoice='y';
						while(modifyCustomerEmailChoice=='y') {
							modifyCustomerEmailInput=scanner.next();
							if(Validations.isValid(modifyCustomerEmailInput)) {
								modifyCustomerEmailChoice='n';
							}
							else {
								System.err.println("user name must be of lower case only  !!");
								System.err.println(" must contain an @ symbol followed by mail address !!");
							}
						}      
						customerDetailsModify.setEmail(modifyCustomerEmailInput);
						try {
							customerService.modifyCustomer(customerIdModifyAfterConverting, customerDetailsModify);
							System.out.println("\nE-MAIL MODIFIED SUCCESSFULLY !!\n");
						} catch (ExceptionWhileModifying e) {
							e.exceptionMessage();
						}
						
						break;
					case 6:
						System.out.println("\n--------ENTER THE REVISED CUSTOMER PHONE NUMBER:-----------\n");
						char cn='n';
						String mphone=null;
						while(cn=='n') {
							mphone=scanner.next();
							if(Validations.isNumber1(mphone) && Validations.isVaidPhoneNumber(mphone)) {
								cn='x';
							}
							else {
								System.err.println("Phone Number Should be of 10 digits, and can only be of natural numbers !!");
							}
						}
						customerDetailsModify.setTelephoneNo(Long.parseLong(mphone));
						try {
							customerService.modifyCustomer(customerIdModifyAfterConverting, customerDetailsModify);
							System.out.println("\nPHONE NUMBER MODIFIED SUCCESSFULLY !!\n");
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

			default:
				System.err.println("\nPLEASE SELECT A VALID OPTION !!\n");
				break;
			}





		}//end of while loop
	}//end of method

}//end of class
