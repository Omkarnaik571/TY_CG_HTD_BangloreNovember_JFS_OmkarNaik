package com.capgemini.jpawithhibernatedto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="product_info ")
public class ProductDto {
@Id
@Column	
private int id;
@Column
private String name;

	
	
	
	
}
