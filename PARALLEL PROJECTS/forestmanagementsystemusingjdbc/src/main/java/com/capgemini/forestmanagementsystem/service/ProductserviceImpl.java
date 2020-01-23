package com.capgemini.forestmanagementsystem.service;

import java.util.List;

import com.capgemini.forestmanagementsystem.dao.ProductDao;
import com.capgemini.forestmanagementsystem.dao.ProductDaoImpl;
import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public class ProductserviceImpl implements ProductService {

	ProductDao dao = new ProductDaoImpl();

	@Override
	public boolean addProduct(ProductDetailsDto pdt) throws CustomExceptions {
		
		return dao.addProduct(pdt);
	}

	@Override
	public boolean deleteProduct(ProductDetailsDto pdt) throws CustomExceptions {
		
		return dao.deleteProduct(pdt);
	}

	@Override
	public boolean modifyProduct(ProductDetailsDto pdt) throws CustomExceptions {
		
		return dao.modifyProduct(pdt);
	}

	@Override
	public List<ProductDetailsDto> viewAllProduct() throws CustomExceptions {
		
		return dao.viewAllProduct();
	}

	@Override
	public ProductDetailsDto viewParticularProduct(ProductDetailsDto pdd) throws CustomExceptions {
		
		return dao.viewParticularProduct(pdd);
	}

}
