package products;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.AllProductsPage;
import objectRepository.ProductPage;
import objectRepository.YourCartPage;
public class AddMultipleProductsToCartTest extends BaseClass
{


	/*Test Class*/

	@Test/*Test method or Test Script*/

	public void tc_002_AddMultipleProductToCartTest() throws IOException
	{

		//Read the data from excel
		String Product1 = eUtil.readDataFromExcel("Products", 1, 2);
		

		//identify Products And add Products to cart

		AllProductsPage app = new AllProductsPage(driver);
		String ProductTitle = app.clickOnParticularProduct(driver, Product1);
		
		ProductPage pp = new ProductPage(driver);
		pp.clickOnAddToCart();


	}
}


