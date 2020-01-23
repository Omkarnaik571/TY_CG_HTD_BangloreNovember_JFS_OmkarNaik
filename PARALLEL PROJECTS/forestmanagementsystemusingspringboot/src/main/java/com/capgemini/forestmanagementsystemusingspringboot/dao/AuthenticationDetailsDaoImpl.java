package com.capgemini.forestmanagementsystemusingspringboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.forestmanagementsystemusingspringboot.dto.AuthenticationDetailsDto;
import com.capgemini.forestmanagementsystemusingspringboot.exception.CustomExceptions;

@Repository
public class AuthenticationDetailsDaoImpl implements AuthenticationDetailsDao {
	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addUser(AuthenticationDetailsDto aDetails) throws CustomExceptions {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(aDetails);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new CustomExceptions("User name alreday been taken by someone else !!");
		}
	}

	@Override
	public boolean delateUser(AuthenticationDetailsDto aDetails) throws CustomExceptions {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			AuthenticationDetailsDto authDto = entityManager.find(AuthenticationDetailsDto.class,
					aDetails.getUserName());
			if (aDetails.getPassword().equals(authDto.getPassword())) {
				entityManager.remove(authDto);
				transaction.commit();
				return true;
			}

			
		} catch (Exception e) {
			throw new CustomExceptions("Failed to delete, User Name and Password didn`t matched !!");
		}
		return false;
	}

	@Override
	public boolean modifyUser(AuthenticationDetailsDto aDetails) throws CustomExceptions {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			AuthenticationDetailsDto authDto = entityManager.find(AuthenticationDetailsDto.class,aDetails.getUserName());
			if (aDetails.getPassword().equals(authDto.getPassword())) {
				authDto.setPassword(aDetails.getPassword());
				entityManager.persist(authDto);
				transaction.commit();
				return true;
			}
			return false;
		} catch (Exception e) {
			throw new CustomExceptions("Failed to modify, User Name and Password didn`t matched !!");
		}

	}

	@Override
	public AuthenticationDetailsDto viewSingleUserClient(AuthenticationDetailsDto aDetails) throws CustomExceptions {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			AuthenticationDetailsDto aDetailsDto = entityManager.find(AuthenticationDetailsDto.class,
					aDetails.getUserName());
			if (aDetailsDto.getPassword().equals(aDetails.getPassword())) {
				return aDetailsDto;
			} 
		} catch (Exception e) {
			throw new CustomExceptions("The username and password didn`t matched");
		}
		return null;
	}

	@Override
	public List<AuthenticationDetailsDto> viewAllClients() throws CustomExceptions {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from AuthenticationDetailsDto";
		Query query=entityManager.createQuery(jpql);
		List<AuthenticationDetailsDto> result=query.getResultList();
		if (result.isEmpty()) {
			throw new CustomExceptions("There are No clients present in the database !!");
		}

		return result;

	}

	@Override
	public List<AuthenticationDetailsDto> viewAllScheduers() throws CustomExceptions {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from AuthenticationDetailsDto where accountType=:scheduler";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("scheduler", "scheduler");
		List<AuthenticationDetailsDto> result = query.getResultList();
		if (result.isEmpty()) {
			throw new CustomExceptions("There are No schedulers present in the database !!");
		}

		return result;
	}

	@Override
	public AuthenticationDetailsDto viewSingleUserScheduler(AuthenticationDetailsDto aDetails) throws CustomExceptions {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			AuthenticationDetailsDto aDetailsDto = entityManager.find(AuthenticationDetailsDto.class,
					aDetails.getUserName());
			if (aDetailsDto.getPassword().equals(aDetails.getPassword())
					&& aDetailsDto.getAccountType().equals("scheduler")) {
				return aDetailsDto;
			}
		} catch (Exception e) {
			throw new CustomExceptions("The username and password didn`t matched");
		}
		return null;
	}

}
