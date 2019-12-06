package custom_Exception;

import exception_Propagation_using_ABC.B;

public class SBIAtm {
	public static void main(String[] args) {
		System.out.println("Main started");
		AtmSimulator a1=new AtmSimulator();
    DayLimitException dy=new DayLimitException();
		
		try{
		a1.withdraw(42000);
		}
		catch(DayLimitException e){
			System.out.println(e.getMessage());
			
		}
		System.out.println("Main ended...");
	}
	

}
