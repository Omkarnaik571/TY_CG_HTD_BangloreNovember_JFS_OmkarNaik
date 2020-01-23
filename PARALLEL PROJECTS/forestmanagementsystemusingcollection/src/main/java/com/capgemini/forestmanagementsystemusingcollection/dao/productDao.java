package com.capgemini.forestmanagementsystemusingcollection.dao;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.ProductDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileModifying;

public interface productDao {

	public boolean addProduct(ProductDetails l) ;

	public boolean removeProduct(Integer landId) ;

	public TreeMap<Integer,ProductDetails> displayAllProduct() ;
	
	public boolean modifyProduct(ProductDetails p) ;
	
	public ProductDetails getSingleProduct(Integer id) ;
	
	
	
}
