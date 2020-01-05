package com.capgemini.forestmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.dto.LandDetailsDto;
import com.capgemini.forestmanagementsystem.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public class LandDaoImpl implements LandDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("forestmanagement");

	@Override
	public boolean addLand(LandDetailsDto pdt) throws CustomExceptions {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(pdt);
			transaction.commit();
			System.out.println("\nLAND ADDED SUCCESFULLY !! \n");
		} catch (Exception e) {
			throw new CustomExceptions("The plot number that you have entered, already present !!");
		}
		return true;
	}

	@Override
	public boolean deleteLand(LandDetailsDto pdt) throws CustomExceptions {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			LandDetailsDto pddto = entityManager.find(LandDetailsDto.class, pdt.getPlotNumber());
			entityManager.remove(pddto);
			transaction.commit();
			System.out.println("\nLAND DELETED SUCCESFULLY !! \n");
			return true;
		} catch (Exception e) {
			throw new CustomExceptions(" The Plot Number that you have entered is not present !!s");
		}
	}

	@Override
	public boolean modifyLand(LandDetailsDto pdt, int ch) throws CustomExceptions {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		switch (ch) {
		case 1:
			try {
			transaction.begin();
			LandDetailsDto pddto = entityManager.find(LandDetailsDto.class, pdt.getPlotNumber());
			pddto.setAcquiredDate(pdt.getAcquiredDate());
			entityManager.persist(pddto);
			transaction.commit();
			}
			catch (Exception e) {
				throw new CustomExceptions("The Plot number that you have entered, doesn`t exists !!");
			}
			break;
		case 2:
			try {
				transaction.begin();
				LandDetailsDto pddto = entityManager.find(LandDetailsDto.class, pdt.getPlotNumber());
				pddto.setLandValue(pdt.getLandValue());
				entityManager.persist(pddto);
				transaction.commit();
				}
				catch (Exception e) {
					throw new CustomExceptions("The Plot number that you have entered, doesn`t exists !!");
				}
			break;

		default:
			break;
		}//end of switch

		return true;
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
