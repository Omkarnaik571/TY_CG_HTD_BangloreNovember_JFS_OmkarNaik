package com.capgemini.stockmanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "investor_details")
public class InvestorDetails {
	@Id
	@GeneratedValue
	@Column
	private int investorId;
	@Column
	private String investorUserName;
	@Column
	private String companyStockPurchased;
	@Column
	private long quantityBought;
	@Column
	private double stocksWorth;
	public String getInvestorUserName() {
		return investorUserName;
	}
	public void setInvestorUserName(String investorUserName) {
		this.investorUserName = investorUserName;
	}
	public String getCompanyStockPurchased() {
		return companyStockPurchased;
	}
	public void setCompanyStockPurchased(String companyStockPurchased) {
		this.companyStockPurchased = companyStockPurchased;
	}
	public long getQuantityBought() {
		return quantityBought;
	}
	public void setQuantityBought(long quantityBought) {
		this.quantityBought = quantityBought;
	}
	public double getStocksWorth() {
		return stocksWorth;
	}
	public void setStocksWorth(double stocksWorth) {
		this.stocksWorth = stocksWorth;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyStockPurchased == null) ? 0 : companyStockPurchased.hashCode());
		result = prime * result + investorId;
		result = prime * result + ((investorUserName == null) ? 0 : investorUserName.hashCode());
		result = prime * result + (int) (quantityBought ^ (quantityBought >>> 32));
		long temp;
		temp = Double.doubleToLongBits(stocksWorth);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	public int getInvestorId() {
		return investorId;
	}
	public void setInvestorId(int investorId) {
		this.investorId = investorId;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvestorDetails other = (InvestorDetails) obj;
		if (companyStockPurchased == null) {
			if (other.companyStockPurchased != null)
				return false;
		} else if (!companyStockPurchased.equals(other.companyStockPurchased))
			return false;
		if (investorId != other.investorId)
			return false;
		if (investorUserName == null) {
			if (other.investorUserName != null)
				return false;
		} else if (!investorUserName.equals(other.investorUserName))
			return false;
		if (quantityBought != other.quantityBought)
			return false;
		if (Double.doubleToLongBits(stocksWorth) != Double.doubleToLongBits(other.stocksWorth))
			return false;
		return true;
	}
	
	
	
	
	
	
}
