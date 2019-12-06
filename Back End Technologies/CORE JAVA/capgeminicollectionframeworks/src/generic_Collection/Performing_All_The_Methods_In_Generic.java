package generic_Collection;

import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Performing_All_The_Methods_In_Generic {
 public static void main(String[] args) {
	
	 ArrayList<String> a1=new ArrayList<String>();
	 ArrayList<Integer> a2=new ArrayList<Integer>();
	 //adding value
	 a1.add("Omkar");
	 a1.add("aaryan");
	 a1.add("Biswajit");
	 System.out.println(a1);
	 
	 //Removing the values through value
	 a1.remove("Biswajit");
	 System.out.println(a1);
	 
	//Removing the values through value appart from String
	 a2.add(12);
	 a2.add(24);
	 System.out.println(a2);
	 a2.remove(new Integer(12));
	 System.out.println(a2);
	 
	 //Size of the Array list
	 System.out.println(a1.size());
	 //is empty()
	 System.out.println(a1.isEmpty());
	 //last indexof()
	 System.out.println(a2.lastIndexOf(new Integer(24)));
	 a1.add("Biswajit");
	 //Retriveing the value from Array List using For loop
	 System.out.print("Retriveing the value from Array List using For loop:\t");
	 for(int i=0;i<a1.size();i++) {
         System.out.print(a1.get(i)+"\t");
	 }
	 
	 System.out.println();
	 //Retriveing the value from Array List using For each loop
	 System.out.print("Retriveing the value from Array List using For each loop:\t");
	 for(String i1:a1) {
         System.out.print(i1+"\t");
	 }
	 
	 // Retriveing the value from Array List using iterator
	 System.out.println();
	 System.out.print("Retriveing the value from Array List using iterator:\t");
	 java.util.Iterator<String> itr=a1.iterator();
	 while(itr.hasNext()) {
		 System.out.print(itr.next()+"\t");
	 }
	 
	// Retriveing the value from Array List using Listiterator
		 System.out.println();
		 System.out.print("Retriveing the value from Array List using List iterator:\t");
		 java.util.ListIterator<String> iter=a1.listIterator(a1.size());
		 while(iter.hasPrevious()) {
			 System.out.print(iter.previous()+"\t");
		 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
	
	
	
	
}
