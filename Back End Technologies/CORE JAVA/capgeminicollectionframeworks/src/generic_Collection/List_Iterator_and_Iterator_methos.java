package generic_Collection;

import java.util.ArrayList;
import java.util.ListIterator;

public class List_Iterator_and_Iterator_methos {
 public static void main(String[] args) {
	 ArrayList<Integer> a1=new ArrayList<Integer>();
		a1.add(12);
		a1.add(24);
		a1.add(36);
		System.out.println(a1);
		
		ListIterator<Integer> itr=a1.listIterator(a1.size());
	    while(itr.hasPrevious()) {
	    	System.out.println(itr.previous());
	    	
	    }
		
		
	 
	 
}
	
	
	
	
}
