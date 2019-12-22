package com.capgemini.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.springcore.annotationconfig.BeansConfig;
import com.capgemini.springcore.beans.Animal;
import com.capgemini.springcore.beans.Dog;
import com.capgemini.springcore.beans.Hello;
import com.capgemini.springcore.beans.Pet;

public class AnnotationConfigApp {
public static void main(String[] args) {
	
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(BeansConfig.class);
	
	Hello hello=context.getBean(Hello.class);
	System.out.println("\n"+hello.getMsg());
	System.out.println(hello.getCount());
	System.out.println(hello);
	Hello hello1=context.getBean(Hello.class);
	Hello hello2=context.getBean(Hello.class);
	System.out.println("\n"+hello1.getMsg());
	System.out.println(hello1.getCount());
	System.out.println(hello1);
	System.out.println("\n"+hello2.getMsg());
	System.out.println(hello2.getCount());
	System.out.println(hello2);
	
	Animal animal=context.getBean(Animal.class);
	System.out.println();
	animal.makeSound();
	
	Pet pet=context.getBean(Pet.class);
	System.out.println("-------------------------");
	System.out.println("\n"+pet.getName());
	pet.getAnimal().makeSound();
	
	
	
	context.close();
	
}
	
	
	
	
	
}
