package com.flipkart.automation.pages;

import java.util.Map;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.flipkart.automation.commonutils.BrowserFactory;
import com.flipkart.automation.commonutils.ExcelUtils;
import com.flipkart.automation.commonutils.ResultReporter;

public class Flipkart {
	
	protected static WebDriver driver ;
	private static String filePath = "TestData.xlsx";
	ResultReporter reporter = ResultReporter.getInstance();
	

	public static void setWebDriver(String browser) {
		if(null==driver){
			initDriver(browser);
		}
	}

	private static void initDriver(String browser) {
		if(browser.equalsIgnoreCase("CHROME")){
			driver = BrowserFactory.getChromeDriver();
		}
		
	}

	public FlipkartHomePage launch() {
		String sheetName = "Global";
		int headerRow = 1;
		int dataRow = 2;
		Map<String, String> params = ExcelUtils.getDataRowFromExcel(filePath, sheetName,  headerRow,  dataRow);
		System.out.println(params.get("URL"));
		driver.get(params.get("URL"));
		
		return new FlipkartHomePage();
		
	}

	public void verifyTitle() {
		String sheetName = "Global";
		int headerRow = 1;
		int dataRow = 2;
		Map<String, String> params = ExcelUtils.getDataRowFromExcel(filePath, sheetName,  headerRow,  dataRow);
		
		String expectedTitle = params.get("Title");
		System.out.println(expectedTitle + "<<expected");
		String actualTitle = driver.getTitle();
		
		try{
			Assert.assertEquals(expectedTitle, actualTitle);
			reporter.reportPass("Validate title", "Should be" + expectedTitle, actualTitle);
		}
		catch(Exception e)
		{
			reporter.reportFailWithSnapshot("Validate title", "Should be" + expectedTitle, actualTitle,driver);
		}
		
		
	}
	
	
	 
	
	
}
