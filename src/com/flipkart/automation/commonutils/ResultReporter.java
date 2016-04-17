package com.flipkart.automation.commonutils;

import java.io.File;
import org.openqa.selenium.WebDriver;

//adding comments

public class ResultReporter {
	
		private static ResultReporter reporter = new ResultReporter( );
		static int counter = 1;
		private String resultWB = "results.xlsx";
		private String resultSht = "Sheet1";
	   
	   /* A private Constructor prevents any other 
	    * class from instantiating.
	    */
	   private ResultReporter(){ 
		   
		   new File(resultWB).delete();
	   }
	
	   /* Static 'instance' method */
	   public static ResultReporter getInstance( ) {
	      return reporter;
	   }
	   
	   /* Other methods protected by singleton-ness */
	   public  void reportPass(String stepDesc, String expectedResult, String actualResult ) {
	      
		   StringBuilder sb = new StringBuilder();
		   
		   
		   sb.append("Step #: " ).append(counter);
		   sb.append(" | Step Status: " ).append("Pass");
		   sb.append(" | Step Desc:" ).append(stepDesc);
		   sb.append(" | Expected Result: ").append(expectedResult);
		   sb.append(" | Actual Result: ").append(actualResult);
		   
		   System.out.println(sb);
		   
		   ExcelUtils.addRowToXL(resultWB, resultSht, new String[]{ ""+counter,"Pass",stepDesc,expectedResult,actualResult});
		   
		   counter++;
		}
	   
	   /* Other methods protected by singleton-ness */
	   public  void reportFailWithSnapshot(String stepDesc, String expectedResult, String actualResult , WebDriver driver) {
	      
		   StringBuilder sb = new StringBuilder();
		   
		   
		   sb.append("Step #: " ).append(counter);
		   sb.append(" | Step Status: " ).append("Fail");
		   sb.append(" | Step Desc:" ).append(stepDesc);
		   sb.append(" | Expected Result: ").append(expectedResult);
		   sb.append(" | Actual Result: ").append(actualResult);
		   
		   ExcelUtils.addRowToXL(resultWB, resultSht, new String[]{ ""+counter,"Failed",stepDesc,expectedResult,actualResult});
		   
		   System.out.println(sb);
		   
		   counter++;
		}
	
	   
	   
	   /* Other methods protected by singleton-ness */
	   public  void reportFail(String stepDesc, String expectedResult, String actualResult ) {
	      
		   StringBuilder sb = new StringBuilder();
		   
		   
		   sb.append("Step #: " ).append(counter);
		   sb.append(" | Step Status: " ).append("Fail");
		   sb.append(" | Step Desc:" ).append(stepDesc);
		   sb.append(" | Expected Result: ").append(expectedResult);
		   sb.append(" | Actual Result: ").append(actualResult);
		   
		   ExcelUtils.addRowToXL(resultWB, resultSht, new String[]{ ""+counter,"Failed",stepDesc,expectedResult,actualResult});
		   
		   System.out.println(sb);
		   
		   counter++;
		}
	   
	   public  void reportInfo(String stepDesc, String expectedResult, String actualResult ) {
		      
		   StringBuilder sb = new StringBuilder();
		   
		   
		   sb.append("Step #: " ).append(counter);
		   sb.append(" | Step Status: " ).append("Info");
		   sb.append(" | Step Desc:" ).append(stepDesc);
		   sb.append(" | Expected Result: ").append(expectedResult);
		   sb.append(" | Actual Result: ").append(actualResult);
		   
		   System.out.println(sb);
		   ExcelUtils.addRowToXL(resultWB, resultSht, new String[]{ ""+counter,"Info",stepDesc,expectedResult,actualResult});
			  
		   
		   counter++;
		}
	   
	   
	   protected static void reportFail( ) {
		      System.out.println("fail"); 
		   }
		   
	   
//	   public static void main(String[] args) {
//		   ResultReporter myReporter = ResultReporter.getInstance( );
//		   myReporter.reportPass( );
//		   myReporter.reportFail();
//	}

}
