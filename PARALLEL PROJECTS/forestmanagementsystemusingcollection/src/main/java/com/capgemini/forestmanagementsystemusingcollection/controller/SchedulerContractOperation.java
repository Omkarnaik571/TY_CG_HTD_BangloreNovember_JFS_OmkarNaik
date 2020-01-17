package com.capgemini.forestmanagementsystemusingcollection.controller;

import java.util.Map;
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

public class SchedulerContractOperation extends AdminContractOperations {
//	static ContractService contractService=new ContractServiceImpl();

	public static void schedulerContractOperation() {
		while (true) {

			ContractDetails contractDetails = FactoryClass.getContractDetailsObject();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Here are the choices: ");
			System.out.println("Press 1 to add a new Contract Detail");
			System.out.println("Press 2 to view all the Contract Details");
			System.out.println("Press 3 to view a particular Contract Detail");
			System.out.println("Press 4 to delete a Contract");
			System.out.println("Press 4 to Modify a Contract Detail");
			System.out.println("Press 6 to go Admin Page");
			System.out.println("Press 7 to go Client Page");
			System.out.println("\nEnter your Chice: --> ");
			char a = 'n';
			String choice = null;
			while (a == 'n') {
				choice = scanner.next();

				if (Validations.isNumber1(choice)) {
					a = 'x';
				} else {
					System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
				}
			}
			int ch = Integer.parseInt(choice);
			switch (ch) {
			case 1:
				System.out.println("--------Enter the Contract Details:-----------\n");
				// 1. Contract Number
				System.out.println("Enter the Contract Number: ");
				char contractNumberChoice = 'n';
				String contractNumberInput = null;
				while (contractNumberChoice == 'n') {
					contractNumberInput = scanner.next();
					if (Validations.isNumber1(contractNumberInput)) {
						contractNumberChoice = 'x';
					} else {
						System.err.println("Enter the contract number in integer value !!");
					}
				}
				int contractNumberAfterConverting = Integer.parseInt(contractNumberInput);
				contractDetails.setContractNo(contractNumberAfterConverting);
				// 2. Customer Id
				System.out.println("Enter the Customer Id: ");
				char customerIdChoice = 'n';
				String customerIdInput = null;
				while (customerIdChoice == 'n') {
					customerIdInput = scanner.next();
					if (Validations.isNumber1(customerIdInput)) {
						customerIdChoice = 'x';
					} else {
						System.err.println("Enter the customer id in integer value !!");
					}
				}
				int customerIdAfterConverting = Integer.parseInt(customerIdInput);
				contractDetails.setCustomerId(customerIdAfterConverting);
				// 3.Product Id:
				System.out.println("Enter the Product Id: ");
				char productIdChoice = 'n';
				String productIdInput = null;
				while (productIdChoice == 'n') {
					productIdInput = scanner.next();
					if (Validations.isNumber1(productIdInput)) {
						productIdChoice = 'x';
					} else {
						System.err.println("Enter the product id in integer value !!");
					}
				}
				int dd1 = Integer.parseInt(productIdInput);
				contractDetails.setProductId(dd1);
				// 5. Delivery Date:
				System.out.println("Enter the Delivery Date: ");
				String deliveryDateInput = null;
				char deliveryDateChoice = 'y';
				while (deliveryDateChoice == 'y') {
					deliveryDateInput = scanner.next();
					if (Validations.isValidDate(deliveryDateInput)) {
						System.err.println(
								"\nEnter delivery date in (dd/mm/yyyy) format and It should be in future date only");
					} else {
						deliveryDateChoice = 'n';
					}
				}
				contractDetails.setDeliveryDate(deliveryDateInput);
				// Enter quantity
				System.out.println("Enter the Quantity: ");
				char quantityChoice = 'n';
				String quantityInput = null;
				while (quantityChoice == 'n') {
					quantityInput = scanner.next();
					if (Validations.isNumber1(quantityInput)) {
						quantityChoice = 'x';
					} else {
						System.err.println("Qunatity will be of number only (Enter In Terms Of Kg) !!");
					}
				}
				int quantityAfterConverting = Integer.parseInt(quantityInput);
				contractDetails.setQuantity(quantityAfterConverting);
				try {
					if (contractService.addContract(contractDetails)) {
						System.out.println("\nCONTRACT ADDDED SUCCESSFULLY ^^^^\n");
					}
				} catch (ExceptionWhileInserting e) {
					e.exceptionMessage();
				}

				break;
			case 2:
				try {
					TreeMap<Integer, ContractDetails> allContractResult = contractService.getAllContract();
					Set<Map.Entry<Integer, ContractDetails>> result = allContractResult.entrySet();
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
				String contractNumberToSeeDetail = null;
				char contractChoice = 'n';
				while (contractChoice == 'n') {
					contractNumberToSeeDetail = scanner.next();
					if (Validations.isNumber1(contractNumberToSeeDetail)) {
						contractChoice = 'x';
					} else {
						System.err.println("Enter the Contractor number in integer value !!");
					}
				}
//				cdbean.setContractNo(Integer.parseInt(k1));
				try {
					ContractDetails singleContract = contractService
							.getSingleContract(Integer.parseInt(contractNumberToSeeDetail));
//					singleContract=contractService.getSingleContract(cdbean.getContractNo());
					System.out.println("\n------CONTRACT DETAILS OF CONTRACT NO(" + singleContract.getContractNo()
							+ ")----------\n");
					System.out.println(singleContract);
					System.out.println("----------------------------------------");

				} catch (ExceptionWhileDisplaying e) {
					e.exceptionMessage();
				}
				break;
			case 4:
				System.out.println("Enter the Contractor number which you want to Delete:");
				char deleteContractChoice = 'n';
				String contractNumberToDelete = null;
				while (deleteContractChoice == 'n') {
					contractNumberToDelete = scanner.next();
					if (Validations.isNumber1(contractNumberToDelete)) {
						deleteContractChoice = 'x';
					} else {
						System.err.println("Enter the Contractor number in integer value !!");
					}
				}
				int delete = Integer.parseInt(contractNumberToDelete);
				try {
					if (contractService.removeContract(delete)) {
						System.out.println("\nCONTRACT DELETED SUCCESSFULLY ^^^^\n");
					}

				} catch (ExceptionWhileDeleting e) {
					e.exceptionMessage();
				}

				break;
			case 5:
				System.out.println("Enter contract Number to modify details");
				String contractNumberToModify1 = null;
				char modifyChoice = 'y';
				while (modifyChoice == 'y') {
					contractNumberToModify1 = scanner.next();
					if (Validations.isNumber1(contractNumberToModify1)) {
						modifyChoice = 'n';
					} else {
						System.err.println("Please enter only numbers!");
					}
				}
				Integer id5 = Integer.parseInt(contractNumberToModify1);
				ContractDetails conn = null;
				try {
					conn = contractService.getSingleContract(id5);
				} catch (ExceptionWhileDisplaying e1) {
					e1.exceptionMessage();
				}
				if (conn != null) {
					System.out.println("1 Modify Delivery Date: ");
					System.out.println("2 Modify Quantity: ");
					char t = 'n';
					String choice1 = null;
					while (t == 'n') {
						choice1 = scanner.next();

						if (Validations.isNumber1(choice1)) {
							t = 'x';
						} else {
							System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
						}
					}
					int mod = Integer.parseInt(choice1);
					switch (mod) {
					case 1:
						System.out.println("--------Enter the revised Delivery Date:-----------\n");
						String revisedDeliveryDate = null;
						char deliveryChoice = 'y';
						while (deliveryChoice == 'y') {
							revisedDeliveryDate = scanner.next();
							if (Validations.isValidDate(revisedDeliveryDate)) {
								System.err.println(
										"\nEnter delivery date in (dd/mm/yyyy) format and It should be in future date only");
							} else {
								deliveryChoice = 'n';
							}
						}
						conn.setDeliveryDate(revisedDeliveryDate);
						try {
							contractService.modifyContract(conn);
							System.out.println("\nDELIVERY DATE MODIFIED SUCCESSFULLY !!\n");
						} catch (ExceptionWhileModifying e) {
							e.exceptionMessage();
						}

						break;
					case 2:
						System.out.println("--------Enter the revised Quantity:-----------\n");
						char revisedQuantityChoice = 'n';
						String revisedQuantity = null;
						while (revisedQuantityChoice == 'n') {
							revisedQuantity = scanner.next();
							if (Validations.isNumber1(revisedQuantity)) {
								revisedQuantityChoice = 'x';
							} else {
								System.err.println("Enter the quantity in integer value !!");
							}
						}
						int revisedQuantityAfterConverting = Integer.parseInt(revisedQuantity);
						conn.setQuantity(revisedQuantityAfterConverting);
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

				} // end of if

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

		} // end of while loop

	}// end of method..

}// end of class
