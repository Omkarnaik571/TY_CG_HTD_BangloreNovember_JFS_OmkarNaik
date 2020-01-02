package com.capgemini.springbootassignment1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.springbootassignment1.dto.ProductBean;

@Repository
public class ProductOperationDaoImpl implements ProductOperationDao {

	@PersistenceUnit
	private EntityManagerFactory entitymanagerfactory;
	
	
	
	@Override
	public boolean addProduct(ProductBean bean) {
		EntityManager manager=entitymanagerfactory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		try {
		manager.persist(bean);
		transaction.commit();
		System.out.println("Product added successfully");
		return true;
		}
		catch (Exception e) {
			System.out.println("\nCatch is executing..\n");
			e.printStackTrace();
			// TODO: handle exception
		}
			return false;
			
	}



	@Override
	public boolean deleteProduct(int id) {
	    EntityManager entityManager=entitymanagerfactory.createEntityManager();
	    EntityTransaction transaction=entityManager.getTransaction();
	    try {
	    transaction.begin();
	     ProductBean pBean=entityManager.find(ProductBean.class, id);
		entityManager.remove(pBean);
		transaction.commit();
		return true;
	    }//end of try
	    catch (Exception e) {
			System.out.println("\nSomething went wrong while deleting..");
		}
		return false;
	}



	@Override
	public List<ProductBean> getAllProductDetails() {
		List<ProductBean> allProductResult=null;
		try {
		EntityManager entityManager=entitymanagerfactory.createEntityManager();
		String jpql="from ProductBean"; 
		Query query=entityManager.createQuery(jpql);
		 allProductResult=query.getResultList();             
		}
		catch (Exception e) {
			System.out.println("\n Something went wrong while getting all data");
			// TODO: handle exception
		}
		return allProductResult;
		}//



	@Override
	public boolean changeImageUrl(int id, String newUrl) {
		try {
		EntityManager entityManager=entitymanagerfactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		ProductBean productBean=entityManager.find(ProductBean.class, id);
		productBean.setImgurl(newUrl);
		entityManager.persist(productBean);
		transaction.commit();
		return true;
		}
		catch (Exception e) {
			System.out.println("\nError in modifying url");
		}
		return false;
	}



	@Override
	public boolean changeProductName(int id, String newProductName) {
		
		
		return false;
	}



	@Override
	public boolean changeCost(int id, double newCost) {
		// TODO Auto-generated method stub
		return false;
	}
        
	
	
}
