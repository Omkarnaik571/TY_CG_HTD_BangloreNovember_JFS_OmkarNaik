package clonnableMethod;

public class TestVehicle {
  public static void main(String[] args) throws CloneNotSupportedException {
	
	  Vehicle v1=new Vehicle("Omkar");
	  Vehicle v2=(Vehicle)v1.clone();
	  System.out.println(v1.name);
	  System.out.println(v2.name);
}
	
	
	
	
}
