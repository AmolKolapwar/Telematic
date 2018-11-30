package com.qa.TestUtill;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.testbase.TestBase;

public class WaitTool {

	
	
	public static boolean waitForElementPresent(WebElement element, int timeOutInSeconds) {
		
		try{
			TestBase.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait() 
			
			WebDriverWait wait = new WebDriverWait(TestBase.driver, timeOutInSeconds); 
			element = wait.until(ExpectedConditions.visibilityOf(element));
			
			TestBase.driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS); //reset implicitlyWait
			return true; //return the element
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
//		return null; 
	}
}
