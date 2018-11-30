package com.qa.testbase;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.qa.TestUtill.TestUtill;
import com.qa.TestUtill.WebEventListener;




public class TestBase {
	public static Properties prjprop;
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static Logger log = Logger.getLogger(TestBase.class);

	public TestBase(){
		String filepath= System.getProperty("user.dir")+"/src/main/resource/project.properties";
		System.out.println(filepath);
		
	//	File projprop = new File(System.getProperty("D:\\HMS\\Testing_Automation_Project\\src\\main\\resource\\project.properties") );
	//	System.out.println("Project Properties Path: " + projprop);
		try 
		{

			FileInputStream fis = new FileInputStream(filepath);
			prjprop = new Properties();
			prjprop.load(fis);

		} catch (Exception e) {
			System.out.println("Exception is ======" + e.getMessage());
		}

	}
	

		public static void intialization(){
			
				String brwoserName= prjprop.getProperty("brwoser");
				if (brwoserName.equals("chrome")){
					
					//WebDriverManager.chromedriver().setup();
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/driver/chromedriver.exe");
					//WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				}else if (brwoserName.equals("FF")){
					//WebDriverManager.firefoxdriver().setup();
					System.setProperty("webdriver.gecko.driver","D:\\Amol_BkUp\\NewProject\\Mavan\\geckodriver.exe");
					driver = new FirefoxDriver();
				}
				
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(TestUtill.PAGE_LOAD_TIMEOUT_, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(TestUtill.IMPLICIT_WAIT, TimeUnit.SECONDS);
				
				
				e_driver = new EventFiringWebDriver(driver);
				// Now create object of EventListerHandler to register it with
				// EventFiringWebDriver
				eventListener = new WebEventListener();
				e_driver.register(eventListener);
				driver = e_driver;
				driver.get(prjprop.getProperty("url"));
				

				
			}


		


				
		
	




	}
	

