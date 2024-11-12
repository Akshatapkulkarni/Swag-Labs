package genericUtilities;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * This class consists of Generic Methods related to selenium 
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;


public class SeleniumUtility 
{
	/**
	 * this method will maximize the window 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the winodw
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will add implicitly wait of 10 Seconds
	 */
	
	public void addImplicityWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method will wait for the particular element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will wait for particular element is clickable
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will handle  dropdown by INDEX
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element , int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * This method will handle dropdown by VisibleText
	 * @param element
	 * @param text
	 */
	public void handleDropDown(WebElement element, String text)
	{
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	
	/**
	 * This method will handle dropdown by Value
	 * @param value
	 * @param element
	 */
	public void handleDropDown(String value ,WebElement element)
	{
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	
	/**
	 * This method performs double click action
	 * @param driver
	 * @param btn
	 */
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	/**
	 * This method performs Click and hold action
	 * @param btn
	 * @param driver
	 */
	public void clickAndHoldAction(WebDriver driver,WebElement element)
	{
		Actions ac = new Actions(driver);
		ac.clickAndHold(element).perform();
	}
	
	/**
	 * This method will perform right click action
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver,WebElement element)
	{
		Actions ac = new Actions(driver);
		ac.contextClick(element).perform();
	}
	
	/**
	 * This method will perform mouse overing action
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver,WebElement element)
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform drag and drop Action on webelement
	 * @param driver
	 * @param source
	 * @param destiny
	 */
	public void dragAndDropAction(WebDriver driver,WebElement source,WebElement destiny)
	{
		Actions ac = new Actions(driver);
		ac.dragAndDrop(source, destiny).perform();
	}
	
	
	/**
	 * This method performs Scroll to particular Element 
	 * @param driver
	 * @param element
	 */
	
	public void scorllToElementAction(WebDriver driver,WebElement element)
	{
		Actions ac = new Actions(driver);
		ac.scrollToElement(element).perform();
		
	}
	
	/**
	 * This method will randomly scroll the page up by 500 units 
	 * @param driver
	 */
	public void scrollUpAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500);", "");
	}

	/**
	 * This method will randomly scroll the page down by 500 units
	 * @param driver
	 */
	public void scrollDownAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);", "");
	}
	/**
	 * This method will scroll to element using javascript executor it is similar to scrollToElemenet
	 * @param driver
	 * @param element
	 */
	
	public void scrollIntoView(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	/**
	 * This method will handle frame by index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle frame by element
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will handle frame by idOrName
	 * @param driver
	 * @param idOrName
	 */
	public void handleFrame(WebDriver driver , String idOrName)
	{
		driver.switchTo().frame(idOrName);
	}
	
	/**
	 * This method will navigate to immediate parent
	 * @param driver
	 */
	public void switchtoParent(WebDriver driver)
	{
		driver.switchTo().parentFrame();
		
	}
	
	/**
	 * This method will navigate to main page
	 * @param driver
	 */
	public void switchtoMainPAge(WebDriver driver)
	{
		driver.switchTo().defaultContent();
		
	}
	
	/**
	 * This method will take screenshot and return the path
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	
	public String captureScreenShot(WebDriver driver , String screenShotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshot\\"+screenShotName+".png");
		Files.copy(src, dst);
		
		return dst.getAbsolutePath(); //Extent reports
	}
	
}

