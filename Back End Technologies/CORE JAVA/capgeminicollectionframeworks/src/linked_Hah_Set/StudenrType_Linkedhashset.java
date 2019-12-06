package linked_Hah_Set;

public class StudenrType_Linkedhashset {
  String name;
  int roll;
public StudenrType_Linkedhashset(String name, int roll) {
	super();
	this.name = name;
	this.roll = roll;
}
@Override
public String toString() {
	return " [name=" + name + ", roll=" + roll + "]";}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	StudenrType_Linkedhashset other = (StudenrType_Linkedhashset) obj;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (roll != other.roll)
		return false;
	return true;
}

  
  
	
	
	
	
	
	
}
