package com.capgemini.springcore.annotationconfig;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.capgemini.springcore.beans.Cat;
import com.capgemini.springcore.beans.Dog;
import com.capgemini.springcore.beans.Hello;
import com.capgemini.springcore.beans.Pet;

@Configuration
public class BeansConfig  {

	@Bean("hello")
//	@Scope("prototype")
	public Hello getHello() {
		Hello hello=new Hello();
		hello.setMsg("LOVE YOU");
		hello.setCount(3000);
		return hello;
		
	}	
	
	@Bean(name="dog")
	public Dog getDog() {
		return new Dog();
	}
	
	@Bean(name="cat")
	@Primary
	public Cat getCat() {
		return new Cat();
	}
	
	@Bean(name="pet")
	public Pet getPet() {
		Pet pet=new Pet();
		pet.setName("Devi");
//		pet.setAnimal(getDog());
		
		return pet;
	}


	




}
