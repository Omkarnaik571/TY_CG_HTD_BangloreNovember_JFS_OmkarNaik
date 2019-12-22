package com.capgemini.springcore.usecaseauthorbook;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.bean.Author;
import com.capgemini.bean.BeanClass;
import com.capgemini.bean.Book;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	ApplicationContext context=new AnnotationConfigApplicationContext(BeanClass.class);
    	Book book=context.getBean(Book.class);
    	System.out.println("\nBook Name : "+book.getName());
    	Author author=context.getBean(Author.class);
    	System.out.println("Author Name : "+author.getName());
    	
    	
    	
    }
}
