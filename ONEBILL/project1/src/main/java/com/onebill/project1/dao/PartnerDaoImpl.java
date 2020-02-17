package com.onebill.project1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.onebill.project1.dto.Partner;
import com.onebill.project1.exception.CustomException;

@Repository
public class PartnerDaoImpl implements PartnerDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	
	@Override
	public int addPartner(Partner partner) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(partner);
			transaction.commit();
			
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("Enter a different email id`s");
		}
		
	}

	@Override
	public Partner viewPartner(Partner partner) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			Partner partnerFound=entityManager.find(partner.getClass(), partner.getPartnerId());
			
			return partnerFound;
		}catch (Exception e) {
			throw new CustomException("Error while retriving values from partner dao");
		}
		
	}

}
