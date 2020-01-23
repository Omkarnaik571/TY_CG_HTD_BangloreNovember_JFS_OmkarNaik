package com.capgemini.forestmanagementsystemusingspringboot;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.forestmanagementsystemusingspringboot.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystemusingspringboot.service.ProductService;
@SpringBootTest
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
