package finalize;

public class Person {
    
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("Hello finalize executed");
	}
	
	
}
