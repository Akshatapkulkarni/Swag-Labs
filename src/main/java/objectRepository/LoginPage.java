package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //Rule 1:Create a separate pom class for webpage
	
	//Rule 2: Identify all the web elements using annotation
	
	@FindBy(id = "user-name") 
	private WebElement usernameEdt;// since its a text field we give variable name as EDT
	
	@FindBy(id = "password") private WebElement passwordEdt;

	@FindBy(id = "login-button")
	private WebElement loginBtn;
	
	//Rule 3: Create a constructor and initialize the web elements
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this); //This statement will initialize all the web elements with the driver reference  
	}
	
	//Rule 4: Provide getters tp access the web elements
	
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//business library - operation
	/**
	 * This method will perform login operation 
	 * @param USERNAME
	 * @param PASSWORD
	 */
	
	public void loginToApp(String USERNAME,String PASSWORD)
	{
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}

}
