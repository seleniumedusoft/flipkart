package com.flipkart.automation.tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.flipkart.automation.commonutils.ResultReporter;
import com.flipkart.automation.pages.Flipkart;
import com.flipkart.automation.pages.FlipkartHomePage;

public class Sanity {

	ResultReporter reporter;
	FlipkartHomePage homepage;
	String browser ;

	@BeforeSuite
	public void setupTestSuite() {
		System.out.println("inside before suite");
		reporter = ResultReporter.getInstance();

	}

	@BeforeMethod
	public void setup() {
		System.out.println("inside before method");
		Flipkart flipkart = new Flipkart();
		flipkart.setWebDriver(browser);

		// launch homepage
		homepage = flipkart.launch();

	}

	@AfterMethod
	public void tearDown() {
		System.out.println("inside after methods");
		// flipkart.close();
	}
	
	@Parameters({ "browser"	})
	@BeforeTest
	public void setupForTestNG_XMLTest(@Optional("chrome") String _browser){
		System.out.println("inside before test for " + _browser);
		browser = _browser;
	}

	/*
	 * This test is to ensure Flipkart url in launching in Chrome browser
	 */
	@Test
	public void autTC01() {

		// validate title
		homepage.verifyTitle();
	}

	/*
	 * This test is to ensure user is getting error message with incorrect login
	 */
	@Test
	public void autTC02() {

		// validate title
		homepage.veriyLogin();

	}

	/*
	 * This test is to ensure signup link is appearing
	 */
	//@Test
	public void autTC03() {

		// validate title
		homepage.verifyElement();

	}

	/*
	 * This test is to ensure search text box is appearing
	 */
	//@Test
	public void autTC04() {

	}

	/*
	 * This test is to ensure download app link is appearing and functional
	 */
	//@Test
	public void autTC05() {

	}

}
