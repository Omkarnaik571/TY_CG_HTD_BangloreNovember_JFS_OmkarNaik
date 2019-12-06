package com.Capgemini.junit.junit_5;

import java.util.Scanner;

public class Calculator {

	public int add(int a,int b) {
		return a+b;
	}
	
	public int multiply(int a,int b) {
		return a*b;
	}
	public int devide(int a,int b) {
		
		return a/b;
	}
	
	
	public int findLength(String name) {
		int length=name.length();
		return length;
	}
	
	
	
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the 1st Number:");
		int a=sc.nextInt();
		System.out.println("Enter the 2nd Number:");
		int b=sc.nextInt();
		Calculator c1=new Calculator();
		int result=c1.add(a, b);
		System.out.println("Sum : "+result);
		int multiply=c1.multiply(12, 4);
	}
	
	
	
	
	
}
