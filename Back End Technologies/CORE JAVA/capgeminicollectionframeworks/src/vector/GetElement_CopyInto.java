package vector;

import java.util.Vector;

public class GetElement_CopyInto {
  public static void main(String[] args) {
	  Vector v1=new Vector();
		//1. addElement()
		v1.addElement(12);
		v1.addElement(56);
		v1.addElement(79);
		v1.addElement(123);
		v1.addElement(256);
		 System.out.println(v1);
	  
		 //2. removeElement()
		 v1.removeElement(new Integer(56));
	  v1.removeElement(new Integer(79));
		 System.out.println(v1);
		
		 //3. copyInto() -> copies the values of a vector to an array...
		 Integer i1[]=new Integer[v1.size()];
		 v1.copyInto(i1);
		 System.out.println("---------Printing values of the array --------");
		 for(int i=0;i<i1.length;i++) {
			 System.out.print(i1[i]+"    ");
		 }
		 System.out.println("\n----------------------------------------------");
		 
		 //4.ensureCapacity() -> it ensures that capacity should be minimum ?
		 //if setsize() increases than ensureCapacity() then, capacity will increase to 
		 // double of ensureCapacity()p''
		 System.out.println("capacity: "+v1.capacity());
		 System.out.println("Size:  "+v1.size());
		 v1.trimToSize();
		 System.out.println("capacity: "+v1.capacity());
		 System.out.println("Size:  "+v1.size());
	     v1.ensureCapacity(6);
		 v1.setSize(9);
	     System.out.println("capacity: "+v1.capacity());
		 System.out.println("Size:  "+v1.size());
		 System.out.println(v1);
		 
}
	
	
	
}
