package com.capgemini.forestmanagementsystem.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.dto.CustomerDetailsDto;
import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.ContractCustomException;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.service.ContractService;
import com.capgemini.forestmanagementsystem.service.CustomerService;
import com.capgemini.forestmanagementsystem.service.CustomerServiceImpl;
import com.capgemini.forestmanagementsystem.service.ProductService;
import com.capgemini.forestmanagementsystem.service.ProductServiceImpl;
import com.capgemini.forestmanagementsystem.validations.Validations;

public class ClientContractOperations {
   
	static Scanner scanner=new Scanner(System.in);
	
public static void clientContractOperation(){
		
	ContractorDetailsDto contractDetailsDto = FactoryClass.getContractorDetailsDto();
	ContractService contractService = FactoryClass.getContractDetailsServiceImpl();
	while (true) {
		System.out.println("--------------------CONTRACT OPERATIONS------------------");
		System.out.println("1 ADD A CONTRACT");
		System.out.println("2 DELETE A CONTRACT");
		System.out.println("3 VIEW  CONTRACT");
		System.out.println("4 MODIFY CONTRACT DETAILS");
		System.out.println("5 GO BACK TO ADMIN PAGE");
		char switchCaseLoop = 'n';
		String choice = null;
		while (switchCaseLoop == 'n') {
			choice = scanner.next();
			if (Validations.isNumber1(choice)) {
				switchCaseLoop = 'x';
			} else {
				System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
			}
		}
		int ch = Integer.parseInt(choice);
		switch (ch) {
		case 1:
			System.out.println("ENTER THE CONTRACT NO: ");
			char contractNumberChoice = 'n';
			String contraactNumberInput = null;
			while (contractNumberChoice == 'n') {
				contraactNumberInput = scanner.next();
				if (Validations.isNumber1(contraactNumberInput)) {
					contractNumberChoice = 'x';
				} else {
					System.err.println("Enter the contract number in integer value !!");
				}
			}
			contractDetailsDto.setContractNo(Integer.parseUnsignedInt(contraactNumberInput));
			int check = 1;
			while (check == 1) {
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
				contractDetailsDto.setCustomerId(Integer.parseUnsignedInt(customerIdInput));
				CustomerDetailsDto customerDetailsDto = FactoryClass.getCustomerDetailsDto();
				CustomerService customerService = new CustomerServiceImpl();
				customerDetailsDto.setCustomerId(contractDetailsDto.getCustomerId());
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
							inputForWrongCustomer = scanner.next();
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
						}// end of switch

					} // end of else

				} catch (CustomExceptions e) {
					e.exceptionMessage();
				}

			} // end of while
			int checkForCorrectProductId = 1;
			while (checkForCorrectProductId == 1) {
				System.out.println("Enter the Product Id: ");
				char productIdSwitch = 'n';
				String productIdInput = null;
				while (productIdSwitch == 'n') {
					productIdInput = scanner.next();
					if (Validations.isNumber1(productIdInput)) {
						productIdSwitch = 'x';
					} else {
						System.err.println("Enter the product id in integer value !!");
					}
				}
				contractDetailsDto.setProductId(Integer.parseInt(productIdInput));
				ProductDetailsDto productDetailsDto = FactoryClass.getProductDetailsDto();
				ProductService productService = new ProductServiceImpl();
				productDetailsDto.setProductId(contractDetailsDto.getProductId());
				try {
					productDetailsDto = productService.viewParticularProduct(productDetailsDto);
					if (productDetailsDto != null) {
						checkForCorrectProductId = 2;
					} else {
						System.err.println("\nTHE PRODUCT ID THAT YOU HAVE ENTERED DOES`NT EXISTS\n");
						System.out.println("SELECT YOUR CHOICE WHAT YOU WANT TO DO NOW :-->");
						System.out.println("1. TRY ENTER ANOTHER PRODUCT ID");
						System.out.println("2. GO BACK TO ADMIN PAGE");
						char choiceForWrongCustomer = 'n';
						String inputForWrongCustomer = null;
						while (choiceForWrongCustomer == 'n') {
							inputForWrongCustomer = scanner.next();
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
						}// end of switch

					} // end of else

				} catch (CustomExceptions e) {
					e.exceptionMessage();
				}

			} // end of whie

			System.out.println("Enter the Delivery Date: ");
			String deliveryDateInput = null;
			char deliveryDateSwitchCase = 'y';
			while (deliveryDateSwitchCase == 'y') {
				deliveryDateInput = scanner.next();
				if (Validations.isValidDate(deliveryDateInput)) {
					System.err.println(
							"\nEnter delivery date in (dd/mm/yyyy) format and It should be in future date only");
				} else {
					deliveryDateSwitchCase = 'n';
				}
			}
			contractDetailsDto.setDeliveryDate(deliveryDateInput);
			System.out.println("Enter the Quantity:(Enter In Terms Of Kg) !! ");
			// sc.nextLine();
			contractDetailsDto.setQuantity(scanner.next());
			try {
				if (contractService.addContractor(contractDetailsDto)) {
					System.out.println("\nCONTRACT ADDED SUCCESSFULLY !!\n");
				} else {

				}
			} catch (ContractCustomException e) {
				e.primarykeyviolation();
			}

