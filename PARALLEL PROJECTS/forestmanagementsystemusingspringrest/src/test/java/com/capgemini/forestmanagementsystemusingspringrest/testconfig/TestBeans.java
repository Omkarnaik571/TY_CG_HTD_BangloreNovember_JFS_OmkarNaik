package com.capgemini.forestmanagementsystemusingspringrest.testconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.capgemini.forestmanagementsystemusingspringrest.dao.AuthenticationDetailsDao;
import com.capgemini.forestmanagementsystemusingspringrest.dao.AuthenticationDetailsDaoImpl;
import com.capgemini.forestmanagementsystemusingspringrest.dao.ContractDetailsDaoImpl;
import com.capgemini.forestmanagementsystemusingspringrest.dao.ContractorDetailsDao;
import com.capgemini.forestmanagementsystemusingspringrest.dao.CustomerDetailsDao;
import com.capgemini.forestmanagementsystemusingspringrest.dao.CustomerDetailsDaoImpl;
import com.capgemini.forestmanagementsystemusingspringrest.dao.LandDao;
import com.capgemini.forestmanagementsystemusingspringrest.dao.LandDaoImpl;
import com.capgemini.forestmanagementsystemusingspringrest.dao.ProductDao;
import com.capgemini.forestmanagementsystemusingspringrest.dao.ProductDetailsDaoImpl;
import com.capgemini.forestmanagementsystemusingspringrest.service.AuthenticationService;
import com.capgemini.forestmanagementsystemusingspringrest.service.AuthenticationServiceImpl;
import com.capgemini.forestmanagementsystemusingspringrest.service.ContractService;
import com.capgemini.forestmanagementsystemusingspringrest.service.ContractorServiceImpl;
import com.capgemini.forestmanagementsystemusingspringrest.service.CustomerService;
import com.capgemini.forestmanagementsystemusingspringrest.service.CustomerServiceImpl;
import com.capgemini.forestmanagementsystemusingspringrest.service.LandService;
import com.capgemini.forestmanagementsystemusingspringrest.service.LandServiceImpl;
import com.capgemini.forestmanagementsystemusingspringrest.service.ProductService;
import com.capgemini.forestmanagementsystemusingspringrest.service.ProductServiceImpl;

@Configuration
public class TestBeans {
	
   @Bean	
  public AuthenticationDetailsDao authenticationDetailsDao() {
		return new AuthenticationDetailsDaoImpl();
	}
   @Bean
  public ContractorDetailsDao contractorDetailsDao() {
	  return new ContractDetailsDaoImpl();
  }
   @Bean
 public CustomerDetailsDao customerDetailsDao() {
	 return new CustomerDetailsDaoImpl();
 }	
   @Bean
 public LandDao landDao() {
	 return new LandDaoImpl();
 }	
   @Bean
 public ProductDao productDao() {
	 return new ProductDetailsDaoImpl();
 }	
   
    @Bean
  public AuthenticationService authenticationService() {
	  return new AuthenticationServiceImpl();
  } 
    @Bean
    public ContractService contractService() {
    	return new ContractorServiceImpl();
    }
   
   @Bean
    public CustomerService customerService() {
    	return new CustomerServiceImpl();
    }
   @Bean
   public LandService landService() {
	   return new LandServiceImpl();
   }
   
   @Bean
   public ProductService productService() {
	   return new ProductServiceImpl();
   }
    
   
      
}
