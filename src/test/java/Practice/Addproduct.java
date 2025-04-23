package Practice;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.ProductsPage;

public class Addproduct extends BaseClass{
  @Test
  public void tc_001_AddProducttocart() throws IOException {
	//Read Test data from Excel file
			String PRODUCTNAME = fUtil.readDataFromExcel("product", 1, 2);
			ProductsPage pp = new ProductsPage(driver);
			String pAddedToCart = pp.clickOnProduct(driver, PRODUCTNAME);
			InventoryItemPage ii = new InventoryItemPage(driver);
			ii.clickonAddToCartButton();
			pp.clickcartContainerBtn();
			
			CartPage cp = new CartPage(driver);
			
		    String pInCart = cp.getProductName();
		    Assert.assertEquals(pInCart, pAddedToCart);
						  //  Assert.assertTrue(pInCart.equals(pAddedToCart));

		    
//		    if (pInCart.equals(pAddedToCart))
//		    {
//		    	System.out.println("pass");
//		    	System.out.println(pInCart);
//		    }
//		    	else
//		    	{
//		    		System.out.println("Fail");
//		    	
//		    }
			
			
			
		//step 8: Logout of App
		    
					

  }
}
