package clonnableMethod;

public class Clone1 implements Cloneable {
String name;
int rollno;
public Clone1(String name, int rollno) {
	super();
	this.name = name;
	this.rollno = rollno;
}

@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	
	

	
	
	
	
}
