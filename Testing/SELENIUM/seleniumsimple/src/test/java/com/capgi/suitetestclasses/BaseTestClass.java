package com.capgi.suitetestclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class BaseTestClass extends TestClass {

//	static {
//		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
//	}
	
	@Test
	public void testMethod() {
		
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
	}
	
	
	
}
