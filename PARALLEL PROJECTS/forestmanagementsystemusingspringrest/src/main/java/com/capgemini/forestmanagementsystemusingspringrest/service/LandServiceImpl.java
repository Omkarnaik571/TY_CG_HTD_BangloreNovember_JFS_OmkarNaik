package com.capgemini.forestmanagementsystemusingspringrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestmanagementsystemusingspringrest.dao.LandDao;
import com.capgemini.forestmanagementsystemusingspringrest.dao.LandDaoImpl;
import com.capgemini.forestmanagementsystemusingspringrest.dto.LandDetailsDto;
import com.capgemini.forestmanagementsystemusingspringrest.exception.CustomExceptions;
@Service
public class LandServiceImpl implements LandService{

	   @Autowired
	   LandDao landDao; 
	
	
	@Override
	public boolean addLand(LandDetailsDto ldd) throws CustomExceptions {
		
		return landDao.addLand(ldd);
	}

	

	

	@Override
	public List<LandDetailsDto> viewAllLand() throws CustomExceptions {
		
		return landDao.viewAllLand();
	}



	@Override
	public boolean deleteLand(int plotNumber) throws CustomExceptions {
		
		return landDao.deleteLand(plotNumber);
	}





	@Override
	public boolean modifyLand(LandDetailsDto pdt) throws CustomExceptions {
		
		return landDao.modifyLand(pdt);
	}
   
	
	
	
	
	
	
	
	
	
	
	
}
