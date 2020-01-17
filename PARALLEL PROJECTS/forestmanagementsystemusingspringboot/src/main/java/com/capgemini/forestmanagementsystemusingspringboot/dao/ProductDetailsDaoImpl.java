package com.capgemini.forestmanagementsystemusingspringboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.forestmanagementsystemusingspringboot.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystemusingspringboot.exception.CustomExceptions;

@Repository
public class ProductDetailsDaoImpl implements ProductDao{
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;


	public boolean addProduct(ProductDetailsDto pdt) throws CustomExceptions {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(pdt);
			transaction.commit();
		}
		catch (Exception e) {

			throw new CustomExceptions();
		}
		return true;

	}//end of add product


	public boolean deleteProduct(int productId) throws CustomExceptions {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			ProductDetailsDto pddto=entityManager.find(ProductDetailsDto.class, productId);
			entityManager.remove(pddto);
			transaction.commit();
		}
		catch (Exception e) {
			throw new CustomExceptions("THE PRODUCT ID THAT YOU HAVE ENTERED IS NOT PRESENT ");
		}
		return true;
	}//end of delete product

	
	public boolean modifyProduct(ProductDetailsDto pdt) throws CustomExceptions {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
		transaction.begin();
		ProductDetailsDto pddto=entityManager.find(ProductDetailsDto.class, pdt.getProductId());
		pddto.setProductName(pdt.getProductName());
		entityManager.persist(pddto);
		transaction.commit();
		}
		catch (Exception e) {
			throw new CustomExceptions("THE PRODUCT ID THAT YOU HAVE ENTERED IS NOT PRESENT ");
		}
		return true;
	}//end of modify product

	public List<ProductDetailsDto> viewAllProduct() throws CustomExceptions {
		try {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String viewall="from ProductDetailsDto"; 
		Query query=entityManager.createQuery(viewall);
		List<ProductDetailsDto> result= query.getResultList();
		return result;
		}
		catch (Exception e) {
			throw new CustomExceptions("There are no products present in the database !!");
		}
	}//end of view all

	public ProductDetailsDto viewParticularProduct(int productId) throws CustomExceptions {
		try {
		EntityManager entityManager=entityManagerFactory.createEntityManager();	
		ProductDetailsDto pdd=entityManager.find(ProductDetailsDto.class, productId);
			return pdd;
		
		}
		catch (Exception e) {
			throw new CustomExceptions("THE PRODUCT ID THAT YOU HAVE ENTERED IS NOT PRESENT ");
		}
	}//end of view single




}
