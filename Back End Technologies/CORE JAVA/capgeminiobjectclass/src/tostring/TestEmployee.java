package tostring;

public class TestEmployee {

	public static void main(String[] args) {
		Employee e1=new Employee("Omkar", 33);
		Employee e2=new Employee("Omkar", 33);
		System.out.println(e1.equals(e2));
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
	}
	
	
}
