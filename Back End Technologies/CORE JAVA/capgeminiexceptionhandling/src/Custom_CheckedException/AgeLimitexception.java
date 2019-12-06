package Custom_CheckedException;

public class AgeLimitexception extends Exception {

	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Not eligible to vote....";
	}
	
	void printDetails(){
		System.out.println("Eligible to vote....");
	}
	
	
	
	
}
