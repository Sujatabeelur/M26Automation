package Practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.LoginPage;
import objectRepository.ProductsPage;

public class InventoryPage extends SeleniumUtility{


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileUtility fUtil = new FileUtility();
		JavaUtility jUtil = new JavaUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		// read common data from Property file
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		//Read Test data from Excel file
		String PRODUCTNAME = fUtil.readDataFromExcel("product", 1, 2);
		
		//Launch the browser
		WebDriver driver = new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.AddimplicitelytWait(driver);
		
		// Step 2 : Load the application

		driver.get(URL);
		
		// Step 3 : Login to application
		LoginPage lp = new LoginPage(driver);
		lp.loginApp(USERNAME, PASSWORD);
		
		
		// Step 4 : Click on product
		
		ProductsPage pp = new ProductsPage(driver);
		String pAddedToCart = pp.clickOnProduct(driver, PRODUCTNAME);
		
		// step 5 : Add the product to cart
		
		InventoryItemPage iip = new InventoryItemPage(driver);
		
		iip.clickonAddToCartButton();
		
		pp.clickcartContainerBtn();
		
		// Step 7 : validate cart container
		
		CartPage cp = new CartPage(driver);
	    String pInCart = cp.getProductName();
	    Assert.assertEquals(pInCart, pAddedToCart);
	  //  Assert.assertTrue(pInCart.equals(pAddedToCart));
	    
//	    if (pInCart.equals(pAddedToCart))
//	    {
//	    	System.out.println("pass");
//	    	System.out.println(pInCart);
//	    }
//	    	else
//	    	{
//	    		System.out.println("Fail");
//	    	
//	    }
//		
		
		
	//step 8: Logout of App
	    
	    pp.logoutOfApp();
				
		
	}

}
