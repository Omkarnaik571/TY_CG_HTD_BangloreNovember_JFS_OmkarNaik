package stream_Method;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Number_Of_FaildeStudent_Filter {
	@Override
	public String toString() {
		return "Number_Of_FaildeStudent_Filter []";
	}
	public static void main(String[] args) {
		ArrayList<Integer> a1=new ArrayList<Integer>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number of users you want to add Data Of: ");
		int persons=sc.nextInt();
		int data=0;
		for(int i=1;i<=persons;i++) {
			System.out.println("Enter the data of user "+i+" : ");
			data=sc.nextInt();
			a1.add(data);
		}
		
		System.out.println("----Marks of the Students are: ");
		for (Integer i1 : a1) {
			System.out.print(i1+"   ");
		}
		System.out.println();
		
	List<Integer> l1=a1.stream().filter(m -> m>30).collect(Collectors.toList());
		
		List<Integer> l2=l1.stream().sorted((i,j)-> i.compareTo(j)).collect(Collectors.toList());
		
		int passed=(int) l2.stream().count();
		
		if(passed>0) {
			System.out.println("\nAfter sorting ======>");
			System.out.println(l2);
			System.out.println();
			System.out.println("Total number of passed Students: "+passed);
		System.out.println("----Marks of the Students who have passed are:------- ");
		for (Integer i1 : l1) {
			System.out.println("Marks : "+i1);
		}
	}
		else {
			System.out.println("No students have passed..");
		}
	
	
	
	
	}
}
