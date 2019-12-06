package finalize;

public class TestPerson {
public static void main(String[] args) {
	System.out.println("main started");
	Person p1=new Person();
	p1=null;
	//System.gc();
	System.out.println("main ended");
}
	
	
	
}
