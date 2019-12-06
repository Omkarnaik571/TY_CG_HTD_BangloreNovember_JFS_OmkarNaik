package linked_List;

import java.util.LinkedList;

public class Push_Pop_Elements {
 public static void main(String[] args) {
	LinkedList l1=new LinkedList();
	l1.add(12);
	l1.add(13);
	l1.add(14);
	System.out.println(l1);
	//1. push(paramieter) -> it is used to add value in the 1st node to the lists
	 l1.push(11);
	 System.out.println(l1);
	 //2. pop() -> it removes the 1st node from the list 
	 l1.pop();
	 System.out.println(l1);
	 //3. element() -> it gives the value present in the 1st node
	 System.out.println(l1.element());
	 
}
	
	
}
