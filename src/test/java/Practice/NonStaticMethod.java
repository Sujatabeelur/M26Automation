package Practice;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NonStaticMethod {
@Test
	
	public void Sample()
	{
	 SoftAssert sa= new SoftAssert();
		System.out.println("Step1");
		System.out.println("Step2");
		sa.assertEquals(1, 0);
		System.out.println("Step 4");
		System.out.println("Stepn 5");
		sa.assertAll();
		
	}
	
}
