package com.capgemini.stockmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.stockmanagementsystem.dto.InvestorDetails;
import com.capgemini.stockmanagementsystem.dto.StockDetails;
import com.capgemini.stockmanagementsystem.exception.CustomException;
@Repository
public class InvestorDaoImpl implements InvestorDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	
	@Override
	public int addInvestor(InvestorDetails investorDetails) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(investorDetails);
			transaction.commit();
			return 1;
			
		}catch (Exception e) {
			throw new CustomException("Stock buy operation failed !!");
		}
		
	}

	

	@Override
	public List<InvestorDetails> viewAllStockDetailsOfAnInvestor(InvestorDetails investorDetails) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		try {
			String jpql="from InvestorDetails where investorUserName=:investorUserName";
			Query query=entityManager.createQuery(jpql);
			query.setParameter("investorUserName",investorDetails.getInvestorUserName());
			List<InvestorDetails> allStockDetails=query.getResultList();
			return allStockDetails;
			
		}catch (Exception e) {
			throw new CustomException("There are no Stock details found");
		}
	}

	@Override
	public int updateSingleInvestorRecord(InvestorDetails investorDetails) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int buyStock(InvestorDetails investorDetails) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {		
			transaction.begin();
			InvestorDetails updateBuyStock=entityManager.find(InvestorDetails.class, investorDetails.getInvestorId());
			updateBuyStock.setInvestorUserName(investorDetails.getInvestorUserName());
			updateBuyStock.setCompanyStockPurchased(investorDetails.getCompanyStockPurchased());
			updateBuyStock.setQuantityBought(investorDetails.getQuantityBought());
			updateBuyStock.setStocksWorth(investorDetails.getStocksWorth());
		     entityManager.persist(updateBuyStock);
			transaction.commit();
		
		}
		catch (Exception e) {
			throw new CustomException("Stock buy option failed in dao layer !!");
		}
		return 1;
	}



	@Override
	public int sellStock(InvestorDetails investorDetails) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
		
		transaction.begin();
		InvestorDetails updateBuyStock=entityManager.find(InvestorDetails.class, investorDetails.getInvestorId());
		updateBuyStock.setInvestorUserName(investorDetails.getInvestorUserName());
		updateBuyStock.setCompanyStockPurchased(investorDetails.getCompanyStockPurchased());
		updateBuyStock.setQuantityBought(investorDetails.getQuantityBought());
		updateBuyStock.setStocksWorth(investorDetails.getStocksWorth());
	     entityManager.persist(updateBuyStock);
		transaction.commit();
		
		}
		catch (Exception e) {
			throw new CustomException("Stock sell option failed in dao layer !!");
		}
		return 1;
	}

	
	
	
	
}
