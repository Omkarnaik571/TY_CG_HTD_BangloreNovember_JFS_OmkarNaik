package com.capgemini.forestmanagementsystemusingspringboot.dao;

import java.util.List;

import com.capgemini.forestmanagementsystemusingspringboot.dto.LandDetailsDto;
import com.capgemini.forestmanagementsystemusingspringboot.exception.CustomExceptions;

public interface LandDao {

    public boolean addLand(LandDetailsDto ldd) throws CustomExceptions;
	
	
	public List<LandDetailsDto> viewAllLand() throws CustomExceptions;

	boolean deleteLand(int plotNumber) throws CustomExceptions;


	boolean modifyLand(LandDetailsDto pdt) throws CustomExceptions;
	
	
	
	
}
