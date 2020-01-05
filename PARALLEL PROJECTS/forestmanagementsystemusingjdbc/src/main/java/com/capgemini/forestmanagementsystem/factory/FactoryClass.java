package com.capgemini.forestmanagementsystem.factory;

import com.capgemini.forestmanagementsystem.dao.ClientDetailsDao;
import com.capgemini.forestmanagementsystem.dao.ClientDetailsDaoImpl;
import com.capgemini.forestmanagementsystem.dao.ContractorDetailsDao;
import com.capgemini.forestmanagementsystem.dao.ContractorDetailsDaoImpl;
import com.capgemini.forestmanagementsystem.dao.CustomerDetailsDao;
import com.capgemini.forestmanagementsystem.dao.CustomerDetailsDaoImpl;
import com.capgemini.forestmanagementsystem.dao.LandDao;
import com.capgemini.forestmanagementsystem.dao.LandDaoImpl;
import com.capgemini.forestmanagementsystem.dao.ProductDao;
import com.capgemini.forestmanagementsystem.dao.ProductDaoImpl;
import com.capgemini.forestmanagementsystem.dao.SchedulerDetailsDao;
import com.capgemini.forestmanagementsystem.dao.SchedulerDetailsDaoImpl;
import com.capgemini.forestmanagementsystem.dto.ClientDetailsDto;
import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.dto.CustomerDetailsDto;
import com.capgemini.forestmanagementsystem.dto.LandDetailsDto;
import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.dto.SchedulerDetailsDto;

public class FactoryClass {


	//1. client details dto object
	public static ClientDetailsDto getClientDetailsDto() {
		return new ClientDetailsDto();
	}

	//. Scheduler details dto
	public static SchedulerDetailsDto getSchedulerDetailsDto() {
		return new SchedulerDetailsDto();
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


	//6. Get Client details dao impl object
	public static ClientDetailsDao getClientDetailsDaoImpl() {
		return new ClientDetailsDaoImpl();
	}

	//7. Get Customer details dao impl object
	public static CustomerDetailsDao getCustomerDetailsDaoImpl() {
		return new CustomerDetailsDaoImpl();
	}

	//8. Get land details dao impl object
	public static LandDao getLandDaoImpl() {
		return new LandDaoImpl();
	}

	//9. Get contractor details dao impl object
	public static ContractorDetailsDao getContractorDaoImpl() {
		return new ContractorDetailsDaoImpl();
	}

	//10. Get product details dao impl object
	public static ProductDao getProductDaoImpl() {
		return new ProductDaoImpl();
	}			

   //get scheduler details dao impl object

	public static SchedulerDetailsDao getSchedulerDetailsDaoImplObject() {
		return new SchedulerDetailsDaoImpl();
	}

}
