package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;

public class RemoveTheProductFromCart
{
	public static void main(String[] args) throws IOException 
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
				
				//Step 1:Launch the browser
				WebDriver driver = new ChromeDriver();
				
				sUtil.maximizeWindow(driver); //Using selenium utilities
				sUtil.addImplicityWait(driver);
				
				//Step 2: Load the url
				
				driver.get(LOGIN_URL);
				
				//Step 3:Login to the application
				
				driver.findElement(By.id("user-name")).sendKeys(USERNAME);
				driver.findElement(By.id("password")).sendKeys(PASSWORD);
				driver.findElement(By.id("login-button")).click();
				
				//Step 4:Click on Cart and open
				
				driver.findElement(By.className("shopping_cart_badge")).click();
				
				//Step 5: Identify the product 
				
				driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).click();
				String ProductRemoved = driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).getText();
				
				//Step 6: Remove the product from cart
				
				driver.findElement(By.id("remove")).click();
				
				//Step 7: Go back to cart and validate Product is removed or not
				
				driver.findElement(By.className("shopping_cart_badge")).click();
				
	}
}
