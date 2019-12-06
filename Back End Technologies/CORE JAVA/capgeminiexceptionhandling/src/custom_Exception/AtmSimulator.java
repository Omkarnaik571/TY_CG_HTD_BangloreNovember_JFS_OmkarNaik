package custom_Exception;

public class AtmSimulator {

	public void withdraw(double amount){
		if(amount>40000){
			throw new DayLimitException();
		}
		
		
	}
	   
	
}
