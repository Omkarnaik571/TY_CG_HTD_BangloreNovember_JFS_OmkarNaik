package com.capgi.suitetestclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestClass {

	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	
	WebDriver driver;
	
	@BeforeMethod
	public void login() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");
		System.out.println("Before");
	}
	
	@AfterMethod
	public void close() {
		driver.close();
		Reporter.log("closing",true);
	}
	
	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("before suite",true);
	}
	
	@BeforeTest
	public void beforeTest() {
		Reporter.log("before test",true);
	}
	
	@BeforeClass
	public void beforeClass() {
		Reporter.log("before class",true);
	}
	
	@AfterSuite
	public void afterSuite() {
		Reporter.log("after suite",true);
	}
	
	@AfterTest
	public void afterTest() {
		Reporter.log("after suite",true);
	}
	
	@AfterClass
	public void afterClass() {
		Reporter.log("after class",true);
	}
	
	
	
	
	
	
	
	
	
	
	
}
