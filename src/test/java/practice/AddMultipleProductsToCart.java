package practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.AllProductsPage;
import objectRepository.LoginPage;
import objectRepository.ProductPage;
import objectRepository.YourCartPage;

public class AddMultipleProductsToCart 
{
	public static void main(String[] args) throws IOException 
	{
		//creating objects for Utility files
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		//Read the common data from PropertyFile
		String LOGIN_URL = pUtil.readDataFromPropertyFile("Login_URl");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD =pUtil.readDataFromPropertyFile("password");
		
		//Read the TestData from ExcelFile
		
		String PRODUCTNAME1 = eUtil.readDataFromExcel("Products", 1, 2);
		String PRODUCTNAME2 = eUtil.readDataFromExcel("Products", 2, 2);
		String PRODUCTNAME3 = eUtil.readDataFromExcel("Products", 3, 2);
		String PRODUCTNAME4 = eUtil.readDataFromExcel("Products", 4, 2);
		
		//Step 1: Launch the Browser
		
		WebDriver driver = new ChromeDriver();
		
		sUtil.maximizeWindow(driver);
		sUtil.addImplicityWait(driver);
		
		//Step 2 : Load the url
		
		driver.get(LOGIN_URL);
		
		//Step 3: Login to the application
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//Step 4: Identify the Products and add to cart
		
		AllProductsPage app = new AllProductsPage(driver);
		ProductPage pp = new ProductPage(driver);
		String ProductTitle1 = app.clickOnParticularProduct(driver, PRODUCTNAME1);
		pp.clickOnAddToCart();
		pp.clickOnBackToProductsBtn();
		String ProductTitle2 = app.clickOnParticularProduct(driver, PRODUCTNAME2);
		pp.clickOnAddToCart();
		pp.clickOnBackToProductsBtn();
		String ProductTitle3 = app.clickOnParticularProduct(driver, PRODUCTNAME3);
		pp.clickOnAddToCart();
		pp.clickOnBackToProductsBtn();
		String ProductTitle4 = app.clickOnParticularProduct(driver, PRODUCTNAME4);
		pp.clickOnAddToCart();
		
		//Step 5: Validate Products 
		
		pp.clickOnShoppingCartLink();
		YourCartPage yp = new YourCartPage(driver);
		String ProductTitleCart = yp.ProductTitleInCart();
		System.out.println(ProductTitleCart);
	}
}
