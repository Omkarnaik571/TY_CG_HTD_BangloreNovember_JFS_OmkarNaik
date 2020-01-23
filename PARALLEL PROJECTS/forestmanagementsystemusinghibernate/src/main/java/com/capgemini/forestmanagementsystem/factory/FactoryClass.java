package com.capgemini.forestmanagementsystem.factory;

import java.util.List;

import com.capgemini.forestmanagementsystem.dao.ContractorDetailsDao;
import com.capgemini.forestmanagementsystem.dao.CustomerDetailsDao;
import com.capgemini.forestmanagementsystem.dao.LandDao;
import com.capgemini.forestmanagementsystem.dao.ProductDao;
import com.capgemini.forestmanagementsystem.dao.ProductDetailsDaoImpl;
import com.capgemini.forestmanagementsystem.dto.AuthenticationDetailsDto;
import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.dto.CustomerDetailsDto;
import com.capgemini.forestmanagementsystem.dto.LandDetailsDto;
import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;
import com.capgemini.forestmanagementsystem.service.AuthenticationService;
import com.capgemini.forestmanagementsystem.service.AuthenticationServiceImpl;
import com.capgemini.forestmanagementsystem.service.ContractService;
import com.capgemini.forestmanagementsystem.service.ContractorServiceImpl;
import com.capgemini.forestmanagementsystem.service.CustomerService;
import com.capgemini.forestmanagementsystem.service.CustomerServiceImpl;
import com.capgemini.forestmanagementsystem.service.ProductService;
import com.capgemini.forestmanagementsystem.service.ProductServiceImpl;

public class FactoryClass {
    //1. Authentication Service Impl method
	public static AuthenticationService  getAuthenticationServiceImpl() {
		return new AuthenticationServiceImpl();
	}
	
	public static AuthenticationDetailsDto  getAuthenticationDetailsObject() {
		return new AuthenticationDetailsDto();
	}
	
	
	       

	//2. Contractor details dto object
	public static ContractorDetailsDto  getContractorDetailsDto() {
		return new ContractorDetailsDto();
	}

	//3. customer details dto object
	public static CustomerDetailsDto  getCustomerDetailsDto() {
		return new CustomerDetailsDto();
	}


	//4. Land details dto object
	public static LandDetailsDto  getLandDetailsDto() {
		return new LandDetailsDto();
	}


	//5. Product details dto object
	public static ProductDetailsDto  getProductDetailsDto() {
		return new ProductDetailsDto();
	}

	//6. product details service impl object
	public static ProductService  getProductDetailsServiceImpl() {
		return new ProductServiceImpl();
	}

	//7. contract details service impl object
	public static ContractService  getContractDetailsServiceImpl() {
		return new ContractorServiceImpl();
	}

	//8. customer details service impl object
	public static CustomerService  getCustomerDetailsServiceImpl() {
		return new CustomerServiceImpl();
	}

	



}
