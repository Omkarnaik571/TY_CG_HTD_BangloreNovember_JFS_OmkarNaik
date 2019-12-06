package array_List;

import java.util.ArrayList;
import java.util.List;

public class Add_Remove_IndexOf_LastIndexOf_Get {
  public static void main(String[] args) {
	List l1=new ArrayList();
	List l2=new ArrayList();
	
	l1.add(12);
	l1.add(14);
	l1.add(16);
	l1.add(8);
	l1.add(4);
	System.out.println(l1);
	 
	//adding the particular element at a index    @@@@ add();
	l1.add(0, 22);
	l1.add(1, 24);
	l1.add(2, 26);
	System.out.println(l1);
	
	//Removing the element at a particular index   @@@@@   remove();
	l1.remove(3);
	l1.remove(3);
	l1.remove(3);
	System.out.println(l1);
	
	System.out.println();
	
	//Retriving the values from the array list with index  @@@@  get();   
	for(int i=0;i<l1.size();i++) {
		System.out.println("Element in the postion  "+i+" : "+l1.get(i)+"\t");
	}
	
	//adding value to particular index by replacing the existing value @@@@ set();
	l1.set(0, 12);
	l1.set(1, 14);
	l1.set(2, 16);
	System.out.println("\nAfter replacing the old values with new Values: ");
	for(int i=0;i<l1.size();i++) {
		System.out.println("Element in the postion  "+i+" : "+l1.get(i)+"\t");
		
	}
	
	//Getting the last index of the array list
	System.out.println(l1.lastIndexOf(8));
	System.out.println(l1.size());
	
	
	l2.add(44);
	l2.add("Omkar");
	l2.add(12.44);
	
	l1.addAll(2, l2);
	for(int i=0;i<l1.size();i++) {
		System.out.println("Element in the postion  "+i+" : "+l1.get(i)+"\t");
	}
	
	  
}
	
	
	
	
	
}
