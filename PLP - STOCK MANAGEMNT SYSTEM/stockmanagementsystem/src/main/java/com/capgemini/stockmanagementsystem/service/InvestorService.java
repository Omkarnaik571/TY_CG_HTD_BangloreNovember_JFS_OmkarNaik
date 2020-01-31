package com.capgemini.stockmanagementsystem.service;

import java.util.List;

import com.capgemini.stockmanagementsystem.dto.InvestorDetails;

public interface InvestorService {

	public int addInvestor(InvestorDetails investorDetails);


	public int updateSingleInvestorRecord(InvestorDetails investorDetails);

	public int buyStock(InvestorDetails investorDetails);

	public int sellStock(InvestorDetails investorDetails);

	List<InvestorDetails> viewAllStockDetailsOfAnInvestor(InvestorDetails investorDetails);

}
