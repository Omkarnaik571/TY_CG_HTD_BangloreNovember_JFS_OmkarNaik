package equals;

public class EqualsExample1 {
   String name;
   int id;
   
   public EqualsExample1(String name,int id) {
	// TODO Auto-generated constructor stub
   this.name=name;
   this.id=id;
   
   }


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	EqualsExample1 other = (EqualsExample1) obj;
	if (id != other.id)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}



   
   


   
   
	
	
	
	
	
	
}
