package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddProductToCartAndValidate 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//Step 1: Launch the browser
		 WebDriver driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		 //Step 2: Load the URL
		 
		 driver.get("https://www.saucedemo.com/");
		 
		 //Step 3:Login to the application
		 
		 driver.findElement(By.id("user-name")).sendKeys("standard_user");
		 driver.findElement(By.id("password")).sendKeys("secret_sauce");
		 driver.findElement(By.id("login-button")).click();
		
		 //Step 4:Identify the product
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//div[.='Sauce Labs Backpack']")).click();
		 String ProductTitle = driver.findElement(By.xpath("//div[.='Sauce Labs Backpack']")).getText();
		 
		 //Step 5: Add product to cart
		 
		 driver.findElement(By.id("add-to-cart")).click();
		 
		 //Step 6:Navigate to cart and Validate product
		 
		 driver.findElement(By.className("shopping_cart_link")).click();
		 String ProductTitleInCart = driver.findElement(By.className("inventory_item_name")).getText();
		 if(ProductTitle.equalsIgnoreCase(ProductTitleInCart))
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
