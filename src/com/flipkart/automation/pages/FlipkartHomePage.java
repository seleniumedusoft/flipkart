package com.flipkart.automation.pages;



import com.flipkart.automation.pagesobjects.FlipKartHomePageObjects;

public class FlipkartHomePage extends Flipkart{
	
	FlipKartHomePageObjects homepageObjects = new FlipKartHomePageObjects();

	public void openURL(){
		driver.get("http://www.flipkart.com");
	}
	
	public void clickLogin() {
		driver.findElement(homepageObjects.getTxtLogin()).click();
	}

}
