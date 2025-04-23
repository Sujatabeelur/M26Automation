package Practice;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.ProductsPage;

@Listeners(genericUtilities.ListenersImplementation.class)


public class AddLowestProductToCart extends BaseClass{
	@Test
	public void tc_001_AddProducttocart() throws IOException {
		
		String PRODUCTNAME = fUtil.readDataFromExcel("product", 4, 3);
		String SORTOPTION = fUtil.readDataFromExcel("product", 4, 2);
		
		

		ProductsPage pp = new ProductsPage(driver);
	//	pp.clickOnLowestPriceProduct(driver, PRODUCTNAME, SORTOPTION);
		pp.clickondropdown(driver, SORTOPTION);
		
		String pAddedToCart = pp.clickOnProduct(driver, PRODUCTNAME);
		InventoryItemPage ii = new InventoryItemPage(driver);
		ii.clickonAddToCartButton();
		pp.clickcartContainerBtn();
		
		CartPage cp = new CartPage(driver);
		
	    String pInCart = cp.getProductName();
	    Assert.assertEquals(pInCart, pAddedToCart);
		
		
		
		

		 
	

	
	
		
	}

}
