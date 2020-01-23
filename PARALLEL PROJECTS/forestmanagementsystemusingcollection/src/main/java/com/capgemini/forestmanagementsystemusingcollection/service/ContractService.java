package com.capgemini.forestmanagementsystemusingcollection.service;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.ContractDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileModifying;



public interface ContractService {

	public boolean addContract(ContractDetails con) ;
	public boolean removeContract(Integer productId);
	public TreeMap<Integer,ContractDetails> getAllContract();
	public boolean modifyContract(ContractDetails con);
	public ContractDetails getSingleContract(Integer id);
	
	
}
