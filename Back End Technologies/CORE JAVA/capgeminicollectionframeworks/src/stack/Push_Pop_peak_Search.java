package stack;

import java.util.Stack;

public class Push_Pop_peak_Search {

	public static void main(String[] args) {
		Stack s1=new Stack();
		s1.add(23);
		s1.add(43);
		s1.add(73);
		System.out.println(s1);
		//1. push()
		s1.push(43);
		System.out.println(s1);
		//2. pop()
		s1.pop();
		s1.pop();
		System.out.println(s1);
		//3. peek()
		System.out.println(s1.peek());
		//4. search()
		System.out.println(s1);
		
		System.out.println("index of 43: "+s1.search(new Integer(43)));
		System.out.println(s1.search(new Integer(23)));
		System.out.println(s1.indexOf(new Integer(43)));
		
	}
	
	
	
}
