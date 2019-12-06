package tree_Map_OR_SortedHashMap;

public class StudentBean implements Comparable<StudentBean> {
String name;
int age;
public StudentBean(String name, int age) {
	super();
	this.name = name;
	this.age = age;
}

public int compareTo(StudentBean o) {
	
	/*
	if(this.age>o.age) {
		return 1;
	}
	else if(this.age<o.age) {
		return -1;
	}
	else {
		return 0;
	}
	*/
	
	return 0;
	
	
}

@Override
public String toString() {
	return "Name :" + name + " || Age :" + age;
}



	
	
	
}
