package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	@FindBy(className="inventory_item_name")
	private WebElement iteminfo;

	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public WebElement getProductname() {
		return iteminfo;
	}

	
	public String  getProductName()
	{
		return iteminfo.getText();
		
	}
	
	
	
}