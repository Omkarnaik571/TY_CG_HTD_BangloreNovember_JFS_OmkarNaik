package com.capgemini.forestmanagementsystemusingspringrest.dao;

import java.util.List;

import com.capgemini.forestmanagementsystemusingspringrest.dto.LandDetailsDto;
import com.capgemini.forestmanagementsystemusingspringrest.exception.CustomExceptions;

public interface LandDao {

    public boolean addLand(LandDetailsDto ldd) throws CustomExceptions;
	
	
	public List<LandDetailsDto> viewAllLand() throws CustomExceptions;

	boolean deleteLand(int plotNumber) throws CustomExceptions;


	boolean modifyLand(LandDetailsDto pdt) throws CustomExceptions;
	
	
	
	
}
