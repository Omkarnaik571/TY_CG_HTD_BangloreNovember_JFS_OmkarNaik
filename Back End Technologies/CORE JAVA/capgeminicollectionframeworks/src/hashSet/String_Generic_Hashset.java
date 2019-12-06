package hashSet;

import java.util.HashSet;

public class String_Generic_Hashset {
  public static void main(String[] args) {
	HashSet<String> hs=new HashSet<String>();
	
	  hs.add(null); 
	  hs.add("Omkar");
	  hs.add("Aaaryan");
	  hs.add("biswa");
	  hs.add("Devi");
	  hs.add("Santosh");
//	  hs.add(null);
	  for (String string : hs) {
		System.out.println(string);
//		System.out.println(string.hashCode());        
	}
	  
	  
}
	
	
	
}
