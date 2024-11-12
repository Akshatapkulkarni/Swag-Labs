package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.AllProductsPage;
import objectRepository.ProductPage;
import objectRepository.YourCartPage;

public class AddMutiPleItemsToCartTest extends BaseClass
{
	@Test
	public void tc_002_AddMultipleItemsToCart() throws EncryptedDocumentException, IOException
	{
		//Read the data from excel
		String Product1 = eUtil.readDataFromExcel("Products", 1, 2);
		String Product2 = eUtil.readDataFromExcel("Products", 2, 2);
		String Product3 = eUtil.readDataFromExcel("Products", 3, 2);
		String Product4 = eUtil.readDataFromExcel("Products", 4, 2);

		//identify Products And add Products to cart

		AllProductsPage app = new AllProductsPage(driver);
		String ProductTitle1 = app.clickOnParticularProduct(driver, Product1);

		ProductPage pp = new ProductPage(driver);
		pp.clickOnAddToCart();

		String ProductTitle2 = app.clickOnParticularProduct(driver, Product2);
		pp.clickOnAddToCart();
		
		String ProductTitle3 = app.clickOnParticularProduct(driver, Product3);
		pp.clickOnAddToCart();
		
		String ProductTitle4 = app.clickOnParticularProduct(driver, Product4);
		pp.clickOnAddToCart();
		
		//Navigate to cart 
		pp.clickOnShoppingCartLink();
		
		//Capture the Product title in cart

		YourCartPage yp = new YourCartPage(driver);
		
	}
}
