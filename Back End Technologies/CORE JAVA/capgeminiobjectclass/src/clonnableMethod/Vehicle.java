package clonnableMethod;

public class Vehicle implements Cloneable {

	 String name;
	  
	  public Vehicle(String name) {
		// TODO Auto-generated constructor stub
	     this.name=name;
	  }
	  
		@Override
		protected Object clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			return super.clone();
		}
	
	
	
	
}
