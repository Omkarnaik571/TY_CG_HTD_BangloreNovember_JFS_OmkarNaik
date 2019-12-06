package tree_Set;

public class Student implements Comparable<Student> {
String name;
int roll;
int salary;
public Student(String name, int roll,int salary) {
	super();
	this.name = name;
	this.roll = roll;
	this.salary=salary;
}

  

@Override
public String toString() {
	return "[name=" + name + ", roll=" + roll + ", salary=" + salary + "]";
}

@Override
	public int compareTo(Student o) {
	
		return 0;
	}
	
	
	

}