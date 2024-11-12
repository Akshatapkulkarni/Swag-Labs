package products;

import org.testng.annotations.Test;

import genericUtilities.BaseClass;

public class RemoveProductTest extends BaseClass
{
	@Test(groups = "Regression")
	public void tc_001_RemoveProduct()
	{
		System.out.println("Removed product successfully");
	}
	
}
