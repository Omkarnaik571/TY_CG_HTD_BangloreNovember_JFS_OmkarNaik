package com.capgemini.forestmanagementsystem.dao;

import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public interface ProductDao {

	public boolean addProduct(ProductDetailsDto pdt )throws CustomExceptions ;

	public boolean deleteProduct(ProductDetailsDto pdt ) ;

	public boolean modifyProduct(ProductDetailsDto pdt );

	public boolean viewAllProduct();

	public boolean viewParticularProduct();



}
