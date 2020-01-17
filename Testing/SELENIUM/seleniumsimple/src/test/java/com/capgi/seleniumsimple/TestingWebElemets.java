package com.capgi.seleniumsimple;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestingWebElemets {
	
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.naukri.com");
		Set<String> wbs=driver.getWindowHandles();
		System.out.println("Number of window handles "+wbs.size());
		System.out.println(wbs);
		driver.quit();
	}
	
	

}
