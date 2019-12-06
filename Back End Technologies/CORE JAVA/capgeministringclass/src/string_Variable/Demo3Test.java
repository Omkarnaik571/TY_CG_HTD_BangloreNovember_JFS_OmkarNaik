package string_Variable;

public class Demo3Test extends Demo3 {
	String n;
	int num;
	
	public Demo3Test(String name, int number) {
		super(name, number);
		this.n = n;
		this.num = num;
	}

   
	
	
	public static void main(String[] args) {
		Demo3 d3=new Demo3("Omkar", 33);
		System.out.println(d3.getName());
		System.out.println(d3.getNumber());
		Demo3Test d33=new Demo3Test("aarayn", 34);
		
		
	}
	
	
}
