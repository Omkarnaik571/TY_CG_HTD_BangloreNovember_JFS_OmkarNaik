package com.Capgemini.junit.junit_5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalTest {
	Calculator c=null;
	
	@BeforeEach
   void createObject() {
		c=new Calculator();
		
	}
	@Test
	void test() {
//		c=new Calculator();
		int i=c.add(12, 5);
	     assertEquals(17, i);
	}
	@Test
	void test2() {
		 c=new Calculator();
		int result=c.add(-2, -6);
		assertEquals(-8, result);	
	}
	
	@Test
	void testMultiply(){
		 c=new Calculator();
		int result=c.multiply(12, 5);
		assertEquals(60, result);
		
	}
	
	@Test
  	void  testDevide(){
		c=new Calculator();
		int result=c.devide(10, 5);
		assertEquals(2, result);
	}
	@Test
   void testArithmeticException(){
		c=new Calculator();
		assertThrows(ArithmeticException.class, 
				()->{
					c.devide(10, 0);
				}
				
				);
	}
	
	@Test
	void testFindLength() {
		c=new Calculator();
		int result=c.findLength("Omkar");
		assertEquals(5, result);
	}
	@Test
	void testFindLengthNull() {
		c=new Calculator();
		int result=c.findLength("Omkar");
		assertEquals(5, result);	
	}
	@Test
	void testNullPointerException() {
		c=new Calculator();
		assertThrows(NullPointerException.class,
				()->{
					c.findLength(null);
				}
				);	
	}
	
	

}
