package hash_Map;

import java.util.Collection;
import java.util.HashMap;

public class Values_MethodContainsKey_containsValue {
  public static void main(String[] args) {
	HashMap<Integer, ValuesmethosBeanclass> hm=new HashMap<Integer, ValuesmethosBeanclass>();
	hm.put(1, new ValuesmethosBeanclass("Omkar", 33));
	hm.put(2, new ValuesmethosBeanclass("Biswa", 14));
	hm.put(3, new ValuesmethosBeanclass("Devi", 17));
	hm.put(4, new ValuesmethosBeanclass("santosg", 51));
	
	//Iterating through values()
	
	          Collection<ValuesmethosBeanclass> c1 =hm.values();
	  for (ValuesmethosBeanclass v1 : c1) {
		System.out.println(v1);
	}
	  
	  //1. containsKey()
	  System.out.println("Key Result : "+hm.containsKey(1));
	  
	  //2. containsValue()
	  System.out.println("Value Result : "+hm.containsValue(new ValuesmethosBeanclass("Biswa", 14)));
}
	
	
	
	
	
	
}
