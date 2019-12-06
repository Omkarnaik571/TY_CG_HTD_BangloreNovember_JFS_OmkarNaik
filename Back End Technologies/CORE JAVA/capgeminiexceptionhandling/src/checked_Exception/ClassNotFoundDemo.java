package checked_Exception;

public class ClassNotFoundDemo {

	public static void main(String[] args)  {
		try{
		Class c1=Class.forName("checked_Exception.ClassNotFoundDemo");
		System.out.println("Class is found...");
		}
		catch(Exception e){
			System.out.println("Class not found....");
		}
		
	}
	
	
	
	
}
