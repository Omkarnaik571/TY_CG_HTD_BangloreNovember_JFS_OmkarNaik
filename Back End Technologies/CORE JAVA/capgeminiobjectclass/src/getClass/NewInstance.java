package getClass;

public class NewInstance {

int number;
public NewInstance(int number) {
	super();
	this.number = number;
}
public NewInstance() {
	// TODO Auto-generated constructor stub
}




public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	NewInstance n1=new NewInstance(4);
	Class c1=n1.getClass();
	NewInstance n2=(NewInstance)c1.newInstance();
   System.out.println(n2.number);
     System.out.println(n1.number);
     Class c2=Class.forName("NewInstance");
     System.out.println(c2);
//     NewInstance n3=(NewInstance)c2.newInstance();
//     System.out.println(n3.number);
     
	
}

	
	
}