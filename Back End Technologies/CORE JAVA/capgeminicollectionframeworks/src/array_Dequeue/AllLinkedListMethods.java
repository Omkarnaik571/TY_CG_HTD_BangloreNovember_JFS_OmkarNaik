package array_Dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

public class AllLinkedListMethods {
 public static void main(String[] args) {
	ArrayDeque<BeanClass_PriorityQueue> ad=new ArrayDeque<BeanClass_PriorityQueue>();
     ad.offer(new BeanClass_PriorityQueue("Omkar", 33));
     ad.offer(new BeanClass_PriorityQueue("Omkar", 33));
     ad.offer(new BeanClass_PriorityQueue("Omkar", 33));
     ad.offer(new BeanClass_PriorityQueue("Omkar", 33));
     
     
     for (BeanClass_PriorityQueue b1 : ad) {
		System.out.println(b1);
	}
	 
	 
	 
}
	
	
	
	
}
