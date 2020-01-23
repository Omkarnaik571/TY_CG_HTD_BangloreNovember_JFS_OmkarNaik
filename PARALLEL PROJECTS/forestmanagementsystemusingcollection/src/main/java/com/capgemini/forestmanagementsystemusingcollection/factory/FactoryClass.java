package com.capgemini.forestmanagementsystemusingcollection.factory;


import com.capgemini.forestmanagementsystemusingcollection.dto.ContractDetails;
import com.capgemini.forestmanagementsystemusingcollection.dto.CustomerDetail;
import com.capgemini.forestmanagementsystemusingcollection.dto.LandDetails;
import com.capgemini.forestmanagementsystemusingcollection.dto.ProductDetails;

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
	
	public static LandDetails getLandDetailsObject() {
		return new LandDetails();
		
	}
	
	
	
	
	
	
}
