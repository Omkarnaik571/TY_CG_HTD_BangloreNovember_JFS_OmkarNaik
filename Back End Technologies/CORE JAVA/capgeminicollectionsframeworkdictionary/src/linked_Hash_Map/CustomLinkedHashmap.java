package linked_Hash_Map;

import java.util.LinkedHashMap;

public class CustomLinkedHashmap {
   public static void main(String[] args) {
	LinkedHashMap<Integer, CustomLinkedHahMapBeanClass> lhm=new LinkedHashMap<Integer, CustomLinkedHahMapBeanClass>();
	lhm.put(1, new CustomLinkedHahMapBeanClass(27000, "Biswa"));   
	lhm.put(2, new CustomLinkedHahMapBeanClass(0, "Devi"));
	lhm.put(3, new CustomLinkedHahMapBeanClass(30000, "Omkar"));
	
	int capacity=lhm.size();
	System.out.println("-----Printing the Details---------");
	for(int i=1;i<=capacity;i++) {
		System.out.println(lhm.get(i));
		System.out.println("---------------");
	}
	
	
	
	   
	   
}
	
	
}
