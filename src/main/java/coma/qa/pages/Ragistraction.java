package coma.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.TestBase;

public class Ragistraction  extends TestBase{
	
	@FindBy(xpath = "//input[@id='reg_email']")
	WebElement RegEnail;
	
	@FindBy(xpath = "//input[@id='reg_password']")
	WebElement PasswordField;
	
	@FindBy (xpath ="//input[@value='Register']")
	WebElement RegistarButton;
	
	
	@FindBy (xpath =" //ul[@class='woocommerce-error']//li")
	public WebElement InvalidEmail;
	
	@FindBy(xpath = "//ul[@class='woocommerce-error']")
	public WebElement EmaptyEmailid;
	
	@FindBy(xpath = "//h2[contains(.,'Register')]")
	WebElement Register_Lable;
	
    public Ragistraction(){
		
		PageFactory.initElements(driver, this);
	}
    
    
    public boolean verifyRegistraction_UIComponents(){
    	
    	if(Register_Lable.isDisplayed() && RegistarButton.isDisplayed()){
    		return true;
    	}
    	return false;
    }
    
    
    public MyAccount  Registartion(String name, String password) throws InterruptedException
    {
    	
    	RegEnail.sendKeys(name);
    	PasswordField.clear();
    	PasswordField.sendKeys(password);
    	Actions action = new Actions(driver);
    	action.moveToElement(RegistarButton).click();
    //	RegistarButton.click();
    	
    	
    	return new  MyAccount();
    	
    }
    
    

}
