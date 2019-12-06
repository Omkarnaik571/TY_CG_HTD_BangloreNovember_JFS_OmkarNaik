package checked_Exception;

public class CloneNotSupportedWithNestedTry implements Cloneable {

	@Override
	protected Object clone() throws CloneNotSupportedException {
		System.out.println("Clone is executing....");
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	public static void main(String[] args) {
		CloneNotSupportedWithNestedTry cn=new CloneNotSupportedWithNestedTry();
		
		
		try{
			Object o1=cn.clone();
			try{
				Class c1=Class.forName("checked_Exception.CloneNotSupportedDemo");
			}
			catch(ClassNotFoundException e){
				System.out.println("class not found...");
			}
			
		}
		catch(CloneNotSupportedException e){
			System.out.println("Clone is not executing...");
		}
		
		
		
	}
	
	
	
	
	
}
