package hash_Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Putting_and_enteySet {
 public static void main(String[] args) {
	HashMap<Integer, String> hm=new HashMap<Integer,String>();
	 hm.put(14, "Biswa");
	 hm.put(51, "santosh");
	 hm.put(17, "Devi");
	 hm.put(33, "Omkar");
			
	//Iterating values through entrySet()		
	 
	      Set<Map.Entry<Integer, String>> s1=hm.entrySet();
	 for (Map.Entry<Integer, String> e1 : s1) {
		System.out.println(e1.getKey()+" : "+e1.getValue());
	}
	 
	 //Iterating through keySet()
	 System.out.println("--Iterating through keySet()-----");
	 Set<Integer> s2=hm.keySet();
	 for (Integer i1 : s2) {
		System.out.println(i1+" : "+hm.get(i1));
	}
	      
	      
	      
	 
}
	
	
	
	
	
	
}
