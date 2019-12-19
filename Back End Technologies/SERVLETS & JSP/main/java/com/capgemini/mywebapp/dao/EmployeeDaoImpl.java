package com.capgemini.mywebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transaction;

import com.capgemini.mywebapp.bin.EmployeeInfoBean;
import com.capgemini.mywebapp.servlets.EmployeeInfoBin;

public class EmployeeDaoImpl implements EmployeeDao {


	private EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Test");


	@Override
	public EmployeeInfoBean searchEmployee(int empId) {

		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EmployeeInfoBean employeeInfoBean=  entityManager.find(EmployeeInfoBean.class, empId);
		entityManager.close();


		return employeeInfoBean;
	}






	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String jpql="from EmployeeInfoBean where empId= :empId and password = :pwd";
		Query query=entityManager.createQuery(jpql);
		query.setParameter("empId", empId);
		query.setParameter("pwd", password);

		EmployeeInfoBean employeeInfoBean=null;

		try {
			employeeInfoBean=(EmployeeInfoBean)query.getSingleResult();
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		entityManager.close();
		return employeeInfoBean;
	}






	@Override
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean) {
		// TODO Auto-generated method stub
		boolean isadded=false;
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=null;	
		try {
			transaction=entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(employeeInfoBean);
			transaction.commit();
			isadded=true;
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		entityManager.close();
		return isadded;
	}






	@Override
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean) {
		// TODO Auto-generated method stub
		boolean isupdated=false;
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();

		transaction.begin();
		EmployeeInfoBean existingEmployeeInfo=  entityManager.find(EmployeeInfoBean.class, employeeInfoBean.getEmpId());
        try {
        	String newName=employeeInfoBean.getName().trim();
        	if(newName != null && !newName.isEmpty()) {
        		existingEmployeeInfo.setName(newName);
        	}
        	
        	int newAge=employeeInfoBean.getAge();
        	if(newAge>18) {
        		existingEmployeeInfo.setAge(newAge);
        	}
        	String newDesignation=employeeInfoBean.getDesignation().trim();
        	if(newDesignation != null && !newName.isEmpty()) {
        		existingEmployeeInfo.setDesignation(newDesignation);
        	}
        	double newSalary=employeeInfoBean.getSalary();
        	if(newSalary >0 ) {
        		existingEmployeeInfo.setSalary(newSalary);
        	}
        	String newPassword=employeeInfoBean.getPassword().trim();
        	if(newPassword != null && !newPassword.isEmpty()) {
        		existingEmployeeInfo.setPassword(newPassword);
        	}
        	
        	transaction.commit();
        	isupdated=true;
        	
        }
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
		entityManager.close();





		return isupdated;
	}






	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		// TODO Auto-generated method stub
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String jpql="from EmployeeInfoBean";

		Query query=entityManager.createQuery(jpql);
		List<EmployeeInfoBean> employeelist=query.getResultList();

		entityManager.close();
		return employeelist;
	}






	@Override
	public boolean deleteEmployee(int empId) {
		boolean isDeleted=false;

		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EmployeeInfoBean employeeInfoBean=entityManager.find(EmployeeInfoBean.class, empId);
		EntityTransaction transaction=null;
		if(employeeInfoBean != null) {
			transaction=entityManager.getTransaction();
			transaction.begin();
			entityManager.remove(employeeInfoBean);
			transaction.commit();
			isDeleted=true;
		}

		entityManager.close();
		return isDeleted;
	}





















}
