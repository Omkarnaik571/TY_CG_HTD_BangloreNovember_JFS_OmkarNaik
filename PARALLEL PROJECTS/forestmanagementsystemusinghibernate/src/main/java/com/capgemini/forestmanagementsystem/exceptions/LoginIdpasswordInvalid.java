package com.capgemini.forestmanagementsystem.exceptions;

public class LoginIdpasswordInvalid extends Exception{

	
	public  void invalidLoginForClient() {
		System.err.println("\nCLIENT ID AND PASSWORD DIDN`T MATCHED\n");
	}
	
	public  void invalidLoginForScheduler() {
		System.err.println("\nSCHEDULER ID AND PASSWORD DIDN`T MATCHED\n");
	}
	
	public  void invalidLoginForContract() {
		System.err.println("\nCONTRACT NUMBER THAT YOU HAVE ENTERED IS NOT PRESENT !!\n");
	}
	
	
	public  void invalidLoginForCustomer() {
		System.err.println("\nCUSTOMER ID THAT YOU HAVE ENTERED IS NOT PRESENT !!\n");
	}
	
	public  void invalidLoginForProduct() {
		System.err.println("\nPRODUCT ID THAT YOU HAVE ENTERED IS NOT PRESENT !!\n");
	}
	
	public  void invalidLoginForLand() {
		System.err.println("\nPLOT NUMBER THAT YOU HAVE ENTERED IS NOT PRESENT !!\n");
	}
	
	
	
	
}
