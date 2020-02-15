package com.tyss.ehub.config.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tyss.ehub.config.dto.AuthenticationDto;
import com.tyss.ehub.config.exception.CustomException;

@Repository
public class AuthenticationDaoImpl implements AuthenticationDao {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addUser(AuthenticationDto authenticationDto) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(authenticationDto);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			throw new CustomException("The user name that you have entered already exits !!");
		}

	}

	@Override
	public boolean deleteUser(AuthenticationDto authenticationDto) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			String deleteUser = "delete from AuthenticationDto where userName=:userName and password=:password";
			Query query = entityManager.createQuery(deleteUser);
			query.setParameter("userName", authenticationDto.getUserName());
			query.setParameter("password", authenticationDto.getPassword());
			transaction.begin();
			int delete = query.executeUpdate();
			if (delete > 0) {
				return true;
			}
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw new CustomException("User deletion failed, Username and password did`nt matched !!");
		}

		return false;
	}

	@Override
	public AuthenticationDto getUser(AuthenticationDto authenticationDto) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			String findUser = "from AuthenticationDto where userName=:userName";
			Query query = entityManager.createQuery(findUser);
			query.setParameter("userName", authenticationDto.getUserName());
			AuthenticationDto userFound = (AuthenticationDto) query.getSingleResult();
			if (userFound.getPassword().equals(authenticationDto.getPassword())) {
				return userFound;
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new CustomException("Username does`nt exists !!");
		}
	}

	
	
	
	
	
	@Override
	public boolean updateUser(AuthenticationDto authenticationDto) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			String findUser = "from AuthenticationDto where userName=:userName";
			TypedQuery<AuthenticationDto> query = entityManager.createQuery(findUser,AuthenticationDto.class);
			query.setParameter("userName", authenticationDto.getUserName());
			AuthenticationDto userFound = query.getSingleResult();
			AuthenticationDto userDataToBeChanged=entityManager.find(AuthenticationDto.class, userFound.getAuthenticationID());
			userDataToBeChanged.setPassword(authenticationDto.getPassword());
			transaction.begin();
			entityManager.persist(userDataToBeChanged);
			transaction.commit();	
			return true;
		} catch (Exception e) {
			transaction.rollback();
			throw new CustomException("Password modification unsuccessful, Username does`nt exists !!");
		}
	}

}
