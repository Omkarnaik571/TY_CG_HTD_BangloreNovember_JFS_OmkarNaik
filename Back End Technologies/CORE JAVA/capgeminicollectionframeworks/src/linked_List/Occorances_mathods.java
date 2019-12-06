package linked_List;

import java.util.LinkedList;

public class Occorances_mathods {
 public static void main(String[] args) {
	LinkedList l1=new LinkedList();
	// adding 
	l1.add(23);
	 l1.add(42);
	 l1.add(32);
	 System.out.println(l1);
	 //2. remove()
	 l1.removeFirst();
	 System.out.println(l1);
	 //3. removeFirst() removelast() deletes first and last node from the linked list
	 l1.add(42);
	 //4. removefirstOccurance() and lastoccurance() removes 1st and last repetetion frol the list
	 l1.removeFirstOccurrence(42);
	 System.out.println(l1);
	 //5. getFirst() and getLast() displays the value present in 1st node and last node respectively
	 l1.add(93);
	 l1.add(73);
	 System.out.println(l1);
	 System.out.println(l1.getFirst());
	 System.out.println(l1.getLast());
	 System.out.println(l1.peek());
	 System.out.println(l1.peekFirst());
	 System.out.println(l1.peekLast());
}
	
	
	
	
}
