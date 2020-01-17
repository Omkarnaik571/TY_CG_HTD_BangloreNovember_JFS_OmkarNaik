package com.capgi.seleniumsimple;

public class RunningTestDemo {
	
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}

	public static void main(String[] args) {
		TestDemo testDemo=new TestDemo();
		testDemo.demo1();
		
	}
	
	
}
