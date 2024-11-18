package products;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.AllProductsPage;
import objectRepository.ProductPage;
import objectRepository.YourCartPage;

@Listeners(genericUtilities.ListenersImplementation.class) //annotation provided by TestNg bring Listners implementation to testScript
/*Test Class*/
public class AddProductToCartTest extends BaseClass
{
	@Test(groups = "Smoke") /*Test method or Test Script*/
	
		public void tc_001_AddSingleProductToCartTest() throws IOException, InterruptedException
		{
		
		//Creating objects for utility files 

		//Read the common data from PropertyFile
		
		
		//Read the Test data from excel File
		
		String PRODUCTNAME = eUtil.readDataFromExcel("Products", 1, 2);
		
		//Step 1: Launch the browser
		
		
		//Step 2: Load the url
		
		
		//Step 3:Login to the application
		
		
		//Step 4: Identify the Product
		Thread.sleep(1000);		
		AllProductsPage app = new AllProductsPage(driver);
		String ProductTitle = app.clickOnParticularProduct(driver, PRODUCTNAME);
		System.out.println(ProductTitle);
		//Step 5: Add Product to cart
		
		ProductPage pp = new ProductPage(driver);
		pp.clickOnAddToCart();
		
		// Step 6: Navigate to cart 
		pp.clickOnShoppingCartLink();
		
		//Assert.fail();
		
		//Step 7: Capture product details in Cart 
		Thread.sleep(1000);
		YourCartPage cp = new YourCartPage(driver);
		String ProductTitleInCart = cp.ProductTitleInCart();
		
		//Step 8: Validate for product name
		Assert.assertEquals(ProductTitleInCart, ProductTitle);
		
		
		
		
	}
}
