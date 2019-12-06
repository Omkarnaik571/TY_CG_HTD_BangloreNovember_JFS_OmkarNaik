package singleDimentionalArray;
import java.util.*;
public class Array1 {
    public static void main(String[] args) {
		int []arr=new int[5];
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the values into the array:");
		for(int i=0;i<arr.length;i++){
			arr[i]=sc.nextInt();
		}
		System.out.println("Values entered inside the array are:");
    	for(int i=0;i<arr.length;i++){
    		System.out.print(arr[i]+"\t");
    	}
    	//Sorting the array
    	int temp=0;
    	for(int i=0;i<arr.length;i++){
    	  for(int j=i+1;j<arr.length;j++){
    		if(arr[i]>arr[j]){
    			temp=arr[i];
    			arr[i]=arr[j];
    			arr[j]=temp;
    		}
        	}
    	}
    	System.out.println("\nAfter sorting");
    	for(int i=0;i<arr.length;i++){
    		System.out.print(arr[i]+"\t");
    	}
    	
    	
    	
	}
	
	
	
	
}
