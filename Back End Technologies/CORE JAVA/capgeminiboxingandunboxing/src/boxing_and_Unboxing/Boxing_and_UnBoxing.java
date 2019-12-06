package boxing_and_Unboxing;

public class Boxing_and_UnBoxing {
public static void main(String[] args) {
	
	int i1=10;
	Integer i2=new Integer(i1);
	int i3=i2.intValue();
	System.out.print(i1+"\t");
	System.out.print(i2+"\t");
	System.out.println(i3+"\t");
	
	double d1=10.33;
	Double d2=new Double(d1);
	double d3=d2.doubleValue();
	System.out.print(d1+"\t");
	System.out.print(d2+"\t");
	System.out.println(d3+"\t");
	
	
	char ch1='a';
	Character ch2=new Character(ch1);
	char ch3=ch2.charValue();
	System.out.print(ch1+"\t");
	System.out.print(ch2+"\t");
	System.out.println(ch3+"\t");
	
	boolean b1=true;
	Boolean b2=new Boolean(b1);
	boolean b3=b2.booleanValue();
	System.out.print(b1+"\t");
	System.out.print(b2+"\t");
	System.out.println(b3+"\t");
	
	
	
}
	
	
	
}