			break;
		case 2:
			System.out.println("ENTER THE CONTRACT NO: ");
			char deleteCntractChoice = 'n';
			String deleteContractInput = null;
			while (deleteCntractChoice == 'n') {
				deleteContractInput = scanner.next();
				if (Validations.isNumber1(deleteContractInput)) {
					deleteCntractChoice = 'x';
				} else {
					System.err.println("Enter the Contractor number in integer value !!");
				}
			}
			contractDetailsDto.setContractNo(Integer.parseInt(deleteContractInput));
			try {
				if (contractService.deleteContractorDetails(contractDetailsDto)) {
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
			char viewContractChoice = 'n';
			String viewContractInput = null;
			while (viewContractChoice == 'n') {
				viewContractInput = scanner.next();
				if (Validations.isNumber1(viewContractInput)) {
					viewContractChoice = 'x';
				} else {
					System.err.println("Enter the Contractor number in integer value !!");
				}
			}
			contractDetailsDto.setContractNo(Integer.parseInt(viewContractInput));
			ContractorDetailsDto isViewSingle = null;
			try {
				isViewSingle = contractService.viewSingleContractorDetails(contractDetailsDto);
			} catch (CustomExceptions e1) {
				e1.exceptionMessage();
			}
			if (isViewSingle == null) {
				System.err.println("\nThe contract number that you have entered is not present !!\n");
			} else {
				System.out.println("\n---------PRODUCT DETAILS------------------");
				System.out.println("Contract No : " + isViewSingle.getContractNo());
				System.out.println("Customer Id : " + isViewSingle.getCustomerId());
				System.out.println("Product Id : " + isViewSingle.getProductId());
				System.out.println("Delivery Date: " + isViewSingle.getDeliveryDate());
				System.out.println("Quantity : " + isViewSingle.getQuantity());
				System.out.println("Contract Status : " + isViewSingle.getContractStatus());
				System.out.println("--------------------------------------------");
			}

			break;
		case 4:
			System.out.println("--------------------MODIFY CUSTOMER DETAILS---------------------");
			System.out.println("1.  MODIFY DELIVERY DATE: ");
			System.out.println("2.  MODIFY QUANTITY: ");
			char modifyContractChoice = 'n';
			String modifyContractInput = null;
			while (modifyContractChoice == 'n') {
				modifyContractInput = scanner.next();
				if (Validations.isNumber1(modifyContractInput)) {
					modifyContractChoice = 'x';
				} else {
					System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
				}
			}
			int option = Integer.parseInt(modifyContractInput);
			boolean isModified = false;
			switch (option) {
			case 1:
				System.out.println("ENTER THE CONTRACT NO: ");
				char modifyForDeliveryDateChoice = 'n';
				String modifyForDeliveryDateInput = null;
				while (modifyForDeliveryDateChoice == 'n') {
					modifyForDeliveryDateInput = scanner.next();
					if (Validations.isNumber1(modifyForDeliveryDateInput)) {
						modifyForDeliveryDateChoice = 'x';
					} else {
						System.err.println("Enter the contract number in integer value !!");
					}
				}
				contractDetailsDto.setContractNo(Integer.parseInt(modifyForDeliveryDateInput));
				scanner.nextLine();
				System.out.println("ENTER THE REVISED DELIVERY DATE: ");
				String ddate2 = null;
				char z2 = 'y';
				while (z2 == 'y') {
					ddate2 = scanner.next();
					if (Validations.isValidDate(ddate2)) {
						System.err.println(
								"\nEnter delivery date in (dd/mm/yyyy) format and It should be in future date only");
					} else {
						z2 = 'n';
					}
				}
				contractDetailsDto.setDeliveryDate(ddate2);
				try {
					if (contractService.modifyContractorDetails(contractDetailsDto, option)) {
						System.out.println("\nDELIVERY DATE MODIFIED SUCCESSFULLY !! \n");
					} else {
						System.out.println("\nTHE CONTRACT NUMBER THAT YOU HAVE ENTERED DOES`NT EXISTS !!\n");
					}
				} catch (CustomExceptions e) {
					e.exceptionMessage();
				}
				break;
			case 2:
				System.out.println("ENTER THE CONTRACT NO: ");
				char modifyForQuantityChoice = 'n';
				String modifyForQuantityInput = null;
				while (modifyForQuantityChoice == 'n') {
					modifyForQuantityInput = scanner.next();
					if (Validations.isNumber1(modifyForQuantityInput)) {
						modifyForQuantityChoice = 'x';
					} else {
						System.err.println("Enter the contract number in integer value !!");
					}
				}
				contractDetailsDto.setContractNo(Integer.parseInt(modifyForQuantityInput));
				scanner.nextLine();
				System.out.println("ENTER THE QUANTITY: (Enter In Terms Of Kg) !! ");
				contractDetailsDto.setQuantity(scanner.nextLine());
				try {
					if (contractService.modifyContractorDetails(contractDetailsDto, option)) {
						System.out.println("\nQUANTITY MODIFIED SUCCESSFULLY !!\n");
					} else {
						System.out.println("\nTHE CONTRACT NUMBER THAT YOU HAVE ENTERED DOES`NT EXISTS !!\n");
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
		case 5:
			AdminPage.adminMain();
			break;
		default:
			System.err.println("\nPLEASE SELECT A VALID OPTION........\n");
			break;
		}

	} // end of while loop
	
	

		
	}//end of client contract operation
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
