package coma.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestUtill.WaitTool;
import com.qa.testbase.TestBase;

public class LoginPage extends TestBase{

	
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement Username;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement Password;
	
	@FindBy(xpath = "//button[@type='button'][contains(.,'Login')]")
	WebElement Login;
	
	@FindBy(xpath = "//a[@class='button text'][contains(.,'I Forgot My Password')]")
	WebElement ForgoPassword;
	
	@FindBy(xpath = "//div[@class='heading main'][contains(.,'Login')]")
	WebElement Login_Lable;
	
	@FindBy(xpath = "//label[@class='error-msg']")
	public WebElement ErrorMSG;
	
	@FindBy(xpath = "//button[@class='secondary']")
	WebElement Create_My_Account;
	
	/*@FindBy(xpath="//ul[@class='woocommerce-error']//li[contains(.,'Error: A user could not be found with this email address.')]")
	public WebElement Errormsg_Invaliduser;*/
	
	//@FindBy(xpath = "//li[contains(.,'Error: Password is required.')]")
	
	/*@FindBy(xpath="//ul[@class='woocommerce-error']//li")
	public WebElement EmptyPassowrdMSG;*/
	
	
	@FindBy(xpath="//a[contains(text(),'Sign out')]")
	public WebElement sign_Out;
	
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	
  
	public boolean 	verifyLoginPage_UIComponents(){
		
		if(Login.isDisplayed()&& Login_Lable.isDisplayed() && Create_My_Account.isDisplayed())
		{
			return true;
		  }else
			return false;
	}
	
	
	
	public boolean  PasswordMask(){
		
		if (Password.getAttribute("type").equals("password")){
			
			return true;
		}else {
			
			System.out.println("Password Field Not Masking");
		}
           return false;
	}
	
	public boolean isUserLoggedIn()
	{			
	 	if ( WaitTool.waitForElementPresent(sign_Out, 5) )
	 	{		 	
	 		return true;
	 	}
	 	else
	 	{		 		
	 		return false;
	 	}
	}
	
	
	
	 /*public LoginPage doSignOut()
	 {
		 if (isUserLoggedIn())
		 {
			 sign_Out.click();
			LoginPage signInPage = new LoginPage();
			return signInPage;
		 }
		 else
		 {
			 System.out.println("Nobody is singed in so cannot signOut");
			 return null;
		 }
	 }*/
	
	

	
	public MyAccount dologin(String name,String password){
		
		Username.sendKeys(name);
		Password.sendKeys(password);
		Login.click();
	   return  new MyAccount();
		
	}
	
	
}
