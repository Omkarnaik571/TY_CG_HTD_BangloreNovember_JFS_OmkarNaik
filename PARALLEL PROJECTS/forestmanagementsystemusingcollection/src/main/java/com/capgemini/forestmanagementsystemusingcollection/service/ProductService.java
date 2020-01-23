package com.capgemini.forestmanagementsystemusingcollection.service;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.ProductDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileModifying;

public interface ProductService {

	public boolean addProduct(ProductDetails l) throws ExceptionWhileInserting;

	public boolean removeProduct(Integer landId) throws ExceptionWhileDeleting;

	public TreeMap<Integer,ProductDetails> displayAllProduct() throws ExceptionWhileDisplaying;
	
	public boolean modifyProduct(ProductDetails p) throws ExceptionWhileModifying;
	
	public ProductDetails getSingleProduct(Integer id) throws ExceptionWhileDisplaying;
	
}
