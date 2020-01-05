package com.capgemini.forestmanagementsystemusingcollection.service;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.LandDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileModifying;

public interface LandService {

public boolean addLandDetail(LandDetails l) throws ExceptionWhileInserting;
	
	public boolean removeLandDetail(Integer landId) throws ExceptionWhileDeleting;
	
	public TreeMap<Integer,LandDetails> displayAllLandDetails() throws ExceptionWhileDisplaying;
	
	public boolean modifyLandDetail(LandDetails l) throws ExceptionWhileModifying;
	
	public LandDetails getSingleLandDetail(Integer landId) throws ExceptionWhileDisplaying;
	
	
	
	
}
