package hashSet;

import java.util.HashSet;

public class TestStudent_HashSet {
 public static void main(String[] args) {
	HashSet<Student_HasSet> hs=new HashSet<Student_HasSet>();
	 hs.add(new Student_HasSet("Omkar", 22));
	 hs.add(new Student_HasSet("Omkar", 22));
	 hs.add(new Student_HasSet("Omkar", 22));
	 Student_HasSet ss1=new Student_HasSet("aaryan", 22);
	 Student_HasSet ss2=new Student_HasSet("aaryan", 22);
	 System.out.println(ss1.equals(ss2));
	
	 /*
	 for (Student_HasSet s1 : hs) {
		System.out.println(s1);
		System.out.println(s1.hashCode());
	}
	 */
	 
}
 
 
 
 
 
 
	
	
	
	
}
