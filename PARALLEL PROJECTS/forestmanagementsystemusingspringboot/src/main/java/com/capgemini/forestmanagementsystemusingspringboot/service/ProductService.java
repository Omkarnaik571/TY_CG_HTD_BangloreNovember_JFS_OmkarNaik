package com.capgemini.forestmanagementsystemusingspringboot.service;

import java.util.List;

import com.capgemini.forestmanagementsystemusingspringboot.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystemusingspringboot.exception.CustomExceptions;

public interface ProductService {

	public boolean addProduct(ProductDetailsDto pdt )throws CustomExceptions ;

	public boolean deleteProduct(int productId ) throws CustomExceptions ;

	public boolean modifyProduct(ProductDetailsDto pdt ) throws CustomExceptions;

	public List<ProductDetailsDto> viewAllProduct() throws CustomExceptions;

	public ProductDetailsDto viewParticularProduct(int productId) throws CustomExceptions;
	
	
	
}
