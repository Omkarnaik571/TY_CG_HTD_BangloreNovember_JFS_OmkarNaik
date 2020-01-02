package com.capgemini.springbootassignment1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.springbootassignment1.dao.ProductOperationDao;
import com.capgemini.springbootassignment1.dto.ProductBean;

@Service
public class ProductOperationServiceImpl implements ProductOperationService {

	@Autowired
	private ProductOperationDao dao;
	
	
	@Override
	public boolean addProduct(ProductBean bean) {
		
		return dao.addProduct(bean);
	}


	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		return dao.deleteProduct(id);
	}


	@Override
	public List<ProductBean> getAllProductDetails() {
		// TODO Auto-generated method stub
		return dao.getAllProductDetails();
	}


	@Override
	public boolean changeImageUrl(int id, String newUrl) {
		// TODO Auto-generated method stub
		return dao.changeImageUrl(id, newUrl);
	}


	@Override
	public boolean changeProductName(int id, String newProductName) {
		// TODO Auto-generated method stub
		return dao.changeProductName(id, newProductName);
	}


	@Override
	public boolean changeCost(int id, double newCost) {
		// TODO Auto-generated method stub
		return changeCost(id, newCost);
	}

}
