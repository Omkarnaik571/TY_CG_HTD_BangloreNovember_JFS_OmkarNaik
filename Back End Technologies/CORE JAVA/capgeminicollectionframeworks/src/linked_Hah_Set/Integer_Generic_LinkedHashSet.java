package linked_Hah_Set;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class Integer_Generic_LinkedHashSet {
  public static void main(String[] args) {
	LinkedHashSet<Integer> lh=new LinkedHashSet<Integer>();
	lh.add(24);
	lh.add(47);
	lh.add(41);
	lh.add(58);
	lh.add(94);
	
	System.out.println("Output using Iterator-------");
	Iterator<Integer> itr=lh.iterator();
	while(itr.hasNext()) {
		System.out.println(itr.next());
	}
	System.out.println("Output using For each loop-------");
	  for (Integer i1 : lh) {
		
		  System.out.println(i1);
	}
	  
	 LinkedHashSet l1=new LinkedHashSet();
	  l1.add(12);
	  l1.add(24);
	  l1.add(12);
	  System.out.println(l1);
	  
	  
	  
	  
	  
}
	
	
	
	
}
