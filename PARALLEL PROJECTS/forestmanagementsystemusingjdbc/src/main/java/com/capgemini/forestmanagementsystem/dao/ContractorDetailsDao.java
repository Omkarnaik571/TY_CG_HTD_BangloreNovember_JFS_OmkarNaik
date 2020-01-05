package com.capgemini.forestmanagementsystem.dao;

import com.capgemini.forestmanagementsystem.dto.ContractorDetailsDto;
import com.capgemini.forestmanagementsystem.exceptions.ContractCustomException;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public interface ContractorDetailsDao {
	
	 //1. add a Contractor
		public boolean addContractor(ContractorDetailsDto cdd ) throws ContractCustomException, MySQLIntegrityConstraintViolationException;
	//2. View all the Contractor detail
		public boolean viewContractorDetails();
	//3. View single Contractor detail
		public boolean viewSingleContractorDetails();
	//4. delete a Contractor detail	
		public boolean deleteContractorDetails(ContractorDetailsDto cdd );
	//5. Modify a Contractor detail	
		public boolean modifyContractorDetails(ContractorDetailsDto cdd,int cno );
		
	
	

}
