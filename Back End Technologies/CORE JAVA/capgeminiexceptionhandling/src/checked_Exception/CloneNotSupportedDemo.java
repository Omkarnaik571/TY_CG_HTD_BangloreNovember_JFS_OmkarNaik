package checked_Exception;

public class CloneNotSupportedDemo {
String name="omkar";
	
	public static void main(String[] args) {
	CloneNotSupportedTest ct=new CloneNotSupportedTest();
		
		CloneNotSupportedDemo cd=new CloneNotSupportedDemo();
		try {
//			Object o1=cd.clone();
			CloneNotSupportedTest ct2=(CloneNotSupportedTest)ct.clone();
//		CloneNotSupportedDemo cd2=o1.clone();
			
		} catch (CloneNotSupportedException e) {
			System.out.println("Clone is not working....");
			
		}
		
		
	}
	
	
	
}
