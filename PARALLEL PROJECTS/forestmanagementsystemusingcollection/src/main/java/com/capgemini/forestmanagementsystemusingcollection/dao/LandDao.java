package com.capgemini.forestmanagementsystemusingcollection.dao;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.LandDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileModifying;


public interface LandDao {

public boolean addLandDetail(LandDetails l) ;
	
	public boolean removeLandDetail(Integer landId) ;
	
	public TreeMap<Integer,LandDetails> displayAllLandDetails() ;
	
	public boolean modifyLandDetail(LandDetails l)  ;
	
	public LandDetails getSingleLandDetail(Integer landId) ;
	
	
	
}
