package com.capgemini.forestmanagementsystemusingcollection.service;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dao.ProductDaoImpl;
import com.capgemini.forestmanagementsystemusingcollection.dao.productDao;
import com.capgemini.forestmanagementsystemusingcollection.dto.ProductDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileModifying;

public class ProductServiceImpl implements ProductService{

	productDao productDao =new ProductDaoImpl();
	
	
	
	@Override
	public boolean addProduct(ProductDetails l) throws ExceptionWhileInserting {
		// TODO Auto-generated method stub
		return productDao.addProduct(l);
	}

	@Override
	public boolean removeProduct(Integer landId) throws ExceptionWhileDeleting {
		// TODO Auto-generated method stub
		return productDao.removeProduct(landId);
	}

	@Override
	public TreeMap<Integer, ProductDetails> displayAllProduct() throws ExceptionWhileDisplaying {
		// TODO Auto-generated method stub
		return productDao.displayAllProduct();
	}

	@Override
	public boolean modifyProduct(ProductDetails p) throws ExceptionWhileModifying {
		// TODO Auto-generated method stub
		return productDao.modifyProduct(p);
	}

	@Override
	public ProductDetails getSingleProduct(Integer id) throws ExceptionWhileDisplaying {
		// TODO Auto-generated method stub
		return productDao.getSingleProduct(id);
	}

	
}
