package com.capgemini.forestmanagementsystemusingcollection.dao;

import java.util.TreeMap;

import com.capgemini.forestmanagementsystemusingcollection.dto.LandDetails;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDeleting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileDisplaying;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileInserting;
import com.capgemini.forestmanagementsystemusingcollection.exceptions.ExceptionWhileModifying;

public class LandDaoImpl  implements LandDao{

	TreeMap<Integer, LandDetails> mapForLand=new TreeMap<Integer, LandDetails>();
	
	
	
	public boolean addLandDetail(LandDetails l)  {
		if(mapForLand.containsKey(l.getPlotNumber())) {
			throw new ExceptionWhileInserting("The plot number that you have entered, alreday exists !!");
		}
		else {
			mapForLand.put(l.getPlotNumber(), l);
			return true;
		}
		
	}

	
	public boolean removeLandDetail(Integer landId) {
		if(mapForLand.containsKey(landId)) {
			mapForLand.remove(landId);
			return true;
		}
		else {
			throw new ExceptionWhileDeleting("The plot number that you have entered is not present");
		}
	}

	
	public TreeMap<Integer, LandDetails> displayAllLandDetails()  {
		if(mapForLand.isEmpty()) {
			throw new ExceptionWhileDisplaying("There are no land details present in the database !!");
		}
		else {
		   return mapForLand;	
		}
		
	}

	
	public boolean modifyLandDetail(LandDetails l)  {
		if(mapForLand.containsKey(l.getPlotNumber())) {
			mapForLand.put(l.getPlotNumber(), l);
		    return true;
		}
		else {
			throw new ExceptionWhileModifying("the plot number that you have entered is not present");
		}
		
	}

	
	public LandDetails getSingleLandDetail(Integer landId)  {
		if(mapForLand.containsKey(landId)) {
			return mapForLand.get(landId);
		}
		else {
			throw new ExceptionWhileDisplaying("The plot number that you have enterd is not present");
		}

	}

	
	
	
}
