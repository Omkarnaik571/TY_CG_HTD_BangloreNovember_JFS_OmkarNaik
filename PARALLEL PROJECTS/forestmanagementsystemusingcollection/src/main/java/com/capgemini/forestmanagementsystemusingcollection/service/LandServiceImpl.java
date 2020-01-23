package com.capgemini.forestmanagementsystemusingcollection.service;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dao.LandDao;
import com.capgemini.forestmanagementsystemusingcollection.dao.LandDaoImpl;
import com.capgemini.forestmanagementsystemusingcollection.dto.LandDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileModifying;

public class LandServiceImpl implements LandService{

	       LandDao dao=new LandDaoImpl();
	
	
	
	public boolean addLandDetail(LandDetails l)  {
		// TODO Auto-generated method stub
		return dao.addLandDetail(l);
	}

	
	public boolean removeLandDetail(Integer landId)  {
		// TODO Auto-generated method stub
		return dao.removeLandDetail(landId);
	}

	
	public TreeMap<Integer, LandDetails> displayAllLandDetails() {
		// TODO Auto-generated method stub
		return dao.displayAllLandDetails();
	}

	
	public boolean modifyLandDetail(LandDetails l)  {
		// TODO Auto-generated method stub
		return dao.modifyLandDetail(l);
	}

	
	public LandDetails getSingleLandDetail(Integer landId)  {
		// TODO Auto-generated method stub
		return dao.getSingleLandDetail(landId);
	}

	
	
	
	
	
}
