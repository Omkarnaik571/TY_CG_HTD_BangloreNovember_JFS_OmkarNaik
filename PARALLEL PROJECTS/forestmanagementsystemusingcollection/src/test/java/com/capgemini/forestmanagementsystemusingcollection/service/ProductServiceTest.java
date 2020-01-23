package com.capgemini.forestmanagementsystemusingcollection.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import com.capgemini.forestmanagementsystemusingcollection.dto.ProductDetails;

class ProductServiceTest {

	static ProductService productService=new ProductServiceImpl();
	static ProductDetails productDetails=new ProductDetails();
	
	@BeforeAll
	static void testAddProduct() {
		productDetails.setProductId(1);
		productDetails.setProductName("Timber");
		productService.addProduct(productDetails);
	}
	
	
	@Test
	 void testAddProduct1() {
		productDetails.setProductId(2);
		productDetails.setProductName("Orange");
		boolean isAdded=productService.addProduct(productDetails);
		assertTrue(isAdded);
	}
	
	@Test
	void testRemoveProduct() {
		ProductDetails productDetails1=new ProductDetails();
		productDetails1.setProductId(2);
		productDetails1.setProductName("Orange");
		productService.addProduct(productDetails1);
	   boolean isRemoved=productService.removeProduct(2);
		assertTrue(isRemoved);
		
	}

	@Test
	void testDisplayAllProduct() {
		assertNotNull(productService.displayAllProduct());	
	}

	@Test
	void testModifyProduct() {
		      boolean isModified=productService.modifyProduct(productDetails);
		       assertTrue(isModified);
	}

	@Test
	void testGetSingleProduct() {
		   productDetails=productService.getSingleProduct(1);
		assertNotNull(productDetails);
		
	}

}
