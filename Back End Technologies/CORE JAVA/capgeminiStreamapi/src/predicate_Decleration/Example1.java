package predicate_Decleration;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Example1 {
	int age;
	String name;
	
  public Example1(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
  
public int getAge() {
	return age;
}

public String getName() {
	return name;
}

public static void main(String[] args) {
	//1. Predicate using test()
	  
	  Predicate<Integer> p1 = number -> number %2 ==0;   
	
	System.out.println( p1.test(10));
	System.out.println( p1.test(41)); 
	  
	  //2. Function using apply()
	
	System.out.println("------Function using apply()-----");
	Function<Integer, String> f1=i -> String.valueOf(i*100);
	
	String result=f1.apply(10);
	System.out.println(result);
	
	
	//3. Supplier using get() 
	System.out.println("\n------Supplier using get()-----");
     Supplier<Example1> s1= () -> new Example1(22,"Omkar");	
     Supplier<Example1> s2= () -> new Example1(22,"aaryan");	
     System.out.println(s1.get().getAge());	
	System.out.println(s1.get().getName());
	System.out.println(s2.get().getAge());	
	System.out.println(s2.get().getName());
	
	
	//4. Consumer using accept()
	System.out.println("\n------Consumer using accept()s-----");
	Consumer<Example1> c1= accept ->{
		System.out.println(accept.getAge());
		System.out.println(accept.getName());
	};
	
	Example1 e1=new Example1(29,"Satyajit Kumar Naik");
	c1.accept(e1);
	
	
	
	
	
}
	
	
	
	
}
