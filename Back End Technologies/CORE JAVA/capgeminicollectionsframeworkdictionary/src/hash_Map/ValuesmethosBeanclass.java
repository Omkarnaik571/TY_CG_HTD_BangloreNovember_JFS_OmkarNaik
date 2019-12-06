package hash_Map;

public class ValuesmethosBeanclass {
  String name;
  int rollno;
public ValuesmethosBeanclass(String name, int rollno) {
	super();
	this.name = name;
	this.rollno = rollno;
}
@Override
public String toString() {
	return " name :" + name + " ||  rollno :" + rollno;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + rollno;
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
	ValuesmethosBeanclass other = (ValuesmethosBeanclass) obj;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (rollno != other.rollno)
		return false;
	return true;
}
  
	
	
	
}
