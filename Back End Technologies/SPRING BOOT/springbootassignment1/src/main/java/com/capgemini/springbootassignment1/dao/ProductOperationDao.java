package com.capgemini.springbootassignment1.dao;

import java.util.List;

import com.capgemini.springbootassignment1.dto.ProductBean;

public interface ProductOperationDao {

	public boolean addProduct(ProductBean bean);
	
	public boolean deleteProduct(int id);
	
	public List<ProductBean> getAllProductDetails();
	
	public boolean changeImageUrl(int id,String newUrl);
	
	public boolean changeProductName(int id,String newProductName);
	
	public boolean changeCost(int id,double newCost);
	
}
