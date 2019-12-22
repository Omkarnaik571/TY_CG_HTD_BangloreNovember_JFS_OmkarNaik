package com.capgemini.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Book {

private	String name;
@Autowired
private Author author;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Author getAuthor() {
	return author;
}
public void setAuthor(Author author) {
	this.author = author;
}



}
