package string_Variable;


public class Demo2 {
	
	String name;
	
	
	
	
	
  public Demo2(String name) {
		super();
		this.name = name;
	}
  



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
}




@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Demo2 other = (Demo2) obj;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}




public static void main(String[] args) {
	String s1=new String("Omkar");
	String s2=new String("Aaryan");  
	String s3=new String("Omkar");
	Object obj=new Object();
	  System.out.println(s1.hashCode());
	  System.out.println(s2.hashCode());
	  System.out.println(s3.hashCode());
	  s1=new String("Aaryan");
	  System.out.println(s1.hashCode());
//	  System.out.println(s1.equals(s3));
	  
}
	
	
	
	
}
