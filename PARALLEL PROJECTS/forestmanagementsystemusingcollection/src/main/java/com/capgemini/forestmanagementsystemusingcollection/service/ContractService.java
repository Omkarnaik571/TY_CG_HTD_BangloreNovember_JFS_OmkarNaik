package com.capgemini.forestmanagementsystemusingcollection.service;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.ContractDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileModifying;



public interface ContractService {

	public boolean addContract(ContractDetails con) throws ExceptionWhileInserting;
	public boolean removeContract(Integer productId) throws ExceptionWhileDeleting;
	public TreeMap<Integer,ContractDetails> getAllContract() throws ExceptionWhileDisplaying;
	public boolean modifyContract(ContractDetails con) throws ExceptionWhileModifying;
	public ContractDetails getSingleContract(Integer id) throws ExceptionWhileDisplaying;
	
	
}
