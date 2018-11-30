package com.qa.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.testbase.TestBase;

import coma.qa.pages.LoginPage;

public class LoginTestPage extends TestBase {

	Logger log = Logger.getLogger(LoginTestPage.class);	
	LoginPage loginpage;
	
	
	public LoginTestPage(){
		super();
	}
	
	
	@BeforeMethod
	public void setup(){
		
		intialization();
		loginpage =new LoginPage();
	}
	
	
	@Test(description ="Login UI Components visiblity",priority=1)
	
	public void verify_Login_UI(){
		System.out.println("---------------------Verify UI Components Start-------");
		System.out.println("Checking UI Compoents: "+  this.getClass());
	    assertTrue(loginpage.verifyLoginPage_UIComponents(), "");
	    System.out.println("-------------------------------------------------------");
	}
	
	
	@Test(description ="Verify Valid Login",priority=2)
	public void verify_Valid_Login(){
		System.out.println("-----------------------");
		System.out.println("Testing the Valid Login Scenario:"+ this.getClass());
		loginpage.dologin("amitk1234@mailinator.com", "Testing$123");
		if(driver.getCurrentUrl().endsWith("home")){
			System.out.println("Login sucessfull");	
		}else{	
			System.out.println("Login Failed");
		}	
		System.out.println("-------------------------");
	}
	
	
	
	@Test(description ="Verify Invalid Login",priority=3)
	public void verify_Invalid_Login(){
		
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Testing the Invalid Login Scenario:"+ this.getClass());
		loginpage.dologin("amiteeeee@testing.com", "Amiuju$12");
		if( loginpage.ErrorMSG.isDisplayed() ){
			System.out.println("Invalid User ID Plese Verify Email id "+ loginpage.ErrorMSG.getText());
		}else{
			
			System.out.println("Login Sucessfull");
		}
		
		System.out.println("-------------------------------------------------------------------------------------");
	}
	
	
	@Test(description ="Empty Password",priority=4)
	public void verify_EmptyPassword_Login(){
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Testing the Invalid Login Scenario Empty Password:"+ this.getClass());
		loginpage.dologin("amiteeeee@testing.com", "");
		if( loginpage.ErrorMSG.isDisplayed() ){
			assertEquals("Password is required", loginpage.ErrorMSG.getText());
			System.out.println("Password is required. "+ loginpage.ErrorMSG.getText());
		}else{
			System.out.println("Login Sucessfull");
		}
		System.out.println("-------------------------------------------------------------------------------------");
		
	}
	
	@Test(description ="Empty User ID",priority=5)
	public void verify_EmptyUserID_Login(){
		
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Testing the Invalid Login Scenario Empty UserName:"+ this.getClass());
		loginpage.dologin("", "Amiuju$12");
		if( loginpage.ErrorMSG.isDisplayed() ){
			assertEquals("Email is required", loginpage.ErrorMSG.getText());
			System.out.println("Email is required"+ loginpage.ErrorMSG.getText());
		}else{
			System.out.println("Login Sucessfull");
		}
		System.out.println("-------------------------------------------------------------------------------------");
		
	}
	
	
	@Test(description ="Empty User ID & Password",priority=6)
	public void verify_EmptyUserID_Password_Login(){
		
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Testing the Invalid Login Scenario Empty UserName & Password:"+ this.getClass());
		loginpage.dologin("", "");
		if( loginpage.ErrorMSG.isDisplayed() ){
			assertEquals("Email is required", loginpage.ErrorMSG.getText());
			System.out.println("Password is required. "+ loginpage.ErrorMSG.getText());
		}else{
			System.out.println("Login Sucessfull");
		}
		System.out.println("-------------------------------------------------------------------------------------");
	}
	
	
	
	@Test(description ="Password Masking",priority=7)
	public void verify_PasswordField_Masking_Login(){
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Testing the Invalid Login Scenario Empty UserName & Password:"+ this.getClass());
		loginpage.dologin("amiteeeee@testing.com", "Amiuju$12");
		assertTrue(loginpage.PasswordMask());
		System.out.println("------------------------------------------------------------------------------------");
		
	}
	
	/*@Test(description ="LoginAuthentication",priority=8)
	public void verify_LoginAuthentication(){
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Testing the Invalid Login Scenario :"+ this.getClass());
		loginpage.dologin("amit@testing.com", "Amiuju$12");
	    if (loginpage.isUserLoggedIn()){
	    	loginpage.sign_Out.click();
	    	assertEquals("My Account – Automation Practice Site", driver.getTitle());
	    }
	              driver.navigate().back();
	              assertEquals("My Account – Automation Practice Site", driver.getTitle());
	        
		System.out.println("------------------------------------------------------------------------------------");
		
	}*/
	@AfterMethod
	public void teardown(){
		driver.quit();
		System.out.println("Closeing the Browser");
	}
}
