package com.flipkart.automation.tests;

import org.testng.annotations.Test;

import com.flipkart.automation.commonutils.ResultReporter;
import com.flipkart.automation.pages.Flipkart;
import com.flipkart.automation.pages.FlipkartHomePage;


public class Sanity {
	
	/*
	 * This test is to 
	 * ensure Flipkart url in launching in Chrome browser	
	 */
	@Test
	public void autTC01(){
		
		//
		ResultReporter reporter = ResultReporter.getInstance();
		
		//Setup browere 
		Flipkart flipkart = new Flipkart();
		flipkart.setWebDriver("chrome");
		
		//launch homepage
		FlipkartHomePage homepage= flipkart.launch();
		
		//validate title
		homepage.verifyTitle();		
	}
	
	/*
	 * This test is to 
	 * ensure user is getting error message with incorrect login
	 */
	@Test
	public void autTC02(){
		
		Flipkart flipkart = new Flipkart();
		flipkart.setWebDriver("chrome");
		
		//launch homepage
		FlipkartHomePage homepage= flipkart.launch();
		
		//validate title
		homepage.veriyLogin();		
		
		
	}
	
	/*
	 * This test is to 
	 * ensure signup link is appearing 
	 */
	@Test
	public void autTC03(){
		Flipkart flipkart = new Flipkart();
		flipkart.setWebDriver("chrome");
		
		//launch homepage
		FlipkartHomePage homepage= flipkart.launch();
		
		//validate title
		homepage.verifyElement();	
		
		
	}
	
	
	/*
	 * This test is to 
	 * ensure search text box is appearing
	 */
	@Test
	public void autTC04(){
		
		
	}
	
	
	/*
	 * This test is to 
	 * ensure download app link is appearing and functional
	 */
	@Test
	public void autTC05(){
		
		
	}

}
