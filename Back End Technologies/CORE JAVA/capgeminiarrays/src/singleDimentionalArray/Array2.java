package singleDimentionalArray;
import java.util.*;
public class Array2 {

	double []drr=new double[4];
	
	public static void main(String[] args) {
		Array2 a2=new Array2();
		Scanner sc=new Scanner(System.in);
	System.out.println("Enter the values in double array: ");
	for(int i=0;i<a2.drr.length;i++){
		a2.drr[i]=sc.nextDouble();
	}
	System.out.println("The values entered are: ");
	for(int i=0;i<a2.drr.length;i++){
	   System.out.print(a2.drr[i]+"\t");
	}	
		
		
		
	}
	
	
	
}
