package com.capgemini.forestmanagementsystem.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.controller.AdminPage;
import com.capgemini.forestmanagementsystem.controller.ClientPage;
import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;
import com.capgemini.forestmanagementsystem.factory.FactoryClass;
import com.capgemini.forestmanagementsystem.validations.Validations;
import com.mysql.jdbc.Statement;

public class ProductDaoImpl implements ProductDao {
	ProductDetailsDto pdd=FactoryClass.getProductDetailsDto();
    Scanner sc=new Scanner(System.in);
	
	@Override
	public boolean addProduct(ProductDetailsDto pdt ) throws CustomExceptions {
		FileReader reader=null;
		Properties prop=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader=new FileReader("operations.properties");
			prop=new Properties();
			prop.load(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbname"),prop.getProperty("dbpass"));
				PreparedStatement insert=conn.prepareStatement(prop.getProperty("insertproduct"))
				){	
			 insert.setInt(1, pdt.getProductId());
			insert.setString(2, pdt.getProductName());
			 int result=insert.executeUpdate();
			if(result>0) {
				System.out.println("\nPRODUCT ADDED SUCCESSFULLY !!\n");
				return true;
				
			}
			else {
				System.out.println("\nYOUR INPUT TO SOME FIELDS DID`NT MATCHED THE PARAMIETERS,  PLEASE INSERT DATA AGAIN PROPERLY !!\n");
			} 
		}
		catch (Exception e) {
			throw new CustomExceptions();
			// TODO: handle exception
		}
		
		return false;
	}//end of addProduct()

	@Override
	public boolean deleteProduct(ProductDetailsDto pdt )  {
		FileReader reader=null;
		Properties prop=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader=new FileReader("operations.properties");
			prop=new Properties();
			prop.load(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbname"),prop.getProperty("dbpass"));
				PreparedStatement delete=conn.prepareStatement(prop.getProperty("deleteproduct"))
				){
			 delete.setInt(1, pdt.getProductId());
			 int result=delete.executeUpdate();
				if(result>0) {
					System.out.println("\nPRODUCT DELETED SUCCESSFULLY !!\n");
					return true;	
				}
				else {
					System.err.println("The Product id that you have entered is not present in the data base !!\n");
				} 
			 
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
	}// end of deleteProduct()

	@Override
	public boolean modifyProduct(ProductDetailsDto pdt ) {
		FileReader reader=null;
		Properties prop=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader=new FileReader("operations.properties");
			prop=new Properties();
			prop.load(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbname"),prop.getProperty("dbpass"));
				PreparedStatement modify=conn.prepareStatement(prop.getProperty("modifyproductname"))
				){
			modify.setInt(2, pdt.getProductId());
			modify.setString(1, pdt.getProductName());
			 int result=modify.executeUpdate();
				if(result>0) {
					System.out.println("\nPRODUCT NAME MODIFIED SUCCESSFULLY !!\n");
					return true;	
				}
				else {
					System.err.println("The product id That you have entered is not Present !!\n");
				}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		

		return false;
	}// end of modifyProduct()

	@Override
	public boolean viewAllProduct() {
		FileReader reader=null;
		Properties prop=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader=new FileReader("operations.properties");
			prop=new Properties();
			prop.load(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbname"),prop.getProperty("dbpass"));
//				Scanner sc=new Scanner(System.in);
				java.sql.Statement stmt=conn.createStatement()
				) {	
			ResultSet rs=stmt.executeQuery(prop.getProperty("viewallproduct"));
			System.out.println("\n<^^^^^^PRODUCT DETAILS^^^^^^^^^^^>");
			while(rs.next()) {
				System.out.println("PRODUCT ID : "+rs.getInt(1));
				System.out.println("PRODUCT NAME : "+rs.getString(2));
				System.out.println("--------------------------------------------------------------------------");
			}
			System.out.println("<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>\n");
			 if(rs.first()) {
				 return true;
			}
			else {
				System.err.println("There are no products present in the database !!\n");
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
		
	}// end of view allProduct()

	@Override
	public boolean viewParticularProduct() {
		FileReader reader=null;
		Properties prop=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader=new FileReader("operations.properties");
			prop=new Properties();
			prop.load(reader);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dburl"),
				prop.getProperty("dbname"),prop.getProperty("dbpass"));
//				Scanner sc=new Scanner(System.in);
				PreparedStatement view=conn.prepareStatement(prop.getProperty("viewsingleproduct"))
				){	
			System.out.println("ENTER PRODUCT ID: ");
			char c='n';
			String c1=null;
			while(c=='n') {
			    c1=sc.next();
				if(Validations.isNumber1(c1)) {
					c='x';
				}
				else {
					System.err.println("Enter the Product id in integer value !!");
				}
			}
			 pdd.setProductId(Integer.parseInt(c1));
			 view.setInt(1, pdd.getProductId());
			ResultSet rs=view.executeQuery();
			System.out.println("\n<^^^^^^PRODUCT DETAILS^^^^^^^^^^^>");
			while(rs.next()) {
				System.out.println("PRODUCT ID : "+rs.getInt(1));
				System.out.println("PRODUCT NAME : "+rs.getString(2));
				System.out.println("---------------------------------------------------------------------");
			}
			System.out.println("<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>\n");
			if(rs.first()) {
				return true;
			}
			else {
				System.err.println("The product id That you have entered is not Present !!\n");
			}
//			ClientPage.productOperations();
			
			}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
       return false;
	}// end of ParticularProduct()

	
	
	
}
