package array_Dequeue;

import java.util.ArrayDeque;
import java.util.Iterator;

public class ArrayDequeue1 {
   public static void main(String[] args) {
	ArrayDeque adq=new ArrayDeque();
    adq.add("Hello");
    adq.add(12);
    adq.add(28);
    adq.add("santua");
    adq.add("Brother");
    adq.add(47);
    adq.add(94);
    System.out.println(adq);
	   
	 Iterator itr=adq.iterator();  
	   while(itr.hasNext()) {
		   System.out.println(itr.next());
	   }
	   
}T
	
	
	
	
	
}
