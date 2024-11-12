package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllProductsPage {//Rule 1: Create a separate POM class for webpage
	
	//Rule 2:Identify all the web elements using annotation
	
	//This can be done but if want to identify the more items its difficult by this way thats the reason we go for business library and in @FindBy we can't have dynamic xpath
	/**
	@FindBy(xpath = "//div[.='Sauce Labs Backpack']")
	private WebElement SauceLabsBackpack;
	
	@FindBy(xpath = "//div[.='Sauce Labs Bike Light']")
	private WebElement SauceLabsBikeLight;
	
	@FindBy(xpath = "//div[.='Sauce Labs Bolt T-Shirt']")
	private WebElement SauceLabsBoltTShirt;
	
	@FindBy(xpath = "//div[.='Sauce Labs Fleece Jacket']")
	private WebElement SauceLabsFleeceJacket;
	
	@FindBy(xpath= "//div[.='Sauce Labs Onesie']")
	private WebElement SauceLabsOnesie;
	
	@FindBy(xpath = "//div[.='Test.allTheThings() T-Shirt (Red)']")
	private WebElement TestallTheThingsTShirtRed;  **/ 
	
	@FindBy (id = "react-burger-menu-btn")
	private WebElement menuBtn;
	
	@FindBy (id = "logout_sidebar_link")
	private WebElement logoutLink;
	
	//Rule 3: Create a construct and initialize the web elements
	
	public AllProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4: Provide getters to access the web elements 
	

	public WebElement getMenuBtn() {
		return menuBtn;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	//Business Library -operation
	/**
	 * This method will click on menu button
	 */
	public void clickOnMenuBtn()
	{
		menuBtn.click();
	}
	
	/**
	 * This method will click on menu button and perform logout operation
	 */
	public void logoutOfApp()
	{
		menuBtn.click();
		logoutLink.click();
	}
	
	/**
	 * This method will click on particular product and return the product title to the caller
	 * @param driver
	 * @param PRODUCTNAME
	 * @return
	 */
	public String clickOnParticularProduct(WebDriver driver,String PRODUCTNAME)
	{
		String productTitle = driver.findElement(By.xpath("//div[.='" + PRODUCTNAME + "']")).getText();
		driver.findElement(By.xpath("//div[.='" + PRODUCTNAME + "']")).click();
		
		return productTitle; //For validation
	}
}
