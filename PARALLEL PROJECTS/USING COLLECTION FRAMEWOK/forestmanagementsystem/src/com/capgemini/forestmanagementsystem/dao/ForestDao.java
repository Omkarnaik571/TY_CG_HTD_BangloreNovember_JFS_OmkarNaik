package com.capgemini.forestmanagementsystem.dao;

import java.util.Map;

import com.capgemini.forestmanagementsystem.dto.ContractDetails;
import com.capgemini.forestmanagementsystem.dto.CustomerDetail;
import com.capgemini.forestmanagementsystem.dto.LandDetails;
import com.capgemini.forestmanagementsystem.dto.ProductDetails;



public interface ForestDao {


	public Map<Integer, ContractDetails> addTheContractDetails(ContractDetails cdbean);

	public Map<Integer, CustomerDetail> addTheCustomerDetails(CustomerDetail cd);


	public Map<Integer, ProductDetails> addTheProductDetails(ProductDetails pd);

	public Map<Integer, LandDetails> addTheLandDetails(LandDetails ld);

	public Map<Integer, String> addTheClientDetails();

	public Map<Integer, String> getTheClientDetails();

	public Map<Integer, String> addTheSchedulerDetails();

	public Map<Integer, String> getTheSchedulerDetails();


}
