package linked_Hash_Map;

public class CustomLinkedHahMapBeanClass {
   int salary;
   String name;
   
  
   
@Override
public String toString() {
	return "salary : " + salary + " || name : " + name;
}
public CustomLinkedHahMapBeanClass(int salary, String name) {
	super();
	this.salary = salary;
	this.name = name;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + salary;
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
	CustomLinkedHahMapBeanClass other = (CustomLinkedHahMapBeanClass) obj;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (salary != other.salary)
		return false;
	return true;
}
   
   
	
	
	
}
