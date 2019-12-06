package linked_List;

import java.util.LinkedList;

public class Peek_Poll_Offer {
  public static void main(String[] args) {
	LinkedList l1=new LinkedList();
	l1.add(24);
	l1.add(44);
	l1.add(54);
	l1.add(79);
	l1.add(9);
	  System.out.println(l1);
	  //1. peek(), peekFirst(), peeklast() -> displays the valu present in 1st and last nodes
	  System.out.println(l1.peek());
	  System.out.println(l1.peekFirst());
	  System.out.println(l1.peekLast());
//	  System.out.println(l1.indexOf(44));
	  //2. poll() pollFirst(),pollLast() ->removes first and last nodes from the list
	  System.out.println(l1);
	  l1.poll();
	  System.out.println(l1);
	  l1.pollFirst();
	  System.out.println(l1);
	  l1.pollLast();
	  System.out.println(l1);
	  
	  //3. offer(),offerFirst(),offerLast() -> offer() adds a value to the 1st node
	  //but offerFirst() and offerLast() are adding values to 1st and last nodes....
	  l1.offer(12);
	  System.out.println(l1);
	  l1.offerFirst(49);
	  System.out.println(l1);
	  l1.offerLast(67);
	  System.out.println(l1);
	  
	  
	  
	  
}
	
	
	
	
}
