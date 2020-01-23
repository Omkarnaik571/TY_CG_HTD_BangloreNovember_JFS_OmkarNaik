package com.capgemini.forestmanagementsystemusingspringrest.dao;

import java.util.List;

import com.capgemini.forestmanagementsystemusingspringrest.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystemusingspringrest.exception.CustomExceptions;

public interface ProductDao {

	public boolean addProduct(ProductDetailsDto pdt )throws CustomExceptions ;

	public boolean deleteProduct(int productId ) throws CustomExceptions ;

	public boolean modifyProduct(ProductDetailsDto pdt ) throws CustomExceptions;

	public List<ProductDetailsDto> viewAllProduct() throws CustomExceptions;

	public ProductDetailsDto viewParticularProduct(int productId) throws CustomExceptions;



}
