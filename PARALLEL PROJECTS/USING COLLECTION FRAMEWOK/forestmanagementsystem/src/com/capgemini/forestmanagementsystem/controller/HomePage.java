package com.capgemini.forestmanagementsystem.controller;

import java.util.Scanner;

import com.capgemini.forestmanagementsystem.validations.Validations;


public class HomePage {
	public static void main(String[] args) {
		while(true) {
		System.out.println("\n--------------------------FOREST MANAGEMENT SYSTEM-------------------\n");
		System.out.println("1 Admin Page");
		System.out.println("2 Client Page");
		System.out.println("3 Scheduler Page");
		Scanner sc=new Scanner(System.in);
		char a='n';
		String choice=null;
		while(a=='n') {
		    choice=sc.next();
			if(Validations.isNumber1(choice)) {
				a='x';
			}
			else {
				System.err.println("ENTER THE CHOICES IN INTEGER VALUES !!");
			}
		}
		int page=Integer.parseInt(choice);
		switch (page) {
		case 1:
           AdminPage.adminPage();
           break;
		case 2:
           ClientPage.clientPage();
			break;
		case 3:
	        SchedulerPage.schedulerPage();      
				break;
		default:
			System.err.println("\nPLEASE SELECT A VALID OPTION \n");
			break;
		}

		}
	}



}
