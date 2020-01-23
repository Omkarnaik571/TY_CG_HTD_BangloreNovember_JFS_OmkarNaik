package com.capgemini.forestmanagementsystem.service;

import java.util.List;

import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public interface ProductService {

	public boolean addProduct(ProductDetailsDto pdt )throws CustomExceptions ;

	public boolean deleteProduct(ProductDetailsDto pdt ) throws CustomExceptions ;

	public boolean modifyProduct(ProductDetailsDto pdt ) throws CustomExceptions;

	public List<ProductDetailsDto> viewAllProduct() throws CustomExceptions;

	public ProductDetailsDto viewParticularProduct(ProductDetailsDto pdt) throws CustomExceptions;
	
	
	
}
