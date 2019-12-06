package tree_Map_OR_SortedHashMap;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Tree_Map_Test {
  public static void main(String[] args) {
	  SortingLogicOfBeanClass sl=new SortingLogicOfBeanClass();
//	  SortingLogicBy_Age s2=new SortingLogicBy_Age();
	TreeMap<StudentBean, String> tm=new TreeMap<StudentBean, String>(new SortingLogicBy_Age());
	tm.put(new StudentBean("Omkar", 22), "IT");
	tm.put(new StudentBean("Biswa", 21), "EcE");
	tm.put(new StudentBean("Devi", 23), "CSE/IT");
	tm.put(new StudentBean("Sunil", 24), "IS");
	  
	        Set<Map.Entry<StudentBean, String>> s1=tm.entrySet();  
	      for (Map.Entry<StudentBean, String> e1 : s1) {
			System.out.println(e1.getKey()+" ---> "+e1.getValue());
		}
	
	
}
	
	
	
}
