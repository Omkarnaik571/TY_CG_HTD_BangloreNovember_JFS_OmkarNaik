package array_List;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;

public class RetainAll_containAll_clear {

	public static void main(String[] args) {
	    Collection c4=new ArrayList();
		Collection c5=new ArrayList();
		
		c4.add(25);
		c4.add(23);
		c4.add(82);
		c4.add(96);
		System.out.println("After insertion into C4 :");
		System.out.println("C4 = "+c4);
		
		c5.add(25);
		c5.add(23);
		c5.add(84);
		c5.add(96);
		System.out.println("After insertion into C5 :");
		System.out.println("C5 = "+c5);
		
		c4.retainAll(c5);
		System.out.println("After performing retainAll() on C4 :");
		System.out.println("C4 = "+c4);
		System.out.println("After performing containsAll() on C4 :");
		System.out.println("If contain All: "+c4.containsAll(c5));
		System.out.println("c4 = "+c4);
		System.out.println("c5 = "+c5);
		System.out.println("\nAfter converting to array.....");
		Object[] o1=c5.toArray();
		for(int i=0;i<o1.length;i++) {
			System.out.print(o1[i]+"\t");
		}
		System.out.println();
		System.out.println();
		
		
		
	}
	
	
	
	
}
