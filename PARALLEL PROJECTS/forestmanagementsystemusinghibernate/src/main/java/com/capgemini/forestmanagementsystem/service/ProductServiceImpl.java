package com.capgemini.forestmanagementsystem.service;

import java.util.List;

import com.capgemini.forestmanagementsystem.dao.ProductDao;
import com.capgemini.forestmanagementsystem.dao.ProductDetailsDaoImpl;
import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public class ProductServiceImpl implements ProductService {

	ProductDao dao=new ProductDetailsDaoImpl();
	
	
	public boolean addProduct(ProductDetailsDto pdt) throws CustomExceptions {
		
		return dao.addProduct(pdt);
	}

	public boolean deleteProduct(ProductDetailsDto pdt) throws CustomExceptions {
		
		return dao.deleteProduct(pdt);
	}

	public boolean modifyProduct(ProductDetailsDto pdt) throws CustomExceptions {
		
		return dao.modifyProduct(pdt);
	}

	public List<ProductDetailsDto> viewAllProduct() throws CustomExceptions {
		
		return dao.viewAllProduct();
	}

	public ProductDetailsDto viewParticularProduct(ProductDetailsDto pdt) throws CustomExceptions {
		System.out.println("Service is being executed..");
		return dao.viewParticularProduct(pdt);
	}

	
	
	
	
	
	
	
}
