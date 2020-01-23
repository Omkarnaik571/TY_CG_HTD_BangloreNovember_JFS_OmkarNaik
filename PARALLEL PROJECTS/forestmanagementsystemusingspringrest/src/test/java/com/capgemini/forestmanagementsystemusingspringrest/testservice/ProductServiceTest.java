package com.capgemini.forestmanagementsystemusingspringrest.testservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestmanagementsystemusingspringrest.config.OrmConfig;
import com.capgemini.forestmanagementsystemusingspringrest.dao.ProductDao;
import com.capgemini.forestmanagementsystemusingspringrest.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystemusingspringrest.service.ProductService;
import com.capgemini.forestmanagementsystemusingspringrest.testconfig.TestBeans;
@SpringJUnitConfig(classes = { TestBeans.class, OrmConfig.class })
class ProductServiceTest {

	
	

	@Autowired
	ProductService productService;
	
	
	@Test
	void testAddProduct() {
		ProductDetailsDto productDetailsDto=new ProductDetailsDto();
		productDetailsDto.setProductId(77);
		productDetailsDto.setProductName("Oak Tree");
		
		boolean isAdded=productService.addProduct(productDetailsDto);
		assertTrue(isAdded);
		productService.deleteProduct(productDetailsDto.getProductId());
		
	}

	@Test
	void testDeleteProduct() {
		ProductDetailsDto productDetailsDto=new ProductDetailsDto();
		productDetailsDto.setProductId(77);
		productDetailsDto.setProductName("Oak Tree");
		productService.addProduct(productDetailsDto);
		boolean isDeleted=productService.deleteProduct(productDetailsDto.getProductId());
		assertTrue(isDeleted);
	}

	@Test
	void testModifyProduct() {
		ProductDetailsDto productDetailsDto=new ProductDetailsDto();
		productDetailsDto.setProductId(77);
		productDetailsDto.setProductName("Oak Tree");
		productService.addProduct(productDetailsDto);
		boolean isModified=productService.modifyProduct(productDetailsDto);
		assertTrue(isModified);
		productService.deleteProduct(productDetailsDto.getProductId());
	}

	@Test
	void testViewAllProduct() {
		assertNotNull(productService.viewAllProduct());
	}

	@Test
	void testViewParticularProduct() {
		ProductDetailsDto productDetailsDto=new ProductDetailsDto();
		productDetailsDto.setProductId(77);
		productDetailsDto.setProductName("Oak Tree");
		productService.addProduct(productDetailsDto);
		assertNotNull(productService.viewParticularProduct(productDetailsDto.getProductId()));
		productService.deleteProduct(productDetailsDto.getProductId());
	}

	
	

}
