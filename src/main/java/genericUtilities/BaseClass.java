package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.ProductsPage;
import objectRepository.LoginPage;

/**
 * This class consists of Basic configuration annotations of TestNG
 * @author Sujata Beelur
 *
 */
public class BaseClass {
	
	public FileUtility fUtil = new FileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	
	public WebDriver driver;
	//for listener
	public static WebDriver sdriver;


	@BeforeSuite(groups = "RegressionSuite")
	public void bsConfig()
	{
		System.out.println("----- Database Connection successfull -----");
	}
	//@Parameters("Browser")
	
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String pValue */) throws IOException
	{
		String URL = fUtil.readDataFromPropertyFile("url");
		
		driver = new ChromeDriver();
		//crossbroser testing
		
//		if(pValue.equals("Chrome"))
//			
//		{
//			driver = new ChromeDriver();
//		}
//		else if(pValue.equals("edge"))
//		{
//		driver = new EdgeDriver();
//		}
//		else
//			
//		{
//			driver = new EdgeDriver();
//		
//		}
//		//for listener
		sdriver =driver;
		sUtil.maximizeWindow(driver);
		sUtil.AddimplicitelytWait(driver);
		
		driver.get(URL);
		
		System.out.println("----- Browser Launch successfull -----");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginApp(USERNAME, PASSWORD);
		
		System.out.println("----- Login to App successfull -----");
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void amConfig()
	{
		ProductsPage ip = new ProductsPage(driver);
		ip.logoutOfApp();
		
	}
	@AfterTest
	//@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("----- Browser closure successfull -----");
	}
	
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("----- Database Closure successfull -----");
	}
}
 

