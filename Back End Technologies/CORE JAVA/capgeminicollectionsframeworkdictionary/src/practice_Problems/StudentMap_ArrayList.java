package practice_Problems;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class StudentMap_ArrayList {
  public static void main(String[] args) {
	  TreeMap<String, ArrayList<StudentBean>> tm=new TreeMap<String, ArrayList<StudentBean>>();
	  
	  ArrayList<StudentBean> al=new ArrayList<StudentBean>();
	  al.add(new StudentBean("Omkar", 33));
	  al.add(new StudentBean("Sunil", 34));
	  al.add(new StudentBean("Biswa", 37));
	  al.add(new StudentBean("Devi", 39));
	
	  ArrayList<StudentBean> a2=new ArrayList<StudentBean>();  
	  a2.add(new StudentBean("Saif", 31));
	  a2.add(new StudentBean("Santosh", 51));
	  a2.add(new StudentBean("Hanuman", 31));
	  
	  ArrayList<StudentBean> a3=new ArrayList<StudentBean>();  
	  a3.add(new StudentBean("Bali", 78));
	  a3.add(new StudentBean("Raman", 91));
	  a3.add(new StudentBean("Heman", 35));
	  
	  
	  tm.put("Engineering 1st Year", al);
	  tm.put("Engineering 2nd Year", a2);
	  tm.put("Engineering 3rd Year", a3);
//	  System.out.println(tm.get("Engineering 1st Year"));
	  
	     Set<Map.Entry<String, ArrayList<StudentBean>>> s1=tm.entrySet();  
	    for (Map.Entry<String, ArrayList<StudentBean>> e1 : s1) {
			System.out.println(e1.getKey()+" -----> "+e1.getValue());
			System.out.println();
		}
	  
	  
	  
	  
	  
	  
	
	  
	  
	  
	  
	 
	  
	  
	  
	  
}
	
	
	
}
