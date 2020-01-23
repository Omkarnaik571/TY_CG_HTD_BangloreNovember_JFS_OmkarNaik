package com.capgemini.forestmanagementsystemusingcollection.dao;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.ContractDetails;
import com.capgemini.forestmanagementsystemusingcollection.dto.CustomerDetail;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileModifying;

public class ContractDaoImpl implements ContractDao {

	TreeMap<Integer, ContractDetails> mapForContract=new TreeMap<Integer, ContractDetails>();
	
	
	public boolean addContract(ContractDetails con)  {
		if(mapForContract.containsKey(con.getContractNo())) {
			throw new ExceptionWhileInserting("Contract id already exists duplicate id not allowed");
		} else {
			
			Integer add=con.getContractNo();
			mapForContract.put(add,con);
			return true;
		}
	}

	
	public boolean removeContract(Integer contractId)  {
		if(mapForContract.containsKey(contractId)){
			mapForContract.remove(contractId);
			return true;
		} else {
			throw new ExceptionWhileDeleting("The contract no that you have entered is not present");
		}
	}

	
	public TreeMap<Integer, ContractDetails> getAllContract()  {
		if(mapForContract.size()!=0) {
			return mapForContract;
		}
		throw new ExceptionWhileDisplaying("Contract details does not exist"); 
		
	}



	public boolean modifyContract(ContractDetails con)  {
		if(mapForContract.containsKey(con.getContractNo())) {
			mapForContract.replace(con.getContractNo(),con);
			return true;
		}
		else {
			throw new ExceptionWhileModifying("The contract no that you have entered is not present ");
		}
		
	}

	
	public ContractDetails getSingleContract(Integer id) {
		if(mapForContract.containsKey(id)) {
			return mapForContract.get(id);
		}
		throw new ExceptionWhileDisplaying("Contract does not exist");
	}

	
	
	
}
