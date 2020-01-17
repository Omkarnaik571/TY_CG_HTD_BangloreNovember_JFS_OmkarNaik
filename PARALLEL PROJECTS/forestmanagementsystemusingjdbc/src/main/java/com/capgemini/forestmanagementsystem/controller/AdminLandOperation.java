package com.capgemini.forestmanagementsystem.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.dao.LandDao;
import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.dto.LandDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.service.LandService;
import com.capgemini.forestmanagementsystem.service.LandServiceImpl;
import com.capgemini.forestmanagementsystem.validations.Validations;

public class AdminLandOperation {
	
	static Scanner sc=new Scanner(System.in);
	
	public static void landOperations() {
		LandDetailsDto ldd=FactoryClass.getLandDetailsDto();
		LandService ld=new LandServiceImpl();
		while(true) {

			System.out.println("--------------------CLIENT OPERATIONS------------------");
			System.out.println("1 ADD A LAND DETAIL");
			System.out.println("2 DELETE A LAND DETAIL");
			System.out.println("3 VIEW  LAND DETAILS");
			System.out.println("4 MODIFY LAND DETAILS");
			System.out.println("5 GO BACK TO ADMIN PAGE");
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
				System.out.println("ENTER THE PLOT NUMBER : ");
				char c='n';
				String c1=null;
				while(c=='n') {
					c1=sc.next();
					if(Validations.isNumber1(c1)) {
						c='x';
					}
					else {
						System.err.println("Enter the Plot number in natural numbers only !!");
					}
				}
				ldd.setPlotNumber(Integer.parseInt(c1));
				System.out.println("ENTER THE ACQUIRED DATE : ");
				ldd.setAcquireDdate(sc.next());
				System.out.println("ENTER THE LAND VALUE : ");
				char d='n';
				String d1=null;
				while(d=='n') {
					d1=sc.next();
					if(Validations.isNumber1(d1)) {
						d='x';
					}
					else {
						System.err.println("Enter the Land price in integer value !!");
					}
				}
				ldd.setLandValue(d1);
				System.out.println("ENTER THE LOCATION : ");
				char e='n';
				String e1=null;
				while(e=='n') {
					e1=sc.next();
					if(Validations.isStringOnlyAlphabet(e1)) {
						e='x';
					}
					else {
						System.err.println("Enter the location in alphabets only !!");
					}
				}
				ldd.setLocation(e1);
				try {
					if(ld.addLand(ldd)) {
						System.out.println("\nLAND DETAIL ADDED SUCCESSFULLY !!\n");
					}
					else {
						System.out.println("\nTHE PLOT NUMBER THAT YOU HAVE ENTERED ALREADY EXISTS !!\n");
					}
				}
				catch (CustomExceptions n) {
					n.plotNumberAlreadyExist();
					// TODO: handle exception
				}
				break;
			case 2:
				System.out.println("ENTER THE PLOT NUMBER : ");
				char plot1='n';
				String plotno1=null;
				while(plot1=='n') {
					plotno1=sc.next();
					if(Validations.isNumber1(plotno1)) {
						plot1='x';
					}
					else {
						System.err.println("Enter the Plot number in natural numbers only !!");
					}
				}
				ldd.setPlotNumber(Integer.parseInt(plotno1));
				try {
					if(ld.deleteLand(ldd)) {
						System.out.println("\nLAND DETAIL DELETED SUCCESSFULLY !!\n");
					}
					else {
						System.err.println("\nTHE PLOT NUMBER THAT YOU HAVE ENTERED DOES`NT EXISTS !!\n");
					}
				} catch (CustomExceptions e2) {
					e2.exceptionMessage();
				}
				break;
			case 3:				
				try {
					List<LandDetailsDto> result=ld.viewAllLand();
				if(!result.isEmpty()) {
					System.out.println("\n--------LAND DETAILS-------------");
					for (LandDetailsDto lx : result) {
						System.out.println(lx);
						System.out.println("----------------------------");
					}
				}//end of if
				else{
					System.err.println("\nThere are no land details present in the database !!\n");
				}
				} catch (CustomExceptions e2) {
					e2.exceptionMessage();
				}
				
				
				
				break;
			case 4:
				boolean isModified=false;
				System.out.println("1 TO MODIFY ACQUIRED DATE : ");
				System.out.println("2 TO MODIFY LAND VALUE : ");
				char n='n';
				String choicen=null;
				while(n=='n') {
					choicen=sc.next();

					if(Validations.isNumber1(choicen)) {
						n='x';
					}
					else {
						System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
					}
				}

				int option=Integer.parseInt(choicen);
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
					ldd.setAcquireDdate(sc.nextLine());
					try {
						if(ld.modifyLand(ldd, option)) {
							System.out.println("\nACQUIRED DATE MODIFIED SUCCESSFULLY !!\n");
						}
						else {
							System.err.println("\nTHE PLOT NUMBER THAT YOU HAVE ENTERED DOES`NT EXISTS !!\n");
						}
					} catch (CustomExceptions e2) {
						e2.exceptionMessage();
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
						if(ld.modifyLand(ldd, option)) {
							System.out.println("\nLAND PRICE MODIFIED SUCCESSFULLY !!\n");
						}
						else {
							System.err.println("\nTHE PLOT NUMBER THAT YOU HAVE ENTERED DOES`NT EXISTS !!\n");
						}
						
					} catch (CustomExceptions e2) {
						e2.exceptionMessage();
					}

					break;
				default:
					System.err.println("/nPLEASE SELECT A VALID OPTION/n");

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

		}//end of while loop

	}
	//land opeartion end

	
	
	
	
	
	
	
	
	
	
	
}//end of class
