package com.capgemini.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanClass {

	@Bean(name="author")
	public Author getAuthor() {
		Author author=new  Author();
		author.setName("Stephen King");
		return author;
	}
	
	@Bean(name="book")
	public Book getBook() {
		Book book=new Book();
		book.setName("The Shawsank Redemption");
		return book;
	}
	
	
}
