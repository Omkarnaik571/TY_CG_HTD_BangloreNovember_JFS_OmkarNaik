package getClass;

public class TestAnimal {
public static void main(String[] args) throws InstantiationException, IllegalAccessException {
	Animal a1=new Animal("Dog");
	Class c1=a1.getClass();
	System.out.println(c1);
	Animal a2=(Animal)c1.newInstance();
	System.out.println(a2.name);
	
}
	
	
	
}
