package hashSet;

import java.util.HashSet;

public class Non_Generic_Hash_Set {
 public static void main(String[] args) {
	
	 HashSet hs=new HashSet();
	 hs.add(12);
	 hs.add(25);
	 hs.add(19);
	 hs.add(58);
     hs.add(null);
	 System.out.println(hs);
	 
	 for (Object object : hs) {
		System.out.println(object);
	}
	 
	 
	 
	 
	 
	 
}
	
	
	
}
