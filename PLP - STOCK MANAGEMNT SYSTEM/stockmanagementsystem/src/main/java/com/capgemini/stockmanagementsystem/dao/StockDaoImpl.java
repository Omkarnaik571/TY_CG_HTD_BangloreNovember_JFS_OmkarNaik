package com.capgemini.stockmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.stockmanagementsystem.dto.StockDetails;
import com.capgemini.stockmanagementsystem.exception.CustomException;

@Repository
public class StockDaoImpl implements StockDao{

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	
	
	@Override
	public int addCompanyStock(StockDetails stockDetails) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(stockDetails);
			transaction.commit();
			return 1;
			
		}catch (Exception e) {
			throw new CustomException("The company name that you have entered, already there in stock list !!");
		}
		
	}
	
	
	

	@Override
	public boolean removeCompanyStock(StockDetails stockDetails) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			StockDetails stockToRemove=entityManager.find(StockDetails.class, stockDetails.getStockId());
			entityManager.remove(stockToRemove);
			transaction.commit();
			return true;
			
		}catch (Exception e) {
			throw new CustomException("Company stock deletion failed !!");
		}
	}

	@Override
	public List<StockDetails> viewAllStockDetails() {
		EntityManager entityManager=entityManagerFactory.createEntityManager();	
		try {
			String jpql="from StockDetails";
			Query query=entityManager.createQuery(jpql);
	 		List<StockDetails> allStockDetails=query.getResultList();
	            return allStockDetails;
		}catch (Exception e) {
			throw new CustomException("There are no stock details present in the data base");
		}
	}

	@Override
	public StockDetails viewSingleStock(StockDetails stockDetails) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();	
		try {
			    StockDetails singleStock=entityManager.find(StockDetails.class, stockDetails.getStockId());
	            return singleStock;
		}catch (Exception e) {
			throw new CustomException("Stock details present in the data base");
		}
	}

	@Override
	public int updateStockDetails(StockDetails stockDetails) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();	
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			StockDetails updatedStock=entityManager.find(StockDetails.class, stockDetails.getStockId());
			updatedStock.setAvailableStocks(stockDetails.getAvailableStocks());
			updatedStock.setMaxBuyOption(stockDetails.getMaxBuyOption());
			updatedStock.setStockPrice(stockDetails.getStockPrice());
			transaction.begin();
			entityManager.persist(updatedStock);
			transaction.commit();
			
			return 1;
		}catch (Exception e) {
			throw new CustomException("Stock deails could`nt be updated !!");
		}
	}

	
	
}
