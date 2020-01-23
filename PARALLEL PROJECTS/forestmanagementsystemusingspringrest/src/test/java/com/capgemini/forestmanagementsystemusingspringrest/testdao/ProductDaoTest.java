package com.capgemini.forestmanagementsystemusingspringrest.testdao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestmanagementsystemusingspringrest.config.OrmConfig;
import com.capgemini.forestmanagementsystemusingspringrest.dao.LandDao;
import com.capgemini.forestmanagementsystemusingspringrest.dao.ProductDao;
import com.capgemini.forestmanagementsystemusingspringrest.dto.LandDetailsDto;
import com.capgemini.forestmanagementsystemusingspringrest.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystemusingspringrest.testconfig.TestBeans;
@SpringJUnitConfig(classes = { TestBeans.class, OrmConfig.class })
class ProductDaoTest {

	
	@Autowired
	ProductDao productDao;
	
	
	@Test
	void testAddProduct() {
		ProductDetailsDto productDetailsDto=new ProductDetailsDto();
		productDetailsDto.setProductId(77);
		productDetailsDto.setProductName("Oak Tree");
		
		boolean isAdded=productDao.addProduct(productDetailsDto);
		assertTrue(isAdded);
		productDao.deleteProduct(productDetailsDto.getProductId());
		
	}

	@Test
	void testDeleteProduct() {
		ProductDetailsDto productDetailsDto=new ProductDetailsDto();
		productDetailsDto.setProductId(77);
		productDetailsDto.setProductName("Oak Tree");
		productDao.addProduct(productDetailsDto);
		boolean isDeleted=productDao.deleteProduct(productDetailsDto.getProductId());
		assertTrue(isDeleted);
	}

	@Test
	void testModifyProduct() {
		ProductDetailsDto productDetailsDto=new ProductDetailsDto();
		productDetailsDto.setProductId(77);
		productDetailsDto.setProductName("Oak Tree");
		productDao.addProduct(productDetailsDto);
		boolean isModified=productDao.modifyProduct(productDetailsDto);
		assertTrue(isModified);
		productDao.deleteProduct(productDetailsDto.getProductId());
	}

	@Test
	void testViewAllProduct() {
		assertNotNull(productDao.viewAllProduct());
	}

	@Test
	void testViewParticularProduct() {
		ProductDetailsDto productDetailsDto=new ProductDetailsDto();
		productDetailsDto.setProductId(77);
		productDetailsDto.setProductName("Oak Tree");
		productDao.addProduct(productDetailsDto);
		assertNotNull(productDao.viewParticularProduct(productDetailsDto.getProductId()));
		productDao.deleteProduct(productDetailsDto.getProductId());
	}

}
