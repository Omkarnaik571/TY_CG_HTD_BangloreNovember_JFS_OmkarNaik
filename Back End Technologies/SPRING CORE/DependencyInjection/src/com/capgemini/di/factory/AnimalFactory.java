package com.capgemini.di.factory;

import com.capgemini.di.dao.Animal;
import com.capgemini.di.dao.Dog;

public class AnimalFactory {

	
	public AnimalFactory() {
		
	}
	
	public static Animal getAnimal() {
		return new Dog();
	}
	
	
	
}
