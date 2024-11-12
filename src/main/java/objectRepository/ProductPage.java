package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {//Rule 1: create a separate pom class for webpage
	
	//Rule 2: Identify all the Web Elements using annotations
	
	@FindBy(id = "add-to-cart")
	private WebElement AddToCart;
	
	@FindBy(className = "shopping_cart_link")
	private WebElement shoppingcartBtn;
	
	@FindBy(id ="back-to-products")
	private WebElement backtoproducts;
	
	//Rule 3: Create a constructor and initialize the web elements
	
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule 4: Provide getters to access the web Elements
	
	public WebElement getAddToCart() {
		return AddToCart;
	}

	public WebElement getShoppingcartBtn() {
		return shoppingcartBtn;
	}

	public WebElement getBacktoproducts() {
		
		return backtoproducts;
	}

	//Business Library -Operation
	
	/**
	 * This method will add the product to cart
	 */
	public void clickOnAddToCart()
	{
		AddToCart.click();
	}
	
	/**
	 * This method will click on cart icon
	 */
	public void clickOnShoppingCartLink()
	{
		shoppingcartBtn.click();
	}
	
	public void clickOnBackToProductsBtn()
	{
		backtoproducts.click();
	}
}
