package com.flipkart.automation.commonutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	private static WebDriver driver ;
	
	public static WebDriver  getChromeDriver(){
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

}
