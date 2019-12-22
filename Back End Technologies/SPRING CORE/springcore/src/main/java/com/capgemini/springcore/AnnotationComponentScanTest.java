package com.capgemini.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.springcore.annotationconfig.ComponentScanConfig;
import com.capgemini.springcore.beans.Animal;
import com.capgemini.springcore.beans.Pet;

public class AnnotationComponentScanTest {
  public static void main(String[] args) {
	
	  ApplicationContext context=new AnnotationConfigApplicationContext(ComponentScanConfig.class);
	  
	  Animal animal=context.getBean(Animal.class);
	  animal.makeSound();
	  
	  Pet pet=context.getBean(Pet.class);
	  pet.getAnimal().makeSound();
	  
}
	
	
	
}
