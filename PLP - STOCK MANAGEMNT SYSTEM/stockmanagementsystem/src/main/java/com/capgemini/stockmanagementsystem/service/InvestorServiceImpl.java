package com.capgemini.stockmanagementsystem.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.stockmanagementsystem.dao.InvestorDao;
import com.capgemini.stockmanagementsystem.dto.InvestorDetails;
import com.capgemini.stockmanagementsystem.dto.StockDetails;
import com.capgemini.stockmanagementsystem.exception.CustomException;

@Service
public class InvestorServiceImpl implements InvestorService {

	
	@Autowired
	InvestorDao investorDao;
	
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	
	@Override
	public int addInvestor(InvestorDetails investorDetails) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try {
			String addStock="from InvestorDetails where investorUserName=:investorName and companyStockPurchased=:companyStockBought"; 
			Query query=entityManager.createQuery(addStock);
			query.setParameter("investorName", investorDetails.getInvestorUserName());
			query.setParameter("companyStockBought",investorDetails.getCompanyStockPurchased());
			InvestorDetails investorFound =null;
			try {
			investorFound=(InvestorDetails)query.getSingleResult();
			}catch (NoResultException e) {
				
			}
			if(investorFound == null) {
				String company="from StockDetails where companyName=:cName";
				Query companyQuery=entityManager.createQuery(company);
				companyQuery.setParameter("cName", investorDetails.getCompanyStockPurchased());
				StockDetails companyStock=null;
				try {
				 companyStock=(StockDetails) companyQuery.getSingleResult();
				}catch (Exception e) {
					
				}
				if(companyStock==null) {
					return 4;
				}
				 if(companyStock.getMaxBuyOption()<investorDetails.getQuantityBought()) {
					return (int) companyStock.getMaxBuyOption();
					//The buying limit exceeds the max buy option
				}
				investorDetails.setStocksWorth(companyStock.getStockPrice()*investorDetails.getQuantityBought());
				
				return investorDao.addInvestor(investorDetails);
			}
			else {
			//investor with same company stock bought already
				return 0;
			}
		  
	  }catch (Exception e) {
		  e.printStackTrace();
		throw new CustomException("Problem in add Investor service layer !!");
	}	
		
	}

	@Override
	public List<InvestorDetails> viewAllStockDetailsOfAnInvestor(InvestorDetails investorDetails) {
		
		
		return investorDao.viewAllStockDetailsOfAnInvestor(investorDetails);
	}

	@Override
	public int updateSingleInvestorRecord(InvestorDetails investorDetails) {
		
		return investorDao.updateSingleInvestorRecord(investorDetails);
	}

	@Override
	public int buyStock(InvestorDetails investorDetails) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try {
		String addStock="from InvestorDetails where investorUserName=:investorName and companyStockPurchased=:companyStockBought"; 
		Query query=entityManager.createQuery(addStock);
		query.setParameter("investorName", investorDetails.getInvestorUserName());
		query.setParameter("companyStockBought",investorDetails.getCompanyStockPurchased());
		InvestorDetails investorFound=(InvestorDetails) query.getSingleResult();
		investorFound.setQuantityBought(investorFound.getQuantityBought()+investorDetails.getQuantityBought());
		
		String company="from StockDetails where companyName=:cName";
		Query companyQuery=entityManager.createQuery(company);
		companyQuery.setParameter("cName", investorDetails.getCompanyStockPurchased());
		StockDetails companyStock=(StockDetails) companyQuery.getSingleResult();
		
		
		//Check whether buy stock exceeds max buy limit
		System.out.println("\nQuantity present previously = "+investorFound.getQuantityBought());
		System.out.println("\nQuantity want to add more = "+investorDetails.getQuantityBought());
		if(companyStock.getMaxBuyOption()<investorFound.getQuantityBought()) {
			return (int) companyStock.getMaxBuyOption();
			//Your buying limit is exceeding the max buy limit set by company manager
		}
		
		//For updating the stock worth--after buying new stocks
		double stockPrice=companyStock.getStockPrice();
		investorFound.setStocksWorth(investorFound.getQuantityBought()*stockPrice);
		
		
		return investorDao.buyStock(investorFound);
		}
		catch (Exception e) {
			throw new CustomException("Problem in buyStock() investor service layer !!");
		}
		
		
		
	}

	@Override
	public int sellStock(InvestorDetails investorDetails) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try {
			String addStock="from InvestorDetails where investorUserName=:investorName and companyStockPurchased=:companyStockBought"; 
			Query query=entityManager.createQuery(addStock);
			query.setParameter("investorName", investorDetails.getInvestorUserName());
			query.setParameter("companyStockBought",investorDetails.getCompanyStockPurchased());
			InvestorDetails investorFound=(InvestorDetails) query.getSingleResult();
			
			//Checking whether sell stock item is more than available stock for investor
			if(investorDetails.getQuantityBought()>investorFound.getQuantityBought()) {
				return 2;
			}
			
			investorFound.setQuantityBought(investorFound.getQuantityBought()-investorDetails.getQuantityBought());
			
			
			String company="from StockDetails where companyName=:cName";
			Query companyQuery=entityManager.createQuery(company);
			companyQuery.setParameter("cName", investorDetails.getCompanyStockPurchased());
			
			//For updating the stock worth--after selling stocks
			StockDetails companyStock=(StockDetails) companyQuery.getSingleResult();
			double stockPrice=companyStock.getStockPrice();
			investorFound.setStocksWorth(investorFound.getQuantityBought()*stockPrice);
			
			
			return investorDao.sellStock(investorFound);
		}catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("Problem in sellStock() investor service layer !!");
		}
		
		
		
		
	}
	
	
	
}
