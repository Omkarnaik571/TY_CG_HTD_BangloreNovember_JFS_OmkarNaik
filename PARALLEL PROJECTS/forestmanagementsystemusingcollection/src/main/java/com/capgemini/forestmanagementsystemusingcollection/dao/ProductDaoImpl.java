package com.capgemini.forestmanagementsystemusingcollection.dao;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.ProductDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.DisplayingDataWithoutEntry;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileModifying;

public class ProductDaoImpl implements productDao {

	TreeMap<Integer,ProductDetails> mapForProduct= new TreeMap<Integer,ProductDetails>();
	
	
	@Override
	public boolean addProduct(ProductDetails l) throws ExceptionWhileInserting {
		if(mapForProduct.containsKey(l.getProductId())) {
			throw new ExceptionWhileInserting("The Product id that you have entered is alreday present ");
		} else {

			mapForProduct.put(l.getProductId(),l);
			return true;
		}
				
	}

	@Override
	public boolean removeProduct(Integer landId) throws ExceptionWhileDeleting {
		if(mapForProduct.containsKey(landId)){
			mapForProduct.remove(landId);
			return true;
		} else {
			throw new ExceptionWhileDeleting("The product id that you have entered is not present");
		}
		
	}

	@Override
	public TreeMap<Integer, ProductDetails> displayAllProduct() throws ExceptionWhileDisplaying {
		if(mapForProduct.size()!=0) {
			return mapForProduct;
		}
		else {
			throw new ExceptionWhileDisplaying("There are no products present in the database ");
		}
		
	}

	@Override
	public boolean modifyProduct(ProductDetails p) throws ExceptionWhileModifying {
		if(mapForProduct.containsKey(p.getProductId())) {
			mapForProduct.put(p.getProductId(), p);
			return true;
		}
		throw new ExceptionWhileModifying("The product id that you have entered is not present !! ");
		
		
	}

	@Override
	public ProductDetails getSingleProduct(Integer id) throws ExceptionWhileDisplaying {
		if(mapForProduct.containsKey(id)) {
			return mapForProduct.get(id);
		}
		throw new ExceptionWhileDisplaying("The product id that you have entered is not present !!");
		
	}

}
