package stream_Method;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Map_Method {
  public static void main(String[] args) {
	  ArrayList<Integer> a1=new ArrayList<Integer>();
		a1.add(12);
		a1.add(25);
		a1.add(36);
		a1.add(19);
		a1.add(72);
		a1.add(91);
	  
	  List<Integer> l1= a1.stream().map(i -> i*100).collect(Collectors.toList());
		System.out.println(l1);
		
		
	//Print the maximum value	using stream().max()
		
		Optional<Integer> result=a1.stream().max((i,j)-> i.compareTo(j));
		
		System.out.println(result);
		
		System.out.println(a1.stream().count());
		
	  
}
	
	
	
}
