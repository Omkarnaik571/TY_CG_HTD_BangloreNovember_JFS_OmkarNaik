package tostring;

public class TestStudent {
public static void main(String[] args) {
	Student st=new Student("Omkar", 33);
	System.out.println(st.toString());
	String s=st.toString();
	System.out.println(s);
	Object obj=new Object();
	System.out.println(obj.hashCode());
	TestStudent ts1=new TestStudent();
	TestStudent ts2=ts1;
	System.out.println(ts1.equals(ts2));
	
	
}
	
	
	
}
