package priority_Queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class Offer_Poll {
 public static void main(String[] args) {
	Queue qs=new PriorityQueue();
	qs.offer(97);
	qs.offer(197);
	qs.offer(297);
	qs.offer(76);
	qs.offer(34);
	qs.offer(8);
	System.out.println(qs);
	qs.remove();
	qs.poll();
	System.out.println(qs);
	 
	for (Object o1 : qs) {
		System.out.println(o1);
	}
	
	
	
	 
	 
	 
}
	
	
	
	
	
}
