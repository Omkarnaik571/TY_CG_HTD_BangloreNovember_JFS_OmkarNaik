package com.capgemini.springcore.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Hello implements InitializingBean,DisposableBean{

	private String msg;
	private int count;

	
	
	public Hello() {
		System.out.println("Object created..");
		// TODO Auto-generated constructor stub
	}
	
//	public void init() {
//		System.out.println("Init method");
//	}
//	@Override
//	public void destroy() {
//		System.out.println("destroy method");
//	}
     @PostConstruct	
	public void init() {
		System.out.println("Init method");
	}
     @PreDestroy
     public void destroy() {
 		System.out.println("destroy method");
 	}
	
	
	
	public Hello(String msg, int count) {
		super();
		this.msg = msg;
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("after set properties method..");
		
		// TODO Auto-generated method stub
		
	}
	
	
}
