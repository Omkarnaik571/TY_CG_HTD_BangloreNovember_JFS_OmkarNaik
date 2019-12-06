package Custom_CheckedException;

public class Age {
	
	public void vote(int age)throws AgeLimitexception{
	if(age>18){
		AgeLimitexception aa=new AgeLimitexception();
		aa.printDetails();
//		System.out.println("eligible to vote...");
	}	
	else{
		throw new AgeLimitexception();
	}
	
	}
	

}
