package un_Checked_Exception;

public class VotingUsingThrow {
   void vote(int age){
	   if(age>=18){
		   System.out.println("You can vote....");
	   }
	   else{
		   throw new ArithmeticException("Not eligible to vote");
	   }
	   
   }
	public static void main(String[] args) {
		VotingUsingThrow vt=new VotingUsingThrow();
		vt.vote(13);
		
		
	}
	
	
	
	
}
