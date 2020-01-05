package com.capgemini.forestmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public class ProductDetailsDaoImpl implements ProductDao{
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("forestmanagement");


	public boolean addProduct(ProductDetailsDto pdt) throws CustomExceptions {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(pdt);
			transaction.commit();
			System.out.println("\nPRODUCT ADDED SUCCESFULLY !! \n");

		}
		catch (Exception e) {

			throw new CustomExceptions();
		}
		return true;

	}//end of add product


	public boolean deleteProduct(ProductDetailsDto pdt) throws CustomExceptions {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			transaction.begin();
			ProductDetailsDto pddto=entityManager.find(ProductDetailsDto.class, pdt.getProductId());
			entityManager.remove(pddto);
			transaction.commit();
			System.out.println("\nPRODUCT DELETED SUCCESFULLY !! \n");
			
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
		System.out.println("\nProduct name modified successfully !!\n");
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

	public ProductDetailsDto viewParticularProduct(ProductDetailsDto pdt) throws CustomExceptions {
		try {
		EntityManager entityManager=entityManagerFactory.createEntityManager();	
		ProductDetailsDto pdd=entityManager.find(ProductDetailsDto.class, pdt.getProductId());
			return pdd;
		
		}
		catch (Exception e) {
			throw new CustomExceptions("THE PRODUCT ID THAT YOU HAVE ENTERED IS NOT PRESENT ");
		}
	}//end of view single




}
