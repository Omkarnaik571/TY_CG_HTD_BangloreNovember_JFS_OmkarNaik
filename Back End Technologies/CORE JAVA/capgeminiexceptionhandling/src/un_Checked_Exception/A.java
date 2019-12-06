package un_Checked_Exception;

public class A {

	public static void main(String[] args){
		A aa=new A();
	    System.out.println("main method started");
		
	    try{
	    System.out.println(10/0);
	    }
	    catch(ArithmeticException e){
	    	System.out.println("\nEnter the numerator properly..\n");
	    }
	    System.out.println("main ended");
	}
	
	
	
	
}
