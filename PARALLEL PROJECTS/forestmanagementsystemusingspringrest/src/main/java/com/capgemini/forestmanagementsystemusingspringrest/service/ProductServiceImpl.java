package com.capgemini.forestmanagementsystemusingspringrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestmanagementsystemusingspringrest.dao.ProductDao;
import com.capgemini.forestmanagementsystemusingspringrest.dao.ProductDetailsDaoImpl;
import com.capgemini.forestmanagementsystemusingspringrest.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystemusingspringrest.exception.CustomExceptions;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;
	
	
	public boolean addProduct(ProductDetailsDto pdt) throws CustomExceptions {
		
		return productDao.addProduct(pdt);
	}

	public boolean deleteProduct(int productId) throws CustomExceptions {
		
		return productDao.deleteProduct(productId);
	}

	public boolean modifyProduct(ProductDetailsDto pdt) throws CustomExceptions {
		
		return productDao.modifyProduct(pdt);
	}

	public List<ProductDetailsDto> viewAllProduct() throws CustomExceptions {
		
		return productDao.viewAllProduct();
	}

	public ProductDetailsDto viewParticularProduct(int productId) throws CustomExceptions {
		return productDao.viewParticularProduct(productId);
	}

	
	
	
	
	
	
	
}
