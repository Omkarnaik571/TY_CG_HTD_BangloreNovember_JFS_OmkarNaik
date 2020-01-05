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
	
	
	@Override
	public boolean addLandDetail(LandDetails l) throws ExceptionWhileInserting {
		// TODO Auto-generated method stub
		return dao.addLandDetail(l);
	}

	@Override
	public boolean removeLandDetail(Integer landId) throws ExceptionWhileDeleting {
		// TODO Auto-generated method stub
		return dao.removeLandDetail(landId);
	}

	@Override
	public TreeMap<Integer, LandDetails> displayAllLandDetails() throws ExceptionWhileDisplaying {
		// TODO Auto-generated method stub
		return dao.displayAllLandDetails();
	}

	@Override
	public boolean modifyLandDetail(LandDetails l) throws ExceptionWhileModifying {
		// TODO Auto-generated method stub
		return dao.modifyLandDetail(l);
	}

	@Override
	public LandDetails getSingleLandDetail(Integer landId) throws ExceptionWhileDisplaying {
		// TODO Auto-generated method stub
		return dao.getSingleLandDetail(landId);
	}

	
	
	
	
	
}
