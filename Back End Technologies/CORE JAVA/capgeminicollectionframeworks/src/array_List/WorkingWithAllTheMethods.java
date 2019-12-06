package array_List;

import java.util.ArrayList;
import java.util.Collection;

public class WorkingWithAllTheMethods {
  public static void main(String[] args) {
	
	  Collection c1=new ArrayList();
	  //Adding values to the array list
	  c1.add(12);
	  c1.add(13);
	  c1.add(14);
	  System.out.println(c1);
	  //removing the values from array list
	  c1.remove(12);
	  c1.remove(13);
	  c1.remove(14);
	  System.out.println(c1);
	  //Checking the size of the array list
	  System.out.println(c1.size());
	  //Checking if  the array list is empty or not
	  System.out.println(c1.isEmpty());
	  //Searching using contains()
	  c1.add(12);
	  c1.add(13);
	  System.out.println(c1.contains(12));
	  
	  
}
	
	
	
	
}
