package tree_Map_OR_SortedHashMap;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Tree_Map {
  public static void main(String[] args) {
	TreeMap<Integer, String> tm=new TreeMap<Integer,String>();
	tm.put(14,"Biswa");  
	tm.put(17,"Devi");
	tm.put(51,"Santua");
	tm.put(33,"Omkar");
	tm.put(67,"Sunil");
	
   //Iteration using entrySet()
	
	  Set<Map.Entry<Integer, String>> s1=tm.entrySet();
	  for (Map.Entry<Integer, String> e1 : s1) {
		System.out.println(e1.getKey()+" : "+e1.getValue());
	}
	  
	
	
	
}
	
	
	
	
}
