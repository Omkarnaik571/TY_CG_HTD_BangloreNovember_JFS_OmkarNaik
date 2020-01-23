package com.capgemini.forestmanagementsystemusingcollection.service;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dao.ContractDao;
import com.capgemini.forestmanagementsystemusingcollection.dao.ContractDaoImpl;
import com.capgemini.forestmanagementsystemusingcollection.dto.ContractDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileModifying;


public class ContractServiceImpl implements ContractService {

	     ContractDao dao=new ContractDaoImpl();
	
	
	public boolean addContract(ContractDetails con) {
		// TODO Auto-generated method stub
		return dao.addContract(con);
	}

	
	public boolean removeContract(Integer contractId) {
		// TODO Auto-generated method stub
		return dao.removeContract(contractId);
	}

	
	public TreeMap<Integer, ContractDetails> getAllContract(){
		// TODO Auto-generated method stub
		return dao.getAllContract();
	}

	
	public boolean modifyContract(ContractDetails con) {
		// TODO Auto-generated method stub
		return dao.modifyContract(con);
	}

	
	public ContractDetails getSingleContract(Integer id)  {
		// TODO Auto-generated method stub
		return dao.getSingleContract(id);
	}
   
	

}
