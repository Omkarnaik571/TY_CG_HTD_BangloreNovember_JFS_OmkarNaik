package throws_keyword;

public class A {
public static void main(String[] args) {
	
	try {
		B.b();
	} catch (ClassNotFoundException e) {
		System.out.println("Class not found handled in Class A");
		
	}
	
	
	
}

	
	
}
