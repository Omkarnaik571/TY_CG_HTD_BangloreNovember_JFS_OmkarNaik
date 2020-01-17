package com.capgemini.forestmanagementsystemusingspringrest.service;

import java.util.List;

import com.capgemini.forestmanagementsystemusingspringrest.dto.LandDetailsDto;
import com.capgemini.forestmanagementsystemusingspringrest.exception.CustomExceptions;

public interface LandService {
  
public boolean addLand(LandDetailsDto ldd) throws CustomExceptions;
	
boolean deleteLand(int plotNumber) throws CustomExceptions;
	
boolean modifyLand(LandDetailsDto pdt) throws CustomExceptions;
	
	public List<LandDetailsDto> viewAllLand() throws CustomExceptions;
	
	
	
	
}
