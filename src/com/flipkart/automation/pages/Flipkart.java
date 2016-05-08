package com.flipkart.automation.pages;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		if(browser.equalsIgnoreCase("chrome")){
			driver = BrowserFactory.getChromeDriver();
		}
		
		if(browser.equalsIgnoreCase("firefox")){
			driver = BrowserFactory.getFirefoxDriver();
		}
		
	}

	public FlipkartHomePage launch() {
		String sheetName = "Global";
		int headerRow = 1;
		int dataRow = 2;
		Map<String, String> params = ExcelUtils.getDataRowFromExcel(filePath, sheetName,  headerRow,  dataRow);
		System.out.println(params.get("URL"));
		driver.get(params.get("URL"));
		
		reporter.reportPass("validate title", "should be ", "is " + driver.getTitle());
		
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
	public void veriyLogin()
	{
	String sheetName="Login";
	int headerRow = 1;
	int dataRow = 2;
	Map<String, String> params = ExcelUtils.getDataRowFromExcel(filePath, sheetName,  headerRow,  dataRow);
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.findElement(By.linkText("Log In")).click();
	
	
	
	String expectedID = params.get("UserID");
	String expectedPass = params.get("Password");
	//System.out.println(expectedTitle + "<<expected");
	
	WebElement UserIDelement= driver.findElement(By.cssSelector("input[class='fk-input login-form-input user-email'][type='text']"));
	//WebElement UserIDelement= driver.findElement(By.className("input[class='fk-input login-form-input user-email'][type='text']"));
	boolean present;
	present = true;
	
	UserIDelement.sendKeys(expectedID);
	/*try{
		Assert.assertEquals(expectedID, UserIDelement);
		reporter.reportPass("Validate title", "Should be" + expectedID, UserIDelement);
	}
	catch (NoSuchElementException e)
	{
	  present = false;
	}*/
	//driver.findElement(By.cssSelector("input[class='fk-input login-form-input user-email'][type='text']")).sendKeys("expectedID");
	//driver.findElement(By.cssSelector("input[class='fk-input login-form-input user-pwd'][type='password']")).sendKeys("shilpi25#");
	
	WebElement UserPassword=driver.findElement(By.cssSelector("input[class='fk-input login-form-input user-pwd'][type='password']"));
	UserPassword.sendKeys(expectedPass);
	//boolean present1;
	//try {
		driver.findElement(By.cssSelector("input[class='submit-btn login-btn btn'][type='button']")).click();
	//present1 = true;
	 // System.out.println("Hello");
	   //} catch (NoSuchElementException e)
	/*{
	  present1 = false;
	}*/
	}
	
public void verifyElement() {
		
		driver.findElement(By.cssSelector("input[class='LM6RPg'][type='text']")).sendKeys("Mobile");
		
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("Number of iframes on the page are " + numberOfFrames);

		//By finding all the web elements using iframe tag
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println("The total number of iframes are " + iframeElements.size());
		
	   driver.findElement(By.cssSelector("input[value='SEARCH'][type='submit']")).click();
	   
	   driver.findElement(By.linkText("Download App")).click();
	   
		   //driver.close();

	}

}
