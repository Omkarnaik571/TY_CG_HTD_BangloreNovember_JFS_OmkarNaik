package Custom_CheckedException;

public class VoteTest {
public static void main(String[] args) {
	Age a1=new Age();
	try{
	a1.vote(19);
	}
	catch(AgeLimitexception aa){
		System.out.println(aa.getMessage());
		
	}
}
	
	
	
}
