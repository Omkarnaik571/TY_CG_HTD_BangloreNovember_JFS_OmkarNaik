package exception_Propagation_using_ABC;

public class A {

	
	public  static void displayA(){
		try{
			B.displayB();
		 }
		catch(ArithmeticException e){
			System.out.println("A class is handling "+e.getMessage());
	
		}
		
		
		
	}
}
