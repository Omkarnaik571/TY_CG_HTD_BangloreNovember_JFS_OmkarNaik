package com.capgemini.moduleusecase1.factory;

import com.capgemini.module1usecase.dao.ContactDao;
import com.capgemini.module1usecase.dao.ContactDaoImpl;
import com.capgemini.module1usecase.dto.ContactDto;

public class FactoryClass {

	public static ContactDaoImpl getContactDaoObject() {
		return new ContactDaoImpl();
	}
	
	
	public static ContactDto getContactDtoObject() {
		return new ContactDto();
	}
	
	
	
	
}
