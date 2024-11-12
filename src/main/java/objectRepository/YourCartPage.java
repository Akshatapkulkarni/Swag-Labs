package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {
	/**
	@FindBy(xpath = "//div[.='Sauce Labs Backpack']")
	private WebElement SauceLabsBackpackCart;
	
	@FindBy(xpath = "//div[.='Sauce Labs Bike Light']")
	private WebElement SauceLabsBikeLightCart;
	
	@FindBy(xpath = "//div[.='Sauce Labs Bolt T-Shirt']")
	private WebElement SauceLabsBoltTShirtCart;
	
	@FindBy(xpath = "//div[.='Sauce Labs Fleece Jacket']")
	private WebElement SauceLabsFleeceJacketCart;
	
	@FindBy(xpath= "//div[.='Sauce Labs Onesie']")
	private WebElement SauceLabsOnesieCart;
	
	@FindBy(xpath = "//div[.='Test.allTheThings() T-Shirt (Red)']")
	private WebElement TestallTheThingsTShirtRedCart;
	
	@FindBy(id ="remove-sauce-labs-bike-light")
	private WebElement removesaucelabsbikelightBtn;
	
	@FindBy(id ="remove-sauce-labs-backpack")
	private WebElement removesaucelabsbackpacktBtn;
	
	@FindBy(id ="remove-sauce-labs-bolt-t-shirt")
	private WebElement removesaucelabsboltshirtBtn;
	
	@FindBy(id ="remove-sauce-labs-fleece-jacket")
	private WebElement removesaucelabsfleecejacketBtn;
	
	@FindBy(id ="remove-sauce-labs-onesie")
	private WebElement removesaucelabsonesieBtn;
	
	@FindBy(id ="remove-test.allthethings()-t-shirt-(red)")
	private WebElement removestestallthethingstshirtredBtn;  **/
	
	//Declaration 
	
	@FindBy(className = "inventory_item_name")
	private WebElement ProductNameLink;
	
	@FindBy(id ="remove")
	private WebElement removeFromCartBtn;
	
	@FindBy(id = "checkout")
	private WebElement checkoutBtn;
	
	//Initialization 
	public YourCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	

	
	public WebElement getProductTitle() {
		return ProductNameLink;
	}

	public WebElement getRemoveFromCartBtn() {
		return removeFromCartBtn;
	}

	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}

	//Business Library 
	

	public void removeItemFromCart()
	{
		removeFromCartBtn.click();
	}
	
	public void clickOnCheckOutButton()
	{
		checkoutBtn.click();
	}
	
	public String ProductTitleInCart()
	{
		return ProductNameLink.getText();
	}
}
