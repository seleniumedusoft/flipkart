package com.flipkart.automation.commonutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	private static WebDriver driver ;
	
	public static WebDriver  getChromeDriver(){
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	public static WebDriver  getFirefoxDriver(){
		//System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new FirefoxDriver();
		return driver;
	}

}
