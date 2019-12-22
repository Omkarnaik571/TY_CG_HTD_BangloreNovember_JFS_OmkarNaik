package com.capgemini.springcore.beans;

import org.springframework.stereotype.Component;

@Component
public class Cat implements Animal {

	@Override
	public void makeSound() {
		System.out.println("Meaooooooooooooooo");
		
	}
	
}
