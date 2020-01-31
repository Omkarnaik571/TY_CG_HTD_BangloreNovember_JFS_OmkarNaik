package com.capgemini.stockmanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock_details")
public class StockDetails {

	@Id
	@Column
	@GeneratedValue
	private int stockId;
	@Column(unique = true)
	private String companyName;
	@Column
	private String managerUserName;
	@Column
	private long availableStocks;
	@Column
	private long maxBuyOption;
	@Column
	private double stockPrice;
	
	
	
	
	public String getManagerUserName() {
		return managerUserName;
	}
	public void setManagerUserName(String managerUserName) {
		this.managerUserName = managerUserName;
	}
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public long getAvailableStocks() {
		return availableStocks;
	}
	public void setAvailableStocks(long availableStocks) {
		this.availableStocks = availableStocks;
	}
	public long getMaxBuyOption() {
		return maxBuyOption;
	}
	public void setMaxBuyOption(long maxBuyOption) {
		this.maxBuyOption = maxBuyOption;
	}
	public double getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}
	
	
	
	
	
}
