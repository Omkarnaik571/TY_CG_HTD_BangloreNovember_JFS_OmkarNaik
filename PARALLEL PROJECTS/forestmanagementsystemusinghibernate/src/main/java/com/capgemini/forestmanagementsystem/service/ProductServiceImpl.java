package com.capgemini.forestmanagementsystem.service;

import java.util.List;

import com.capgemini.forestmanagementsystem.dao.ProductDao;
import com.capgemini.forestmanagementsystem.dao.ProductDetailsDaoImpl;
import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public class ProductServiceImpl implements ProductService {

	ProductDao productDao=new ProductDetailsDaoImpl();
	
	
	public boolean addProduct(ProductDetailsDto pdt) throws CustomExceptions {
		
		return productDao.addProduct(pdt);
	}

	public boolean deleteProduct(ProductDetailsDto pdt) throws CustomExceptions {
		
		return productDao.deleteProduct(pdt);
	}

	public boolean modifyProduct(ProductDetailsDto pdt) throws CustomExceptions {
		
		return productDao.modifyProduct(pdt);
	}

	public List<ProductDetailsDto> viewAllProduct() throws CustomExceptions {
		
		return productDao.viewAllProduct();
	}

	public ProductDetailsDto viewParticularProduct(ProductDetailsDto pdt) throws CustomExceptions {
		return productDao.viewParticularProduct(pdt);
	}

	
	
	
	
	
	
	
}
