package linked_List;

import java.util.LinkedList;
import java.util.ListIterator;

public class Adding_and_Removing {
 public static void main(String[] args) {
	LinkedList l1=new LinkedList();
	 l1.add(12);
	 l1.add(14);
	 l1.add(16);
	 l1.add(18);
	 l1.add(12);
	 l1.add(null);
	 System.out.println(l1);
	 l1.remove(new Integer(12));
	 l1.remove(null);
	 System.out.println(l1);
	 l1.add(2, 44);
	 System.out.println(l1);
	 System.out.println("l1 = "+l1);
	 ListIterator iter=l1.listIterator(l1.size());
	 while(iter.hasPrevious()) {
		 System.out.print(iter.previous()+"\t");
	 }
	 System.out.println();
	 for(Object i1:l1) {
		 System.out.print(i1+"  ");
		 
	 }
	 System.out.println();
	 
	 for(int i=0;i<l1.size();i++) {
		 System.out.print(l1.get(i)+"  ");
	 }
	 
	 
	 
}
	
	
}
