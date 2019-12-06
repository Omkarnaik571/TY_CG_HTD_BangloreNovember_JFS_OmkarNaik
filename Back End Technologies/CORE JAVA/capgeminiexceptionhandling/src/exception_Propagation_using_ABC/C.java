package exception_Propagation_using_ABC;

public class C {

	 public static void displayC(){
		 try{
			 System.out.println(10/0);
		 }
		catch(ArithmeticException e){
			System.out.println("C class is handling "+e.getMessage());
			throw e;
		}
	}
	
	
	
}
