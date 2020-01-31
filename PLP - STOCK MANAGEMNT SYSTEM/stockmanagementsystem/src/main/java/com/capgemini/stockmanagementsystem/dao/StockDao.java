package com.capgemini.stockmanagementsystem.dao;

import java.util.List;

import com.capgemini.stockmanagementsystem.dto.StockDetails;

public interface StockDao {

	
	public int addCompanyStock(StockDetails stockDetails);
	
	public boolean removeCompanyStock(StockDetails stockDetails);
	
	public List<StockDetails> viewAllStockDetails ();
	
	public StockDetails viewSingleStock(StockDetails stockDetails);
	
	public int updateStockDetails(StockDetails stockDetails);
	
}
