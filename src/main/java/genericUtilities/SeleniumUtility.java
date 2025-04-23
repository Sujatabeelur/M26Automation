package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/***
 * This class consists of generic  related to Selenium tool
 * @author Sujata Beelur
 */

public class SeleniumUtility {

	

	/**
	 * This method will maximize the window
	 * @param driver
	 */
	
	public void maximizeWindow(WebDriver driver) {
    driver.manage().window().maximize();		
		
	}
	
	/**
	 * This mehod will minimize the window
	 * @param driver
	 */
		
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * This method will add the implicit wait to the code
	 * @param driver
	 */
	
	public void AddimplicitelytWait(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait for particular to be visible
	 * @param driver
	 * @param element
	 */
	
	public void waitForWebElementToBeVisible(WebDriver driver ,WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	/**
	 * This method will wait for particular to be clickable.
	 * @param driver
	 * @param element
	 */
	
	public void waitForWebElementToBeClickable(WebDriver driver, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	/**
	 * This method will handle DropDown by VisibleText 
	 * @param element
	 * @param VisibleText
	 */
	
	public void handleDropDown(WebElement element, String VisibleText) {
		Select s = new Select(element);
		s.selectByVisibleText(VisibleText);
	}
	/**
	 * This method will handle DropDown by Value
	 * @param value
	 * @param element
	 */
	public void handleDropDown(String value,WebElement element) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method will handle DropDown by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index ) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method will perform mouse hover action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	/**
	 * This method will perform right click action
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	/**
	 * This Method will perform double click action
	 * @param driver
	 * @param element
	 */
	
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
		
	}
	public void dragAndDropAction(WebDriver driver, WebElement srceloc, WebElement destloc)
	{
		Actions a = new Actions(driver);
		a.dragAndDrop(srceloc, destloc).perform();
	}
	
	public void handleFrameByIndex(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void handleFrameByNameorId(WebDriver driver,String NameorId)
	{
		driver.switchTo().frame(NameorId);
	}
	/**
	 * This method handles the frame by we
	 * @param driver
	 * @param element
	 */
	public void handleFrameByWebelement(WebDriver driver,WebElement element )
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method switch the control back to immediate parent frame
	 * @param driver
	 */
	
	public void switchtoParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * This method will switch back to main frame ignoring all the parent frame
	 * @param driver
	 */
	public void switchtoMainFrame(WebDriver driver )
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This Method handles the window based on the window id
	 * @param driver
	 * @param windowHandle
	 */
	public void switctoWindow(WebDriver driver, String windowHandle)
	{
		driver.switchTo().window(windowHandle);
	}
	
	public void handleAlretAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void handleAlretDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This Method will capture the alert text and return to the caller
	 * @param driver
	 */
	public void getAlertText(WebDriver driver)
	{
		driver.switchTo().alert().getText();
	}
	/**
	 * This method will enter data into alert popup
	 * @param driver
	 * @param Alertdata
	 */
	public void getAlertText(WebDriver driver, String Alertdata)
	{
		driver.switchTo().alert().sendKeys(Alertdata);
	}
	
	public void scriptExcuterscrollup(WebDriver driver)
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
	
	}
	/**
	 * This method will capture the screen shot and return the path to caller
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver, String screenShotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\"+screenShotName+".png"); //tsname_date_time
		FileHandler.copy(src, dst);
		return dst.getAbsolutePath();
		
		
	}
	
	
		
}
