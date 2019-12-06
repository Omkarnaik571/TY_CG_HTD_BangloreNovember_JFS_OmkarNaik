package equals;

public class TestEquals1 {
public static void main(String[] args) {
	EqualsExample1 e1=new EqualsExample1("Hello", 4);
	EqualsExample1 e2=new EqualsExample1("Hello", 4);
	System.out.println(e1.equals(e2));
	System.out.println(e1.hashCode());
	System.out.println(e2.hashCode());
	
}
	
	
	
}
