package com.capgemini.stockmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.stockmanagementsystem.dao.StockDao;
import com.capgemini.stockmanagementsystem.dto.StockDetails;

@Service
public class StockServiceImpl implements StockService{

	@Autowired
	StockDao stockDao;
	
	@Override
	public int addCompanyStock(StockDetails stockDetails) {
		if(stockDetails.getAvailableStocks()<stockDetails.getMaxBuyOption()) {
			return 0;
		}
		
		return stockDao.addCompanyStock(stockDetails);
	}

	@Override
	public boolean removeCompanyStock(StockDetails stockDetails) {
		
		return stockDao.removeCompanyStock(stockDetails);
	}

	@Override
	public List<StockDetails> viewAllStockDetails() {
		
		return stockDao.viewAllStockDetails();
	}

	@Override
	public StockDetails viewSingleStock(StockDetails stockDetails) {
		
		return stockDao.viewSingleStock(stockDetails);
	}

	@Override
	public int updateStockDetails(StockDetails stockDetails) {
		if(stockDetails.getAvailableStocks()<=stockDetails.getMaxBuyOption()) {
			return 0;
		}
		return stockDao.updateStockDetails(stockDetails);
	}

	
	
	
	
	
}
