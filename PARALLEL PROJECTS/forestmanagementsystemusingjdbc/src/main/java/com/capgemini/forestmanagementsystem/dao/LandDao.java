package com.capgemini.forestmanagementsystem.dao;

import com.capgemini.forestmanagementsystem.dto.LandDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public interface LandDao {

    public boolean addLand(LandDetailsDto ldd) throws CustomExceptions;
	
	public boolean deleteLand(LandDetailsDto ldd);
	
	public boolean modifyLand(LandDetailsDto ldd,int ch);
	
	public boolean viewAllLand();
	
	
	
	
}
