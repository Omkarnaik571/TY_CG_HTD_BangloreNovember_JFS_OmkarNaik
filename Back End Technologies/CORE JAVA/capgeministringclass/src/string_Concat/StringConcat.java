package string_Concat;

public class StringConcat {
   public static void main(String[] args) {
	String s1=new String("Aaryan");
	System.out.println(s1.hashCode());
	  s1=new String("Omkar");
	  System.out.println(s1.hashCode());
	   s1=s1.concat("hello");
	   System.out.println(s1.hashCode());
	   
}
	
	
	
	
}
