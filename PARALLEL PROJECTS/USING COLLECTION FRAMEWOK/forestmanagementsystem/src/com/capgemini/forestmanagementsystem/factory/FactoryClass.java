package com.capgemini.forestmanagementsystem.factory;

import com.capgemini.forestmanagementsystem.dao.ForestDao;
import com.capgemini.forestmanagementsystem.dao.ForestDaoImpl;
import com.capgemini.forestmanagementsystem.dto.ContractDetails;
import com.capgemini.forestmanagementsystem.dto.CustomerDetail;
import com.capgemini.forestmanagementsystem.dto.ProductDetails;

public class FactoryClass {

	public static ContractDetails getContractDetailsObject() {
		return new ContractDetails();
		
	}
	
	public static CustomerDetail getCustomerDetailsObject() {
		return new CustomerDetail();
		
	}
	
	public static ProductDetails getproductDetailsObject() {
		return new ProductDetails();
		
	}
	
	
	public static  ForestDao getForestDAOImplObject() {
		return new ForestDaoImpl();
		
	}
	
	
	
	
	
}
