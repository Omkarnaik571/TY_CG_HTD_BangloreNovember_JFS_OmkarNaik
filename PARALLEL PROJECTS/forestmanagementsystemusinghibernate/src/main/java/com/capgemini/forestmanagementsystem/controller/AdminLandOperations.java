package com.capgemini.forestmanagementsystem.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.dto.LandDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.service.LandService;
import com.capgemini.forestmanagementsystem.service.LandServiceImpl;
import com.capgemini.forestmanagementsystem.validations.Validations;

public class AdminLandOperations {

	static Scanner sc = new Scanner(System.in);
	private static String[] args;
	static LandService landService = new LandServiceImpl();

	public static void adminLandOperation() {
		while (true) {
			LandDetailsDto ldd = FactoryClass.getLandDetailsDto();
			System.out.println("--------------------CLIENT OPERATIONS------------------");
			System.out.println("1 ADD A LAND DETAIL");
			System.out.println("2 DELETE A LAND DETAIL");
			System.out.println("3 VIEW  LAND DETAILS");
			System.out.println("4 MODIFY LAND DETAILS");
			System.out.println("5 GO BACK TO ADMIN PAGE");
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
				System.out.println("ENTER THE PLOT NUMBER : ");
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
				ldd.setPlotNumber(Integer.parseInt(c1));
				System.out.println("ENTER THE ACQUIRED DATE : ");
				ldd.setAcquiredDate(sc.next());
				System.out.println("ENTER THE LAND VALUE : ");
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
				ldd.setLandValue(d1);
				System.out.println("ENTER THE LOCATION : ");
				char e = 'n';
				String e1 = null;
				while (e == 'n') {
					e1 = sc.next();
					if (Validations.isStringOnlyAlphabet(e1)) {
						e = 'x';
					} else {
						System.err.println("Enter the location in alphabets only !!");
					}
				}
				ldd.setLocation(e1);
				try {
					landService.addLand(ldd);
				} catch (CustomExceptions e2) {
					e2.exceptionMessage();
				}

				break;
			case 2:
				System.out.println("ENTER THE PLOT NUMBER : ");
				char plot1 = 'n';
				String plotno1 = null;
				while (plot1 == 'n') {
					plotno1 = sc.next();
					if (Validations.isNumber1(plotno1)) {
						plot1 = 'x';
					} else {
						System.err.println("Enter the Plot number in natural numbers only !!");
					}
				}
				ldd.setPlotNumber(Integer.parseInt(plotno1));

				try {
					landService.deleteLand(ldd);
				} catch (CustomExceptions e2) {
					e2.exceptionMessage();
				}
				break;
			case 3:
				try {
					List<LandDetailsDto> result = landService.viewAllLand();
					if (result.isEmpty()) {
						System.err.println("\nTHERE ARE NO LAND DETAILS PRESENT IN THE DATABASE\n");
					} else {
						System.out.println("\n--------LAND DETAILS------------------");
						for (LandDetailsDto l1 : result) {
							System.out.println(l1);
							System.out.println("--------------------------------------");
						}
					} // end of else..
				} catch (CustomExceptions e2) {
					e2.exceptionMessage();
				}

				break;
			case 4:
				boolean isModified = false;
				System.out.println("1 TO MODIFY ACQUIRED DATE : ");
				System.out.println("2 TO MODIFY LAND VALUE : ");
				char n = 'n';
				String choicen = null;
				while (n == 'n') {
					choicen = sc.next();

					if (Validations.isNumber1(choicen)) {
						n = 'x';
					} else {
						System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
					}
				}

				int option = Integer.parseInt(choicen);
				switch (option) {
				case 1:
					System.out.println("ENTER THE PLOT NUMBER : ");
					char plot2='n';
					String plotno2=null;
					while(plot2=='n') {
						plotno2=sc.next();
						if(Validations.isNumber1(plotno2)) {
							plot2='x';
						}
						else {
							System.err.println("Enter the Plot number in natural numbers only !!");
						}
					}
					ldd.setPlotNumber(Integer.parseInt(plotno2));
					System.out.println("ENTER THE  REVISED ACQUIRED DATE : ");
					sc.nextLine();
					ldd.setAcquiredDate(sc.nextLine());
					try {
						isModified=landService.modifyLand(ldd, option);
					} catch (CustomExceptions e2) {
						e2.exceptionMessage();
					}
					if(isModified) {
						System.out.println("\nACQUIRED DATE MODIFIED SUCCESSFULLY !!\n");
					}else {
						System.out.println("\nACQUIRED  MODIFICATION UNSUCCESSFUL !!\n");
					}
					
					break;
				case 2:
					System.out.println("ENTER THE PLOT NUMBER : ");
					char plot3='n';
					String plotno3=null;
					while(plot3=='n') {
						plotno3=sc.next();
						if(Validations.isNumber1(plotno3)) {
							plot3='x';
						}
						else {
							System.err.println("Enter the Plot number in natural numbers only !!");
						}
					}
					ldd.setPlotNumber(Integer.parseInt(plotno3));
					System.out.println("ENTER THE REVISED LAND VALUE : ");
					char g='n';
					String g1=null;
					while(g=='n') {
						g1=sc.next();
						if(Validations.isNumber1(g1)) {
							g='x';
						}
						else {
							System.err.println("Enter the Land price in integer value !!");
						}
					}
					ldd.setLandValue(g1);
					try {
						isModified=landService.modifyLand(ldd, option);
					} catch (CustomExceptions e2) {
						e2.exceptionMessage();
					}
					if(isModified) {
						System.out.println("\nLAND VALUE MODIFIED SUCCESSFULLY !!\n");
					}else {
						System.out.println("\nLAND VALUE  MODIFICATION UNSUCCESSFUL !!\n");
					}

					break;

				default:
					System.err.println("\nPLEASE SELECT A VALID OPTION........\n");
					break;
				}
				break;
			case 5:
				AdminPage.main(args);
				break;

			default:
				System.err.println("\nPLEASE SELECT A VALID OPTION........\n");
				break;
			}

		} // end of while

	}// end of method

}// end of class
