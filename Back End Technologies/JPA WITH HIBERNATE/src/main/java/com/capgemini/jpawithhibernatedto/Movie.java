package com.capgemini.jpawithhibernatedto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class Movie {
@Id
@Column
private int id;
@Column
private String name;
@Column
private String rating;



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getRating() {
	return rating;
}
public void setRating(String rating) {
	this.rating = rating;
}
@Override
public String toString() {
	return "Id : " + id + "\nName : " + name + "\nRating : " + rating ;
}







	
	
	
}
