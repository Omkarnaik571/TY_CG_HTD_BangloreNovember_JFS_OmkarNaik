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
	
	
	
	
	public boolean addProduct(ProductDetails l) {
		// TODO Auto-generated method stub
		return productDao.addProduct(l);
	}

	
	public boolean removeProduct(Integer landId){
		// TODO Auto-generated method stub
		return productDao.removeProduct(landId);
	}

	
	public TreeMap<Integer, ProductDetails> displayAllProduct() {
		// TODO Auto-generated method stub
		return productDao.displayAllProduct();
	}

	
	public boolean modifyProduct(ProductDetails p) {
		// TODO Auto-generated method stub
		return productDao.modifyProduct(p);
	}

	
	public ProductDetails getSingleProduct(Integer id) {
		// TODO Auto-generated method stub
		return productDao.getSingleProduct(id);
	}

	
}
