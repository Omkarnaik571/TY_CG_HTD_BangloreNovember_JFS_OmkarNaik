package com.capgemini.module1usecase.dao;

public interface ContactDao {
	
	public int addContact();
	
	public int deleteContact();
	
	public int modifyContact();
	
	public int modifyContactGroup();
	
	public void searchContact();
	
	public void viewAllContact();

}
