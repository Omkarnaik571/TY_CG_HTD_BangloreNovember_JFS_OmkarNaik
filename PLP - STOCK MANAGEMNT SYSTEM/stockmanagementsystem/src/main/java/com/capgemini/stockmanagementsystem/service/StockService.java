package com.capgemini.stockmanagementsystem.service;

import java.util.List;

import com.capgemini.stockmanagementsystem.dto.StockDetails;

public interface StockService {

	public int addCompanyStock(StockDetails stockDetails);

	public boolean removeCompanyStock(StockDetails stockDetails);

	public List<StockDetails> viewAllStockDetails();

	public StockDetails viewSingleStock(StockDetails stockDetails);

	public int updateStockDetails(StockDetails stockDetails);

}
