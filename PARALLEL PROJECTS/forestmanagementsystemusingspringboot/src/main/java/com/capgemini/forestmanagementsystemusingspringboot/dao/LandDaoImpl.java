package com.capgemini.forestmanagementsystemusingspringboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.forestmanagementsystemusingspringboot.dto.LandDetailsDto;
import com.capgemini.forestmanagementsystemusingspringboot.exception.CustomExceptions;

@Repository
public class LandDaoImpl implements LandDao {
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addLand(LandDetailsDto pdt) throws CustomExceptions {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(pdt);
			transaction.commit();
		} catch (Exception e) {
			throw new CustomExceptions("The plot number that you have entered, already present !!");
		}
		return true;
	}

	@Override
	public boolean deleteLand(int plotNumber) throws CustomExceptions {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			LandDetailsDto pddto = entityManager.find(LandDetailsDto.class, plotNumber);
			entityManager.remove(pddto);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new CustomExceptions(" The Plot Number that you have entered is not present !!s");
		}
	}

	@Override
	public boolean modifyLand(LandDetailsDto pdt) throws CustomExceptions {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			LandDetailsDto pddto = entityManager.find(LandDetailsDto.class, pdt.getPlotNumber());
			pddto.setAcquiredDate(pdt.getAcquiredDate());
			pddto.setLandValue(pdt.getLandValue());
			entityManager.persist(pddto);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new CustomExceptions(" The Plot Number that you have entered is not present !!s");
		}
	}

	@Override
	public List<LandDetailsDto> viewAllLand() throws CustomExceptions {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String viewall = "from LandDetailsDto";
		Query query = entityManager.createQuery(viewall);
		try {
			List<LandDetailsDto> result = query.getResultList();
			return result;
		} catch (Exception e) {
			throw new CustomExceptions("\nThere are no land details present in the database !!\n");
		}

	}

}
