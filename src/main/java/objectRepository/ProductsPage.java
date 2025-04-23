package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class ProductsPage extends SeleniumUtility {
	
	//Declaration
		@FindBy(className="product_sort_container")
		private WebElement sortDropDown;
		
		@FindBy (id="react-burger-menu-btn")
		private WebElement menuButton;
		
		@FindBy (className="shopping_cart_badge")
		private WebElement cartContainerBtn;
		
		@FindBy (linkText="Logout")
		private WebElement logoutLnk;
		//initialization
		
		public ProductsPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			
		}
		
		//utilization


		public WebElement getSortDropDown() {
			return sortDropDown;
		}

		public WebElement getMenuButton() {
			return menuButton;
		}

		public WebElement getCartContainerBtn() {
			return cartContainerBtn;
		}

		public WebElement getLogoutLnk() {
			return logoutLnk;
		}
	
		//Business link
		/**
		 * This method will clickon a product and returnthedetails to caller
		 * @param driver
		 * @param productname
		 * @return
		 */
		
		public String clickOnProduct(WebDriver driver,String productname ) {
			
			WebElement ele = driver.findElement(By.xpath("//div[.='"+productname+"']"));
			String productdetails = ele.getText();
			ele.click();
			return productdetails;		
		}
		
		
		
		/**
		 * This method will click on lowest priced product and return the product to caller
		 * @param driver
		 * @param productname
		 * @param sortOption
		 * @return
		 */
		public String clickOnLowestPriceProduct(WebDriver driver,String productname,String sortOption) {
			
		handleDropDown(cartContainerBtn, sortOption);
		WebElement ele = driver.findElement(By.xpath("//div[.='"+productname+"']"));
		String productdetails = ele.getText();
		ele.click();
		return productdetails;
		
		}
		/**
		 * This method performs logout operation
		 */
		
		public void logoutOfApp()
		{
			menuButton.click();
			logoutLnk.click();
		}
		/**
		 * This method click on  cartContainerBtn
		 */
		
		public void clickcartContainerBtn()
		{
			cartContainerBtn.click();
		}
		
		public void clickondropdown(WebDriver driver,String sortOption)
		{
			handleDropDown(sortDropDown,sortOption);
		}
}
