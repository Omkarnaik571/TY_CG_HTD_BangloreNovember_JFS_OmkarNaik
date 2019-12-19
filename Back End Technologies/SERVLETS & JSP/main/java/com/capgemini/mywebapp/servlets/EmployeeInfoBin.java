package com.capgemini.mywebapp.servlets;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="employee_info")
public class EmployeeInfoBin {
@Id
@Column(name="emp_id")
private int empId;
@Column
private String name;
@Column
private double salary;
@Column
private int age;
@Column
private String designation;
@Column
private String password;
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

	
	
	
}
