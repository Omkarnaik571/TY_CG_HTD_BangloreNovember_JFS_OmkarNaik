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
	
	@Override
	public boolean addContract(ContractDetails con) throws ExceptionWhileInserting {
		// TODO Auto-generated method stub
		return dao.addContract(con);
	}

	@Override
	public boolean removeContract(Integer contractId) throws ExceptionWhileDeleting {
		// TODO Auto-generated method stub
		return dao.removeContract(contractId);
	}

	@Override
	public TreeMap<Integer, ContractDetails> getAllContract() throws ExceptionWhileDisplaying {
		// TODO Auto-generated method stub
		return dao.getAllContract();
	}

	@Override
	public boolean modifyContract(ContractDetails con) throws ExceptionWhileModifying {
		// TODO Auto-generated method stub
		return dao.modifyContract(con);
	}

	@Override
	public ContractDetails getSingleContract(Integer id) throws ExceptionWhileDisplaying {
		// TODO Auto-generated method stub
		return dao.getSingleContract(id);
	}
   
	

}
