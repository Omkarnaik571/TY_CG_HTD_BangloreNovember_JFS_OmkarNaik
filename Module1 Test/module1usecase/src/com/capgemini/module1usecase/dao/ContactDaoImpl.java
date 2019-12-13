package com.capgemini.module1usecase.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.module1usecase.dto.ContactDto;
import com.capgemini.module1usecase.mainaccess.HomePage;
import com.capgemini.moduleusecase1.factory.FactoryClass;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class ContactDaoImpl  implements ContactDao{
	FileReader reader=null;
	Properties prop=null;
	ContactDto cdt=FactoryClass.getContactDtoObject();
	private String[] args; 	


	//1.
	@Override
	public int addContact() {
		int result=0;
		Scanner sc=new Scanner(System.in);
		try {
			reader=new FileReader("data.properties");
			prop=new Properties();
			prop.load(reader);
			//Jdbc steps
			//1.
			Class.forName("com.mysql.jdbc.Driver");
			 //Driver is loaded
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try(java.sql.Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("username"),prop.getProperty("password"));
				PreparedStatement stmt=conn.prepareStatement(prop.getProperty("insert"))	

				){
			//Connection is made
			System.out.println("Enter the Name:");
			cdt.setName(sc.next());
			stmt.setString(1,cdt.getName() );
			System.out.println("Enter the Number:");
			cdt.setNumber(sc.nextInt());
			stmt.setInt(2, cdt.getNumber());
			System.out.println("Enter the Group Type:");
			cdt.setGroupn(sc.next());
			stmt.setString(3, cdt.getGroupn());

			result=stmt.executeUpdate();

		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}


		return result;

	}
	//1. Add contact end


	//2.
	@Override
	public int deleteContact() {
		int result=0;
		Scanner sc=new Scanner(System.in);
		try {
			reader=new FileReader("data.properties");
			prop=new Properties();
			prop.load(reader);
			//Jdbc steps
			//1.
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try(java.sql.Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("username"),prop.getProperty("password"));
				PreparedStatement stmt=conn.prepareStatement(prop.getProperty("delete"))	

				){
			
			System.out.println("Enter the Name whose record you want to delete:");
			cdt.setName(sc.next());
			stmt.setString(1,cdt.getName() );

			result=stmt.executeUpdate();

		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return result;
	}
	//2. delete contact end






	//3.
	@Override
	public int modifyContact() {
		int result=0;
		Scanner sc=new Scanner(System.in);
		try {
			reader=new FileReader("data.properties");
			prop=new Properties();
			prop.load(reader);
			//Jdbc steps
			//1.
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try(java.sql.Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("username"),prop.getProperty("password"));
				PreparedStatement stmt=conn.prepareStatement(prop.getProperty("modifynumber"))	
				){
			System.out.println("Enter the Name:");
			cdt.setName(sc.next());
			stmt.setString(2,cdt.getName() );
			System.out.println("Enter the revised Number:");
			cdt.setNumber(sc.nextInt());
			stmt.setInt(1, cdt.getNumber());
			result=stmt.executeUpdate();
			


		}

		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}


     return result;
	}
	//3. modify contact end








	//4.
	@Override
	public void searchContact() {
		Scanner sc=new Scanner(System.in);
		try {
			reader=new FileReader("data.properties");
			prop=new Properties();
			prop.load(reader);
			//Jdbc steps
			//1.
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try(java.sql.Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("username"),prop.getProperty("password"));
				PreparedStatement stmt=conn.prepareStatement(prop.getProperty("searchcontact"))

				){
			System.out.println("\nEnter the Name which you want to see detail of:");
			cdt.setName(sc.next());
			stmt.setString(1,cdt.getName() );	
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				System.out.println("Name : "+rs.getString("name"));
				System.out.println("Phone Number : "+rs.getInt(2));
				System.out.println("Group Type : "+rs.getString("groupn"));
			}
			System.out.println("\nSELECT WHICH TASK YOU WANT TO PERFORM");		
			System.out.println("1 for Call");		
			System.out.println("2 for Message");		
			System.out.println("3 for Main menu");
			int choice=sc.nextInt();
			if(choice==1) {
				System.out.println("\n*****CALLING****  <"+cdt.getName()+">");
				System.out.println("\nPress 9 to end the call..");
				int ch=sc.nextInt();
				if(ch==9) {
					System.out.println("\n***Ending the call with  <"+cdt.getName()+">");
					HomePage.main(args);
				}
				else {
					System.out.println("\nInvalid end call button..");
					searchContact();
				}

			}
			else if(choice==2) {
				System.out.println("Type your message :");
				sc.nextLine();
				String message=sc.nextLine();
				System.out.println("\nThe message  {"+message+"} has been sent to  "+cdt.getName());
				HomePage.main(args);

			}
			else if(choice ==3) {
				HomePage.main(args);
			}
			else {
				System.out.println("\nPlease select a valid Choice..");
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}


	}


	//4. search contact end





	//5.
	@Override
	public void viewAllContact() {
		Scanner sc=new Scanner(System.in);
		try {
			reader=new FileReader("data.properties");
			prop=new Properties();
			prop.load(reader);
			//Jdbc steps
			//1.
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try(java.sql.Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("username"),prop.getProperty("password"));
				java.sql.Statement stmt=conn.createStatement();

				){

			ResultSet rs=stmt.executeQuery(prop.getProperty("viewallcontact"));
			System.out.println("---All the Names in the contact List are------");
			while(rs.next()) {
				System.out.println(rs.getString("name"));
			}
			HomePage.main(args);

		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}



	}
	//5. view all contact end


	@Override
	public int modifyContactGroup() {
		int result=0;
		Scanner sc=new Scanner(System.in);
		try {
			reader=new FileReader("data.properties");
			prop=new Properties();
			prop.load(reader);
			//Jdbc steps
			//1.
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try(java.sql.Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),prop.getProperty("username"),prop.getProperty("password"));
				PreparedStatement stmt=conn.prepareStatement(prop.getProperty("modifygroupn"))	
				){
			System.out.println("Enter the Name:");
			cdt.setName(sc.next());
			stmt.setString(2,cdt.getName() );
			System.out.println("Enter the revised Group Type:");
			cdt.setGroupn(sc.next());
			stmt.setString(1, cdt.getGroupn());
			result=stmt.executeUpdate();
			
		}

		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}


     return result;
		
	}


}
