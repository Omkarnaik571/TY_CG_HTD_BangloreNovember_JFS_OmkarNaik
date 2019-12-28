package com.capgemini.forestmanagementsystem.controller;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.forestmanagementsystem.dao.ForestDao;
import com.capgemini.forestmanagementsystem.dto.LandDetails;
import com.capgemini.forestmanagementsystem.dto.ProductDetails;
import com.capgemini.forestmanagementsystem.exceptions.DisplayingDataWithoutEntry;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.validations.Validations;

public class LandDetailsMain {
	static Map<Integer, LandDetails> result = null;

	public static void landDetailsMain() {
		ForestDao fd=FactoryClass.getForestDAOImplObject();
		LandDetails ld=new LandDetails();
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("HERE ARE THE CHOICES: ");
			System.out.println("PRESS 1 TO ADD A NEW LAND DETAIL");
			System.out.println("PRESS 2 TO VIEW ALL THE LAND DETAILS");
			System.out.println("PRESS 3 TO VIEW A PARTICULAR LAND DETAIL");
			System.out.println("PRESS 4 TO VIEW THE NUMBER OF LAND DETAILS");	
			System.out.println("PRESS 5 TO DELETE A LAND DETAIL");
			System.out.println("PRESS 6 TO MODIFY A LAND DETAIL");
			System.out.println("PRESS 7 TO GO TO ADMIN PAGE");
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
				System.out.println("\nENTER THE PLOT NUMBER : ");
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
				int cc1=Integer.parseInt(c1);
				ld.setPlotnumber(cc1);
				System.out.println("\nENTER THE OWNER NAME : ");
				String cname=null;
				char g='y';
				while(g=='y') {
					cname=sc.next();
					if(Validations.isStringOnlyAlphabet(cname)) {
						g='n';
					}
					else {
						System.err.println("Land owner name can be of alphabets only !!");
					}
				}
				ld.setOwner(cname);
				System.out.println("\nENTER THE ACQUIRED DATE : ");
				ld.setAcquireddate(sc.next());
				System.out.println("\nENTER THE LAND PRICE: ");
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
				double dd1=Double.parseDouble(d1);
				ld.setPrice(dd1);
				result=fd.addTheLandDetails(ld);
				System.out.println("\nLAND DETAILS ADDED SUCCESSFULLY !!\n");
				break;
			case 2:
				try {
					Set<Map.Entry<Integer, LandDetails>>  s1=result.entrySet();                                
					System.out.println("\n----------THE PRODUCT DETAILS ARE:------------");
					System.out.println("*************************************************");
					for (Map.Entry<Integer, LandDetails> entry : s1) {
						System.out.println("Details of Land id ("+entry.getKey()+")  ARE: ");
						System.out.print(entry.getValue()+"\n");
						System.out.println("------------------------------------------------");
					}
					System.out.println("*************************************************");	
				}
				catch (NullPointerException n) {
					DisplayingDataWithoutEntry e=new DisplayingDataWithoutEntry();
					e.dataWithoutEntryForLand();
					// TODO: handle exception
				}
				break;
			case 3:
				try {
				System.out.println("Enter the Land Id Which yo want to see detail Of: ");
				char vid='n';
				String Viewid=null;
				while(vid=='n') {
					Viewid=sc.next();
					if(Validations.isNumber1(Viewid)) {
						vid='x';
					}
					else {
						System.err.println("Enter the Plot number in natural numbers only !!");
					}
				}
				int detail=Integer.parseInt(Viewid);
				boolean yes=result.containsKey(detail);
				if(yes==true) {
					System.out.println("\n----------THE LAND DETAILS ARE:------------");
					System.out.println("*************************************************");
					System.out.println("Details of Land Id "+detail+" is:");      
					Set<Map.Entry<Integer, LandDetails>> s2=   result.entrySet();
					System.out.println(result.get(detail));	
					System.out.println("*************************************************");		
					System.out.println("------------------------------------------------");
				}
				else {
					System.err.println("\nThe Land Id that you have entered is not in the data base !!");
				}
				}//end of try
				catch (NullPointerException n) {
					DisplayingDataWithoutEntry e= new DisplayingDataWithoutEntry();
					e.dataWithoutEntryForLand();
				}

				break;
			case 4:
				try {
					int size=result.size();
					System.out.println("\nNumber of Land Details in the Database = "+size+"\n");
				}
				catch (NullPointerException n) {
					DisplayingDataWithoutEntry e= new DisplayingDataWithoutEntry();
					e.dataWithoutEntryForLand();
				}

				break;
			case 5:
				try {
				System.out.println("Enter the Land Id which you want to Delete:");
				char vid='n';
				String Viewid=null;
				while(vid=='n') {
					Viewid=sc.next();
					if(Validations.isNumber1(Viewid)) {
						vid='x';
					}
					else {
						System.err.println("Enter the Plot number in natural numbers only !!");
					}
				}
				int delete=Integer.parseInt(Viewid);
				if(result.containsKey(delete) ) {
				result.remove(delete);
				System.out.println("\nLand Detail DELETED SUCCESSFULLY\n");
				}
				else {
					System.err.println("\nThe Land Id that you have entered is not in the data base !!");
				}
				
				}
				catch (NullPointerException e) {
					DisplayingDataWithoutEntry e1= new DisplayingDataWithoutEntry();
					e1.dataWithoutEntryForLand();
					// TODO: handle exception
				}
				break;
			case 6:
				try {
				System.out.println("\nENTER THE LAND ID : \n");
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
				if(result.containsKey(landid) ) {
					LandDetails ld1=result.get(landid);
					System.out.println("1 MODIFY OWNER NAME : ");
					System.out.println("2 MODIFY ACQUIRED DATE : ");
					System.out.println("3 MODIFY LAND PRICE: ");
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
					int mod=Integer.parseInt(choicen);
					switch (mod) {
					case 1:
						System.out.println("\nENTER REVISED OWNER NAME : ");
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
						ld1.setOwner(mcname);
                        result.replace(landid, ld1);
                        System.out.println("\nOWNER NAME MODIFIED SUCCESSFULLY !!\n");
						break;
					case 2:
						System.out.println("\nENTER REVISED ACQUIRED DATE : ");
                        
						
						ld1.setAcquireddate(sc.next());
                        result.replace(landid, ld1);
                        System.out.println("\nACQUIRED DATE MODIFIED SUCCESSFULLY !!\n");
						break;
					case 3:
						System.out.println("\nENTER REVISED  LAND PRICE : ");
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
                        ld1.setPrice(dd2);
                        result.replace(landid, ld1);
                        System.out.println("\nLAND PRICE MODIFIED SUCCESSFULLY !!\n");
						break;
					default:
						System.err.println("\nPLEASE SELECT A VALID OPTION !!\n");
						break;
					}	
					
				}
				else {
					System.err.println("\nTHE LAND ID THAT YOU HAVE ENTERED IS NOT IN THE DATABASE  !!\n");
				}
				}//end of modify land try
				catch (NullPointerException e) {
					DisplayingDataWithoutEntry e1= new DisplayingDataWithoutEntry();
					e1.dataWithoutEntryForLand();
					// TODO: handle exception
				}
				
				break;
			case 7:
				AdminPage.adminPage();
				break;
			default:
				System.err.println("\nPLEASE SELECT A VALID OPTION !!\n");
				break;
			}




		}//end of while loop





	}









}
