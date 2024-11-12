package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class AddProductToCartUsingDDTandGU
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		//Creating objects of utility files
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		//Read the common data from property file
		String LOGIN_URL= pUtil.readDataFromPropertyFile("Login_URl");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		//Read THe TestData from Excel file
		
		String PRODUCTNAME = eUtil.readDataFromExcel("Products", 1, 2);
		
		//Step 1:LAunch the browser
		WebDriver driver = new ChromeDriver();
		
		sUtil.maximizeWindow(driver); //Using selenium utilities
		sUtil.addImplicityWait(driver);
		
		//Step 2: Load the url
		
		driver.get(LOGIN_URL);
		
		//Step 3:Login to the application
		
//		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
//		driver.findElement(By.id("password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("login-button")).click();
		
		LoginPage lp = new LoginPage(driver);
		lp.getUsernameEdt().sendKeys(USERNAME);
		lp.getPasswordEdt().sendKeys(PASSWORD);
		lp.getLoginBtn().click();
		
		//Step 4: Identify the Product
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).click();
		String PRODUCT_TITTLE = driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).getText();
		
		//Step 5:Add to Cart
		
		driver.findElement(By.id("add-to-cart")).click();
		
		//Step 6:Navigate to cart and Validate product
		 driver.findElement(By.className("shopping_cart_link")).click();
		String ProductTitleInCart = driver.findElement(By.className("inventory_item_name")).getText();
		if(ProductTitleInCart.equals(PRODUCT_TITTLE))
		{
			System.out.println("Product successfully added to cart");
			 System.out.println("Pass");
			 System.out.println(ProductTitleInCart);
		}
		else
		{
			System.out.println("Product not added to the cart =>Fail");
		}
		

		 //Step 7: logout
		 
		 driver.findElement(By.id("react-burger-menu-btn")).click();
		 driver.findElement(By.id("logout_sidebar_link")).click();
		 
		 System.out.println("Successfully logged out");
		
	}
}
