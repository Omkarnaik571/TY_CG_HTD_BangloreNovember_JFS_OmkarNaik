package com.capgemini.forestmanagementsystem.dao;

import java.util.List;

import com.capgemini.forestmanagementsystem.dto.LandDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public interface LandDao {

    public boolean addLand(LandDetailsDto ldd) throws CustomExceptions;
	
	public boolean deleteLand(LandDetailsDto ldd) throws CustomExceptions;
	
	public boolean modifyLand(LandDetailsDto ldd,int ch) throws CustomExceptions;
	
	public List<LandDetailsDto> viewAllLand() throws CustomExceptions;
	
	
	
	
}
