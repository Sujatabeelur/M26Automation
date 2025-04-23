package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage {
	@FindBy(xpath="//div[@data-test=\"inventory-item-price\"]")
	private WebElement priceElement;
	
	@FindBy (id="add-to-cart")
	private WebElement addtocartButton;
	
	@FindBy (xpath="//button[.=\"Remove\"]")
	private WebElement removeButton;
	
	public InventoryItemPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getPriceElement() {
		return priceElement;
	}

	public WebElement getAddtocartButton() {
		return addtocartButton;
	}
	
	public WebElement getRemoveButton() {
		return removeButton;
	}

	/*
	 * this method click on the Add to Cart Button
	 */

	

	public void clickonAddToCartButton() {
		addtocartButton.click();
		
	}
	/**
	 * This Method click on remove button
	 */
	
	public void clickOnRemoveButton()
	{
		removeButton.click();
	}
}
