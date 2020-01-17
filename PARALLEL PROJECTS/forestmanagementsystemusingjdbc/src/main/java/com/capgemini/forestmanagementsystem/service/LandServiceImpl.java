package com.capgemini.forestmanagementsystem.service;

import java.util.List;

import com.capgemini.forestmanagementsystem.dao.LandDao;
import com.capgemini.forestmanagementsystem.dao.LandDaoImpl;
import com.capgemini.forestmanagementsystem.dto.LandDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.CustomExceptions;

public class LandServiceImpl  implements LandService{

	    LandDao dao=new LandDaoImpl();
	
	@Override
	public boolean addLand(LandDetailsDto ldd) throws CustomExceptions {
		
		return dao.addLand(ldd);
	}

	@Override
	public boolean deleteLand(LandDetailsDto ldd) throws CustomExceptions {
		
		return dao.deleteLand(ldd);
	}

	@Override
	public boolean modifyLand(LandDetailsDto ldd, int ch) throws CustomExceptions {
		
		return dao.modifyLand(ldd, ch);
	}

	@Override
	public List<LandDetailsDto> viewAllLand() throws CustomExceptions {
		
		return dao.viewAllLand();
	}

}
