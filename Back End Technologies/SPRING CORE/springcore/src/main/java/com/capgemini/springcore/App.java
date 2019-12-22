package com.capgemini.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcore.beans.Animal;
import com.capgemini.springcore.beans.Cat;
import com.capgemini.springcore.beans.Hello;
import com.capgemini.springcore.beans.Pet;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
//    	Hello hello=context.getBean(Hello.class);
//    	System.out.println(hello.getMsg());
//    	System.out.println(hello.getCount());
//    	System.out.println("-----------------------------------");
    	Animal animal=context.getBean(Animal.class);
    	animal.makeSound();
    	
    	Pet pet=context.getBean(Pet.class);
    	System.out.println(pet.getName());
    	pet.getAnimal().makeSound();
    	
    	
    	
    	
    	

    	
    	
    	
    }
}
