package com.capgemini.springbootassignment1.service;

import java.util.List;

import com.capgemini.springbootassignment1.dto.ProductBean;


public interface ProductOperationService {

	public boolean addProduct(ProductBean bean);

	public boolean deleteProduct(int id);

	public List<ProductBean> getAllProductDetails();

	public boolean changeImageUrl(int id,String newUrl);

	public boolean changeProductName(int id,String newProductName);

	public boolean changeCost(int id,double newCost);



}
