package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.AllProductsPage;
import objectRepository.LoginPage;

/**
 * This class consists of basic configuration annotation of TestNG
 */
public class BaseClass 
{
	public WebDriver driver;
	
	/*Used for Listeners*/
	/*for taking screen shot in listener implementation we need driver reference so instead for extends we can create one more Static webdriver reference and use in listner implimenation */
	public static WebDriver sDriver;
	
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	
	@BeforeSuite(groups = {"Smoke","Regression"})
	public void bsConfig()
	{
		System.out.println("---------- Database Connection Successfull--------------");
	} 
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		/*This is for Cross browser Testing*/
		/*
		if(BROWSER.equalsIgnoreCase("Edge"))
		{
			driver =  new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}*/
		String 	URL = pUtil.readDataFromPropertyFile("Login_URl");
		driver = new ChromeDriver();
		
		sUtil.maximizeWindow(driver);
		sUtil.addImplicityWait(driver);
		
		driver.get(URL);
		System.out.println("---------- Launch Of Browser Successfull--------------");
		
		/*Used for Listeners*/
		/*intiatlizing the static webDriver refernce with the current webDriver*/
		sDriver = driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException 
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("---------- Login To Application Successfull--------------");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig()
	{
		AllProductsPage app = new AllProductsPage(driver);
		app.logoutOfApp();
		
		System.out.println("---------- Logout Of Application Successfull--------------");
	}
	
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("---------- Closure Of Browser Successfull--------------");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("---------- Database Closure Successfull--------------");
	}
}