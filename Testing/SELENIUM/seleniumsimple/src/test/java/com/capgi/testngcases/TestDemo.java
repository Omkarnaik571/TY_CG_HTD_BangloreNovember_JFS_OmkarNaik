package com.capgi.testngcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestDemo {

	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	
	@Test
	public void demo1() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
	     Reporter.log("from test demo 1",true);
	}
	
	@Test
	public void demo3() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
	     Reporter.log("from test demo 2",true);
	}
	
}
