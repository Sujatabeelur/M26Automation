package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AddProducttocart {
	
@Test
public void tc_001_AddProducttocart() throws IOException {
	//public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties p =new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		// Read Test data from Xl file
		FileInputStream fise = new FileInputStream("C:\\Users\\HI\\eclipse-workspace\\SeleniumWebdriverFramework\\src\\test\\resources\\TestData.xlsx");
		 Workbook wb = WorkbookFactory.create(fise);
		Sheet sh= wb.getSheet("Product");
		Row rw = sh.getRow(1);
		Cell cl = rw.getCell(2);
		String PRODUCTNAME = cl.getStringCellValue();
//		
//		
//		
//		
//		
//		String PRODUCTNAME = cl.getStringCellValue();

		
		 
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Step 2:  load the application

		driver.get(URL);
		// Step 3: login to application
		
		
		// Step 3 : Login to application

		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		
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
