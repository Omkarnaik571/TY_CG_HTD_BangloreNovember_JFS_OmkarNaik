package com.capgemini.module1usecase.mainaccess;

import java.util.Scanner;

import com.capgemini.module1usecase.dao.ContactDaoImpl;
import com.capgemini.moduleusecase1.factory.FactoryClass;

public class HomePage {
	public static void main(String[] args) {
       ContactDaoImpl cdi=FactoryClass.getContactDaoObject();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("------WELCOME TO PHONE SIMULATOR--------------");
		System.out.println("\nSELECT YOUR OPTIONS :-->");
		System.out.println("Press 1 to Show All Contacts");
		System.out.println("Press 2 to search a Contact");
		System.out.println("Press 3 to operate on a Contact");  

		int choice=sc.nextInt();
		if(choice ==1) {
			//Show all the contacts
			cdi.viewAllContact();
			
			
		}
		else if(choice ==2) {
			//Show a particular contact
			cdi.searchContact();

		}
		else if(choice ==3) {
			//Perform opeartion on a contact
			System.out.println("\nSELECT YOUR OPTIONS :-->");
			System.out.println("Press 1 to add a contact");
			System.out.println("Press 2 to delete a Contact");
			System.out.println("Press 3 to modify Contact"); 
			int option=sc.nextInt();
			switch (option){
			case 1:
				//add a contact
			int add=cdi.addContact();
              if(add>0) {
            	  System.out.println("\nRecord inserted successfully..");
            	  HomePage.main(args);
              }
              else {
            	  System.out.println("\nSomething went wrong..");
            	  HomePage.main(args);
              }
			
				break;
			case 2:
                 //delete a contact
				int delete=cdi.deleteContact();
				if(delete>0) {
	            	  System.out.println("\nRecord deleted successfully..");
	            	  HomePage.main(args);
	              }
	              else {
	            	  System.out.println("\nSomething went wrong..");
	            	  HomePage.main(args);
	              }
				break;
			case 3:
                //modify a contact
				System.out.println("Press 1 to modify the Number : ");
				System.out.println("Press 2 to modify the Group type :");
				int mod=sc.nextInt();
				
				if(mod==1) {
				int modifynumber=cdi.modifyContact();
				if(modifynumber>0) {
	            	  System.out.println("\nPhone number modified successfully..");
	            	  HomePage.main(args);
	              }
	              else {
	            	  System.out.println("\nSomething went wrong..");
	            	  HomePage.main(args);
	              }
					
				}
				else if(mod==2) {
					int modifygroup=cdi.modifyContactGroup();
					if(modifygroup>0) {
		            	  System.out.println("\nGroup modified successfully..");
		            	  HomePage.main(args);
		              }
		              else {
		            	  System.out.println("\nSomething went wrong..");
		            	  HomePage.main(args);
		              }
					
					
				}
				else {
					System.out.println("\nInvalid Choice");
					HomePage.main(args);
				}
				
				
				break;

			default:
				System.out.println("\nPlease select a valid option..");
				break;
			}




		}
		else {
			System.out.println("\nPlease enter a valid Choice..");
			HomePage.main(args);
		}


	}




}
