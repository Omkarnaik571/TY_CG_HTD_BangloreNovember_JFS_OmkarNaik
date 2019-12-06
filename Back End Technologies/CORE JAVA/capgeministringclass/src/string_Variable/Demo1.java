package string_Variable;

public class Demo1 {
   
	public static void main(String[] args) {
		Demo1 d1=new Demo1();
		
		String s1="Omkar";
		System.out.println(s1.hashCode());
		   String s2="Aaryan";
		   System.out.println(s2.hashCode());
			  s1="Rahul";
			 System.out.println(s1.hashCode());
			String s3="Rahul";
		System.out.println(s3.hashCode());
		
	}
	
}
