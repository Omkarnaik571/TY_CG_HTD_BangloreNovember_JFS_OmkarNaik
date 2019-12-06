package vector;

import java.util.Vector;

public class Add_Remove_Iterate {
 public static void main(String[] args) {
	Vector v1=new Vector();
	//1. add()
	v1.add(12);
	v1.add(39);
	v1.add(84);
	v1.add(57);
	v1.add(5);
	 System.out.println(v1);
	 //2. remove(index), remove(value)
	 v1.remove(0);
	 v1.remove(new Integer(57));
	 System.out.println(v1);
	 //3 set(index, value)
	 v1.set(0, 63);
	 System.out.println(v1);
	 //4. Iterate using for loop
	 System.out.println("-----------Iteration using for loop----------");
	 for(int i=0;i<v1.size();i++) {
		 System.out.print(v1.get(i)+"    ");
	 }
	 System.out.println();
	 //5. elementAt(index) ->  returns the value present at a particular index 
	 System.out.println(v1.elementAt(0));
	 //6. capacity() -> by default number of indexes of a vector @10
	 System.out.println(v1.capacity());
	 
	 //7. size() -> the number of indexes which are filled only
	 System.out.println("size = "+v1.size());
	 
	 //8.setSize(size) -> used to set size of a vector,the non filled indexes
	 // will be filled with null values by default
	 
	 v1.setSize(10);
	 System.out.println("Size after setSize() = "+v1.size());
	 System.out.println("values in the vector after setSize() = "+v1);
	 
	 //Set()
	 v1.set(4, 700);
	 v1.set(6, 800);
	 v1.set(8, 900);
	 System.out.println("values in the vector after set() = "+v1);
	 
	 
	 
	 
	 
}
	
	
	
}
