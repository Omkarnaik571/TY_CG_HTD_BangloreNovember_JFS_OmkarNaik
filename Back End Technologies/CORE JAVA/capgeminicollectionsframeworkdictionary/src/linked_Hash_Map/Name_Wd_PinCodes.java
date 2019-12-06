package linked_Hash_Map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Name_Wd_PinCodes {
 public static void main(String[] args) {
	LinkedHashMap<String,Integer> lhm=new LinkedHashMap<String,Integer>();
	 
	lhm.put("BTM", 560045);
	lhm.put("RJNR", 566043);
	lhm.put("BTR", 569044);
	lhm.put("HEBBAL", 565047);
	lhm.put("OAR", 567849);
	
	//Iterating from HashMap through   "entrySet();"
	 Set<Map.Entry<String, Integer> > s1= lhm.entrySet();
	 for (Map.Entry<String, Integer> e1 : s1) {
		System.out.println(e1.getKey()+" : "+e1.getValue());
		System.out.println("----------");
	}
	 //Removing values from the HashMap, remove(key);
	 lhm.remove("OAR");
	 System.out.println();
	 System.out.println("----------After Removing-------");
	 System.out.println();
	 for (Map.Entry<String, Integer> e1 : s1) {
			System.out.println(e1.getKey()+" : "+e1.getValue());
			System.out.println("----------");	
	 }
	 
	 
}
	
	
	
}
