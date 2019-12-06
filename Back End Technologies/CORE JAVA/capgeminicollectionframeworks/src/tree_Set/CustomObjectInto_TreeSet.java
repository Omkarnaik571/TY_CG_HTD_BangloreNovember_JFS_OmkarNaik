package tree_Set;

import java.util.Iterator;
import java.util.TreeSet;

public class CustomObjectInto_TreeSet {

	public static void main(String[] args) {
		StudentAge sage=new StudentAge();
		StudentName sname=new StudentName();
		TreeSet<Student> ts=new TreeSet<Student>(sname);
		ts.add(new Student("Omkar", 33,30000));
		ts.add(new Student("Biswajit", 14,40000));
		ts.add(new Student("santosh", 56,20000));
		
		Iterator<Student> itr=ts.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
	}
	
	
	
	
	
}
