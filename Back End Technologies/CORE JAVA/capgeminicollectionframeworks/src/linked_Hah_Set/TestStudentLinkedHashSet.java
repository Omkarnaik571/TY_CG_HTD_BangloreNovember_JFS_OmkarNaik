package linked_Hah_Set;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class TestStudentLinkedHashSet {
 public static void main(String[] args) {
	LinkedHashSet<StudenrType_Linkedhashset> lh=new LinkedHashSet<StudenrType_Linkedhashset>();
	 lh.add(new StudenrType_Linkedhashset("Omkar", 33));
	 lh.add(new StudenrType_Linkedhashset("Biswa", 14));
	 lh.add(new StudenrType_Linkedhashset("Santosh", 56));
	 lh.add(new StudenrType_Linkedhashset("Omkar", 33));
	 Iterator<StudenrType_Linkedhashset> itr=lh.iterator();
	 while(itr.hasNext()) {
		 System.out.println(itr.next());
	 }
	 
	 
	 
}
	
	
	
	
	
}
