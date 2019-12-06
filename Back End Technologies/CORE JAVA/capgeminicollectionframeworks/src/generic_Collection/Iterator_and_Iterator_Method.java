package generic_Collection;

import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Iterator_and_Iterator_Method {

	public static void main(String[] args) {
		ArrayList<Integer> a1=new ArrayList<Integer>();
		a1.add(12);
		a1.add(24);
		a1.add(36);
		System.out.println(a1);
		java.util.Iterator<Integer> itr=a1.iterator(); 
		
		while(itr.hasNext()) {
          System.out.println(itr.next());
		}
		
		
		
		
	}
	
	
	
}
