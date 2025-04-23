package Practice;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;


public class AddProductToCartUsingDDTandGUI {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Create object of all theutiliteis
		FileUtility fUtil=new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		JavaUtility jUtil = new JavaUtility();
		
		//Read common data from Property file
	String URL = fUtil.readDataFromPropertyFile("url");
	String USERNAME = fUtil.readDataFromPropertyFile("username");
	String PASSWORD = fUtil.readDataFromPropertyFile("password");
	
	// Read Test data from Excel file 
	String PRODUCTNAME = fUtil.readDataFromExcel("Product", 1, 2);
		
				
				 
				// TODO Auto-generated method stub
				WebDriver driver = new ChromeDriver();
				sUtil.maximizeWindow(driver);
				// Step 2:  load the application
				sUtil.AddimplicitelytWait(driver);
				driver.get(URL);
				LoginPage loginPage = new LoginPage(driver);
				loginPage.getUsernameEdit().sendKeys(USERNAME);
				loginPage.getPasswordEdit().sendKeys(PASSWORD);
				loginPage.getLoginButton().click();
				
				
				// Step 3: login to application
				
				
				// Step 3 : Login to application

//				driver.findElement(By.id("user-name")).sendKeys(USERNAME);
//				driver.findElement(By.id("password")).sendKeys(PASSWORD);
//				driver.findElement(By.id("login-button")).click();
//			

				//Step 4 : Click on product -Sauce Labs Bolt T-Shirt
				WebElement product = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
				String productaddedtocart =product.getText();
				product.click();
				// Step 5 : Add a product to cart
				driver.findElement(By.id("add-to-cart")).click();

				//driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
				//driver.findElement(By.xpath("//button[@name=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")).click();
				// Step -6 : Navigate to cart
				driver.findElement(By.xpath("//a[@data-test=\"shopping-cart-link\"]")).click();
				
				// Step 7 : Validate the product
				WebElement proval= driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
				
				String pval=proval.getText();
				
				String screenShotName = "TC_OO1";
				sUtil.captureScreenShot(driver, screenShotName);
				
				
				if (pval.equals(productaddedtocart)) {
					System.out.println("Pass");
					System.out.println(productaddedtocart);
					
				}
				else {
					System.out.println("Fail");
					System.out.println(productaddedtocart);
				}
				
				// Step 8 : Click on Checkout
				driver.findElement(By.id("checkout")).click();
				
				// Step 9 : Click on Menu
				driver.findElement(By.id("react-burger-menu-btn")).click();
				// step 10 : click on logout Button
				driver.findElement(By.id("logout_sidebar_link")).click();
				

	}

}
