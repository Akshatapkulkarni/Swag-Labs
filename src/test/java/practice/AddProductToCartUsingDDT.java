package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddProductToCartUsingDDT
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		//read the data
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String URL = p.getProperty("Login_URl");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		//read Test Data from excel file
		
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\Test_Data.xlsx");
		Workbook wb = WorkbookFactory.create(fisp);
		Sheet sh =wb.getSheet("Products");
	    Row	rw = sh.getRow(1);
	    Cell cl = rw.getCell(2);
	    String PRODUCTNAME = cl.getStringCellValue();
		
	    //Step 1:Launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Step 2: Load the url
		
		driver.get(URL);
		
		//Step 3 : Login to the application
		
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		
		
		//Step 4:Identify the product
		 Thread.sleep(1000);
		 /*The below line is an example for dynamic xpath*/
		 driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();
		 String ProductTitle = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).getText();
		 
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
