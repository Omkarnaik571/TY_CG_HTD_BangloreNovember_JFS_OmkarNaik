package com.capgemini.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcore.beans.Animal;
import com.capgemini.springcore.beans.Pet;

public class XmlComponentScanTest {
  public static void main(String[] args) {
	ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
	
	Animal animal=context.getBean(Animal.class);
	  animal.makeSound();
	  
	  Pet pet=context.getBean(Pet.class);
	  pet.getAnimal().makeSound();
	  
	  
}
	
	
	
	
	
}
