package exception_Propagation_using_ABC;

public class B {
	
	public static void displayB(){
		 try{
			 C.displayC();
		 }
		catch(ArithmeticException e){
			System.out.println("B class is handling "+e.getMessage());
			throw e;
		}
		
		
	}
	

}
