package com.capgemini.forestmanagementsystemusingcollection.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmanagementsystemusingcollection.dto.ProductDetails;

class productDaoTest {

	
	static productDao productDao=new ProductDaoImpl();
	static ProductDetails productDetails=new ProductDetails();
	
	@BeforeAll
	static void testAddProduct() {
		productDetails.setProductId(1);
		productDetails.setProductName("Timber");
		productDao.addProduct(productDetails);
	}
	
	
	@Test
	 void testAddProduct1() {
		productDetails.setProductId(2);
		productDetails.setProductName("Orange");
		boolean isAdded=productDao.addProduct(productDetails);
		assertTrue(isAdded);
	}
	
	@Test
	void testRemoveProduct() {
		ProductDetails productDetails1=new ProductDetails();
		productDetails1.setProductId(2);
		productDetails1.setProductName("Orange");
		productDao.addProduct(productDetails1);
	   boolean isRemoved=productDao.removeProduct(2);
		assertTrue(isRemoved);
		
	}

	@Test
	void testDisplayAllProduct() {
		assertNotNull(productDao.displayAllProduct());	
	}

	@Test
	void testModifyProduct() {
		      boolean isModified=productDao.modifyProduct(productDetails);
		       assertTrue(isModified);
	}

	@Test
	void testGetSingleProduct() {
		   productDetails=productDao.getSingleProduct(1);
		assertNotNull(productDetails);
		
	}

}
